/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.PayablesDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface PayablesFacadeRemote {

    public void persist(Object object);

    public PayablesDetails getPayableItem(String id);

    public void createPayableItem(PayablesDetails details);

    public void editPayableItem(PayablesDetails details);

    public void removePayableItem(String id);

    public PayablesDetails find(Object pk);

    public List findAll();

    public int getPrice(String type, String title);

    public PayablesDetails getPayable(String type, String title);
    
}
