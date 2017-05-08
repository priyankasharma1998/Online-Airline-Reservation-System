package usermodule;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

			public Connection getCon(){
				
				Connection con=null;
				
				
				try {
					Class.forName("org.hsqldb.jdbcDriver");
					String url = "jdbc:hsqldb:hsql://localhost/";
					con = DriverManager.getConnection(url, "sa", "");
					
					
				} catch(Exception e) {
					System.err.print("ClassNotFoundException: ");
					System.err.println(e.getMessage());
				}

				return con;
				
			}
			
			public Statement getStmt(){
				Statement stmt=null;
				try{
					
				DatabaseConnector obj=new DatabaseConnector();
				Connection con=obj.getCon();
				stmt = con.createStatement();
				}
				catch(Exception e){
					System.out.println("Statement");
				}
				
				return stmt;
			}
			
			public static void closeCon(Connection con){
				
				try {
						con.close();
				}
				
				catch(Exception e){
					System.out.println(e);
				}
					
			}
			
			public static void closeStmt(Statement stmt){
							
							try {
									stmt.close();
							}
							
							catch(Exception e){
								System.out.println(e);
							}
								
			}
			
			
}
