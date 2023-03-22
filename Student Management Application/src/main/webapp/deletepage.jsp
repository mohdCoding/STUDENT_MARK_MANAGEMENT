<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE RECORD</title>
<style>
body {
	background-color: aqua;
}

.heading {
	color: white;
	text-align: center;
}

.deleteform {
	background-color: black;
	width: 40%;
	height: 50%;
	margin: 140px auto;
	padding: 20px;
	border: 3px solid white;
}

.deleteform .input-box {
	padding: 5px;
	color: black;
	font-size: 22px;
	border: 2px solid black;
	border-radius: 5px;
	width: 70%;
}

.deleteform .delete {
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

.deleteform .delete:hover {
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
	padding: 7px;
}
</style>
</head>
<body>


	<div class="deleteform">

		<form action="./controller/delete">

			<h1 class="heading">DELETE THE RECORD</h1>
			<br>
			<hr>
			<%
			String deleteMsg = (String) session.getAttribute("delete");

			if (deleteMsg != null) {
				if (deleteMsg.equals("success")) {
			%>
			<h3 class="message">SUCCESS FULLY DELETED THE RECORD</h3>
			<%
			session.removeAttribute("delete");
			} else if (deleteMsg.equals("failure")) {
			%>
			<h3 class="message">FAILED TO DELETE THE RECORD</h3>
			<%
			session.removeAttribute("delete");
			} else if (deleteMsg.equals("not-found")) {
			%>
			<h3 class="message">RECORD NOT FOUND FOR THIS ROLLNUMBER OR SEM</h3>
			<%
			session.removeAttribute("delete");
			}
			}
			%>
			<center>
				<input type="text" placeholder="rollno" name="deleterollno"
					class="input-box" />
			</center>

			<br>
			<br>
			<center>
				<input type="text" placeholder="sem" name="deletesem"
					class="input-box" />
			</center>
			<br>
			<br> <input type="submit" value="DELETE RECORD" class="delete" />

		</form>

	</div>

</body>
</html>