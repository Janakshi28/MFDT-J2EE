/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.tickets;

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
import lk.megafundtpark.remote.interfaces.LockerReservationFacadeRemote;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.ElockerDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;
import lk.megafundtpark.remote.utils.PhotoDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends TicketInteractionServlet {
    private static final long serialVersionUID = 1L;
         private static final String LOCKERS_SESSION_KEY = "lockerReservations";
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         EbandDetails band;
         LockerReservationFacadeRemote remotereservation = (LockerReservationFacadeRemote) request.getSession().getAttribute(LOCKERS_SESSION_KEY);
            if(remotereservation== null){
                // EJB is not yet in the HTTP session
              // This means that the client just sent his first request
              // We obtain a ELockerReservationFacade instance and add it to the session object.
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
            
          if(request.getParameter("bandid") != null ){
              int id= Integer.parseInt(request.getParameter("bandid"));
              if(remotelocker.getBandReserved(id)!=null){
                  List<ElockerDetails> lockers = remotelocker.getBandReserved(id);
                  for(ElockerDetails locker:lockers){
                      locker.setIsoccupied(Boolean.FALSE);
                      locker.setEbandId(0);
                      
                      remotelocker.editElocker(locker);
                  }
              }
               if(remoteitem.getPaymentList(id)!=null){
                  List<PayedItemDetails> items = remoteitem.getPaymentList(id);
                  for(PayedItemDetails item: items){
                            remoteitem.removePayedItem(item.getId());
                  }
              }
                if(remotephoto.getPhotoList(id)!=null){
                  List<PhotoDetails> photos = remotephoto.getPhotoList(id);
                  for(PhotoDetails pic: photos){
                           remotephoto.removePhoto(pic.getPhotoid());
                  }
              }
            remotereservation.removeEBand(id+"");
            int total=remoteBand.readEband(id).getTotal();
           remoteBand.removeEband(id);
           session.setAttribute("cStatus", "1"); 
           request.setAttribute("refund", total); 
            RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
            rd.forward(request, response);
          }else{
             session.setAttribute("cStatus", "2");
             
            
            RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
            rd.forward(request, response);
        }
        

    }


}
