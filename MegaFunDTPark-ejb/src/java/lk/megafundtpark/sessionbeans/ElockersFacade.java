/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.ElockersFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.entities.Elockers;
import lk.megafundtpark.entities.Tickets;
import lk.megafundtpark.remote.utils.ElockerDetails;


/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "elockersfacade")
public class ElockersFacade implements ElockersFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

     private List<ElockerDetails> copyToElockerDetails(List< Elockers> elockers) {
        List<ElockerDetails>  elockerList = new ArrayList<ElockerDetails>();
        Iterator i =  elockers.iterator();
        while (i.hasNext()) {
            Elockers elocker = (Elockers) i.next();
            ElockerDetails details = new ElockerDetails(elocker.getLockerid(),elocker.getSize(), elocker.getIsoccupied(),(elocker.getEbands()).getBandid());
            elockerList.add(details);
        }
        return elockerList;
    }
    
      private List<ElockerDetails> copyToElockersDetails(List< Elockers> elockers) {
        List<ElockerDetails>  elockerList = new ArrayList<ElockerDetails>();
        Iterator i =  elockers.iterator();
        while (i.hasNext()) {
            Elockers elocker = (Elockers) i.next();
            ElockerDetails details = new ElockerDetails(elocker.getLockerid(),elocker.getSize(), elocker.getIsoccupied());
            elockerList.add(details);
        }
        return elockerList;
    }
     
    private ElockerDetails copyToElockerDetails(Elockers elocker) {
        return new ElockerDetails(elocker.getLockerid(),elocker.getSize(), elocker.getIsoccupied());
    }
    
    @Override
    public ElockerDetails getElocker(Integer lockerid) {
        try {
            ElockerDetails elocker = this.copyToElockerDetails(em.find(Elockers.class, lockerid));
            
            return elocker;
        } catch (Exception e) {
            return null;
        }
    }
     
    @Override
    public void createElocker(ElockerDetails details) {
        try {
            Elockers elocker = new Elockers(details.getLockerid(),details.getSize(), details.getIsoccupied());
            elocker.setEbands(em.find(Ebands.class, details.getEbandId()));   
            em.persist(elocker);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editElocker(ElockerDetails details) {
        try {
            Elockers elocker = new Elockers(details.getLockerid(),details.getSize(), details.getIsoccupied(), em.find(Ebands.class, details.getEbandId()));
            em.merge(elocker);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public List<ElockerDetails> getUnreserved(){
        Boolean isoccupied=false;
        try {
                
                 List<Elockers> results = em.createNamedQuery("Elockers.findByNotReserved", Elockers.class)
                         .setParameter("isoccupied", isoccupied)
                        .getResultList();
                if (results.isEmpty()) {                  
                    return null;
                    
                } else {
                            return copyToElockersDetails(results);
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
    }
    
    @Override
    public List<ElockerDetails> getReserved(){
         Boolean isoccupied=true;
        try {
                
                 List<Elockers> results = em.createNamedQuery("Elockers.findByReserved", Elockers.class)
                          .setParameter("isoccupied", isoccupied)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                    return copyToElockersDetails(results);                           
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
    }
    
    @Override
    public List<ElockerDetails> getBandReserved(Integer bandid){
         Boolean isoccupied=true;
        try {
                
                 List<Elockers> results = em.createNamedQuery("Elockers.findByBandByReserved", Elockers.class)
                          .setParameter("isoccupied", isoccupied)
                         .setParameter("bandid", bandid)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                    return copyToElockersDetails(results);                           
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
    }
    
    
    @Override
    public void removeElocker(String id) {
        try {
            Elockers elocker = em.find(Elockers.class, id);
            em.remove(elocker);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public ElockerDetails find(Object pk) {
        Elockers elocker= em.find(Elockers.class, pk);
        return new ElockerDetails(elocker.getLockerid(),elocker.getSize(), elocker.getIsoccupied(),(elocker.getEbands()).getBandid());
    }
    
    @Override
    public List findAll() {
        return copyToElockerDetails(em.createQuery("select object(o) from Elockers as o").getResultList());
    }
}
