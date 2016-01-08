

package Database;

import java.sql.*;
import javax.swing.*;

public class database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DATABASE_URL = "jdbc:mysql://localhost:3306/infsystem";
    public ResultSetMetaData metadata;
    public  ResultSet result;
    public ResultsModel model=new ResultsModel();
     Connection connection = null; // manages connection
     Statement statement = null;




        // connect to database books and query database
       public database(){
           
        
           try
        {
          // query statement
            Class.forName( JDBC_DRIVER ); // load database driver class

           // establish connection to database                              
           connection =                                                     
              DriverManager.getConnection( DATABASE_URL, "root", "root" );

           // create Statement for querying database
           statement = connection.createStatement();

           
        } // end try
        catch ( SQLException sqlException )
        {
           sqlException.printStackTrace();
           System.exit(0  );
        } // end catch
        catch ( ClassNotFoundException classNotFound )
        {
           classNotFound.printStackTrace();
           System.exit( 0 );
        } // end catch
      
       }
public void insertStudent(int student_id,String student_name,int student_roll,int registration_no,String Semister,String Student_department,String user_id)
{
try{  
   PreparedStatement st=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?);");
   st.setInt(1,student_id);
   st.setString(2,student_name);
   st.setInt(3,student_roll);
   st.setInt(4,registration_no);
   st.setString(5,Semister);
   st.setString(6,Student_department);
   st.setString(7,user_id);
   st.execute();
   JOptionPane.showMessageDialog(null,"you have registered as student successfully");
  
   
   
}
 catch(SQLException e){}
 
}

public void insertUser(String user_id,String user_password,String user_type)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into user values(?,?,?);");
   st.setString(1,user_id);
   st.setString(2,user_password);
  st.setString(3,user_type);
    st.execute();
  
  
JOptionPane.showMessageDialog(null,"You are now a valid user");
}
 catch(SQLException e){}

 }

 public void insertteacher(String teacher_id,String teacher_name,String user_id)
 {
try{ 
   PreparedStatement st=connection.prepareStatement("insert into teacher values(?,?,?)");
   st.setString(1,teacher_id);
   st.setString(2,teacher_name);
   st.setString(3,user_id);
   st.execute();
   JOptionPane.showMessageDialog(null,"you have registered as teacher successfully");
}
 catch(SQLException e){
 JOptionPane.showMessageDialog(null,"you should fill up the total form");}
 }
 public void insertcourseTeacher( String course_id,String course_name,float credit,String teacher_id,String semister)
 {
try{ 
   PreparedStatement st=connection.prepareStatement("insert into courseteacher values(?,?,?,?,?);");
   st.setString(1,course_id);
   st.setString(2,course_name);
   st.setFloat(3,credit);
   st.setString(4,teacher_id);
   st.setString(5,semister);
   
   st.execute();
   JOptionPane.showMessageDialog(null, "successfully assigned the course");
   
}
 catch(SQLException e){}
 }
 public void insertcourseStudent( String course_id,String semister,int student_id)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into coursestudent values(?,?,?,?,?);");
   st.setString(1,course_id);
   st.setString(2,semister);
   st.setInt(3,student_id);
   st.execute();
   JOptionPane.showMessageDialog(null, "successfully assigned the course");

}
 catch(SQLException e){}
 }
  public void student_user(String user_name,String user_password,String student_id,String student_name)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into student_user values(?,?,?,?);");
   st.setString(1,user_name);
   st.setString(2,user_password);
   st.setString(3,student_id);
   st.setString(4,student_name);
   st.execute();
   JOptionPane.showMessageDialog(null, "successfully login into student user");

}
 catch(SQLException e){}
  }



   public void teacher_user(String user_name, String user_pas,String teacher_id,String teacher_name)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into teacher_user values(?,?,?,?);");
   st.setString(1,user_name);
   st.setString(2,user_pas);
   st.setString(3,teacher_id);
   st.setString (4,teacher_name);
   st.execute();
   JOptionPane.showMessageDialog(null, "successfully login into teacher_user");

}
 catch(SQLException e){}
   }

public void insertPartialmark(int student_id,String course_id,float semis,float mark_total,String grade,float gpa)
 {
try{
 
   PreparedStatement st=connection.prepareStatement("update resultgpa set semis=?, mark_total=?,grade=?,gpa=?where student_id=? and course_id=?;");
   st.setFloat(1,semis);
   
   st.setFloat (2,mark_total);
   st.setString (3,grade);
   st.setFloat (4,gpa);
  st.setInt(5,student_id);
  st.setString(6,course_id);
   st.execute();
 JOptionPane.showMessageDialog(null, "successfully uploaded to main result");

}
 catch(SQLException e){}
   }




    public void insertResultTuito(String course_id, int student_id,float Tc01,float Tc02,float Tc03,float aveg_tuto,float attandence,float total)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into resulttuto values(?,?,?,?,?,?,?,?);");
   st.setString(1,course_id);
   st.setInt(2,student_id);
  

   st.setFloat (3,Tc01);
   st.setFloat (4,Tc02);
   st.setFloat (5,Tc03);
   st.setFloat (6,aveg_tuto);
   st.setFloat (7,attandence);
   st.setFloat (8,total);
   st.execute();
 JOptionPane.showMessageDialog(null, "successfully uploaded");

}
 catch(SQLException e){}
   }
  public void insertroutine(String course_id, String teacher_id,String d01,String d02,String d03,String t01,String t02,String t03,int semis)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into routine values(?,?,?,?,?,?,?,?,?);");
   st.setString(1,course_id);
   st.setString(2,teacher_id);
   st.setString(3,d01);

   st.setString (4,d02);
   st.setString (5,d03);
   st.setString (6,t01);
   st.setString (7,t02);
   st.setString(8,t03);
   st.setInt(9,semis);
    st.execute();

JOptionPane.showMessageDialog(null,"Inserted into routine");
}catch(SQLException se){}
 }


public void insertcourse_routine(String course_id, String teacher_id,String d01,String t01)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into course_routine values(?,?,?,?);");
   st.setString(1,course_id);
   st.setString(2,teacher_id);
   st.setString(3,d01);

   st.setString (4,t01);
   st.execute();
   JOptionPane.showMessageDialog(null,"Inserted into course_routine");

}catch(SQLException se){}
 }
    public void insertResultGpa(int student_id,String course_id,float semis,float total,float mark_total,String grade,float gpa)
 {
try{
   PreparedStatement st=connection.prepareStatement("insert into resultgpa values(?,?,?,?,?,?,?);");
   st.setInt(1,student_id);
   st.setString(2,course_id);
   st.setFloat (3,total);
   st.setFloat(4,semis);
   
   st.setFloat(5,mark_total);
   st.setString (6,grade);
   st.setFloat (7,gpa);
   
   st.execute();
   JOptionPane.showMessageDialog(null, " inserted marks to the course wise result");

}
 catch(SQLException e){}
   }
    public void searchstudent(String course_id,String[] student)
 {
try{
   PreparedStatement st=connection.prepareStatement("select student_id from course where course_id=?;");
   st.setString(1,course_id);
   st.execute();
  result=st.getResultSet();
  model.setResultSet(result);
  int rowcount=model.getRowCount();
  int i=0;
  for(;i<rowcount;i++)
  {
  student[i]=model.getValueAt(i, 0);
  }
   
}
 catch(SQLException e){}
 }





public  String searchuser(String s1,String s2) throws SQLException
{   
   System.out.println("checke 01");
   PreparedStatement st=connection.prepareStatement("select user_type from user where user_id=? AND user_password=?;");
   st.setString(1,s1);
   st.setString(2,s2);
   st.execute();
  result=st.getResultSet();
  model.setResultSet(result);
  result.last();
  int j=result.getRow();
  String user_type=model.getValueAt(0,0);
  if(j==0)
   {
   user_type="not valid";
   return user_type;
   }
  statement.close();
  connection.close();
 return user_type;
}

public  String findTotal(int s1,String s2) throws SQLException
{   
    System.out.println("checke 01");
   PreparedStatement st=connection.prepareStatement("select total from resulttuto where student_id=? AND course_id=?;");
   st.setInt(1,s1);
   st.setString(2,s2);
   st.execute();
  result=st.getResultSet();
  model.setResultSet(result);
  result.last();
  int j=result.getRow();
  String total=model.getValueAt(0,0);
  statement.close();
  connection.close();
 return total;
}


}