package Entities;

import Entities.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-19T09:00:23")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> comment_id;
    public static volatile SingularAttribute<Comment, Person> person;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, Date> createdDate;

}