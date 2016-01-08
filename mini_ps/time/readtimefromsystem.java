//import java.sql.*;
import java.util.*;
import java.text.*;
public class readtimefromsystem
{
	public static void main (String[] args)
	{
		 try {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      String date = "2003/01/10";
      java.util.Date utilDate = formatter.parse(date);
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      System.out.println("date:" + date);
      System.out.println("sqlDate:" + sqlDate);
      System.out.println (utilDate);
    } catch (ParseException e) {
      System.out.println(e.toString());
      e.printStackTrace();
    }
 
	}
}