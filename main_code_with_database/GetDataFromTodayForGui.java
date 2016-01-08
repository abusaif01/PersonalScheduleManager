import java.sql.*;
public class GetDataFromTodayForGui
{
	database_connection connection=new database_connection();
	ResultSet set;
	int t_row;
	ResultsModel model=new ResultsModel();
	recent_time rct=new recent_time();
	public GetDataFromTodayForGui()
	{
	try{
		new collect_from_other_table_to_today((rct.get_recent_time()));
		Statement st=connection.con.createStatement();
		set=st.executeQuery("SELECT * FROM today;");
		model.setResultSet(set);
		t_row= model.getRowCount();
		}
	catch(SQLException e)
	{
		System.err.println (e);
		}
	}
}