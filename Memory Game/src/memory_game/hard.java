
package memory_game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Cursor;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class hard {

    public JButton[] btn = new JButton[37];
    public int btn_txt[] = new int[37];
    public int clk_time = 0, Time, result = 0, pre_btn = 0;
    public char pre_txt = ' ';
    public Container c;
    
    private ImageIcon img, back_home, reset_ico,timer_ico;
    private Cursor cursor;
    private JButton exit_btn,rs_btn;
    private JLabel timer_lbl;

    public void NewGame() throws InterruptedException {

        JFrame nfFrame = new JFrame("New Game");
        nfFrame.setVisible(true);
        nfFrame.setSize(650, 550);
        nfFrame.setLocationRelativeTo(null);
        nfFrame.setResizable(false);
        nfFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("icon.jpg"));
        nfFrame.setIconImage(icon.getImage());
        //
        c = new Container();
       
        c.setLayout(null);
        nfFrame.add(c);
        
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
            m.call_hard_game();

        });

        exit_btn.addActionListener((ActionEvent e) -> {
            nfFrame.setVisible(false);
            Memory_Game.main(new String[8]);
        });


        JPanel panel = new JPanel();
        panel.setBounds(200, 100, 400, 400);
        int row = 6, col = 6;
        panel.setLayout(new GridLayout(row, col, 2, 2));
        
        panel.setOpaque(false);
        c.add(panel);

        for (int i = 1; i <= 36; i++) {
            btn[i] = new JButton();
            btn[i].setFont(new Font("tahoma", Font.PLAIN, 25));
            btn[i].setBackground(Color.magenta);
            btn[i].setFocusPainted(false);
            panel.add(btn[i]);
        }

        ArrayList numbers = new ArrayList();
        for (int i = 0; i < 36; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 36; i++) {
            int s = (Integer) numbers.get(i);
            btn[s].setText((i + 2) / 2 + "");
            btn_txt[s] = (i + 2) / 2;
        }

        Font f = new Font("Arial", Font.BOLD, 50);
        final JLabel countdown = new JLabel();
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
            int time = 16000;
            int step = 1;

            public void actionPerformed(ActionEvent ae) {
                if (time == 0 && step == 1) {
                    time = 60000;
                    step = 2;

                    //removing text
                    for (int i = 0; i < 36; i++) {
                        btn[i + 1].setText("");
                    }
                } else if (time == 0 && step == 2&& result < 18) {
                    //System.out.println("kkkkkkk");
                    //countdown.setText("game over");
                    ((Timer) ae.getSource()).stop();
                    //nfFrame.setVisible(false);
                }
                time -= 100;
                Time = time;
                if (time > 0&& result < 18) {
                    countdown.setText(Integer.toString(time / 1000) + "s");
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
        btn[17].addActionListener((ActionEvent e) -> {
            button_action(17);
        });
        btn[18].addActionListener((ActionEvent e) -> {
            button_action(18);
        });
        btn[19].addActionListener((ActionEvent e) -> {
            button_action(19);
        });
        btn[20].addActionListener((ActionEvent e) -> {
            button_action(20);
        });
        btn[21].addActionListener((ActionEvent e) -> {
            button_action(21);
        });
        btn[22].addActionListener((ActionEvent e) -> {
            button_action(22);
        });
        btn[23].addActionListener((ActionEvent e) -> {
            button_action(23);
        });
        btn[24].addActionListener((ActionEvent e) -> {
            button_action(24);
        });
        btn[25].addActionListener((ActionEvent e) -> {
            button_action(25);
        });
        btn[26].addActionListener((ActionEvent e) -> {
            button_action(26);
        });
        btn[27].addActionListener((ActionEvent e) -> {
            button_action(27);
        });
        btn[28].addActionListener((ActionEvent e) -> {
            button_action(28);
        });
        btn[29].addActionListener((ActionEvent e) -> {
            button_action(29);
        });
        btn[30].addActionListener((ActionEvent e) -> {
            button_action(30);
        });
        btn[31].addActionListener((ActionEvent e) -> {
            button_action(31);
        });
        btn[32].addActionListener((ActionEvent e) -> {
            button_action(32);
        });
        btn[33].addActionListener((ActionEvent e) -> {
            button_action(33);
        });
        btn[34].addActionListener((ActionEvent e) -> {
            button_action(34);
        });
        btn[35].addActionListener((ActionEvent e) -> {
            button_action(35);
        });
        btn[36].addActionListener((ActionEvent e) -> {
            button_action(36);
        });

    }

    public void button_action(int n) {
        if (btn[n].getText() == "") {
            clk_time++;
            if (clk_time == 1) {
                btn[n].setText(btn_txt[n] + "");
                btn[n].setBackground(Color.cyan);
                pre_txt = (char) btn_txt[n];
                pre_btn = n;
            }
            if (clk_time == 2) {
                clk_time = 0;
                btn[n].setText(btn_txt[n] + "");
                btn[n].setBackground(Color.cyan);
                if (btn_txt[n] == pre_txt) {
                    result++;
                    if (result == 18) {
                        int used_time = (60000 - Time) / 1000;
                        
                        JOptionPane.showMessageDialog(null, "You are done and your "
                                + "score :" + used_time);
                        JFrame scorFr=new JFrame("score");
                        scorFr.setBounds(150,80,1,1);
                        scorFr.setVisible(true);
                        scorFr.setLocationRelativeTo(null);

                    }
                } else if (btn_txt[n] != pre_txt) {
                    btn[n].setText(btn_txt[n] + "");
                    pause p = new pause();
                    p.mainn();

                    btn[n].setText("");
                    btn[pre_btn].setText("");
                    btn[n].setBackground(Color.magenta);
                    btn[pre_btn].setBackground(Color.magenta);
                    pre_btn = 0;

                    System.out.println("");
                }
            }
        }

    }

}
