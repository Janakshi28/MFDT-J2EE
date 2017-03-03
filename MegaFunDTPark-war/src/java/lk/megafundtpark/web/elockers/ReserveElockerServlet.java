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
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;
import lk.megafundtpark.remote.utils.ElockerDetails;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

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
	    LockerReservationFacadeRemote remotereservation = (LockerReservationFacadeRemote) request.getSession().getAttribute(LOCKERS_SESSION_KEY);
            if(remotereservation== null){
               // EJB is not yet in the HTTP session
              // This means that the client just sent his first request
              // We obtain a LockerReservationFacade instance and add it to the session object.
               try{
                    InitialContext ic = new InitialContext();

                    remotereservation = (LockerReservationFacadeRemote) ic.lookup("java:global/MegaFunDTPark-ejb/LockerReservationFacade!"
                            +"lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote");
                    request.getSession().setAttribute(LOCKERS_SESSION_KEY,remotereservation);

                    System.out.println("elockerReservation set is created");


                }catch(NamingException e){
                    throw new ServletException(e);
                }
            
            
            }
            
          
         if(request.getParameter("bandid") != null && request.getParameter("lockerNo")!= null ){
               int bandid = Integer.parseInt(request.getParameter("bandid"));
            int lNo = Integer.parseInt(request.getParameter("lockerNo"));
            
            EbandDetails band;
            band = remoteband.readEband(bandid);
            
            ElockerDetails locker = remotelocker.getElocker(lNo);
             
            String size=locker.getSize();
            locker.setEbandId(bandid);
            locker.setIsoccupied(Boolean.TRUE);
            int total=band.getTotal();
            if(remotereservation.getReservedLockerList(request.getParameter("bandid"))!=null){
                total-=20;
                System.out.println(total);
                //String type, int amount, int noofitems, int ebandId, int payablesId
                PayedItemDetails payment= new PayedItemDetails("Locker-Reuse",20,1,bandid,25);
                int pay=20;
                remoteitem.createPayedItem(payment);  
                band.setTotal(total);
                remoteband.editEband(band);   
                session.setAttribute("msg2", "The locker "+lNo+" has been reserved and the payment was Rs. "+pay+".00.");
            }
            else{
                System.out.println(locker.getSize());
                if("Small".equals(size)){
                    total-=40;
                    System.out.println(total);
                    PayedItemDetails payment= new PayedItemDetails("Small Locker-Reservation",40,1,bandid,24);
                    int pay=40;
                    remoteitem.createPayedItem(payment);  
                    band.setTotal(total);
                    remoteband.editEband(band);   
                    session.setAttribute("msg2", "The locker "+lNo+" has been reserved and the payment was Rs. "+pay+".00.");
                }
                else if("Large".equals(size)){
                    total-=60;
                    System.out.println(total);
                    PayedItemDetails payment= new PayedItemDetails("Large Locker-Reservation",60,1,bandid,23);
                    int pay=60;
                    remoteitem.createPayedItem(payment);  
                    band.setTotal(total);
                    remoteband.editEband(band);       
                    session.setAttribute("msg2", "The locker "+lNo+" has been reserved and the payment was Rs. "+pay+".00.");
                }
            }
            remotelocker.editElocker(locker);
            remotereservation.reserveLocker(request.getParameter("bandid"), request.getParameter("lockerNo"));               
               session.setAttribute("lStatus", "1");
               session.setAttribute("msg1", "Reservation Success!!");
               
               request.setAttribute("page", "reserve");
          }else{
                  session.setAttribute("lStatus", "2");
                session.setAttribute("msg1", "Reservation Failed!!");
                session.setAttribute("msg2","Please check the data fields for correctness");
                request.setAttribute("page", "reserve");
           }
           
            
            RequestDispatcher rd = request.getRequestDispatcher("elockerReservations.jsp");
            rd.forward(request, response);

    }


}
