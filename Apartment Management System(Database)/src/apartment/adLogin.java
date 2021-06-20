package apartment;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mahathir Bishal
 */
public class adLogin extends JFrame{
    
    private ImageIcon ad_log_ico,login_ico;
    private JLabel ad_log_bg_lbl;
    private Container c;
    private Cursor cursor;
    
    JFrame adLogfr = new JFrame("Admin Login");
    public void AdLogin() {
        
        adLogfr.setVisible(true);
        adLogfr.setSize(600, 400);
        adLogfr.setLocationRelativeTo(null);
        adLogfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        adLogfr.setResizable(false);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        adLogfr.setIconImage(icon.getImage());
        
        c=new Container();
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.red);
        adLogfr.add(c);
        
        Font f=new Font("tahoma",Font.PLAIN, 15);
        cursor=new Cursor(Cursor.HAND_CURSOR);
        
        JLabel header=new JLabel("Admin Login");
        header.setBounds(210,20,200,60);
        header.setFont(new Font("tahoma",Font.PLAIN, 25));
        c.add(header);
        
        JTextField user_name = new JTextField("Admin Name :");
        user_name.setBounds(145, 100, 100, 30);
        user_name.setEditable(false);
        user_name.setOpaque(false);
        user_name.setFont(f);
        user_name.setBorder(null);
        c.add(user_name);

        JTextField pass = new JTextField("Password :");
        pass.setBounds(145, 150, 100, 30);;
        pass.setEditable(false);
        pass.setOpaque(false);
        pass.setFont(f);
        pass.setBorder(null);
        c.add(pass);

        JTextField userf = new JTextField("hafiz");
        userf.setBounds(290, 105, 110, 25);
        userf.setFont(f);
        userf.setOpaque(false);
        c.add(userf);

        JPasswordField passf = new JPasswordField("1234");
        passf.setBounds(290, 155, 110, 25);
        passf.setFont(f);
        passf.setOpaque(false);
        c.add(passf);

        login_ico=new ImageIcon(getClass().getResource("icon/login.png"));
        JButton loginbtn = new JButton(login_ico);
        loginbtn.setBounds(230, 250, 100, 27);
        loginbtn.setBorder(null);
        loginbtn.setContentAreaFilled(false);
        loginbtn.setCursor(cursor);
        loginbtn.setToolTipText("Cloick to Login");
        c.add(loginbtn);

        JButton signbtn = new JButton("Sign Up");
        signbtn.setBounds(215, 280, 130, 20);
        signbtn.setFont(new Font("Helvetica", Font.PLAIN, 14));
        // adLogfr.add(signbtn);
        
        ad_log_ico=new ImageIcon(getClass().getResource("icon/ad_login.png"));
        ad_log_bg_lbl=new JLabel(ad_log_ico);
        ad_log_bg_lbl.setBounds(0,0,600,400);
        c.add(ad_log_bg_lbl);

        
        loginbtn.addActionListener((ActionEvent e) -> {
            if (userf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "User name is Empty");
            } else if (passf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password is Empty");
            } else {
                try {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/apartment_management", "pma", "");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT user_name , password FROM admin");
                    int row = 0, count = 0;

                    while (rs.next()) {
                        row++;
                        String name = userf.getText();
                        String password = passf.getText();

                        String usr = rs.getString("user_name");
                        String pas = rs.getString("Password");

                        if (usr.equals(name) && pas.equals(password)) {
                            adLogfr.setVisible(false);
                            adAccount adAc = new adAccount();
                        }
                    }
                } catch (Exception ep) {
                    JOptionPane.showMessageDialog(null, ep);

                }

            }

        });
    }

}
