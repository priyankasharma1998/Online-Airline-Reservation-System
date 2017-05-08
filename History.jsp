<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History</title>
</head>
<link type="text/css" rel="stylesheet" href="History.css" />

<body>
	
		<jsp:include page="header.jsp" />

		<%@ page import="java.util.*" %>
		<%@ page import="java.io.*" %>
		<%@ page import="java.sql.*" %>
		
		<%
		ResultSet rs=(ResultSet)session.getAttribute("rs1");
			%>
		<div id="list">
			<table>
				<tr>
					<th>FLIGHT-ID</th>
					<th>FLIGHT-NAME</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>DATE</th>
					<th>TIME</th>
					<th>CLASS</th>
					<th>TICKET PRICE</th>
				</tr>	
			
			
			<% while(rs.next()){ %>
					<tr>
						
						<td id="td1"><%=rs.getString(2) %></td>
						<td id="td1"><%=rs.getString(3) %></td>
						<td id="td1"><%=rs.getString(4) %></td>
						<td id="td1"><%=rs.getString(5) %></td>
						<td id="td1"><%=rs.getString(6) %></td>
						<td id="td1"><%=rs.getString(7) %></td>
						<td id="td1"><%=rs.getString(8) %></td>
						<td id="td1"><%=rs.getString(9) %></td>
						
						<td><form  action="Cancel" method="post">
								<input type="hidden" name="FlightId" value="<%=rs.getString(2) %>">
								<input type="hidden" name="type" value="<%=rs.getString(8) %>">
								<input type="submit" value="cancel">
							</form> 
					</tr>			
						
			<%} %>
			</table>
			
	</div>
</body>
</html>