/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.photos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import lk.megafundtpark.remote.exceptions.RemoteException;
import lk.megafundtpark.remote.interfaces.EbandsFacadeRemote;
import lk.megafundtpark.remote.interfaces.PayeditemsFacadeRemote;
import lk.megafundtpark.remote.interfaces.PhotosFacadeRemote;

/**
 *
 * @author Janakshi
 */
public abstract class PhotoInteractionServlet extends HttpServlet {

  public static final String SESSION_PARAM_PHOTO= "photo";
    
    
    protected static PhotosFacadeRemote remotephoto;
    protected static EbandsFacadeRemote remoteband;
    protected static PayeditemsFacadeRemote remoteitem;

    @Override
    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            remotephoto = (PhotosFacadeRemote) context.lookup("photosfacade");
            remoteband = (EbandsFacadeRemote)context.lookup("ebandsfacade");
            remoteitem = (PayeditemsFacadeRemote)context.lookup("payeditemsfacade");
        } catch (Exception e) {
            System.err.println("Error in initializing the PhotoInteractionServlet");
            e.printStackTrace();
            throw new RemoteException("PhotoInteractionServlet");   
        }
    }
}
