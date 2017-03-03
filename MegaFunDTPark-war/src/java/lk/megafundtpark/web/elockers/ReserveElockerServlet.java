/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.elockers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.interfaces.EPaymentFacadeRemote;
import lk.megafundtpark.remote.utils.ElockerDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "ReserveElockerServlet", urlPatterns = {"/ReserveElockerServlet"})
public class ReserveElockerServlet extends ElockerInteractionServlet {
        private static final long serialVersionUID = 1L;
         private static final String LOCKERS_SESSION_KEY = "lockerReservations";
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        String result = request.getParameter("page").toString();
       if(remotelocker.getUnreserved()==null){
           
           request.setAttribute("page", result);
             rd= request.getRequestDispatcher("elockerReservations.jsp");
             rd.forward(request, response);
       }else{
            //request.setAttribute("lockers", lockers);   
            List<ElockerDetails> lockers=remotelocker.getUnreserved();
            request.setAttribute("lockers", lockers);
            request.setAttribute("page", result);
             rd= request.getRequestDispatcher("elockerReservations.jsp");
             rd.forward(request, response);
       }
        
           
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			HttpSession session = request.getSession();
			//To be implemented
           
            
            RequestDispatcher rd = request.getRequestDispatcher("elockerReservations.jsp");
            rd.forward(request, response);

    }


}
