package apartment;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahathir Bishal
 */
public class adAccount extends JFrame {

    public String sexx, ten_fdbk, ten_name, ten_flat;

    private ImageIcon goHome_ico;
    private Cursor cursor;

    private DefaultTableModel model1, model2, model3;
    private JTable table1, table2, table3;
    private JScrollPane scroll1, scroll2, scroll3;

    private JPanel panel1, panel2, panel3;
    private JTabbedPane tbPane;

    JFrame admFrame = new JFrame("Control panel");

    adAccount() throws IOException {

        admFrame.setVisible(true);
        admFrame.setBounds(1, 1, 750, 600);
        admFrame.setLocationRelativeTo(null);
        admFrame.setLayout(null);
        admFrame.setResizable(false);
        admFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon/icon.png"));
        admFrame.setIconImage(icon.getImage());

        cursor = new Cursor(Cursor.HAND_CURSOR);

        JLabel label = new JLabel("APARTMENT MANAGEMENT SYSTEM ");
        JLabel label2 = new JLabel(" CONTROL PANEL");
        label.setBounds(220, 20, 330, 70);
        label2.setBounds(280, 50, 160, 70);
        label.setFont(new Font("tahoma", Font.PLAIN, 17));
        label2.setFont(new Font("tahoma", Font.PLAIN, 17));
        admFrame.add(label);
        admFrame.add(label2);

        //calling visitors infrmation function
        visitors_info();

        //home button
        goHome_ico = new ImageIcon(getClass().getResource("icon/home_ico.png"));
        JButton goHome = new JButton(goHome_ico);
        goHome.setBounds(30, 30, 55, 55);
        goHome.setBorderPainted(false);
        goHome.setContentAreaFilled(false);
        goHome.setCursor(cursor);
        goHome.setBackground(null);
        goHome.setToolTipText("Back to home Screen");
        admFrame.add(goHome);

        //see feedback
        JButton fbkbtn = new JButton("See FeedBack");
        fbkbtn.setBounds(250, 480, 120, 30);
        fbkbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
        admFrame.add(fbkbtn);

        JButton visitor = new JButton("see visitors info");
        visitor.setBounds(120, 480, 120, 30);
        //admFrame.add(visitor);

        tbPane = new JTabbedPane();
        tbPane.setBounds(30, 120, 440, 300);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

//        panel1.setOpaque(false);
//        panel2.setBackground(Color.blue);
//        panel3.setBackground(Color.cyan);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        //scroll1=new JScrollPane(table1);
        //scroll3=new JScrollPane(table3);
        tbPane.addTab("Tenant", panel1);
        tenant_showing();
        tbPane.addTab("visitor", panel2);
        visitor_showing();
        tbPane.addTab("employee", panel3);
        employee_showing();

        admFrame.add(tbPane);

        ImageIcon bg_ico = new ImageIcon(getClass().getResource("icon/adm_bg.png"));
        JLabel bg_icon_lbl = new JLabel(bg_ico);
        bg_icon_lbl.setBounds(0, 0, 750, 600);
        admFrame.add(bg_icon_lbl);

        goHome.addActionListener((ActionEvent e) -> {
            admFrame.setVisible(false);
            Apartment.main(new String[0]);
        });

        //=new JTable();
        visitor.addActionListener((ActionEvent e) -> {
            // visitor_showing();
        });

        fbkbtn.addActionListener((ActionEvent e) -> {

            JFrame fbkframe = new JFrame("Feedback");
            fbkframe.setVisible(true);
            fbkframe.setSize(400, 300);
            fbkframe.setLocationRelativeTo(null);
            fbkframe.setLayout(null);
            fbkframe.setResizable(false);
            fbkframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            try {
                String ip = InetAddress.getLocalHost().getHostAddress();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                Statement st = c.createStatement();

                ResultSet rs = st.executeQuery("select * from feedback");
                // String ten_fdbk, ten_name, ten_flat;
                while (rs.next()) {
                    ten_fdbk = rs.getString("feedback");
                    ten_name = rs.getString("tenant_name");
                    ten_flat = rs.getString("Flat_no");
                }

                st.close();
                c.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (ten_fdbk == null) {
                JLabel Null_fdbk = new JLabel("NO FEEDBACK YET");
                Null_fdbk.setBounds(120, 120, 200, 30);
                Null_fdbk.setFont(new Font("tahoma", Font.PLAIN, 17));
                fbkframe.add(Null_fdbk);
            } else {
                JLabel flat_lbl = new JLabel("From :  Flat no " + ten_flat);
                flat_lbl.setBounds(20, 20, 200, 20);
                fbkframe.add(flat_lbl);
                JLabel name_lbl = new JLabel("Name :  " + ten_name);
                name_lbl.setBounds(20, 40, 200, 20);
                fbkframe.add(name_lbl);
                JLabel fb_lbl = new JLabel("Feedback : ");
                fb_lbl.setBounds(20, 60, 200, 20);
                fbkframe.add(fb_lbl);
                JTextArea fdbk_ta = new JTextArea();
                fdbk_ta.setBounds(20, 80, 200, 100);
                fdbk_ta.setEditable(false);
                fdbk_ta.setLineWrap(true);

                fdbk_ta.setText(ten_fdbk);
                fbkframe.add(fdbk_ta);

            }
            JButton okbtn = new JButton("OK");
            okbtn.setBounds(170, 220, 70, 30);
            okbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
            fbkframe.add(okbtn);

            okbtn.addActionListener((ActionEvent ep) -> {
                fbkframe.setVisible(false);
            });

        });

//        visitor.addActionListener((ActionEvent e) -> {
//
//            JFrame visit = new JFrame("Visitor's info");
//            visit.setVisible(true);
//            visit.setBounds(1, 1, 300, 400);
//            visit.setLayout(null);
//            visit.setResizable(false);
//            visit.setLocationRelativeTo(null);
//            visit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//
//        });
    }

    public void visitors_info() {

        JPanel visitor_panel = new JPanel();
        visitor_panel.setBounds(480, 100, 250, 300);
        //visitor_panel.setBackground(Color.red);
        visitor_panel.setLayout(null);
        visitor_panel.setOpaque(false);
        admFrame.add(visitor_panel);

        JLabel name, flat, sex, heading;
        JTextField nm, flt;

        heading = new JLabel("Visitor's Info");
        heading.setBounds(90, 0, 100, 30);
        visitor_panel.add(heading);

        name = new JLabel("Name :");
        name.setBounds(30, 50, 100, 30);
        name.setFont(new Font("tahoma", Font.PLAIN, 13));
        flat = new JLabel("Flat No :");
        flat.setBounds(30, 100, 100, 30);
        flat.setFont(new Font("tahoma", Font.PLAIN, 13));
        sex = new JLabel("Sex :");
        sex.setBounds(30, 150, 100, 30);
        sex.setFont(new Font("tahoma", Font.PLAIN, 13));

        visitor_panel.add(name);
        visitor_panel.add(flat);
        visitor_panel.add(sex);

        nm = new JTextField();
        nm.setBounds(130, 50, 100, 25);
        flt = new JTextField("0");
        flt.setBounds(130, 100, 100, 25);

        visitor_panel.add(nm);
        visitor_panel.add(flt);

        JRadioButton malebtn = new JRadioButton("Male");
        JRadioButton femalebtn = new JRadioButton("Female");
        malebtn.setBounds(130, 150, 100, 30);
        malebtn.setOpaque(false);
        femalebtn.setBounds(130, 175, 100, 30);
        femalebtn.setOpaque(false);
        visitor_panel.add(malebtn);
        visitor_panel.add(femalebtn);

        ButtonGroup btngrp = new ButtonGroup();
        btngrp.add(malebtn);
        btngrp.add(femalebtn);

        malebtn.addActionListener((ActionEvent e1) -> {
            sexx = "male";
        });
        femalebtn.addActionListener((ActionEvent e1) -> {
            sexx = "female";
            //System.out.println(sexx);
        });

        JButton addbtn = new JButton("ADD");
        addbtn.setBounds(100, 230, 60, 25);
        addbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
        visitor_panel.add(addbtn);

        addbtn.addActionListener((ActionEvent e1) -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time = dtf.format(now);
            String nam = nm.getText();
            int fn = Integer.valueOf(flt.getText());

            if (nam != null && fn != 0 & sexx != null) {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();
                    st.execute("insert into visitor values('" + nam + "','" + fn + "','" + sexx + "','" + time + "')");

                    st.close();
                    c.close();
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                nm.setText("");
                flt.setText("");
                JOptionPane.showMessageDialog(null, "Information added");

            } else {
                JOptionPane.showMessageDialog(null, "Fill all the information");
            }

            //updating table
            panel2.remove(scroll2);
            visitor_showing();

        });
    }

    public void tenant_showing() {

        String col[] = {"Flat No", "Name", "Profession", "Phone", "F_member"};
        String row[] = new String[5];
        table1 = new JTable();

        model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(col);

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("select * from tenant");
            // String ten_fdbk, ten_name, ten_flat;
            int i = 0;
            while (rs.next()) {

                row[0] = rs.getString("FLat_no");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Job");
                row[3] = rs.getString("Phone");
                row[4] = rs.getString("Family_memb");
                model1.addRow(row);
            }

            st.close();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table1.setModel(model1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        table1.getColumnModel().getColumn(3).setPreferredWidth(110);
        table1.getColumnModel().getColumn(4).setPreferredWidth(80);

        scroll1 = new JScrollPane(table1);
        scroll1.setBounds(0, 00, 440, 200);
        panel1.add(scroll1);

        Font ff = new Font("tahoma", Font.PLAIN, 13);
        JButton delete = new JButton("delete");
        delete.setBounds(130, 225, 74, 25);
        delete.setFont(ff);
        delete.setFocusPainted(false);
        panel1.add(delete);

        JButton update = new JButton("update");
        update.setBounds(230, 225, 74, 25);
        update.setFont(ff);
        update.setFocusPainted(false);
        panel1.add(update);

        delete.addActionListener((ActionEvent e) -> {

            int n = table1.getSelectedRow();
            if (n >= 0) {
                String key = (model1.getValueAt(n, 0).toString());

                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.executeUpdate("DELETE FROM tenant WHERE Flat_no='" + key + "' ");

                    st.close();
                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                model1.removeRow(n);

            } else {
                JOptionPane.showMessageDialog(null, "Select a row first ,then delete it");
            }

        });

        update.addActionListener((ActionEvent e) -> {
            int r = table1.getSelectedRow();
            if (r < 0) {
                JOptionPane.showMessageDialog(null, "select a row to update");
            } else {
                JFrame fr = new JFrame();
                fr.setVisible(true);
                fr.setSize(300, 350);
                fr.setResizable(false);
                fr.setLayout(null);
                fr.setLocationRelativeTo(null);
                fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JLabel name, flt, Prof, phn, Fmly_mmb, heading;
                JTextField Name, Flt, Profes, Phn, Fm;

                heading = new JLabel("Update Tenant's Info");
                heading.setBounds(90, 0, 180, 30);
                fr.add(heading);

                Font font = new Font("tahoma", Font.PLAIN, 13);
                name = new JLabel("Name :");
                name.setBounds(50, 50, 100, 30);
                name.setFont(font);
                flt = new JLabel("SSN :");
                flt.setBounds(50, 100, 100, 30);
                flt.setFont(font);
                Prof = new JLabel("Designation :");
                Prof.setBounds(50, 150, 100, 30);
                Prof.setFont(font);
                phn = new JLabel("Phone :");
                phn.setBounds(50, 200, 200, 30);
                phn.setFont(font);
                Fmly_mmb = new JLabel("Family memb. :");
                Fmly_mmb.setBounds(50, 250, 200, 30);
                Fmly_mmb.setFont(font);

                fr.add(name);
                fr.add(flt);
                fr.add(phn);
                fr.add(Prof);
                fr.add(Fmly_mmb);

                Name = new JTextField();
                Name.setBounds(150, 50, 100, 25);
                Flt = new JTextField();
                Flt.setBounds(150, 100, 100, 25);
                Profes = new JTextField();
                Profes.setBounds(150, 150, 100, 25);
                Phn = new JTextField();
                Phn.setBounds(150, 200, 100, 25);
                Fm = new JTextField();
                Fm.setBounds(150, 250, 100, 25);

                fr.add(Name);
                fr.add(Flt);
                fr.add(Profes);
                fr.add(Profes);
                fr.add(Phn);
                fr.add(Fm);

                Flt.setText(model1.getValueAt(r, 0).toString());
                Name.setText(model1.getValueAt(r, 1).toString());
                Profes.setText(model1.getValueAt(r, 2).toString());
                Phn.setText(model1.getValueAt(r, 3).toString());
                Fm.setText(model1.getValueAt(r, 4).toString());

                JButton addbtn = new JButton("Update");
                addbtn.setBounds(110, 280, 80, 25);
                addbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
                fr.add(addbtn);

                addbtn.addActionListener((ActionEvent e1) -> {

                    String FLT = Flt.getText();
                    String NM = Name.getText();
                    String PROFES = Profes.getText();
                    String PHN = Phn.getText();
                    String FM = Fm.getText();

                    String PreFLT = model1.getValueAt(r, 0).toString();

                    try {
                        String ip = InetAddress.getLocalHost().getHostAddress();
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                        Statement st = c.createStatement();
                        st.execute("update tenant set Name='" + NM + "',Job='" + PROFES + "',Phone='" + PHN + "',Flat_no='" + FLT + "',Family_memb='" + FM + "' where Flat_no='" + PreFLT + "'   ");

                        st.close();
                        c.close();
                        fr.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Tenant's info Updated");
                    } catch (Exception ep) {
                        ep.printStackTrace();
                    }

                    //
                    panel1.remove(scroll1);
                    tenant_showing();

                });
//
            }
        });

    }

    public void visitor_showing() {
        String col[] = {"Flat No", "Name", "Sex", "Time"};
        String rows[] = new String[4];

        table2 = new JTable();

        model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(col);

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("select * from visitor");
            // String ten_fdbk, ten_name, ten_flat;

            while (rs.next()) {

                rows[0] = rs.getString("FLat_no");
                rows[1] = rs.getString("Name");
                rows[2] = rs.getString("Sex");
                rows[3] = rs.getString("Time");

                model2.addRow(rows);
            }

            st.close();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table2.setModel(model2);

        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table2.getColumnModel().getColumn(0).setPreferredWidth(50);
        table2.getColumnModel().getColumn(1).setPreferredWidth(90);
        table2.getColumnModel().getColumn(2).setPreferredWidth(60);
        table2.getColumnModel().getColumn(3).setPreferredWidth(145);

        scroll2 = new JScrollPane(table2);
        scroll2.setBounds(0, 00, 350, 290);
        panel2.add(scroll2);

        Font ff = new Font("tahoma", Font.PLAIN, 13);
        JButton delete = new JButton("delete");
        delete.setBounds(355, 10, 74, 25);
        delete.setFont(ff);
        delete.setFocusPainted(false);
        panel2.add(delete);

        JButton update = new JButton("update");
        update.setBounds(355, 50, 74, 25);
        update.setFont(ff);
        update.setFocusPainted(false);
        panel2.add(update);

        delete.addActionListener((ActionEvent e) -> {

            int n = table2.getSelectedRow();
            if (n >= 0) {
                String var = (model2.getValueAt(n, 3).toString());

                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.executeUpdate("DELETE FROM visitor WHERE Time='" + var + "' ");

                    st.close();
                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                model2.removeRow(n);

            } else {
                JOptionPane.showMessageDialog(null, "Select a row first ,then delete it");
            }

        });

        update.addActionListener((ActionEvent e) -> {
            //panel2.remove(scroll2);
            //visitor_showing();
            int r = table2.getSelectedRow();

            JFrame fr = new JFrame();

            fr.setSize(300, 300);
            fr.setResizable(false);
            fr.setLayout(null);
            fr.setLocationRelativeTo(null);
            fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            if (r <= 0) {
                fr.setVisible(false);
                JOptionPane.showMessageDialog(null, "select a row to update");
            } else {
                fr.setVisible(true);
                //}

                JLabel name, flat, sex, heading;
                JTextField nm, flt;

                heading = new JLabel("Update Visitor's Info");
                heading.setBounds(90, 0, 180, 30);
                fr.add(heading);

                Font font = new Font("tahoma", Font.PLAIN, 13);
                name = new JLabel("Name :");
                name.setBounds(50, 50, 100, 30);
                name.setFont(font);
                flat = new JLabel("Flat No :");
                flat.setBounds(50, 100, 100, 30);
                flat.setFont(font);
                sex = new JLabel("Sex :");
                sex.setBounds(50, 150, 100, 30);
                sex.setFont(font);

                fr.add(name);
                fr.add(flat);
                fr.add(sex);

                nm = new JTextField();
                nm.setBounds(150, 50, 100, 25);
                flt = new JTextField("0");
                flt.setBounds(150, 100, 100, 25);

                fr.add(nm);
                fr.add(flt);

                JRadioButton malebtn = new JRadioButton("Male");
                JRadioButton femalebtn = new JRadioButton("Female");
                malebtn.setBounds(150, 150, 100, 30);
                femalebtn.setBounds(150, 175, 100, 30);
                fr.add(malebtn);
                fr.add(femalebtn);

                ButtonGroup btngrp = new ButtonGroup();
                btngrp.add(malebtn);
                btngrp.add(femalebtn);

                malebtn.addActionListener((ActionEvent e1) -> {
                    sexx = "male";
                });
                femalebtn.addActionListener((ActionEvent e1) -> {
                    sexx = "female";
                    //System.out.println(sexx);
                });

                nm.setText(model2.getValueAt(r, 1).toString());
                flt.setText(model2.getValueAt(r, 0).toString());

                JButton addbtn = new JButton("Update");
                addbtn.setBounds(110, 230, 80, 25);
                addbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
                fr.add(addbtn);

                addbtn.addActionListener((ActionEvent e1) -> {

                    String nam = nm.getText();
                    int fn = Integer.valueOf(flt.getText());

                    String PreTime = model2.getValueAt(r, 3).toString();
                    //System.out.println(PreTime);
                    try {
                        String ip = InetAddress.getLocalHost().getHostAddress();
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                        Statement st = c.createStatement();
                        st.execute("update visitor set Name='" + nam + "',Flat_no='" + fn + "',Sex='" + sexx + "' where Time='" + PreTime + "'   ");

                        st.close();
                        c.close();
                    } catch (Exception ep) {
                        ep.printStackTrace();
                    }

                    //
                    panel2.remove(scroll2);
                    visitor_showing();

                    fr.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Visitors info Updated");

                });
//
            }
        });

    }

    public void employee_showing() {
        String col[] = {"SSN", "Name", "Designation", "Address", "Bank Acc", "Payment"};
        String rows[] = new String[6];

        table3 = new JTable();

        model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(col);

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("select * from employee");
            // String ten_fdbk, ten_name, ten_flat;

            while (rs.next()) {

                rows[0] = rs.getString("SSN");
                rows[1] = rs.getString("name");
                rows[2] = rs.getString("Designation");
                rows[3] = rs.getString("Address");
                rows[4] = rs.getString("BankAcc");
                rows[5] = rs.getString("Payment");

                model3.addRow(rows);
            }

            st.close();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
            Statement st = c.createStatement();

            if(day==1)
            {
            st.execute("update employee set Payment='No'");
            }
            st.close();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table3.setModel(model3);

        table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table3.getColumnModel().getColumn(0).setPreferredWidth(50);
        table3.getColumnModel().getColumn(1).setPreferredWidth(90);
        table3.getColumnModel().getColumn(2).setPreferredWidth(80);
        table3.getColumnModel().getColumn(3).setPreferredWidth(120);
        table3.getColumnModel().getColumn(4).setPreferredWidth(80);
        table3.getColumnModel().getColumn(5).setPreferredWidth(60);

        scroll3 = new JScrollPane(table3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll3.setBounds(0, 00, 340, 270);
        panel3.add(scroll3);

        Font ff = new Font("tahoma", Font.PLAIN, 13);
        JButton delete = new JButton("delete");
        delete.setBounds(345, 10, 83, 25);
        delete.setFont(ff);
        delete.setFocusPainted(false);
        panel3.add(delete);

        JButton update = new JButton("update");
        update.setBounds(345, 50, 83, 25);
        update.setFont(ff);
        update.setFocusPainted(false);
        panel3.add(update);

        JButton payment = new JButton("Payment");
        payment.setBounds(345, 90, 83, 25);
        payment.setFont(ff);
        payment.setFocusPainted(false);
        panel3.add(payment);

        delete.addActionListener((ActionEvent e) -> {

            int n = table3.getSelectedRow();
            if (n >= 0) {
                String var = (model3.getValueAt(n, 0).toString());

                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.executeUpdate("DELETE FROM employee WHERE SSN='" + var + "' ");

                    st.close();
                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                model3.removeRow(n);

            } else {
                JOptionPane.showMessageDialog(null, "Select a row first ,then delete it");
            }

        });

        update.addActionListener((ActionEvent e) -> {
            //panel2.remove(scroll2);
            //visitor_showing();
            int r = table3.getSelectedRow();

            if (r <= 0) {
                // fr.setVisible(false);
                JOptionPane.showMessageDialog(null, "select a row to update");
            } else {
                JFrame fr = new JFrame();
                fr.setVisible(true);
                fr.setSize(300, 300);
                fr.setResizable(false);
                fr.setLayout(null);
                fr.setLocationRelativeTo(null);
                fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JLabel name, ssn, designation, addr, heading;
                JTextField nm, SSN, desig, ADDR;

                heading = new JLabel("Update Employees's Info");
                heading.setBounds(90, 0, 180, 30);
                fr.add(heading);

                Font font = new Font("tahoma", Font.PLAIN, 13);
                name = new JLabel("Name :");
                name.setBounds(50, 50, 100, 30);
                name.setFont(font);
                ssn = new JLabel("SSN :");
                ssn.setBounds(50, 100, 100, 30);
                ssn.setFont(font);
                designation = new JLabel("Designation :");
                designation.setBounds(50, 150, 100, 30);
                designation.setFont(font);
                addr = new JLabel("Address :");
                addr.setBounds(50, 200, 200, 30);
                addr.setFont(font);

                fr.add(name);
                fr.add(ssn);
                fr.add(addr);
                fr.add(designation);

                nm = new JTextField();
                nm.setBounds(150, 50, 100, 25);
                SSN = new JTextField();
                SSN.setBounds(150, 100, 100, 25);
                desig = new JTextField();
                desig.setBounds(150, 150, 100, 25);
                ADDR = new JTextField();
                ADDR.setBounds(150, 200, 100, 25);

                fr.add(nm);
                fr.add(SSN);
                fr.add(desig);
                fr.add(ADDR);

                SSN.setText(model3.getValueAt(r, 0).toString());
                nm.setText(model3.getValueAt(r, 1).toString());
                desig.setText(model3.getValueAt(r, 2).toString());
                ADDR.setText(model3.getValueAt(r, 3).toString());

                JButton addbtn = new JButton("Update");
                addbtn.setBounds(110, 230, 80, 25);
                addbtn.setFont(new Font("tahoma", Font.PLAIN, 13));
                fr.add(addbtn);

                addbtn.addActionListener((ActionEvent e1) -> {

                    String nam = nm.getText();
                    String sn = SSN.getText();
                    String Desig = desig.getText();
                    String Addr = ADDR.getText();

                    String PreSSN = model3.getValueAt(r, 0).toString();

                    try {
                        String ip = InetAddress.getLocalHost().getHostAddress();
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                        Statement st = c.createStatement();
                        st.execute("update employee set name='" + nam + "',Designation='" + Desig + "',Address='" + Addr + "' where SSN='" + PreSSN + "'   ");

                        st.close();
                        c.close();
                        fr.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Emlpoyee's info Updated");
                    } catch (Exception ep) {
                        ep.printStackTrace();
                    }

                    //
                    panel3.remove(scroll3);
                    employee_showing();

                });

            }
        });

        payment.addActionListener((ActionEvent e) -> {

            int r = table3.getSelectedRow();

            if (r <= 0) {
                JOptionPane.showMessageDialog(null, "select a Employee to make payment");
            } else if (model3.getValueAt(r, 5).toString() == "Yes") {
                String des = model3.getValueAt(r, 2).toString();
                String name = model3.getValueAt(r, 1).toString();

                JOptionPane.showMessageDialog(null, des + " " + name + " has alreagy got payment");
            } else {
                JFrame fr = new JFrame();
                fr.setVisible(true);
                fr.setSize(300, 300);
                fr.setResizable(false);
                fr.setLayout(null);
                fr.setLocationRelativeTo(null);
                fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JLabel name, ssn, designation, amount, heading;
                JTextField AMOUNT;

                heading = new JLabel("Emplyee's Payment");
                heading.setBounds(90, 0, 180, 30);
                fr.add(heading);

                Font font = new Font("tahoma", Font.PLAIN, 14);
                name = new JLabel("Name          : " + model3.getValueAt(r, 1).toString());
                name.setBounds(50, 50, 200, 30);
                name.setFont(font);
                designation = new JLabel("Designation  : " + model3.getValueAt(r, 2).toString());
                designation.setBounds(50, 90, 200, 30);
                designation.setFont(font);
                amount = new JLabel("Set Amount : ");
                amount.setBounds(50, 130, 100, 30);
                amount.setFont(font);

                fr.add(name);
                fr.add(designation);
                fr.add(amount);

                AMOUNT = new JTextField();
                AMOUNT.setBounds(150, 130, 100, 25);
                fr.add(AMOUNT);

                JButton done = new JButton("Done");
                done.setBounds(110, 190, 70, 30);
                fr.add(done);

                done.addActionListener((ActionEvent ep) -> {
                    //if(model3.getValueAt(r, 5).toString()=="Yes")
                       // JOptionPane.showMessageDialog(null, "Emlpoyee's Payment already paid");
                    
                    //else
                    if (AMOUNT.getText() != "") {
                        String EMPssn = model3.getValueAt(r, 0).toString();
                        try {
                            String ip = InetAddress.getLocalHost().getHostAddress();
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                            Statement st = c.createStatement();
                            st.executeUpdate("update  employee set Payment='Yes' where SSN='" + EMPssn + "'");

                            st.close();
                            c.close();
                            fr.setVisible(false);
                            panel3.remove(scroll3);
                            employee_showing();
                            JOptionPane.showMessageDialog(null, "Emlpoyee's Payment compled");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Amount is empty");
                    }

                });

            }

        });
    }

}
