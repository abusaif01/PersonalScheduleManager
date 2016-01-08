import java.util.*;
import java.text.*;
public class gettimefromsystem
{
	public static void main (String[] args) {
		Date dt= new Date();
		Calendar cl=Calendar.getInstance();
	/*	int a,b,c;
		try{
		System.out.println (cl.get(Calendar.YEAR));
		System.out.println (cl.get(Calendar.MONTH));
		System.out.println (cl.get(Calendar.DATE));
		System.out.println ("time    :");
		System.out.println (cl.get(Calendar.HOUR));
		System.out.println (cl.get(Calendar.MINUTE));
		System.out.println (cl.get(Calendar.SECOND));
		String nw; */
		SimpleDateFormat fr=new SimpleDateFormat("yyyy/MM/dd");
	/*	a=cl.get(Calendar.YEAR);
		b=cl.get(Calendar.MONTH);
		c=cl.get(Calendar.DATE);
		nw=a+"/"+b+"/"+c; */
		dt=fr.parse(nw);
		System.out.println (dt);
		}
		catch(ParseException pe)
		{
			System.err.println(pe);
			}
	
}
	}