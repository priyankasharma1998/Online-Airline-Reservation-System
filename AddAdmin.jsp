<%
	/*response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility */
	String u = (String) session.getAttribute("uname");
	//System.out.println("Helllo "+usename);
	if (u == null) {
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
<title>Add new Admin</title>
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
		style="margin: auto; width: 50%; margin-top: 40px;
	/*border: 1px solid #73AD21;*/ padding: 15px;">
		<h1
			style="font-size: 40px; margin-left: 20px; text-align: center; margin-top: 70px; color: #660099;background-color: #E6E6FA;">Enter
			new Admin details</h1>

		<form
			style="margin-left: 50px; margin-right: 150px; font-size: 15px; margin-top: 40px; color: #000000;"
			method="post" action="newadminserv">
			<table>
				<tr>
					<label style="font-size: 20px;color:white;font-family:Arial ;font-weight: bold;background-color:#660099;">Enter
						Email</label>
					<br>
				</tr>
				<br>
				<tr>
					<input style="height: 20px; width: 250px" type="email" name="name" placeholder="Enter email"
						required>
					<br>
				</tr>
				<br>
				<tr>
					<label style="font-size: 20px;color:white;font-family:Arial;font-weight: bold;background-color:#660099;">Enter
						Password</label>
					<br>
				</tr>
				<br>
				<tr>
					<input style="height: 20px; width: 250px" type="Password" placeholder="Enter password"
						name="passw" id="passw" required>
					<br>
				</tr>
				<br>
				<tr>
					<label style="font-size: 20px; color: white;font-family:Arial;font-weight: bold;background-color:#660099;">Confirm 
						Password</label>
					<br>
				</tr>
				<br>
				<tr>
				
					<input style="height: 20px; width: 250px" type="Password" placeholder="Confirm Password"
						name="passw1" id="passw1" required>
					<br>
					<br>
				</tr>
				<br>
				
				<tr>
					<input style="height: 50px;color: #660099; font-weight: bold; font-size: 20px;background-color:#F0F8FF;"
						type="submit" name="subm" value="Make new Admin" onclick="myFunction1()">
				</tr>
			</table>

			
		</form>
		<script>
			var passs = document.getElementById("passw");
			var confirmpass = document.getElementById("passw1");
				function myFunction1() {
				if(passs.value != confirmpass.value)
			    {
						alert("Password dont match");
						
			    		confirmpass.setCustomValidity("Passwords Don't Match!! Please try Again");
			    }
			   	else
			   			confirmpass.setCustomValidity("");
			 
			
		}
	</script>
	</div>

</body>
</html>
<%
	}
%>
