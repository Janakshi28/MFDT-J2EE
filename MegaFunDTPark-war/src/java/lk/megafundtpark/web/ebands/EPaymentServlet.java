/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.ebands;

import java.io.IOException;
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
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "EPaymentServlet", urlPatterns = {"/EPaymentServlet"})
public class EPaymentServlet extends EbandInteractionServlet {
   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       
        if(request.getParameter("bandid") != null && request.getParameter("item")!= null&& request.getParameter("noOfItems")!= null){
            int bandId= Integer.parseInt(request.getParameter("bandid"));
            int noOfItems= Integer.parseInt(request.getParameter("noOfItems"));
            String type=request.getParameter("type");
            String item=request.getParameter("item");
            int price=remotepayable.getPrice(type, item);
            int total=0;
            EbandDetails eband = remoteBand.readEband(bandId);
            total=eband.getTotal();
            total-=price*noOfItems;
            eband.setTotal(total);
            remoteBand.editEband(eband);
            //(String type, int amount, int noofitems, int ebandId, int payablesId)
            //System.out.println(remotepayable.getPayable(type, item).getId());
            remoteitem.createPayedItem(new PayedItemDetails(type,price,noOfItems,bandId,12));
             session.setAttribute("bStatus", "1");
             request.setAttribute("fee", price*noOfItems);
            
        }
        else{
            session.setAttribute("bStatus", "2");
             
        }
        RequestDispatcher rd = request.getRequestDispatcher("foodStall.jsp");
       rd.forward(request, response);
    }


}
