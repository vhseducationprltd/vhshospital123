
package multispecility_hospital_solapur;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;
import multispecility_hospital_solapur.ADMIN.ADMIN;
import multispecility_hospital_solapur.DATA_TABLES.PATIENTS;
import multispecility_hospital_solapur.use.GetConnection;
import multispecility_hospital_solapur.use.getTotalUsers;
import static org.eclipse.persistence.internal.jpa.metadata.xml.XMLEntityMappingsReader.clear;

public class NEW_PATIENTS extends javax.swing.JFrame {

    public NEW_PATIENTS() {
        
        initComponents();  
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        statement = new GetConnection().Connect_mysql();
        
        this.getAllUsers();
       
        showDate();
        showTime();
         
         try {
             
            String query = "SELECT * FROM VHSHOSPITAL.DOCTORS";
            ResultSet result = statement.executeQuery(query);
            
            
            while (result.next()) {
                 String a = result.getString("FNAME");
                DrOpds.add(result.getString("OPDNO"));
                DrFees.add(result.getString("FEE"));

                String b = result.getString("MNAME");
                String c = result.getString("LNAME");         

                String d = a+" "+b+" "+ c;
                DRNAME.addItem("DR." +d.toUpperCase()); 
            } 
           
        } catch (Exception e) {
            System.out.println("Something is happened In NewPatients ..");
            System.out.println(e);
        }

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
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                TIME.setText(s.format(d));
            }
            
        }).start();
    }
     public void getAllUsers(){
        //        PATIENTS
        String total = new getTotalUsers().getTotalPatients();
        int tempTotal = 1+ Integer.parseInt(total);
        String totall = "";

   try{ 
            ResultSet ress = statement.executeQuery("SELECT MAX(Sr) AS max  FROM VHSHOSPITAL.NURSES;");
        while(ress.next()){
            totall = ress.getString("max"); 
            totall = Integer.toString((Integer.parseInt(totall)+1));
        }
        }catch(Exception e){
            System.out.println(e);
        }
   if(totall==null){
            totall="1";
        }
        PID.setText(Integer.toString(tempTotal)); 

       
  }

     void getData() {
      
        Pid = Integer.parseInt(PID.getText());
        Fname = FNAME.getText().toUpperCase();
        Mname = MNAME.getText();
        Lname = LNAME.getText();
        Age = Integer.parseInt(AGE.getText());
         String date = ((JTextField)DOB.getDateEditor().getUiComponent()).getText();
        
        Dob = LocalDate.parse(date).toString();
        
        Gender = GENDER.getItemAt(GENDER.getSelectedIndex()); 
        Mstatus = MSTATUS.getItemAt(MSTATUS.getSelectedIndex());
        Contact1 = Long.parseLong(CONTACT1.getText());  
        Contact2 = Long.parseLong(CONTACT2.getText());
        Symptoms = SYMPTOMS.getText();
        Aadhaarno = Long.parseLong(AADHAARNO.getText());
        Panno = PANNO.getText();
        Drname = DRNAME.getItemAt(DRNAME.getSelectedIndex());
        Opdno = Integer.parseInt(OPDNO.getText());
        Fee = Integer.parseInt(FEE.getText());
        Address = ADDRESS.getText();
        City = CITY.getText();
        District = DISTRICT.getText();
        State = STATE.getText();
        Country = COUNTRY.getText();
        Pincode = Long.parseLong(PINCODE.getText());
        Date = DATE.getText();
        Time = TIME.getText();

    }    

     private void clearFields() { 
        PID.setText("");
        FNAME.setText("");
        MNAME.setText("");
        LNAME.setText("");
        AGE.setText(""); 
        DOB.setDate(null);
        CONTACT1.setText("");
        CONTACT2.setText("");
        AADHAARNO.setText("");
        PANNO.setText("");
        FEE.setText("");
        OPDNO.setText("");
        SYMPTOMS.setText("");
        ADDRESS.setText("");
        CITY.setText("");
        DISTRICT.setText("");
        STATE.setText("");
        COUNTRY.setText("");
        PINCODE.setText(""); 
        DERR.setText("  ");
        new ADMIN().getAllUsers();
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        FNAME = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        MNAME = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        LNAME = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        AGE = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        GENDER = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        DOB = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        MSTATUS = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        CONTACT1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CONTACT2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AADHAARNO = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        PANNO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SYMPTOMS = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        OPDNO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        FEE = new javax.swing.JTextField();
        DRNAME = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        ADDRESS = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CITY = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        DISTRICT = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        COUNTRY = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        PINCODE = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        STATE = new javax.swing.JTextField();
        VIEW = new javax.swing.JButton();
        SUBMIT = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        DERR = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

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

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("FIRST NAME");

        FNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        FNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNAMEActionPerformed(evt);
            }
        });
        FNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FNAMEKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("MIDDLE NAME");

        MNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        MNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNAMEActionPerformed(evt);
            }
        });
        MNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MNAMEKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("LAST NAME");

        LNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNAMEActionPerformed(evt);
            }
        });
        LNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LNAMEKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("AGE");

        AGE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGEActionPerformed(evt);
            }
        });
        AGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AGEKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("GENDER");

        GENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        GENDER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "MALE", "FEMALE", "OTHER" }));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setText("DOB");

        DOB.setDateFormatString("yyyy-MM-dd");
        DOB.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setText("MARIATAL STATUS");

        MSTATUS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        MSTATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("CONTACT   1");

        CONTACT1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CONTACT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTACT1ActionPerformed(evt);
            }
        });
        CONTACT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CONTACT1KeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel17.setText("CONTACT  2");

        CONTACT2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CONTACT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTACT2ActionPerformed(evt);
            }
        });
        CONTACT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CONTACT2KeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel18.setText("AADHAAR NO");

        AADHAARNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AADHAARNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AADHAARNOActionPerformed(evt);
            }
        });
        AADHAARNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AADHAARNOKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel19.setText("PAN NO");

        PANNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PANNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PANNOActionPerformed(evt);
            }
        });
        PANNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PANNOKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("SYMPTOMS");

        SYMPTOMS.setColumns(20);
        SYMPTOMS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SYMPTOMS.setRows(5);
        jScrollPane1.setViewportView(SYMPTOMS);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel20.setText("DOCTORS NAME");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel21.setText("OPD NO");

        OPDNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        OPDNO.setCaretColor(new java.awt.Color(255, 255, 255));
        OPDNO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OPDNOMouseEntered(evt);
            }
        });
        OPDNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OPDNOKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel22.setText("FEE");

        FEE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        FEE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FEEMouseEntered(evt);
            }
        });
        FEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEEActionPerformed(evt);
            }
        });
        FEE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FEEKeyTyped(evt);
            }
        });

        DRNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DRNAME.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DRNAMEItemStateChanged(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel23.setText("ADDRESS");

        ADDRESS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDRESSActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel24.setText("CITY ");

        CITY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CITY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CITYActionPerformed(evt);
            }
        });
        CITY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CITYKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel25.setText("DISTRICT");

        DISTRICT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DISTRICT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISTRICTActionPerformed(evt);
            }
        });
        DISTRICT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DISTRICTKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel26.setText("COUNTRY");

        COUNTRY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        COUNTRY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COUNTRYActionPerformed(evt);
            }
        });
        COUNTRY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                COUNTRYKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel27.setText("ZIP / PIN  CODE");

        PINCODE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PINCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINCODEActionPerformed(evt);
            }
        });
        PINCODE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PINCODEKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel29.setText("STATE");

        STATE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        STATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STATEActionPerformed(evt);
            }
        });
        STATE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                STATEKeyTyped(evt);
            }
        });

        VIEW.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        VIEW.setText("VIEW");
        VIEW.setMargin(new java.awt.Insets(7, 24, 7, 24));
        VIEW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VIEWMouseClicked(evt);
            }
        });
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
        UPDATE.setMargin(new java.awt.Insets(7, 24, 7, 24));
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(232, 59, 59));
        DELETE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        DELETE.setText("DELETE");
        DELETE.setMargin(new java.awt.Insets(7, 24, 7, 24));
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

        DERR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DERR.setForeground(new java.awt.Color(204, 0, 0));
        DERR.setText("    ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DERR, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(CITY, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel26)
                                    .addComponent(COUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(PINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel16)
                                        .addComponent(FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel10)
                                        .addComponent(MNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(CONTACT1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17)
                                                .addComponent(CONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(20, 20, 20)
                                                    .addComponent(jLabel18))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(AADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel19)
                                                .addComponent(PANNO, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(265, 265, 265))
                                                .addComponent(LNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(jLabel14))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addGap(255, 255, 255)
                                            .addComponent(jLabel21))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(DRNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(OPDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(FEE, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LOGOUT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SUBMIT)
                .addGap(34, 34, 34)
                .addComponent(UPDATE)
                .addGap(29, 29, 29)
                .addComponent(DELETE)
                .addGap(18, 18, 18)
                .addComponent(VIEW)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DERR)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FNAME)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(34, 34, 34))
                        .addComponent(jLabel18)
                        .addComponent(jLabel16)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CONTACT2)
                                    .addComponent(AADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CONTACT1)
                                    .addComponent(MSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PANNO)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DRNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OPDNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VIEW)
                    .addComponent(UPDATE)
                    .addComponent(DELETE)
                    .addComponent(SUBMIT)
                    .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel6.setText("RECEPTIONIST");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        TIME.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        TIME.setText("DATE");

        DATE.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        DATE.setText("TIME");

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel8.setText("DATE :");

        jLabel28.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel28.setText("TIME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DATE)
                            .addComponent(TIME))
                        .addGap(36, 36, 36))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DATE)
                        .addComponent(jLabel8))
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TIME)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PIDActionPerformed

    private void FNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNAMEActionPerformed

    private void MNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MNAMEActionPerformed

    private void LNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LNAMEActionPerformed

    private void AGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGEActionPerformed

    private void CONTACT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTACT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONTACT1ActionPerformed

    private void CONTACT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTACT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONTACT2ActionPerformed

    private void AADHAARNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AADHAARNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AADHAARNOActionPerformed

    private void PANNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PANNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PANNOActionPerformed
 
    private void FEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FEEActionPerformed

    private void ADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDRESSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSActionPerformed

    private void CITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CITYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CITYActionPerformed

    private void DISTRICTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DISTRICTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTActionPerformed

    private void COUNTRYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COUNTRYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COUNTRYActionPerformed

    private void PINCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINCODEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PINCODEActionPerformed

    private void STATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STATEActionPerformed

    private void VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWActionPerformed
       try {
            PATIENTS data = new PATIENTS();
            data.setVisible(true);
            data.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            clearFields();
        } catch (Exception e) { 
            System.out.println("probleam to featch the data base to table");
            System.out.println(e);
        }
    }//GEN-LAST:event_VIEWActionPerformed

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
        int Sr = 0;
        getData();
        try {
            String query = "SELECT * FROM VHSHOSPITAL.APPOINTMENTS";
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {
                Sr = Integer.parseInt(result.getString("SR"));
            }
            System.out.println(Sr); 
           query = ("INSERT INTO VHSHOSPITAL.APPOINTMENTS (SR,PID,FNAME,MNAME,LNAME,AGE,GENDER,DOB,MSTATUS,CONTACT1,CONTACT2,AADHAARNO,PANNO,DRNAME,FEE,OPDNO,SYMPTOMS,ADDRESS,CITY,DISTRICT,STATE,COUNTRY,PINCODE,DATE,TIME)VALUES(" + (Sr + 1) + "," + Pid + ",'" + Fname + "','" + Mname + "','" + Lname + "'," + Age + ",'" + Gender + "','"  + Dob + "','" + Mstatus + "'," + Contact1 + "," + Contact2 + "," + Aadhaarno + ",'" + Panno + "','" + Drname + "'," + Fee + "," + Opdno + ",'" + Symptoms + "','" + Address + "','" + City + "','" + District + "','" + State + "','" + Country + "'," + Pincode + ",'" + Date + "','" + Time + "')");
            statement.execute(query);
            clearFields();
            getAllUsers();
        } catch (Exception e) {
            System.out.println("Something is happened In NewPatients ..");
            if(e.getMessage().contains("Duplicate entry")){
                DERR.setText("Duplicate Data..!");
            }
            System.out.println(e);
        }
    }

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
       
getData();
        try {

            String query = " UPDATE VHSHOSPITAL.APPOINTMENTS SET " + "FNAME=" + "'" + Fname + "'," + "MNAME=" + "'" + Mname + "'," + "LNAME=" + "'" + Lname + "'," + "AGE=" + Age + "," + "GENDER=" + "'" + Gender + "'," + "DOB=" + "'" + Dob + "'," + "MSTATUS=" + "'" + Mstatus + "'," + "CONTACT1=" + Contact1 + "," + "CONTACT2=" + Contact2 + "," + "AADHAARNO=" + Aadhaarno + "," + "PANNO=" + "'" + Panno + "'," + "DRNAME=" + "'" + Drname + "'," + "FEE=" + Fee + "," + "OPDNO=" + Opdno + "," + "SYMPTOMS=" + "'" + Symptoms + "'," + "ADDRESS=" + "'" + Address + "'," + "CITY=" + "'" + City + "'," + "DISTRICT=" + "'" + District + "'," + "STATE=" + "'" + State + "'," + "COUNTRY=" + "'" + Country + "'," + "PINCODE=" + Pincode + " WHERE PID=" + Pid;
            
            System.out.println(query); 

            statement.execute(query);
            clearFields();
            getAllUsers();

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        Pid = Integer.parseInt(PID.getText());
        String query = "DELETE FROM VHSHOSPITAL.APPOINTMENTS WHERE PID=" + Pid;
        try {
            statement.execute(query);
            clearFields();
            getAllUsers();


        } catch (Exception e) {
             System.out.println(e);
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void PIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PIDKeyPressed
         if (evt.getKeyCode() == (10)) {
            try {
                String query = "SELECT * FROM VHSHOSPITAL.APPOINTMENTS WHERE PID=" + Integer.parseInt(PID.getText());   

                ResultSet result = statement.executeQuery(query);
                while (result.next()) { 
                   
                        FNAME.setText(result.getString("FNAME"));
                        MNAME.setText(result.getString("MNAME"));
                        LNAME.setText(result.getString("LNAME"));
                        AGE.setText(result.getString("AGE"));
                        
                        switch(result.getString("GENDER")){
                            case "SELECT":GENDER.setSelectedIndex(0);
                                         break;
                            case "MALE":GENDER.setSelectedIndex(1);
                                         break;
                            case "FEMALE":GENDER.setSelectedIndex(2);
                                         break;
                        }
                        
                       DOB.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("DOB")));
                       
                        if(result.getString("MSTATUS").equals("YES")){
                            MSTATUS.setSelectedIndex(1);
                        }else{
                            MSTATUS.setSelectedIndex(0);
                        }
                        
                        CONTACT1.setText(result.getString("CONTACT1"));
                        CONTACT2.setText(result.getString("CONTACT2"));
                        AADHAARNO.setText(result.getString("AADHAARNO"));
                        PANNO.setText(result.getString("PANNO"));
                         
                        FEE.setText(result.getString("FEE"));
                        OPDNO.setText(result.getString("OPDNO"));
                        SYMPTOMS.setText(result.getString("SYMPTOMS"));
                        ADDRESS.setText(result.getString("ADDRESS"));
                        CITY.setText(result.getString("CITY"));
                        DISTRICT.setText(result.getString("DISTRICT"));
                        STATE.setText(result.getString("STATE"));
                        COUNTRY.setText(result.getString("COUNTRY"));
                        PINCODE.setText(result.getString("PINCODE"));

                }
            } catch (Exception e) {
                    System.out.println(e);
            }
        }
    }//GEN-LAST:event_PIDKeyPressed

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
//       JOptionPane.showMessageDialog(rootPane, "DO YOU WANT TO LOG OUT "); 
        this.dispose();
          LOGIN_FORM log = new  LOGIN_FORM();
                     log.setVisible(true);                        
                     this.setVisible(false);
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void VIEWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIEWMouseClicked
         
    }//GEN-LAST:event_VIEWMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void DRNAMEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DRNAMEItemStateChanged
       if(DRNAME.getSelectedIndex()>=0){
           OPDNO.setText(DrOpds.get(DRNAME.getSelectedIndex()));
           FEE.setText(DrFees.get(DRNAME.getSelectedIndex()));

       }
    }//GEN-LAST:event_DRNAMEItemStateChanged

    private void CONTACT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACT1KeyTyped
     
        char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
        
        String p = CONTACT1.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<10){
                   CONTACT1.setEditable(true);
               }else{
                   CONTACT1.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   CONTACT1.setEditable(true);
               }else{
                   CONTACT1.setEditable(true);
               }
           }
    }//GEN-LAST:event_CONTACT1KeyTyped

    private void CONTACT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACT2KeyTyped
         char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
        String p = CONTACT2.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<10){
                   CONTACT2.setEditable(true);
               }else{
                   CONTACT2.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   CONTACT2.setEditable(true);
               }else{
                   CONTACT2.setEditable(true);
               }
           }
    }//GEN-LAST:event_CONTACT2KeyTyped

    private void AADHAARNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AADHAARNOKeyTyped
          char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
        String p = AADHAARNO.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<12){
                   AADHAARNO.setEditable(true);
               }else{
                   AADHAARNO.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   AADHAARNO.setEditable(true);
               }else{
                   AADHAARNO.setEditable(true);
               }
           }
    }//GEN-LAST:event_AADHAARNOKeyTyped

    private void PINCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PINCODEKeyTyped
       char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }
       String p = PINCODE.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<6){
                   PINCODE.setEditable(true);
               }else{
                   PINCODE.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   PINCODE.setEditable(true);
               }else{
                   PINCODE.setEditable(true);
               }
           }
    }//GEN-LAST:event_PINCODEKeyTyped

    private void OPDNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OPDNOKeyTyped
        evt.consume();
    }//GEN-LAST:event_OPDNOKeyTyped

    private void FEEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FEEKeyTyped
        evt.consume();
    }//GEN-LAST:event_FEEKeyTyped

    private void FNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FNAMEKeyTyped

    char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        FNAME.setEditable(true);
    }else{
                FNAME.setEditable(false);

    }
        
        
    }//GEN-LAST:event_FNAMEKeyTyped

    private void MNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MNAMEKeyTyped
char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        MNAME.setEditable(true);
    }else{
                MNAME.setEditable(false);

    }        // TODO add your handling code here:
    }//GEN-LAST:event_MNAMEKeyTyped

    private void LNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LNAMEKeyTyped
char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        LNAME.setEditable(true);
    }else{
                LNAME.setEditable(false);

    }        // TODO add your handling code here:
    }//GEN-LAST:event_LNAMEKeyTyped

    private void CITYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CITYKeyTyped
char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        CITY.setEditable(true);
    }else{
                CITY.setEditable(false);

    }        // TODO add your handling code here:
    }//GEN-LAST:event_CITYKeyTyped

    private void DISTRICTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DISTRICTKeyTyped
char c = evt.getKeyChar();
    if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        DISTRICT.setEditable(true);
    }else{
                DISTRICT.setEditable(false);

    }        // TODO add your handling code here:
    }//GEN-LAST:event_DISTRICTKeyTyped

    private void STATEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STATEKeyTyped
      char c = evt.getKeyChar();

           if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        STATE.setEditable(true);
    }else{
                STATE.setEditable(false);

    }  
    }//GEN-LAST:event_STATEKeyTyped

    private void COUNTRYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_COUNTRYKeyTyped
       char c = evt.getKeyChar();

           if(Character.isLetter(c) || Character.isWhitespace(c)|| Character.isISOControl(c)){
        COUNTRY.setEditable(true);
    }else{
                COUNTRY.setEditable(false);

    }  
    }//GEN-LAST:event_COUNTRYKeyTyped

    private void AGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGEKeyTyped
       
char b = evt.getKeyChar();
        if(!Character.isDigit(b)){
            evt.consume();
        }

        String p = AGE.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<3){
                   AGE.setEditable(true);
               }else{
                   AGE.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   AGE.setEditable(true);
               }else{
                   AGE.setEditable(true);
               }
           }
    }//GEN-LAST:event_AGEKeyTyped

    private void PANNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PANNOKeyTyped

   String p = PANNO.getText();
           int length = p.length();
           char c = evt.getKeyChar();
           if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
               if(length<10){
                   PANNO.setEditable(true);
               }else{
                   PANNO.setEditable(false);
               }
           }else{
               if(evt.getExtendedKeyCode()==KeyEvent.VK_BACKSPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                   PANNO.setEditable(true);
               }else{
                   PANNO.setEditable(true);
               }
           }        // TODO add your handling code here:
    }//GEN-LAST:event_PANNOKeyTyped

    private void OPDNOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OPDNOMouseEntered
        OPDNO.setEditable(false);
    }//GEN-LAST:event_OPDNOMouseEntered

    private void FEEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FEEMouseEntered
         FEE.setEditable(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_FEEMouseEntered
//
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NEW_PATIENTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NEW_PATIENTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NEW_PATIENTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NEW_PATIENTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NEW_PATIENTS().setVisible(true);
            }
        });
    } 

    int Sr;
    int Pid;
    String Fname; 
    String Mname;
    String Lname;
    int Age;
    String Gender;
    String Dob;
    String Mstatus;
    Long Contact1; 
    Long Contact2;
    Long Aadhaarno;
    String Panno;
    String Drname;
    int Fee;
    int Opdno;
    String Symptoms;
    String Address;
    String City ;
    String District; 
    String State ;
    String Country;  
    Long Pincode ;
    String Date;
    String Time;
    Statement statement;
    ArrayList<String> DrOpds = new ArrayList();
    ArrayList<String> DrFees = new ArrayList();  


            



    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AADHAARNO;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE;
    private javax.swing.JTextField CITY;
    private javax.swing.JTextField CONTACT1;
    private javax.swing.JTextField CONTACT2;
    private javax.swing.JTextField COUNTRY;
    private javax.swing.JLabel DATE;
    private javax.swing.JButton DELETE;
    private javax.swing.JLabel DERR;
    private javax.swing.JTextField DISTRICT;
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JComboBox<String> DRNAME;
    private javax.swing.JTextField FEE;
    private javax.swing.JTextField FNAME;
    private javax.swing.JComboBox<String> GENDER;
    private javax.swing.JTextField LNAME;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JTextField MNAME;
    private javax.swing.JComboBox<String> MSTATUS;
    private javax.swing.JTextField OPDNO;
    private javax.swing.JTextField PANNO;
    private javax.swing.JTextField PID;
    private javax.swing.JTextField PINCODE;
    private javax.swing.JTextField STATE;
    private javax.swing.JButton SUBMIT;
    private javax.swing.JTextArea SYMPTOMS;
    private javax.swing.JLabel TIME;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton VIEW;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
