/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.tickets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.AdminDetails;
import lk.megafundtpark.remote.utils.CustomerDetails;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.TicketDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "IssueTicketServlet", urlPatterns = {"/IssueTicketServlet"})
public class IssueTicketServlet extends TicketInteractionServlet{

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
          Date today = new Date( );
          final int aPrice = 500;
          final int cPrice = 250;
          CustomerDetails customer;
          EbandDetails band;
          TicketDetails ticket;
          AdminDetails admin =(AdminDetails) session.getAttribute("user");
          ArrayList<EbandDetails> ebands = new ArrayList<EbandDetails>(); //Current customer's ebands
          ArrayList<EbandDetails> ebandList; // Whole session's ebands
          if(session.getAttribute("ebandList")== null){
             ebandList  = new ArrayList<EbandDetails>(); 
          }
          else{
             ebandList = (ArrayList<EbandDetails>) session.getAttribute("ebandList"); 
          }
           
        
        if(request.getParameter("adult") != null && request.getParameter("child")!= null && request.getParameter("name") != null && request.getParameter("email") !=null){
               int adult = Integer.parseInt(request.getParameter("adult"));
               int child = Integer.parseInt(request.getParameter("child"));
               String name = request.getParameter("name");
               String email = request.getParameter("email"); 

               if(remoteCustomer.getCustomer(email, name)== null){
               //Creating a customer
                   customer= new CustomerDetails(name,email);            
                   remoteCustomer.createCustomer(customer);           
               }

               customer = remoteCustomer.getCustomer(email, name);

              //Creating tickets
               for(int i=0;i<adult;i++){
                   ticket= new TicketDetails("adult", today, 500 ,admin.getUserid(), customer.getCustomerid());
                   remoteTicket.createTicket(ticket);
               }
               for(int i=0;i<child;i++){
                   ticket= new TicketDetails("child", today, 250,admin.getUserid(), customer.getCustomerid());
                   remoteTicket.createTicket(ticket);
               }

               List<TicketDetails> tlist=remoteTicket.getTickets(customer.getCustomerid(), today);

               //Creating e-bands
               for(TicketDetails t1 : tlist){
                   band= new EbandDetails(100,t1.getTicketid());
                   remoteBand.createEband(band);

               }

               for(TicketDetails t2 : tlist){
                   band= remoteBand.getEband(t2.getTicketid());
                   ebands.add(band); 
                   ebandList.add(band);
               }
               session.setAttribute("issueStatus", "1");
               session.setAttribute("ebands", ebands);
               session.setAttribute("ebandList", ebandList);

               RequestDispatcher rd = request.getRequestDispatcher("tickets.jsp");
               rd.forward(request, response);
        }
        else{
             session.setAttribute("issueStatus", "3");
            
            RequestDispatcher rd = request.getRequestDispatcher("tickets.jsp");
            rd.forward(request, response);
        }
    }

   

}
