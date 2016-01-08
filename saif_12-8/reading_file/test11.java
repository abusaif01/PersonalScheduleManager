import java.io.*;
import java.util.*;
public class test11
{
	public static void main(String arg[])
	{
		int j=55,i;

		try
		{
			BufferedReader br;
			br=new BufferedReader(new FileReader("afreen.txt"));
			String s;
			StringTokenizer stn;
			while((s=br.readLine())!=null)
			{
				stn=new StringTokenizer(s);
				while(stn.hasMoreTokens())
				{
					i=Integer.parseInt(stn.nextToken());
					System.out.println(j/i);
					}
				}
			br.close();
			}
			catch(IOException e)
			{
				System.out.println("beta vol hoiche");
				}
			catch(ArithmeticException hhh)
			{
				System.out.println("voool");
				}
				finally
				{
					System.out.println("hello");

					}

		}
	}








