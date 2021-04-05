package GameCode;

import collections.LinkedList;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;

/**
 * Globals.java - global variables for the running simulator
 *
 * @author Ethan Alexander
 * @since Mar. 24, 2021,10:25:34 a.m.
 */
public class Globals {

    /**
     * gets the dimensions of the screen of the monitor
     */
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * gets half the width of the screen
     */
    public int halfWidth = (int) (screenSize.getWidth() / 2);
    /**
     * gets half the height of the screen
     */
    public int halfHeight = (int) (screenSize.getHeight() / 2);

    /**
     * 0 if the user is on the first section of terrain, 1 if the user
     * is on another section of terrain
     */
    public static int terrainCount = 0;
    
    /**
     * the current score of the user, increases as time passes records how
     * long they lasted in the game. is reset when the player calls the reset
     * method
     */
    public static int currentScore = 0;
    
    /**
     * old list of scores  
     */
    public static LinkedList<Integer> oldList = new LinkedList<>();
    
    /**
     * Default constructor, set class properties
     */
    public Globals() {

    }
}
