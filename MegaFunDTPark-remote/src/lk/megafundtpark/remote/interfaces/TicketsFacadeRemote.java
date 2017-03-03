/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.TicketDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface TicketsFacadeRemote {

    public void persist(Object object);

    public List<TicketDetails> getTickets(Integer customerid, Date date);

    public void createTicket(TicketDetails details);

    public void editTicket(TicketDetails details);

    public void removeTicket(String id);

    public TicketDetails find(Object pk);

    public List findAll();
    
}
