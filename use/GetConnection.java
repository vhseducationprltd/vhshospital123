package use; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
import javax.swing.JLabel;

public class GetConnection {
   Statement stat;  
   public Statement CreateConnection(JLabel lablel){
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
   
   public Statement CreateConnection(){
       try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/VHS","VHS","VHS");  
        stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
       }catch(Exception e){ 
           System.out.println("Problem is Occured inside the : use -> GetConncection.java : " +e); 
       }
       return stat;
   }
}
