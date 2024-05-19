<%@page import="com.Entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body{
background-color: lightcyan;

}
.head{
    margin-top: 5%;
    font-size: large;
    text-shadow: 10px 10px 20px black;
}
.tb1{
	text-align: center;
    font-size:large;
}



</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="head"><center><h1>All Employees</h1></center>
</div>
<%

ArrayList<Employee> emps = (ArrayList<Employee>)session.getAttribute("emps");
%>
<div class="tb1">
<center>
<table class="tb" border="2" style="border-collapse: collapse;">

<thead>
<tr>
<th>Id</th>
<th>Employee Name</th>
<th>Employee Salary</th>
</tr>
</thead>

<tbody>
<% 
for(Employee e:emps)
{
	

%>


<tr>
<td><%=e.getId() %></td>
<td><%=e.getName() %></td>
<td><%=e.getSalary() %></td>
</tr>

<%} %>
</tbody>
</table>
</center>
</div>
</body>
</html>