/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.AdminDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface AdminsFacadeRemote {

    public void updatePassword(String username, String oldPassword, String newPassword);

    public AdminDetails getAdmin(String userid);

    public boolean isLoginValied(String userid, String password);

    public void createAdmin(AdminDetails details);

    public void editAdmin(AdminDetails details);

    public void removeAdmin(String id);

    public AdminDetails find(Object pk);

    public List findAll();

    public void persist(Object object);
    
}
