/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayablesFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;
import lk.megafundtpark.remote.interfaces.EPaymentFacadeRemote;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.PayablesDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@Stateful(mappedName = "epaymentfacade")
public class EPaymentFacade implements EPaymentFacadeRemote {
       private EbandsFacadeRemote ebandHandler;
       private PayeditemsFacadeRemote paymentHandler;
       private PayablesFacadeRemote itemHandler;
       
       //Holds bandIds
       private List<Integer> bands;
       

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

       @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    @PostConstruct
    private void initializeBean(){
             bands = new ArrayList<Integer>();
        try {
            InitialContext ic = new InitialContext();
            ebandHandler = (EbandsFacadeRemote) ic.lookup("ebandsfacade");
            paymentHandler= (PayeditemsFacadeRemote) ic.lookup("payeditemsfacade");
            itemHandler = (PayablesFacadeRemote) ic.lookup("payablesfacade");
        } catch (NamingException ex) {
            Logger.getLogger(EPaymentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addToPayments(int bandId){
        int count=0;
        for(Integer i: bands) {
            if(i== bandId){
               count++;
            }
        }
        
        if(count==0){
           bands.add(bandId); 
        }       
    }
    
      
       @Override
     public List<PayedItemDetails> getPaymentsOfOne(List<Integer> list, int id){
         
        for(Integer i: list) {
            if(i== id){
               return paymentHandler.getPaymentList(id);
            }
        }
            
        return null;
    }
    
       @Override
    public void payForAnItem(PayablesDetails item, EbandDetails band, int amount){
        String type =item.getType()+"-"+item.getTitle();
        int total = amount* item.getFee();
        PayedItemDetails payItem = new PayedItemDetails(type,item.getFee(),amount,band.getBandid(),item.getId());
        paymentHandler.createPayedItem(payItem);
        
        int balance= band.getTotal() - total;
        band.setTotal(balance);
        ebandHandler.editEband(band);
        
    }
    
       @Override
    public void undoPayment(PayedItemDetails payItem, EbandDetails band){
        int refund= payItem.getAmount()*payItem.getNoofitems();
        int balance= band.getTotal()+refund;
        paymentHandler.removePayedItem(payItem.getId());
        ebandHandler.editEband(band);
        
    }
    
    
      @Override
      @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int clearEband(int bandId){
        int refund = 0;
        List<PayedItemDetails> pList = paymentHandler.getPaymentList(bandId);
        for(PayedItemDetails i : pList){
            paymentHandler.removePayedItem(i.getId());
        }
        Ebands eband = em.find(Ebands.class, bandId);
        refund = eband.getTotal();
        
        ebandHandler.removeEband(bandId);
        
        return refund;
    }

       @Override
    public List<Integer> getBands() {
        return bands;
    }

       @Override
    public void setBands(List<Integer> bands) {
        this.bands = bands;
    }

    @Remove
       @Override
    public void remove() {
        bands.clear();
    }

    
   
    
    
}
