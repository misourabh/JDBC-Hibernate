package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcSelectDemo 
{
	public static void main(String[]args)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection
                                  ("jdbc:mysql://localhost:3306/WEJA1?" + "user=root&password=root");	
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from student");
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" | "+
			                        resultSet.getString(2)+" | "+
			                        resultSet.getString(3)+" | "+
			                        resultSet.getString(4));
			}
			connection.close();
			statement.close();
			resultSet.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
