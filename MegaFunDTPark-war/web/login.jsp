<%-- 
    Document   : login
    Created on : Jan 21, 2017, 3:32:33 AM
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
        <title>Log In</title>
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
        
        <div class="login-box">
            <div class="login-logo">
              <a href="#"><b>Admin</b>LOGIN</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
              <p class="login-box-msg">Sign in to start your session</p>

              <form action="./LoginServlet" method="post">
                <div class="form-group has-feedback">
                  <input type="text" class="form-control" name="id" placeholder="User name">
                  <span class="fa  fa-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                  <input type="password" class="form-control" name="password" placeholder="Password">
                  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                  <div class="col-xs-8" >
                    <div class="checkbox icheck">
                      
                    </div>
                  </div>
                  <!-- /.col -->
                  <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
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
             
                        <c:when test="${'1' eq sessionScope.loginStatus}">
                            <div class="alert alert-success alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-check"></i> Login Success!!</h4>
                                <a href="changePassword.jsp" class="text-center">Update Password</a>
                          </div>
                        </c:when>                                  
                        <c:when test="${'2' eq sessionScope.loginStatus}">
                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-warning"></i> Login Failed! Try Again...</h4>
                                  If you have forgotten the password, please go to below link to get a new password.
                             </div>
                            <c:remove var="loginStatus" scope="session" />
                        </c:when>   
                           
              </c:choose>
              <a href="#">I forgot my password</a><br>
              <a href="register.jsp" class="text-center">Register a new membership</a>

            </div>
            <!-- /.login-box-body -->
          </div>
          <!-- /.login-box -->
         
         
    <%@include file="footer.jsp" %>
    </body>
</html>
