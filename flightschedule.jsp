<%
		String usenam = (String) session.getAttribute("uname");
	//System.out.println("Helllo "+usename);
	if (usenam == null) {
		response.sendRedirect("loginpage.jsp");
		
	}
	else{
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedule Flights</title>

<link type="text/css" rel="stylesheet" href="schedule.css" />
<script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

</head>

<body>
	<jsp:include page="headeradmin.jsp" />
	<div
		style="margin: auto; width: 50%; margin-top: 40px; /*border: 1px solid #73AD21;*/ padding: 15px;">
		<h1
			style="margin-left: 20px; text-align: center; margin-top: 70px; color: #660099; background-color: #E6E6FA;">FLIGHT
			SCHEDULES</h1>
		<form action="AddFlight.jsp">
			<input style="height: 50px; margin-left: 350px; font-weight: bold"
				type="submit" name="submit" value="ADD NEW FLIGHT DETAILS">
		</form>
		<%@ page import="java.util.*"%>
		<%@ page import="java.io.*"%>
		<%@ page import="java.sql.*"%>


		<%
			
			ResultSet rs = (ResultSet) session.getAttribute("rs1");
			ResultSet rs1 = (ResultSet) session.getAttribute("rs2");
		%>
		<div id="list">
			<table>
				<tr>
					<th></th>
					<th></th>
					<th>FLIGHT-ID</th>
					<th>FLIGHT-NAME</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>Date</th>
					<th>TIME</th>
					<th>CLASS TYPE</th>
					<th>CAPACITY</th>
					<th>AVAILABLE SEATS</th>
					<th>PRICE</th>

				</tr>


				<%
					while (rs.next() && rs1.next()) {
				%>
				<tr>
					<td>
						<form action="DeleteFlightServ" method="post">
							<input type="hidden" name="check" value="<%=rs.getString(1)%>">
							<input type="hidden" name="check1" value="<%=rs.getString(2)%>">
							<input style="font-weight: bold" type="submit"
								value="Delete Flight"
								onclick="return confirm('Are you sure you want to delete?')">
						</form>
					</td>

					<td>
						<form action="UpdateFlightServ" method="post">
							<br> <input type="text" name="newfare"
								placeholder="Enter new Fare">
								 <input type="hidden"
								name="check" value="<%=rs.getString(1)%>"> 
								<input
								type="hidden" name="check1" value="<%=rs.getString(2)%>"><br>
							<input style="font-weight: bold" type="submit"
								value="Update Flight Fare"
								onclick="return confirm('Are you sure you want to update?')"><br>
							<br>
						</form>

					</td>


					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
					<td><%=rs.getString(7)%></td>
					<td><%=rs1.getString(3)%></td>
					<td><%=rs1.getString(4)%></td>
					<td><%=rs1.getString(5)%></td>
				</tr>

				<%
					}
				%>
			</table>
			<%
				// close all the connections.
			
			%>


		</div>
</body>
</html>
<%
	}
%>
