package internalassessment;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyChecker.java - Checks if a key is pressed
 *
 * @author Ethan Alexander
 * @since Apr. 3, 2021, 1:39:14 p.m.
 */
public class KeyChecker extends KeyAdapter {

    GamePanel panel;

    /**
     * Default constructor, set class properties
     * @param panel the panel check the keys for
     */
    public KeyChecker(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        panel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        panel.keyReleased(e);
    }

}
