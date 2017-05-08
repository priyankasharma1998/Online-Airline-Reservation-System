package adminmodule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FeedbackClass {
	
	
	ResultSet displayfeed(){
		
		try{
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
		    String Query = "SELECT * from Feedback";
		     
		    ResultSet rs = st.executeQuery(Query); 
		    return rs;
			
		}
		catch(Exception e){
			System.out.println("Sql Exception");
			return null;
		}
		
		
	}
	
	

}


