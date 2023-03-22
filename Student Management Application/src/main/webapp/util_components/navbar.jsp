<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
  
    </style>
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Welcome To Our Website</title>
</head>
<body>
 <div class="navbar">
 
        <div class="logo">
            <li class="navbar-list list1"><img src="images/logo.jpg"/></li>
        </div>
        
        
        <ul class="navbar-lists">
          <li class="navbar-list list1"><a href="./index.jsp" class="link1"><i class="fa fa-home">Home</i></a></li>
          <%
            String adminLogin =(String) session.getAttribute("admin-login");
          
            if(adminLogin != null) {
          %>
          <li class="navbar-list list2"><a href="./login.jsp" class="link2"><i class="fa fa-user">Logout</i></a></li>
        <%} else { %>
          <li class="navbar-list list2"><a href="./login.jsp" class="link2"><i class="fa fa-user"> Login</i></a></li>
        <%
        }
        %>
        </ul>


        <div class="logo1">
            <li class="navbar-list list1"><img src="images/logo.jpg"/></li>
        </div>

    </div>
</body>
</html>