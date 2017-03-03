/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.admins;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.interfaces.AdminsFacadeRemote;
import lk.megafundtpark.remote.exceptions.RemoteException;

/**
 *
 * @author Janakshi
 */
public abstract class AdminInteractionServlet extends HttpServlet {

public static final String SESSION_PARAM_ADMIN= "admin";
    
    
    protected static AdminsFacadeRemote remote;

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remote = (AdminsFacadeRemote) context.lookup("adminsfacade");
        } catch (Exception e) {
            System.err.println("Error in initializing the AdminsFacadeRemote");
            e.printStackTrace();
            throw new RemoteException("AdminsFacadeRemote");   
        }
    }

}
