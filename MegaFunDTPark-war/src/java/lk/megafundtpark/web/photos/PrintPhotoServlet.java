/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.photos;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.PhotoDetails;

/**
 *
 * @author Janakshi
 */
@WebServlet(name = "PrintPhotoServlet", urlPatterns = {"/PrintPhotoServlet"})
public class PrintPhotoServlet extends PhotoInteractionServlet {
     static final long serialVersionUID = 1L;
        private static final int BUFSIZE = 4096;
        private String filePath;

        public void init() {
            // the file data.xls is under web application folder
            filePath = "F:\\Educational\\EAJEECB005871\\MegaFunDTParkEE\\MegaFunDTPark-war\\web\\photoUploads\\";
        }
        
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         HttpSession session = req.getSession();
         RequestDispatcher rd;
        int bandId= Integer.parseInt(req.getParameter("bandid"));
        session.setAttribute("bandId", bandId);
        
        List<String> photos= new ArrayList<String>();
        List<PhotoDetails>picList =remotephoto.getPhotoList(bandId);
        for(PhotoDetails p: picList){
            photos.add("photoUploads/"+p.getPic());
        }
        session.setAttribute("photos", photos);
        session.setAttribute("pStatus", "1");
        req.setAttribute("page", "print");
        rd= req.getRequestDispatcher("photoStall.jsp");
        rd.forward(req, resp);
    }
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         HttpSession session = req.getSession();
          System.out.println(filePath);
        //retrieving the parameter by its name
        String fileName = req.getParameter("url").toString().substring(12); //this will return `data.xls`
        String folder= "photoUploads";
        System.out.println(fileName);
        //using the File(parent, child) constructor for File class
        String fullPath="xxxx";
        fullPath = ""+filePath;
        File file = new File(fullPath, fileName);
        //verify if the file exists
        int length   = 0;
        ServletOutputStream outStream = resp.getOutputStream();
        ServletContext context  = getServletConfig().getServletContext();
        String mimetype = context.getMimeType(fullPath);

        // sets response content type
        if (mimetype == null) {
            mimetype = "application/octet-stream";
        }
        resp.setContentType(mimetype);
        resp.setContentLength((int)file.length());
        
        // sets HTTP header
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        byte[] byteBuffer = new byte[BUFSIZE];
        DataInputStream in = new DataInputStream(new FileInputStream(file));

        // reads the file's bytes and writes them to the response stream
        while ((in != null) && ((length = in.read(byteBuffer)) != -1))
        {
            outStream.write(byteBuffer,0,length);
        }

        in.close();
        outStream.close();

    }

    

}
