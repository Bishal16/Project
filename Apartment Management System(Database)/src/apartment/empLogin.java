/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mahathir Bishal
 */
public class empLogin extends JFrame{
    
    
        private String usr,pas;
    private ImageIcon login_ico;
    private JLabel tn_bg_lbl;
    private Container c;
    
    public empLogin () 
    {
        JFrame logfr = new JFrame("Employee Login");
        logfr.setVisible(true);
        logfr.setBounds(400, 200, 600, 400);
        logfr.setLocationRelativeTo(null);
        logfr.setResizable(false);
        logfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        logfr.setIconImage(icon.getImage());
        
        c=new Container();
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.red);
        logfr.add(c);
        
        JLabel header=new JLabel("Employee Login");
        header.setBounds(200,20,200,60);
        header.setFont(new Font("tahoma",Font.PLAIN, 25));
        c.add(header);

        
        Font f=new Font("",Font.PLAIN,15);
        JTextField user_name = new JTextField("Name :");
        user_name.setBounds(125, 100, 100, 30);
        user_name.setEditable(false);
        user_name.setFont(f);
        user_name.setBorder(null);
        user_name.setOpaque(false);
        c.add(user_name);

        JTextField pass = new JTextField("Password :");
        pass.setBounds(125, 150, 100, 30);
        pass.setEditable(false);
        pass.setFont(f);
        pass.setBorder(null);
        pass.setOpaque(false);
        c.add(pass);

        JTextField userf = new JTextField("Faruk");
        userf.setBounds(290, 105, 110, 25);
        userf.setOpaque(false);
        userf.setFont(f);
        c.add(userf);

        JPasswordField passf = new JPasswordField("1234");
        passf.setBounds(290, 155, 110, 25);
        passf.setOpaque(false);
        passf.setFont(f);
        c.add(passf);

        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(215, 250, 130, 20);
        loginbtn.setFont(new Font("Helvetica", Font.PLAIN, 12));
        c.add(loginbtn);

        JButton signbtn = new JButton("Sign Up");
        signbtn.setBounds(215, 280, 130, 20);
        signbtn.setFont(new Font("Helvetica", Font.PLAIN, 12));
        c.add(signbtn);
        
        login_ico=new ImageIcon(getClass().getResource("icon/ad_login.png"));
        
        tn_bg_lbl=new JLabel(login_ico);
        tn_bg_lbl.setBounds(0,0,600,400);
        c.add(tn_bg_lbl);

        loginbtn.addActionListener((ActionEvent e) -> {
            if (userf.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "User name is Empty");
            }
            if (passf.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Password is Empty");
            } 
            else 
            {
                try 
                {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM employee");
                    int row = 0, count = 0;

                    while (rs.next()) 
                    {
                        row++;
                        String name = userf.getText();
                        String password = passf.getText();

                         usr = rs.getString("user_name");
                         pas = rs.getString("password");
                 
                        if (usr.equals(name) && pas.equals(password)) 
                        {
                            logfr.setVisible(false);
                            empAccount ea = new empAccount();
                            ea.Account(usr,pas);
                        } 
                        else 
                        {
                            count++;
                        }
                    }

                    if (count == row) {
                        JOptionPane.showMessageDialog(null, "Password not matched");
                    }
                    st.close();
                    con.close();

                }
                catch (Exception ep) 
                {
                    JOptionPane.showMessageDialog(null, ep);
                }
            }

        });
        signbtn.addActionListener((ActionEvent e) -> {
            logfr.setVisible(false);
            empSignup esu = new empSignup();

        });

    }
    
}
