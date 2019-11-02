<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.lti.*" import="java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Student> list=(ArrayList)session.getAttribute("clgList");

if(list.isEmpty())
{
	
%>
No records found
<% 
}
else
{
%>
<table border="1px">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Course Type</th>
		<th>City</th>
		<th>Fees</th>
		<th>Pincode</th>
	</tr>
	
<%
	for(Student s:list)
	{
%>
<tr>
		<td><%= s.getId()%>"></td>
		<td><%= s.getCname() %></td>
		<td><%= s.getCourseType() %></td>
		<td><%= s.getCity() %></td>
		<td><%= s.getFees() %></td>
		<td><%= s.getPincode() %></td>
</tr>

<% 
	}
%>
	
</table>
<%
}
%>


<a href="add.jsp">Add</a>
<br><br>
<a href="delete.jsp">Delete</a>

</body>
</html>