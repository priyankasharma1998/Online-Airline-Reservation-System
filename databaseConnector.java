package adminmodule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnector {
	
	
	public Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");
			
		}
		catch(Exception e){
			System.out.println("Connection Not Established");
		}
		return con;
	}
	
	public Statement createStatement(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt=null;
		try{
	        
	        stmt = con.createStatement();
		}
		catch(SQLException ex) {
	    	System.out.println("Statement not created");
	 	} 
		return stmt;
		
		
	}
	
	
	public static void closeCon(Connection con,Statement stmt)
	   {
		   try
		   {
			   stmt.close();
			   con.close();
		   }
		   catch(SQLException e)
	   	   {
			   System.out.println("SQL");
	   	   }
		   catch(Exception e)
		   {
			   System.out.println("Exceptiion");
		   }
		   
	   }
    
    
    
    

}
