<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome TO Out website</title>
<link rel="stylesheet" href="util_components/style.css"></link>
<style>
.adminbar {
	background-color: black;
	height: 70px;
}

.adminbar .adminlists {
	display: flex;
	list-style-type: none;
}

.adminbar .adminlists .list {
	margin-top: 20px;
	margin-left: 50px;
}

.adminbar .adminlists .link {
	text-decoration: none;
	background-color: red;
	color: white;
	border: 2px solid white;
	border-radius: 5px;
	padding: 4px;
	font-size: 22px;
}

.adminbar .adminlists .link:hover {
	text-decoration: none;
	background-color: blue;
	color: white;
	border: 2px solid white;
	border-radius: 5px;
	padding: 5px;
	font-size: 22px;
}

body {
	background-color: aqua;
}

.searchform {
	background-color: black;
	width: 40%;
	height: 50%;
	margin: 140px auto;
	padding: 20px;
	border: 3px solid white;
}

.searchform .input-box {
	padding: 5px;
	color: black;
	font-size: 22px;
	border: 2px solid black;
	border-radius: 5px;
	width: 70%;
}

.searchform .search {
	font-size: 23px;
	border: 2px solid white;
	border-radius: 5px;
	background-color: red;
	color: white;
	text-align: center;
	width: 70%;
	margin-left: 15%;
	margin-bottom: 20px;
	padding: 4px;
}

.searchform .search:hover {
	cursor: pointer;
	background-color: yellow;
	color: red;
	border: 2px solid white;
}

#heading {
	color: white;
}

.message {
	background-color: orange;
	color: white;
}

.list3 {
	margin-left: 100px;
}

.sem-input {
	font-size: 22px;
	padding: 4px;
}
</style>
</head>
<body>

	<%

     String studentLoggedIn =(String) session.getAttribute("StudentLoggedIn");
    if(studentLoggedIn == null) {
    	
    	
    	
 %>
	<div class="adminbar">

		<ul class="adminlists">
			<li class="list"><a href="./editpage.jsp" class="link link1">EDIT
					RECORD</a></li>




			<li class="list list2"><a href="./deletepage.jsp"
				class="link link2">DELETE RECORD</a></li>

			<li class="list list3">
				<form action="./controller/add">

					<input type="submit" value="ADD RECORD" class="link link3" /> <input
						type="text" name="addsem" placeholder="sem" class="sem-input" />

				</form>
			</li>
		</ul>
	</div>
	<%
	  String newRecordMsg =(String) session.getAttribute("new-record");
	
	  if(newRecordMsg != null) {
		  if(newRecordMsg.equals("success")) {
	%>
	<h3 class="message">NEW RECORD HAS BEEN ADDED SUCCESSFULLY</h3>
	<%
      session.removeAttribute("new-record");
	  } else {
    %>
	<h3 class="message">FAILED TO ADD THE RECORD</h3>
	<%
      session.removeAttribute("new-record");
	  }
	  }
    
    } else {
   
    %>
	<div class="searchform">
		<center>
			<h1 id="heading">SEARCH FOR THE STUDENT</h1>
		</center>
		<hr>
		<br>

		<%
		String readMsg = (String) session.getAttribute("read-fail");

		if (readMsg != null) {
			if (readMsg.equals("failure")) {
		%>
		<h3 class="message">RECORD NOT FOUND FOR THIS ROLLNO OR SEM</h3>
		<%
		session.removeAttribute("read-fail");
		}
		}
		%>



		<form action="./controller/getstudent" method="post">
			<br>
			<%
			  String emptyMsg =(String) session.getAttribute("addSucess");
			
			  if(emptyMsg != null) {
				  if(emptyMsg.equals("empty")) {
			%>
			<h3 class="message">NO RECORD FOUND FOR GIVEN ROLLNO OR SEM</h3>
			<%
			   session.removeAttribute("addSucess");
				  }
			  }
			%>
			<center>
				<input type="text" placeholder="rollno" name="rollno"
					class="input-box" />
			</center>

			<br> <br>
			<center>
				<input type="text" placeholder="sem" name="sem" class="input-box" />
			</center>
			<br> <br> <input type="submit" value="search"
				class="search" />
		</form>

	</div>

	<%
}
%>
</body>
</html>