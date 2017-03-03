/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.ebands;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import lk.megafundtpark.remote.utils.TicketDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "ReloadEbandServlet", urlPatterns = {"/ReloadEbandServlet"})
public class ReloadEbandServlet extends EbandInteractionServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
          EbandDetails band;
          int total=0;
          
        if(request.getParameter("bandid") != null && request.getParameter("amount")!= null ){
               int id = Integer.parseInt(request.getParameter("bandid"));
               int amount = Integer.parseInt(request.getParameter("amount"));
               

               if(remoteBand.readEband(id)== null){
                     session.setAttribute("reloadStatus", "2");
               }else{
                     band = remoteBand.readEband(id);
                     total=band.getTotal();
                     total+=amount;
                     band.setTotal(total);
                     remoteBand.editEband(band);
                     session.setAttribute("reloadStatus", "1");
                     request.setAttribute("amount", amount);
                     request.setAttribute("total", total);
               }

             

               RequestDispatcher rd = request.getRequestDispatcher("eBandReloads.jsp");
               rd.forward(request, response);
        }
        else{
             session.setAttribute("reloadStatus", "3");
            
            RequestDispatcher rd = request.getRequestDispatcher("eBandReloads.jsp");
            rd.forward(request, response);
        }
       
    }

    

}
