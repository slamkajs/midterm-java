/*
 * This is the business logic for the guestbook.
 */
package business;

import Entities.Comment;
import Entities.Person;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author slamkajs
 */
@Stateful
public class ControlBean {
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Inserts a comment into the database.
     * @param firstName First name of the person making the comment.
     * @param middleName Middle name of the person making the comment.
     * @param lastName Last name of the person making the comment.
     * @param emailAddress Email address of the person making the comment.
     * @param commentBody The actual comment the person wants to make in the guestbook.
     * @return Boolean value of whether or not the comment was properly inserted into the database.
     */
    public boolean createComment(String firstName, String middleName, String lastName, String emailAddress, String commentBody) {
        try {
            Person currPerson = getPersonByEmail(emailAddress);
            
            if(currPerson == null || (!currPerson.getFirstName().equalsIgnoreCase(firstName) || !currPerson.getMiddleName().equalsIgnoreCase(middleName) || !currPerson.getLastName().equalsIgnoreCase(lastName))) {
                currPerson = createPerson(firstName, middleName, lastName, emailAddress);
            }
            
            Comment newComment = new Comment();

            newComment.setPerson(currPerson);
            newComment.setComment(commentBody);
            newComment.setCreatedDate(new Date());

            em.persist(newComment);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Create a person
     * @param firstName First name of the person.
     * @param middleName Middle name of the person.
     * @param lastName Last name of the person.
     * @param emailAddress Email address of the person.
     * @return Returns the record that was created.
     */
    private Person createPerson(String firstName, String middleName, String lastName, String emailAddress) {
        try {
            Person newPerson = new Person();
            
            newPerson.setFirstName(firstName);
            newPerson.setMiddleName(middleName);
            newPerson.setLastName(lastName);
            newPerson.setEmailAddress(emailAddress);
            
            em.persist(newPerson);
            
            return newPerson;
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * Searches for a person based on their email address.
     * @param emailAddress Email address to search by.
     * @return Returns a person record based on the provided email address.
     */
    private Person getPersonByEmail(String emailAddress) {
        try {
            Person searchResult = (Person) em.createNamedQuery("getPersonByEmail").setMaxResults(1).setParameter("email", emailAddress.toUpperCase() + "%").getSingleResult();
            
            return searchResult;
        } catch(NoResultException e) {
            return null;
        }
    }
    
    /**
     * Retrieves full list of comments.
     * @return List of comment objects.
     */
    public List<Comment> getComments() {
        try {
            return (List<Comment>) em.createNamedQuery("getAllComments").getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
