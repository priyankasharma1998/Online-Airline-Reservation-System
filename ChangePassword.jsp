<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChangePassword</title>
</head>
<link type="text/css" rel="stylesheet" href="History.css" />

<body>
	
	<jsp:include page="header.jsp" />
	
	
	
		<br><br>
		<form action="ChangeServlet" method="post">
		
				<div style="color:blue; padding-left:350px;">
						<label><b style="font-size:20px;">ENTER YOUR CURRENT PASSWORD</b></label><br>
						<input id="pass" style="width:300px;" type="password" name="p1"><br><br>
						<label><b style="font-size:20px;">ENTER YOUR NEW PASSWORD</b></label><br>
						<input id="npass" style="width:300px;" type="password" name="p2"><br><br>
						<label><b style="font-size:20px;">CONFIRM YOUR PASSWORD</b> </label><br>
						<input id="npass1" style="width:300px;"  type="password" name="p3"><br><br>
				</div>
				<center><input style="background-color:#6600CC;color:white; margin-right:300px;" type="submit"  name=""  onclick="myFunction1()"></center>
		</form>
		
		<% String Password=(String)session.getAttribute("Password");
			%>
		<script>
			
			var passs = document.getElementById("npass");
			var confirmpass = document.getElementById("npass1");
			var old = '<%= Password %>';
			var oldPass=document.getElementById("pass");
			
			function myFunction1() {
				
				if(old !=oldPass.value){
					oldPass.setCustomValidity("Enter correct Password");
				}
				if(passs.value != confirmpass.value)
			    {
						
			    		confirmpass.setCustomValidity("Passwords Don't Match");
			    }
			 //  	else
			  // 		alert("Password Changed Succesfully, Now Login Again");		
			}

	</script>

</body>
</html>