/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.ElockersFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayablesFacadeRemote;

/**
 *
 * @author Janakshi
 */
@Stateful(mappedName = "lockerreservationfacade")
public class LockerReservationFacade implements LockerReservationFacadeRemote {
    private EbandsFacadeRemote bandHandler;
    private ElockersFacadeRemote lockersHandler;
    private PayablesFacadeRemote payableHandler;
    

    private HashMap<String, List<String>> lockerInfo= null;    

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @PostConstruct
    private void initializeBean() {
        lockerInfo = new HashMap<>();
        try {
            InitialContext ic = new InitialContext();
            bandHandler = (EbandsFacadeRemote) ic.lookup("ebandsfacade");
            lockersHandler = (ElockersFacadeRemote) ic.lookup("elockersfacade");
            payableHandler= (PayablesFacadeRemote)ic.lookup("payablesfacade");
        } catch (NamingException ex) {
            Logger.getLogger(LockerReservationFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
	
    @Override
    public void addNewReservation(String lockerId) {
        lockerInfo.put(lockerId, new ArrayList<String>());
    }

    @Override
    public void addNewReservation(String bandId, String lockerId) {
        List<String> list = new ArrayList<>();
        list.add(lockerId);
        lockerInfo.put(bandId, list);
    }

    @Override
    public void reserveLocker(String bandId, String lockerId) {
        List<String> lockerList = lockerInfo.get(bandId);
        if (lockerList == null) {
            this.addNewReservation(bandId, lockerId);
        } else {
            lockerList.add(lockerId);
            lockerInfo.put(bandId, lockerList);
        }
    }

    @Override
    public void clearLocker(String bandId, String lockerId) {
        List<String> lockerList = lockerInfo.get(bandId);
        if (lockerList != null) {
            lockerList.remove(lockerId);
            lockerInfo.put(bandId, lockerList);
        }
    }
    
    
    @Override
    public List<String> getReservedLockerList(String bandId) {
        return lockerInfo.get(bandId);
    }

    @Override
    public void removeEBand(String bandId) {
        lockerInfo.remove(bandId);
    }

    
    @Override
    public int getLockersPerEBand(String bandId) {
        List<String> lockers = lockerInfo.get(bandId);
        if (lockers != null) {
            return lockers.size();
        } else {
            return 0;
        }
    }
    
    @Override
    public int getAllReservedLockerCounter() {
        int lockerNumber = 0;
        Set<String> keys = lockerInfo.keySet();
        for(String key : keys) {
            lockerNumber += lockerInfo.get(key).size();
        }
        
        return lockerNumber;
    }

    @Remove
    @Override
    public void remove() {
	lockerInfo.clear();
        lockerInfo = null;
    }
    
}
