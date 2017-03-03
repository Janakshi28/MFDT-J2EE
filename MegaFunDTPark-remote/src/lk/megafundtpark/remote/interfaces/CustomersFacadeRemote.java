/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.CustomerDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface CustomersFacadeRemote {

    public void persist(Object object);

    public void createCustomer(CustomerDetails details);

    public void editCustomer(CustomerDetails details);

    public void removeCustomer(String id);

    public CustomerDetails find(Object pk);

    public List findAll();

    public CustomerDetails getCustomer(String email, String name);
    
}
