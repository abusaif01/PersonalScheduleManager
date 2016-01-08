import java.util.*;
import java.text.*;
public class recent_time
{
	java.sql.Timestamp sdt;
	SimpleDateFormat frt;
	String nw;
	Date dt= new Date();
	Calendar cc;
	public recent_time()
	{
			
		cc=new GregorianCalendar();
		dt=cc.getTime();
		frt=new SimpleDateFormat("yyyy-MM-dd hh:mm:00");
		nw=frt.format(dt);
	//	System.out.println ("by st : "+nw);
		sdt=java.sql.Timestamp.valueOf(nw);
	//	System.out.println ("sdate : "+sdt);
		
}
	java.sql.Timestamp get_recent_time()
	{
		return sdt;
		}
		public String todays_date()
		{
			dt=cc.getTime();
			frt=new SimpleDateFormat("dd-MM-yyyy");
			nw=frt.format(dt);
			return nw;
			}
			
		public	String time_now()
			{
			cc=new GregorianCalendar();
			dt=cc.getTime();
			frt=new SimpleDateFormat("hh:mm:ss");
			nw=frt.format(dt);
			return nw;
			}
			
			
			
			public static void main (String[] args) {
				recent_time r=new recent_time();
			while(true)
			{
			
			String st=r.time_now();
			System.out.println (st);
			}
}
	}