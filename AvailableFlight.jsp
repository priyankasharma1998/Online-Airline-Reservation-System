<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule Flights</title>

<link type="text/css" rel="stylesheet" href="schedule.css" />


</head>

<body>
	<jsp:include page="header.jsp" />
	
	
	<div
		style="margin: auto; width: 50%; margin-top: 40px; /*border: 1px solid #73AD21;*/ padding: 15px;">
		<h1
			style="margin-left: 20px; text-align: center; margin-top: 70px; color: #660099; background-color: #E6E6FA;">FLIGHT
			SCHEDULES</h1>
		
		<%@ page import="java.util.*"%>
		<%@ page import="java.io.*"%>
		<%@ page import="java.sql.*"%>


		<%
			
			ResultSet rs = (ResultSet)session.getAttribute("rs");
		System.out.println("hello query");
			
		%>
		<div id="list">
			<table>
				<tr>
					<th>FLIGHT-ID</th>
					<th>FLIGHT-NAME</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th> Type</th>
					<th>Time</th>
					
				</tr>
				<%					
					while (rs.next() ) {
						System.out.println("hello query");
				%>
				<tr>
					
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(7)%></td>
					<td><%=rs.getString(6)%></td>
				
				</tr>
 	
					<%} %>
			</table>
						<center>	
						<form action="FlightInfoModule.SelectFlight" method="post">
		enter flight id which one u want to visit <input type="text" name="FlightId"><br>
								<input type="submit" value="SHOW">
						</form>
					</center>
			</div>
</body>
</html>