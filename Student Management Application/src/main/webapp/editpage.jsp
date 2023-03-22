<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit the record</title>
<style>
 

body {
  background-color:aqua;
}
.editform {
   background-color:black;
   width:40%;
   height:50%;
   margin:140px auto;
   padding:20px;
   border:3px solid white;
}


.editform .input-box {
   
   padding:5px;
   color:black;
   font-size:22px;
   border:2px solid black;
   border-radius:5px;
   width:70%;
}

.editform .edit {
   font-size:23px;
   border:2px solid white;
   border-radius:5px;
   background-color:red;
   color:white;
   text-align:center;
   width:70%;
   margin-left:15%;
   margin-bottom:20px;
   padding:4px;

}

.editform .edit:hover {

   cursor:pointer;
   background-color:yellow;
   color:red;
   border:2px solid white;
}
#heading {
  color:white;
}

.message {
  background-color:orange;
  color:white;
  padding:7px;
}
</style>
</head>
<body>
  <div class="editform">
<center>
<h1 id="heading">EDIT THE STUDENT RECORD</h1>
</center>
<hr>
<br>
<%
  String readMsg = (String) session.getAttribute("read-fail");

   if(readMsg != null) {
	   if(readMsg.equals("failure")) {
		   
%>
  <h3 class="message">NO RECORD FOUND FOR THIS ROLLNO OR SEM</h3>
<% 
    session.removeAttribute("read-fail");
	   }
   }
%>
 <%
  
  String updateMsg =(String) session.getAttribute("update");
  

  if(updateMsg != null) {
   if(updateMsg.equals("success")) {
%>
<h3 class="message">RECORD UPDATED SUCCESSFULLY</h3>
<%
   session.removeAttribute("update");
   } else {
   
%>
<h3 class="message">FAILED TO UPDATE THE RECORD</h3>
 <%
   session.removeAttribute("update");
   }
  } 
  
  
 %>
 

<form action="./controller/edit" method="post">
       <br>
         <center>
          <input type="text" placeholder="rollno" name="editrollno" class="input-box" /> 
        </center>
		
		<br><br>
		<center>
		  <input type="text" placeholder="sem" name="editsem" class="input-box"/>
		</center>
		 <br><br>
			<input type="submit" value="EDIT RECORD" class="edit"/>
	</form>

</div>
</body>
</html>