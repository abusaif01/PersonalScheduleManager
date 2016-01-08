import java.sql.*;

public class database_connection
{
	
	 String driver="com.mysql.jdbc.Driver";
	 String	database_url="jdbc:mysql://localhost:3306/saif";
	  static Connection con;
	  static Statement statement;
	public database_connection()
	{
		try
		{
		Class.forName(driver);
		con=DriverManager.getConnection(database_url,"root","root");
		System.out.println (con);
		statement= con.createStatement();
		}
		catch(ClassNotFoundException cnf)
		{
			System.err.println(cnf);
			}
			catch(SQLException qse)
			{
				System.err.println(qse);
			}
		System.out.println ("connection created succesfully");	
	}
	
	public static void main (String[] args) {
			new database_connection();
		}
}