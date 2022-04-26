
package multispecility_hospital_solapur.use;
import java.sql.ResultSet;
import java.sql.Statement;

public class getTotalUsers {
   public static String getTotalReceptionists(){
        String total="";    
        String totall="";
        
        Statement staetment = new GetConnection().Connect_mysql();
        
        try{ 
        ResultSet ress = staetment.executeQuery("SELECT MAX(Sr) AS max  FROM VHSHOSPITAL.RECEPTIONISTS;");
        while(ress.next()){
            totall = ress.getString("max"); 
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
       try{
           ResultSet res = staetment.executeQuery("SELECT COUNT(SR) AS COUNT FROM VHSHOSPITAL.RECEPTIONISTS");
           while(res.next()){
            total = res.getString("count"); 
        }
       }catch(Exception e ){
           System.out.println(e);
       }
        
        return total;
    }
   public static  String getTotalDoctors(){
        String total="";
        Statement staetment = new GetConnection().Connect_mysql();
         
       try{ 
          
            ResultSet res = staetment.executeQuery("SELECT COUNT(SR) AS COUNT FROM VHSHOSPITAL.DOCTORS");
            
            while(res.next()){
            total = res.getString("count");
        }
       }catch(Exception e ){
           System.out.println(e);
       }
        
        return total ;
    }
   public static String getTotalNurses(){
        String total="";
        String totall="";

        Statement staetment = new GetConnection().Connect_mysql();
         try{ 
        ResultSet ress = staetment.executeQuery("SELECT MAX(Sr) AS max FROM VHSHOSPITAL.NURSES;");
        while(ress.next()){
           totall = ress.getString("max"); 
        }
        }catch(Exception e){
            System.out.println(e);
        }
       try{
           ResultSet res = staetment.executeQuery("SELECT COUNT(SR) AS COUNT FROM VHSHOSPITAL.NURSES");
           
            while(res.next()){
            total = res.getString("count");
        }
       }catch(Exception e ){
           System.out.println(e);
       }
        
        return total;
    }
   public static  String getTotalAdmitPatients(){
        String total="";   
        String totall="";

        Statement staetment = new GetConnection().Connect_mysql();
         try{
             ResultSet ress = staetment.executeQuery("SELECT MAX(Sr) AS max FROM VHSHOSPITAL.NURSES");

        while(ress.next()){
           totall = ress.getString("max"); 
        }
        }catch(Exception e){
            System.out.println(e);
        }
       try{
            
            ResultSet res = staetment.executeQuery("SELECT COUNT(SR) AS COUNT FROM VHSHOSPITAL.NURSES");
            while(res.next()){
            total = res.getString("count");
        }
       }catch(Exception e ){
           System.out.println(e);
       }
        
        return total;
    }
   public static  String getTotalPatients(){
        String total="";
        String totall="";

        Statement staetment = new GetConnection().Connect_mysql();
        try{
             ResultSet ress = staetment.executeQuery("SELECT MAX(Sr) AS max FROM VHSHOSPITAL.APPOINTMENTS");

        while(ress.next()){
           totall = ress.getString("max"); 
        }
        }catch(Exception e){
            System.out.println(e);
        }
       try{
            
        ResultSet res = staetment.executeQuery("SELECT COUNT(SR) AS COUNT FROM VHSHOSPITAL.APPOINTMENTS");
            while(res.next()){
            total = res.getString("count");
        }
       }catch(Exception e ){
           System.out.println(e);
       }
        
        return total;
    }
    
    
}
