package lk.megafundtpark.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Payeditems;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Payables.class)
public class Payables_ { 

    public static volatile CollectionAttribute<Payables, Payeditems> payeditemsCollection;
    public static volatile SingularAttribute<Payables, Integer> fee;
    public static volatile SingularAttribute<Payables, Integer> id;
    public static volatile SingularAttribute<Payables, String> type;
    public static volatile SingularAttribute<Payables, String> title;

}