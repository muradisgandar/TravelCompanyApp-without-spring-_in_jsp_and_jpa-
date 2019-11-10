package entities;

import entities.Travelpackages;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-10T14:45:22")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> mail;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, Travelpackages> tourId;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> phonenumber;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Integer> age;

}