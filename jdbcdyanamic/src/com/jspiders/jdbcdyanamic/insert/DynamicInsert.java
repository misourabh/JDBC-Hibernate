package com.jspiders.jdbcdyanamic.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DynamicInsert 
{
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static int result;
	private static Properties properties;
	private static  String filePath =  "D:\\WEJA1\\jdbc\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		try {
			fileReader = new FileReader(filePath);
			properties =new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
		     query = "insert into " 
			                  + "student values " 
		    		          + "(?,?,?,?)";
		     preparedStatement = connection.prepareStatement(query);
		   
		
		     

				preparedStatement.setInt(1, 42);
				preparedStatement.setString(2, "Babita");
				preparedStatement.setString(3, "babita@gmail.com");
				preparedStatement.setLong(4, 9876542310L);
		     
		     
		     
		     result = preparedStatement.executeUpdate();
		     System.out.println("QUERY OK " + result + " rowas()affcted");
		     
       	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}       if(preparedStatement !=null) {
				       try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}           if (fileReader !=null) {
				            try {
								fileReader.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			}
		}
	}
	
}
     
