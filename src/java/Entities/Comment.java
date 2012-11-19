/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author slamkajs
 */
@Entity
@NamedQuery(name="getAllComments", query="select c from Comment c")

public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comment_id;
    
    @Column(columnDefinition="LONG VARCHAR")
    private String comment;
    
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    public int getCommentId() {
        return comment_id;
    }

    public void setCommentId(int id) {
        this.comment_id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) comment_id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the comment_id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if (this.comment_id != other.comment_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Comment[ id=" + comment_id + " ]";
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
