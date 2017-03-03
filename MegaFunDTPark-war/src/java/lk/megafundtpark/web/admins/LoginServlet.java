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
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.AdminDetails;
import static lk.megafundtpark.web.admins.AdminInteractionServlet.remote;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AdminInteractionServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       final HttpSession session = request.getSession();
        final String userid = request.getParameter("id");
        final String password = request.getParameter("password");

        if (remote.isLoginValied(userid, password)) {
            
            final AdminDetails adminDetails = remote.getAdmin(userid);

            if (adminDetails.getName() == null || adminDetails.getName().length() == 0) {
                adminDetails.setName(userid);
            }
            session.setAttribute("loginStatus", "1");
            session.setAttribute("user", adminDetails);
            
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);

        } else {
            session.setAttribute("loginStatus", "2");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

        
    }



}
