/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mahathir Bishal
 */
public class empAccount {
    
        int submit = 0;
    String ten_name, ten_job, ten_flatNo, admin_name, admin_office, bal;
    private ImageIcon tn_bg_ico, goHome_ico;
    private Container c;
    private JLabel tn_bg_lbl;
    private Cursor cursor;

    public void Account(String name, String password) {
        JFrame tnAccFrame = new JFrame();
        tnAccFrame.setVisible(true);
        tnAccFrame.setBounds(600, 200, 650, 500);
        tnAccFrame.setLocationRelativeTo(null);
        tnAccFrame.setLayout(null);
        tnAccFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tnAccFrame.setTitle("Employee Profile");
        tnAccFrame.setResizable(false);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        tnAccFrame.setIconImage(icon.getImage());

        cursor = new Cursor(Cursor.HAND_CURSOR);

        JLabel mainLabel = new JLabel("Employee Account");
        mainLabel.setBounds(210, 20, 210, 50);
        mainLabel.setFont(new Font("tahoma", Font.PLAIN, 25));
        tnAccFrame.add(mainLabel);

        JLabel lbl1 = new JLabel("Employee Information :");
        lbl1.setBounds(20, 150, 170, 30);
        lbl1.setFont(new Font("tahoma", Font.BOLD, 14));
        tnAccFrame.add(lbl1);

        JLabel lbl2 = new JLabel("Admin Information :");
        lbl2.setBounds(20, 300, 150, 30);
        lbl2.setFont(new Font("tahoma", Font.BOLD, 14));
        tnAccFrame.add(lbl2);

        JLabel fb_lbl = new JLabel("Send A Feedback To Admin  :");
        fb_lbl.setBounds(400, 250, 250, 100);
        fb_lbl.setFont(new Font("tahoma", Font.HANGING_BASELINE, 13));
       // tnAccFrame.add(fb_lbl);

        JTextArea fb = new JTextArea();
        fb.setLineWrap(true);
        
        JScrollPane scroll=new JScrollPane(fb);
        scroll.setBounds(400, 270, 200, 130);
       // tnAccFrame.add(scroll);
        
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
            Statement st = c.createStatement();
            ResultSet rs1 = st.executeQuery("select * from employee,admin");
            int counter = 1;
            while (rs1.next()) {

                if (name.equals(rs1.getString("user_name")) && password.equals(rs1.getString("password"))) {
                    ten_name = rs1.getString("name");
                    ten_job = rs1.getString("Designation");
                    ten_flatNo = rs1.getString("Address");
                }
                if (counter <= 1) {
                    admin_name = rs1.getString("Admin_name");
                    admin_office = rs1.getString("Office_address");
                    counter++;
                }
            }

            st.close();
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Font f=new Font("tahoma",Font.PLAIN,14);
        JLabel lbl1a = new JLabel("Name :  " + ten_name);
        lbl1a.setBounds(60, 180, 200, 30);
        lbl1a.setFont(f);
        tnAccFrame.add(lbl1a);
        JLabel lbl1b = new JLabel("Designation :  " + ten_job);
        lbl1b.setBounds(60, 200, 200, 30);
        lbl1b.setFont(f);
        tnAccFrame.add(lbl1b);
        JLabel lbl1c = new JLabel("Address :  " + ten_flatNo);
        lbl1c.setBounds(60, 220, 200, 30);
        lbl1c.setFont(f);
        tnAccFrame.add(lbl1c);

        JLabel lbl2a = new JLabel("Admin Name :  " + admin_name);
        lbl2a.setBounds(60, 330, 200, 30);
        lbl2a.setFont(f);
        tnAccFrame.add(lbl2a);
        JLabel lbl2b = new JLabel("Admin Office :  " + admin_office);
        lbl2b.setBounds(60, 340, 250, 60);
        lbl2b.setFont(f);
        //lbl2b.setLineWrap(true);
        tnAccFrame.add(lbl2b);

        JButton fbbtn = new JButton("send");
        fbbtn.setBounds(400, 410, 75, 25);
        fbbtn.setFont(new Font("tahoma", Font.PLAIN, 14));
        //tnAccFrame.add(fbbtn);

        goHome_ico = new ImageIcon(getClass().getResource("icon/home_ico.png"));
        JButton goHome = new JButton(goHome_ico);
        goHome.setBounds(30, 30, 55, 55);
        goHome.setBorderPainted(false);
        goHome.setContentAreaFilled(false);
        goHome.setCursor(cursor);
        goHome.setBackground(null);
        goHome.setToolTipText("Back to home Screen");
        tnAccFrame.add(goHome);

        tn_bg_ico = new ImageIcon(getClass().getResource("icon/tenantAcc.png"));

        tn_bg_lbl = new JLabel(tn_bg_ico);
        tn_bg_lbl.setBounds(0, 0, 650, 500);
        tnAccFrame.add(tn_bg_lbl);

        goHome.addActionListener((ActionEvent e) -> {
            tnAccFrame.setVisible(false);
            Apartment.main(new String[0]);
        });

        fbbtn.addActionListener((ActionEvent ep) -> {
            bal = fb.getText();
            if (fb.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Type something to send");
            } else {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.execute("insert into feedback values('" + bal + "','" + ten_name + "','" + ten_flatNo + "')");
                    st.close();
                    c.close();
                    JOptionPane.showMessageDialog(null, "Feedbank sent");
                    fb.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        });
    }
    
}
