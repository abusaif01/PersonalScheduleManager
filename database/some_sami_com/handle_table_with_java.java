import java.sql.*;

public class handle_table_with_java
{
	
	 String driver="com.mysql.jdbc.Driver";
	 String	database_url="jdbc:mysql://localhost:3306/saif";
	  static Connection con;
	  static Statement statement;
	public handle_table_with_java()
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
		//	java.sql.Date dt;
		//	dt=new java.sql.Date(yr-m-d);
		//	System.out.println ("integer is  :"+a);
		//	insert_value(dt,str);
	}
		public void execute_querey(java.sql.Date date,String oc)
		{

		try
		{
			PreparedStatement st= con.prepareStatement("INSERT INTO imd (date,ocation) VALUES(?,?);");
			st.setDate(1,date);
			st.setString(2,oc);
			st.execute();
			System.out.println ("added");
			}
			catch(SQLException se)
			{
				System.err.println(se);
				}
		
		}
										
				
}