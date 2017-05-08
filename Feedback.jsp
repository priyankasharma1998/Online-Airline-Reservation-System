<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Give Feedback</title>
</head>
<link type="text/css" rel="stylesheet" href="History.css" />
<body>

		<jsp:include page="header.jsp" />
		<div style="margin-top:50px;">
			
			<center>	
						<p style="color:red;">We are always ready to help you.Please help us by giving your feedback to improve Airline' facilities </p>
						<h1 style="color:blue;">Submit Your Feedback</h1>
						
						<form method="post" action="FeedbackServlet">
									
									<textarea name="content" style="width:50%; height:200px;"></textarea><br /><br />
									<input type="submit" value="Submit" />
						</form>
			</center>
		</div>
</body>
</html>