<%-- 
    Document   : home
    Created on : Jan 21, 2017, 3:31:36 AM
    Author     : Janakshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/jpg" href="img/park logo.jpg"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home-MFDT</title>
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
             
             <style>
                table {
                    border-collapse: collapse;
                }

                td, th {
                    border: 1px solid #dddddd;
                    text-align: left;
                    padding: 8px;
                }

                tr:nth-child(even) {
                    background-color: #dddddd;
                }
                </style>
            
             
             
            <!--Scripts-->
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
           <div class="slider-area">
                    <div class="zigzag-bottom"></div>
                    <div id="slide-list" class="carousel carousel-fade slide" data-ride="carousel">

                        <div class="slide-bulletz">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ol class="carousel-indicators slide-indicators">
                                            <li data-target="#slide-list" data-slide-to="0" class="active"></li>
                                            <li data-target="#slide-list" data-slide-to="1"></li>
                                            <li data-target="#slide-list" data-slide-to="2"></li>
                                        </ol>                            
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <div class="single-slide">
                                    <div class="slide-bg slide-one"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>Have Fun</h2>
                                                            <p>Bring out the best fun in you with MegaFun-DownTown Amusement park!</p>
                                                            <p>We make sure you spend one of the most amazing,thrilling and unforgettable days in your life with us. We brings to you the most fun filled games, events and stalls to make the most of your memories.</p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="single-slide">
                                    <div class="slide-bg slide-two"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>Experience more</h2>
                                                            <p>Experience the amazement in three different worlds with our Water, Wildlife and Extreme parks! Stop worrying about cash, roam around cashless with your e-bands.</p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="single-slide">
                                    <div class="slide-bg slide-three"></div>
                                    <div class="slide-text-wrapper">
                                        <div class="slide-text">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 col-md-offset-6">
                                                        <div class="slide-content">
                                                            <h2>We are superb</h2>
                                                            <p>Curious about how our services are?</p>
                                                            <p>When it comes to services we are on your side. We make sure that you have fun being more comfortable with tasty comfort food, photo booths to make memories and to be more secure with e-lockers! </p>
                                                            <a href="" class="readmore">Learn more</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>        
            </div> <!-- End slider area -->   
        <div class="promo-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <a href="tickets.jsp" > </a><i class="fa fa-ticket"></i>
                        <p>Tickets</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class=" fa fa-google-wallet"></i>
                        <p>E- Payments</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-refresh "></i>
                        <p>E-Band Reloading</p>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-camera"></i>
                        <p>Photo Booth</p>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End promo area -->
    
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
