/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.ElockerDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface ElockersFacadeRemote {

    public void persist(Object object);

    public ElockerDetails getElocker(Integer lockerid);

    public void createElocker(ElockerDetails details);

    public void editElocker(ElockerDetails details);

    public void removeElocker(String id);

    public ElockerDetails find(Object pk);

    public List findAll();

    public List<ElockerDetails> getUnreserved();

    public List<ElockerDetails> getReserved();

    public List<ElockerDetails> getBandReserved(Integer bandid);
    
}
