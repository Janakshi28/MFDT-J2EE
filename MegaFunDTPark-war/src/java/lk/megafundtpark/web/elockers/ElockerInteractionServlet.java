/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.elockers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.exceptions.RemoteException;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.ElockersFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;

/**
 *
 * @author Janakshi
 */
public abstract class ElockerInteractionServlet extends HttpServlet {
    
    public static final String SESSION_PARAM_ADMIN= "locker";
    
    protected static ElockersFacadeRemote remotelocker;
    protected static EbandsFacadeRemote remoteband;
    protected static PayeditemsFacadeRemote remoteitem;
    protected static LockerReservationFacadeRemote remotereservation;
   
    

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remotelocker = (ElockersFacadeRemote) context.lookup("elockersfacade");
            remoteband = (EbandsFacadeRemote)context.lookup("ebandsfacade");
            remoteitem = (PayeditemsFacadeRemote)context.lookup("payeditemsfacade");
            remotereservation = (LockerReservationFacadeRemote) context.lookup("lockerreservationfacade");
        } catch (Exception e) {
            System.err.println("Error in initializing the ElockerInteractionServlet");
            e.printStackTrace();
            throw new RemoteException("ElockerInteractionServlet");   
        }
    }

    

   

}
