/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.ebands;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.exceptions.RemoteException;
import lk.megafundtpark.remote.interfaces.EPaymentFacadeRemote;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayablesFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;

/**
 *
 * @author Janakshi
 */
public abstract class EbandInteractionServlet extends HttpServlet {

   public static final String SESSION_PARAM_ADMIN= "eband";
    
    protected static EbandsFacadeRemote remoteBand;
    protected static EPaymentFacadeRemote remotepayment;
    protected static PayablesFacadeRemote remotepayable;
    protected static PayeditemsFacadeRemote remoteitem;
   
    

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remotepayment = (EPaymentFacadeRemote) context.lookup("epaymentfacade");
            remoteBand = (EbandsFacadeRemote) context.lookup("ebandsfacade");
            remotepayable = (PayablesFacadeRemote) context.lookup("payablesfacade");
            remoteitem = (PayeditemsFacadeRemote) context.lookup("payeditemsfacade");
        } catch (Exception e) {
            System.err.println("Error in initializing the EbandInteractionServlet");
            e.printStackTrace();
            throw new RemoteException("EbandInteractionServlet");   
        }
    }

}
