package internalassessment;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * MainFrame.java - builds the frame that the game displays on
 *
 * @author Ethan Alexander
 * @since Mar. 26, 2021,10:37:48 a.m.
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Default constructor, set class properties
     */
    public MainFrame() {

        
//        JLabel label = new JLabel("Hi");
//        
//        this.getContentPane().setLayout(null);
        
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);
        
//        this.getContentPane().add(label);
//        label.setBounds(100, 100, 100, 100);
        
        
        addKeyListener(new KeyChecker(panel));
    }
}
