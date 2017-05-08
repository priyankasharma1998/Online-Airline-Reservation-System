<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility 
	 
	String usename = (String) session.getAttribute("uname");
	String usename1 = (String) session.getAttribute("Username");
	//System.out.println("Helllo "+usename);
	if (usename != null) 
		response.sendRedirect("PassengerlistServ");
	else if(usename1!=null)
		response.sendRedirect("History");
	else{
		
	
%>
<!DOCTYPE html>
<html>
<head>
	
	<title>Airline Reservation System</title>
	
	<link type="text/css" rel="stylesheet" href="login.css" />
</head>
<body >
	
		<div id="header">
			<h1 style="color:white">Airline Reservation System</h1>
		</div>



<div id="nav">
<font size="4" weight=normal color=black>
<ul>
	<li><a style="color:black ;font-size:32px;font-weight:bold" href="SignUp.jsp">Register</a></li>
	<!-- <li><a style="color:black ;font-weight:bold" href="forgotpassword.jsp">Forgot Your Password</a></li>-->
</ul>
</font>
</div>
<div style="
   height:450px;
   width:1500px;
   float:right;
   
   font-family:arial;">		
			<form style="margin-right:150px;font-weight:bold;align:center;font-size: 14px;margin-top: 110px;color: #000000;" method="post" action="validate1">
				<label style="font-size: 25px;color: #000000;">Email</label><br>
					<input  type="email" name="name" required><br>
				<label style="font-size: 25px;color: #000000" >Password</label><br>
					<input   type="Password" name="passw" required><br>	
				<input type="radio" name="type" value="Admin" required>Admin
				<input type="radio" name="type" value="User" required>User<br>
				<br>
				 <input style="font-size:20px;color: #000000;" type="submit" name="password" value="Log in" > 
			 </form>
</div>		
</body>
</html>
<%
	}
%>
