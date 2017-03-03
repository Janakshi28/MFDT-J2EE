package lk.megafundtpark.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Elockers;
import lk.megafundtpark.entities.Payeditems;
import lk.megafundtpark.entities.Photos;
import lk.megafundtpark.entities.Tickets;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Ebands.class)
public class Ebands_ { 

    public static volatile CollectionAttribute<Ebands, Elockers> elockersCollection;
    public static volatile CollectionAttribute<Ebands, Payeditems> payeditemsCollection;
    public static volatile SingularAttribute<Ebands, Integer> total;
    public static volatile SingularAttribute<Ebands, Tickets> tickets;
    public static volatile SingularAttribute<Ebands, Integer> bandid;
    public static volatile CollectionAttribute<Ebands, Photos> photosCollection;

}