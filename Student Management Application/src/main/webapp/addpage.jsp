<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.application.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new record</title>
<style>
.table1 {
	margin-top: 40px;
	margin-bottom: 20px;
	height: 40%;
}

.table1 th {
	font-size: 22px;
}

.table1 .input-field {
	font-size: 22px;
	margin-left: 2px;
}

.table2 {
	margin-top: 70px;
}

.mytable tr th {px;
	font-size: 18px;
}

.mytable .input-fields {
	font-size: 18px;
}

.add {
	font-size: 23px;
	padding: 10px;
	color: white;
	background-color: blue;
	border: 2px solid white;
	border-radius: 5px;
	width: 95%;
	margin-top: 40px;
}

.add:hover {
	background-color: red;
	color: white;
	border: 2px solid white;
	cursor: pointer;
}

body {
	background-color: aqua;
}

.heading {
	color: red;
}
</style>
</head>
<body>
	<center>
		<h1 class="headin">ADD THE NEW RECORD</h1>
	</center>
	<hr>
	<form action="insert" method="post">

		<table border="2" class="table1">
			<tr>
				<th>ROLL NUMBER</th>
				<td><input type="text" name="addrollnumber"
					class="input-fields" /></td>
			</tr>

			<tr>
				<th>NAME</th>
				<td><input type="text" name="addname" class="input-fields" /></td>
			</tr>

			<tr>
				<th>DOB</th>
				<td><input type="text" name="adddob" class="input-fields" /></td>
			</tr>
		</table>

		<%
		ArrayList<StudentMarks> studentMarks = (ArrayList<StudentMarks>) session.getAttribute("add-student-details");
		%>
		<table border="2" class="mytable">

			<tr>
				<th>SUBJECT CODE</th>
				<th>SUBJECT NAME</th>
				<th>INTERNAL</th>
				<th>EXTERNAL</th>
				<th>TOTAL</th>
				<th>GRADE</th>
				<th>RESULT</th>
			</tr>

			<%
			for (StudentMarks studentMark : studentMarks) {
			%>
			<input type="hidden" name="addsem"
				value="<%=request.getParameter("addsem")%>" />
			<input type="hidden" name="addsubjectcode"
				value="<%=studentMark.getSubjectCode()%>" />
			<input type="hidden" name="addsubjectname"
				value="<%=studentMark.getSubjectName()%>" />
			<tr>
				<td><%=studentMark.getSubjectCode()%></td>
				<td><%=studentMark.getSubjectName()%></td>
				<td><input type="text" name="addinternal" class="input-fields" /></td>
				<td><input type="text" name="addexternal" class="input-fields" /></td>
				<td><input type="text" name="addtotal" class="input-fields" /></td>
				<td><input type="text" name="addgrade" class="input-fields" /></td>
				<td><input type="text" name="addresult" class="input-fields" /></td>
			</tr>
			<%
			}
			%>

		</table>

		<input type="submit" value="ADD RECORD" class="add" />
	</form>



</body>
</html>