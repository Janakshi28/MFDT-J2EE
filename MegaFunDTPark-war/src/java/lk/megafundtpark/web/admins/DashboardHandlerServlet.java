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

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "DashboardHandlerServlet", urlPatterns = {"/DashboardHandlerServlet"})
public class DashboardHandlerServlet extends AdminInteractionServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          RequestDispatcher rd;
        String result = request.getParameter("page").toString();
        
       
            request.setAttribute("page", result);
             rd= request.getRequestDispatcher("myAccount.jsp");
             rd.forward(request, response);
    }

  
    

}
