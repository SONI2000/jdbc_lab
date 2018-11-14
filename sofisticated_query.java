package jdbc;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class sofisticated_query {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
		
		String url = "jdbc:mysql:thin:root/secret@localhost:40000:xe" ;
		String user = "root";
		String pass = "secret";
		
		Connection connexion=null;
		
		try {
			 connexion = DriverManager.getConnection(url, user, pass);
	
			
			
			
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
		           
		
		     Statement statement = connexion.createStatement();
		     String query=null;
		     // converting command line argument into query
		     for (int i=0;i<args.length;i++){
		    	 query+=args[0]+" ";
		     }    
		     
		     
		          ResultSet resultat= statement.executeQuery(query);
		           String data[];
		           String display[];
		          if(args[0]=="select" || args[0]=="SELECT"){
		        	  
		        	 
					        	 // to fetch the header of array
					        	  display=new String[args.length];
					        	 for(int i=1;i<args.length;i++){
					        		     if (args[i]=="from" || args[i]=="FROM")
					        			    break; // exit from for loop
					        		       else
					        			   display[i-1]=args[i];
					                   }
					        	   
					        	   int row=0;
					        	   data=new String[args.length];
					        	   try{
					        	 while (resultat.next()) {
						                for(int i=0;i<display.length;i++){
						                 data[i]=resultat.getString(display[i]);
						                  System.out.print(data[i]); 
						                }
						                System.out.println("");
						                row++;
						        
						           }// end of while
					        	 System.out.println(+row +" affected");
					        	 }
					        	   catch (SQLException e) {
					                      e.printStackTrace();
					                   }
					        	 resultat.close();
					        	 
		               }//end of if
					        	 
					 // not a select query      	 
		          else{
		        	  int row=0;
		        	   try{
		        	 while (resultat.next()) {
			         
			                row++;  // no need to display data only affected row
			        
			           }// end of while
		        	 System.out.println(+row +" affected");
		        	 }
		        	   catch (SQLException e) {
		                      e.printStackTrace();
		                   }
		        	 resultat.close();
		        	  
		        	  
		          }
		      
	}
}
		     
		
		   
	            