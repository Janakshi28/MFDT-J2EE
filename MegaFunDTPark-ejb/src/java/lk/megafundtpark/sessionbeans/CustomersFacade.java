/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.CustomersFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Customers;
import lk.megafundtpark.remote.utils.CustomerDetails;

/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "customersfacade")
public class CustomersFacade implements CustomersFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    private List<CustomerDetails> copyToCustomerDetails(List< Customers> customers) {
        List<CustomerDetails>  customerList = new ArrayList<CustomerDetails>();
        Iterator i =  customers.iterator();
        while (i.hasNext()) {
            Customers customer = (Customers) i.next();
            CustomerDetails details = new CustomerDetails(customer.getCustomerid(),
            customer.getName(), customer.getEmail());
            customerList.add(details);
        }
        return customerList;
    }
    
    private CustomerDetails copyToCustomerDetails(Customers customer) {
        return new CustomerDetails(customer.getCustomerid(), customer.getName(), customer.getEmail());
    }
    
    @Override
    public CustomerDetails getCustomer(String email, String name) {
        try {
            
             List<Customers> results = em.createNamedQuery("Customers.findByEmail", Customers.class)
                    .setParameter("email", email)
                    .getResultList();
            if (results.isEmpty()) {
                return null;
            } else {
                for (Customers customer : results) {
                    if (name.equals(customer.getName()) && email.equals(customer.getEmail())) {
                        return copyToCustomerDetails(customer);
                    }
                }

                return null;
            }
           // return customer;
        } catch (Exception e) {
            return null;
        }
    }
    
    
     
    @Override
    public void createCustomer(CustomerDetails details) {
        try {
            Customers customer = new Customers(details.getName(), details.getEmail());
            em.persist(customer);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editCustomer(CustomerDetails details) {
        try {
            Customers customer = new Customers(details.getCustomerid(), details.getName(), details.getEmail());
            em.merge(customer);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removeCustomer(String id) {
        try {
            Customers customer = em.find(Customers.class, id);
            em.remove(customer);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public CustomerDetails find(Object pk) {
        Customers customer= em.find(Customers.class, pk);
        return new CustomerDetails(customer.getCustomerid(), customer.getName(), customer.getEmail());
    }
    
    @Override
    public List findAll() {
        return copyToCustomerDetails(em.createQuery("select object(o) from Customers as o").getResultList());
    }

}
