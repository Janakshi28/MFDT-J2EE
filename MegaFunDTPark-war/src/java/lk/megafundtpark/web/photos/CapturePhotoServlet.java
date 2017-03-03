/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.web.photos;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.megafundtpark.remote.utils.EbandDetails;
import lk.megafundtpark.remote.utils.PayedItemDetails;
import lk.megafundtpark.remote.utils.PhotoDetails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Janakshi
 */
@WebServlet(name = "CapturePhotoServlet", urlPatterns = {"/CapturePhotoServlet"})
public class CapturePhotoServlet extends PhotoInteractionServlet {

   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String folderPath = "F:\\Educational\\EAJEECB005871\\MegaFunDTParkEE\\MegaFunDTPark-war\\web\\photoUploads\\";
        int bandId = 0;//;
        int total=0;
        int fee=0;
        boolean isEnlarged = true;
        boolean isFramed =true; 
        boolean isEdited = true;
        String payment = "xxx";
        String fileName="xxx.txt";
        RequestDispatcher rd;
          
        
         File file ;
            int   maxRequestSize=1024*1024*50;
            int maxFileSize = 1024 * 1024*10;
            int maxMemSize = 5000 * 1024;
        
        String contentType = req.getContentType();
            if ((contentType.indexOf("multipart/form-data") >= 0)) {

               DiskFileItemFactory factory = new DiskFileItemFactory();
               factory.setSizeThreshold(maxMemSize);
               factory.setRepository(new File("c:\\temp"));
               ServletFileUpload upload = new ServletFileUpload(factory);
               upload.setSizeMax( maxFileSize );
               
               try{ 
                  List fileItems = upload.parseRequest(req);
                  Iterator i = fileItems.iterator();
                  //out.println("<html>");
                  //out.println("<body>");
                  while ( i.hasNext () ) 
                  {
                     FileItem fi = (FileItem)i.next();
                     if(fi.isFormField ()){
                         String name = fi.getFieldName();//text1
                        
                         if(name.equals("bandid")){
                             bandId= Integer.parseInt(fi.getString());
                         }
                         else if(name.equals("frame")){
                             isFramed= Boolean.parseBoolean(fi.getString());
                         }
                         else if(name.equals("enlarge")){
                             isEnlarged= Boolean.parseBoolean(fi.getString());
                         }
                         else if(name.equals("edit")){
                             isEdited= Boolean.parseBoolean(fi.getString());
                         }
                         
                     }
                     else if ( !fi.isFormField () )  {
                         String fieldName = fi.getFieldName();
                         fileName = fi.getName();
                         boolean isInMemory = fi.isInMemory();
                         long sizeInBytes = fi.getSize();
                         
                         // Write the file
                         if( fileName.lastIndexOf("\\") >= 0 ){
                            file = new File( folderPath + 
                            fileName.substring( fileName.lastIndexOf("\\"))) ;
                         }else{
                            file = new File( folderPath + 
                            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                         }
                            fi.write( file );
                            req.setAttribute("fPath",folderPath);
                            req.setAttribute("fName",fileName);
                      
                     }
                       
                  }
                   remotephoto.createPhoto(new PhotoDetails(isFramed,isEnlarged,isEdited,fileName,bandId));
                        EbandDetails band = remoteband.readEband(bandId);
                        total= band.getTotal();
                        if(isEdited==true){
                            //String type, int amount, int noofitems, int ebandId, int payablesId
                            remoteitem.createPayedItem(new PayedItemDetails("Photo Edit",50,1,bandId,4));
                            total-= 50;
                            fee+= 50;
                        }
                        if(isEnlarged==true){
                            remoteitem.createPayedItem(new PayedItemDetails("Photo Enlarge",50,1,bandId,3));
                            total-= 50;
                            fee+= 50;
                        }
                         if(isFramed==true){
                             remoteitem.createPayedItem(new PayedItemDetails("Photo Frame",150,1,bandId,2));
                            total-= 150;
                            fee+= 150;
                        } 
                         remoteitem.createPayedItem(new PayedItemDetails("Photo",75,1,bandId,1));
                         //Boolean isframed, Boolean isenlarged, Boolean isedited, String pic, int ebandId
                         
                         total-=75;
                         fee+= 75;
                         remoteband.editEband(band);
                  
                 
                           
                            
                  //out.println("</body>");
                  //out.println("</html>");
                }catch(Exception ex) {
                   System.out.println(ex);
                }
                            session.setAttribute("uStatus", 1);
                            session.setAttribute("url", "photoUploads/"+fileName);
                            session.setAttribute("fee", fee);
                            session.setAttribute("total", total);
                            req.setAttribute("page", "capture");                           
                           rd= req.getRequestDispatcher("photoStall.jsp");
                           rd.forward(req, resp);
             }else{
                     session.setAttribute("uStatus", 2);
                     req.setAttribute("page", "capture");    
                    rd= req.getRequestDispatcher("photoStall.jsp");
                    rd.forward(req, resp);
            }    

    }


}
