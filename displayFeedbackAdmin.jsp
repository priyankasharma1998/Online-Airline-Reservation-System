<%
	
	String userName = (String) session.getAttribute("uname");
	if (userName == null) {
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
<title>Feedback</title>
</head>
<link type="text/css" rel="stylesheet" href="schedule.css" />
<script type = "text/javascript" >
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

<body>

</head>

<body>
	<jsp:include page="headeradmin.jsp" />
	
	<div
		style="margin: auto; width: 50%; margin-top: 40px;/*border: 1px solid #73AD21;*/ padding: 15px;">
		<h1 style="margin-left: 20px; text-align: center; background-color: #E6E6FA;margin-top: 70px;color:#660099">FEEDBACK</h1>
		
		<%@ page import="java.util.*" %>
		<%@ page import="java.io.*" %>
		<%@ page import="java.sql.*" %>
		
		
		
		<%
		
		   
		       System.out.println("hello");
		       ResultSet rs=(ResultSet)session.getAttribute("rs1");
		       System.out.println(rs);
		    
		      
			%>
		<div id="list">
			<table>
				<tr>
					
					<th>USER NAME</th>
					<th>FEEDBACK</th>
					
					
				</tr>	
			
			
			<% while(rs.next()){ %>
					<tr>
						<td><%=rs.getString(1) %></td>
						<td><%=rs.getString(2) %></td>
												
					</tr>			
						
			<%} %>
			</table>
			
		
		
	</div>
</body>
</html>

<%
	}
%>