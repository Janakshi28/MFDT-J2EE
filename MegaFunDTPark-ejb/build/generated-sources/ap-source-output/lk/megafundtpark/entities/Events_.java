package lk.megafundtpark.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lk.megafundtpark.entities.Admins;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-03T05:06:33")
@StaticMetamodel(Events.class)
public class Events_ { 

    public static volatile SingularAttribute<Events, Date> endtime;
    public static volatile SingularAttribute<Events, Integer> id;
    public static volatile SingularAttribute<Events, Date> starttime;
    public static volatile SingularAttribute<Events, String> title;
    public static volatile SingularAttribute<Events, Date> dateadded;
    public static volatile SingularAttribute<Events, String> park;
    public static volatile SingularAttribute<Events, Admins> admins;

}