
package org.foi.emp.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="loandate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", propOrder = {
    "id",
    "isbn",
    "loandate"
})
public class Loan {

    protected int id;
    protected long isbn;
    protected String loandate;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     */
    public void setIsbn(long value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the loandate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoandate() {
        return loandate;
    }

    /**
     * Sets the value of the loandate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoandate(String value) {
        this.loandate = value;
    }

}
