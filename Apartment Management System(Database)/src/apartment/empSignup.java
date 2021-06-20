/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mahathir Bishal
 */
public class empSignup {
    
        empSignup() {
        JFrame signfr = new JFrame("Employee Sign up");
        signfr.setVisible(true);
        signfr.setBounds(400, 150, 600, 550);
        signfr.setLocationRelativeTo(null);
        signfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        signfr.setLayout(null);
        signfr.setBackground(Color.GREEN);

        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        signfr.setIconImage(icon.getImage());
        JLabel name, ssn, job,  user,Bank, pass, repass,Addr;
        JTextField Uname, Ussn, Ujob,UAddr, Uuser,UBankacc;
        JPasswordField Upass, Urepass;
        JButton create, back;

        name = new JLabel("Name");
        name.setBounds(100, 100, 100, 30);
        name.setFont(new Font("Helvetica", Font.PLAIN, 14));

        ssn = new JLabel("SSN");
        ssn.setBounds(100, 140, 100, 30);
        ssn.setFont(new Font("Helvetica", Font.PLAIN, 14));

        job = new JLabel("Designation");
        job.setBounds(100, 180, 100, 30);
        job.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        Addr = new JLabel("Address");
        Addr.setBounds(100, 220, 100, 30);
        Addr.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        Bank = new JLabel("Bank Account No");
        Bank.setBounds(100, 260, 150, 30);
        Bank.setFont(new Font("Helvetica", Font.PLAIN, 14));

        user = new JLabel("User Name");
        user.setBounds(100, 300, 100, 30);
        user.setFont(new Font("Helvetica", Font.PLAIN, 14));

        pass = new JLabel("Password");
        pass.setBounds(100, 340, 100, 30);
        pass.setFont(new Font("Helvetica", Font.PLAIN, 14));

        repass = new JLabel("Retype Password");
        repass.setBounds(100, 380, 150, 30);
        repass.setFont(new Font("Helvetica", Font.PLAIN, 14));

        signfr.add(name);
        signfr.add(job);
        signfr.add(ssn);
        signfr.add(Addr);
        signfr.add(Bank);
        signfr.add(user);
        signfr.add(pass);
        signfr.add(repass);
        //signfr.add(name,ssn,working_place,job,phone,fam_memb);
        //Uname,Ussn,Uwp,Uph,Ufm,Uuser,Upass,Urepass
        Uname = new JTextField();
        Uname.setBounds(300, 100, 130, 20);
        Uname.setBorder(null);
        signfr.add(Uname);

        Ussn = new JTextField();
        Ussn.setBounds(300, 140, 130, 20);
        Ussn.setBorder(null);
        signfr.add(Ussn);

        Ujob = new JTextField();
        Ujob.setBounds(300, 180, 130, 20);
        Ujob.setBorder(null);
        signfr.add(Ujob);

        
        UAddr = new JTextField();
        UAddr.setBounds(300, 220, 130, 20);
        UAddr.setBorder(null);
        signfr.add(UAddr);
        
        UBankacc = new JTextField();
        UBankacc.setBounds(300, 260, 130, 20);
        UBankacc.setBorder(null);
        signfr.add(UBankacc);

        Uuser = new JTextField();
        Uuser.setBounds(300, 300, 130, 20);
        Uuser.setBorder(null);
        signfr.add(Uuser);
        
        Upass = new JPasswordField();
        Upass.setBounds(300, 340, 130, 20);
        Upass.setBorder(null);
        signfr.add(Upass);

        Urepass = new JPasswordField();
        Urepass.setBounds(300, 380, 130, 20);
        Urepass.setBorder(null);
        signfr.add(Urepass);
        
        //
        create = new JButton("Create Account");
        create.setBounds(150, 460, 120, 25);
        create.setFont(new Font("tahoma", Font.PLAIN, 12));
        back = new JButton("Back");
        back.setFont(new Font("Helvetica", Font.PLAIN, 12));
        back.setBounds(350, 460, 65, 25);
        signfr.add(create);
        signfr.add(back);

        // database connectivity
        //name,ssn,job,working_place,phone,fam_memb,user,pass,repass;
        //////////////////////
        create.addActionListener((ActionEvent e) -> {
            String Ename = Uname.getText();
            //String Tssn,Tjob,Twp,Tph,Tfm,Tuser,Tpass,Trepass;
            String Essn = Ussn.getText();
            String Ejob = Ujob.getText();
            String EAddr = UAddr.getText();
            String Euser = Uuser.getText();
            String Epass = Upass.getText();
            String Erepass = Urepass.getText();
            String Bnnkaccount =UBankacc.getText();

            //System.out.println(Tuser);//+"  "+Tjob+"  "+Twp+"  "+Tph+"  "+Tfm+"  "+Tuser+"  "+Tpass+"  "+Trepass);
            int passlen = Epass.length();

            if (Ename.isEmpty() || Essn.isEmpty() || Ejob.isEmpty() ||  Euser.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please,Fill all the information", "Alert", JOptionPane.ERROR_MESSAGE);
                
            } else if (passlen < 4) {
                JOptionPane.showMessageDialog(null, "use a password of atlest 4 character", "Alert", JOptionPane.ERROR_MESSAGE);
            } else if (!Epass.equals(Erepass) ) {
                JOptionPane.showMessageDialog(null, "password not matched!!", "Error", JOptionPane.ERROR_MESSAGE);
                Upass.setText("");
                Urepass.setText("");
            } else {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.execute("insert into employee VALUES ('" + Essn + "','" + Ename + "','" + Ejob + "','" + EAddr + "','" + Euser + "','" + Epass + "' ,'"+Bnnkaccount+"','No');");

                    st.close();
                    c.close();
                    JOptionPane.showMessageDialog(null, "Your information has added to database", "info added", JOptionPane.PLAIN_MESSAGE);
                    Uname.setText("");
                    Ussn.setText("");
                    
                    Ujob.setText("");
                    UAddr.setText("");
                    Uuser.setText("");
                    Upass.setText("");
                    UBankacc.setText("");
                    Urepass.setText("");

                } catch (Exception ex) {
                    
                   
                    JOptionPane.showMessageDialog(null, ex);

                }

            }

        });
        back.addActionListener((ActionEvent e) -> {

            signfr.setVisible(false);
            empLogin eup = new empLogin();

        });

    }
    
}
