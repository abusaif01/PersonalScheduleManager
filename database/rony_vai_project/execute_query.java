/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;
import Database.ResultsModel;
import java.sql.*;
import java.awt.*;
import java.sql.ResultSet;

/**
 *
 * @author iean
 */
public class execute_query {
 static  String password="netuseron";
 static  String user     = "root";
 static  String url      = "jdbc:mysql://localhost:3306/cse";
 static  String driver   = "com.mysql.jdbc.Driver";
 static Connection connection;
 static Statement statement;
 static ResultSet model;
 static String[] re;
 
  

     public String[] executeResult(String  query) throws ClassNotFoundException {

     // Get the SQL statement


    try {
        Class.forName(driver);                     // Load the driver
      connection = DriverManager.getConnection(url, user, password);
statement=connection.createStatement();
model=statement.executeQuery(query);
ResultsModel model1 = new ResultsModel();

 model1.setResultSet(model);
int j= model1.getRowCount();
 re=new String[j];
for(int i=0;i<j;i++)
 {
 re[i]=model1.getValueAt(i,0);

 }

 } catch (SQLException sqle) {
        // Display error message
    }
 return re;
     }

}
