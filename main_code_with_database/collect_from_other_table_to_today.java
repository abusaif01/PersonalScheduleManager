import java.sql.*;
public class collect_from_other_table_to_today
{
	database_connection connection=new database_connection();
	ResultSet set;
	String dd,mm,yy,temp;
	public collect_from_other_table_to_today(java.sql.Timestamp  dat)
	{
		temp=dat.toString();
		yy=temp.substring(0,4);
		mm=temp.substring(5,7);
		dd=temp.substring(8);
		System.out.println (temp+"  "+dd +"  "+mm+"  "+yy);
		
		blank_today();
		chk_in_daily();
//		chk_in_weakly();
		chk_in_monthly();
		chk_in_yearly();
		chk_in_once();
		}
		
		//chk in monthly.
	private void chk_in_monthly()
	{
		try
		{
			//from montly.
			String type="monthly";
			PreparedStatement pst=connection.con.prepareStatement("select * FROM monthly where date=?;");
			pst.setString(1,dd);
			pst.execute();
			set=pst.getResultSet();
			int number_of_rw=0;
			while(set.next())
			{
			number_of_rw++;
			Time dt_g=set.getTime("time");
			String oc=set.getString("ocation");
			insert_into_today(type,dt_g,oc);
			System.out.println (dt_g);
			}
			System.out.println ("number_of_rw :"+number_of_rw);
		}
		catch(SQLException e)
		{
			System.err.println(e);
			}
		}
		
		//chk in yearly;
		private void chk_in_yearly()
		{
		try
		{
			//from montly.
			String type="yearly";
			PreparedStatement pst=connection.con.prepareStatement("select * FROM yearly where date=?;");
			pst.setString(1,mm+"-"+dd);
			pst.execute();
			set=pst.getResultSet();
			int number_of_rw=0;
			while(set.next())
			{
			number_of_rw++;
			Time dt_g=set.getTime("time");
			String oc=set.getString("ocation");
			insert_into_today(type,dt_g,oc);
			System.out.println (dt_g);
			}
			System.out.println ("number_of_rw :"+number_of_rw);
		}
		catch(SQLException e)
		{
			System.err.println(e);
			}
		}
		//chk in once.
	private void chk_in_once()
	{
		try
		{
			//from montly.
			String type="once";
			PreparedStatement pst=connection.con.prepareStatement("select * FROM once where date=?;");
			pst.setString(1,yy+"-"+mm+"-"+dd);
			pst.execute();
			set=pst.getResultSet();
			int number_of_rw=0;
			while(set.next())
			{
			number_of_rw++;
			Time dt_g=set.getTime("time");
			String oc=set.getString("ocation");
			insert_into_today(type,dt_g,oc);
			
			
			///////connection closed here.
			connection.con.close();
			System.out.println (dt_g);
			}
			System.out.println ("number_of_rw :"+number_of_rw);
		}
		catch(SQLException e)
		{
			System.err.println(e);
			}
	}
	
	/*
	//chk in weakly.
	private void chk_in_weakly(Date dt)
	{
		try
		{
			//from montly.
			String type="weakly";
			PreparedStatement pst=connection.con.prepareStatement("select * FROM weakly where date=?;");
			pst.setDate(1,dt);
			pst.execute();
			set=pst.getResultSet();
			int number_of_rw=0;
			while(set.next())
			{
			number_of_rw++;
			Time dt_g=set.getTime("time");
			String oc=set.getString("ocation");
			insert_into_today(type,dt_g,oc);
			System.out.println (dt_g);
			}
			System.out.println ("number_of_rw :"+number_of_rw);
		}
		catch(SQLException e)
		{
			System.err.println(e);
			}
	}
	*/
		
		//chk daily
	private void chk_in_daily()
	{
		try{
			String type="daily";
			Statement st=connection.con.createStatement();
			set=st.executeQuery("select * FROM daily;");
			int number_of_rw=0;
			while(set.next())
			{
			number_of_rw++;
			Time dt_g=set.getTime("time");
			String oc=set.getString("ocation");
			insert_into_today(type,dt_g,oc);
			System.out.println (dt_g);
			}
			}catch(SQLException e)
			{
				System.err.println(e);
			}
		}
		
	//to empty today table.
	private void blank_today()
	{
			try
			{
				Statement st=connection.con.createStatement();
				st.executeQuery("TRUNCATE TABLE today;");
				
				}catch(SQLException sq)
				{
					System.err.println (sq);
					}
		
		}
		
		
	private void insert_into_today(String type,Time time,String oc)
	{
		try
		{
			PreparedStatement prs=connection.con.prepareStatement("INSERT INTO today (type,time,ocation) VALUES(?,?,?);");
			prs.setString(1,type);
			prs.setTime(2,time);
			prs.setString(3,oc);
			prs.execute();
		}catch(SQLException e)
		{
			System.err.println (e);
			}
	}
		public static void main (String[] args) {
	new collect_from_other_table_to_today(java.sql.Timestamp.valueOf("2010-12-19"));
		
}
	}