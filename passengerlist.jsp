<%
	
	
	String usename = (String) session.getAttribute("uname");
	//System.out.println("Helllo "+usename);
	if (usename == null) {
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
<title>Passenger list</title>

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
			style="margin-left: 20px; text-align: center; margin-top: 70px; c
				olor: #660099; background-color: #E6E6FA;">PASSENGERS
			LIST</h1>

		<%@ page import="java.util.*"%>
		<%@ page import="java.io.*"%>
		<%@ page import="java.sql.*"%>
		<%@ page import="java.io.PrintWriter"%>
		

		<%
			String userName = (String) session.getAttribute("uname");
			//System.out.println("Helllo "+userName);
			if (userName == null) {
		%>

		<script type="text/javascript">
			alert('Error Session has ended Please login.');
			location = 'loginpage.jsp';
		</script>

		<%
			}
			ResultSet rs=(ResultSet)session.getAttribute("rs1");
		%>
		<div id="list">
			<table>
				<tr>

					<th>FLIGHT-ID</th>
					<th>USER-ID</th>
					<th>FLIGHT-NAME</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>DATE OF JOURNEY</th>
					<th>DEPARTURE TIME</th>
					<th>CLASS TYPE</th>
					<th>PRICE</th>


				</tr>


				<%
					while (rs.next()) {
				%>
				<tr>


					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
					<td><%=rs.getString(7)%></td>
					<td><%=rs.getString(8)%></td>
					<td><%=rs.getString(9)%></td>

				</tr>

				<%
					}
				%>
			</table>
			

		</div>
</body>
</html>
<%
	}
%>