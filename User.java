package usermodule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User {
		
		 			private String Title;
		 			private String FirstName;
		 			private String LastName;
		 			private String Mobile;
		 			private String Address;
		 			private String Gender;
		 			private String DOB;
		 			private String Username;
		 			private String Password;
					
					
					User(String t,String F,String L,String dob,String Gen,String Add,String M,String user,String pass){
						
						
								this.setTitle( t);
								this.setFirstName(F);
								this.setLastName(L);
								this.setMobile(M);
								this.setAddress(Add);
								this.setGender(Gen);
								this.setUsername(user);
								this.setDOB(dob);
								this.setPassword(pass);
								
						
					}
					
					public User(String username,String pass){
						this.setUsername(username);
						this.setPassword(pass);
					}
					
					
					
					public String getTitle() {
						return Title;
					}
					public void setTitle(String title) {
						Title = title;
					}
					public String getFirstName() {
						return FirstName;
					}
					public void setFirstName(String firstName) {
						FirstName = firstName;
					}
					public String getLastName() {
						return LastName;
					}
					public void setLastName(String lastName) {
						LastName = lastName;
					}
					public String getMobile() {
						return Mobile;
					}
					
					
					public void setMobile(String mobile) {
						Mobile = mobile;
					}
					public String getAddress() {
						return Address;
					}
					public void setAddress(String address) {
						Address = address;
					}
					public String getGender() {
						return Gender;
					}
					public void setGender(String gender) {
						Gender = gender;
					}
					public String getDOB() {
						return DOB;
					}
					public void setDOB(String dOB) {
						DOB = dOB;
					}
					public String getUsername() {
						return Username;
					}
					public void setUsername(String username) {
						Username = username;
					}
					public String getPassword() {
						return Password;
					}
					public void setPassword(String password) {
						Password = password;
					}
					
					public boolean LoginCheck(){
						
							boolean flag=false;
							
							String correctPassword=null;
							String correctUsername=null;
							try{
									DatabaseConnector obj=new DatabaseConnector();
									Connection con=obj.getCon();
									Statement stmt = obj.getStmt();
									
									String query = "select * from USER";
									
									stmt.executeQuery(query);
									ResultSet rs =stmt.getResultSet();
									while(rs.next())
								    {
												
								            	  correctPassword=rs.getString(2);
								            	  correctUsername=rs.getString(1);
								            	//  System.out.println(correctPassword+" "+correctUsername+" "+Username+" "+Password);
								            	  if(correctPassword.equals(getPassword()) && correctUsername.equals(getUsername())){
								            		  flag=true;
								            		  break;
								            		  
								            	  }
								            	  
								   }
									
									DatabaseConnector.closeCon(con);
									DatabaseConnector.closeStmt(stmt);
									return flag; 
								
								}
							catch(Exception e){
								System.out.println("Exception in verify password "+e.toString());
								return false;
							}
						
					}

					int storeInDatabase(){
							int result=0;
							
						try{
							DatabaseConnector obj=new DatabaseConnector();
							Connection con=obj.getCon();
							Statement stmt = obj.getStmt();
							
							String query="insert into USER "+ "values("+"'"+getUsername()+"'"+","+"'"+getPassword()+"'"+","+"'"+getTitle()+"'"+","+"'"+getFirstName()+"'"+","+"'"+getLastName()+"'"+","+"'"+getDOB()+"'"+","+"'"+getGender()+"'"+","+"'"+getAddress()+"'"+","+"'"+getMobile()+"'"+")";
							result=stmt.executeUpdate(query);
							
							DatabaseConnector.closeCon(con);
							DatabaseConnector.closeStmt(stmt);
						}
						catch(Exception e){
							System.out.println("Error in connecting database");
						}
						
						return result;
					}
			 
					void addFeedback(String feed){
					
						try{
							
							DatabaseConnector obj=new DatabaseConnector();
							Connection con=obj.getCon();
							Statement stmt = obj.getStmt();
							
							String query="insert into FEEDBACK "+ "values("+"'"+getUsername()+"'"+","+"'"+feed+"'"+")";
						//	System.out.println(query);
							stmt.executeUpdate(query);
							
							DatabaseConnector.closeCon(con);
							DatabaseConnector.closeStmt(stmt);
						}
						catch(Exception e){
							System.out.println("Error in connecting database");
						}
						
					}
					
					
					
					
					int changePassword(String pass){
						
							int result=0;
							try{
								
								DatabaseConnector obj=new DatabaseConnector();
								Connection con=obj.getCon();
								Statement stmt = obj.getStmt();
								
								String query="Update User set Password="+"'"+pass+"'"+" where username="+"'"+getUsername()+"'";
							//	System.out.println(query);
								result=stmt.executeUpdate(query);
								
								DatabaseConnector.closeCon(con);
								DatabaseConnector.closeStmt(stmt);
							}
							catch(Exception e){
								System.out.println("Error in connecting database");
							}
							
							return result;
					}
					
					 ResultSet showFeedback(){
						 ResultSet rs=null;
						 try{
								DatabaseConnector obj=new DatabaseConnector();
								Connection con=obj.getCon();
								Statement stmt = obj.getStmt();
								
		
						      
							   String QueryString = "SELECT * from FEEDBACK where username="+"'"+getUsername()+"'";
						    //   System.out.println(QueryString);
						       rs = stmt.executeQuery(QueryString);
						       
						       DatabaseConnector.closeCon(con);
							   DatabaseConnector.closeStmt(stmt);
						       
						       
						 }
						 	catch(Exception e){
								System.out.println("Error in connecting database");
							}
						 
						 return rs;
					}
					 
					 ResultSet showHistory(){
						 ResultSet rs=null;
						 try{
								DatabaseConnector obj=new DatabaseConnector();
								Connection con=obj.getCon();
								Statement stmt = obj.getStmt();
								
		
						      
								 String QueryString = "SELECT * from HISTORY where username="+"'"+getUsername()+"'";
						    //   System.out.println(QueryString);
						       rs = stmt.executeQuery(QueryString);
						       
						       DatabaseConnector.closeCon(con);
							   DatabaseConnector.closeStmt(stmt);
						       
						       
						 }
						 	catch(Exception e){
								System.out.println("Error in connecting database");
							}
						 
						 return rs;
					 }
					 
					 

}
