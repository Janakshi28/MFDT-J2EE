/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.elockers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.ElockerDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;
import static lk.megafundtpark.web.elockers.ElockerInteractionServlet.remotelocker;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "ClearElockerServlet", urlPatterns = {"/ClearElockerServlet"})
public class ClearElockerServlet extends ElockerInteractionServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher rd;
        String result = request.getParameter("page").toString();
       if(remotelocker.getReserved()==null){
           System.out.println("HI HI HI NULL");
           request.setAttribute("page", result);
             rd= request.getRequestDispatcher("elockerReservations.jsp");
             rd.forward(request, response);
       }else{
            //request.setAttribute("lockers", lockers);   
            List<ElockerDetails> lockers=remotelocker.getReserved();
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
         if(request.getParameter("bandid") != null && request.getParameter("lockerNo")!= null ){
               int bandid = Integer.parseInt(request.getParameter("bandid"));
            int lNo = Integer.parseInt(request.getParameter("lockerNo"));
            
            //EbandDetails band;
            //band = remoteband.readEband(bandid);
            //System.out.println("TT"+band.getTicketId());
             ElockerDetails locker = remotelocker.getElocker(lNo);
             System.out.println("LL"+locker.getSize());
             String size=locker.getSize();
             locker.setEbandId(0);
             locker.setIsoccupied(Boolean.FALSE);
           // int total=band.getTotal();
                            
            
            remotelocker.editElocker(locker);
                        
               session.setAttribute("lStatus", "1");
               session.setAttribute("lNo", lNo);
               
               request.setAttribute("page", "clear");
          }else{
                  session.setAttribute("lStatus", "2");
                request.setAttribute("page", "clear");
           }
         RequestDispatcher rd = request.getRequestDispatcher("elockerReservations.jsp");
            rd.forward(request, response);
    }

   

}
