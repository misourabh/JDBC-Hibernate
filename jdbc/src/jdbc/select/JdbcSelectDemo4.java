package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo4
{
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath="com.mysql.cj.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/WEJA1";
	private static String user="root";
	private static String password="root";
	private static String Query;
	
	public static void main(String[]args)
	{
		try {
			Class.forName(driverPath);
			
			connection=DriverManager.getConnection(dburl,user,password);
			
			statement=connection.createStatement();
			
			Query="select * from student";
			
			resultSet=statement.executeQuery(Query);
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" | "+
			                       resultSet.getString(2)+ " | "
			                       + resultSet.getString(3)
			                       + " | "+ resultSet.getString(4));
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) 
		{
			  e.printStackTrace();
		}
		finally 
		{   
			if(connection !=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if(statement !=null)
				{
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(resultSet !=null)
				{
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
			
			
			
		
			
			
			     
		}
	}
	
	
	

}
