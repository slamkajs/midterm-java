/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author slamkajs
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getPersonByEmail", query="select p from Person p where UPPER(p.emailAddress) LIKE :email")
})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int person_id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    

    public int getPersonId() {
        return getPerson_id();
    }

    public void setPersonId(int id) {
        this.setPerson_id(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) getPerson_id();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the person_id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if (this.getPerson_id() != other.getPerson_id()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Person[ id=" + getPerson_id() + " ]";
    }

    /**
     * @return the person_id
     */
    public int getPerson_id() {
        return person_id;
    }

    /**
     * @param person_id the person_id to set
     */
    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
}
