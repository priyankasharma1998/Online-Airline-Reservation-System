package adminmodule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
	
	private String userName;
	private String pass;
	
	Admin(String user,String pass){
		setUserName(user);
		setPass(pass);
	}
	
	int storeInDatabase(){
		int i=0;
		try{
				
				databaseConnector dl = new databaseConnector();
				Connection con = dl.getCon();
				Statement st = dl.createStatement(con);
									
						String query="insert into ADMIN "+ "values("+"'"+userName+"'"+","+"'"+pass+"'"+")";
						System.out.println(query);
						i=st.executeUpdate(query);
						
						databaseConnector.closeCon(con,st);	
					} 
					catch(SQLException ex) {
					//	System.err.println("SQLException: " + ex.getMessage());
					}
					return i;
					
				}

	
	boolean valid(){
		
		boolean flag=false;
		String correctUser=null;
		String correctPassword=null;
		try{
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			String query = "select * from ADMIN";
			
			st.executeQuery(query);
			ResultSet rs =st.getResultSet();
			while(rs.next())
		              {
		            	  correctPassword=rs.getString(2);
		            	  correctUser=rs.getString(1);
		            	 
		            	  if(correctPassword.equals(this.pass) && correctUser.equals(this.userName)){
		      				flag= true;
		      				break;
		      			}
		      			else
		      				flag=false;
		              }
			databaseConnector.closeCon(con,st);
			/*if(correctPassword.equals(this.pass)){
				return true;
			}
			else
				return false;
		            	  	*/
			return flag;
	              
	        	
			}
		catch(Exception e){
			System.out.println("Exception in verify password "+e.toString());
			return false;
		}
			
		}
			
        
		
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/*public static void main(String[] args) {
		Admin a=new Admin();
		a.valid();
	}*/
}
