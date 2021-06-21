package memory_game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Mahathir Bishal
 */
public class Memory_Game extends JFrame {

    private Container c = new Container();
    private ImageIcon img, img_play, img_exit, img_how, img_level,icon;
    private JLabel label, mode;
    private Cursor cursor;
    private Font cbf;
    int s = 0;

    Memory_Game() {
        initComponents();
        //call_new_game();
        //
        //System.out.println("kkkk");

    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        icon=new ImageIcon(getClass().getResource("icon.jpg"));
        this.setIconImage(icon.getImage());
        JButton play, exit, how;

        cursor = new Cursor(Cursor.HAND_CURSOR);
        cbf = new Font("Ariel", Font.PLAIN, 15);

//        img_level = new ImageIcon(getClass().getResource("level.png"));
//        mode = new JLabel(img_level);
//        mode.setBounds(130, 210, 150, 39);
        //mode.setOpaque(true);
        //c.add(mode);
        String cb_element[] = {"Easy", "Hard"};

        JComboBox cb = new JComboBox(cb_element);
        cb.setBackground(Color.cyan);
        cb.setOpaque(false);
        cb.setForeground(Color.black);
        cb.setBounds(230, 210, 100, 30);
        cb.setCursor(cursor);
        cb.setToolTipText("Select Difficulty Level");
        cb.setFont(cbf);
        c.add(cb);

        img_play = new ImageIcon(getClass().getResource("play.png"));
        img_exit = new ImageIcon(getClass().getResource("exit.png"));
        img_how = new ImageIcon(getClass().getResource("how.png"));

        play = new JButton();
        play.setIcon(img_play);
        play.setBorder(null);
        play.setBounds(215, 270, 130, 39);
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.setCursor(cursor);
        play.setToolTipText("Click To Play");
        c.add(play);

        exit = new JButton(img_exit);
        exit.setBounds(215, 320, 130, 39);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(cursor);
        exit.setToolTipText("Click To Quit");
        c.add(exit);

        how = new JButton();
        how.setIcon(img_how);
        how.setBorder(null);
        how.setBounds(435, 315, 50, 50);
        how.setBorderPainted(false);
        how.setContentAreaFilled(false);
        how.setCursor(cursor);
        how.setToolTipText("How To Play");
        c.add(how);

        img = new ImageIcon(getClass().getResource("home.png"));
        label = new JLabel(img);
        label.setBounds(0, 00, 550, 450);
        c.add(label);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                s = cb.getSelectedIndex();
                //System.out.println(s);
            }

        });

        play.addActionListener((ActionEvent e) -> {

            if (s == 0) {
                this.setVisible(false);
                ///opening easy level
                newGame ng = new newGame();
                try {
                    ng.NewGame();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Memory_Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Memory_Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.setVisible(false);
                ///opening hard level
                hard h = new hard();
                try {
                    h.NewGame();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Memory_Game.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        exit.addActionListener((ActionEvent e) -> {
            this.dispose();
        });
        how.addActionListener((ActionEvent e) -> {

            JFrame howfr = new JFrame();
            howfr.setVisible(true);
            howfr.setSize(430, 315);
            howfr.setLocationRelativeTo(null);
            howfr.setResizable(false);
            howfr.setLayout(null);
            howfr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            howfr.getContentPane().setBackground(Color.gray);
            ImageIcon icon=new ImageIcon(getClass().getResource("icon.jpg"));
            howfr.setIconImage(icon.getImage());
            JLabel lbl1 = new JLabel();
            lbl1.setBounds(115, 10, 200, 40);
            lbl1.setText("How To Play");
            lbl1.setForeground(Color.green);
            lbl1.setFont(new Font("tahome", Font.PLAIN, 28));
            howfr.add(lbl1);

            JLabel lbl2 = new JLabel();
            lbl2.setBounds(10, 50, 410, 195);
            lbl2.setText("<html>"
                    + "Easy : <br>"
                    + "in easy mode there will be 4x4 grid equiped with image.You<br>"
                    + "will get 10 second to memorize all the images with their<br>"
                    + "position,then they will be disappeared and you have to click<br>"
                    + "the two similar image consequently before 60 seconds.<br>"
                    + "Hard :<br>"
                    + "there will be 6x6 grid equiped with 16 different number<br>"
                    + "between 60 second you have to click the paired number<br>consequently<br>"
                    + "Developed By : Mahathir Mohammad Bishal<br>"
                    + "</html>");
            lbl2.setForeground(Color.green);
            lbl2.setFont(new Font("tahome", Font.PLAIN, 15));
            howfr.add(lbl2);
            
            JButton ok=new JButton();
            ok.setText("Ok");
            ok.setBounds(195,250,50,25);
            ok.setBackground(Color.green);
            howfr.add(ok);
            
            ok.addActionListener((ActionEvent ep)->{
                howfr.dispose();
            });

        });

    }

    public void call_new_game() {
        try {
            newGame n = new newGame();
            n.NewGame();
            //nfFrame.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(Memory_Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void call_hard_game() {
        hard h = new hard();
        try {
            h.NewGame();
        } catch (InterruptedException ex) {
            Logger.getLogger(Memory_Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //ImageIcon img=nr=new(getClass().getResource("1.png"));
        Memory_Game frame = new Memory_Game();
        frame.setTitle("Memory Game");
        frame.setVisible(true);
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
