<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.application.dto.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Detail</title>
<style>
.heading-1 {
	margin-top: 20px;
	color: blue;
}

.para1 {
	color: blue;
	font-size: 22px;
}
.heading2 {
  color:red;
}
.container .mytable {
   padding:10px;
   font-size:25px;
   width:70%;
   height:70%;
}

.studenttable {
  margin:10px auto;
  font-size:20px;
  padding:5px;
}

</style>
</head>
<body>
	<center>
		<h1 class="heading-1">NADAR MAHAJANA SANGAM</h1>
	</center>

	<center>
		<h1 class="heading-1">S.VELLACHAMY NADAR COLLEGE</h1>
	</center>

	<center>
		<p class="para1">(An Autonomous Institution Affilated to madurai
			kamaraj university)</p>
	</center>
    
    <center>
      <h1 class="heading2">SUMMATIVE EXAMINATION RESULT</h1>
    </center>
    <%
    
      Student student =(Student) session.getAttribute("student");
      
    %>
  <table class="studenttable">
     <tr>
       <th>REGISTER NUMBER</th>
       <td>&nbsp;&nbsp;<%=student.getRollno() %></td>
     </tr>
     <tr>
       <th>DEPARTMENT</th>
       <td>&nbsp;&nbsp;INFORMATION TECHNOLOGY (SF)</td>
     </tr>
     <tr>
       <th>NAME</th>
       <td>&nbsp;&nbsp;<%= student.getName() %></td>
     </tr>
     <tr>
       <th>LEVEL</th>
       <td>&nbsp;&nbsp;UG</td>
     </tr>
  </table>
	<div class="container">
		<center>
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
				ArrayList<StudentMarks> studentMarks = (ArrayList<StudentMarks>) session.getAttribute("studentMarks");

				for (StudentMarks studentMark : studentMarks) {
				%>
				<tr>
					<td><%= studentMark.getSubjectCode() %></td>
					<td><%= studentMark.getSubjectName() %></td>
					<td><%= studentMark.getInternal() %></td>
					<td><%= studentMark.getExternal() %></td>
					<td><%= studentMark.getTotal() %></td>
					<td><%= studentMark.getGrade() %></td>
					<td><%= studentMark.getResult() %></td>
				</tr>

				<%
				}
				%>
			</table>
		</center>
	</div>
</body>
</html>