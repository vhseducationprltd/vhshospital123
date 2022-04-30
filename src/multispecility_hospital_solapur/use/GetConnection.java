package multispecility_hospital_solapur.use; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 
import javax.swing.JLabel;

public class GetConnection {
//    DERBY
   Statement stat;  
   public Statement connect_derby(JLabel lablel){
       try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/VHS","VHS","VHS");  
        stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
       }catch(Exception e){
           if(e.getMessage().contains("Error connecting to server")){
               lablel.setText("Please Start The Database Server..");
           }
           System.out.println("Problem is Occured inside the : use -> GetConncection.java : " +e); 
       }
       return stat;
   }
   
//   MY SQL WITHOUT ERROR LABLE
  public Statement Connect_mysql(){
       try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");   
        stat=con.createStatement();   
        System.out.println("ConnectedSuccessfully..");
       }catch(Exception e){ 
           System.out.println("Problem is Occured inside the : use -> GetConncection.java : " +e); 
       }
       return stat;
   }
//  MY SQL WITH ERROR LABLE
  public Statement Connect_mysql(JLabel lablel){
       try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");   
        stat=con.createStatement();   
        System.out.println("ConnectedSuccessfully..");
       }catch(Exception e){ 
           if(e.getMessage().contains("Communications link failure")){
               lablel.setText("Please Start The Database Server..");
           }
           System.out.println("Problem is Occured inside the : use -> GetConncection.java : " +e); 
       }
       return stat;
   }
  public Connection Connect_mysql_Prep(){ 
      Connection con=null;
       try{
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");     
        System.out.println("ConnectedSuccessfully..");
       }catch(Exception e){ 
          
           System.out.println("Problem is Occured inside the : use -> GetConncection.java : " +e); 
       }
       return con;
   }
}
