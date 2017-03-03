package lk.megafundtpark.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Tickets;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, Integer> customerid;
    public static volatile SingularAttribute<Customers, String> name;
    public static volatile CollectionAttribute<Customers, Tickets> ticketsCollection;
    public static volatile SingularAttribute<Customers, String> email;

}