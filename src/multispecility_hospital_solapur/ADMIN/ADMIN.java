package multispecility_hospital_solapur.ADMIN;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import multispecility_hospital_solapur.LOGIN_FORM;
import multispecility_hospital_solapur.use.GetConnection;
import multispecility_hospital_solapur.use.getTotalUsers;

public class ADMIN extends javax.swing.JFrame {

  public ADMIN() {
    initComponents();
    statement = new GetConnection().Connect_mysql();
    getAllWards();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    getdata();
    this.getAllUsers();
    showDate();
    showTime();
  }

  public void getdata() {
    //     DOCTORSLIST
    try {
      DefaultTableModel table = (DefaultTableModel) DOCTORS_LIST.getModel();
      System.out.println("Inside the pati");
      String query = "SELECT * FROM VHSHOSPITAL.DOCTORS";
      Statement statement = new GetConnection().Connect_mysql();
      ResultSet result = statement.executeQuery(query);

      while (result.next()) {
        String Data[] = {
          result.getString("SR"),
          result.getString("ID"),
          result.getString("FNAME"),
          result.getString("MNAME"),
          result.getString("LNAME"),
          result.getString("AGE"),
          result.getString("GENDER"),
          result.getString("DOB"),
          result.getString("MSTATUS"),
          result.getString("UPHOTO"),
          result.getString("USERNAME"),
          result.getString("PASSWORD"),
          result.getString("SPECIALIZATION"),
          result.getString("EDUCATION"),
          result.getString("FEE"),
          result.getString("OPDNO"),
          result.getString("JOBEXP"),
          result.getString("DATEOFJOIN"),
          result.getString("LKNOWN"),
          result.getString("DOCUMENT"),
          result.getString("EMAIL"),
          result.getString("CONTACT1"),
          result.getString("CONTACT2"),
          result.getString("ECONTACT"),
          result.getString("AADHAAR"),
          result.getString("PAN"),
          result.getString("ADDRESS"),
          result.getString("CITY"),
          result.getString("DISTRICT"),
          result.getString("STATE"),
          result.getString("COUNTRY"),
          result.getString("PIN"),
          result.getString("DATE"),
          result.getString("TIME"),
        };
        table.addRow(Data);
      }
    } catch (Exception e) {}

    try {
      DefaultTableModel table = (DefaultTableModel) NURSE_LIST.getModel();
      System.out.println("Inside the pati");
      String query = "SELECT * FROM VHSHOSPITAL.DOCTORS";
      Statement statement = new GetConnection().Connect_mysql();
      ResultSet result = statement.executeQuery(query);

      while (result.next()) {
        String Data[] = {
          result.getString("SR"),
          result.getString("ID"),
          result.getString("FNAME"),
          result.getString("MNAME"),
          result.getString("LNAME"),
          result.getString("AGE"),
          result.getString("GENDER"),
          result.getString("DOB"),
          result.getString("MSTATUS"),
          result.getString("UPHOTO"),
          result.getString("USERNAME"),
          result.getString("PASSWORD"),
          result.getString("SPECIALIZATION"),
          result.getString("EDUCATION"),
          result.getString("JOBEXP"),
          result.getString("DATEOFJOIN"),
          result.getString("LKNOWN"),
          result.getString("DOCUMENT"),
          result.getString("EMAIL"),
          result.getString("CONTACT1"),
          result.getString("CONTACT2"),
          result.getString("AADHAAR"),
          result.getString("PAN"),
          result.getString("ADDRESS"),
          result.getString("CITY"),
          result.getString("DISTRICT"),
          result.getString("STATE"),
          result.getString("COUNTRY"),
          result.getString("PIN"),
          result.getString("DATE"),
          result.getString("TIME"),
        };

        table.addRow(Data);
      }
    } catch (Exception e) {}

    try {
      DefaultTableModel table = (DefaultTableModel) RECEPTIONIST_LIST.getModel();
      System.out.println("Inside the pati");
      String query = "SELECT * FROM VHSHOSPITAL.RECEPTIONISTS";
      Statement statement = new GetConnection().Connect_mysql();
      ResultSet result = statement.executeQuery(query);

      while (result.next()) {
        String Data[] = {
          result.getString("SR"),
          result.getString("ID"),
          result.getString("FNAME"),
          result.getString("MNAME"),
          result.getString("LNAME"),
          result.getString("AGE"),
          result.getString("GENDER"),
          result.getString("DOB"),
          result.getString("MSTATUS"),
          result.getString("UPHOTO"),
          result.getString("USERNAME"),
          result.getString("PASSWORD"),
          result.getString("SPECIALIZATION"),
          result.getString("EDUCATION"),
          result.getString("JOBEXP"),
          result.getString("DATEOFJOIN"),
          result.getString("LKNOWN"),
          result.getString("DOCUMENT"),
          result.getString("EMAIL"),
          result.getString("CONTACT1"),
          result.getString("CONTACT2"),
          result.getString("AADHAAR"),
          result.getString("PAN"),
          result.getString("ADDRESS"),
          result.getString("CITY"),
          result.getString("DISTRICT"),
          result.getString("STATE"),
          result.getString("COUNTRY"),
          result.getString("PIN"),
          result.getString("DATE"),
          result.getString("TIME"),
        };

        table.addRow(Data);
      }
    } catch (Exception e) {}

    try {
      DefaultTableModel table = (DefaultTableModel) PATIENTS_DATA.getModel();
      System.out.println("Inside the pati");
      String query = "SELECT * FROM VHSHOSPITAL.APPOINTMENTS";
      Statement statement = new GetConnection().Connect_mysql();
      ResultSet result = statement.executeQuery(query);

      while (result.next()) {
        String Data[] = {
          result.getString("SR"),
          result.getString("PID"),
          result.getString("FNAME"),
          result.getString("MNAME"),
          result.getString("LNAME"),
          result.getString("AGE"),
          result.getString("GENDER"),
          result.getString("DOB"),
          result.getString("MSTATUS"),
          result.getString("CONTACT1"),
          result.getString("CONTACT2"),
          result.getString("AADHAARNO"),
          result.getString("PANNO"),
          result.getString("DRNAME"),
          result.getString("FEE"),
          result.getString("OPDNO"),
          result.getString("SYMPTOMS"),
          result.getString("ADDRESS"),
          result.getString("CITY"),
          result.getString("DISTRICT"),
          result.getString("STATE"),
          result.getString("COUNTRY"),
          result.getString("PINCODE"),
          result.getString("TIME"),
          result.getString("DATE"),
        };

        table.addRow(Data);
      }
    } catch (Exception e) {}
  }

  public void search(String str) {
    DefaultTableModel model = (DefaultTableModel) DOCTORS_LIST.getModel();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    DOCTORS_LIST.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
  }

  public void search1(String str) {
    DefaultTableModel model = (DefaultTableModel) NURSE_LIST.getModel();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    NURSE_LIST.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
  }

  public void search2(String str) {
    DefaultTableModel model = (DefaultTableModel) RECEPTIONIST_LIST.getModel();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    RECEPTIONIST_LIST.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
  }

  public void search3(String str) {
    DefaultTableModel model = (DefaultTableModel) PATIENTS_DATA.getModel();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    PATIENTS_DATA.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
  }

  void showDate() {
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
    DATE.setText(s.format(d));
    RDATE.setText(s.format(d));
    RDATE1.setText(s.format(d));
    DDATE.setText(s.format(d));
  }

  public void getAllUsers() {
    //        Doctors
    String total = new getTotalUsers().getTotalDoctors();
    String totall = "";
    try {
      ResultSet ress = statement.executeQuery(
        "SELECT MAX(ID) AS max  FROM VHSHOSPITAL.DOCTORS;"
      );
      while (ress.next()) {
        totall = ress.getString("max");
        totall = Integer.toString((Integer.parseInt(totall) + 1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if (totall == null) {
      totall = "1";
    }

    DID.setText(totall);
    TDOCTORS.setText(total);

    //     RESEPTIONISTS

    total = new getTotalUsers().getTotalReceptionists();
    totall = "";

    try {
      ResultSet ress = statement.executeQuery(
        "SELECT MAX(ID) AS max  FROM VHSHOSPITAL.RECEPTIONISTS;"
      );
      while (ress.next()) {
        totall = ress.getString("max");
        totall = Integer.toString((Integer.parseInt(totall) + 1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if (totall == null) {
      totall = "1";
    }

    RID.setText(totall);
    TRESEPTIONISTS.setText(total);
    //        NURSES
    total = new getTotalUsers().getTotalNurses();
    totall = "";

    try {
      ResultSet ress = statement.executeQuery(
        "SELECT MAX(ID) AS max  FROM VHSHOSPITAL.NURSES;"
      );
      while (ress.next()) {
        totall = ress.getString("max");
        totall = Integer.toString((Integer.parseInt(totall) + 1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if (totall == null) {
      totall = "1";
    }

    NID.setText(totall);
    TNURSES.setText(total);

    //        PATIENTS
    total = new getTotalUsers().getTotalPatients();
    totall = "";

    try {
      ResultSet ress = statement.executeQuery(
        "SELECT MAX(ID) AS max  FROM VHSHOSPITAL.APPOINTMENTS;"
      );
      while (ress.next()) {
        totall = ress.getString("max");
        totall = Integer.toString((Integer.parseInt(totall) + 1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if (totall == null) {
      totall = "1";
    } 
    PID.setText(totall);
    TPATIENTS.setText(total);

    try {
      ResultSet ress = statement.executeQuery(
        "SELECT MAX(ID) AS max  FROM VHSHOSPITAL.WARD;"
      );
      while (ress.next()) {
        totall = ress.getString("max");
        totall = Integer.toString((Integer.parseInt(totall) + 1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if (totall == null) {
      totall = "1";
    }
    //    WID.setText(totall);
  }

  void showTime() {
    new Timer(
      0,
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Date d = new Date();
          SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
          TIME.setText(s.format(d));
          RTIME.setText(s.format(d));
          RTIME1.setText(s.format(d));
          DTIME.setText(s.format(d));
        }
      }
    )
      .start();
  }

  void getData3() {
    //    Sr = Integer.parseInt(SR.getText());
    Rid = Integer.parseInt(NID.getText());
    Fname = NFNAME.getText();
    Mname = NMNAME.getText();
    Lname = NLNAME.getText();
    Age = Integer.parseInt(NAGE.getText());
    Gender = NGENDER.getItemAt(NGENDER.getSelectedIndex());
    String date =
      ((JTextField) NDOB.getDateEditor().getUiComponent()).getText();
    Dob = LocalDate.parse(date).toString();
    Mstatus = NMSTATUS.getItemAt(NMSTATUS.getSelectedIndex());
    Userphoto = NUSERPHOTO.getText();
    Username = NUSERNAME.getText();
    Password = NPASSWORD.getText();
    Specialization = NSPECIALIZATION.getText();
    Education = NEDUCATION.getText();
    Jobexperience = NJOB_EXPERIENCE.getText();
    Lknown = NLKNOWN.getText();
    Document = NDOCUMENT.getText();
    Email = NEMAIL.getText();
    Contact1 = Long.parseLong(NCONTACT1.getText());
    Contact2 = Long.parseLong(NCONTACT2.getText());
    Aadhaarno = Long.parseLong(NAADHAARNO.getText());
    Panno = NPANNO.getText();
    Address = NADDRESS.getText();
    City = NCITY.getText();
    District = NDISTRICT.getText();
    State = NSTATE.getText();
    Country = NCOUNTRY.getText();
    String date2 =
      ((JTextField) NDATEOFJOINING.getDateEditor().getUiComponent()).getText();
    Dateofjoin = LocalDate.parse(date2).toString();
    Pincode = Long.parseLong(NPINCODE.getText());
    Date = DATE.getText();
    Time = TIME.getText();
  }

  void getData2() {
    Rid = Integer.parseInt(RID.getText());
    Fname = RFNAME.getText();
    Mname = RMNAME.getText();
    Lname = RLNAME.getText();
    Age = Integer.parseInt(RAGE.getText());
    Gender = RGENDER.getItemAt(RGENDER.getSelectedIndex());
    String date =
      ((JTextField) RDOB.getDateEditor().getUiComponent()).getText();
    Dob = LocalDate.parse(date).toString();
    Mstatus = RMSTATUS.getItemAt(RMSTATUS.getSelectedIndex());
    Userphoto = RUSERPHOTO.getText();
    Username = RUSERNAME.getText();
    Password = RPASSWORD.getText();
    Specialization = RSPECIALIZATION.getText();
    Education = REDUCATION.getText();
    Jobexperience = RJOB_EXPERIENCE.getText();
    Lknown = RLKNOWN.getText();
    Document = RDOCUMENT.getText();
    Email = REMAIL.getText();
    Contact1 = Long.parseLong(RCONTACT1.getText());
    Contact2 = Long.parseLong(RCONTACT2.getText());
    Aadhaarno = Long.parseLong(RAADHAARNO.getText());
    Panno = RPANNO.getText();
    Address = RADDRESS.getText();
    City = RCITY.getText();
    District = RDISTRICT.getText();
    State = RSTATE.getText();
    Country = RCOUNTRY.getText();
    String date2 =
      ((JTextField) RDATEOFJOINING.getDateEditor().getUiComponent()).getText();
    Dateofjoin = LocalDate.parse(date2).toString();
    Pincode = Long.parseLong(RPINCODE.getText());
    Date = DATE.getText();
    Time = TIME.getText();
  }

  void getData() {  
    Did = Integer.parseInt(DID.getText());
    Fname = FNAME.getText();
    Mname = MNAME.getText();
    Lname = LNAME.getText();
    Age = Integer.parseInt(AGE.getText());
    Gender = GENDER.getItemAt(GENDER.getSelectedIndex());
    String date = ((JTextField) DOB.getDateEditor().getUiComponent()).getText();
    Dob = LocalDate.parse(date).toString();
    Mstatus = MSTATUS.getItemAt(MSTATUS.getSelectedIndex());
    Education = EDUCATION.getText();
    Specilization = SPECIALIZATION.getText();
    Jobexperience = JOB_EXPERIENCE.getText();
    Lknown = LKNOWN.getText();
    Address = ADDRESS.getText();
    City = CITY.getText();
    District = DISTRICT.getText();
    State = STATE.getText();
    Country = COUNTRY.getText();
    Pincode = Long.parseLong(PINCODE.getText());
    Email = EMAIL.getText();
    Contact1 = Long.parseLong(CONTACT1.getText());
    Fee = Integer.parseInt(FEE.getText());
    Opd = Integer.parseInt(OPD_NO.getText());
    Contact2 = Long.parseLong(CONTACT2.getText());
    EContact = Long.parseLong(EMERGANCY_CONTACT.getText());
    photo = USERPHOTO.getText();
    Document = DOCUMENT.getText();
    Aadhaarno = Long.parseLong(AADHAARNO.getText());
    Panno = PANNO.getText();
    Time = TIME.getText();
    Date = DATE.getText();
    String date2 =
      ((JTextField) DATEOFJOINING.getDateEditor().getUiComponent()).getText();
    DateJoin = LocalDate.parse(date2).toString();
    Userid = USERNAME.getText();
    Password = PASSWORD.getText();
    Cpassword = CPASSWORD.getText(); 
  }

  void getwarddata() {
    Wid = Integer.parseInt(WID.getText());
    Ward = WARD.getText();
    Charges = Integer.parseInt(CHARGES.getText());
  }

  void clearFields() {
    DID.setText("");
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
    OPD_NO.setText("");
    ADDRESS.setText("");
    CITY.setText("");
    DISTRICT.setText("");
    STATE.setText("");
    COUNTRY.setText("");
    EDUCATION.setText("");
    USERPHOTO.setText("");
    EMERGANCY_CONTACT.setText("");
    JOB_EXPERIENCE.setText("");
    DOCUMENT.setText("");
    EMAIL.setText("");
    SPECIALIZATION.setText("");
    MSTATUS.setSelectedIndex(0);
    PINCODE.setText("");
    USERNAME.setText("");
    PASSWORD.setText("");
    GENDER.setSelectedIndex(0);
    LKNOWN.setText("");
    GENDER.setSelectedIndex(0);
    DATEOFJOINING.setDate(null);
    CPASSWORD.setText("");
    //
    RID.setText("");
    RFNAME.setText("");
    RMNAME.setText("");
    RLNAME.setText("");
    RAGE.setText("");
    RDOB.setDate(null);
    RCONTACT1.setText("");
    RCONTACT2.setText("");
    RAADHAARNO.setText("");
    RPANNO.setText("");
    RADDRESS.setText("");
    RCITY.setText("");
    RDISTRICT.setText("");
    RSTATE.setText("");
    RCOUNTRY.setText("");
    REDUCATION.setText("");

    RUSERPHOTO.setText("");
    RJOB_EXPERIENCE.setText("");
    RDOCUMENT.setText("");
    REMAIL.setText("");
    RSPECIALIZATION.setText("");
    RMSTATUS.setSelectedIndex(0);
    RPINCODE.setText("");
    RUSERNAME.setText("");
    RPASSWORD.setText("");
    RGENDER.setSelectedIndex(0);
    RLKNOWN.setText("");
    RGENDER.setSelectedIndex(0);
    RDATEOFJOINING.setDate(null);
    RCPASSWORD.setText("");

    //
    NID.setText("");
    NFNAME.setText("");
    NMNAME.setText("");
    NLNAME.setText("");
    NAGE.setText("");
    NDOB.setDate(null);
    NCONTACT1.setText("");
    NCONTACT2.setText("");
    NAADHAARNO.setText("");
    NPANNO.setText("");
    NADDRESS.setText("");
    NCITY.setText("");
    NDISTRICT.setText("");
    NSTATE.setText("");
    NCOUNTRY.setText("");
    NEDUCATION.setText("");
    NUSERPHOTO.setText("");
    NJOB_EXPERIENCE.setText("");
    NDOCUMENT.setText("");
    NEMAIL.setText("");
    NSPECIALIZATION.setText("");
    NMSTATUS.setSelectedIndex(0);
    NPINCODE.setText("");
    NUSERNAME.setText("");
    NPASSWORD.setText("");
    NGENDER.setSelectedIndex(0);
    NLKNOWN.setText("");
    NGENDER.setSelectedIndex(0);
    NDATEOFJOINING.setDate(null);
    NCPASSWORD.setText("");

    ///
    WID.setText("");
    WARD.setText("");
    CHARGES.setText("");
    ERRORLABLE.setText("");
    
    ERR.setText(" ");
  }

  int Sr;
  int Did;
  String Fname; 
  String Mname;
  String Lname;
  int Age;
  int Opd;
  int Fee;
  int Rid;

  int Wid;
  int Charges;
  String Ward;

  String Userphoto;
  String Username;
  String Specialization;
  String Dateofjoin;
  String Gender;
  String Dob;
  String Mstatus;
  String Education;
  String Specilization;
  String Jobexperience;
  String Lknown;
  String Address;
  String City;
  String District;
  String State;
  String Country;
  Long Pincode;
  String Email;
  Long Contact1;
  Long Contact2;
  Long EContact;
  String photo;
  String Document;
  Long Aadhaarno;
  String Panno;
  String Time;
  String Date;
  String DateJoin;
  String Userid;
  String Password;
  String Cpassword;
  Statement statement;
  boolean status=true;

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jPanel9 = new javax.swing.JPanel();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        VHSHOSPITALPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("VHSHOSPITALPU").createEntityManager();
        wardsQuery = java.beans.Beans.isDesignTime() ? null : VHSHOSPITALPUEntityManager.createQuery("SELECT w FROM Wards w");
        wardsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : wardsQuery.getResultList();
        wardsQuery1 = java.beans.Beans.isDesignTime() ? null : VHSHOSPITALPUEntityManager.createQuery("SELECT w FROM Wards w");
        wardsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : wardsQuery1.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        DASHBOARD0 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        TDOCTORS = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        TDEATH = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        TNURSES = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        TADMIT = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        TPATIENTS = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        TRESEPTIONISTS = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DOCTORS_CREATE = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        DID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        FNAME = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        MNAME = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        LNAME = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        AGE = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        GENDER = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        MSTATUS = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        USERPHOTO = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        USERNAME = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        VIEW = new javax.swing.JButton();
        SUBMIT = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        SPECIALIZATION = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        JOB_EXPERIENCE = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        LKNOWN = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        DOCUMENT = new javax.swing.JTextField();
        EDUCATION = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        DISTRICT = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        COUNTRY = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        PINCODE = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        STATE = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        ADDRESS = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        CITY = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        EMAIL = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        CONTACT1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        CONTACT2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        AADHAARNO = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        PANNO = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        OPD_NO = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        FEE = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        EMERGANCY_CONTACT = new javax.swing.JTextField();
        ERR = new javax.swing.JLabel();
        DOB = new com.toedter.calendar.JDateChooser();
        DATEOFJOINING = new com.toedter.calendar.JDateChooser();
        PASSWORD = new javax.swing.JPasswordField();
        CPASSWORD = new javax.swing.JPasswordField();
        jLabel46 = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        TIME1 = new javax.swing.JLabel();
        TIME2 = new javax.swing.JLabel();
        RECEPTIONIST_CREATE = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        SeparatorLine1 = new javax.swing.JSeparator();
        jPanel31 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        RID = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        RFNAME = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        RMNAME = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        RLNAME = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        RAGE = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        RGENDER = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        RMSTATUS = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        RUSERPHOTO = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        RUSERNAME = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        RVIEW = new javax.swing.JButton();
        RSUBMIT = new javax.swing.JButton();
        RUPDATE = new javax.swing.JButton();
        RDELETE = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        RSPECIALIZATION = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        RJOB_EXPERIENCE = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        RLKNOWN = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        RDOCUMENT = new javax.swing.JTextField();
        REDUCATION = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        RDISTRICT = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        RCOUNTRY = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        RPINCODE = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        RSTATE = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        RADDRESS = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        RCITY = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        REMAIL = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        RCONTACT1 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        RCONTACT2 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        RAADHAARNO = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        RPANNO = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        RDOB = new com.toedter.calendar.JDateChooser();
        RDATEOFJOINING = new com.toedter.calendar.JDateChooser();
        RPASSWORD = new javax.swing.JPasswordField();
        RCPASSWORD = new javax.swing.JPasswordField();
        jLabel85 = new javax.swing.JLabel();
        RDATE = new javax.swing.JLabel();
        RTIME = new javax.swing.JLabel();
        RDATE2 = new javax.swing.JLabel();
        RDATE3 = new javax.swing.JLabel();
        NURSE_CREATE = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        NID = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        NFNAME = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        NMNAME = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        NLNAME = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        NAGE = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        NGENDER = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        NMSTATUS = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        NUSERPHOTO = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        NUSERNAME = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        RVIEW1 = new javax.swing.JButton();
        NSUBMIT = new javax.swing.JButton();
        RUPDATE1 = new javax.swing.JButton();
        RDELETE1 = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        NSPECIALIZATION = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        NJOB_EXPERIENCE = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        NLKNOWN = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        NDOCUMENT = new javax.swing.JTextField();
        NEDUCATION = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        NDISTRICT = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        NCOUNTRY = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        NPINCODE = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        NSTATE = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        NADDRESS = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        NCITY = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        NEMAIL = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        NCONTACT1 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        NCONTACT2 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        NAADHAARNO = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        NPANNO = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        NDOB = new com.toedter.calendar.JDateChooser();
        NDATEOFJOINING = new com.toedter.calendar.JDateChooser();
        NPASSWORD = new javax.swing.JPasswordField();
        NCPASSWORD = new javax.swing.JPasswordField();
        jLabel118 = new javax.swing.JLabel();
        RDATE1 = new javax.swing.JLabel();
        RTIME1 = new javax.swing.JLabel();
        RDATE4 = new javax.swing.JLabel();
        RTIME2 = new javax.swing.JLabel();
        WARD_CREATE = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        WID = new javax.swing.JTextField();
        NSUBMIT1 = new javax.swing.JButton();
        RUPDATE2 = new javax.swing.JButton();
        RDELETE2 = new javax.swing.JButton();
        jLabel148 = new javax.swing.JLabel();
        WARD = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        CHARGES = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        WARDSTABLE = new javax.swing.JTable();
        ERRORLABLE = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        RDATE5 = new javax.swing.JLabel();
        RTIME3 = new javax.swing.JLabel();
        RDATE6 = new javax.swing.JLabel();
        RTIME4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DISCHARGE_FORM = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        PID = new javax.swing.JTextField();
        RSUBMIT2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        OTAMOUNT = new javax.swing.JTextField();
        FULLNAME = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        NOOFDAAYS = new javax.swing.JLabel();
        WARDNAME = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        PATIENT_STATUS = new javax.swing.JComboBox<>();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        EXTRA_AMOUNT = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        DRNAME = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TREATMENT = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        MEDICINES = new javax.swing.JTextArea();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        DDATE = new javax.swing.JLabel();
        DTIME = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        DOCTORLIST = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        DOCTORS_LIST = new javax.swing.JTable();
        PATIENTS1 = new javax.swing.JLabel();
        txt_search1 = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        NURSEEE = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NURSE_LIST = new javax.swing.JTable();
        txt_search2 = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RECEPTIONISTDARA = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        RECEPTIONIST_LIST = new javax.swing.JTable();
        txt_search3 = new javax.swing.JTextField();
        search3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        PATIENTSD = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_search4 = new javax.swing.JTextField();
        search4 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        PATIENTS_DATA = new javax.swing.JTable();
        PATIENTS = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem10.setText("jMenuItem10");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem12.setText("jMenuItem12");

        jMenuItem13.setText("jMenuItem13");

        jMenuItem14.setText("jMenuItem14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DASHBOARD0.setBackground(new java.awt.Color(218, 218, 238));
        DASHBOARD0.setPreferredSize(new java.awt.Dimension(1953, 905));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Hnet.com-image.png"))); // NOI18N

        jPanel20.setBackground(new java.awt.Color(180, 180, 246));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });

        TDOCTORS.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TDOCTORS.setText("00");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("DOCTORS");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/iloveimg-resized/1.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(TDOCTORS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(51, 51, 51))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TDOCTORS)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(61, 61, 61))
        );

        jPanel21.setBackground(new java.awt.Color(180, 180, 246));

        TDEATH.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TDEATH.setText("00");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("DEATH");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1_Rec.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(TDEATH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(71, 71, 71))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(TDEATH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(180, 180, 246));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
        });

        TNURSES.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TNURSES.setText("00");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setText("NURSE");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/doctor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(TNURSES)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(66, 66, 66))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(TNURSES))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(180, 180, 246));

        TADMIT.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TADMIT.setText("00");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel12.setText("ADMIT PATIENT");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1_Rec.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TADMIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(72, 72, 72))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(TADMIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(180, 180, 246));

        TPATIENTS.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TPATIENTS.setText("00");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel15.setText("PATIENT");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1_Rec.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(TPATIENTS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(71, 71, 71))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(TPATIENTS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(180, 180, 246));
        jPanel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel40MouseClicked(evt);
            }
        });

        TRESEPTIONISTS.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        TRESEPTIONISTS.setText("00");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("RECEPTIONISTS");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1_Rec.png"))); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(TRESEPTIONISTS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(71, 71, 71))
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(TRESEPTIONISTS))
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(277, 277, 277))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DASHBOARD0Layout = new javax.swing.GroupLayout(DASHBOARD0);
        DASHBOARD0.setLayout(DASHBOARD0Layout);
        DASHBOARD0Layout.setHorizontalGroup(
            DASHBOARD0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARD0Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DASHBOARD0Layout.setVerticalGroup(
            DASHBOARD0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DASHBOARD0Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", DASHBOARD0);

        jPanel26.setBackground(new java.awt.Color(0, 153, 153));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        jPanel27.setBackground(new java.awt.Color(0, 153, 153));

        jLabel21.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel21.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel22.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel22.setText("SOLAPUR .  413006");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel24.setText("DID");

        DID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DIDActionPerformed(evt);
            }
        });
        DID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DIDKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel25.setText("FIRST NAME");

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

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel26.setText("MIDDLE NAME");

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

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel27.setText("LAST NAME");

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

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel28.setText("AGE");

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

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel29.setText("GENDER");

        GENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        GENDER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "MALE", "FEMALE", "OTHER" }));

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel30.setText("DOB");

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel31.setText("MARIATAL STATUS");

        MSTATUS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        MSTATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        jLabel32.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel32.setText("USER PHOTO");

        USERPHOTO.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        USERPHOTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                USERPHOTOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                USERPHOTOMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                USERPHOTOMouseReleased(evt);
            }
        });
        USERPHOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERPHOTOActionPerformed(evt);
            }
        });
        USERPHOTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                USERPHOTOKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel33.setText("USERNAME");

        USERNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        USERNAME.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                USERNAMEInputMethodTextChanged(evt);
            }
        });
        USERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERNAMEActionPerformed(evt);
            }
        });
        USERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                USERNAMEKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel34.setText(" PASSWORD");

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel35.setText("CONFORM PASSWORD");

        VIEW.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        VIEW.setText("VIEW");
        VIEW.setMargin(new java.awt.Insets(7, 24, 7, 24));
        VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEWActionPerformed(evt);
            }
        });

        SUBMIT.setBackground(new java.awt.Color(51, 153, 255));
        SUBMIT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
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

        DELETE.setBackground(new java.awt.Color(255, 0, 0));
        DELETE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        DELETE.setText("DELETE");
        DELETE.setMargin(new java.awt.Insets(7, 24, 7, 24));
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel36.setText("SPECILIAZATION");

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel37.setText("EDUCATION");

        SPECIALIZATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        SPECIALIZATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPECIALIZATIONActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel38.setText("JOB EXPERIENCE");

        JOB_EXPERIENCE.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JOB_EXPERIENCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOB_EXPERIENCEMouseClicked(evt);
            }
        });
        JOB_EXPERIENCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOB_EXPERIENCEActionPerformed(evt);
            }
        });
        JOB_EXPERIENCE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JOB_EXPERIENCEKeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel39.setText("LANGUAGE KNOWN");

        LKNOWN.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LKNOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LKNOWNActionPerformed(evt);
            }
        });
        LKNOWN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LKNOWNKeyTyped(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel40.setText("DOCUMENT");

        DOCUMENT.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DOCUMENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOCUMENTMouseClicked(evt);
            }
        });
        DOCUMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOCUMENTActionPerformed(evt);
            }
        });
        DOCUMENT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DOCUMENTKeyTyped(evt);
            }
        });

        EDUCATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        EDUCATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDUCATIONActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel41.setText("DISTRICT");

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

        jLabel42.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel42.setText("COUNTRY");

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

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel43.setText("ZIP / PIN  CODE");

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

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel44.setText("STATE");

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

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel45.setText("ADDRESS");

        ADDRESS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDRESSActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel47.setText("CITY  ");

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

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel48.setText("EMAIL");

        EMAIL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        EMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMAILActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel49.setText("CONTACT 1");

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

        jLabel50.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel50.setText("CONTACT 2");

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

        jLabel51.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel51.setText("AADHAAR NO");

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

        jLabel52.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel52.setText("PAN NO");

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

        jLabel120.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel120.setText("DATE OF JOINING");

        jLabel122.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel122.setText("OPO_NO");

        OPD_NO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        OPD_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPD_NOActionPerformed(evt);
            }
        });
        OPD_NO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OPD_NOKeyTyped(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel123.setText("FEE");

        FEE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
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

        jLabel124.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel124.setText("EMERGANCY_CONTACT ");

        EMERGANCY_CONTACT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        EMERGANCY_CONTACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMERGANCY_CONTACTActionPerformed(evt);
            }
        });
        EMERGANCY_CONTACT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EMERGANCY_CONTACTKeyTyped(evt);
            }
        });

        ERR.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ERR.setForeground(new java.awt.Color(204, 0, 51));
        ERR.setText("   ");

        DOB.setDateFormatString("yyyy-MM-dd");
        DOB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        DATEOFJOINING.setDateFormatString("yyyy-MM-dd");
        DATEOFJOINING.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        PASSWORD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSWORDActionPerformed(evt);
            }
        });

        CPASSWORD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        CPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPASSWORDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SUBMIT)
                .addGap(34, 34, 34)
                .addComponent(UPDATE)
                .addGap(29, 29, 29)
                .addComponent(DELETE)
                .addGap(18, 18, 18)
                .addComponent(VIEW)
                .addGap(50, 50, 50))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(ERR, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25)
                                    .addComponent(FNAME)
                                    .addComponent(jLabel31)
                                    .addComponent(MSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel26)
                                    .addComponent(MNAME)
                                    .addComponent(USERPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(DOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel30)))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel33)
                                            .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34)
                                            .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addComponent(jLabel35)
                                                .addGap(84, 84, 84))
                                            .addComponent(CPASSWORD)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel122))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel123)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel37)
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addComponent(EDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(JOB_EXPERIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel39)
                                            .addComponent(LKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40)
                                            .addComponent(DOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(42, 42, 42))))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(CONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(AADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(PANNO, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42)
                            .addComponent(COUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(PINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(CITY, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel41))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel120)
                            .addComponent(DATEOFJOINING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(OPD_NO, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FEE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel124)
                            .addComponent(EMERGANCY_CONTACT, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ERR))
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel32))
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel39)
                                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel38)
                                                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(JOB_EXPERIENCE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(LKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel35))
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(CPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(USERPHOTO)
                                            .addComponent(USERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel123)
                                    .addComponent(jLabel124))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EMERGANCY_CONTACT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel122)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OPD_NO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addGap(8, 8, 8)))
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(jLabel52)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PANNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(AADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel44))
                            .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DATEOFJOINING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                            .addComponent(jLabel47)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                            .addComponent(jLabel45)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                            .addComponent(jLabel41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(STATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VIEW)
                    .addComponent(UPDATE)
                    .addComponent(DELETE)
                    .addComponent(SUBMIT))
                .addGap(45, 45, 45))
        );

        jLabel46.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel46.setText("DOCTORS CREATE");

        TIME.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        TIME.setText("DATE");

        DATE.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        DATE.setText("TIME");

        TIME1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        TIME1.setText("TIME  :");

        TIME2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        TIME2.setText("DATE  :");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(727, 727, 727)))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(TIME2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DATE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(TIME1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TIME)))
                        .addGap(91, 91, 91))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TIME1)
                    .addComponent(jLabel46)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(TIME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DATE)
                            .addComponent(TIME2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DOCTORS_CREATELayout = new javax.swing.GroupLayout(DOCTORS_CREATE);
        DOCTORS_CREATE.setLayout(DOCTORS_CREATELayout);
        DOCTORS_CREATELayout.setHorizontalGroup(
            DOCTORS_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOCTORS_CREATELayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DOCTORS_CREATELayout.setVerticalGroup(
            DOCTORS_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOCTORS_CREATELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", DOCTORS_CREATE);

        jPanel30.setBackground(new java.awt.Color(0, 153, 153));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        SeparatorLine1.setBackground(new java.awt.Color(0, 0, 0));
        SeparatorLine1.setForeground(new java.awt.Color(0, 0, 0));
        SeparatorLine1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SeparatorLine1.setDoubleBuffered(true);
        SeparatorLine1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jPanel31.setBackground(new java.awt.Color(0, 153, 153));

        jLabel54.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel54.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel55.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel55.setText("SOLAPUR .  413006");
        jLabel55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addContainerGap())
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addContainerGap())
        );

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jLabel57.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel57.setText("RID");

        RID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RIDActionPerformed(evt);
            }
        });
        RID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RIDKeyPressed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel58.setText("FIRST NAME");

        RFNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RFNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RFNAMEActionPerformed(evt);
            }
        });
        RFNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RFNAMEKeyTyped(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel59.setText("MIDDLE NAME");

        RMNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RMNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RMNAMEActionPerformed(evt);
            }
        });
        RMNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RMNAMEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RMNAMEKeyTyped(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel60.setText("LAST NAME");

        RLNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RLNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RLNAMEActionPerformed(evt);
            }
        });
        RLNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RLNAMEKeyTyped(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel61.setText("AGE");

        RAGE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAGEActionPerformed(evt);
            }
        });
        RAGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RAGEKeyTyped(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel62.setText("GENDER");

        RGENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RGENDER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "MALE", "FEMALE", "OTHER" }));

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel63.setText("DOB");

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel64.setText("MARIATAL STATUS");

        RMSTATUS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RMSTATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        jLabel65.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel65.setText("USER PHOTO");

        RUSERPHOTO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RUSERPHOTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RUSERPHOTOMouseClicked(evt);
            }
        });
        RUSERPHOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUSERPHOTOActionPerformed(evt);
            }
        });
        RUSERPHOTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RUSERPHOTOKeyTyped(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel66.setText("USERNAME");

        RUSERNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RUSERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUSERNAMEActionPerformed(evt);
            }
        });
        RUSERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RUSERNAMEKeyTyped(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel67.setText(" PASSWORD");

        jLabel68.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel68.setText("CONFORM PASSWORD");

        RVIEW.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RVIEW.setText("VIEW");
        RVIEW.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RVIEWActionPerformed(evt);
            }
        });

        RSUBMIT.setBackground(new java.awt.Color(51, 153, 255));
        RSUBMIT.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RSUBMIT.setText("SUBMIT");
        RSUBMIT.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RSUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSUBMITActionPerformed(evt);
            }
        });

        RUPDATE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RUPDATE.setText("UPDATE");
        RUPDATE.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUPDATEActionPerformed(evt);
            }
        });

        RDELETE.setBackground(new java.awt.Color(255, 0, 0));
        RDELETE.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RDELETE.setText("DELETE");
        RDELETE.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDELETEActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel69.setText("SPECIALIZATION");

        jLabel70.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel70.setText("EDUCATION");

        RSPECIALIZATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RSPECIALIZATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSPECIALIZATIONActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel71.setText("JOB EXPERIENCE");

        RJOB_EXPERIENCE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RJOB_EXPERIENCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RJOB_EXPERIENCEMouseClicked(evt);
            }
        });
        RJOB_EXPERIENCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RJOB_EXPERIENCEActionPerformed(evt);
            }
        });
        RJOB_EXPERIENCE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RJOB_EXPERIENCEKeyTyped(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel72.setText("LANGUAGE KNOWN");

        RLKNOWN.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RLKNOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RLKNOWNActionPerformed(evt);
            }
        });
        RLKNOWN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RLKNOWNKeyTyped(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel73.setText("DOCUMENT");

        RDOCUMENT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RDOCUMENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RDOCUMENTMouseClicked(evt);
            }
        });
        RDOCUMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDOCUMENTActionPerformed(evt);
            }
        });
        RDOCUMENT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RDOCUMENTKeyTyped(evt);
            }
        });

        REDUCATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        REDUCATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REDUCATIONActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel74.setText("DISTRICT");

        RDISTRICT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RDISTRICT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDISTRICTActionPerformed(evt);
            }
        });
        RDISTRICT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RDISTRICTKeyTyped(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel75.setText("COUNTRY");

        RCOUNTRY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RCOUNTRY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCOUNTRYActionPerformed(evt);
            }
        });
        RCOUNTRY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RCOUNTRYKeyTyped(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel76.setText("ZIP / PIN  CODE");

        RPINCODE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RPINCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPINCODEActionPerformed(evt);
            }
        });
        RPINCODE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RPINCODEKeyTyped(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel77.setText("STATE");

        RSTATE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RSTATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSTATEActionPerformed(evt);
            }
        });
        RSTATE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RSTATEKeyTyped(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel78.setText("ADDRESS");

        RADDRESS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RADDRESSActionPerformed(evt);
            }
        });
        RADDRESS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RADDRESSKeyTyped(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel79.setText("CITY");

        RCITY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RCITY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCITYActionPerformed(evt);
            }
        });
        RCITY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RCITYKeyTyped(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel80.setText("EMAIL");

        REMAIL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        REMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REMAILActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel81.setText("CONTACT 1");

        RCONTACT1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RCONTACT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCONTACT1ActionPerformed(evt);
            }
        });
        RCONTACT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RCONTACT1KeyTyped(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel82.setText("CONTACT 2");

        RCONTACT2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RCONTACT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCONTACT2ActionPerformed(evt);
            }
        });
        RCONTACT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RCONTACT2KeyTyped(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel83.setText("AADHAAR NO");

        RAADHAARNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RAADHAARNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAADHAARNOActionPerformed(evt);
            }
        });
        RAADHAARNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RAADHAARNOKeyTyped(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel84.setText("PAN NO");

        RPANNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        RPANNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPANNOActionPerformed(evt);
            }
        });
        RPANNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RPANNOKeyTyped(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel119.setText("DATE OF JOINING");

        RDOB.setDateFormatString("yyyy-MM-dd");
        RDOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RDOBKeyTyped(evt);
            }
        });

        RDATEOFJOINING.setDateFormatString("yyyy-MM-dd");

        RPASSWORD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPASSWORDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(45, 45, 45)
                        .addComponent(RID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel80)
                                .addComponent(REMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel81)
                                .addComponent(RCONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel82)
                                .addComponent(RCONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel83)
                                .addComponent(RAADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel84)
                                .addComponent(RPANNO)))
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RCOUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel75))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel76)
                                        .addComponent(RPINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel78)
                                        .addComponent(RADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel79)
                                        .addComponent(RCITY, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel74)
                                        .addComponent(RDISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RSTATE, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel77))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel119)
                                        .addComponent(RDATEOFJOINING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel69)
                                        .addComponent(RSPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel70)
                                        .addComponent(REDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71)
                                        .addComponent(RJOB_EXPERIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel72)
                                        .addComponent(RLKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel73)
                                        .addComponent(RDOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel58)
                                            .addComponent(RFNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel64)
                                        .addComponent(RMSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel65)
                                        .addComponent(jLabel59)
                                        .addComponent(RMNAME)
                                        .addComponent(RUSERPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel60)
                                                .addComponent(RLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel61)
                                                .addComponent(RAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel62)
                                                .addComponent(RGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel32Layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(RDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel63)))
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel66)
                                                .addComponent(RUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel67)
                                                .addComponent(RPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel68)
                                                .addComponent(RCPASSWORD))))))
                            .addGap(10, 10, 10))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(RSUBMIT)
                .addGap(34, 34, 34)
                .addComponent(RUPDATE)
                .addGap(29, 29, 29)
                .addComponent(RDELETE)
                .addGap(18, 18, 18)
                .addComponent(RVIEW)
                .addGap(80, 80, 80))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel58))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RFNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RAGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(RDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel66)
                                        .addComponent(jLabel68))
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(RUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(RUSERPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(RCPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel67)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel64)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RPASSWORD, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RMSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RDOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel72)
                                            .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel71)
                                                    .addComponent(jLabel70)
                                                    .addComponent(jLabel69))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(RJOB_EXPERIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(RLKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(REDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(RSPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addComponent(jLabel81)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RCONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addComponent(jLabel80)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(REMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addComponent(jLabel82)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RCONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addComponent(jLabel84)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RPANNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel83)
                                            .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(RAADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RCITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RDISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RDATEOFJOINING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RSTATE)))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel119)
                        .addGap(39, 39, 39)))
                .addGap(27, 27, 27)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jLabel75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RPINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RCOUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RVIEW)
                    .addComponent(RUPDATE)
                    .addComponent(RDELETE)
                    .addComponent(RSUBMIT))
                .addGap(47, 47, 47))
        );

        jLabel85.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel85.setText("RECEPTION CREATE");

        RDATE.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE.setText("DATE");

        RTIME.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RTIME.setText("TIME");

        RDATE2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE2.setText("DATE  :");

        RDATE3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE3.setText("TIME  :");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(771, 771, 771)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RDATE2)
                            .addComponent(RDATE3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RDATE)
                            .addComponent(RTIME))
                        .addGap(68, 68, 68)))
                .addComponent(SeparatorLine1))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addGap(50, 50, 50))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(RDATE)
                    .addComponent(RDATE2))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(SeparatorLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RTIME)
                            .addComponent(RDATE3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 1922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RECEPTIONIST_CREATELayout = new javax.swing.GroupLayout(RECEPTIONIST_CREATE);
        RECEPTIONIST_CREATE.setLayout(RECEPTIONIST_CREATELayout);
        RECEPTIONIST_CREATELayout.setHorizontalGroup(
            RECEPTIONIST_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1943, Short.MAX_VALUE)
            .addGroup(RECEPTIONIST_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RECEPTIONIST_CREATELayout.createSequentialGroup()
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RECEPTIONIST_CREATELayout.setVerticalGroup(
            RECEPTIONIST_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
            .addGroup(RECEPTIONIST_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RECEPTIONIST_CREATELayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", RECEPTIONIST_CREATE);

        jPanel33.setBackground(new java.awt.Color(0, 153, 153));

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        jPanel34.setBackground(new java.awt.Color(0, 153, 153));

        jLabel87.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel87.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel87.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel88.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel88.setText("SOLAPUR .  413006");
        jLabel88.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel87)
                .addContainerGap())
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88)
                .addContainerGap())
        );

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jLabel90.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel90.setText("NID");

        NID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIDActionPerformed(evt);
            }
        });
        NID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NIDKeyPressed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel91.setText("FIRST NAME");

        NFNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NFNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NFNAMEActionPerformed(evt);
            }
        });
        NFNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NFNAMEKeyTyped(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel92.setText("MIDDLE NAME");

        NMNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NMNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NMNAMEActionPerformed(evt);
            }
        });
        NMNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NMNAMEKeyTyped(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel93.setText("LAST NAME");

        NLNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NLNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NLNAMEActionPerformed(evt);
            }
        });
        NLNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NLNAMEKeyTyped(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel94.setText("AGE");

        NAGE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAGEActionPerformed(evt);
            }
        });
        NAGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NAGEKeyTyped(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel95.setText("GENDER");

        NGENDER.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NGENDER.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "MALE", "FEMALE", "OTHER" }));

        jLabel96.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel96.setText("DOB");

        jLabel97.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel97.setText("MARIATAL STATUS");

        NMSTATUS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NMSTATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));

        jLabel98.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel98.setText("USER PHOTO");

        NUSERPHOTO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NUSERPHOTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NUSERPHOTOMouseClicked(evt);
            }
        });
        NUSERPHOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUSERPHOTOActionPerformed(evt);
            }
        });
        NUSERPHOTO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NUSERPHOTOKeyTyped(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel99.setText("USERNAME");

        NUSERNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NUSERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUSERNAMEActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel100.setText(" PASSWORD");

        jLabel101.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel101.setText("CONFORM PASSWORD");

        RVIEW1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RVIEW1.setText("VIEW");
        RVIEW1.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RVIEW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RVIEW1ActionPerformed(evt);
            }
        });

        NSUBMIT.setBackground(new java.awt.Color(51, 153, 255));
        NSUBMIT.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        NSUBMIT.setText("SUBMIT");
        NSUBMIT.setMargin(new java.awt.Insets(7, 24, 7, 24));
        NSUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSUBMITActionPerformed(evt);
            }
        });

        RUPDATE1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RUPDATE1.setText("UPDATE");
        RUPDATE1.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RUPDATE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUPDATE1ActionPerformed(evt);
            }
        });

        RDELETE1.setBackground(new java.awt.Color(255, 0, 0));
        RDELETE1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RDELETE1.setText("DELETE");
        RDELETE1.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RDELETE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDELETE1ActionPerformed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel102.setText("SPECIALIZATION");

        jLabel103.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel103.setText("EDUCATION");

        NSPECIALIZATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NSPECIALIZATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSPECIALIZATIONActionPerformed(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel104.setText("JOB EXPERIENCE");

        NJOB_EXPERIENCE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NJOB_EXPERIENCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NJOB_EXPERIENCEMouseClicked(evt);
            }
        });
        NJOB_EXPERIENCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NJOB_EXPERIENCEActionPerformed(evt);
            }
        });
        NJOB_EXPERIENCE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NJOB_EXPERIENCEKeyTyped(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel105.setText("LANGUAGE KNOWN");

        NLKNOWN.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NLKNOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NLKNOWNActionPerformed(evt);
            }
        });
        NLKNOWN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NLKNOWNKeyTyped(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel106.setText("DOCUMENT");

        NDOCUMENT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NDOCUMENT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NDOCUMENTMouseClicked(evt);
            }
        });
        NDOCUMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NDOCUMENTActionPerformed(evt);
            }
        });
        NDOCUMENT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NDOCUMENTKeyTyped(evt);
            }
        });

        NEDUCATION.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NEDUCATION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEDUCATIONActionPerformed(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel107.setText("DISTRICT");

        NDISTRICT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NDISTRICT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NDISTRICTActionPerformed(evt);
            }
        });
        NDISTRICT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NDISTRICTKeyTyped(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel108.setText("COUNTRY");

        NCOUNTRY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NCOUNTRY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCOUNTRYActionPerformed(evt);
            }
        });
        NCOUNTRY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NCOUNTRYKeyTyped(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel109.setText("ZIP / PIN  CODE");

        NPINCODE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NPINCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NPINCODEActionPerformed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel110.setText("STATE");

        NSTATE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NSTATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSTATEActionPerformed(evt);
            }
        });
        NSTATE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NSTATEKeyTyped(evt);
            }
        });

        jLabel111.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel111.setText("ADDRESS");

        NADDRESS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NADDRESSActionPerformed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel112.setText("CITY");

        NCITY.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NCITY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCITYActionPerformed(evt);
            }
        });
        NCITY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NCITYKeyTyped(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel113.setText("EMAIL");

        NEMAIL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NEMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEMAILActionPerformed(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel114.setText("CONTACT 1");

        NCONTACT1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NCONTACT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCONTACT1ActionPerformed(evt);
            }
        });
        NCONTACT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NCONTACT1KeyTyped(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel115.setText("CONTACT 2");

        NCONTACT2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NCONTACT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCONTACT2ActionPerformed(evt);
            }
        });
        NCONTACT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NCONTACT2KeyTyped(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel116.setText("AADHAAR NO");

        NAADHAARNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NAADHAARNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAADHAARNOActionPerformed(evt);
            }
        });
        NAADHAARNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NAADHAARNOKeyTyped(evt);
            }
        });

        jLabel117.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel117.setText("PAN NO");

        NPANNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NPANNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NPANNOActionPerformed(evt);
            }
        });
        NPANNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NPANNOKeyTyped(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel121.setText("DATE OF JOINING");

        NDOB.setDateFormatString("yyyy-MM-dd");

        NDATEOFJOINING.setDateFormatString("yyyy-MM-dd");

        NPASSWORD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        NCPASSWORD.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addGap(45, 45, 45)
                        .addComponent(NID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NCOUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel108))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel109)
                                .addComponent(NPINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel35Layout.createSequentialGroup()
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel111)
                                .addComponent(NADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel112)
                                .addComponent(NCITY, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel107)
                                .addComponent(NDISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NSTATE, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel110))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel121)
                                .addComponent(NDATEOFJOINING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel35Layout.createSequentialGroup()
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel113)
                                .addComponent(NEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel114)
                                .addComponent(NCONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel115)
                                .addComponent(NCONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel116)
                                .addComponent(NAADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel117)
                                .addComponent(NPANNO)))
                        .addGroup(jPanel35Layout.createSequentialGroup()
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(NFNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel97)
                                .addComponent(NMSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel98)
                                .addComponent(jLabel92)
                                .addComponent(NMNAME)
                                .addComponent(NUSERPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel35Layout.createSequentialGroup()
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel93)
                                        .addComponent(NLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel94)
                                        .addComponent(NAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel95)
                                        .addComponent(NGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel35Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(NDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel96)))
                                .addGroup(jPanel35Layout.createSequentialGroup()
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel99)
                                        .addComponent(NUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel100)
                                        .addComponent(NPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel101)
                                    .addGap(121, 121, 121))))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NCPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel102)
                                    .addComponent(NSPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel103)
                                    .addComponent(NEDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel104)
                                    .addComponent(NJOB_EXPERIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel105)
                                    .addComponent(NLKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel106)
                                    .addComponent(NDOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NSUBMIT)
                .addGap(34, 34, 34)
                .addComponent(RUPDATE1)
                .addGap(29, 29, 29)
                .addComponent(RDELETE1)
                .addGap(18, 18, 18)
                .addComponent(RVIEW1)
                .addGap(80, 80, 80))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel91))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NFNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NAGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NGENDER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(NDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel99)
                                            .addComponent(jLabel101))
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(NUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(NUSERPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(NCPASSWORD))))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel100)
                                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel98)
                                                .addComponent(jLabel97)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NMSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NDOCUMENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel105)
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel104)
                                                    .addComponent(jLabel103)
                                                    .addComponent(jLabel102))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(NJOB_EXPERIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(NLKNOWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(NEDUCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(NSPECIALIZATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel114)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NCONTACT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel113)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel115)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NCONTACT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addComponent(jLabel117)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NPANNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel35Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel116)
                                            .addGroup(jPanel35Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(NAADHAARNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NCITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NDISTRICT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NSTATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NDATEOFJOINING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(jLabel108))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NPINCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NCOUNTRY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RVIEW1)
                    .addComponent(RUPDATE1)
                    .addComponent(RDELETE1)
                    .addComponent(NSUBMIT))
                .addGap(21, 21, 21))
        );

        jLabel118.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel118.setText("NURSE CREATE");

        RDATE1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE1.setText("DATE");

        RTIME1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RTIME1.setText("TIME");

        RDATE4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE4.setText("DATE");

        RTIME2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RTIME2.setText("TIME");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(50, 50, 50))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(794, 794, 794)
                        .addComponent(RDATE4))
                    .addComponent(RTIME2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RDATE1)
                    .addComponent(RTIME1))
                .addGap(70, 70, 70))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 1926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel118)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RDATE1)
                            .addComponent(RDATE4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RTIME1)
                            .addComponent(RTIME2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NURSE_CREATELayout = new javax.swing.GroupLayout(NURSE_CREATE);
        NURSE_CREATE.setLayout(NURSE_CREATELayout);
        NURSE_CREATELayout.setHorizontalGroup(
            NURSE_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NURSE_CREATELayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 1922, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NURSE_CREATELayout.setVerticalGroup(
            NURSE_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("tab4", NURSE_CREATE);

        jPanel41.setBackground(new java.awt.Color(0, 153, 153));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        jPanel42.setBackground(new java.awt.Color(0, 153, 153));

        jLabel142.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel142.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel142.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel145.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel145.setText("SOLAPUR .  413006");
        jLabel145.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel142)
                .addContainerGap())
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel145)
                .addContainerGap())
        );

        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jLabel147.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel147.setText("WARD ID");

        WID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        WID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WIDActionPerformed(evt);
            }
        });
        WID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                WIDKeyPressed(evt);
            }
        });

        NSUBMIT1.setBackground(new java.awt.Color(51, 153, 255));
        NSUBMIT1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        NSUBMIT1.setText("SUBMIT");
        NSUBMIT1.setMargin(new java.awt.Insets(7, 24, 7, 24));
        NSUBMIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NSUBMIT1ActionPerformed(evt);
            }
        });

        RUPDATE2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RUPDATE2.setText("UPDATE");
        RUPDATE2.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RUPDATE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUPDATE2ActionPerformed(evt);
            }
        });

        RDELETE2.setBackground(new java.awt.Color(255, 0, 0));
        RDELETE2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RDELETE2.setText("DELETE");
        RDELETE2.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RDELETE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDELETE2ActionPerformed(evt);
            }
        });

        jLabel148.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel148.setText("WARD NAME");

        WARD.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        WARD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WARDActionPerformed(evt);
            }
        });
        WARD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                WARDKeyPressed(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel149.setText("WARD CHARGES PER DAY");

        CHARGES.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CHARGES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHARGESActionPerformed(evt);
            }
        });
        CHARGES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CHARGESKeyPressed(evt);
            }
        });

        jScrollPane6.setViewportView(WARDSTABLE);

        ERRORLABLE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ERRORLABLE.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel148)
                            .addComponent(jLabel149))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CHARGES, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WARD, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel147)
                                .addGap(180, 180, 180)
                                .addComponent(WID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ERRORLABLE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(NSUBMIT1)
                .addGap(40, 40, 40)
                .addComponent(RUPDATE2)
                .addGap(27, 27, 27)
                .addComponent(RDELETE2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WARD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CHARGES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(ERRORLABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NSUBMIT1)
                    .addComponent(RUPDATE2)
                    .addComponent(RDELETE2))
                .addGap(89, 89, 89))
        );

        jLabel176.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel176.setText(" HOSPITAL MAINTANCE");

        RDATE5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE5.setText("DATE");

        RTIME3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RTIME3.setText("TIME");

        RDATE6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RDATE6.setText("DATE");

        RTIME4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        RTIME4.setText("TIME");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel146)
                .addGap(50, 50, 50))
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(703, 703, 703)
                        .addComponent(RDATE6))
                    .addComponent(RTIME4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RDATE5)
                    .addComponent(RTIME3))
                .addGap(70, 70, 70))
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel176)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RDATE5)
                            .addComponent(RDATE6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RTIME3)
                            .addComponent(RTIME4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout WARD_CREATELayout = new javax.swing.GroupLayout(WARD_CREATE);
        WARD_CREATE.setLayout(WARD_CREATELayout);
        WARD_CREATELayout.setHorizontalGroup(
            WARD_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WARD_CREATELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        WARD_CREATELayout.setVerticalGroup(
            WARD_CREATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WARD_CREATELayout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", WARD_CREATE);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab7", jPanel7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel6);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1469, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 524, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 123, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab8", jPanel8);

        jPanel36.setBackground(new java.awt.Color(0, 153, 153));
        jPanel36.setPreferredSize(new java.awt.Dimension(1939, 800));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_1.png"))); // NOI18N

        jPanel37.setBackground(new java.awt.Color(0, 153, 153));

        jLabel126.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel126.setText("VHS MULTI-SPECIALITY HOSPITAL ,");
        jLabel126.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel127.setFont(new java.awt.Font("Imprint MT Shadow", 3, 48)); // NOI18N
        jLabel127.setText("SOLAPUR .  413006");
        jLabel127.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel126)
                .addContainerGap())
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel126)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel127)
                .addContainerGap())
        );

        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo_2.png"))); // NOI18N

        jPanel38.setPreferredSize(new java.awt.Dimension(1939, 500));

        jLabel129.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel129.setText("PID");

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

        RSUBMIT2.setBackground(new java.awt.Color(51, 153, 255));
        RSUBMIT2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        RSUBMIT2.setText("DISCHARGE");
        RSUBMIT2.setMargin(new java.awt.Insets(7, 24, 7, 24));
        RSUBMIT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSUBMIT2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel17.setText("ADMIT DATE");

        OTAMOUNT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        OTAMOUNT.setText("0");
        OTAMOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTAMOUNTActionPerformed(evt);
            }
        });

        FULLNAME.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        FULLNAME.setText("FULL NAME");

        jLabel19.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel19.setText("DISCHARGE DATE");

        jLabel131.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel131.setText("NO OF DAYS TO STAY");

        NOOFDAAYS.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        NOOFDAAYS.setText("NO OF DAYS ADMIT");

        WARDNAME.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        WARDNAME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICU", "IPD", "MRI", "MICU", "NICU", "OPD", "NICU", "OT", "HCU", "ICCU" }));

        jLabel133.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel133.setText("WARD NAME");

        jLabel134.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel134.setText("OPERATION AMOUNT");

        jLabel135.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel135.setText("BED AMOUNT");

        jLabel136.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel136.setText("PATIENT  STATUS");

        PATIENT_STATUS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PATIENT_STATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIVE", "DEATH" }));
        PATIENT_STATUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PATIENT_STATUSActionPerformed(evt);
            }
        });

        jLabel137.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel137.setText("WARD CHARGES");

        jLabel138.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel138.setText("EXTRA AMOUNT");

        EXTRA_AMOUNT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        EXTRA_AMOUNT.setText("0");
        EXTRA_AMOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXTRA_AMOUNTActionPerformed(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel140.setText("FULL NAME");

        jLabel139.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel139.setText("DR NAME");

        DRNAME.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        DRNAME.setText("DR NAME");

        jLabel130.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel130.setText("TREATMENT");

        TREATMENT.setColumns(20);
        TREATMENT.setRows(5);
        jScrollPane2.setViewportView(TREATMENT);

        MEDICINES.setColumns(20);
        MEDICINES.setRows(5);
        jScrollPane3.setViewportView(MEDICINES);

        jLabel143.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel143.setText("MEDICINES");

        jLabel144.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel144.setText("NEXT VISIT");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(849, 849, 849)
                .addComponent(jLabel129)
                .addGap(18, 18, 18)
                .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(817, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel140)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel131)
                            .addComponent(jLabel139)
                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel136)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel137, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NOOFDAAYS, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WARDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PATIENT_STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OTAMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(RSUBMIT2)
                                .addComponent(EXTRA_AMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(DRNAME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel130)
                    .addComponent(jLabel143)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(FULLNAME))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel140)))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NOOFDAAYS)
                            .addComponent(jLabel131))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRNAME)
                            .addComponent(jLabel139))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WARDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel133))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel135)
                            .addComponent(jLabel137))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel134)
                            .addComponent(OTAMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(EXTRA_AMOUNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(PATIENT_STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel144)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(RSUBMIT2)
                .addGap(36, 36, 36))
        );

        DDATE.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        DDATE.setText("DATE");

        DTIME.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        DTIME.setText("TIME");

        jLabel141.setFont(new java.awt.Font("Imprint MT Shadow", 3, 18)); // NOI18N
        jLabel141.setText("DISCHARGE PATIENTS");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel128)
                .addGap(50, 50, 50))
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(853, 853, 853)
                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DDATE)
                    .addComponent(DTIME))
                .addGap(91, 91, 91))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(DTIME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DDATE))
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DISCHARGE_FORMLayout = new javax.swing.GroupLayout(DISCHARGE_FORM);
        DISCHARGE_FORM.setLayout(DISCHARGE_FORMLayout);
        DISCHARGE_FORMLayout.setHorizontalGroup(
            DISCHARGE_FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DISCHARGE_FORMLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 1922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        DISCHARGE_FORMLayout.setVerticalGroup(
            DISCHARGE_FORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DISCHARGE_FORMLayout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", DISCHARGE_FORM);

        DOCTORS_LIST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR", "ID", "FNAME ", "MNAME ", "LNAME ", "AGE ", "GENDER ", "DOB ", "MSTATUS ", "UPHOTO ", "USERNAME", "PASSWORD ", "SPECIALIZATION ", "EDUCATION ", "FEE ", "OPDNO ", "JOBEXP ", "DATEOFJOIN ", "LKNOWN ", "DOCUMENT", "EMAILS", "CONTACT1", "CONTACT1", "ECONTACT", "AADHARNO", "PAN NO", "ADDRESS", "CITY", "DISTRICT", "STATE", "COUNTRY", "PIN", "DATE", "TIME"
            }
        ));
        DOCTORS_LIST.setShowHorizontalLines(false);
        jScrollPane8.setViewportView(DOCTORS_LIST);

        PATIENTS1.setFont(new java.awt.Font("Imprint MT Shadow", 3, 18)); // NOI18N
        PATIENTS1.setText("DOCTORS   DETAILS");

        search1.setText("FIND DOCTORS");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(search1)
                .addGap(385, 385, 385)
                .addComponent(PATIENTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1942, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PATIENTS1)
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search1))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jScrollPane5.setViewportView(jPanel47);

        javax.swing.GroupLayout DOCTORLISTLayout = new javax.swing.GroupLayout(DOCTORLIST);
        DOCTORLIST.setLayout(DOCTORLISTLayout);
        DOCTORLISTLayout.setHorizontalGroup(
            DOCTORLISTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOCTORLISTLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DOCTORLISTLayout.setVerticalGroup(
            DOCTORLISTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOCTORLISTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab10", DOCTORLIST);

        NURSE_LIST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR", "ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "GENDER", "DOB", "MSTATUS", "USERPHOTO", "USERNAME", "PASSWORD", "SPECIALIZATION", "EDUCATION", "JOB EXPERIENCE", "DATE OF JOINING", "L KNOWN", "DOCUMENT", "EMAIL", "CONTACT1", "CONTACT2", "AADHAAR NO", "PAN NO", "ADDRESS", "CITY", "DISTRICT", "STATE", "COUNTRY", "PIN CODE", "DATE", "TIME"
            }
        ));
        jScrollPane4.setViewportView(NURSE_LIST);

        txt_search2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        search2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        search2.setText("Search Patients");
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 3, 18)); // NOI18N
        jLabel2.setText("NURSE LIST");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(search2)
                .addGap(386, 386, 386)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 96, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NURSEEELayout = new javax.swing.GroupLayout(NURSEEE);
        NURSEEE.setLayout(NURSEEELayout);
        NURSEEELayout.setHorizontalGroup(
            NURSEEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NURSEEELayout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        NURSEEELayout.setVerticalGroup(
            NURSEEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NURSEEELayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab11", NURSEEE);

        RECEPTIONIST_LIST.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR", "ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "GENDER", "DOB", "MSTATUS", "USER PHOTO", "USERNAME", "PASSWORD", "SPECIALIZATION", "EDUCATION", "JOB EXPERIENCE", "DATE OF JOIN", "L KNOWN", "DOCUMENT", "EMAIL", "CONTACT1", "CONTACT2", "ADDHAAR NO", "PAN NO", "ADDRESS", "CITY", "DISTRICT", "STATE", "COUNTRY", "PIN CODE", "DATE", "TIME"
            }
        ));
        jScrollPane7.setViewportView(RECEPTIONIST_LIST);

        txt_search3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        search3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        search3.setText("Search Patients");
        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Imprint MT Shadow", 3, 18)); // NOI18N
        jLabel14.setText("RECEPTIONISTS    LIST");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(search3)
                .addGap(386, 386, 386)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 2132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search3)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout RECEPTIONISTDARALayout = new javax.swing.GroupLayout(RECEPTIONISTDARA);
        RECEPTIONISTDARA.setLayout(RECEPTIONISTDARALayout);
        RECEPTIONISTDARALayout.setHorizontalGroup(
            RECEPTIONISTDARALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RECEPTIONISTDARALayout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RECEPTIONISTDARALayout.setVerticalGroup(
            RECEPTIONISTDARALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RECEPTIONISTDARALayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab12", RECEPTIONISTDARA);

        txt_search4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        search4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        search4.setText("Search Patients");
        search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search4ActionPerformed(evt);
            }
        });

        PATIENTS_DATA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR", "PID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "AGE", "GENDER", "DATE OF BIRTH", "MSTATUS", "CONTACT1", "CONTACT2", "AADHAAR NO", "PAN NO", "DR NAME", "OPD NO", "FEE", "SYSMPTOMS", "ADDRESS", "CITY", "DISTRICT", "STATE", "COUNTRY", "PINCODE", "DATE", "TIME"
            }
        ));
        PATIENTS_DATA.setGridColor(new java.awt.Color(145, 178, 224));
        jScrollPane9.setViewportView(PATIENTS_DATA);

        PATIENTS.setFont(new java.awt.Font("Imprint MT Shadow", 3, 18)); // NOI18N
        PATIENTS.setText("PATIENTS    DETAILS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search4)
                        .addGap(405, 405, 405)
                        .addComponent(PATIENTS, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search4)
                        .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PATIENTS, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PATIENTSDLayout = new javax.swing.GroupLayout(PATIENTSD);
        PATIENTSD.setLayout(PATIENTSDLayout);
        PATIENTSDLayout.setHorizontalGroup(
            PATIENTSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PATIENTSDLayout.setVerticalGroup(
            PATIENTSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PATIENTSDLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab13", PATIENTSD);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab14", jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab15", jPanel16);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab16", jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2045, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab17", jPanel18);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 2050, 1070));

        jMenu5.setText("DASH BOARD");
        jMenu5.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu5.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu5MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setText("MASTER");
        jMenu6.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu1.setText("CREATE USERS");
        jMenu1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(5, 10, 5, 10));

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem2.setText("DOCTORS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem1.setText("RECEPTIONIST");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jMenuItem3.setText("NURCE");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("VIEW USRES LIST");
        jMenu2.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(5, 10, 5, 10));

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem4.setText("DOCTORS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem6.setText("RECPTIONIST");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jMenuItem7.setText("NURSE");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("VIEW PATIENTS DETAILS");
        jMenu3.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(5, 10, 5, 10));

        jMenuItem8.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem8.setText("PATIENTS");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem9.setText("ADMIT PATIENTS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem11.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jMenuItem11.setText("DEATH PATIENTS");
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("LOG OUT");
        jMenu4.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    jTabbedPane1.setSelectedIndex(1);
  }//GEN-LAST:event_jMenuItem2ActionPerformed

  private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
    jTabbedPane1.setSelectedIndex(0);
  }//GEN-LAST:event_jMenu5ActionPerformed

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    jTabbedPane1.setSelectedIndex(2);
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void DIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_DIDActionPerformed

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

  private void USERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_USERNAMEActionPerformed

  private void VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEWActionPerformed
    jTabbedPane1.setSelectedIndex(9);
  }//GEN-LAST:event_VIEWActionPerformed

  private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
    getData();
    if(status){
    String query =
      "INSERT INTO VHSHOSPITAL.DOCTORS ( ID,FNAME,MNAME,LNAME,AGE,GENDER,DOB,MSTATUS,UPHOTO,USERNAME,PASSWORD,SPECIALIZATION,EDUCATION,FEE,OPDNO,JOBEXP,DATEOFJOIN,LKNOWN,DOCUMENT,EMAIL,CONTACT1,CONTACT2,ECONTACT,AADHAAR,PAN,ADDRESS,CITY,DISTRICT,STATE,COUNTRY,PIN,DATE,TIME)VALUES(" + Did + ",'" + Fname + "'," + "'" + Mname + "'," + "'" + Lname + "'," + "" + Age + "," + "'" + Gender + "'," + "'" + Dob + "'," + "'" + Mstatus + "'," + "'" + photo + "'," + "'DR_" + Userid + "'," + "'" + Password + "'," + "'" + Specilization + "'," + "'" + Education + "'," + Fee + "," + Opd + "," + "'" + Jobexperience + "'," + "'" + DateJoin + "'," + "'" + Lknown + "'," + "'" + Document + "'," + "'" + Email + "'," + "" + Contact1 + "," + "" + Contact2 + "," + "" + EContact + "," + Aadhaarno + "," + "'" + Panno + "'," + "'" + Address + "'," + "'" + City + "'," + "'" + District + "'," + "'" + State + "'," + "'" + Country + "'," + Pincode + "," + "'" + Date + "'," + "'" + Time + "'" + ")";
    try {
      try {
        statement.execute(query);
      } catch (Exception e) {
        if (e.getMessage().contains("Duplicate")) {
          ERR.setText("Dublicate Record..!");
          System.out.println(e);
          return;
        }
      }
      ERR.setText("  ");
      String DbName = "doc" + "_" + DID.getText();
      System.out.println(DbName);
      String databaseCreate = "CREATE DATABASE IF NOT EXISTS " + DbName;
      String admit =
        "CREATE TABLE IF NOT EXISTS " +
        DbName +
        ".ADMIT(" +
        "SR INT NULL AUTO_INCREMENT PRIMARY KEY," +
        "PID INT NOT NULL UNIQUE," +
        "FNAME VARCHAR(100) NOT NULL ," +
        "MNAME VARCHAR(100) NOT NULL ," +
        "LNAME VARCHAR(100) NOT NULL ," +
        "AGE INT NOT NULL ," +
        "GENDER VARCHAR(50) NOT NULL ," +
        "DRNAME VARCHAR(200) NOT NULL," +
        "WARDNAME VARCHAR(200) NOT NULL," +
        "BEDNO INT NOT NULL ," +
        "DATEOFADMIT VARCHAR(20) NOT NULL," +
        "CFULLNAME  VARCHAR(200) NOT NULL," +
        "CAGE INT NOT NULL ," +
        "CGENDER VARCHAR(50) NOT NULL ," +
        "CCONTACT BIGINT NOT NULL," +
        "CRELATIONTOPATIENT  VARCHAR(200) NOT NULL," +
        "CAADHAARNO BIGINT NOT NULL UNIQUE," +
        "CADDRESS  VARCHAR(200) NOT NULL," +
        "DATE  VARCHAR(50) NOT NULL," +
        "TIME  VARCHAR(50) NOT NULL" +
        ")";
      String nonAdmit =
        "CREATE TABLE IF NOT EXISTS " +
        DbName +
        ".NONADMIT(" +
        "SR INT NULL AUTO_INCREMENT PRIMARY KEY," +
        "PID INT NOT NULL UNIQUE," +
        "FNAME VARCHAR(100) NOT NULL ," +
        "MNAME VARCHAR(100) NOT NULL ," +
        "LNAME VARCHAR(100) NOT NULL ," +
        "AGE INT NOT NULL ," +
        "GENDER VARCHAR(50) NOT NULL ," +
        "SYMPTOMS VARCHAR(255) NOT NULL," +
        "DRNAME VARCHAR(200) NOT NULL," +
        "MEDICINES VARCHAR(255) NOT NULL," +
        "TREATMENT VARCHAR(255) NOT NULL," +
        "REPORTS VARCHAR(255) NOT NULL," +
        "DATE  VARCHAR(50) NOT NULL," +
        "TIME  VARCHAR(50) NOT NULL" +
        ")";
      String discharge =
        "CREATE TABLE IF NOT EXISTS " +
        DbName +
        ".DISCHARGE(" +
        "SR INT PRIMARY KEY AUTO_INCREMENT ," +
        "PID  BIGINT NOT NULL UNIQUE, " +
        "NAME VARCHAR(255)  NOT NULL , " +
        "ADMITDATE VARCHAR(50) NOT NULL , " +
        "DISCHARGEDATE VARCHAR(50) NOT NULL , " +
        "NODAYS INT NOT NULL  , " +
        "DRNAME VARCHAR(255)  NOT NULL , " +
        "WARDNAME VARCHAR(255)  NOT NULL , " +
        "WARDCHARGES INT NOT NULL  , " +
        "OPERATIOINAMT INT NOT NULL  ,   " +
        "EXTRAAMT INT NOT NULL  , " +
        "PATIENTSTATUS VARCHAR(255)  NOT NULL , " +
        "PRESCRIPTION  VARCHAR(255)  NOT NULL , " +
        "MEDICINES  VARCHAR(255)  NOT NULL , " +
        "NEXTVISIT  VARCHAR(255)  NOT NULL , " +
        "DATE VARCHAR(255)  NOT NULL , " +
        "TIME VARCHAR(255)  NOT NULL" +
        " );";
      System.out.println(discharge);
      statement.execute(databaseCreate);
      statement.execute(admit);
      statement.execute(nonAdmit);
      statement.execute(discharge);
    } catch (Exception e) {
      System.out.println(e);
    }

    clearFields();
    getAllUsers();
    }else{
        
    }
  }//GEN-LAST:event_SUBMITActionPerformed

  private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
    getData();
    String query = "UPDATE VHSHOSPITAL.DOCTORS SET " + "FNAME=" + "'" + Fname + "'," + "MNAME=" + "'" + Mname + "'," + "LNAME=" + "'" + Lname + "'," + "AGE=" + Age + "," + "GENDER=" + "'" + Gender + "'," + "DOB=" + "'" + Dob + "'," + "MSTATUS=" + "'" + Mstatus + "'," + "CONTACT1=" + Contact1 + "," + "CONTACT2=" + Contact2 + "," + "ECONTACT=" + EContact + "," + "AADHAAR=" + Aadhaarno + "," + "PAN=" + "'" + Panno + "'," + "FEE=" + Fee + "," + "OPDNO=" + Opd + "," + "ADDRESS=" + "'" + Address + "'," + "UPHOTO=" + "'" + photo + "'," + "USERNAME=" + "'" + Userid + "'," + "PASSWORD=" + "'" + Password + "'," + "CITY=" + "'" + City + "'," + "DISTRICT=" + "'" + District + "'," + "STATE=" + "'" + State + "'," + "COUNTRY=" + "'" + Country + "'," + "PIN=" + Pincode + ",EDUCATION=" + "'" + Education + "'," + "DATEOFJOIN=" + "'" + DateJoin + "'," + "JOBEXP=" + "'" + Jobexperience + "'" + " WHERE ID=" + Did;
    System.out.println(query);

    try {
      statement.execute(query);
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_UPDATEActionPerformed

  private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
    try {
      statement.execute(
        "DELETE FROM  VHSHOSPITAL.DOCTORS WHERE ID=" + DID.getText()
      );
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_DELETEActionPerformed

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    jTabbedPane1.setSelectedIndex(9);
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void jMenu5MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu5MenuKeyPressed
    jTabbedPane1.setSelectedIndex(0);
  }//GEN-LAST:event_jMenu5MenuKeyPressed

  private void SPECIALIZATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPECIALIZATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_SPECIALIZATIONActionPerformed

  private void JOB_EXPERIENCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOB_EXPERIENCEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_JOB_EXPERIENCEActionPerformed

  private void LKNOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LKNOWNActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_LKNOWNActionPerformed

  private void DOCUMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOCUMENTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_DOCUMENTActionPerformed

  private void EDUCATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDUCATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_EDUCATIONActionPerformed

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

  private void ADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDRESSActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ADDRESSActionPerformed

  private void CITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CITYActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_CITYActionPerformed

  private void USERPHOTOActionPerformed(java.awt.event.ActionEvent evt) {}                                                                                     

  private void USERPHOTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERPHOTOMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      
      String DbName = "doc" + "_" + DID.getText();
      String newPath = "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/DR_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());  
      USERPHOTO.setText(newPath+DbName+"."+extension); 
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_USERPHOTOMouseClicked

  private void JOB_EXPERIENCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JOB_EXPERIENCEMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath(); 
      String DbName = "doc" + "_" + DID.getText();
      String newPath =
        "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/DR_EXPERIENCE_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath()); 
      JOB_EXPERIENCE.setText(newPath + DbName + "." + extension);
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_JOB_EXPERIENCEMouseClicked

  private void EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMAILActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_EMAILActionPerformed

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

  private void DOCUMENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCUMENTMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      DOCUMENT.setText(filename);
      String DbName = "doc" + "_" + DID.getText();
      String newPath = "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/DR_DOCUMENT/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_DOCUMENTMouseClicked

  private void RIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RIDActionPerformed

  private void RFNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RFNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RFNAMEActionPerformed

  private void RMNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RMNAMEActionPerformed

  private void RLNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RLNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RLNAMEActionPerformed

  private void RAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAGEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RAGEActionPerformed

  private void RUSERPHOTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUSERPHOTOMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      RUSERPHOTO.setText(filename);
      String DbName = "Rec" + "_" + RID.getText();
      String newPath = "C://VHS_MULTISPECILITY_HOSPITAL/RECPTIONIST/RES_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_RUSERPHOTOMouseClicked

  private void RUSERPHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUSERPHOTOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RUSERPHOTOActionPerformed

  private void RUSERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUSERNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RUSERNAMEActionPerformed

  private void RVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RVIEWActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RVIEWActionPerformed

  private void RSUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSUBMITActionPerformed
    getData2();
    String query =
      "INSERT INTO VHSHOSPITAL.RECEPTIONISTS (ID,FNAME,MNAME,LNAME,AGE,GENDER,DOB,MSTATUS,UPHOTO,USERNAME,PASSWORD,SPECIALIZATION,EDUCATION,JOBEXP,DATEOFJOIN,LKNOWN,DOCUMENT,EMAIL,CONTACT1,CONTACT2,AADHAAR,PAN,ADDRESS,CITY,DISTRICT,STATE,COUNTRY,PIN,DATE,TIME)VALUES(" + Rid + ",'" + Fname + "','" + Mname + "','" + Lname + "','" + Age + "','" + Gender + "','" + Dob + "','" + Mstatus + "','" + Userphoto + "','REC_" + Username + "','" + Password + "','" + Specialization + "','" + Education + "','" + Jobexperience + "','" + Dateofjoin + "','" + Lknown + "','" + Document + "','" + Email + "'," + Contact1 + "," + Contact2 + "," + Aadhaarno + "," + Panno + ",'" + Address + "','" + City + "','" + District + "','" + State + "','" + Country + "'," + Pincode + ",'" + Date + "','" + Time + "')";
System.out.println(query);
    try {
      statement.execute(query);
    } catch (Exception e) {
      System.out.println(e);
    }

    clearFields();
    getAllUsers();
  }//GEN-LAST:event_RSUBMITActionPerformed

  private void RUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUPDATEActionPerformed
    getData2();
    String query = "UPDATE VHSHOSPITAL.RECEPTIONISTS SET " + "FNAME=" + "'" + Fname + "'," + "MNAME=" + "'" + Mname + "'," + "LNAME=" + "'" + Lname + "'," + "AGE=" + Age + "," + "GENDER=" + "'" + Gender + "'," + "DOB=" + "'" + Dob + "'," + "MSTATUS=" + "'" + Mstatus + "'," + "CONTACT1=" + Contact1 + "," + "CONTACT2=" + Contact2 + "," + "AADHAAR=" + Aadhaarno + "," + "PAN=" + "'" + Panno + "'," + "FEE=" + Fee + "," + "OPDNO=" + Opd + "," + "ADDRESS=" + "'" + Address + "'," + "UPHOTO=" + "'" + photo + "'," + "USERNAME=" + "'" + Userid + "'," + "PASSWORD=" + "'" + Password + "'," + "CITY=" + "'" + City + "'," + "DISTRICT=" + "'" + District + "'," + "STATE=" + "'" + State + "'," + "COUNTRY=" + "'" + Country + "'," + "PIN=" + Pincode + ",EDUCATION=" + "'" + Education + "'," + "DATEOFJOIN=" + "'" + DateJoin + "'," + "JOBEXP=" + "'" + Jobexperience + "'" + " WHERE ID=" + Did;
    System.out.println(query);

    try {
      statement.execute(query);
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_RUPDATEActionPerformed

  private void RDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDELETEActionPerformed
    try {
      statement.execute(
        "DELETE FROM  VHSHOSPITAL.RECEPTIONISTS WHERE ID=" + RID.getText()
      );
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_RDELETEActionPerformed

  private void RSPECIALIZATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSPECIALIZATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RSPECIALIZATIONActionPerformed

  private void RJOB_EXPERIENCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RJOB_EXPERIENCEMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      RJOB_EXPERIENCE.setText(filename);
      String DbName = "Rec" + "_" + RID.getText();
      String newPath =
        "C://VHS_MULTISPECILITY_HOSPITAL/RECPTIONIST/RES_EXPERIENCE/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_RJOB_EXPERIENCEMouseClicked

  private void RJOB_EXPERIENCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RJOB_EXPERIENCEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RJOB_EXPERIENCEActionPerformed

  private void RLKNOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RLKNOWNActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RLKNOWNActionPerformed

  private void RDOCUMENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RDOCUMENTMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath(); 
      String DbName = "Rec" + "_" + RID.getText();
      String newPath =
        "C://VHS_MULTISPECILITY_HOSPITAL/RECPTIONIST/RES_DOCUMENT/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      RDOCUMENT.setText(newPath + DbName + "." + extension);
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_RDOCUMENTMouseClicked

  private void RDOCUMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDOCUMENTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RDOCUMENTActionPerformed

  private void REDUCATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REDUCATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_REDUCATIONActionPerformed

  private void RDISTRICTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDISTRICTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RDISTRICTActionPerformed

  private void RCOUNTRYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCOUNTRYActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RCOUNTRYActionPerformed

  private void RPINCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPINCODEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RPINCODEActionPerformed

  private void RSTATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSTATEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RSTATEActionPerformed

  private void RADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RADDRESSActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RADDRESSActionPerformed

  private void RCITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCITYActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RCITYActionPerformed

  private void REMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REMAILActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_REMAILActionPerformed

  private void RCONTACT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCONTACT1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RCONTACT1ActionPerformed

  private void RCONTACT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCONTACT2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RCONTACT2ActionPerformed

  private void RAADHAARNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAADHAARNOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RAADHAARNOActionPerformed

  private void RPANNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPANNOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RPANNOActionPerformed

  private void OPD_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPD_NOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_OPD_NOActionPerformed

  private void FEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_FEEActionPerformed

  private void EMERGANCY_CONTACTActionPerformed(
    java.awt.event.ActionEvent evt
  ) {//GEN-FIRST:event_EMERGANCY_CONTACTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_EMERGANCY_CONTACTActionPerformed

  private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
    this.dispose();
    LOGIN_FORM log = new LOGIN_FORM();
    log.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jMenu4MouseClicked

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    jTabbedPane1.setSelectedIndex(3);
  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    jTabbedPane1.setSelectedIndex(10);
  }//GEN-LAST:event_jMenuItem7ActionPerformed

  private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
    jTabbedPane1.setSelectedIndex(0);
  }//GEN-LAST:event_jMenu5MouseClicked

  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    jTabbedPane1.setSelectedIndex(11);
  }//GEN-LAST:event_jMenuItem6ActionPerformed

  private void NIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NIDActionPerformed

  private void NFNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NFNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NFNAMEActionPerformed

  private void NMNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NMNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NMNAMEActionPerformed

  private void NLNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NLNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NLNAMEActionPerformed

  private void NAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAGEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NAGEActionPerformed

  private void NUSERPHOTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NUSERPHOTOMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      NUSERPHOTO.setText(filename);
      String DbName = "nur" + "_" + NID.getText();
      String newPath = "C://VHS_MULTISPECILITY_HOSPITAL/NURCES/NU_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_NUSERPHOTOMouseClicked

  private void NUSERPHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUSERPHOTOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NUSERPHOTOActionPerformed

  private void NUSERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUSERNAMEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NUSERNAMEActionPerformed

  private void RVIEW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RVIEW1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RVIEW1ActionPerformed

  private void NSUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSUBMITActionPerformed
    // TODO add your handling code here:

    try {
      getData3();
      String query = "INSERT INTO VHSHOSPITAL.NURSES (ID,FNAME,MNAME,LNAME,AGE,GENDER,DOB,MSTATUS,UPHOTO,USERNAME,PASSWORD,SPECIALIZATION,EDUCATION,JOBEXP,DATEOFJOIN,LKNOWN,DOCUMENT,EMAIL,CONTACT1,CONTACT2,AADHAAR,PAN,ADDRESS,CITY,DISTRICT,STATE,COUNTRY,PIN,DATE,TIME)VALUES(" + Rid + ",'" + Fname + "','" + Mname + "','" + Lname + "','" + Age + "','" + Gender + "','" + Dob + "','" + Mstatus + "','" + Userphoto + "','NU_" + Username + "','" + Password + "','" + Specialization + "','" + Education + "','" + Jobexperience + "','" + Dateofjoin + "','" + Lknown + "','" + Document + "','" + Email + "'," + Contact1 + "," + Contact2 + "," + Aadhaarno + "," + Panno + "," + Address + "," + City + "," + District + "," + State + "," + Country + "," + Pincode + ",'" + Date + "','" + Time + "')";
      System.out.println(query);
      statement.execute(query);
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_NSUBMITActionPerformed

  private void RUPDATE1ActionPerformed(java.awt.event.ActionEvent evt) {}                                                                                   

  private void RDELETE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDELETE1ActionPerformed
    try {
      statement.execute(
        "DELETE FROM  VHSHOSPITAL.NURSES WHERE ID=" + NID.getText()
      );
      clearFields();
      getAllUsers();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_RDELETE1ActionPerformed

  private void NSPECIALIZATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSPECIALIZATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NSPECIALIZATIONActionPerformed

  private void NJOB_EXPERIENCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NJOB_EXPERIENCEMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      NJOB_EXPERIENCE.setText(filename);
      String DbName = "nur" + "_" + NID.getText();
      String newPath =
        "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/NURCES_EXPERIENCE_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_NJOB_EXPERIENCEMouseClicked

  private void NJOB_EXPERIENCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NJOB_EXPERIENCEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NJOB_EXPERIENCEActionPerformed

  private void NLKNOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NLKNOWNActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NLKNOWNActionPerformed

  private void NDOCUMENTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NDOCUMENTMouseClicked
    try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      String filename = f.getAbsolutePath();
      NDOCUMENT.setText(filename);
      String DbName = "nur" + "_" + NID.getText();
      String newPath =
        "C://VHS_MULTISPECILITY_HOSPITAL/DOCTORS/NURCES_EXPERIENCE_PHOTO/";
      File directionary = new File(newPath);
      if (!directionary.exists()) {
        directionary.mkdirs();
      }
      File sourcsfile = null;
      File destinationFile = null;
      String extension = filename.substring(filename.lastIndexOf('.') + 1);
      sourcsfile = new File(filename);
      destinationFile = new File(newPath + DbName + "." + extension);
      Files.copy(sourcsfile.toPath(), destinationFile.toPath());
      System.out.println(sourcsfile.toPath());
    } catch (Exception e) {}
  }//GEN-LAST:event_NDOCUMENTMouseClicked

  private void NDOCUMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NDOCUMENTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NDOCUMENTActionPerformed

  private void NEDUCATIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEDUCATIONActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NEDUCATIONActionPerformed

  private void NDISTRICTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NDISTRICTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NDISTRICTActionPerformed

  private void NCOUNTRYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCOUNTRYActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NCOUNTRYActionPerformed

  private void NPINCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NPINCODEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NPINCODEActionPerformed

  private void NSTATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSTATEActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NSTATEActionPerformed

  private void NADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NADDRESSActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NADDRESSActionPerformed

  private void NCITYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCITYActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NCITYActionPerformed

  private void NEMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEMAILActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NEMAILActionPerformed

  private void NCONTACT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCONTACT1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NCONTACT1ActionPerformed

  private void NCONTACT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCONTACT2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NCONTACT2ActionPerformed

  private void NAADHAARNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAADHAARNOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NAADHAARNOActionPerformed

  private void NPANNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NPANNOActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_NPANNOActionPerformed

  private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    jTabbedPane1.setSelectedIndex(12);
  }//GEN-LAST:event_jMenuItem8ActionPerformed

  private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
    jTabbedPane1.setSelectedIndex(4);
  }//GEN-LAST:event_jMenu6MouseClicked

  private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {}

  private void DIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DIDKeyPressed
    if (evt.getKeyCode() == 10) {
      String getQuery =
        "SELECT * FROM VHSHOSPITAL.DOCTORS WHERE ID =" + DID.getText();
      try {
        ResultSet result = statement.executeQuery(getQuery);
        while (result.next()) {
          DID.setText(result.getString("ID"));
          FNAME.setText(result.getString("FNAME"));
          MNAME.setText(result.getString("MNAME"));
          LNAME.setText(result.getString("LNAME"));
          AGE.setText(Integer.toString(result.getInt("AGE")));
          DOB.setDate(
            new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("DOB"))
          );
          CONTACT1.setText(result.getString("CONTACT1"));
          CONTACT2.setText(result.getString("CONTACT2"));
          AADHAARNO.setText(result.getString("AADHAAR"));
          PANNO.setText(result.getString("PAN"));
          FEE.setText(result.getString("FEE"));
          OPD_NO.setText(result.getString("OPDNO"));
          ADDRESS.setText(result.getString("ADDRESS"));
          CITY.setText(result.getString("CITY"));
          DISTRICT.setText(result.getString("DISTRICT"));
          STATE.setText(result.getString("STATE"));
          COUNTRY.setText(result.getString("COUNTRY"));
          EDUCATION.setText(result.getString("EDUCATION"));
          USERPHOTO.setText(result.getString("UPHOTO"));
          EMERGANCY_CONTACT.setText(result.getString("ECONTACT"));
          JOB_EXPERIENCE.setText(result.getString("JOBEXP"));
          DOCUMENT.setText(result.getString("DOCUMENT"));
          EMAIL.setText(result.getString("EMAIL"));
          SPECIALIZATION.setText(result.getString("SPECIALIZATION"));
          if (result.getString("MSTATUS").equals("YES")) {
            MSTATUS.setSelectedIndex(1);
          } else {
            MSTATUS.setSelectedIndex(0);
          }
          PINCODE.setText(result.getString("PIN"));
          USERNAME.setText(result.getString("USERNAME"));
          PASSWORD.setText(result.getString("PASSWORD"));

          DATEOFJOINING.setDate(
            new SimpleDateFormat("yyyy-MM-dd")
            .parse(result.getString("DATEOFJOIN"))
          );

          LKNOWN.setText(result.getString("LKNOWN"));

          switch (result.getString("GENDER")) {
            case "SELECT":
              GENDER.setSelectedIndex(0);
              break;
            case "MALE":
              GENDER.setSelectedIndex(1);
              break;
            case "FEMALE":
              GENDER.setSelectedIndex(2);
              break;
            default:
              GENDER.setSelectedIndex(3);
          }
          CPASSWORD.setText(result.getString("USERNAME"));
        }
      } catch (Exception e) {
        clearFields();
        System.out.println(e);
      }
    }
  }//GEN-LAST:event_DIDKeyPressed

  private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
    String af = txt_search4.getText();
    search3(af);
  }//GEN-LAST:event_search4ActionPerformed


  private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {                                      
    jTabbedPane1.setSelectedIndex(9);
  }                                     

  private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
    jTabbedPane1.setSelectedIndex(10);
  }//GEN-LAST:event_jPanel22MouseClicked

  

  private void jPanel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseClicked
    jTabbedPane1.setSelectedIndex(11);
  }//GEN-LAST:event_jPanel40MouseClicked

  private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
    String af = txt_search1.getText();
    search(af);
  }//GEN-LAST:event_search1ActionPerformed

  private void DOBMouseClicked(java.awt.event.MouseEvent evt) {}                                                                   

  private void RIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RIDKeyPressed
    if (evt.getKeyCode() == 10) {
      String getQuery =
        "SELECT * FROM VHSHOSPITAL.RECEPTIONISTS WHERE ID =" + RID.getText();
      try {
        ResultSet result = statement.executeQuery(getQuery);
        while (result.next()) {
          RID.setText(result.getString("ID"));
          RFNAME.setText(result.getString("FNAME"));
          RMNAME.setText(result.getString("MNAME"));
          RLNAME.setText(result.getString("LNAME"));
          RAGE.setText(Integer.toString(result.getInt("AGE")));
          RDOB.setDate(
            new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("DOB"))
          );
          RCONTACT1.setText(result.getString("CONTACT1"));
          RCONTACT2.setText(result.getString("CONTACT2"));
          RAADHAARNO.setText(result.getString("AADHAAR"));
          RPANNO.setText(result.getString("PAN"));
          RADDRESS.setText(result.getString("ADDRESS"));
          RCITY.setText(result.getString("CITY"));
          RDISTRICT.setText(result.getString("DISTRICT"));
          RSTATE.setText(result.getString("STATE"));
          RCOUNTRY.setText(result.getString("COUNTRY"));
          REDUCATION.setText(result.getString("EDUCATION"));
          RUSERPHOTO.setText(result.getString("UPHOTO"));
          RJOB_EXPERIENCE.setText(result.getString("JOBEXP"));
          RDOCUMENT.setText(result.getString("DOCUMENT"));
          REMAIL.setText(result.getString("EMAIL"));
          RSPECIALIZATION.setText(result.getString("SPECIALIZATION"));
          if (result.getString("MSTATUS").equals("YES")) {
            RMSTATUS.setSelectedIndex(1);
          } else {
            MSTATUS.setSelectedIndex(0);
          }
          RPINCODE.setText(result.getString("PIN"));
          RUSERNAME.setText(result.getString("USERNAME"));
          RPASSWORD.setText(result.getString("PASSWORD"));

          RDATEOFJOINING.setDate(
            new SimpleDateFormat("yyyy-MM-dd")
            .parse(result.getString("DATEOFJOIN"))
          );

          RLKNOWN.setText(result.getString("LKNOWN"));

          switch (result.getString("GENDER")) {
            case "SELECT":
              RGENDER.setSelectedIndex(0);
              break;
            case "MALE":
              RGENDER.setSelectedIndex(1);
              break;
            case "FEMALE":
              RGENDER.setSelectedIndex(2);
              break;
            default:
              RGENDER.setSelectedIndex(3);
          }
          RCPASSWORD.setText(result.getString("USERNAME"));
        }
      } catch (Exception e) {
        clearFields();
        System.out.println(e);
      }
    }
  }//GEN-LAST:event_RIDKeyPressed

  private void NIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NIDKeyPressed
    if (evt.getKeyCode() == 10) {
      String getQuery =
        "SELECT * FROM VHSHOSPITAL.NURSES WHERE ID =" + NID.getText();
      try {
        ResultSet result = statement.executeQuery(getQuery);
        while (result.next()) {
          NID.setText(result.getString("ID"));
          NFNAME.setText(result.getString("FNAME"));
          NMNAME.setText(result.getString("MNAME"));
          NLNAME.setText(result.getString("LNAME"));
          NAGE.setText(Integer.toString(result.getInt("AGE")));
          NDOB.setDate(
            new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("DOB"))
          );
          NCONTACT1.setText(result.getString("CONTACT1"));
          NCONTACT2.setText(result.getString("CONTACT2"));
          NAADHAARNO.setText(result.getString("AADHAAR"));
          NPANNO.setText(result.getString("PAN"));
          NADDRESS.setText(result.getString("ADDRESS"));
          NCITY.setText(result.getString("CITY"));
          NDISTRICT.setText(result.getString("DISTRICT"));
          NSTATE.setText(result.getString("STATE"));
          NCOUNTRY.setText(result.getString("COUNTRY"));
          NEDUCATION.setText(result.getString("EDUCATION"));
          NUSERPHOTO.setText(result.getString("UPHOTO"));
          NJOB_EXPERIENCE.setText(result.getString("JOBEXP"));
          NDOCUMENT.setText(result.getString("DOCUMENT"));
          NEMAIL.setText(result.getString("EMAIL"));
          NSPECIALIZATION.setText(result.getString("SPECIALIZATION"));
          if (result.getString("MSTATUS").equals("YES")) {
            NMSTATUS.setSelectedIndex(1);
          } else {
            NMSTATUS.setSelectedIndex(0);
          }
          NPINCODE.setText(result.getString("PIN"));
          NUSERNAME.setText(result.getString("USERNAME"));
          NPASSWORD.setText(result.getString("PASSWORD"));

          NDATEOFJOINING.setDate(
            new SimpleDateFormat("yyyy-MM-dd")
            .parse(result.getString("DATEOFJOIN"))
          );

          NLKNOWN.setText(result.getString("LKNOWN"));

          switch (result.getString("GENDER")) {
            case "SELECT":
              NGENDER.setSelectedIndex(0);
              break;
            case "MALE":
              NGENDER.setSelectedIndex(1);
              break;
            case "FEMALE":
              NGENDER.setSelectedIndex(2);
              break;
            default:
              NGENDER.setSelectedIndex(3);
          }
          NCPASSWORD.setText(result.getString("USERNAME"));
        }
      } catch (Exception e) {
        clearFields();
        System.out.println(e);
      }
    }
  }//GEN-LAST:event_NIDKeyPressed

  private void DISCHARGEDATEKeyPressed(java.awt.event.KeyEvent evt) {}                                                                                   

  private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
    String af = txt_search2.getText();
    search1(af);
  }//GEN-LAST:event_search2ActionPerformed

  private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
    String af = txt_search3.getText();
    search2(af);
  }//GEN-LAST:event_search3ActionPerformed

  private void DIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DIDKeyTyped
    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
      evt.consume();
    } // TODO add your handling code here:
  }//GEN-LAST:event_DIDKeyTyped

  private void AGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGEKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = AGE.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 3) {
        AGE.setEditable(true);
      } else {
        AGE.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        AGE.setEditable(true);
      } else {
        AGE.setEditable(true);
      }
    }
  }//GEN-LAST:event_AGEKeyTyped

  private void OPD_NOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OPD_NOKeyTyped
    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
      evt.consume();
    } // TODO add your handling code here:
  }//GEN-LAST:event_OPD_NOKeyTyped

  private void FEEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FEEKeyTyped
    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
      evt.consume();
    } // TODO add your handling code here:
  }//GEN-LAST:event_FEEKeyTyped

  private void CONTACT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACT1KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = CONTACT1.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        CONTACT1.setEditable(true);
      } else {
        CONTACT1.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        CONTACT1.setEditable(true);
      } else {
        CONTACT1.setEditable(true);
      }
    }
  }//GEN-LAST:event_CONTACT1KeyTyped

  private void CONTACT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONTACT2KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = CONTACT2.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        CONTACT2.setEditable(true);
      } else {
        CONTACT2.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        CONTACT2.setEditable(true);
      } else {
        CONTACT2.setEditable(true);
      }
    }
  }//GEN-LAST:event_CONTACT2KeyTyped

  private void EXTRA_AMOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXTRA_AMOUNTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_EXTRA_AMOUNTActionPerformed

  private void PATIENT_STATUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PATIENT_STATUSActionPerformed
    if (PATIENT_STATUS.getSelectedItem().toString().equals("NO")) {
      WARD_CREATE.setVisible(true);
    } else {
      WARD_CREATE.setVisible(false);
    }
  }//GEN-LAST:event_PATIENT_STATUSActionPerformed

  private void OTAMOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OTAMOUNTActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_OTAMOUNTActionPerformed

  private void RSUBMIT2ActionPerformed(java.awt.event.ActionEvent evt) {}                                                                                   

  private void PIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PIDKeyPressed
    if (evt.getKeyCode() == 10) {
      String DOCNAME = "";
      int did = 0;
      String dateofadmit = "";
      String pid = PID.getText();
      String getQuery =
        "SELECT * FROM VHSHOSPITAL.APPOINTMENTS WHERE PID =" + pid;
      try {
        ResultSet res = statement.executeQuery(
          "SELECT DRNAME AS DRNAME FROM VHSHOSPITAL.APPOINTMENTS WHERE PID=" +
          pid
        );
        while (res.next()) {
          DOCNAME = res.getString("DRNAME");
        }
        String name[] = DOCNAME.split("DR.")[1].split(" ");
        res =
          statement.executeQuery(
            "SELECT ID AS ID FROM VHSHOSPITAL.DOCTORS WHERE FNAME='" +
            name[0] +
            "' AND MNAME='" +
            name[1] +
            "' AND LNAME='" +
            name[2] +
            "'"
          );
        while (res.next()) {
          did = Integer.parseInt(res.getString("ID"));
        }
        String dbname = "doc_" + did;

        String query =
          "SELECT DATEOFADMIT FROM " + dbname + ".ADMIT WHERE PID=" + pid;

        res = statement.executeQuery(query);
        while (res.next()) {
          dateofadmit = res.getString("DATEOFADMIT");
        }
        DOB.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateofadmit));
      } catch (Exception e) {
        System.out.println(e);
      }

      try {
        ResultSet result = statement.executeQuery(getQuery);
        while (result.next()) {
          String a = result.getString("FNAME");
          String b = result.getString("MNAME");
          String c = result.getString("LNAME");
          String fullname = a + " " + b + " " + c;
          FULLNAME.setText(fullname);
          DRNAME.setText(result.getString("DRNAME"));
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }//GEN-LAST:event_PIDKeyPressed

  private void PIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_PIDActionPerformed

  private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
    jTabbedPane1.setSelectedIndex(4);
  }//GEN-LAST:event_jMenu6ActionPerformed

  private void CHARGESKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CHARGESKeyPressed
    // TODO add your handling code here:
  }//GEN-LAST:event_CHARGESKeyPressed

  private void CHARGESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHARGESActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_CHARGESActionPerformed

  private void WARDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WARDKeyPressed
    // TODO add your handling code here:
  }//GEN-LAST:event_WARDKeyPressed

  private void WARDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WARDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_WARDActionPerformed

  private void RDELETE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDELETE2ActionPerformed
    //        Wid = Integer.parseInt(WID.getText());

    try {
      statement.execute(
        "DELETE FROM  VHSHOSPITAL.WARDS WHERE WID=" + WID.getText()
      );
      //             String query = "DELETE FROM VHSHOSPITAL.WARDS WHERE WID=" + Wid;
      //            statement.execute(query);
      clearFields();
      getAllUsers();
      getAllWards();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_RDELETE2ActionPerformed

  private void RUPDATE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUPDATE2ActionPerformed
    getwarddata();
    try {
      String query =
        " UPDATE VHSHOSPITAL.WARDS SET " +
        "WARDNAME=" +
        "'" +
        Ward +
        "'," +
        "CHARGES=" +
        Charges +
        " WHERE WID=" +
        Wid;
      System.out.println(query);
      statement.execute(query);
      clearFields();
      getAllUsers();
      getAllWards();
    } catch (Exception e) {
      System.out.println(e);
    }
  }//GEN-LAST:event_RUPDATE2ActionPerformed

  public void getAllWards() {
    String query = "SELECT * FROM VHSHOSPITAL.WARDS";
    try {
      ResultSet result = statement.executeQuery(query);
      DefaultTableModel model = null;
      model =
        new DefaultTableModel(
          new Object[] { "SR", "WID", "WARDNAME", "CHARGES" },
          0
        );
      while (result.next()) {
        model.addRow(
          new Object[] {
            result.getInt("SR"),
            result.getString("WID"),
            result.getString("WARDNAME"),
            result.getInt("CHARGES"),
          }
        );
        System.out.println(model);
      }
      WARDSTABLE.setModel(model);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void NSUBMIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NSUBMIT1ActionPerformed
    int Sr = 0;
    getwarddata();

    try {
      String query = "SELECT * FROM VHSHOSPITAL.WARDS";
      ResultSet result = statement.executeQuery(query);
      while (result.next()) {
        Sr = Integer.parseInt(result.getString("SR"));
      }
      System.out.println(Sr);
      query =
        (
          "INSERT INTO VHSHOSPITAL.WARDS (SR,WID,WARDNAME,CHARGES)VALUES(" +
          (Sr + 1) +
          "," +
          Wid +
          ",'" +
          Ward +
          "'," +
          Charges +
          ")"
        );
      statement.execute(query);
      clearFields();
      getAllUsers();
      getAllWards();
    } catch (Exception e) {
      if (e.getMessage().contains("Duplicate")) {
        ERRORLABLE.setText("Record Already Exists .. Press Update Insted");
      }
    }
  }//GEN-LAST:event_NSUBMIT1ActionPerformed

  private void WIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WIDKeyPressed
    if (evt.getKeyCode() == (10)) {
      try {
        String query =
          "SELECT * FROM VHSHOSPITAL.WARDS WHERE WID=" +
          Integer.parseInt(WID.getText());
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
          WARD.setText(result.getString("WARDNAME"));
          CHARGES.setText(result.getString("CHARGES"));
        }
      } catch (Exception e) {}
    }
  }//GEN-LAST:event_WIDKeyPressed

  private void WIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WIDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_WIDActionPerformed

  private void FNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      FNAME.setEditable(true);
    } else {
      FNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_FNAMEKeyTyped

  private void MNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      MNAME.setEditable(true);
    } else {
      MNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_MNAMEKeyTyped

  private void LNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      LNAME.setEditable(true);
    } else {
      LNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_LNAMEKeyTyped

  private void CITYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CITYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      CITY.setEditable(true);
    } else {
      CITY.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_CITYKeyTyped

  private void DISTRICTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DISTRICTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      DISTRICT.setEditable(true);
    } else {
      DISTRICT.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_DISTRICTKeyTyped

  private void STATEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STATEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      STATE.setEditable(true);
    } else {
      STATE.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_STATEKeyTyped

  private void PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSWORDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_PASSWORDActionPerformed

  private void CPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPASSWORDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_CPASSWORDActionPerformed

  private void USERPHOTOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERPHOTOMouseEntered
    USERPHOTO.setEditable(false);
  }//GEN-LAST:event_USERPHOTOMouseEntered

  private void EMERGANCY_CONTACTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EMERGANCY_CONTACTKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = EMERGANCY_CONTACT.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        EMERGANCY_CONTACT.setEditable(true);
      } else {
        EMERGANCY_CONTACT.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        EMERGANCY_CONTACT.setEditable(true);
      } else {
        EMERGANCY_CONTACT.setEditable(true);
      }
    }
  }//GEN-LAST:event_EMERGANCY_CONTACTKeyTyped

  private void AADHAARNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AADHAARNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = AADHAARNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 12) {
        AADHAARNO.setEditable(true);
      } else {
        AADHAARNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        AADHAARNO.setEditable(true);
      } else {
        AADHAARNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_AADHAARNOKeyTyped

  private void PANNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PANNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = PANNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        PANNO.setEditable(true);
      } else {
        PANNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        PANNO.setEditable(true);
      } else {
        PANNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_PANNOKeyTyped

  private void PINCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PINCODEKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = PINCODE.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 6) {
        PINCODE.setEditable(true);
      } else {
        PINCODE.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        PINCODE.setEditable(true);
      } else {
        PINCODE.setEditable(true);
      }
    }
  }//GEN-LAST:event_PINCODEKeyTyped

  private void RFNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RFNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RFNAME.setEditable(true);
    } else {
      RFNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RFNAMEKeyTyped

  private void RMNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RMNAMEKeyReleased
    // TODO add your handling code here:
  }//GEN-LAST:event_RMNAMEKeyReleased

  private void RMNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RMNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RMNAME.setEditable(true);
    } else {
      RMNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RMNAMEKeyTyped

  private void RLNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RLNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RLNAME.setEditable(true);
    } else {
      RLNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RLNAMEKeyTyped

  private void RCITYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RCITYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RCITY.setEditable(true);
    } else {
      RCITY.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RCITYKeyTyped

  private void RDISTRICTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RDISTRICTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RDISTRICT.setEditable(true);
    } else {
      RDISTRICT.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RDISTRICTKeyTyped

  private void RSTATEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RSTATEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RSTATE.setEditable(true);
    } else {
      RSTATE.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RSTATEKeyTyped

  private void RCOUNTRYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RCOUNTRYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RCOUNTRY.setEditable(true);
    } else {
      RCOUNTRY.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RCOUNTRYKeyTyped

  private void USERPHOTOMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERPHOTOMouseReleased
    // TODO add your handling code here:
  }//GEN-LAST:event_USERPHOTOMouseReleased

  private void USERPHOTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_USERPHOTOKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      USERPHOTO.setEditable(false);
    } else {
      USERPHOTO.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    } // TODO add your handling code here:
  }//GEN-LAST:event_USERPHOTOKeyTyped

  private void JOB_EXPERIENCEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JOB_EXPERIENCEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      JOB_EXPERIENCE.setEditable(false);
    } else {
      JOB_EXPERIENCE.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_JOB_EXPERIENCEKeyTyped

  private void DOCUMENTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCUMENTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      DOCUMENT.setEditable(false);
    } else {
      DOCUMENT.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    } // TODO add your handling code here:
  }//GEN-LAST:event_DOCUMENTKeyTyped

  private void LKNOWNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LKNOWNKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      LKNOWN.setEditable(true);
    } else {
      LKNOWN.setEditable(false);
    }
  }//GEN-LAST:event_LKNOWNKeyTyped

  private void COUNTRYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_COUNTRYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      COUNTRY.setEditable(true);
    } else {
      COUNTRY.setEditable(false);
    }
  }//GEN-LAST:event_COUNTRYKeyTyped

  private void RAGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RAGEKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RAGE.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 3) {
        RAGE.setEditable(true);
      } else {
        RAGE.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RAGE.setEditable(true);
      } else {
        RAGE.setEditable(true);
      }
    }
  }//GEN-LAST:event_RAGEKeyTyped

  private void RCONTACT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RCONTACT1KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RCONTACT1.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        RCONTACT1.setEditable(true);
      } else {
        RCONTACT1.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RCONTACT1.setEditable(true);
      } else {
        RCONTACT1.setEditable(true);
      }
    }
  }//GEN-LAST:event_RCONTACT1KeyTyped

  private void RCONTACT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RCONTACT2KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RCONTACT2.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        RCONTACT2.setEditable(true);
      } else {
        RCONTACT2.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RCONTACT2.setEditable(true);
      } else {
        RCONTACT2.setEditable(true);
      }
    }
  }//GEN-LAST:event_RCONTACT2KeyTyped

  private void RAADHAARNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RAADHAARNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RAADHAARNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 12) {
        RAADHAARNO.setEditable(true);
      } else {
        RAADHAARNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RAADHAARNO.setEditable(true);
      } else {
        RAADHAARNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_RAADHAARNOKeyTyped

  private void RPANNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPANNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RPANNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        RPANNO.setEditable(true);
      } else {
        RPANNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RPANNO.setEditable(true);
      } else {
        RPANNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_RPANNOKeyTyped

  private void RPINCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RPINCODEKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = RPINCODE.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 6) {
        RPINCODE.setEditable(true);
      } else {
        RPINCODE.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        RPINCODE.setEditable(true);
      } else {
        RPINCODE.setEditable(true);
      }
    }
  }//GEN-LAST:event_RPINCODEKeyTyped

  private void RADDRESSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RADDRESSKeyTyped
    // TODO add your handling code here:
  }//GEN-LAST:event_RADDRESSKeyTyped

  private void RLKNOWNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RLKNOWNKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RLKNOWN.setEditable(true);
    } else {
      RLKNOWN.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_RLKNOWNKeyTyped

  private void RUSERNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RUSERNAMEKeyTyped
   
  }//GEN-LAST:event_RUSERNAMEKeyTyped

  private void RUSERPHOTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RUSERPHOTOKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RUSERPHOTO.setEditable(false);
    } else {
      RUSERPHOTO.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_RUSERPHOTOKeyTyped

  private void RDOBKeyTyped(java.awt.event.KeyEvent evt) {}                                                             

  private void USERNAMEKeyTyped(java.awt.event.KeyEvent evt) {}                                                                     

  private void USERNAMEInputMethodTextChanged(
    java.awt.event.InputMethodEvent evt
  ) {}                                                                                                 

  private void RJOB_EXPERIENCEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RJOB_EXPERIENCEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RJOB_EXPERIENCE.setEditable(false);
    } else {
      RJOB_EXPERIENCE.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_RJOB_EXPERIENCEKeyTyped

  private void RDOCUMENTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RDOCUMENTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      RDOCUMENT.setEditable(false);
    } else {
      RDOCUMENT.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_RDOCUMENTKeyTyped

  private void RPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPASSWORDActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_RPASSWORDActionPerformed

  private void NFNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NFNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NFNAME.setEditable(true);
    } else {
      NFNAME.setEditable(false);
    } // TODO add your handling code here:
  }//GEN-LAST:event_NFNAMEKeyTyped

  private void NMNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NMNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NMNAME.setEditable(true);
    } else {
      NMNAME.setEditable(false);
    }
  }//GEN-LAST:event_NMNAMEKeyTyped

  private void NLNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NLNAMEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NLNAME.setEditable(true);
    } else {
      NLNAME.setEditable(false);
    }
  }//GEN-LAST:event_NLNAMEKeyTyped

  private void NLKNOWNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NLKNOWNKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NLKNOWN.setEditable(true);
    } else {
      NLKNOWN.setEditable(false);
    }
  }//GEN-LAST:event_NLKNOWNKeyTyped

  private void NCITYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NCITYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NCITY.setEditable(true);
    } else {
      NCITY.setEditable(false);
    }
  }//GEN-LAST:event_NCITYKeyTyped

  private void NDISTRICTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDISTRICTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NDISTRICT.setEditable(true);
    } else {
      NDISTRICT.setEditable(false);
    }
  }//GEN-LAST:event_NDISTRICTKeyTyped

  private void NSTATEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NSTATEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NSTATE.setEditable(true);
    } else {
      NSTATE.setEditable(false);
    }
  }//GEN-LAST:event_NSTATEKeyTyped

  private void NCOUNTRYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NCOUNTRYKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NCOUNTRY.setEditable(true);
    } else {
      NCOUNTRY.setEditable(false);
    }
  }//GEN-LAST:event_NCOUNTRYKeyTyped

  private void NAGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAGEKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = NAGE.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 3) {
        NAGE.setEditable(true);
      } else {
        NAGE.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        NAGE.setEditable(true);
      } else {
        NAGE.setEditable(true);
      }
    }
  }//GEN-LAST:event_NAGEKeyTyped

  private void NCONTACT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NCONTACT1KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = NCONTACT1.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        NCONTACT1.setEditable(true);
      } else {
        NCONTACT1.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        NCONTACT1.setEditable(true);
      } else {
        NCONTACT1.setEditable(true);
      }
    }
  }//GEN-LAST:event_NCONTACT1KeyTyped

  private void NCONTACT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NCONTACT2KeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = NCONTACT2.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        NCONTACT2.setEditable(true);
      } else {
        NCONTACT2.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        NCONTACT2.setEditable(true);
      } else {
        NCONTACT2.setEditable(true);
      }
    }
  }//GEN-LAST:event_NCONTACT2KeyTyped

  private void NAADHAARNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAADHAARNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = NAADHAARNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 12) {
        NAADHAARNO.setEditable(true);
      } else {
        NAADHAARNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        NAADHAARNO.setEditable(true);
      } else {
        NAADHAARNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_NAADHAARNOKeyTyped

  private void NPANNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NPANNOKeyTyped
    char b = evt.getKeyChar();
    if (!Character.isDigit(b)) {
      evt.consume();
    }
    String p = NPANNO.getText();
    int length = p.length();
    char c = evt.getKeyChar();
    if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
      if (length < 10) {
        NPANNO.setEditable(true);
      } else {
        NPANNO.setEditable(false);
      }
    } else {
      if (
        evt.getExtendedKeyCode() == KeyEvent.VK_BACKSPACE ||
        evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
      ) {
        NPANNO.setEditable(true);
      } else {
        NPANNO.setEditable(true);
      }
    }
  }//GEN-LAST:event_NPANNOKeyTyped

  private void NUSERPHOTOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NUSERPHOTOKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NUSERPHOTO.setEditable(false);
    } else {
      NUSERPHOTO.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_NUSERPHOTOKeyTyped

  private void NJOB_EXPERIENCEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NJOB_EXPERIENCEKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NJOB_EXPERIENCE.setEditable(false);
    } else {
      NJOB_EXPERIENCE.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    }
  }//GEN-LAST:event_NJOB_EXPERIENCEKeyTyped

  private void NDOCUMENTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDOCUMENTKeyTyped
    char c = evt.getKeyChar();
    if (
      Character.isLetter(c) ||
      Character.isWhitespace(c) ||
      Character.isISOControl(c)
    ) {
      NDOCUMENT.setEditable(false);
    } else {
      NDOCUMENT.setEditable(true);
      char b = evt.getKeyChar();
      if (Character.isDigit(b)) {
        evt.consume();
      }
    } // TODO add your handling code here:
  }//GEN-LAST:event_NDOCUMENTKeyTyped

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(ADMIN.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ADMIN.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ADMIN.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ADMIN.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new ADMIN().setVisible(true);
        }
      }
    );
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AADHAARNO;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE;
    private javax.swing.JTextField CHARGES;
    private javax.swing.JTextField CITY;
    private javax.swing.JTextField CONTACT1;
    private javax.swing.JTextField CONTACT2;
    private javax.swing.JTextField COUNTRY;
    private javax.swing.JPasswordField CPASSWORD;
    private javax.swing.JPanel DASHBOARD0;
    private javax.swing.JLabel DATE;
    private com.toedter.calendar.JDateChooser DATEOFJOINING;
    private javax.swing.JLabel DDATE;
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField DID;
    private javax.swing.JPanel DISCHARGE_FORM;
    private javax.swing.JTextField DISTRICT;
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JPanel DOCTORLIST;
    private javax.swing.JPanel DOCTORS_CREATE;
    private javax.swing.JTable DOCTORS_LIST;
    private javax.swing.JTextField DOCUMENT;
    private javax.swing.JLabel DRNAME;
    private javax.swing.JLabel DTIME;
    private javax.swing.JTextField EDUCATION;
    private javax.swing.JTextField EMAIL;
    private javax.swing.JTextField EMERGANCY_CONTACT;
    private javax.swing.JLabel ERR;
    private javax.swing.JLabel ERRORLABLE;
    private javax.swing.JTextField EXTRA_AMOUNT;
    private javax.swing.JTextField FEE;
    private javax.swing.JTextField FNAME;
    private javax.swing.JLabel FULLNAME;
    private javax.swing.JComboBox<String> GENDER;
    private javax.swing.JTextField JOB_EXPERIENCE;
    private javax.swing.JTextField LKNOWN;
    private javax.swing.JTextField LNAME;
    private javax.swing.JTextArea MEDICINES;
    private javax.swing.JTextField MNAME;
    private javax.swing.JComboBox<String> MSTATUS;
    private javax.swing.JTextField NAADHAARNO;
    private javax.swing.JTextField NADDRESS;
    private javax.swing.JTextField NAGE;
    private javax.swing.JTextField NCITY;
    private javax.swing.JTextField NCONTACT1;
    private javax.swing.JTextField NCONTACT2;
    private javax.swing.JTextField NCOUNTRY;
    private javax.swing.JPasswordField NCPASSWORD;
    private com.toedter.calendar.JDateChooser NDATEOFJOINING;
    private javax.swing.JTextField NDISTRICT;
    private com.toedter.calendar.JDateChooser NDOB;
    private javax.swing.JTextField NDOCUMENT;
    private javax.swing.JTextField NEDUCATION;
    private javax.swing.JTextField NEMAIL;
    private javax.swing.JTextField NFNAME;
    private javax.swing.JComboBox<String> NGENDER;
    private javax.swing.JTextField NID;
    private javax.swing.JTextField NJOB_EXPERIENCE;
    private javax.swing.JTextField NLKNOWN;
    private javax.swing.JTextField NLNAME;
    private javax.swing.JTextField NMNAME;
    private javax.swing.JComboBox<String> NMSTATUS;
    private javax.swing.JLabel NOOFDAAYS;
    private javax.swing.JTextField NPANNO;
    private javax.swing.JPasswordField NPASSWORD;
    private javax.swing.JTextField NPINCODE;
    private javax.swing.JTextField NSPECIALIZATION;
    private javax.swing.JTextField NSTATE;
    private javax.swing.JButton NSUBMIT;
    private javax.swing.JButton NSUBMIT1;
    private javax.swing.JPanel NURSEEE;
    private javax.swing.JPanel NURSE_CREATE;
    private javax.swing.JTable NURSE_LIST;
    private javax.swing.JTextField NUSERNAME;
    private javax.swing.JTextField NUSERPHOTO;
    private javax.swing.JTextField OPD_NO;
    private javax.swing.JTextField OTAMOUNT;
    private javax.swing.JTextField PANNO;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JLabel PATIENTS;
    private javax.swing.JLabel PATIENTS1;
    private javax.swing.JPanel PATIENTSD;
    private javax.swing.JTable PATIENTS_DATA;
    private javax.swing.JComboBox<String> PATIENT_STATUS;
    private javax.swing.JTextField PID;
    private javax.swing.JTextField PINCODE;
    private javax.swing.JTextField RAADHAARNO;
    private javax.swing.JTextField RADDRESS;
    private javax.swing.JTextField RAGE;
    private javax.swing.JTextField RCITY;
    private javax.swing.JTextField RCONTACT1;
    private javax.swing.JTextField RCONTACT2;
    private javax.swing.JTextField RCOUNTRY;
    private javax.swing.JPasswordField RCPASSWORD;
    private javax.swing.JLabel RDATE;
    private javax.swing.JLabel RDATE1;
    private javax.swing.JLabel RDATE2;
    private javax.swing.JLabel RDATE3;
    private javax.swing.JLabel RDATE4;
    private javax.swing.JLabel RDATE5;
    private javax.swing.JLabel RDATE6;
    private com.toedter.calendar.JDateChooser RDATEOFJOINING;
    private javax.swing.JButton RDELETE;
    private javax.swing.JButton RDELETE1;
    private javax.swing.JButton RDELETE2;
    private javax.swing.JTextField RDISTRICT;
    private com.toedter.calendar.JDateChooser RDOB;
    private javax.swing.JTextField RDOCUMENT;
    private javax.swing.JPanel RECEPTIONISTDARA;
    private javax.swing.JPanel RECEPTIONIST_CREATE;
    private javax.swing.JTable RECEPTIONIST_LIST;
    private javax.swing.JTextField REDUCATION;
    private javax.swing.JTextField REMAIL;
    private javax.swing.JTextField RFNAME;
    private javax.swing.JComboBox<String> RGENDER;
    private javax.swing.JTextField RID;
    private javax.swing.JTextField RJOB_EXPERIENCE;
    private javax.swing.JTextField RLKNOWN;
    private javax.swing.JTextField RLNAME;
    private javax.swing.JTextField RMNAME;
    private javax.swing.JComboBox<String> RMSTATUS;
    private javax.swing.JTextField RPANNO;
    private javax.swing.JPasswordField RPASSWORD;
    private javax.swing.JTextField RPINCODE;
    private javax.swing.JTextField RSPECIALIZATION;
    private javax.swing.JTextField RSTATE;
    private javax.swing.JButton RSUBMIT;
    private javax.swing.JButton RSUBMIT2;
    private javax.swing.JLabel RTIME;
    private javax.swing.JLabel RTIME1;
    private javax.swing.JLabel RTIME2;
    private javax.swing.JLabel RTIME3;
    private javax.swing.JLabel RTIME4;
    private javax.swing.JButton RUPDATE;
    private javax.swing.JButton RUPDATE1;
    private javax.swing.JButton RUPDATE2;
    private javax.swing.JTextField RUSERNAME;
    private javax.swing.JTextField RUSERPHOTO;
    private javax.swing.JButton RVIEW;
    private javax.swing.JButton RVIEW1;
    private javax.swing.JTextField SPECIALIZATION;
    private javax.swing.JTextField STATE;
    private javax.swing.JButton SUBMIT;
    private javax.swing.JSeparator SeparatorLine1;
    private javax.swing.JLabel TADMIT;
    private javax.swing.JLabel TDEATH;
    private javax.swing.JLabel TDOCTORS;
    private javax.swing.JLabel TIME;
    private javax.swing.JLabel TIME1;
    private javax.swing.JLabel TIME2;
    private javax.swing.JLabel TNURSES;
    private javax.swing.JLabel TPATIENTS;
    private javax.swing.JTextArea TREATMENT;
    private javax.swing.JLabel TRESEPTIONISTS;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JTextField USERPHOTO;
    private javax.persistence.EntityManager VHSHOSPITALPUEntityManager;
    private javax.swing.JButton VIEW;
    private javax.swing.JTextField WARD;
    private javax.swing.JComboBox<String> WARDNAME;
    private javax.swing.JTable WARDSTABLE;
    private javax.swing.JPanel WARD_CREATE;
    private javax.swing.JTextField WID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel176;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JButton search3;
    private javax.swing.JButton search4;
    private javax.swing.JTextField txt_search1;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_search3;
    private javax.swing.JTextField txt_search4;
    private java.util.List<multispecility_hospital_solapur.ADMIN.Wards> wardsList;
    private java.util.List<multispecility_hospital_solapur.ADMIN.Wards> wardsList1;
    private javax.persistence.Query wardsQuery;
    private javax.persistence.Query wardsQuery1;
    // End of variables declaration//GEN-END:variables

}
