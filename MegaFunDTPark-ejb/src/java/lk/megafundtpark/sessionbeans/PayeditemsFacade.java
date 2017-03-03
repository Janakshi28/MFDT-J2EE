/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.entities.Payables;
import lk.megafundtpark.entities.Payeditems;
import lk.megafundtpark.remote.utils.PayedItemDetails;



/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "payeditemsfacade")
public class PayeditemsFacade implements PayeditemsFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    private List<PayedItemDetails> copyToPayedItemDetails(List< Payeditems> items) {
        List<PayedItemDetails>  itemList = new ArrayList<PayedItemDetails>();
        Iterator i =  items.iterator();
        while (i.hasNext()) {
            Payeditems item = (Payeditems) i.next();
            PayedItemDetails details = new PayedItemDetails(item.getId(),item.getType(), item.getAmount(),item.getNoofitems(),
                                                    (item.getEbands()).getBandid(), (item.getPayables()).getId());
            itemList.add(details);
        }
        return itemList;
    }
    
    private PayedItemDetails copyToPayedItemDetails(Payeditems item) {
        return new PayedItemDetails(item.getId(),item.getType(), item.getAmount(),item.getNoofitems(),
                                                    (item.getEbands()).getBandid(), (item.getPayables()).getId());
    }
    
    @Override
    public PayedItemDetails getPayedItem(Integer id) {
        try {
            PayedItemDetails item = this.copyToPayedItemDetails(em.find(Payeditems.class, id));
            
            return item;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
     public List<PayedItemDetails> getPaymentList(int bandId) {
            try {
                
                 List<Payeditems> results = em.createNamedQuery("Payeditems.findByBandId", Payeditems.class)
                        .setParameter("bandid", bandId)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                            return copyToPayedItemDetails(results);
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
        
  
 }
     
    @Override
    public void createPayedItem(PayedItemDetails details) {
        try {
            Payeditems item = new Payeditems(details.getType(),details.getAmount(),details.getNoofitems());
            item.setEbands(em.find(Ebands.class, details.getEbandId()));
            item.setPayables(em.find(Payables.class, details.getPayablesId()));
            em.persist(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editPayedItem(PayedItemDetails details) {
        try {
            Payeditems item = new Payeditems(details.getId(),details.getType(),details.getAmount(),details.getNoofitems(),
                                                 em.find(Ebands.class, details.getEbandId()), em.find(Payables.class, details.getPayablesId()));
            em.merge(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removePayedItem(Integer id) {
        try {
            Payeditems item = em.find(Payeditems.class, id);
            em.remove(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public PayedItemDetails find(Object pk) {
        Payeditems item= em.find(Payeditems.class, pk);
        return new PayedItemDetails(item.getId(),item.getType(), item.getAmount(),item.getNoofitems(),
                                                    (item.getEbands()).getBandid(), (item.getPayables()).getId());
    }
    
    @Override
    public List findAll() {
        return copyToPayedItemDetails(em.createQuery("select object(o) from Payeditems as o").getResultList());
    }

    
}
