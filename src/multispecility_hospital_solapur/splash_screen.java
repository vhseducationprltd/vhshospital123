package multispecility_hospital_solapur;
import java.sql.Statement;
import multispecility_hospital_solapur.use.GetConnection;


public class splash_screen extends javax.swing.JFrame {

    public splash_screen() {
        initComponents();
        
        Statement stat = new GetConnection().Connect_mysql();
        String databaseCreate = "CREATE DATABASE IF NOT EXISTS VHSHOSPITAL";
        
        String adminCreate = "CREATE TABLE IF NOT EXISTS  VHSHOSPITAL.ADMIN(SR INT NULL PRIMARY KEY AUTO_INCREMENT , USERNAME VARCHAR(255) NOT NULL UNIQUE, PASSWORD VARCHAR(255) NOT NULL );";
        String addAdmin = "INSERT INTO VHSHOSPITAL.ADMIN(USERNAME , PASSWORD ) VALUES('VHS' , 'VHS');";
        
        String receptionistCreate = "CREATE TABLE IF NOT EXISTS VHSHOSPITAL.RECEPTIONISTS(" +"SR INT NULL AUTO_INCREMENT PRIMARY KEY," +"ID INT NOT NULL UNIQUE," +"FNAME VARCHAR(100) NOT NULL ," +"MNAME VARCHAR(100) NOT NULL ," +"LNAME VARCHAR(100) NOT NULL ," +"AGE INT NOT NULL ," +"GENDER VARCHAR(50) NOT NULL ," +"DOB VARCHAR(50) NOT NULL ," +"MSTATUS VARCHAR(50) NOT NULL ," +"UPHOTO VARCHAR(255) NOT NULL ," +"USERNAME VARCHAR(100) NOT NULL UNIQUE," +"PASSWORD VARCHAR(100) NOT NULL," +"SPECIALIZATION VARCHAR(200) NOT NULL," +"EDUCATION VARCHAR(200) NOT NULL," +"JOBEXP  VARCHAR(200) NOT NULL," +"DATEOFJOIN  VARCHAR(200) NOT NULL," +"LKNOWN  VARCHAR(200) NOT NULL," +"DOCUMENT  VARCHAR(200) NOT NULL," +"EMAIL  VARCHAR(200) NOT NULL," +"CONTACT1 BIGINT NOT NULL," +"CONTACT2  BIGINT NOT NULL," +"AADHAAR BIGINT NOT NULL UNIQUE," +"PAN BIGINT NOT NULL UNIQUE," +"ADDRESS  VARCHAR(200) NOT NULL," +"CITY  VARCHAR(200) NOT NULL," +"DISTRICT  VARCHAR(200) NOT NULL," +"STATE  VARCHAR(200) NOT NULL," +"COUNTRY  VARCHAR(200) NOT NULL," +"PIN  INT NOT NULL ," +"DATE  VARCHAR(50) NOT NULL," +"TIME  VARCHAR(50) NOT NULL" +")";     
        String appointmentCreate = "CREATE TABLE IF NOT EXISTS VHSHOSPITAL.APPOINTMENTS(" +"SR INT NULL PRIMARY KEY," +"PID INT NOT NULL UNIQUE," +"FNAME VARCHAR(100) NOT NULL ," +"MNAME VARCHAR(100) NOT NULL ," +"LNAME VARCHAR(100) NOT NULL ," +"AGE INT NOT NULL ," +"GENDER VARCHAR(50) NOT NULL ,"+"DOB VARCHAR(100) NOT NULL ,"  +"MSTATUS VARCHAR(50) NOT NULL," +"CONTACT1 BIGINT NOT NULL ," +"CONTACT2 BIGINT NOT NULL," +"AADHAARNO BIGINT NOT NULL," +"PANNO VARCHAR(50) NOT NULL," +"DRNAME VARCHAR(50) NOT NULL," +"FEE INT NOT NULL ," +"OPDNO  INT NOT NULL," +"SYMPTOMS VARCHAR(255) NOT NULL," +"ADDRESS VARCHAR(255) NOT NULL," +"CITY VARCHAR(50) NOT NULL," +"DISTRICT VARCHAR(50) NOT NULL," +"STATE VARCHAR(50) NOT NULL," +"COUNTRY VARCHAR(50) NOT NULL," +"PINCODE VARCHAR(50) NOT NULL," +"DATE VARCHAR(50) NOT NULL," +"TIME VARCHAR(50) NOT NULL" +")";     
        
        String doctorCreate = "CREATE TABLE IF NOT EXISTS VHSHOSPITAL.DOCTORS(" +"SR INT NULL AUTO_INCREMENT PRIMARY KEY," +"ID INT NOT NULL UNIQUE ," +"FNAME VARCHAR(100) NOT NULL ," +"MNAME VARCHAR(100) NOT NULL ," +"LNAME VARCHAR(100) NOT NULL ," +"AGE INT NOT NULL ," +"GENDER VARCHAR(50) NOT NULL ," +"DOB VARCHAR(50) NOT NULL ," +"MSTATUS VARCHAR(50) NOT NULL ," +"UPHOTO VARCHAR(255) NOT NULL ," +"USERNAME VARCHAR(100) NOT NULL UNIQUE," +"PASSWORD VARCHAR(100) NOT NULL," +"SPECIALIZATION VARCHAR(200) NOT NULL," +"EDUCATION VARCHAR(200) NOT NULL," +"FEE INT NOT NULL," +"OPDNO INT NOT NULL UNIQUE," +"JOBEXP  VARCHAR(200) NOT NULL," +"DATEOFJOIN  VARCHAR(200) NOT NULL," +"LKNOWN  VARCHAR(200) NOT NULL," +"DOCUMENT  VARCHAR(200) NOT NULL," +"EMAIL  VARCHAR(200) NOT NULL," +"CONTACT1 BIGINT NOT NULL," +"CONTACT2  BIGINT NOT NULL," +"ECONTACT  BIGINT NOT NULL," +"AADHAAR BIGINT NOT NULL UNIQUE," +"PAN VARCHAR(20) NOT NULL UNIQUE," +"ADDRESS  VARCHAR(200) NOT NULL," +"CITY  VARCHAR(200) NOT NULL," +"DISTRICT  VARCHAR(200) NOT NULL," +"STATE  VARCHAR(200) NOT NULL," +"COUNTRY  VARCHAR(200) NOT NULL," +"PIN  INT NOT NULL," +"DATE  VARCHAR(50) NOT NULL," +"TIME  VARCHAR(50) NOT NULL" +")";
        String nurseCreate = "CREATE TABLE IF NOT EXISTS VHSHOSPITAL.NURSES(" +"SR INT NULL AUTO_INCREMENT PRIMARY KEY," +"ID INT NOT NULL UNIQUE ," +"FNAME VARCHAR(100) NOT NULL ," +"MNAME VARCHAR(100) NOT NULL ," +"LNAME VARCHAR(100) NOT NULL ," +"AGE INT NOT NULL ," +"GENDER VARCHAR(50) NOT NULL ," +"DOB VARCHAR(50) NOT NULL ," +"MSTATUS VARCHAR(50) NOT NULL ," +"UPHOTO VARCHAR(255) NOT NULL ," +"USERNAME VARCHAR(100) NOT NULL UNIQUE," +"PASSWORD VARCHAR(100) NOT NULL," +"SPECIALIZATION VARCHAR(200) NOT NULL," +"EDUCATION VARCHAR(200) NOT NULL," +"JOBEXP  VARCHAR(200) NOT NULL," +"DATEOFJOIN  VARCHAR(200) NOT NULL," +"LKNOWN  VARCHAR(200) NOT NULL," +"DOCUMENT  VARCHAR(200) NOT NULL," +"EMAIL  VARCHAR(200) NOT NULL," +"CONTACT1 BIGINT NOT NULL," +"CONTACT2  BIGINT NOT NULL," +"AADHAAR BIGINT NOT NULL UNIQUE, " +"PAN VARCHAR(20) NOT NULL UNIQUE," +"ADDRESS  VARCHAR(200) NOT NULL," +"CITY  VARCHAR(200) NOT NULL," +"DISTRICT  VARCHAR(200) NOT NULL," +"STATE  VARCHAR(200) NOT NULL," +"COUNTRY  VARCHAR(200) NOT NULL," +"PIN  INT NOT NULL ," +"DATE  VARCHAR(50) NOT NULL," +"TIME  VARCHAR(50) NOT NULL" +")";     
        String ward = "CREATE TABLE IF NOT EXISTS  VHSHOSPITAL.WARDS(" +"SR INT NULL PRIMARY KEY AUTO_INCREMENT," +"WID INT NOT NULL UNIQUE," +" WARDNAME VARCHAR(255) NOT NULL UNIQUE," +" CHARGES INT NOT NULL" +");";   

       try{
            try{
                stat.execute(databaseCreate);                
                stat.execute(adminCreate);
                stat.execute(receptionistCreate);
                stat.execute(doctorCreate);
                stat.execute(nurseCreate);
                stat.execute(appointmentCreate);
                stat.execute(addAdmin);   
                stat.execute(ward);
            }catch(Exception e){
                if(!e.getMessage().contains("Duplicate entry 'VHS' for key 'USERNAME'")){
                    System.out.println("Error : " +e );
                }
            }
       }catch(Exception e){
           System.out.println("Error Occured in splash screen : " + e);
       }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        LoadingLable = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(191, 191, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iloveimg-resized/doctor-align-with-lower-cost-and-increased-quality-alignment-21.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 3, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VHS MULTISPECILITY HOSPITAL,");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, -1, -1));

        jLabel3.setFont(new java.awt.Font("Imprint MT Shadow", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SOLAPUR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 137, 160, -1));

        LoadingValue.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(0, 0, 0));
        LoadingValue.setText("0 %");
        jPanel1.add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, -1, -1));

        LoadingLable.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        LoadingLable.setForeground(new java.awt.Color(0, 0, 0));
        LoadingLable.setText("Loading ...!");
        jPanel1.add(LoadingLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        jPanel1.add(LoadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 810, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(splash_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        splash_screen fs = new splash_screen();
        fs.setVisible(true);
        try{
            for(int i=0;i<101;i++){
            Thread.sleep(10);
            fs.LoadingValue.setText(i +"%");
            if(i==10){
                fs.LoadingLable.setText("Starting Modules...");
            }
             if(i==20){
                fs.LoadingLable.setText("Turing on modules ... Done..!");
            }
              if(i==50){
                fs.LoadingLable.setText("Done loading modules..");
            }
               if(i==70){
                fs.LoadingLable.setText("Wait a start");
            }
                if(i==80){
                fs.LoadingLable.setText("open a system");
            }
            fs.LoadingBar.setValue(i);
            }
        fs.setVisible(false);

             LOGIN_FORM log = new  LOGIN_FORM();
            log.setVisible(true);   
             fs.setVisible(false);
        }catch(Exception e){
           System.out.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLable;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
