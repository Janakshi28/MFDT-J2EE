package lk.megafundtpark.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Events;
import lk.megafundtpark.entities.Tickets;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Admins.class)
public class Admins_ { 

    public static volatile SingularAttribute<Admins, String> password;
    public static volatile SingularAttribute<Admins, Short> role;
    public static volatile SingularAttribute<Admins, String> name;
    public static volatile CollectionAttribute<Admins, Events> eventsCollection;
    public static volatile CollectionAttribute<Admins, Tickets> ticketsCollection;
    public static volatile SingularAttribute<Admins, String> userid;

}