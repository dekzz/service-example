package org.foi.emp.client.ejb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.foi.emp.web.LibraryWS_Service;

/**
 * Bean for adding a new record in one of the tables
 *
 * @author Bandić, Rajčević, Tomala
 */
@ManagedBean
@SessionScoped
public class AddRecordBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LibraryWS/LibraryWS.wsdl")
    private LibraryWS_Service service;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private long isbn;
    private String title;
    private String author;
    private boolean available;

    public AddRecordBean() {
    }

    /**
     * Calls the service operation for inserting a new member
     *
     * @return INSERT, to be redirected to the index page
     */
    public String insertMember() {
        addMember(id, firstName, lastName, email);
        return "INSERT";
    }

    /**
     * Calls the service operation for inserting a new book
     *
     * @return INSERT, to be redirected to the index page
     */
    public String insertBook() {
        addBook(isbn, title, author, available);
        return "INSERT";
    }

    /**
     * Calls the service operation for inserting a new loan
     *
     * @return INSERT, to be redirected to the index page
     */
    public String insertLoan() {
        LibraryClientBean ep = (LibraryClientBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("libraryClientBean");
        addLoan(ep.getIsbn(), ep.getId());
        return "INSERT";
    }

    public LibraryWS_Service getService() {
        return service;
    }

    public void setService(LibraryWS_Service service) {
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean addMember(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.addMember(arg0, arg1, arg2, arg3);
    }

    private boolean addBook(long arg0, java.lang.String arg1, java.lang.String arg2, boolean arg3) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.addBook(arg0, arg1, arg2, arg3);
    }

    private boolean addLoan(long arg0, int arg1) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.addLoan(arg0, arg1);
    }
}
