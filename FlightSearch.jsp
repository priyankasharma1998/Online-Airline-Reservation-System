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
<div class="login-page">
  <div class="form">
    
    <form class="login-form" method="post" action ="FlightInfoModule.CollectServlet">
      <input type="text" name = "Source" placeholder="Source"/>
      <input type="text"  name = "Destination" placeholder="Destination"/>
      <input type="Date" name = "Date" placeholder="Date"/>
      
      <button>Search</button>
      
       </form>
  </div>
</div>


		</div>
</body>
</html>