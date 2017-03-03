package lk.megafundtpark.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Admins;
import lk.megafundtpark.entities.Customers;
import lk.megafundtpark.entities.Ebands;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Tickets.class)
public class Tickets_ { 

    public static volatile SingularAttribute<Tickets, Integer> price;
    public static volatile SingularAttribute<Tickets, Customers> customers;
    public static volatile SingularAttribute<Tickets, String> type;
    public static volatile SingularAttribute<Tickets, Integer> ticketid;
    public static volatile SingularAttribute<Tickets, Date> issueddate;
    public static volatile SingularAttribute<Tickets, Admins> admins;
    public static volatile CollectionAttribute<Tickets, Ebands> ebandsCollection;

}