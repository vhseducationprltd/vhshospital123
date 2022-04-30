
package multispecility_hospital_solapur.DOCTOR;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import multispecility_hospital_solapur.LOGIN_FORM;
import multispecility_hospital_solapur.use.GetConnection;


public class OPD extends javax.swing.JFrame {

   
       public OPD(ResultSet result) {
                 initComponents();
                  statement = new GetConnection().Connect_mysql(); 
                   showDate();
             showTime();
                  setExtendedState(JFrame.MAXIMIZED_BOTH); 
             try{
                 drname.setText("DR."+result.getString("FNAME").toUpperCase()+" "+result.getString("MNAME").toUpperCase()+" "+result.getString("LNAME").toUpperCase() ); 
                 DbName="doc_"+result.getString("ID");
                 System.out.println(DbName);
             }catch(Exception e){}
             
             
             
              try {
             
            String query = "SELECT * FROM VHSHOSPITAL.WARDS";
            ResultSet result2 = statement.executeQuery(query);
            
            
            while (result2.next()) {
                 String wardname = result2.getString("WARDNAME");
         
                WARDNAME.addItem(wardname.toUpperCase()); 
            } 
           
        } catch (Exception e) {
            System.out.println("Something is happened In NewPatients ..");
            System.out.println(e);
        }
              jPanel5.setVisible(true);
             admitYesPanel.setVisible(false); 
             admitYesPanel.setVisible(false); 
             admitYesPanel2.setVisible(false);
       

    }
     void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        DATE.setText(s.format (d));
    }
    
     void showTime(){
     new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm a");
                TIME.setText(s.format(d));
            }
            
        }).start();
    }
     
     
     void getDataNoAdmit() {
        Pid = Integer.parseInt(PID.getText());
        
        String[] name = FULLNAME.getText().split(":")[1].trim().split(" "); 
        System.out.println(name);
        Fname = name[0];
        Mname = name[1];
        Lname = name[2];
         
        Age = Integer.parseInt(AGE.getText().split(":")[1].trim());
        Gender = GENDER.getText().split(":")[1];

        Symptoms = SYMPTOMS.getText();
        Medicines = MEDICINES.getText();
        Treatment = TREATMENT.getText();
        Reports = REPORTS.getText();
         
        Drname = drname.getText();  

        Date = DATE.getText();
        Time = TIME.getText();

    }    
       void getDataAdmit() {
        Pid = Integer.parseInt(PID.getText());
        
        String name = FULLNAME.getText().split(":")[1].trim();
        Fname = name.split(" ")[0];
        Mname = name.split(" ")[1];
        Lname = name.split(" ")[2];
         
        Age = Integer.parseInt(AGE.getText().split(":")[1].trim());
        Gender = GENDER.getText();
        Caddhar = Long.parseLong(CAADHAAR.getText());
        Symptoms = SYMPTOMS.getText();
        Medicines = MEDICINES.getText();
        Treatment = TREATMENT.getText();
        Reports = REPORTS.getText();
        
        Bedno = Integer.parseInt(BEDNO.getText());
        Wardname = WARDNAME.getItemAt(WARDNAME.getSelectedIndex());

        Cfullname= CFULLNAME.getText();
        Cage = Integer.parseInt(CAGE.getText());
        System.out.println( CGENDER.getItemAt(CGENDER.getSelectedIndex()));
        Cgender = CGENDER.getItemAt(CGENDER.getSelectedIndex()); 
        String date2 =
      ((JTextField) DATEOFADMIT.getDateEditor().getUiComponent()).getText();
    Dateofadmit = LocalDate.parse(date2).toString();
        Drname = drname.getText();  
         
        Contact = Long.parseLong(CONTACT.getText());

        Rtopatient = RTOPATIENT.getText();
        CAddress = CADDRESS.getText(); 

        Date = DATE.getText();
        Time = TIME.getText();

    }    
     
     private void clearFields() {
         PID.setText(""); 
         GENDER.setText("GENDER : ");
      
         SYMPTOMS.setText("");
         MEDICINES.setText("");
         TREATMENT.setText("");
         REPORTS.setText("");
             //      DATEOFADMIT.setText("");
             //      WARDNAME.setText("");
         BEDNO.setText("");
         FULLNAME.setText("NAME : ");
         AGE.setText("AGE : ");
         CFULLNAME.setText("");
         CAGE.setText("");
             //      CGENDER.setText("");
         CAADHAAR.setText("");
         CONTACT.setText("");
      
         RTOPATIENT.setText("");
         CADDRESS.setText("");
         ERRLABLE.setText("  ");
         DATEOFADMIT.setDate(null);
     
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PID = new javax.swing.JTextField();
        VIEW = new javax.swing.JButton();
        SUBMIT = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        GENDER = new javax.swing.JLabel();
        AGE = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        admitStatus = new javax.swing.JComboBox<>();
        admitYesPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        BEDNO = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        WARDNAME = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        DATEOFADMIT = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        admitYesPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        CAADHAAR = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CFULLNAME = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CAGE = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        CGENDER = new javax.swing.JComboBox<>();
        CONTACT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        RTOPATIENT = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CADDRESS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SYMPTOMS = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        REPORTS = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TREATMENT = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MEDICINES = new javax.swing.JTextArea();
        FULLNAME = new javax.swing.JLabel();
        ERRLABLE = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        drname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel1.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel2.setText("SOLAPUR .  413006");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("PID");

        PID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PID.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PIDMouseMoved(evt);
            }
        });
        PID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PIDMouseClicked(evt);
            }
        });
        PID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PIDActionPerformed(evt);
            }
        });
        PID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PIDKeyPressed(evt);
            }
        });

        VIEW.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        VIEW.setText("VIEW");
        VIEW.setMargin(new java.awt.Insets(4, 27, 4, 27));
        VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWActionPerformed(evt);
            }
        });

        SUBMIT.setBackground(new java.awt.Color(51, 153, 255));
        SUBMIT.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        SUBMIT.setText("SUBMIT");
        SUBMIT.setMargin(new java.awt.Insets(7, 24, 7, 24));
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBMITActionPerformed(evt);
            }
        });

        UPDATE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        UPDATE.setText("UPDATE");
        UPDATE.setMargin(new java.awt.Insets(4, 27, 4, 27));
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(232, 59, 59));
        DELETE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        DELETE.setText("DELETE");
        DELETE.setMargin(new java.awt.Insets(4, 27, 4, 27));
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        LOGOUT.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LOGOUT.setText("LOG OUT");
        LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUTMouseClicked(evt);
            }
        });
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        GENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        GENDER.setText("GENDER : ");

        AGE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AGE.setText("AGE : ");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("ADMIT STATUS");

        admitStatus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        admitStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));
        admitStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admitStatusActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("WARD NAME");

        BEDNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BEDNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEDNOActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setText("BED NO");

        WARDNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        WARDNAME.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                WARDNAMEItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("DATE OF ADMIT");

        DATEOFADMIT.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout admitYesPanel2Layout = new javax.swing.GroupLayout(admitYesPanel2);
        admitYesPanel2.setLayout(admitYesPanel2Layout);
        admitYesPanel2Layout.setHorizontalGroup(
            admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitYesPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(DATEOFADMIT, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(226, 226, 226)
                .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WARDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(140, 140, 140)
                .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(BEDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        admitYesPanel2Layout.setVerticalGroup(
            admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitYesPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, admitYesPanel2Layout.createSequentialGroup()
                        .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(admitYesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(WARDNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(DATEOFADMIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, admitYesPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BEDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(1000, 500));

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel29.setText("AADHAAR NO");

        CAADHAAR.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CAADHAAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAADHAARActionPerformed(evt);
            }
        });
        CAADHAAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CAADHAARKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel23.setText("FULL  NAME");

        CFULLNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CFULLNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFULLNAMEActionPerformed(evt);
            }
        });
        CFULLNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CFULLNAMEKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel24.setText("AGE");

        CAGE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAGEActionPerformed(evt);
            }
        });
        CAGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CAGEKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setText("GENDER");

        CGENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CGENDER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "MALE", "FEMALE", "OTHER" }));

        CONTACT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CONTACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTACTActionPerformed(evt);
            }
        });
        CONTACT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CONTACTKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel30.setText("CONTACT");

        RTOPATIENT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RTOPATIENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RTOPATIENTActionPerformed(evt);
            }
        });
        RTOPATIENT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RTOPATIENTKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel31.setText("RELATIONN TO PATIENT");

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel25.setText("ADDRESS");

        CADDRESS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CADDRESSActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel17.setText("CONTACT PERSON");

        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout admitYesPanelLayout = new javax.swing.GroupLayout(admitYesPanel);
        admitYesPanel.setLayout(admitYesPanelLayout);
        admitYesPanelLayout.setHorizontalGroup(
            admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitYesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(CFULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(CAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(CAADHAAR, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(CONTACT, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(RTOPATIENT, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(CADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        admitYesPanelLayout.setVerticalGroup(
            admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admitYesPanelLayout.createSequentialGroup()
                .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admitYesPanelLayout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CAGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CFULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CAADHAAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CONTACT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(admitYesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RTOPATIENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admitYesPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(CADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(admitYesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(admitYesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SYMPTOMS.setColumns(20);
        SYMPTOMS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SYMPTOMS.setRows(5);
        jScrollPane1.setViewportView(SYMPTOMS);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("SYMPTOMS");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("MEDICINES");

        REPORTS.setColumns(20);
        REPORTS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        REPORTS.setRows(5);
        REPORTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REPORTSMouseClicked(evt);
            }
        });
        REPORTS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                REPORTSKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(REPORTS);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("TREATMENT");

        TREATMENT.setColumns(20);
        TREATMENT.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TREATMENT.setRows(5);
        jScrollPane3.setViewportView(TREATMENT);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("REPORTS");

        MEDICINES.setColumns(20);
        MEDICINES.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        MEDICINES.setRows(5);
        jScrollPane2.setViewportView(MEDICINES);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        FULLNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        FULLNAME.setText("NAME : ");

        ERRLABLE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ERRLABLE.setForeground(new java.awt.Color(255, 0, 0));
        ERRLABLE.setText("              ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ERRLABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(admitStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(admitYesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LOGOUT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SUBMIT)
                .addGap(34, 34, 34)
                .addComponent(UPDATE)
                .addGap(29, 29, 29)
                .addComponent(DELETE)
                .addGap(18, 18, 18)
                .addComponent(VIEW)
                .addGap(44, 44, 44))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FULLNAME)
                        .addComponent(ERRLABLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(GENDER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admitStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(admitYesPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LOGOUT)
                    .addComponent(VIEW)
                    .addComponent(UPDATE)
                    .addComponent(DELETE)
                    .addComponent(SUBMIT))
                .addGap(18, 18, 18))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel6.setText("SPECELIST");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        TIME.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        TIME.setText("TIME");

        DATE.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        DATE.setText("DATE");

        drname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        drname.setText("DR NAME");

        jLabel18.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel18.setText("DATE :");

        jLabel19.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel19.setText("TIME :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268)
                .addComponent(jLabel3)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drname, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(544, 544, 544)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DATE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TIME)))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(DATE)
                            .addComponent(jLabel18))))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TIME)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CADDRESSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CADDRESSActionPerformed

    private void RTOPATIENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RTOPATIENTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RTOPATIENTActionPerformed

    private void CONTACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTACTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONTACTActionPerformed

    private void CAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAGEActionPerformed

    private void CFULLNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CFULLNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CFULLNAMEActionPerformed

    private void CAADHAARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAADHAARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAADHAARActionPerformed

    private void BEDNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEDNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BEDNOActionPerformed

    private void admitStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admitStatusActionPerformed
        if(admitStatus.getSelectedItem().toString().equals("NO")){
  
            jPanel5.setVisible(true);
            admitYesPanel.setVisible(false);
            admitYesPanel2.setVisible(false);

        }else{
        
            jPanel5.setVisible(false);
            admitYesPanel.setVisible(true);
            admitYesPanel2.setVisible(true);

        }
    }//GEN-LAST:event_admitStatusActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        this.dispose();
        LOGIN_FORM log = new  LOGIN_FORM();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        Pid = Integer.parseInt(PID.getText());
        String query = "DELETE FROM OPD WHERE PID=" + Pid;
        try {
            statement.execute(query);
            clearFields();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        getDataNoAdmit();
        try {

            String query = " UPDATE APPOINTMENT SET " + "SYMPTOMS=" + "'" + Symptoms + "'," + "MEDICINES=" + "'" + Medicines + "'," + "TREATMENT=" + "'" + Treatment + "'," + "REPORT=" + "'" + Reports + "'," + "DATEOFADMIT=" + "'" + Dateofadmit + "'," + "WARDNAME=" + "'" + Wardname + "'," + "BEDNO=" + Bedno + "," + "CFULLNAME=" + "'" + Cfullname + "'," + "CAGE=" + Cage + "," + "CGENDER=" + "'" + Cgender + "'," + "EMAIL=" + "'" + Email + "'," + "CONTACT=" + "'" + Contact + "'," + "RTOPATIENT=" + "'" + Rtopatient + "'," + "ADDRESS=" + "'" + CAddress + "' WHERE PID=" + Pid;

            statement.execute(query);
            clearFields();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
         int Sr = 0; 
          
          if(admitStatus.getSelectedItem().toString().equals("NO")){
              getDataNoAdmit();
           try {
               System.out.println(DbName);   
            String query = "SELECT COUNT(SR) AS SR FROM " + DbName +".NONADMIT ";
            
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Sr = Integer.parseInt(result.getString("SR"));
            }
            System.out.println(Sr);
           
            query = ("INSERT INTO " + DbName +".NONADMIT(SR,PID,FNAME,MNAME,LNAME,AGE,GENDER,DRNAME,SYMPTOMS,MEDICINES,TREATMENT,REPORTS,DATE,TIME)VALUES(" + (Sr + 1) + "," + Pid + ",'" + Fname + "','" + Mname + "','" + Lname + "'," + Age + ",'" + Gender + "','" + Drname + "','" + Symptoms + "','" + Medicines + "','" + Treatment + "','" + Reports + "','" + Date + "','" + Time + "')");

            System.out.println(query);
            statement.execute(query);
            clearFields();
            JOptionPane.showMessageDialog(rootPane, "PATIENT ADDED..");
        } catch (Exception e) {
             if(e.getMessage().contains("Duplicate entry")){
                ERRLABLE.setText("Duplicate entry..");
             }
            System.out.println("nahi jal  beeeee");
            System.out.println(e);
        }

        }else{
              getDataAdmit();
         try {
            String query = "SELECT COUNT(SR) AS SR FROM " + DbName +".ADMIT";
            
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Sr = Integer.parseInt(result.getString("SR"));
            }
            System.out.println(Sr);
           //
            query = ("INSERT INTO " + DbName +".ADMIT (SR,PID,FNAME,MNAME,LNAME,AGE,GENDER,DRNAME,WARDNAME,BEDNO,DATEOFADMIT,CFULLNAME,CAGE,CGENDER,CCONTACT,CRELATIONTOPATIENT,CAADHAARNO,CADDRESS,DATE,TIME)VALUES(" + (Sr + 1) + "," + Pid + ",'" + Fname + "','" + Mname + "','" + Lname + "'," + Age + ",'" + Gender + "','"+Drname + "','" + Wardname+ "'," +Bedno  + ",'" +Dateofadmit+ "','"+Cfullname+ "'," + Cage + ",'" + Cgender + "'," + Contact + ",'" + Rtopatient + "'," +Caddhar  + ",'" + CAddress + "','" + Date + "','" + Time + "')");

            System.out.println(query);
            statement.execute(query);
            
            
            String patienttable = "P_"+Pid; 
            String createTable = "CREATE TABLE IF NOT EXISTS " + DbName +"."+patienttable+"(" +"SR INT NULL AUTO_INCREMENT PRIMARY KEY," +"ID INT NOT NULL ,"+"SYMPTOMS VARCHAR(255) NOT NULL ," +"MEDICINES VARCHAR(255) NOT NULL ," +"TREATMENT VARCHAR(255) NOT NULL ," +"TEST VARCHAR(255) NOT NULL ," +"TESTREPORTS VARCHAR(255) NOT NULL ," +"DATE  VARCHAR(50) NOT NULL," +"TIME  VARCHAR(50) NOT NULL" +")";     
            System.out.println(createTable);
            statement.execute(createTable);
            clearFields();
            JOptionPane.showMessageDialog(rootPane, "PATIENT ADMITTED ..");
        } catch (Exception e) {
            System.out.println("nahi jal");
            System.out.println(e);
            if(e.getMessage().contains("Duplicate entry")){
                ERRLABLE.setText("Patient Already Admitted..!");
            }
        }

        }
    }//GEN-LAST:event_SUBMITActionPerformed

    private void VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VIEWActionPerformed

    private void PIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIDActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void PIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PIDKeyPressed
        System.out.println("inside the event..") ;
//       
        if(evt.getKeyCode()==10){ 
            ERRLABLE.setText("");
             try{ 
                 Pid = Integer.parseInt(PID.getText()); 
                 ResultSet result = statement.executeQuery("SELECT * FROM VHSHOSPITAL.APPOINTMENTS WHERE PID="+PID.getText());
                 
                  while(result.next()){ 
                      String doctorName = result.getString("DRNAME").toUpperCase();
                       if(doctorName.equals(drname.getText())){
                           String F=result.getString("FNAME");
                           String L=result.getString("MNAME");
                           String M=result.getString("LNAME");
                           String FF= F+" "+ M +" " +L;
                           FULLNAME.setText("NAME : "+FF); 
                           AGE.setText("AGE : " + result.getString("AGE"));
                           GENDER.setText("GENDER :" + result.getString("GENDER")); 
                           ERRLABLE.setText("");
                       }else{
                           ERRLABLE.setText("NOT UER PATIENT.."); 
                       }
                  } 
             }catch(Exception e){
                
                 System.out.println(e);
             }
             
         }
    }//GEN-LAST:event_PIDKeyPressed

    private void PIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PIDMouseClicked

    private void PIDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PIDMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_PIDMouseMoved

    private void REPORTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REPORTSMouseClicked
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f=chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            REPORTS.setText(filename);
            
            String DbName = "Patient"+"_"+PID.getText();  
            String DbNaxme = "Patient"+"_"+drname.getText();

            
            String newPath = "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/DR_PHOTO/";
            File directionary = new File(newPath);
            if(!directionary.exists()){
                directionary.mkdirs();
            }
            File sourcsfile  = null;
            File destinationFile =null;
            String  extension = filename.substring(filename.lastIndexOf('.') +1);
            sourcsfile = new File(filename);
            destinationFile = new File(newPath+ DbName+"." +extension);
            Files.copy(sourcsfile.toPath(), destinationFile.toPath());

        }catch(Exception e){}        // TODO add your handling code here:
    }//GEN-LAST:event_REPORTSMouseClicked

    private void WARDNAMEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_WARDNAMEItemStateChanged

    }//GEN-LAST:event_WARDNAMEItemStateChanged

    private void REPORTSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_REPORTSKeyTyped
        char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        REPORTS.setEditable(false);
    }else{
    REPORTS.setEditable(true);
      char b = evt.getKeyChar();
        if(Character.isDigit(b)){
            evt.consume();
        }

    }
    }//GEN-LAST:event_REPORTSKeyTyped

    private void CFULLNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CFULLNAMEKeyTyped
 char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        CFULLNAME.setEditable(true);
    }else{
    CFULLNAME.setEditable(false);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_CFULLNAMEKeyTyped

    private void RTOPATIENTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RTOPATIENTKeyTyped
char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        RTOPATIENT.setEditable(true);
    }else{
    RTOPATIENT.setEditable(false);
    }
    }//GEN-LAST:event_RTOPATIENTKeyTyped

    private void CAGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CAGEKeyTyped
 char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
 String p = CAGE.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<3){
                   CAGE.setEditable(true);
               }else{
                   CAGE.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   CAGE.setEditable(true);
               }else{
                   CAGE.setEditable(true);
               }
           }        // TODO add your handling code here:
    }//GEN-LAST:event_CAGEKeyTyped

    private void CAADHAARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CAADHAARKeyTyped
       char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
 String p = CAADHAAR.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<12){
                   CAADHAAR.setEditable(true);
               }else{
                   CAADHAAR.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   CAADHAAR.setEditable(true);
               }else{
                   CAADHAAR.setEditable(true);
               }
           } 
    }//GEN-LAST:event_CAADHAARKeyTyped

    private void CONTACTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACTKeyTyped
  char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
 String p = CONTACT.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<12){
                   CONTACT.setEditable(true);
               }else{
                   CONTACT.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   CONTACT.setEditable(true);
               }else{
                   CONTACT.setEditable(true);
               }
           }         // TODO add your handling code here:
    }//GEN-LAST:event_CONTACTKeyTyped

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
            java.util.logging.Logger.getLogger(OPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OPD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
    }

    
     int Sr;
    int Pid;
    String Drname;
    String Fname; 
    String Mname;
    String Lname;
    int Age;
    String Gender;
    String Symptoms;
    String Medicines;
    String Treatment;
    String Reports;
    String Dateofadmit;
    String Wardname;
    int Bedno;
    String Cfullname;
    int Cage;
    String Cgender;
    String Email;
    Long Contact;
    String Rtopatient;
    String CAddress;
    String Date;
    String Time;
    Statement statement;
    String PtableName;
     String DbName="";
    ResultSet drInfo;
    Long Caddhar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AGE;
    private javax.swing.JTextField BEDNO;
    private javax.swing.JTextField CAADHAAR;
    private javax.swing.JTextField CADDRESS;
    private javax.swing.JTextField CAGE;
    private javax.swing.JTextField CFULLNAME;
    private javax.swing.JComboBox<String> CGENDER;
    private javax.swing.JTextField CONTACT;
    private javax.swing.JLabel DATE;
    private com.toedter.calendar.JDateChooser DATEOFADMIT;
    private javax.swing.JButton DELETE;
    private javax.swing.JLabel ERRLABLE;
    private javax.swing.JLabel FULLNAME;
    private javax.swing.JLabel GENDER;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JTextArea MEDICINES;
    private javax.swing.JTextField PID;
    private javax.swing.JTextArea REPORTS;
    private javax.swing.JTextField RTOPATIENT;
    private javax.swing.JButton SUBMIT;
    private javax.swing.JTextArea SYMPTOMS;
    private javax.swing.JLabel TIME;
    private javax.swing.JTextArea TREATMENT;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton VIEW;
    private javax.swing.JComboBox<String> WARDNAME;
    private javax.swing.JComboBox<String> admitStatus;
    private javax.swing.JPanel admitYesPanel;
    private javax.swing.JPanel admitYesPanel2;
    private javax.swing.JLabel drname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
