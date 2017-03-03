/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;


import java.util.logging.Level;
import java.util.logging.Logger;
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Janakshi
 */
@Stateful(mappedName = "lockerreservationfacade")
public class LockerReservationFacade implements LockerReservationFacadeRemote {
        

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

	@Remove
    @Override
    public void remove() {        
    }
    
}
