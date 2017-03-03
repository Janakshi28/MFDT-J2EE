/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.EbandDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface EbandsFacadeRemote {

    public void persist(Object object);

    public EbandDetails getEband(Integer ticketid);

    public void createEband(EbandDetails details);

    public void editEband(EbandDetails details);

    public void removeEband(Integer id);

    public EbandDetails find(Object pk);

    public List findAll();

    public EbandDetails readEband(Integer bandId);
    
}
