/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.EventDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface EventsFacadeRemote {

    public void persist(Object object);

    public EventDetails getEvent(int id);

    public void createEvent(EventDetails details);

    public void editEvent(EventDetails details);

    public void removeEvent(int id);

    public EventDetails find(Object pk);

    public List findAll();

    public EventDetails getEvent(String title, String aId);
    
}
