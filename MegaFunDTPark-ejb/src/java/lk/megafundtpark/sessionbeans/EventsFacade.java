/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.EventsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Admins;
import lk.megafundtpark.entities.Events;
import lk.megafundtpark.remote.utils.EventDetails;


/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "eventsfacade")
public class EventsFacade implements EventsFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    private List<EventDetails> copyToEventDetails(List< Events> events) {
        List<EventDetails>  eventList = new ArrayList<EventDetails>();
        Iterator i =  events.iterator();
        while (i.hasNext()) {
            Events event = (Events) i.next();
            EventDetails details = new EventDetails(event.getId(),event.getTitle(), event.getPark(),event.getStarttime(),event.getEndtime(),event.getDateadded(),(event.getAdmins()).getUserid());
            eventList.add(details);
        }
        return eventList;
    }
    
    private EventDetails copyToEventDetails(Events event) {
        return new EventDetails(event.getId(),event.getTitle(), event.getPark(),event.getStarttime(),event.getEndtime(),event.getDateadded(),(event.getAdmins()).getUserid());
    }
    
    @Override
    public EventDetails getEvent(int id) {
        try {
            EventDetails event = this.copyToEventDetails(em.find(Events.class, id));
            
            return event;
        } catch (Exception e) {
            return null;
        }
    }
    
    public EventDetails getEvent(String title, String aId){
         try {
                
                 List<Events> results = em.createNamedQuery("Events.findByTitleByAdminId", Events.class)
                        .setParameter("title", title)
                        .setParameter("adminId", aId)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                    for(Events e: results){
                            return copyToEventDetails(e);
                    }
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
        return null;
    }
     
    @Override
    public void createEvent(EventDetails details) {
        try {
            Events event = new Events(details.getTitle(), details.getPark(),details.getStarttime(),details.getEndtime(),details.getDateadded());
            event.setAdmins(em.find(Admins.class, details.getAdminId()));   
            em.persist(event);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editEvent(EventDetails details) {
        try {
            Events event = new Events(details.getId(),details.getTitle(), details.getPark(),details.getStarttime(),details.getEndtime(),details.getDateadded(), em.find(Admins.class, details.getAdminId()));
            em.merge(event);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removeEvent(int id) {
        try {
            Events event = em.find(Events.class, id);
            em.remove(event);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public EventDetails find(Object pk) {
        Events event= em.find(Events.class, pk);
        return new EventDetails(event.getId(),event.getTitle(), event.getPark(),event.getStarttime(),event.getEndtime(),event.getDateadded(),(event.getAdmins()).getUserid());
    }
    
    @Override
    public List findAll() {
        return copyToEventDetails(em.createQuery("select object(o) from Events as o").getResultList());
    }

    
}
