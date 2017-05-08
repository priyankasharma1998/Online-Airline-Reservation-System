<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancellation Request</title>

   <link type="text/css" rel="stylesheet" href="old.css" />


</head>
<body>

<div style=" font-family:arial;
            font-size: 20px;
            font-weight:bold;
            text-align:center;
            border: 1px solid purple;
            width: 105%;
           	background-color:purple;
            color:white;
            margin-top: -25px;
			margin-left: -15px;
			height: 105px;">
			<h1>Cancellation of Ticket</h1>
</div>
<font size="6" weight=normal color=blue>
<h2 style="text-align:center">Booked Ticket Details</h2>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="usermodule.History"  %>
<%
     System.out.println("Cancel");
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
      
      <%
     }
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
<%while(rs2.next()) {%>
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
<TR>
<TD><FORM ACTION="History" method="get" >
<button id="shdg" type="submit"><-- back</button></TD></FORM>
<TD><FORM ACTION="Cancellation" method="post">
<button  id="shdg" type="submit">CANCEL</button></TD></FORM>
</TR>
</table>
</div>
</font>
</body>
</html>