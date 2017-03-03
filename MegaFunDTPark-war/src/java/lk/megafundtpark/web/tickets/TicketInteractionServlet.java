/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.tickets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.exceptions.RemoteException;
import lk.megafundtpark.remote.interfaces.CustomersFacadeRemote;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.ElockersFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;
import lk.megafundtpark.remote.interfaces.PhotosFacadeRemote;
import lk.megafundtpark.remote.interfaces.TicketsFacadeRemote;

/**
 *
 * @author Janakshi
 */

public abstract class TicketInteractionServlet extends HttpServlet {
    public static final String SESSION_PARAM_ADMIN= "ticket";
    
    
    protected static TicketsFacadeRemote remoteTicket;
    protected static EbandsFacadeRemote remoteBand;
    protected static CustomersFacadeRemote remoteCustomer;
    protected static PayeditemsFacadeRemote remoteitem;
    protected static ElockersFacadeRemote remotelocker;
     protected static PhotosFacadeRemote remotephoto;
    

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remoteTicket = (TicketsFacadeRemote) context.lookup("ticketsfacade");
            remoteBand = (EbandsFacadeRemote) context.lookup("ebandsfacade");
            remoteCustomer= (CustomersFacadeRemote) context.lookup("customersfacade");
            remoteitem = (PayeditemsFacadeRemote) context.lookup("payeditemsfacade");
            remotelocker= (ElockersFacadeRemote) context.lookup("elockersfacade");
            remotephoto= (PhotosFacadeRemote) context.lookup("photosfacade");
            
        } catch (Exception e) {
            System.err.println("Error in initializing the TicketInteractionServlet");
            e.printStackTrace();
            throw new RemoteException("TicketInteractionServlet");   
        }
    }
   
}
