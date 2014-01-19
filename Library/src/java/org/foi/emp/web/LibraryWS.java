package org.foi.emp.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import org.foi.emp.model.Book;
import org.foi.emp.model.Loan;
import org.foi.emp.model.Member;

/**
 * Web service for the library. Gets, updates and deletes the information about
 * our database.
 *
 * @author Bandić, Rajčević, Tomala
 */
@WebService(serviceName = "LibraryWS")
@Stateless()
public class LibraryWS {

    private String username = "root";
    private String pass = "rootpass";
    private String url = "jdbc:derby://localhost:1527/Library";

    /**
     * Web service operation which gets all the members from our library
     *
     * @return list of Member objects for every entry
     */
    @WebMethod(operationName = "getMembers")
    public java.util.List<Member> getMembers() {

        List<Member> members = new ArrayList<Member>();

        String query = "SELECT * FROM members";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            ResultSet rs = instruction.executeQuery(query);

            while (rs.next()) {
                Member m = new Member(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"));
                members.add(m);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    /**
     * Web service operation which gets all the books from our library
     *
     * @return list of Book objects for every entry
     */
    @WebMethod(operationName = "getBooks")
    public java.util.List<Book> getBooks() {

        List<Book> books = new ArrayList<Book>();

        String query = "SELECT * FROM books";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            ResultSet rs = instruction.executeQuery(query);

            while (rs.next()) {
                Book b = new Book(rs.getLong("isbn"), rs.getString("title"), rs.getString("author"), rs.getBoolean("available"));
                books.add(b);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    /**
     * Web service operation which gets all the loan relations from our library
     *
     * @return list of Loan objects for every entry
     */
    @WebMethod(operationName = "getLoan")
    public java.util.List<Loan> getLoan() {

        List<Loan> loans = new ArrayList<Loan>();

        String query = "SELECT * FROM loan";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            ResultSet rs = instruction.executeQuery(query);

            while (rs.next()) {
                String s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(rs.getTimestamp("loandate"));
                Loan l = new Loan(rs.getLong("isbn"), rs.getInt("id"), s);
                loans.add(l);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loans;
    }

    /**
     * Web service operation which inserts a new entry in the table members
     *
     * @param id to set for the new entry
     * @param fn to set for the new entry
     * @param ln to set for the new entry
     * @param email to set for the new entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "addMember")
    public boolean addMember(int id, String fn, String ln, String email) {

        String query = "INSERT into members values(" + id + ", '" + fn
                + "', '" + ln + "', '" + email + "')";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which inserts a new entry in the table books
     *
     * @param isbn to set for the new entry
     * @param title to set for the new entry
     * @param author to set for the new entry
     * @param available to set for the new entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "addBook")
    public boolean addBook(long isbn, String title, String author, boolean available) {

        String query = "INSERT into books values(" + isbn + ", '" + title
                + "', '" + author + "', " + available + ")";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which inserts a new entry in the table loan
     *
     * @param isbn to set for the new entry
     * @param id to set for the new entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "addLoan")
    public boolean addLoan(long isbn, int id) {

        String query = "INSERT into loan values(" + isbn + ", " + id
                + ", DEFAULT )";
        String query2 = "UPDATE books SET available=false WHERE isbn=" + isbn;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            boolean rs2 = instruction.execute(query2);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which updates an entry in the table members
     *
     * @param id of the entry
     * @param fn first name of the entry (member)
     * @param ln last name of the entry (member)
     * @param email email of the entry (member)
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "editMember")
    public boolean editMember(int id, String fn, String ln, String email) {

        String query = "UPDATE members SET firstname='" + fn + "', lastname='" + ln + "', email='"
                + email + "' WHERE id=" + id;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which updates an entry in the table books
     *
     * @param isbn of the entry
     * @param title of the book
     * @param author of the book
     * @param available if the book is available for loan
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "editBook")
    public boolean editBook(long isbn, String title, String author, boolean available) {

        String query = "UPDATE books SET title='" + title + "', author='" + author + "', available="
                + available + " WHERE isbn=" + isbn;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which deletes an entry from the table members
     *
     * @param id of the entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "deleteMember")
    public boolean deleteMember(int id) {

        String query = "DELETE FROM members WHERE id=" + id;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which deletes an entry from the table books
     *
     * @param isbn of the entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "deleteBook")
    public boolean deleteBook(long isbn) {

        String query = "DELETE FROM books WHERE isbn=" + isbn;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Web service operation which deletes an entry from the table loan
     *
     * @param isbn of the entry
     * @param id of the entry
     * @return false if an error occurs, else true
     */
    @WebMethod(operationName = "deleteLoan")
    public boolean deleteLoan(long isbn, int id) {

        String query = "DELETE FROM loan WHERE isbn=" + isbn + " AND id=" + id;
        String query2 = "UPDATE books SET available=true WHERE isbn=" + isbn;

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement instruction = connection.createStatement();
            boolean rs = instruction.execute(query);
            boolean rs2 = instruction.execute(query2);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryWS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
