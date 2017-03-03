/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.PayablesFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Payables;
import lk.megafundtpark.remote.utils.PayablesDetails;


/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "payablesfacade")
public class PayablesFacade implements PayablesFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    private List<PayablesDetails> copyToPayablesDetails(List< Payables> items) {
        List<PayablesDetails>  itemList = new ArrayList<PayablesDetails>();
        Iterator i =  items.iterator();
        while (i.hasNext()) {
            Payables item = (Payables) i.next();
            PayablesDetails details = new PayablesDetails(item.getId(),item.getType(), item.getTitle(),item.getFee());
            itemList.add(details);
        }
        return itemList;
    }
    
    private PayablesDetails copyToPayablesDetails(Payables item) {
        return new PayablesDetails(item.getId(),item.getType(), item.getTitle(),item.getFee());
    }
    
    @Override
    public PayablesDetails getPayableItem(String id) {
        try {
            PayablesDetails item = this.copyToPayablesDetails(em.find(Payables.class, id));
            
            return item;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
     public PayablesDetails getPayable(String type, String title) {
       List<PayablesDetails> list= new ArrayList<PayablesDetails>();
       PayablesDetails pay= new PayablesDetails();
           int price= 0;
           try {
                 List<Payables> results = em.createNamedQuery("Payables.findByTypeByTitle", Payables.class)
                        .setParameter("type", type)
                        .setParameter("title", title)
                        .getResultList();
                if (results.isEmpty()) {
                        list= null;
                } else {
                        list= copyToPayablesDetails(results);
                }
            }
             catch (Exception e) {
                 System.out.println(e);
            }
        for(PayablesDetails p: list){
            if(p.getTitle()==title){
                return p;
            }
        }
        return null;
    }
     
    @Override
    public void createPayableItem(PayablesDetails details) {
        try {
            Payables item = new Payables(details.getId(),details.getType(),details.getTitle(), details.getFee());
            em.persist(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editPayableItem(PayablesDetails details) {
        try {
            Payables item = new Payables(details.getId(),details.getType(),details.getTitle(), details.getFee());
            em.merge(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removePayableItem(String id) {
        try {
            Payables item = em.find(Payables.class, id);
            em.remove(item);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public int getPrice(String type, String title){
           List<PayablesDetails> list= new ArrayList<PayablesDetails>();
           int price= 0;
           try {
                 List<Payables> results = em.createNamedQuery("Payables.findByTypeByTitle", Payables.class)
                        .setParameter("type", type)
                        .setParameter("title", title)
                        .getResultList();
                if (results.isEmpty()) {
                        list= null;
                } else {
                        list= copyToPayablesDetails(results);
                }
            }
             catch (Exception e) {
                 System.out.println(e);
            }
        for(PayablesDetails p: list){
            price= p.getFee();
        }
        return price;
    }
    
    @Override
    public PayablesDetails find(Object pk) {
        Payables item= em.find(Payables.class, pk);
        return new PayablesDetails(item.getId(),item.getType(), item.getTitle(),item.getFee());
    }
    
    @Override
    public List findAll() {
        return copyToPayablesDetails(em.createQuery("select object(o) from Payables as o").getResultList());
    }

    
}
