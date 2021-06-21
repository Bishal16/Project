//import java.awt.GridLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class LabelDelay {
    JFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JPanel contentPane;
    Timer timer;
    int count=0;

    public LabelDelay() {
       JFrame.setDefaultLookAndFeelDecorated(true);
       frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       contentPane = new JPanel(new GridLayout(1,4));

       label1 = new JLabel("Label1");
       contentPane.add(label1);

       label2 = new JLabel("Label2");
       contentPane.add(label2);

       label3 = new JLabel("Label3");
       contentPane.add(label3);

       label4 = new JLabel("Label4");
       contentPane.add(label4);

       frame.setContentPane(contentPane);
       frame.pack();

       label1.setVisible(false);
       label2.setVisible(false);
       label3.setVisible(false);
       label4.setVisible(false);


       ActionListener action = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          switch(count) {
            case 0:
              label1.setVisible(true);
              break;
            case 1:
              label2.setVisible(true);
              break;
            case 2:
              label3.setVisible(true);
              break;
            case 3:
              label4.setVisible(true);
              break;
            case 4:
              timer.stop();//base criteria
              break;
          }
          count++;    
        }
      };      
       frame.setVisible(true);
       timer = new Timer(1000, action);
       timer.start();
    }
    public static void main(String args[]) {
      new LabelDelay();
    }
}