package org.foi.emp.client.ejb;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.foi.emp.web.LibraryWS_Service;

/**
 * Bean for editing a record in one of the tables
 *
 * @author Bandić, Rajčević, Tomala
 */
@ManagedBean
@SessionScoped
public class EditRecordBean implements Serializable {

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

    public EditRecordBean() {
        LibraryClientBean ep = (LibraryClientBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("libraryClientBean");
        id = ep.getSelectedMember().getId();
        firstName = ep.getSelectedMember().getFirstname();
        lastName = ep.getSelectedMember().getLastname();
        email = ep.getSelectedMember().getEmail();
        isbn = ep.getSelectedBook().getIsbn();
        title = ep.getSelectedBook().getTitle();
        author = ep.getSelectedBook().getAuthor();
        available = ep.getSelectedBook().isAvailable();
    }

    /**
     * Calls the service operation for editing a member
     *
     * @return UPDATE, to be redirected to the index page
     */
    public String updateMember() {
        editMember(id, firstName, lastName, email);
        return "UPDATE";
    }

    /**
     * Calls the service operation for editing a book
     *
     * @return UPDATE, to be redirected to the index page
     */
    public String updateBook() {
        editBook(isbn, title, author, available);
        return "UPDATE";
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

    private boolean editMember(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.editMember(arg0, arg1, arg2, arg3);
    }

    private boolean editBook(long arg0, java.lang.String arg1, java.lang.String arg2, boolean arg3) {
        org.foi.emp.web.LibraryWS port = service.getLibraryWSPort();
        return port.editBook(arg0, arg1, arg2, arg3);
    }
}
