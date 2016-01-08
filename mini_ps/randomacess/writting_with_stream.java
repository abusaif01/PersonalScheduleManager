import java.io.*;
public class writting_with_stream
{
	public static void main (String[] args) {

	FileOutputStream fos; 
    DataOutputStream dos;

    try {
		String sr=new String();
      File file= new File("MyFile.txt");
      fos = new FileOutputStream(file);
      dos=new DataOutputStream(fos);
      //dos.writeInt(2333);
      RandomAccessFile raf=new RandomAccessFile(file,"rws");
      raf.writeChars("hello");
      raf.writeUTF("hello");
      raf.writeUTF("hello");
      while((sr=raf.readLine())!=null)
      {
      	System.out.println (sr);
      	}
    } catch (IOException e) {
      System.out.println ("erros");
    	}

		}
	}