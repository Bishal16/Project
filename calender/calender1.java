package calender;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class calender1 extends JFrame {

    JFrame YMframe = new JFrame();
    JFrame inframe = new JFrame();

    int weekDay, year, month, mon, i, week = 0, cYear, cMonth, cDay;
    int month_p[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int monthDay[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private Container c;
    private ImageIcon imgIcon, monthImg, nxtMonth, preMonth, nxtYear, preYear, DevIcon, yminput, ttMon_yr, crMon_yr;
    private JTextArea ta, mta, yta, devta, JumpMon, Jumpta;
    private JTextField ytf;
    private JLabel imgLabel;
    private JPanel panel;
    private JButton nextMonth, prevMonth, nextYear, prevYear, YMinput, Developer, crMOn, anyMon;
    private Font f, df;
    private JComboBox cb;

    calender1() {
        initcomponents();
        print();
    }

    public void initcomponents() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 10, 550, 700);
        this.setTitle("Calendar v 0.3");
        imgIcon = new ImageIcon(getClass().getResource("calenderIcon.jpg"));
        this.setIconImage(imgIcon.getImage());
        this.setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        panel.setBounds(100, 100, 350, 240);
        panel.setBackground(Color.lightGray);
        c.add(panel);

        ta = new JTextArea();
        ta.setBounds(100, 390, 350, 250);
        ta.setBackground(Color.LIGHT_GRAY);
        f = new Font("Arial", Font.BOLD, 16);
        ta.setFont(f);
        ta.setEditable(false);
        c.add(ta);

        mta = new JTextArea();
        mta.setBounds(100, 350, 150, 40);
        mta.setBackground(Color.LIGHT_GRAY);
        f = new Font("Arial", Font.BOLD, 24);
        mta.setFont(f);
        mta.setEditable(false);
        c.add(mta);

        yta = new JTextArea();
        yta.setBounds(230, 30, 90, 45);
        yta.setBackground(Color.lightGray);
        f = new Font("Arial", Font.BOLD + Font.ITALIC, 36);
        yta.setFont(f);
        yta.setEditable(false);
        c.add(yta);

        nxtMonth = new ImageIcon(getClass().getResource("nextMbutton.png"));
        preMonth = new ImageIcon(getClass().getResource("prevMbutton.png"));
        nxtYear = new ImageIcon(getClass().getResource("nextYbutton.png"));
        preYear = new ImageIcon(getClass().getResource("prevYbutton.png"));
        yminput = new ImageIcon(getClass().getResource("jumpButton.png"));
        DevIcon = new ImageIcon(getClass().getResource("DevInfo.png"));

        prevMonth = new JButton(preMonth);
        prevMonth.setBounds(30, 350, 50, 50);
        prevMonth.setToolTipText("Back to previous MONTH");
        prevMonth.setBackground(Color.LIGHT_GRAY);
        prevMonth.setBorderPainted(false);
        prevMonth.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(prevMonth);

        nextMonth = new JButton(nxtMonth);
        nextMonth.setBounds(470, 350, 50, 50);
        nextMonth.setToolTipText("GO to next month");
        nextMonth.setBackground(Color.LIGHT_GRAY);
        nextMonth.setBorderPainted(false);
        nextMonth.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(nextMonth);

        prevYear = new JButton(preYear);
        prevYear.setBounds(185, 35, 30, 30);
        prevYear.setToolTipText("Back to previous YEAR");
        prevYear.setBackground(Color.LIGHT_GRAY);
        prevYear.setBorderPainted(false);
        prevYear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(prevYear);

        nextYear = new JButton(nxtYear);
        nextYear.setBounds(325, 35, 30, 30);
        nextYear.setToolTipText("GO to next year");
        nextYear.setBackground(Color.LIGHT_GRAY);
        nextYear.setBorderPainted(false);
        nextYear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(nextYear);

        YMinput = new JButton(yminput);
        YMinput.setBounds(470, 450, 50, 50);
        YMinput.setToolTipText("jump to any year");
        YMinput.setBackground(Color.LIGHT_GRAY);
        YMinput.setBorderPainted(false);
        YMinput.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(YMinput);

        Developer = new JButton(DevIcon);
        Developer.setBounds(475, 600, 50, 50);
        Developer.setToolTipText("About Developer");
        Developer.setBackground(Color.LIGHT_GRAY);
        Developer.setBorderPainted(false);
        Developer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.add(Developer);

        //starts action click listener
        nextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mon++;
                if (mon > 11) {
                    mon = 0;
                    year++;
                }
                print();
            }
        });
        prevMonth.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {

                mon--;
                if (mon < 0) {
                    mon = 11;
                    year--;
                }
                print();
            }
        });
        nextYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                year++;
                print();
            }
        });
        prevYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                year--;
                print();
            }
        });
        YMinput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                YMframe.setVisible(true);
                YMframe.setBounds(455, 250, 450, 260);
                YMframe.setLayout(null);
                YMframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                YMframe.getContentPane().setBackground(Color.lightGray);
                YMframe.setTitle("Current or Jump to any month");
                YMframe.setResizable(false);
                imgIcon = new ImageIcon(getClass().getResource("calenderIcon.jpg"));
                YMframe.setIconImage(imgIcon.getImage());

                ttMon_yr = new ImageIcon(getClass().getResource("time_travel.png"));
                crMon_yr = new ImageIcon(getClass().getResource("current_month.png"));

                crMOn = new JButton(crMon_yr);
                crMOn.setFocusable(false);
                crMOn.setBackground(Color.lightGray);
                crMOn.setBounds(115, 60, 100, 100);
                crMOn.setBorderPainted(false);
                crMOn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                crMOn.setToolTipText("Back to current Month");
                YMframe.add(crMOn);

                anyMon = new JButton(ttMon_yr);
                anyMon.setFocusable(false);
                anyMon.setBackground(Color.lightGray);
                anyMon.setBounds(255, 60, 100, 100);
                anyMon.setBorderPainted(false);
                anyMon.setCursor(new Cursor(Cursor.HAND_CURSOR));
                anyMon.setToolTipText("Jump to any year and month");
                YMframe.add(anyMon);

                f = new Font("Ariel", Font.BOLD, 18);
                Jumpta = new JTextArea("    CURRENT              JUMP");
                Jumpta.setBackground(Color.lightGray);
                Jumpta.setBounds(100, 170, 300, 40);
                Jumpta.setEditable(false);
                Jumpta.setFont(f);
                YMframe.add(Jumpta);

                crMOn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        YMframe.setVisible(false);
                        mon = cMonth - 1;
                        year = cYear;
                        print();
                    }
                });

                anyMon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        YMframe.setVisible(false);

                        JFrame inpframe = new JFrame();
                        inpframe.setLocation(455, 250);
                        inpframe.setSize(450, 260);
                        inpframe.setLayout(null);
                        inpframe.getContentPane().setBackground(Color.lightGray);
                        inpframe.setResizable(false);
                        inpframe.setTitle(" Input Year and select Month");
                        imgIcon = new ImageIcon(getClass().getResource("calenderIcon.jpg"));
                        inpframe.setIconImage(imgIcon.getImage());
                        inpframe.setVisible(true);
                        //inpframe.setBackground(Color.GREEN);
                                           
                        JumpMon = new JTextArea("Year :\n\nMonth :");
                        JumpMon.setBounds(10, 25, 80, 70);
                        JumpMon.setBackground(Color.lightGray);
                        f = new Font("Arial", Font.BOLD, 16);
                        JumpMon.setEditable(false);
                        JumpMon.setFont(f);
                        inpframe.add(JumpMon);

                        ytf = new JTextField();
                        ytf.setBounds(110, 20, 100, 30);
                        ytf.setBackground(Color.lightGray);
                        ytf.setFont(f);
                        inpframe.add(ytf);

                        cb = new JComboBox(months);
                        cb.setBounds(110, 60, 100, 30);
                        inpframe.add(cb);

                        JButton inpBtn = new JButton("OK");
                        inpBtn.setBounds(200, 160, 60, 30);
                        inpBtn.setBackground(Color.CYAN);
                        inpframe.add(inpBtn);

                        inpBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                inpframe.setVisible(false);
                                String Y = ytf.getText();
                                int inpY = Integer.parseInt(Y);
                                String selMon = cb.getSelectedItem().toString();
                                
                                if(Y.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(null, "year is empty");
                                    inpframe.setVisible(true);
                                }
                                if (inpY == 0) {
                                    JOptionPane.showMessageDialog(null, "Opps!!  year can't be 0\n");
                                    inpframe.setVisible(true);
                                }

                                if (inpY < 0) {
                                    JOptionPane.showMessageDialog(null, "Opps!!  year can't be negative\n");
                                    inpframe.setVisible(true);
                                }
                                else {

                                    year = inpY;
                                    for (int t = 0; t < 12; t++) {
                                        if (selMon == months[t]) {
                                            mon = t;
                                        }
                                    }
                                    print();
                                }

                            }
                        }
                        );
                    }
                });
            }

        });
        Developer.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                //JOptionPane.showMessageDialog(null,"HELLO WORLD","About Developer",-1);
                JFrame dframe = new JFrame();
                dframe.setVisible(true);
                dframe.setBounds(455, 250, 450, 260);
                dframe.setLayout(null);
                dframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                dframe.getContentPane().setBackground(Color.gray);
                dframe.setResizable(false);

                df = new Font("Ariel", Font.PLAIN, 15);
                devta = new JTextArea("A Natural Calener !!\nDeveloped By  'Mahathir Mohammad Bishal' \n\nAny suggestion or criticism is highly appreciated.\n\nContact :\n\tEmail : mahathir.cse16@gmail.com\n\tfb : Mahathir Bishal");
                devta.setBackground(Color.gray);
                devta.setBounds(20, 20, 410, 160);
                devta.setEditable(false);
                devta.setFont(df);
                dframe.add(devta);

                JButton btn = new JButton("OK");
                btn.setFocusable(false);
                btn.setBackground(Color.GREEN);
                btn.setLocation(200, 192);
                btn.setSize(60, 30);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                dframe.add(btn);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dframe.setVisible(false);
                    }
                });
            }
        }
        );

        ////**calender calculation starts**
        //date taking from system
        GregorianCalendar cal = new GregorianCalendar();
        cYear = cal.get(GregorianCalendar.YEAR);
        cMonth = cal.get(GregorianCalendar.MONTH);
        cDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
        cMonth = cMonth + 1;
        //System.out.println("current month is " + cMonth);

        //variable decleration
        year = cYear;
        mon = cMonth;
        week = 0;
        mon--;
        weekDay = (((year - 1) * 365) + ((year - 1) / 4) - ((year - 1) / 100) + ((year) / 400) + 1) % 7;

        ///leap year checking
        if ((year % 4 == 0 && year % 100 != 0) || (year
                % 400 == 0)) {
            monthDay[1] = 29;
        }

        int m_space[] = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        if (monthDay[1] == 29) {
            m_space[1] = 1;
        }

        //year showing
        String years = String.valueOf(year);

        yta.append(years);

        for (month = 0;
                month < 12; month++) {
            if (mon == month_p[month]) {

//               switch case
                mta.append(months[month]);
                ta.append("SAT    SUN    MON    TUE     WED    THU     FRI \n\n");

                if (weekDay != 6) {
                    for (i = 0; i <= weekDay; i++) {
                        ta.append("              ");
                        week++;
                    }
                }

                for (i = 1; i <= monthDay[mon]; i++) {
                    String I = String.valueOf(i);
                    ta.append(I);
                    if (i < 10) {
                        ta.append("           ");
                    } else {
                        ta.append("         ");
                    }
                    week++;
                    if (week > 6) {
                        ta.append("\n\n");
                        week = 0;
                    }
                }
            }

            weekDay = weekDay + m_space[month];
            weekDay = weekDay % 7;
        }
    }

    public void print() {
        //variable decleration
        ta.setText("");
        mta.setText("");
        yta.setText("");
        //year = cYear;
        //mon = cMonth;
        week = 0;
        //mon--;
        weekDay = (((year - 1) * 365) + ((year - 1) / 4) - ((year - 1) / 100) + ((year) / 400) + 1) % 7;

        ///leap year checking
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            monthDay[1] = 29;
        }
        else{
            monthDay[1] = 28;
        }

        int m_space[] = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        if (monthDay[1] == 29) {
            m_space[1] = 1;
        }

        //year showing
        String years = String.valueOf(year);
        yta.append(years);

        for (month = 0; month < 12; month++) {
            if (mon == month_p[month]) {

                int p;
                for (p = 0; p < 12; p++) {
                    if (mon == p) {
                        panel.removeAll();
                        String Ii = String.valueOf(p);
                        monthImg = new ImageIcon(getClass().getResource(Ii + ".jpg"));
                        imgLabel = new JLabel(monthImg);
                        imgLabel.setBounds(100, 100, 350, 240);
                        panel.add(imgLabel);
                    }
                }

                mta.append(months[month]);
                ta.append("SAT    SUN    MON    TUE     WED    THU     FRI \n\n");

                if (weekDay != 6) {
                    for (i = 0; i <= weekDay; i++) {
                        ta.append("              ");
                        week++;
                    }
                }

                for (i = 1; i <= monthDay[mon]; i++) {
                    String I = String.valueOf(i);
                    ta.append(I);

                    if (weekDay >= 4 && i == 5) {
                        ta.append("              ");
                    } else if (i < 10) {
                        ta.append("           ");
                    } else {
                        ta.append("         ");
                    }
                    week++;
                    if (week > 6) {
                        ta.append("\n\n");
                        week = 0;
                    }
                }
            }
            weekDay = weekDay + m_space[month];
            weekDay = weekDay % 7;
        }
    }

    public static void main(String[] args) {
        calender1 frame = new calender1();
        frame.setVisible(true);
    }
}
