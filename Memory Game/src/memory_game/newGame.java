/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory_game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mahathir Bishal
 */
public class newGame extends JFrame {

    public JButton[] btn = new JButton[17];
    public int btn_txt[] = new int[17];
    public int clk_time = 0;
    public int result = 0;
    public char pre_txt = ' ';
    public int pre_btn = 0;
    public int Time;
    public Container c;
    private JButton exit_btn, rs_btn;
    private Cursor cursor;
    private JLabel countdown,timer_lbl;
    private Icon pre_icon, mainIcoTxt;

    private ImageIcon img, back_home, reset_ico,timer_ico;
    private ImageIcon common = new ImageIcon(getClass().getResource("common.jpg"));
    private ImageIcon p1 = new ImageIcon(getClass().getResource("1.png"));
    private ImageIcon p2 = new ImageIcon(getClass().getResource("2.png"));
    private ImageIcon p3 = new ImageIcon(getClass().getResource("3.png"));
    private ImageIcon p4 = new ImageIcon(getClass().getResource("4.png"));
    private ImageIcon p5 = new ImageIcon(getClass().getResource("5.png"));
    private ImageIcon p6 = new ImageIcon(getClass().getResource("6.png"));
    private ImageIcon p7 = new ImageIcon(getClass().getResource("7.png"));
    private ImageIcon p8 = new ImageIcon(getClass().getResource("8.png"));

    JFrame nfFrame = new JFrame("New Game");

    
    //
    public void NewGame()  throws Exception{

        nfFrame.setVisible(true);
        nfFrame.setSize(650, 550);
        nfFrame.setLocationRelativeTo(null);
        nfFrame.setResizable(false);
        nfFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon.jpg"));
        nfFrame.setIconImage(icon.getImage());
        c = new Container();
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.magenta);
        nfFrame.add(c);

        JPanel panel = new JPanel();
        panel.setBounds(200, 100, 400, 400);
        int row = 4, col = 4;
        panel.setLayout(new GridLayout(row, col, 2, 2));
        //panel.setBackground(Color.cyan);
        panel.setOpaque(false);
        c.add(panel);

        cursor = new Cursor(Cursor.HAND_CURSOR);
        back_home = new ImageIcon(getClass().getResource("backHome.png"));
        reset_ico = new ImageIcon(getClass().getResource("reset.png"));

        exit_btn = new JButton(back_home);
        exit_btn.setBounds(80, 400, 50, 50);
        exit_btn.setContentAreaFilled(false);
        exit_btn.setBorderPainted(false);
        exit_btn.setToolTipText("Back To Home");
        exit_btn.setCursor(cursor);
        c.add(exit_btn);

        rs_btn = new JButton(reset_ico);
        rs_btn.setBounds(55, 460, 100, 27);
        rs_btn.setToolTipText("Reset Game");
        rs_btn.setContentAreaFilled(false);
        rs_btn.setBorderPainted(false);
        rs_btn.setCursor(cursor);
        c.add(rs_btn);

        rs_btn.addActionListener((ActionEvent e) -> {
            nfFrame.dispose();
            Memory_Game m = new Memory_Game();
            m.call_new_game();

        });

        exit_btn.addActionListener((ActionEvent e) -> {
            nfFrame.setVisible(false);
            //Memory_Game m=new Memory_Game();
            Memory_Game.main(new String[0]);
        });

        for (int i = 1; i <= 16; i++) {
            btn[i] = new JButton();
            btn[i].setBackground(Color.white);
            btn[i].setFocusPainted(false);
            btn[i].setIcon(common);
            panel.add(btn[i]);
        }

        ArrayList numbers = new ArrayList();
        for (int i = 0; i < 16; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 16; i++) {
            int s = (Integer) numbers.get(i);
            //btn[s].setText((i + 2) / 2 + "");
            //btn[s].setIcon(pre_icon);
            //System.out.println(i + 2 / 2);

            switch ((i + 2) / 2) {
                case 1:
                    btn[s].setIcon(p1);
                    break;

                case 2:
                    btn[s].setIcon(p2);
                    break;

                case 3:
                    btn[s].setIcon(p3);
                    break;

                case 4:
                    btn[s].setIcon(p4);
                    break;

                case 5:
                    btn[s].setIcon(p5);
                    break;

                case 6:
                    btn[s].setIcon(p6);
                    break;

                case 7:
                    btn[s].setIcon(p7);
                    break;

                case 8:
                    btn[s].setIcon(p8);
                    break;
            }

            btn_txt[s] = (i + 2) / 2;
        }

        Font f = new Font("Arial", Font.BOLD, 50);
        countdown = new JLabel();
        countdown.setBounds(110, 100, 90, 70);
        countdown.setOpaque(false);
        countdown.setFont(f);
        countdown.setForeground(Color.white);
        c.add(countdown);
        
        timer_ico = new ImageIcon(getClass().getResource("timer.png"));
        timer_lbl=new JLabel(timer_ico);
        timer_lbl.setBounds(10,80,90,100);
        c.add(timer_lbl);

        img = new ImageIcon(getClass().getResource("ngbg.png"));

        final JLabel bg_lbl = new JLabel(img);
        bg_lbl.setBounds(0, 0, 650, 550);
        bg_lbl.setOpaque(true);
        bg_lbl.setBackground(Color.blue);
        c.add(bg_lbl);

        ActionListener timer = new ActionListener() {
            int time = 10000;
            int step = 1;

            public void actionPerformed(ActionEvent ae) {
                if (time == 0 && step == 1) {
                    time = 60000;
                    step = 2;
                    //System.out.println("kjjjjjjjjjjj");
                    //removing text
                    for (int i = 0; i < 16; i++) {
                        /// btn[i + 1].setText("");
                        btn[i + 1].setIcon(common);
                    }
                } else if (time == 0 && step == 2 && result < 8) {
                    //countdown.setText("game over");
                    ((Timer) ae.getSource()).stop();
                    //nfFrame.setVisible(false);
                }
                time -= 100;
                Time = time;
                if (time > 0 && result < 8) {
                    countdown.setText( Integer.toString(time / 1000) + "s");
                }
            }
        };
        new javax.swing.Timer(100, timer).start();

        actionListeners();
    }

    private void actionListeners() {
        btn[1].addActionListener((ActionEvent e) -> {
            button_action(1);
        });
        btn[2].addActionListener((ActionEvent e) -> {
            button_action(2);
        });
        btn[3].addActionListener((ActionEvent e) -> {
            button_action(3);
        });
        btn[4].addActionListener((ActionEvent e) -> {
            button_action(4);
        });
        btn[5].addActionListener((ActionEvent e) -> {
            button_action(5);
        });
        btn[6].addActionListener((ActionEvent e) -> {
            button_action(6);
        });
        btn[7].addActionListener((ActionEvent e) -> {
            button_action(7);
        });
        btn[8].addActionListener((ActionEvent e) -> {
            button_action(8);
        });
        btn[9].addActionListener((ActionEvent e) -> {
            button_action(9);
        });
        btn[10].addActionListener((ActionEvent e) -> {
            button_action(10);
        });
        btn[11].addActionListener((ActionEvent e) -> {
            button_action(11);
        });
        btn[12].addActionListener((ActionEvent e) -> {
            button_action(12);
        });
        btn[13].addActionListener((ActionEvent e) -> {
            button_action(13);
        });
        btn[14].addActionListener((ActionEvent e) -> {
            button_action(14);
        });
        btn[15].addActionListener((ActionEvent e) -> {
            button_action(15);
        });
        btn[16].addActionListener((ActionEvent e) -> {
            button_action(16);
        });
    }

    public void button_action(int n) {
        //if(btn[n].getText()=="")
        if (btn[n].getIcon() == common) {
            clk_time++;
            if (clk_time == 1) {
                ///btn[n].setText(btn_txt[n] + "");

                switch (btn_txt[n]) {
                    case 1:
                        btn[n].setIcon(p1);
                        pre_icon = p1;
                        break;

                    case 2:
                        btn[n].setIcon(p2);
                        pre_icon = p2;
                        break;

                    case 3:
                        btn[n].setIcon(p3);
                        pre_icon = p3;
                        break;

                    case 4:
                        btn[n].setIcon(p4);
                        pre_icon = p4;
                        break;

                    case 5:
                        btn[n].setIcon(p5);
                        pre_icon = p5;
                        break;

                    case 6:
                        btn[n].setIcon(p6);
                        pre_icon = p6;
                        break;

                    case 7:
                        btn[n].setIcon(p7);
                        pre_icon = p7;
                        break;

                    case 8:
                        btn[n].setIcon(p8);
                        pre_icon = p8;
                        break;

                }

                //btn[n].setBackground(Color.cyan);
                /// pre_txt = (char) btn_txt[n];
                pre_btn = n;
            }
            if (clk_time == 2) {
                clk_time = 0;
                ///btn[n].setText(btn_txt[n] + "");
                //btn[n].setBackground(Color.cyan);
                //btn[n].setIcon();
                //btn[n].setIcon

                //if (btn_txt[n] == pre_txt) 
                switch (btn_txt[n]) {
                    case 1:
                        btn[n].setIcon(p1);
                        mainIcoTxt = p1;
                        break;

                    case 2:
                        btn[n].setIcon(p2);
                        mainIcoTxt = p2;
                        break;

                    case 3:
                        btn[n].setIcon(p3);
                        mainIcoTxt = p3;
                        break;

                    case 4:
                        btn[n].setIcon(p4);
                        mainIcoTxt = p4;
                        break;

                    case 5:
                        btn[n].setIcon(p5);
                        mainIcoTxt = p5;
                        break;

                    case 6:
                        btn[n].setIcon(p6);
                        mainIcoTxt = p6;
                        break;

                    case 7:
                        btn[n].setIcon(p7);
                        mainIcoTxt = p7;
                        break;

                    case 8:
                        btn[n].setIcon(p8);
                        mainIcoTxt = p8;
                        break;
                }

                if (mainIcoTxt == pre_icon) {
                    result++;
                    if (result == 8) {
                        int used_time = (Time) / 1000;
                       // JOptionPane.showMessageDialog(null, "You are done and your "
                         //       + "score :" + used_time);
                        JFrame scorFr=new JFrame("score");
                        scorFr.setSize(350,200);
                        scorFr.setVisible(true);
                        scorFr.setLayout(null);
                        scorFr.getContentPane().setBackground(Color.gray);
                        scorFr.setResizable(false);
                        scorFr.setLocationRelativeTo(null);
                        
                        Font f=new Font("tahoma",Font.PLAIN,37);
                        JLabel scr=new JLabel();
                        scr.setBounds(50,30,300,100);
                        scr.setForeground(Color.green);
                        scr.setOpaque(false);
                        scr.setFont(f);
                        scr.setText("Your Score : "+Time/1000);
                        scorFr.add(scr);
                        
                        JButton ok=new JButton();
                        ok.setBounds(150,130,50,30);
                        ok.setText("Ok");
                        ok.setBackground(Color.green);
                        ok.setFocusPainted(false);
                        ok.setBorder(null);
                        scorFr.add(ok);
                        ok.addActionListener((ActionEvent e) ->{
                        scorFr.setVisible(false);
                        });

                    }
                } //else if (btn_txt[n] != pre_txt) 
                else if(mainIcoTxt != pre_icon){
                    ///btn[n].setText(btn_txt[n] + "");
                    //pause p = new pause();
                    //p.mainn();

                    ///btn[n].setText("");
                    //btn[pre_btn].setText("");
                    ///btn[n].setBackground(Color.magenta);
                    ///btn[pre_btn].setBackground(Color.magenta);
                    ///pre_btn = 0;
                    btn[n].setIcon(common);
                    btn[pre_btn].setIcon(common);
                    pre_btn = 0;

                    // System.out.println("");
                }
            }
        }//first if

    }

}
