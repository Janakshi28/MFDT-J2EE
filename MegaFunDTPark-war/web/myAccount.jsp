<%-- 
    Document   : myAccount
    Created on : Jan 22, 2017, 12:15:02 PM
    Author     : Janakshi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="icon" type="image/jpg" href="img/park logo.jpg"/>
  <title>MFDT-Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link href="styles/adminLTE/_all-skins.min.css" rel="stylesheet" type="text/css"/>
  <!-- iCheck -->
  <link href="styles/adminLTE/blue.css" rel="stylesheet" type="text/css"/>
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <c:import url="header.jsp"/>   
        <div class="wrapper">



          <!-- Left side column. contains the logo and sidebar -->
          <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
              <!-- Sidebar user panel -->
              <div class="user-panel">
                <div class="pull-left image">
                    <img src="img/admin.png" class="img-circle" alt="User Image"> 
                </div>
                <div class="pull-left info">
                  <p>${user.name}</p>
                  <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
              </div>
              <!-- sidebar menu: : style can be found in sidebar.less -->
              <ul class="sidebar-menu" >
                <li class="header">MAIN NAVIGATION</li>
                 <li>
                  <a href="">
                    <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                  </a>
                </li>
               
                <li class="treeview">
                  <a href="#">
                    <i class="fa fa-files-o"></i><span>Events</span>
                     <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                     </span>
                  </a>
                  <ul class="treeview-menu">
                        <li class="active"><a href="DashboardHandlerServlet?page=addE"><i class="fa fa-circle-o"></i> Add Events</a></li>
                        <li><a href="DashboardHandlerServlet?page=editE"><i class="fa fa-circle-o"></i> Edit Event</a></li>
                        <li><a href="DashboardHandlerServlet?page=deleteE"><i class="fa fa-circle-o"></i> Delete Event</a></li>  
                  </ul>
                </li>
                <li class="treeview">
                  <a href="#">
                    <i class="fa fa-files-o"></i><span>Sales</span>
                     <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                     </span>
                  </a>
                  <ul class="treeview-menu">
                        <li><a href="DashboardHandlerServlet?page=monthS"><i class="fa fa-circle-o"></i> Monthly Sales</a></li>
                        <li><a href="DashboardHandlerServlet?page=yearS"><i class="fa fa-circle-o"></i> Yearly Sales</a></li>
                        <li><a href="DashboardHandlerServlet?page=todayS"><i class="fa fa-circle-o"></i> Today's Sales</a></li>   
                  </ul>
                </li>
              </ul>
            </section>
            <!-- /.sidebar -->
          </aside>

          <!-- Content Wrapper. Contains page content -->
          <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Dashboard
                    <small>Control panel</small>
                  </h1>
                  <ol class="breadcrumb">
                    <li><a href="home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Dashboard</li>
                  </ol>
            </section>
            <!-- /.content -->
            <section class="content">
                                            
                <c:choose>
                    <c:when test="${'addE' eq requestScope.page}">
                              <div class="login-box">
                                    <div class="login-logo">
                                      <a href="#"><b>Add </b>EVENTS</a>
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
                                      <p class="login-box-msg">Add new events</p>

                                      <form action="./AddEventServlet" method="post">
                                          <div class="form-group has-feedback">
                                          <input type="text" class="form-control" name="title" placeholder="Title">
                                          <span class="fa  fa-user form-control-feedback"></span>
                                          </div>                                     
                                          <div class="form-group has-feedback">
                                          <select name="park" id="park" class="form-control" >
                                                <option value="">Select a Park</option>
                                                <option value="Water">Water</option>
                                                <option value="Wildlife">Wildlife</option>
                                                <option value="Extreme">Extreme</option>  
                                                <option value="Other">Other</option>  
                                           </select>
                                          </div>
                                          <div class="form-group has-feedback">
                                             <input type="text" class="form-control" name="start" placeholder="Start Time">                                      
                                          <span class="fa  fa-user form-control-feedback"></span>
                                          </div>
                                          <div class="form-group has-feedback">
                                          <input type="text" class="form-control" name="end" placeholder="End Time">
                                          <span class="fa  fa-user form-control-feedback"></span>
                                          </div>
                                        <div class="row">
                                          <div class="col-xs-8" >
                                            <div class="checkbox icheck">

                                            </div>
                                          </div>
                                          <!-- /.col -->
                                          <div class="col-xs-4">
                                            <button type="submit" class="btn btn-primary btn-block btn-flat">Add</button>
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

                                                <c:when test="${'1' eq sessionScope.eStatus}">
                                                    <div class="alert alert-success alert-dismissible">
                                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                                        <h4><i class="icon fa fa-check"></i> ${sessionScope.msg1}</h4>
                                                        ${sessionScope.msg2}<br/>
                                                  </div>
                                                    <c:remove var="eStatus" scope="session" />
                                                    <c:remove var="msg1" scope="session" />
                                                    <c:remove var="msg2" scope="session" />
                                                </c:when>                                  
                                                <c:when test="${'2' eq sessionScope.eStatus}">
                                                    <div class="alert alert-danger alert-dismissible">
                                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                                        <h4><i class="icon fa fa-warning"></i> ${sessionScope.msg1}</h4>
                                                          ${sessionScope.msg2}
                                                     </div>
                                                    <c:remove var="eStatus" scope="session" />
                                                    <c:remove var="msg1" scope="session" />
                                                    <c:remove var="msg2" scope="session" />
                                                </c:when>   

                                      </c:choose>

                                      

                                    </div>
                                    <!-- /.login-box-body -->
                                  </div>
                                  <!-- /.login-box -->
                             
                         </c:when>
                                  
                </c:choose>
            </section>
          </div>
        </div>
                  
 <script>
$(function(){
    $('#time').combodate({
        firstItem: 'name', //show 'hour' and 'minute' string at first item of dropdown
        minuteStep: 1
    });  
});
</script>
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
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="scripts/adminLTE/dashboard.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="scripts/adminLTE/demo.js" type="text/javascript"></script>
 <%@include file="footer.jsp" %>
</body>
</html>