import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;


public class get_dates_query
{
	ResultSet resultset;
	ResultsModel resulstmodel=new ResultsModel();
	int rw,cl;
	database_connection connection=new database_connection();
	public get_dates_query(java.sql.Timestamp date) throws SQLException
	{

		PreparedStatement prest= connection.con.prepareStatement("select * from upcomming where date_time=?;");
		prest.setTimestamp(1,date);
		prest.execute();
		resultset=prest.getResultSet();
		resulstmodel.setResultSet(resultset);
		rw=resulstmodel.getRowCount();
		cl=resulstmodel.getColumnCount();
		System.out.println ("found row are : "+rw);
		if(rw!=0)
		{
		System.out.println ("values  "+resulstmodel.getValueAt(0,3));
		System.exit(0);
		}
		
		}
}