package org.foi.emp.model;

import java.io.Serializable;

/**
 * Model for one entry in database table loan
 *
 * @author Bandić, Rajčević, Tomala
 */
public class Loan implements Serializable{

    private long isbn;
    private int id;
    private String loandate;

    public Loan(long isbn, int id, String loandate) {
        this.isbn = isbn;
        this.id = id;
        this.loandate = loandate;
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

    public String getLoandate() {
        return loandate;
    }

    public void setLoandate(String loandate) {
        this.loandate = loandate;
    }
}
