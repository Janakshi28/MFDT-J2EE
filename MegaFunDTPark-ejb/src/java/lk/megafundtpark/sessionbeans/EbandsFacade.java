/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.entities.Tickets;
import lk.megafundtpark.remote.utils.EbandDetails;


/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "ebandsfacade")
public class EbandsFacade implements EbandsFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
     private List<EbandDetails> copyToEbandDetails(List< Ebands> ebands) {
        List<EbandDetails>  ebandList = new ArrayList<EbandDetails>();
        Iterator i =  ebands.iterator();
        while (i.hasNext()) {
            Ebands eband = (Ebands) i.next();
            EbandDetails details = new EbandDetails(eband.getBandid(),eband.getTotal(), (eband.getTickets()).getTicketid());
            ebandList .add(details);
        }
        return ebandList;
    }
    
    private EbandDetails copyToEbandDetails(Ebands eband) {
        return new EbandDetails(eband.getBandid(),eband.getTotal(), (eband.getTickets()).getTicketid());
    }
    
    @Override
    public EbandDetails getEband(Integer ticketid) {
        
          try {
                 List<Ebands> results = em.createNamedQuery("Ebands.findByTicketId", Ebands.class)
                        .setParameter("ticketid", ticketid)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                    for (Ebands band : results) {
                        if (band.getTickets().getTicketid().equals(ticketid)) {
                            return copyToEbandDetails(band);
                        }
                    }
                    return null;
                }
            }
               // return eband;
             catch (Exception e) {
                return null;
            }
        
    }
    
    @Override
    public EbandDetails readEband(Integer bandId){
         try {
            EbandDetails band = this.copyToEbandDetails(em.find(Ebands.class, bandId));
            return band;
        } catch (Exception e) {
            return null;
        }
    }
    
    
     
    @Override
    public void createEband(EbandDetails details) {
        try {
            Ebands eband = new Ebands(details.getTotal(),em.find(Tickets.class, details.getTicketId()));
            em.persist(eband);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editEband(EbandDetails details) {
        try {
            Ebands eband = new Ebands(details.getBandid(),details.getTotal(), em.find(Tickets.class, details.getTicketId()));
            em.merge(eband);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removeEband(Integer id) {
        try {
            Ebands eband = em.find(Ebands.class, id);
            em.remove(eband);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public EbandDetails find(Object pk) {
        Ebands eband= em.find(Ebands.class, pk);
        return new EbandDetails(eband.getBandid(),eband.getTotal(), (eband.getTickets()).getTicketid());
    }
    
    @Override
    public List findAll() {
        return copyToEbandDetails(em.createQuery("select object(o) from Ebands as o").getResultList());
    }
    
    
}
