<%-- 
    Document   : header
    Created on : Jan 22, 2017, 3:26:30 PM
    Author     : Janakshi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% session = request.getSession();%>
<jsp:useBean id="user" class="lk.megafundtpark.remote.utils.AdminDetails" scope="session">
    <jsp:setProperty name="user" property="name" value="Guest"/>
</jsp:useBean>
<div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="home.jsp"><img src="img/park1 icon.png" alt="" height="15px" width="15px"/>  MegaFun-DownTown Amusement Park</a></li>  
                            
                           <c:choose>                                    
                                <c:when test="${sessionScope.loginStatus eq null || user.name eq 'Guest'}">                                      
                                      <li><a href="login.jsp"><i class="fa  fa-area-chart"></i> Dashboard</a></li> 
                                </c:when>
                                  <c:when test="${'1' eq sessionScope.loginStatus && user.name ne 'Guest'}">
                                    <li><a href="myAccount.jsp"><i class="fa  fa-area-chart"></i> Dashboard</a></li>
                                  </c:when>          
                             </c:choose>  
                                    
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                             <c:choose>                                    
                                <c:when test="${sessionScope.loginStatus eq null || user.name eq 'Guest'}">                                      
                                    <li><a href="#"><i class="fa fa-user"></i> Welcome!</a></li>
                                </c:when>
                                  <c:when test="${'1' eq sessionScope.loginStatus && user.name ne 'Guest'}">
                                    <li><a href="#"><i class="fa fa-user"></i> Welcome ${user.name}!</a></li>
                                  </c:when>          
                             </c:choose>   
                                    
                            <c:choose>
                                <c:when test="${sessionScope.loginStatus eq null || user.name eq 'Guest'}">
                                    <li><a href="login.jsp"><i class="fa fa-user"></i> Log in</a></li>  
                                </c:when>
                                  <c:when test="${'1' eq sessionScope.loginStatus && user.name ne 'Guest'}">
                                    <li><a href="LogoutServlet?logout=1"><i class="fa fa-user"></i> Log out</a></li> 
                                  </c:when>          
                             </c:choose> 
                           
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="home.jsp">       <img src="img/amusement-park-logo.png" alt=""/>MegaFun-<span>DownTown</span></a></h1>
                        
                    </div>
                </div>
                
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">                        
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="manageBulletins.jsp">Bulletins</a></li>                        
                        <li><a href="tickets.jsp">Tickets</a></li>
                        <li><a href="eBandReloads.jsp">E-Loads</a></li>
                        <li><a href="foodStall.jsp">Food Stall</a></li>
                        <li><a href="extremeevents.jsp">Extreme Events</a></li>
                        <li><a href="photoStall.jsp">Photo Booth</a></li>
                        <li><a href="elockerReservations.jsp">E-Lockers</a></li>  
                        <li><a href="checkout.jsp">Checkout</a></li>  
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->