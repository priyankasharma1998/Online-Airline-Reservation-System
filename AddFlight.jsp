<%


	String useame = (String) session.getAttribute("uname");
	//System.out.println("Helllo "+usename);
	if (useame == null) {
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
<link type="text/css" rel="stylesheet" href="allstyle.css"/>
<title>ADD Flights</title>
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
	<form action="NewFlightServ" method="post" >
		
		<br><hr size=1px color=#6600CC></hr>
		
		<div id="highlight">Add New Flight Details:</div>

	

	<div class="my-container">

		<div id="section">

			<br>

			<table border="0">
				<tr>
					<td><b6>Flight Id*</b6></td>
					<td><b6>Flight Name*</b6></td>
				</tr>
				<tr>
					<td><input type="number" name="fid" required></td>
					<td><input type="text" name="fname" required></td>
				</tr>
				<tr>
					<td><b6>Source*</b6></td>
					<td><b6>Destination*</b6></td>
					<td><b6>Date*</b6></td>
					<td><b6>Time*</b6></td>
					

				</tr>
				<tr>
					<td><input type="text" name="fsrc" id="src" required></td>
					<td><input type="text" name="fdest" required></td>
					<td><input type="date" name="fdate" required></td>
					<td><input type="time" name="ftime" required></td>
					
				</tr>
			</table>	
			<br>
			<hr size=1px color=#6600CC></hr>
			<div id="highlight">Class:</div>


			<table border="0">
				<b6>Class*</b6><br> 
        				<select name="classN" required>
			        			<option value="classN" selected>Select Class</option>
			        			<option value="Business" >Business Class</option>
			        			<option value="Economic" >Economic class</option>
			        			
			        			
        				</select> <br>
				
				<tr>
					<td><b6>Total Capacity*</b6></td>
					<td><b6>Available Seats*</b6></td>
					<td><b6>Price*</b6></td>
					
				</tr>
				<tr>
					<td><input type="number" name="Tseats" required></td>
					<td><input type="number" name="ASeats" required></td>
					<td><input type="text" name="fprice" required></td>
				</tr>

			</table>
			<br><hr size=1px color=#6600CC></hr>
			<p style="text-align: center;">
				<input style="background-color: #6600CC;height:50px;width:200px; color:white; font-weight:bold;font-size:20px;float:left" type="submit"
					value="Add flight" 	">
			</p>
			<br>
			
			<script type="text/javascript">
				function alertName(){
					
						alert("Flight inserted successfully");
					
				} 
			</script> 

		</div>
	</div>
	</form>
</body>
</html>
<%
	}
%>