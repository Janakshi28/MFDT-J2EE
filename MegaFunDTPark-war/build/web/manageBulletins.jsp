<%-- 
    Document   : manageBulletins
    Created on : Jan 25, 2017, 2:36:10 PM
    Author     : Janakshi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/jpg" href="img/park logo.jpg"/>
        <title>Bulletins</title>
        <!--Styles-->
         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
          <!-- Tell the browser to be responsive to screen width -->
            <!-- Styles -->
                    <!-- Google Fonts -->
             <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
             <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
             <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

             <!-- Bootstrap -->
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

             <!-- Font Awesome -->
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

             <!-- Custom CSS -->
             <link rel="stylesheet" href="styles/products/owl.carousel.css">            
             <link rel="stylesheet" href="styles/products/style.css">
             <link rel="stylesheet" href="styles/products/responsive.css">
         
        <!-- Bootstrap 3.3.6 -->
        <link href="styles/adminLTE/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="styles/adminLTE/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <!-- iCheck -->
        <link href="styles/adminLTE/blue.css" rel="stylesheet" type="text/css"/>
         <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
         <link href="styles/adminLTE/_all-skins.min.css" rel="stylesheet" type="text/css"/>
        
         <!--Scripts-->
         <!-- jQuery 2.2.3 -->
            <script src="scripts/adminLTE/jquery-2.2.3.min.js" type="text/javascript"></script>
            <!-- Bootstrap 3.3.6 -->
            <script src="scripts/adminLTE/bootstrap.min.js" type="text/javascript"></script>
            <!-- iCheck -->
            <script src="scripts/adminLTE/icheck.min.js" type="text/javascript"></script>
            <script>
              $(function () {
                $('input').iCheck({
                  checkboxClass: 'icheckbox_square-blue',
                  radioClass: 'iradio_square-blue',
                  increaseArea: '20%' // optional
                });
              });
            </script>
            
            <!-- FastClick -->
            <script src="scripts/adminLTE/fastclick.js" type="text/javascript"></script>
            <!-- AdminLTE App -->
            <script src="scripts/adminLTE/app.min.js" type="text/javascript"></script>
            <!-- AdminLTE for demo purposes -->
            <script src="scripts/adminLTE/demo.js" type="text/javascript"></script>
            
            <!-- Latest jQuery form server -->
            <script src="https://code.jquery.com/jquery.min.js"></script>

            <!-- Bootstrap JS form CDN -->
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

            <!-- jQuery sticky menu -->
            <script src="scripts/products/owl.carousel.min.js"></script>
            <script src="scripts/products/jquery.sticky.js"></script>

            <!-- jQuery easing -->
            <script src="scripts/products/jquery.easing.1.3.min.js"></script>

            <!-- Main Script -->
            <script src="scripts/products/main.js"></script>
            
             <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
             <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
         
    </head>
    <body>
        <c:import url="header.jsp"/>   
        <div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <h2 class="section-title">Bulletins</h2>
            
            <div class="row">
                <div class="col-md-4">                    
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Water Park</h2>
                        <a href="" class="wid-view-more">Modify</a>
                        <table>
                            <tr>
                              <th>Event</th>
                              <th>Time</th>                             
                            </tr>
                            <tr>
                              <td>Boat rides</td>
                              <td>10.00 a.m -3.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Water Circus</td>
                              <td>10.00 a.m -1.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Water slides</td>
                              <td>9.00 a.m -5.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Aqua Roller coaster</td>
                              <td>10.00 a.m -3.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Aqua dancing</td>
                              <td>11.00 a.m -2.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Aqua war</td>
                              <td>3.00 p.m -5.00 p.m</td>
                            </tr>
                          </table>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Wildlife Park</h2>
                        <a href="#" class="wid-view-more">Modify</a>
                       <table>
                            <tr>
                              <th>Event</th>
                              <th>Time</th>                             
                            </tr>
                            <tr>
                              <td>Safari</td>
                              <td>9.00 a.m -4.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Zoolo Jumps</td>
                              <td>9.00 a.m -5.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Tiger show</td>
                              <td>4.00 p.m -5.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Wild circus</td>
                              <td>9.00 a.m -11.00 a.m</td>
                            </tr>
                            <tr>
                              <td>Monkey dance</td>
                              <td>9.00 a.m -3.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Bear war</td>
                              <td>9.00 a.m -5.00 p.m</td>
                            </tr>
                          </table>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Extreme Park</h2>
                        <a href="#" class="wid-view-more">Modify</a>
                       <table>
                            <tr>
                              <th>Event</th>
                              <th>Time</th>                             
                            </tr>
                            <tr>
                              <td>Mad Swing</td>
                              <td>10.00 a.m -5.00 pm</td>
                            </tr>
                            <tr>
                              <td>Heaven Jump</td>
                              <td>9.00 a.m -5.00 pm</td>
                            </tr>
                            <tr>
                              <td>Potter Ride</td>
                              <td>10.00 a.m -4.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Avenger war</td>
                              <td>9.00 a.m -2.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Crazy Roller Coaster</td>
                              <td>10.00 a.m -4.00 p.m</td>
                            </tr>
                            <tr>
                              <td>Color shots</td>
                              <td>10.00 a.m -3.00 p.m</td>
                            </tr>
                          </table>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
        <%@include file="footer.jsp" %>
    </body>
</html>
