package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class simple_query {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
		
		String url = "jdbc:mysql:thin:root/secret@localhost:40000:xe" ;
		String user = "root";
		String pass = "23832681";
		
		Connection connexion=null;
		
		try {
			 connexion = DriverManager.getConnection(url, user, pass);
	
			System.out.println("Database Connected");
			
			
			
		   }     catch (SQLException e) {
			             e.printStackTrace();
		           }  finally {
			            if (connexion != null)
			                	try {
					                  connexion.close();
				                    } catch (SQLException ignore) {
					                        ignore.printStackTrace();
				                          }
		                        }
		             
	 }
		
	
	public  static void displaytable( Connection connexion) throws SQLException {
		      Statement statement = connexion.createStatement();
		
		     ResultSet result = statement.executeQuery("SELECT Last_name  FROM actor");
		
		   
	             try {
	            while (result.next()) {
	                System.out.println(result.getString("Last_name"));
	                   }
	              } 
	                 catch (SQLException e) {
	                      e.printStackTrace();
	                   }
			
		     resultat.close();


	}

}
