/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.admins;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends AdminInteractionServlet {
    private static final long serialVersionUID = 1L;
         private static final String LOCKERS_SESSION_KEY = "lockerReservations";

  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String logout = req.getParameter("logout");
        LockerReservationFacadeRemote remotereservation = (LockerReservationFacadeRemote) req.getSession().getAttribute(LOCKERS_SESSION_KEY);
        if(logout != null){
            if(remotereservation!= null){
                remotereservation.remove();
            }
            req.getSession().invalidate();
            
            //req.getSession().setAttribute("just_logged_out", "1");
            
        }
        
        RequestDispatcher dp = req.getRequestDispatcher("home.jsp");
        dp.forward(req, resp);
    }


}
