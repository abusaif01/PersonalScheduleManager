import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.*;
public class just_get_the_table_with_query
{
	public static void main (String[] args) {
		String user="root";
		String pass="root";
	 
	  String driver   = "com.mysql.jdbc.Driver";
	  String database_url="jdbc:mysql://localhost:3306/saif";//here "saif" is the database.
	  Connection con;
	  Statement statement;
	  ResultSet reslt_model;
	  ResultsModel useable_result=new ResultsModel();
		
		
		try{
			
		  Class.forName(driver);  
			con=DriverManager.getConnection(database_url,user,pass);
			System.out.println ("the connection is "+con);
			statement= con.createStatement();
			
			String query=new String();
			Scanner in= new Scanner(System.in);
			query=in.nextLine();
			reslt_model=statement.executeQuery(query);
			useable_result.setResultSet(reslt_model);
			int cl,rw;
			cl=useable_result.getColumnCount();
			rw=useable_result.getRowCount();
			String column=new String();
			System.out.println ("the number of colum and row ="+cl+" "+rw);
			for(int i=0;i<cl;i++)
			{
				column=useable_result.getColumnName(i);
				System.out.println ("the names of column :"+column);
				}
				
				
				
				
				
				
			statement.close();
			con.close();
			}
			catch(ClassNotFoundException cnf)
	     	{
				System.err.println(cnf);
				}
				catch(SQLException sqle)
				{
					System.err.println(sqle);
					}

	}

}
