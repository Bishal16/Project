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
public class tnSignup {

    tnSignup() {
        JFrame signfr = new JFrame("Sign up");
        signfr.setVisible(true);
        signfr.setBounds(400, 150, 600, 550);
        signfr.setLocationRelativeTo(null);
        signfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        signfr.setLayout(null);
        signfr.setBackground(Color.GREEN);

        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        signfr.setIconImage(icon.getImage());
        JLabel name, ssn, job, working_place, phone, fam_memb, flat_no, user, pass, repass;
        JTextField Uname, Ussn, Ujob, Uwp, Uph, Ufm, Ufno, Uuser;
        JPasswordField Upass, Urepass;
        JButton create, back;

        name = new JLabel("Name");
        name.setBounds(100, 50, 100, 30);
        name.setFont(new Font("Helvetica", Font.PLAIN, 14));

        ssn = new JLabel("SSN");
        ssn.setBounds(100, 90, 100, 30);
        ssn.setFont(new Font("Helvetica", Font.PLAIN, 14));

        job = new JLabel("Job");
        job.setBounds(100, 130, 100, 30);
        job.setFont(new Font("Helvetica", Font.PLAIN, 14));

        working_place = new JLabel("Working Place");
        working_place.setBounds(100, 170, 100, 30);
        working_place.setFont(new Font("Helvetica", Font.PLAIN, 14));

        phone = new JLabel("Phone");
        phone.setBounds(100, 210, 100, 30);
        phone.setFont(new Font("Helvetica", Font.PLAIN, 14));

        fam_memb = new JLabel("No of Family Member");
        fam_memb.setBounds(100, 250, 150, 30);
        fam_memb.setFont(new Font("Helvetica", Font.PLAIN, 14));

        flat_no = new JLabel("Flat No.");
        flat_no.setBounds(100, 290, 150, 30);
        flat_no.setFont(new Font("Helvetica", Font.PLAIN, 14));

        user = new JLabel("User Name");
        user.setBounds(100, 330, 100, 30);
        user.setFont(new Font("Helvetica", Font.PLAIN, 14));

        pass = new JLabel("Password");
        pass.setBounds(100, 370, 100, 30);
        pass.setFont(new Font("Helvetica", Font.PLAIN, 14));

        repass = new JLabel("Retype Password");
        repass.setBounds(100, 410, 100, 30);
        repass.setFont(new Font("Helvetica", Font.PLAIN, 14));

        signfr.add(name);
        signfr.add(working_place);
        signfr.add(job);
        signfr.add(fam_memb);
        signfr.add(ssn);
        signfr.add(phone);
        signfr.add(user);
        signfr.add(pass);
        signfr.add(repass);
        signfr.add(flat_no);
        //signfr.add(name,ssn,working_place,job,phone,fam_memb);
        //Uname,Ussn,Uwp,Uph,Ufm,Uuser,Upass,Urepass
        Uname = new JTextField();
        Uname.setBounds(300, 50, 130, 20);
        Uname.setBorder(null);
        signfr.add(Uname);

        Ussn = new JTextField();
        Ussn.setBounds(300, 90, 130, 20);
        Ussn.setBorder(null);
        signfr.add(Ussn);

        Ujob = new JTextField();
        Ujob.setBounds(300, 130, 130, 20);
        Ujob.setBorder(null);
        signfr.add(Ujob);

        Uwp = new JTextField();
        Uwp.setBounds(300, 170, 130, 20);
        Uwp.setBorder(null);
        signfr.add(Uwp);

        Uph = new JTextField();
        Uph.setBounds(300, 210, 130, 20);
        Uph.setBorder(null);
        signfr.add(Uph);

        Ufm = new JTextField();
        Ufm.setBounds(300, 250, 130, 20);
        Ufm.setBorder(null);
        signfr.add(Ufm);

        Ufno = new JTextField();
        Ufno.setBounds(300, 290, 130, 20);
        Ufno.setBorder(null);
        signfr.add(Ufno);

        Uuser = new JTextField();
        Uuser.setBounds(300, 330, 130, 20);
        Uuser.setBorder(null);
        signfr.add(Uuser);

        Upass = new JPasswordField();
        Upass.setBounds(300, 370, 130, 20);
        Upass.setBorder(null);
        signfr.add(Upass);

        Urepass = new JPasswordField();
        Urepass.setBounds(300, 410, 130, 20);
        Urepass.setBorder(null);
        signfr.add(Urepass);

        //
        create = new JButton("Create Account");
        create.setBounds(150, 470, 120, 25);
        create.setFont(new Font("tahoma", Font.PLAIN, 12));
        back = new JButton("Back");
        back.setFont(new Font("Helvetica", Font.PLAIN, 12));
        back.setBounds(350, 470, 65, 25);
        signfr.add(create);
        signfr.add(back);

        // database connectivity
        //name,ssn,job,working_place,phone,fam_memb,user,pass,repass;
        //////////////////////
        create.addActionListener((ActionEvent e) -> {
            String Tname = Uname.getText();
            //String Tssn,Tjob,Twp,Tph,Tfm,Tuser,Tpass,Trepass;
            String Tssn = Ussn.getText();
            String Tjob = Ujob.getText();
            String Twp = Uwp.getText();
            String Tph = Uph.getText();
            String Tfm = Ufm.getText();
            String Tfno = Ufno.getText();
            String Tuser = Uuser.getText();
            String Tpass = Upass.getText();
            String Trepass = Urepass.getText();

            //System.out.println(Tuser);//+"  "+Tjob+"  "+Twp+"  "+Tph+"  "+Tfm+"  "+Tuser+"  "+Tpass+"  "+Trepass);
            int passlen = Tpass.length();

            if (Tname.isEmpty() || Tssn.isEmpty() || Tjob.isEmpty() || Twp.isEmpty() || Tph.isEmpty() || Tfm.isEmpty() || Tfno.isEmpty() || Tuser.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please,Fill all the information", "Alert", JOptionPane.ERROR_MESSAGE);
                
            } else if (passlen < 4) {
                JOptionPane.showMessageDialog(null, "use a password of atlest 4 character", "Alert", JOptionPane.ERROR_MESSAGE);
            } else if (!Tpass.equals(Trepass) ) {
                JOptionPane.showMessageDialog(null, "password not matched!!", "Error", JOptionPane.ERROR_MESSAGE);
                Upass.setText("");
                Urepass.setText("");
            } else {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection c = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = c.createStatement();

                    st.execute("insert into tenant VALUES ('" + Tname + "','" + Tssn + "','" + Tjob + "','" + Twp + "','" + Tph + "','" + Tfm + "','" + Tfno + "','" + Tuser + "','" + Tpass + "' );");

                    st.close();
                    c.close();
                    JOptionPane.showMessageDialog(null, "Your information has added to database", "info added", JOptionPane.PLAIN_MESSAGE);
                    Uname.setText("");
                    Ussn.setText("");
                    Uwp.setText("");
                    Uph.setText("");
                    Ujob.setText("");
                    Ufm.setText("");
                    Ufno.setText("");
                    Uuser.setText("");
                    Upass.setText("");
                    Urepass.setText("");

                } catch (Exception ex) {

                }

            }

        });
        back.addActionListener((ActionEvent e) -> {

            signfr.setVisible(false);
            tnLogin tup = new tnLogin();

        });

    }

}
