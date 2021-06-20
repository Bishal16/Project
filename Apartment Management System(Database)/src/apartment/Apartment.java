/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment;

/**
 *
 * @author Mahathir Bishal
 */
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Apartment extends JFrame {

    private JButton adbtn,tnbtn,empbtn;
    private JLabel Home_bg_lbl,admin_lbl,tenant_lbl,emp_lbl;
    private ImageIcon home_ico,admin_ico,tenant_ico,emp_ico;
    private Cursor cursor;
    private Container c;
    Apartment()
    {
        initcomponents();
    }
    
    public void initcomponents()
    {
        
        c=new Container();
        c=getContentPane();
        c.setLayout(null);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon/icon.png"));
        this.setIconImage(icon.getImage());
        
        cursor=new Cursor(Cursor.HAND_CURSOR);
        
        Font f=(new Font("Helvetica", Font.PLAIN, 20));
        JLabel label1 = new JLabel("WELLCOME");
        JLabel label2 = new JLabel("TO");
        JLabel label3 = new JLabel("APARTMENT MANAGEMNET SYSTEM");
        label1.setBounds(270, 10, 130, 100);
        label2.setBounds(315, 40, 60, 100);
        label3.setBounds(160, 70, 500, 100);
        label1.setFont(f);
        label2.setFont(f);
        label3.setFont(f);

        c.add(label1);
        c.add(label2);
        c.add(label3);
     
        admin_ico=new ImageIcon(getClass().getResource("icon/admin.png"));
        tenant_ico=new ImageIcon(getClass().getResource("icon/tenant.png"));
        emp_ico=new ImageIcon(getClass().getResource("icon/employee.png"));
        
        admin_lbl=new JLabel("Admin");
        admin_lbl.setBounds(130, 330, 90, 30);
        admin_lbl.setOpaque(false);
        c.add(admin_lbl);
        tenant_lbl=new JLabel("Tenant");
        tenant_lbl.setBounds(320, 330, 90, 30);
        tenant_lbl.setOpaque(false);
        c.add(tenant_lbl);
        emp_lbl=new JLabel("Employee");
        emp_lbl.setBounds(510,330,90,30);
        emp_lbl.setOpaque(false);
        c.add(emp_lbl);
        
        
        Font Btn_font=new Font("tahoma", Font.PLAIN, 15);
        adbtn = new JButton(admin_ico);
        adbtn.setBounds(90,220,110,110);
        adbtn.setOpaque(false);
        adbtn.setBorder(null);
        adbtn.setCursor(cursor);
        adbtn.setContentAreaFilled(false);
        adbtn.setFocusPainted(false);
        adbtn.setFont(Btn_font);
        c.add(adbtn);

        tnbtn = new JButton(tenant_ico);
        tnbtn.setBounds(290,220,110,110);
        tnbtn.setFocusPainted(false);
        tnbtn.setBorder(null);
        tnbtn.setCursor(cursor);
        tnbtn.setContentAreaFilled(false);
        tnbtn.setFocusPainted(false);
        tnbtn.setFont(Btn_font);
        c.add(tnbtn);

        empbtn=new JButton(emp_ico);
        empbtn.setBounds(490,220,110,110);
        empbtn.setBorder(null);
        empbtn.setCursor(cursor);
        empbtn.setFocusPainted(false);
        empbtn.setContentAreaFilled(false);
        c.add(empbtn);
        
        home_ico=new ImageIcon(getClass().getResource("icon/home.png"));
        Home_bg_lbl=new JLabel(home_ico);
        Home_bg_lbl.setBounds(0,0,700,450);
        c.add(Home_bg_lbl);

        adbtn.addActionListener((ActionEvent e) -> {

            adLogin adLog = new adLogin();
            this.setVisible(false);
            adLog.AdLogin();
        });

        tnbtn.addActionListener((ActionEvent e) -> {

            tnLogin tl = new tnLogin();
            this.setVisible(false);
        });
        
        empbtn.addActionListener((ActionEvent e) -> {

            empLogin el = new empLogin();
            this.setVisible(false);
        });
        
    }
    
    
    public static void main(String[] args) {

        Apartment frame = new Apartment();
        frame.setTitle("Apartment Management System");
        frame.setVisible(true);
        frame.setBounds(300, 100, 700, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        
        

    }

}
