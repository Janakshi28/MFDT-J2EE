package lk.megafundtpark.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.entities.Payables;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Payeditems.class)
public class Payeditems_ { 

    public static volatile SingularAttribute<Payeditems, Integer> amount;
    public static volatile SingularAttribute<Payeditems, Integer> noofitems;
    public static volatile SingularAttribute<Payeditems, Ebands> ebands;
    public static volatile SingularAttribute<Payeditems, Integer> id;
    public static volatile SingularAttribute<Payeditems, String> type;
    public static volatile SingularAttribute<Payeditems, Payables> payables;

}