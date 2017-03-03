/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface PayeditemsFacadeRemote {

    public void persist(Object object);

    public PayedItemDetails getPayedItem(Integer id);

    public void createPayedItem(PayedItemDetails details);

    public void editPayedItem(PayedItemDetails details);

    public void removePayedItem(Integer id);

    public PayedItemDetails find(Object pk);

    public List findAll();

    public List<PayedItemDetails> getPaymentList(int bandId);
    
}
