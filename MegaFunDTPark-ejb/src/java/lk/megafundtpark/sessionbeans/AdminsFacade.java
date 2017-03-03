/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.AdminsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Admins;
import lk.megafundtpark.remote.utils.AdminDetails;

/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "adminsfacade")
public class AdminsFacade implements AdminsFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
   
    
    @Override
     public boolean isLoginValied(String userid, String password) {
        try {
            Admins admin = em.find(Admins.class, userid);
            if (admin == null) {
                return false;
            } else return userid.equals(admin.getUserid())
                    && password.equals(admin.getPassword());
        } catch (Exception e) {
            return false;
        }
    }
     
    
    @Override
     public void updatePassword(String username, String oldPassword, String newPassword) {

    }
     
     private List<AdminDetails> copyToAdminDetails(List< Admins> admins) {
        List<AdminDetails> adminList = new ArrayList<AdminDetails>();
        Iterator i = admins.iterator();
        while (i.hasNext()) {
            Admins admin = (Admins) i.next();
            AdminDetails details = new AdminDetails(admin.getUserid(),
            admin.getPassword(), admin.getName(), admin.getRole());
            adminList.add(details);
        }
        return adminList;
    }
    
    private AdminDetails copyToAdminDetails(Admins admin) {
        return new AdminDetails(admin.getUserid(),admin.getPassword(), admin.getName(), admin.getRole());
    }
    
    @Override
    public AdminDetails getAdmin(String userid) {
        try {
            AdminDetails admin = this.copyToAdminDetails(em.find(Admins.class, userid));
            admin.setPassword(null);
            return admin;
        } catch (Exception e) {
            return null;
        }
    }
     
    @Override
    public void createAdmin(AdminDetails details) {
        try {
            Admins acct = new Admins(details.getUserid(), details.getPassword(), details.getName(), details.getRole());
            em.persist(acct);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editAdmin(AdminDetails details) {
        try {
            Admins acct = new Admins(details.getUserid(), details.getPassword(), details.getName(), details.getRole());
            em.merge(acct);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removeAdmin(String id) {
        try {
            Admins a = em.find(Admins.class, id);
            em.remove(a);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public AdminDetails find(Object pk) {
        Admins admin= em.find(Admins.class, pk);
        return new AdminDetails(admin.getUserid(),admin.getPassword(), admin.getName(), admin.getRole());
    }
    
    @Override
    public List findAll() {
        return copyToAdminDetails(em.createQuery("select object(o) from Admins as o").getResultList());
    }

   
}
