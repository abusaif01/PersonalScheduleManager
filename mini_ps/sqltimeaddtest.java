import java.sql.*;
public class sqltimeaddtest
{
	public static void main (String[] args) {

		Date dt=Date.valueOf("2010-10-09");
		System.out.println (dt);
		int a;
		a=dt.getMonth();
		dt.setMonth(a+2);
		System.out.println (a);
		System.out.println (dt);
}
	}