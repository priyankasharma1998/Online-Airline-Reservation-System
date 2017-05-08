<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booked Ticket</title>
<link type="text/css" rel="stylesheet" href="new.css" />

</head>
<body>

<div class="my-container">
			<div style="z-index: 1;
	/*position: fixed;*/
	width: 105%;
	margin-top: -35px;
	margin-left: -8px;
	margin-right: -4px;
	height: 110px;
	background-color:purple;">
				<h1 style="text-align: center;
	line-height:95px;
	margin-left: 150px;
	margin-top: 35px;
	padding-bottom: -26px;
	font-size: 43px;
	font-style: italic;
	font-family: 'Tahoma';
	/*font-weight:bold;*/
	color:white;">Airline Reservation </h1>
				
			</div>
		</div>
<div style="width: 105%; height: 27px; margin-left: -7.5px; padding: 1em; margin-top: 0px; background-color:#6600CC; margin-right:-20px;">
		<ul>
			<li id="topic"><a href="History">HISTORY</a></li>
			<li id="topic2"><a href="FlightSearch.jsp">RESERVATION</a></li>
			<li id="topic1"><a href="usermodule.ShowFeedback">FEEDBACK</li>
			
			<li id="cat1"><a href="usermodule.LogoutServlet">LOG OUT</a></li>
			<li id="cat2"><a href="ChangePassword.jsp">CHANGE PASSWORD</a></li>
		</ul>

	</div>

	</div>
<font size="6" weight=normal color=blue>
<h2 style="text-align:center">Booked Ticket Details</h2>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>

<%
	//String AirlineId = (String)session.getAttribute("AirlineId");
	String Username=(String)session.getAttribute("Username");
//	int flno=Integer.parseInt(AirlineId);    
     ResultSet rs=(ResultSet)session.getAttribute("rs");
       %>
       
     <div id="nav">
      <font size="5" weight=normal color=red>
      FLIGHT DETAIL
      <font size="3" weight=normal color=black>
      <table id="t01" cellpadding="15" border="1" style="background-color: #ffffcc;text-align:center">
         <tr>
         <th>FLIGHT ID</th>
         <th>FLIGHT NAME</th>
         <th>SOURCE</th>
         <th>DESTINATION</th>
         <th>DATE</th>
         <th>TIME</th>
         <th>TYPE</th>
         <th>PRICE</th>
        </tr>
        <%while(rs.next()){ %>
      <TR>
      <TD><%=rs.getString(2)%></TD>
      <TD><%=rs.getString(3)%></TD>
      <TD><%=rs.getString(4)%></TD>
      <TD><%=rs.getString(5)%></TD>
      <TD><%=rs.getString(6)%></TD>
      <TD><%=rs.getString(7)%></TD>
      <TD><%=rs.getString(8)%></TD>
      <TD><%=rs.getString(9)%></TD>
      </TR></table>
     
      <%}
     ResultSet rs2=(ResultSet)session.getAttribute("rs2");
      %>
      <br>
      <font size="5" weight=normal color=red>
      PASSENGER DETAILS
      <font size="3" weight=normal color=black>
<table id="t01" cellpadding="15" border="1" style="background-color: #ffffcc;">
<tr>
         <th>FIRST NAME</th>
         <th>LAST NAME</th>
         <th>DOB</th>
         <th>GENDER</th>
        </tr>
       <%while(rs2.next()){ %>
         <TR>
         <TD><%=rs2.getString(4)%></TD>
         <TD><%=rs2.getString(5)%></TD>
         <TD><%=rs2.getString(6)%></TD>
         <TD><%=rs2.getString(7)%></TD>
         </TR>
         <%} %>
</table>

</font>
<font size="+3" color="red"></b>


</table>
<br><table>
</table>
</div>
</font>
</body>
</html>