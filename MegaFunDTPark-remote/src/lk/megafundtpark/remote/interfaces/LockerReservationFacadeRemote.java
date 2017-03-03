/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Janakshi
 */
@Remote
public interface LockerReservationFacadeRemote {

    public void persist(Object object);

    public void addNewReservation(String lockerId);

    public void addNewReservation(String bandId, String lockerId);

    public void reserveLocker(String bandId, String lockerId);

    public void clearLocker(String bandId, String lockerId);

    public List<String> getReservedLockerList(String bandId);

    public void removeEBand(String bandId);

    public int getLockersPerEBand(String bandId);

    public int getAllReservedLockerCounter();
	
    public void remove();
    
}
