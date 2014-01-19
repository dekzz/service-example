package org.foi.emp.client.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.foi.emp.web.Book;
import org.foi.emp.web.LibraryWS_Service;
import org.foi.emp.web.Loan;
import org.foi.emp.web.Member;

/**
 * Bean for showing the tables and for deleting an entry
 *
 * @author Bandić, Rajčević, Tomala
 */
@ManagedBean
@SessionScoped
public class LibraryClientBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LibraryWS/LibraryWS.wsdl")
    private LibraryWS_Service service;
    private List<Member> listMembers;
    private List<Book> listBooks;
    private List<Loan> listLoans;
    private Member selectedMember;
    private Book selectedBook;
    private Loan selectedLoan;
    private boolean visibleMembers;
    private boolean visibleBooks;
    private boolean visibleLoan;
    private int show;
    private long isbn;
    private int id;
    private List<Long> availableISBN;
    private List<Long> bookISBNs;
    private List<Integer> memberIDs;

    /**
     * Creates a new instance of LibraryClientBean
     */
    public LibraryClientBean() {
    }

    /**
     * Adds the book to the list if it is available
     *
     * @return list of available books
     */
    public List<Long> getAvailableISBN() {
        availableISBN = new ArrayList<Long>();
        for (Book b : this.getBooks()) {
            if (b.isAvailable()) {
                availableISBN.add(b.getIsbn());
            }
        }
        return availableISBN;
    }

    public void setAvailableISBN(List<Long> availableISBN) {
        this.availableISBN = availableISBN;
    }

    public List<Long> getBookISBNs() {
        bookISBNs = new ArrayList<Long>();
        for (Book b : this.getBooks()) {
            bookISBNs.add(b.getIsbn());
        }
        return bookISBNs;
    }

    public void setBookISBNs(List<Long> bookISBNs) {
        this.bookISBNs = bookISBNs;
    }

    /**
     * Adds the members id to a list
     *
     * @return list with members id
     */
    public List<Integer> getMemberIDs() {
        memberIDs = new ArrayList<Integer>();
        for (Member m : this.getMembers()) {
            memberIDs.add(m.getId());
        }
        return memberIDs;
    }

    public void setMemberIDs(List<Integer> memberIDs) {
        this.memberIDs = memberIDs;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisibleMembers() {
        return visibleMembers;
    }

    public void setVisibleMembers(boolean visibleMembers) {
        this.visibleMembers = visibleMembers;
    }

    public boolean isVisibleBooks() {
        return visibleBooks;
    }

    public void setVisibleBooks(boolean visibleBooks) {
        this.visibleBooks = visibleBooks;
    }

    public boolean isVisibleLoan() {
        return visibleLoan;
    }

    public void setVisibleLoan(boolean visibleLoan) {
        this.visibleLoan = visibleLoan;
    }

    /**
     * Calling a web service operations fills a list of Members
     *
     * @return list of Members
     */
    public List<Member> getListMembers() {
        listMembers = new ArrayList<Member>();
        listMembers.addAll(this.getMembers());
        return listMembers;
    }

    public void setListMembers(List<Member> listMembers) {
        this.listMembers = listMembers;
    }

    /**
     * Calling a web service operations fills a list of Books
     *
     * @return list of Books
     */
    public List<Book> getListBooks() {
        listBooks = new ArrayList<Book>();
        listBooks.addAll(this.getBooks());
        return listBooks;
    }

    public void setListBooks(List<Book> books) {
        this.listBooks = books;
    }

    /**
     * Calling a web service operations fills a list of Loans
     *
     * @return list of Loans
     */
    public List<Loan> getListLoans() {
        listLoans = new ArrayList<Loan>();
        listLoans.addAll(this.getLoan());
        return listLoans;
    }

    public void setListLoans(List<Loan> listLoans) {
        this.listLoans = listLoans;
    }

    /**
     * Changes the visibility of the books part in the JSF page
     *
     * @return empty string, to be redirected to the same page
     */
    public String changeVisibilityBooks() {
        if (visibleBooks) {
            visibleBooks = false;
        } else {
            visibleBooks = true;
        }
        return "";
    }

    /**
     * Changes the visibility of the loan part in the JSF page
     *
     * @return empty string, to be redirected to the same page
     */
    public String changeVisibilityLoan() {
        if (visibleLoan) {
            visibleLoan = false;
        } else {
            visibleLoan = true;
        }
        return "";
    }

    /**
     * Changes the visibility of the members part in the JSF page
     *
     * @return empty string, to be redirected to the same page
     */
    public String changeVisibilityMembers() {
        if (visibleMembers) {
            visibleMembers = false;
        } else {
            visibleMembers = true;
        }
        return "";
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    /**
     * Gets the selected member from the table for editing or deleting
     *
     * @return the selected member
     */
    public Member getSelectedMember() {
        selectedMember = new Member();
        for (Member m : this.getMembers()) {
            if (m.getId() == id) {
                selectedMember.setId(m.getId());
                selectedMember.setFirstname(m.getFirstname());
                selectedMember.setLastname(m.getLastname());
                selectedMember.setEmail(m.getEmail());
            }
        }
        return selectedMember;
    }

    public void setSelectedMember(Member selectedMember) {
        this.selectedMember = selectedMember;
    }

    /**
     * Gets the selected book from the table for editing or deleting
     *
     * @return the selected book
     */
    public Book getSelectedBook() {
        selectedBook = new Book();
        for (Book b : this.getBooks()) {
            if (b.getIsbn() == isbn) {
                selectedBook.setIsbn(b.getIsbn());
                selectedBook.setTitle(b.getTitle());
                selectedBook.setAuthor(b.getAuthor());
                selectedBook.setAvailable(b.isAvailable());
            }
        }
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    /**
     * Gets the selected loan from the table for editing or deleting
     *
     * @return the selected loan
     */
    public Loan getSelectedLoan() {
        selectedLoan = new Loan();
        for (Loan l : this.getLoan()) {
            if (l.getIsbn() == isbn && l.getId() == id) {
                selectedLoan.setIsbn(l.getIsbn());
                selectedLoan.setId(l.getId());
                selectedLoan.setLoandate(l.getLoandate());
            }
        }
        return selectedLoan;
    }

    public void setSelectedLoan(Loan selectedLoan) {
        this.selectedLoan = selectedLoan;
    }

    /**
     * Sets the show variable to 0, which indicates that only the member panel
     * grid in the addRecord JSF page should be visible.
     *
     * @return ADD, to be redirected to the index page
     */
    public String addMember() {
        show = 0;
        return "ADD";
    }

    /**
     * Calls the service operation for deleting a member
     *
     * @return empty string, to be redirected to the same page
     */
    public String removeMember() {
        deleteMember(id);
        return "";
    }

    /**
     * Sets the show variable to 0, which indicates that only the member panel
     * grid in the editRecord JSF page should be visible.
     *
     * @return EDIT, to be redirected to the index page
     */
    public String editMember() {
        show = 0;
        return "EDIT";
    }

    /**
     * Sets the show variable to 1, which indicates that only the book panel
     * grid in the addRecord JSF page should be visible.
     *
     * @return ADD, to be redirected to the index page
     */
    public String addBook() {
        show = 1;
        return "ADD";
    }

    /**
     * Calls the service operation for deleting a book
     *
     * @return empty string, to be redirected to the same page
     */
    public String removeBook() {
        deleteBook(isbn);
        return "";
    }

    /**
     * Sets the show variable to 1, which indicates that only the book panel
     * grid in the editRecord JSF page should be visible.
     *
     * @return EDIT, to be redirected to the index page
     */
    public String editBook() {
        show = 1;
        return "EDIT";
    }

    /**
     * Sets the show variable to 2, which indicates that only the loan panel
     * grid in the addRecord JSF page should be visible.
     *
     * @return ADD, to be redirected to the index page
     */
    public String addLoan() {
        show = 2;
        return "ADD";
    }

    /**
     * Calls the service operation for deleting a loan
     *
     * @return empty string, to be redirected to the same page
     */
    public String removeLoan() {
        deleteLoan(isbn, id);
        return "";
    }

    private java.util.List<org.foi.emp.web.Loan> getLoan() {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.getLoan();
    }

    private java.util.List<org.foi.emp.web.Book> getBooks() {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.getBooks();
    }

    private java.util.List<org.foi.emp.web.Member> getMembers() {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.getMembers();
    }

    private boolean deleteBook(long arg0) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.deleteBook(arg0);
    }

    private boolean deleteMember(int arg0) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.deleteMember(arg0);
    }

    private boolean deleteLoan(long arg0, int arg1) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.deleteLoan(arg0, arg1);
    }
}
