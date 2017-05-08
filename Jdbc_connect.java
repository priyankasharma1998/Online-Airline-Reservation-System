package FlightInfoModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_connect {
	String Source;
		String Date;
		String Time;
	String Destination1;
	String Type;
	String Price;
	String AvailableSeats;
	String NoofSeats;
	String FlightId;
	String FlightName;
	
	
	
	public Jdbc_connect(String Source, String Destination, String Date)
	{   this.Source = Source;
	this.Destination1 = Destination;
	this.Date = Date;
		
	}
	public Jdbc_connect(String FlightId)
	{
		this.FlightId = FlightId;
	
		
	}
	
	public ResultSet fun1() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		System.out.println("QUERRy ahhhh ");
		try{
			Class.forName("org.hsqldb.jdbcDriver");
		}
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try{ 
			String url = "jdbc:hsqldb:hsql://localhost/";
			System.out.println("QUERRy ahhhh ");
		  con =   DriverManager.getConnection(url,"sa","");
	      stmt =  con.createStatement();
	      System.out.println("QUERRy ahhhh ");
	      System.out.println(Source);
	      String query = "SELECT * FROM flight where SRC ="+"'"+Source+"'"+" and DEST="+"'"+Destination1+"'"+" and DATEI="+"'"+Date+"'";
	     // String query =  "SELECT FLIGHT_ID , FLIGHT_NAME , SRC , DEST  from flight where flight.SRC = Source and flight.DEST = Destination and flight.DATEI= Date ";
	      System.out.println("QUERRy"+query);
		 rs1 =stmt.executeQuery(query);
		
		 stmt.close();
			con.close();
		   
			 System.out.println("SRC and DEST AND DATE :");
	}	
		
		catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
		return rs1;
	}
public ResultSet fun2() {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs1 = null;
	System.out.println("QUERRy ahhhh ");
	try{
		Class.forName("org.hsqldb.jdbcDriver");
	}
	catch(java.lang.ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	}
	try{ 
		String url = "jdbc:hsqldb:hsql://localhost/";
		System.out.println("QUERRy ahhhh ");
	  con =   DriverManager.getConnection(url,"sa","");
      stmt =  con.createStatement();

		 String query =  "SELECT FLIGHT_ID , FLIGHT_NAME , SRC , DEST , DATEI ,TYPE , NOOFSEATS , AVAILABLESEATS , PRICE,TIME from flight , TYPESEATS  where flight.FLIGHT_ID = TYPESEATS.FLIGHT_ID and flight.TYPE=TYPESEATS.TYPE  and flight.FLIGHT_ID="+"'"+this.FlightId+"'";
		System.out.println(FlightId);
		 System.out.println(query);
		 
	     rs1 =stmt.executeQuery(query);
		
		 stmt.close();
			con.close();
			
	} 
	catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}
	
	return rs1;
	}
	
}

	
	


