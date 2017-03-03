<%-- 
    Document   : elockerReservations
    Created on : Jan 24, 2017, 5:36:56 PM
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
        <title>E- Locker Reservation</title>
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
         
        <!-- Morris chart -->
        <link href="styles/adminLTE/morris.css" rel="stylesheet" type="text/css"/>
        <!-- jvectormap -->
        <link href="styles/adminLTE/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css"/>
        <!-- Date Picker -->
        <link href="styles/adminLTE/datepicker3.css" rel="stylesheet" type="text/css"/>
        <!-- Daterange picker -->
        <link href="styles/adminLTE/daterangepicker.css" rel="stylesheet" type="text/css"/>
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="styles/adminLTE/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css"/>
         
         
         
        
         <!--Scripts-->
         <!-- jQuery 2.2.3 -->
            <script src="scripts/adminLTE/jquery-2.2.3.min.js" type="text/javascript"></script>
            <!-- jQuery UI 1.11.4 -->
            <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
            <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
            <script>
              $.widget.bridge('uibutton', $.ui.button);
            </script>
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
            
            <!-- Morris.js charts -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
            <script src="scripts/adminLTE/morris.min.js" type="text/javascript"></script>
            <!-- Sparkline -->
            <script src="scripts/adminLTE/jquery.sparkline.min.js" type="text/javascript"></script>
            <!-- jvectormap -->
            <script src="scripts/adminLTE/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
            <script src="scripts/adminLTE/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
            <!-- jQuery Knob Chart -->
            <script src="scripts/adminLTE/jquery.knob.js" type="text/javascript"></script>
            <!-- daterangepicker -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
            <script src="scripts/adminLTE/daterangepicker.js" type="text/javascript"></script>
            <!-- datepicker -->
            <script src="scripts/adminLTE/bootstrap-datepicker.js" type="text/javascript"></script>
            <!-- Bootstrap WYSIHTML5 -->
            <script src="scripts/adminLTE/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
            <!-- Slimscroll -->
            <script src="scripts/adminLTE/jquery.slimscroll.min.js" type="text/javascript"></script>
            
            
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
         <section class="content-header">
          <h1>
            E- Lockers
            <small>Control panel</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">E- Lockers</li>
          </ol>
        </section>
         
         <section class="content">
                           <div class="row">
                    <div class="col-lg-3 col-xs-6">
                      <!-- small box -->
                      <div class="small-box bg-aqua">
                        <div class="inner">
                          <h3>Reserve </h3>

                          <p>Lockers</p>
                        </div>
                        <div class="icon">
                          <i class="ion ion-bag"></i>
                        </div>
                        <a href="ReserveElockerServlet?page=reserve" class="small-box-footer">Go <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                      <!-- small box -->
                      <div class="small-box bg-green">
                        <div class="inner">
                          <h3>Clear</h3>

                          <p>Lockers</p>
                        </div>
                        <div class="icon">
                          <i class="ion ion-stats-bars"></i>
                        </div>
                        <a href="ClearElockerServlet?page=clear" class="small-box-footer">Go <i class="fa fa-arrow-circle-right"></i></a>
                      </div>
                    </div>
                    <!-- ./col -->
                   
                    
      </div>
      <!-- /.row -->
      <c:choose>
          <c:when test="${'reserve' eq requestScope.page}">
              
                       <div class="login-box">
            <div class="login-logo">
              <a href="#"><b>E-Locker </b>RESERVATION</a>
            </div>             
             
            <!-- /.login-logo -->
            <div class="login-box-body">
                <c:choose>
                          <c:when test="${user eq null || user.name eq 'Guest'}">
                              <div class="alert alert-danger alert-dismissible">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <h4><i class="icon fa fa-ban"></i> Access Denied!</h4>
                                      Please log in to the system as an admin before performing this function.
                               </div>
                                       
                            </c:when>
                        <c:when test="${user ne null }">
                            <p class="login-box-msg">Ticket issuing for current session</p>
                        </c:when>
                        
                    </c:choose>
              <p class="login-box-msg">Reserve a locker using e-payments</p>

              

            </div>
            <!-- /.login-box-body -->
          </div>
          <!-- /.login-box -->
              
          </c:when>
          <c:when test="${'clear' eq requestScope.page}">
                       <div class="login-box">
            <div class="login-logo">
              <a href="#"><b>E-Locker </b>CLEARLING</a>
            </div>             
             
            <!-- /.login-logo -->
            <div class="login-box-body">
              <p class="login-box-msg">Clear a locker</p>

              <form action="./ClearElockerServlet" method="post">
                <div class="form-group has-feedback">                   
                  <input type="text" class="form-control" name="bandid" placeholder="E-Band ID">
                  <span class="fa  fa-user form-control-feedback"></span>
                </div>                 
                <div class="form-group has-feedback">
                     <select name="lockerNo" id="park" class="form-control" >
                         <option value="">Select a Locker</option>
                         
                         <c:forEach items="${requestScope.lockers}" var="item">                            
                             <option value="${item.getLockerid()}">${item.getLockerid()}</option>
                        </c:forEach>
                                                
                      </select>           
                  <span class="fa  fa-box form-control-feedback"></span>
                </div>
              
                <div class="row">
                  <div class="col-xs-8" >
                    <div class="checkbox icheck">
                      
                    </div>
                  </div>
                  <!-- /.col -->
                  <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Clear</button>
                  </div>
                  <!-- /.col -->
                </div>
                   <div class="row">
                  <div class="col-xs-8" >
                    <div class="checkbox icheck">
                      
                    </div>
                  </div>
                  <!-- /.col -->              
                </div>
              </form>
              <c:choose>
             
                        <c:when test="${'1' eq sessionScope.lStatus}">
                            <div class="alert alert-success alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-check"></i> Clearing Success!</h4>
                                Locker number: ${sessionScope.lNo} is cleared.
                          </div>
                            <c:remove var="lStatus" scope="session" />
                        </c:when>                                  
                        <c:when test="${'2' eq sessionScope.lStatus}">
                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-warning"></i> Clearing Failed! Try Again...</h4>
                                  Please check if all the fields are filled..
                             </div>
                            <c:remove var="lStatus" scope="session" />
                        </c:when>   
                           
              </c:choose>

            </div>
            <!-- /.login-box-body -->
          </div>
          <!-- /.login-box -->
              
          </c:when>
          
          
      </c:choose>      
             
             
             

         
         </section>
    <%@include file="footer.jsp" %>
    </body>
</html>
