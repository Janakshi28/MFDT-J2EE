/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.TicketsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Admins;
import lk.megafundtpark.entities.Customers;
import lk.megafundtpark.entities.Tickets;
import lk.megafundtpark.remote.utils.TicketDetails;

/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "ticketsfacade")
public class TicketsFacade implements TicketsFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    private List<TicketDetails> copyToTicketDetails(List< Tickets> tickets) {
        List<TicketDetails>  ticketList = new ArrayList<TicketDetails>();
        Iterator i =  tickets.iterator();
        while (i.hasNext()) {
            Tickets ticket = (Tickets) i.next();
            TicketDetails details = new TicketDetails(ticket.getTicketid(),ticket.getType(),ticket.getIssueddate(), ticket.getPrice(),
                                            (ticket.getAdmins()).getUserid(), (ticket.getCustomers()).getCustomerid());
            ticketList.add(details);
        }
        return ticketList;
    }
    
    
    private TicketDetails copyToTicketDetails(Tickets ticket) {
        return new TicketDetails(ticket.getTicketid(),ticket.getType(),ticket.getIssueddate(), ticket.getPrice(),
                                            (ticket.getAdmins()).getUserid(), (ticket.getCustomers()).getCustomerid());
    }
    
    @Override
    public List<TicketDetails> getTickets(Integer customerid, Date date) {
            try {
                
                 List<Tickets> results = em.createNamedQuery("Tickets.findByCustomerIdByIssuedDate", Tickets.class)
                        .setParameter("customerid", customerid)
                        .setParameter("issueddate", date)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                            return copyToTicketDetails(results);
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
        
  
 }
     
    @Override
    public void createTicket(TicketDetails details) {
        try {
            Tickets ticket = new Tickets(details.getType(),details.getIssueddate(),details.getPrice());
            ticket.setAdmins(em.find(Admins.class, details.getAdminId()));
            ticket.setCustomers(em.find(Customers.class, details.getCustomerId()));
            em.persist(ticket);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editTicket(TicketDetails details) {
        try {
            Tickets ticket = new Tickets(details.getTicketid(),details.getType(),details.getIssueddate(),details.getPrice(),
                                                 em.find(Admins.class, details.getAdminId()), em.find(Customers.class, details.getCustomerId()));
            em.merge(ticket);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removeTicket(String id) {
        try {
            Tickets ticket = em.find(Tickets.class, id);
            em.remove(ticket);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public TicketDetails find(Object pk) {
        Tickets ticket= em.find(Tickets.class, pk);
        return new TicketDetails(ticket.getTicketid(),ticket.getType(),ticket.getIssueddate(), ticket.getPrice(),
                                            (ticket.getAdmins()).getUserid(), (ticket.getCustomers()).getCustomerid());
    }
    
    @Override
    public List findAll() {
        return copyToTicketDetails(em.createQuery("select object(o) from Tickets as o").getResultList());
    }

    
}
