/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.events;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.exceptions.RemoteException;
import lk.megafundtpark.remote.interfaces.AdminsFacadeRemote;
import lk.megafundtpark.remote.interfaces.EventsFacadeRemote;

/**
 *
 * @author Janakshi
 */
public abstract class EventInteractionServlet extends HttpServlet {

   public static final String SESSION_PARAM_ADMIN= "event";
    
    protected static EventsFacadeRemote remoteevent;
    protected static AdminsFacadeRemote remoteadmin;
   
    

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remoteevent = (EventsFacadeRemote) context.lookup("eventsfacade");
            remoteadmin = (AdminsFacadeRemote) context.lookup("adminsfacade");
        } catch (Exception e) {
            System.err.println("Error in initializing the EventInteractionServlet");
            e.printStackTrace();
            throw new RemoteException("EventInteractionServlet");   
        }
    }

}
