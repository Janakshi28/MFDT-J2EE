/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;


import javax.ejb.Remote;

/**
 *
 * @author Janakshi
 */
@Remote
public interface LockerReservationFacadeRemote {

    public void persist(Object object);
	
    public void remove();
    
}
