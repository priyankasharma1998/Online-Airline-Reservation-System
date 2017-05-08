

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="schedule.css" />
<title>Insert title here</title>
</head>
<body>

	<div id="header">
		<h1>Airline Reservation System</h1>
	</div>
	<div id="nav">
		<font size="5" weight=normal color=black>
			<table>
				<tr>
					<th><a href="AddAdmin.jsp"
						style="color: white; font-weight: bold">New Admin</a></th>
					<th></th>
					<th><a href="flightScheduleServ"
						style="color: white; font-weight: bold">Flight Scheduling</a></th>
					<th></th>
					<th><a href="PassengerlistServ"
						style="color: white; font-weight: bold">Passenger List</a></th>
					<th></th>
					<th><a href="feedbackSev"
						style="color: white; font-weight: bold">View Feedback</a></th>
					<th></th>
					<th><a href="logout"
						style="color: white; font-weight: bold">Log Out</a></th>
					<th><h2 style="color:#E6E8FA; font-weight: bold;float:right;margin-left:260px">Welcome <%
	String user=(String)session.getAttribute("uname");
	out.println(user);
	%></h1></th>
				</tr>
			</table>

		</font>
	</div>
	
</body>
</html>
