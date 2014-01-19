package org.foi.emp.model;

import java.io.Serializable;

/**
 * Model for one entry in database table books
 *
 * @author Bandić, Rajčević, Tomala
 */
public class Book implements Serializable{

    private long isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(long isbn, String title, String author, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = available;
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
}
