<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="util_components/style.css"></link>
<title>admin login</title>
<style>
.heading {
background-color:aqua;
color:white;
padding:12px;
font-size:32px;
}

.login-f {
  background-color:orange;
  color:white;
  text-align:center;
}
</style>
</head>
<body class="login">

<center>
<h1 class="heading">ADMIN PAGE</h1>
</center>


 <div class="card">
    <center><h1>Login</h1></center>
    <br>
    <hr/>
    <form method="post" action="./controller/admin-page">
     
     <br>
     <%
       
        String loginFailure =(String) session.getAttribute("login-failure");
     
        if(loginFailure != null) {
     %>
      <p class="login-f"><%=loginFailure %></p>
      <%
        session.removeAttribute("login-failure");
        }
      %>
      <label class="labels email-label">Enter Your Email</label><br>
      <input type="email" name="email" required class="emails inputs"/><br><br>
      <label class="labels password-label">Enter Your Password</label><br>
      <input type="password" name="password" required class="passwords inputs"/><br>
      
      <input type="submit" id="submit" value="Login"/>
    </form>
    <br>
    
    <hr>
    <br>
    
    
    <center>
    <i><a href="studentlogin.jsp" class="studentlogin">Click Here to login as a student</a></i>
    </center>
 </div>
 
 <%@ include file="util_components/footer.jsp" %>
</body>
</html>