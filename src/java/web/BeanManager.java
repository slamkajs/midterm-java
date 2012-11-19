/*
 * The controller behind the view and business logic.
 */
package web;

import Entities.Comment;
import business.ControlBean;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author slamkajs
 */
@ManagedBean
@SessionScoped
public class BeanManager {
    // COMMENT VARIABLES
    private String commentBody;
    
    // PERSON VARIABLES
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    
    // LIST VARIABLES
    private List<Comment> commentList;
    
    // RETURN VARS
    private String formReturn = "";
    private boolean status = false;
    
    @EJB
    ControlBean control;

    /** Creates a new instance of BeanManager */
    public BeanManager() {
    }
    
    /**
     * Allow a user to insert a comment into the database.
     */
    public void createComment() {
        try {
            // INSERT COMMENT INTO GUESTBOOK DATABASE
            setStatus(control.createComment(firstName, middleName, lastName, email, commentBody));
            
            // DETERMINE IF IT WAS SUCCESSFULLY INSERTED
            if(isStatus()) {
                setFormReturn("Comment has been added to the guestbook.");
                
                // CLEAR THE FORM FIELDS
                clearFormVars();
            } else {
                setFormReturn("Please provide more information.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the commentBody
     */
    public String getCommentBody() {
        return commentBody;
    }

    /**
     * @param commentBody the commentBody to set
     */
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the full list of comments
     */
    public List<Comment> getCommentList() {
        try {
            this.commentList = control.getComments();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return commentList;
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
     * @return the commentReturn
     */
    public String getFormReturn() {
        return formReturn;
    }

    /**
     * @param commentReturn the commentReturn to set
     */
    public void setFormReturn(String commentReturn) {
        this.formReturn = commentReturn;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Clears the variables used to store form information.  Used after a comment is successfully inserted.
     */
    private void clearFormVars() {
        setFirstName("");
        setMiddleName("");
        setLastName("");
        setEmail("");
        setCommentBody("");
    }
}
