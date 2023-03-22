<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.application.dto.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update the records</title>
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

.update {
	font-size: 23px;
	padding: 10px;
	color: white;
	background-color: blue;
	border: 2px solid white;
	border-radius: 5px;
	width: 95%;
	margin-top: 40px;
}

.update:hover {
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
		<h1 class="heading">EDIT THE RECORDS OF A STUDENT</h1>
	</center>
	<hr>

	<%
	Student student = (Student) session.getAttribute("student");
     
	ArrayList<StudentMarks> studentMarks = (ArrayList<StudentMarks>) session.getAttribute("studentMarks");
	 
	%>
	<div class="updateform">

		<form method="post" action="./controller/update">
			<center>
			    <input type="hidden" name="semester" value="<%= request.getParameter("editsem")%>"/>
			    
				<table border='1' class="table1">
					<tr>
						<th>rollno</th>
						<td><%=student.getRollno()%></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><%=student.getName()%></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td>
							<%=student.getDob()%> 
						</td>
					</tr>
				</table>

				
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
						<input type="hidden" name="usubject_code"
								value="<%=studentMark.getSubjectCode()%>" class="input-fields" />
						<input type="hidden" name="usubject_name"
								value="<%=studentMark.getSubjectName()%>" class="input-fields" />
						<tr>
							<td>
								<%=studentMark.getSubjectCode()%></td>
							<td>
								<%=studentMark.getSubjectName()%></td>
							<td><input type="text" name="uinternal"
								value="<%=studentMark.getInternal()%>" class="input-fields" /></td>
							<td><input type="text" name="uexternal"
								value="<%=studentMark.getExternal()%>" class="input-fields" /></td>
							<td><input type="text" name="utotal"
								value="<%=studentMark.getTotal()%>" class="input-fields" /></td>
							<td><input type="text" name="ugrade"
								value="<%=studentMark.getGrade()%>" class="input-fields" /></td>
							<td><input type="text" name="uresult"
								value="<%=studentMark.getResult()%>" class="input-fields" /></td>
						</tr>

						<%
						}
						%>
					</table>
					</center>

					<center>
						<input type="submit" value="UPDATE RECORD" class="update" />
					</center>
					</form>
					</div>
</body>
</html>