<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script type = "text/javascript" >
		function disableBackButton()
		{
			window.history.forward();
		}
		setTimeout("disableBackButton()", 0);
	</script>

</head>

<link type="text/css" rel="stylesheet" href="History.css" />

<body>
		<div class="my-container">
			<div id="header">
				<h1><i>Airline Reservation System<i></h1>
				
			</div>
		</div>
	
	
	<div style="width: 105%; height: 27px; margin-left: -7.5px; padding: 1em; margin-top: 0px; background-color:#6600CC; margin-right:-20px;">
		<ul>
			<li id="topic"><a href="History">HISTORY</a></li>
			<li id="topic2"><a href="FlightSearch.jsp">RESERVATION</a></li>
			<li id="topic1"><a href="ShowFeedback">FEEDBACK</li>
			
			<li id="cat1"><a href="LogoutServlet">LOG OUT</a></li>
			<li id="cat2"><a href="ChangePassword.jsp">CHANGE PASSWORD</a></li>
		</ul>

	</div>
	<h1  style="color:purple">Welcome <%
	String us=(String)session.getAttribute("Username");
	out.println(us);
	%></h1>
		
</body>

</html>