<%-- 
    Document   : header
    Created on : Jan 21, 2017, 1:12:06 PM
    Author     : Janakshi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% session = request.getSession();%>
<jsp:useBean id="user" class="lk.megafundtpark.remote.utils.AdminDetails" scope="session">
    <jsp:setProperty name="user" property="name" value="Guest"/>
</jsp:useBean>

  <header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="home.jsp" class="navbar-brand"><b>MegaFun-</b>DownTown</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="home.jsp">Home <span class="sr-only">(current)</span></a></li>
            <li><a href="myAccount.jsp">Dashboard</a></li>
            
          </ul>
          
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
               <c:choose>
                        <c:when test="${sessionScope.loginStatus eq null && user.name eq 'Guest'}">
                            <li><a href="login.jsp">Log in </a></li>
                        </c:when>
                        <c:when test="${'1' eq sessionScope.loginStatus && user.name ne 'Guest'}">
                           <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.name}<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="myAccount">My Home</a></li>
                                <li><a href="LogoutServlet?logout=1">Log out</a></li>
                            </ul>
                        </c:when>                                                        
                            
                 </c:choose>            
              
            </li>          
        </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>      
<!-- header -->
