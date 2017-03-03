/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.PayablesDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface EPaymentFacadeRemote {

    public void persist(Object object);

    public void payForAnItem(PayablesDetails item, EbandDetails band, int amount);

    public void undoPayment(PayedItemDetails payItem, EbandDetails band);

    public int clearEband(int bandId);

    public List<PayedItemDetails> getPaymentsOfOne(List<Integer> list, int id);

    public List<Integer> getBands();

    public void setBands(List<Integer> bands);

    public void addToPayments(int bandId);

    public void remove();


    
}
