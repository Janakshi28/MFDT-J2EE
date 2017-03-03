/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.events;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.AdminDetails;
import lk.megafundtpark.remote.utils.CustomerDetails;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.EventDetails;
import lk.megafundtpark.remote.utils.TicketDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "AddEventServlet", urlPatterns = {"/AddEventServlet"})
public class AddEventServlet extends EventInteractionServlet {

   

   

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
          Date today = new Date( );         
          CustomerDetails customer;
          EbandDetails band;
          AdminDetails admin =(AdminDetails) session.getAttribute("user");
          
           if(request.getParameter("park") != null && request.getParameter("title")!= null && request.getParameter("start") != null && request.getParameter("end") !=null){
             try {
                 String park = request.getParameter("park").toString();
                 String title = request.getParameter("title");
                 String start = request.getParameter("start")+":00";
                 String end = request.getParameter("end")+":00";
                 DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                 Date sTime = formatter.parse(start);
                 Date eTime= formatter.parse(end);
                 //String title, String park, Date starttime, Date endtime, Date dateadded, String adminId
                 EventDetails event = new EventDetails(title,park,sTime,eTime,today,admin.getUserid());
                 remoteevent.createEvent(event); 
                 
                    
                    session.setAttribute("event", event);
                 
             } catch (ParseException ex) {
                 Logger.getLogger(AddEventServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
               session.setAttribute("eStatus", "1");
               session.setAttribute("msg1", "Adding Success!!");
               session.setAttribute("msg2", "New Event has been added..");
               request.setAttribute("page", "addE");
               RequestDispatcher rd = request.getRequestDispatcher("myAccount.jsp");
               rd.forward(request, response);
           }else{
               session.setAttribute("eStatus", "2");
               session.setAttribute("msg1", "Adding Failed!!.. Try again...");
               session.setAttribute("msg2", "Enter data for all the fields..");
               request.setAttribute("page", "addE");
               RequestDispatcher rd = request.getRequestDispatcher("myAccount.jsp");
               rd.forward(request, response);
           }
    }

   

}
