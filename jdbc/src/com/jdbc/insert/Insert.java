package com.jdbc.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Insert 
{
  private static Connection connection;
  private static PreparedStatement preparedStatement;
  private static int result;
  private static FileReader fileReader;
  private static Properties properties;
  private static String query;
  private static String filePath="D:\\WEJA1\\jdbc\\Resources\\db_info.properties";
   
  public static void main(String[]args)
   {
	   try {
		fileReader=new FileReader(filePath);
		
		 properties=new Properties();
		 
		 properties.load(fileReader);
		 
		Class.forName(properties.getProperty("driverPath"));
		
		connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		
		query="insert into " 
		       + "student values " 
			   + "(?,?,?,?)";
		
		preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setInt(1,10);
		preparedStatement.setString(2, "vaibhav");
		preparedStatement.setString(3, "vaibhavkedar12@gmail.com");
		preparedStatement.setLong(4, 7058981413l);
		
		result=preparedStatement.executeUpdate();
		
		System.out.println
		("Query OK, " + result + " row(s) affected.");
		
	   
	  } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   
	   finally
	   {
			  try {
				  if(connection !=null)
				  {  
					  connection.close();
				  }
				    
				  if(preparedStatement !=null)
				   {
					   preparedStatement.close();
				   }
				  
				  if(fileReader !=null)
				  {
					  fileReader.close();
				  }
				  
			  
			  
			  }
				  catch (SQLException e)
				  {
				      e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
				}
		  
			 
		 
	   
   }
  
   } 
}
