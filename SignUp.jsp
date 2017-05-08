<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new account</title>

	<script type = "text/javascript" >
		function disableBackButton()
		{
			window.history.forward();
		}
		setTimeout("disableBackButton()", 0);
	</script>
</head>

<link type="text/css" rel="stylesheet" href="SignUp.css" />
<body>
	<form method="post" action="SignUpServlet">
		<div class="my-container">
			<div id="header">
				<h1>Airline Reservation System</h1>
				
			</div>
		</div>
	
		
        
        <div class="my-container">
          
            <div id="section">
        	
        		<br><hr size=1px color=#6600CC></hr>
        		
        		<div id="highlight">Personal Information:</div>
        		<br>
        		
        		
        			<b6>Title</b6><br> 
        				<select name="title">
			        			<option value="title" selected>Select Title</option>
			        			<option value="Mr.">Mr.</option>
			        			<option value="Mrs.">Mrs.</option>
			        			<option value="Miss">Miss</option>
			        			
        				</select> <br>
        		
        		<table border="0">      
        			<tr> 
        				<td><b6>First Name</b6></td>
        				<td><b6>Last Name</b6></td>
        			</tr>
        			<tr>
        				<td><input type="text" name="firstname" Required></td>
        				<td><input type="text" name="lastname" Required></td>
        			</tr>
        			<tr>
        				<td><b6>Date of Birth</b6></td>
        				<td><b6>Gender</b6></td>
        				
        			</tr>
        			<tr>
        				<td><input type="date" name="dob"></td>
        				<td><select name="gender">
        						<option value="gender" selected>Select</option>
        						<option value="Female">Female</option>
        						<option value="Male">Male</option>
        					</select></td>
        				
        			</tr>
        		</table>
        		<br><hr size=1px color=#6600CC></hr>
        		<div id="highlight">Contact Information:</div>
        		
        		
                <table border="0">
        			<tr>
        				<td><b6>Address</b6></td>
        				<td><b6>Mobile Number</b6></td>
        			</tr>
        			<tr>
        				<td><input type="text" name="address" Required></td>
        				<td><input id="mobile" type="text" name="MobileNo" Required></td>
        			</tr>
        		
        		</table>
        		<br><hr size=1px color=#6600CC></hr>
        		 <div id="highlight">Account Details:</div>
        	
        		<table border="0">
        			<tr>      
        				<td><b6>Username</b6></td>    
        				<td><b6>Password</b6></td> 
        				<td><b6>Confirm Password</b6></td>
        			</tr>
        			<tr>
        				<td><input type="email" name="username" value=" " Required></td>
        				<td><input id="pass" type="password" name="password" Required></td>
        				<td><input id="conf" type="password" name="confirmPassword:" Required></td>
        			</tr>
        		</table>
        		<br><hr size=1px color=#6600CC></hr>
        		<p style="text-align:center"><input style="background-color:#6600CC;color:white" type="submit" value="Register" onclick="myFunction1()"></p>
    			<br><hr size=1px color=#6600CC></hr>
    			
    		</div>
    	</div>
    	
    </form>
    
    <script>
			var passs = document.getElementById("pass");
			var confirmpass = document.getElementById("conf");
			 var phoneno = /^\d{10}$/;  
			 //document.writeln(phoneno);
			 var mobile=document.getElementById("mobile");
				
			 
				function myFunction1() {
					
					
							if(passs.value != confirmpass.value)
						    {
						    		confirmpass.setCustomValidity("Passwords Don't Match");
						    }
						   	else
						   			confirmpass.setCustomValidity("");
							
							if(mobile.value.match(phoneno))  
							{  
								mobile.setCustomValidity("");
							}  
							else  
							{  
								mobile.setCustomValidity("Not a valid number");
							}  
							
		       }

	</script>
</body>
</html>
