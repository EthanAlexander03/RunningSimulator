package internalassessment;

import GameCode.Globals;
import GameCode.Updater;
import collections.LinkedList;
import io.FileHandler;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 * GamePanel.java - creates the panel that the game is displayed on
 *
 * @author Ethan Alexander
 * @since Mar. 30, 2021, 2:50:59 p.m.
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();
    int cameraX;
    int offset;
    Timer gameTimer;
    
    File file;

    FileHandler<LinkedList<Integer>> fileHandler;
    Rectangle Scoreboard;
    Updater updater;

    /**
     * Default constructor, set class properties
     */
    public GamePanel() {
        file = new File("scores.txt");
        updater = new Updater();
        fileHandler = new FileHandler<>();
        
        Globals.oldList = fileHandler.openObject(file);
        if (Globals.oldList == null) {
            Globals.oldList = new LinkedList<>();
        }
        
        
        Scoreboard = new Rectangle(1000, 25, 50, 50);

        player = new Player(400, 300, this);
        reset();
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Globals.currentScore+=1000;
                if (walls.get(walls.size() - 1).x < 2500) {
                    offset += 1200;
                    makeWalls(offset);
                    System.out.println(walls.size()); //delete this line 
                }
                player.set();
                for (Wall wall : walls) {
                    wall.set(cameraX);
                }

                for (int i = 0; i < walls.size(); i++) {
                    if (walls.get(i).x < -800) {
                        walls.remove(i);
                    }
                }

                
//                
                
                repaint();
            }
        }, 0, 17);
    }

    /**
     * paints the objects on the frame
     *
     * @param g the graphic to display
     */
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);

        for (Wall wall : walls) {
            wall.draw(gtd);
        }
        
        
//        FontRenderContext fontRenderer = gtd.getFontRenderContext();
//        Font font = new Font("Courier", Font.BOLD, 24);
//        
//        String text = updater.output(Globals.oldList, Globals.currentScore);
//                
//        TextLayout textLayout = new TextLayout(text, font, fontRenderer);
//
//        textLayout.draw(gtd, 10, 800);

    }

    /**
     *
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * determines the key that is pressed
     *
     * @param e the key that is pressed
     */
    void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = true;
        }
        if (e.getKeyChar() == 'd') {
            player.keyRight = true;
        }
        if (e.getKeyChar() == ' ') {
            player.keyUp = true;
        }
        if (e.getKeyChar() == 's') {
            player.keyDown = true;
        }
        if (e.getKeyChar() == 'r') {
            reset();
        }
        if (e.getKeyChar() == 'p') {
            fileHandler.saveObject(Globals.oldList, file);
            System.exit(0);
        }

    }

    /**
     * determines the when the key is released
     *
     * @param e the key is released
     */
    void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = false;
        }
        if (e.getKeyChar() == 'd') {
            player.keyRight = false;
        }
        if (e.getKeyChar() == ' ') {
            player.keyUp = false;
        }
        if (e.getKeyChar() == 's') {
            player.keyDown = false;
        }
    }

    /**
     * respawns the player in the starting position
     */
    public void reset() {
        Globals.oldList = updater.add(Globals.oldList, Globals.currentScore);
        String text = updater.output(Globals.oldList, Globals.currentScore);
        JOptionPane.showMessageDialog(this, text);
                
        player.x = 200;
        player.y = 150;
        cameraX = 150;
        player.xspeed = 0;
        player.yspeed = 0;
        Globals.currentScore = 0;
        Globals.terrainCount = 0;
        walls.clear();
        offset = -300;
        makeWalls(offset);
    }

    /**
     * creates the walls objects in different orientations
     *
     * @param offset the spacing of the blocks off screen
     */
    public void makeWalls(int offset) {

        int s = 50;
        Random rand = new Random();
        int index = rand.nextInt(5);
        if (Globals.terrainCount < 1) {
            for (int i = 0; i < 24; i++) {
                walls.add(new Wall(offset + i * 50, 600, s, s));
            }
            Globals.terrainCount++;
            return;
        }
        if (index == 0) {

            walls.add(new Wall(offset + 0, 550, s, s));
            walls.add(new Wall(offset + 50, 550, s, s));
            walls.add(new Wall(offset + 100, 450, s, s));
            walls.add(new Wall(offset + 150, 450, s, s));
            walls.add(new Wall(offset + 200, 450, s, s));
            walls.add(new Wall(offset + 250, 350, s, s));
            walls.add(new Wall(offset + 300, 350, s, s));
            walls.add(new Wall(offset + 350, 250, s, s));
            walls.add(new Wall(offset + 400, 200, s, s));
            walls.add(new Wall(offset + 450, 200, s, s));
            walls.add(new Wall(offset + 500, 200, s, s));
            walls.add(new Wall(offset + 550, 150, s, s));
            walls.add(new Wall(offset + 600, 150, s, s));
            walls.add(new Wall(offset + 650, 150, s, s));
            walls.add(new Wall(offset + 700, 100, s, s));
            walls.add(new Wall(offset + 750, 100, s, s));
            walls.add(new Wall(offset + 800, 100, s, s));
            walls.add(new Wall(offset + 850, 100, s, s));
            walls.add(new Wall(offset + 900, 300, s, s));
            walls.add(new Wall(offset + 950, 300, s, s));
            walls.add(new Wall(offset + 1000, 300, s, s));
            walls.add(new Wall(offset + 1050, 350, s, s));
            walls.add(new Wall(offset + 1100, 350, s, s));
            walls.add(new Wall(offset + 1150, 350, s, s));
            walls.add(new Wall(offset + 1200, 400, s, s));
        } else if (index == 1) {

            walls.add(new Wall(offset + 0, 550, s, s));
            walls.add(new Wall(offset + 50, 550, s, s));
            walls.add(new Wall(offset + 100, 550, s, s));
            walls.add(new Wall(offset + 250, 550, s, s));
            walls.add(new Wall(offset + 300, 450, s, s));
            walls.add(new Wall(offset + 350, 450, s, s));
            walls.add(new Wall(offset + 450, 450, s, s));
            walls.add(new Wall(offset + 750, 350, s, s));
            walls.add(new Wall(offset + 650, 450, s, s));
            walls.add(new Wall(offset + 800, 350, s, s));
            walls.add(new Wall(offset + 1050, 550, s, s));
        } else if (index == 2) {

            walls.add(new Wall(offset + 50, 550, s, s));
            walls.add(new Wall(offset + 100, 550, s, s));
            walls.add(new Wall(offset + 250, 550, s, s));
            walls.add(new Wall(offset + 300, 450, s, s));
            walls.add(new Wall(offset + 350, 450, s, s));
            walls.add(new Wall(offset + 400, 450, s, s));
            walls.add(new Wall(offset + 500, 450, s, s));
            walls.add(new Wall(offset + 550, 450, s, s));
            walls.add(new Wall(offset + 700, 350, s, s));
            walls.add(new Wall(offset + 750, 300, s, s));
            walls.add(new Wall(offset + 800, 350, s, s));
            walls.add(new Wall(offset + 850, 350, s, s));
            walls.add(new Wall(offset + 1050, 550, s, s));
        } else if (index == 3) {

            walls.add(new Wall(offset + 0, 550, s, s));
            walls.add(new Wall(offset + 50, 550, s, s));
            walls.add(new Wall(offset + 100, 450, s, s));
            walls.add(new Wall(offset + 150, 450, s, s));
            walls.add(new Wall(offset + 200, 450, s, s));
            walls.add(new Wall(offset + 250, 350, s, s));
            walls.add(new Wall(offset + 300, 350, s, s));
            walls.add(new Wall(offset + 350, 250, s, s));
            walls.add(new Wall(offset + 450, 200, s, s));
            walls.add(new Wall(offset + 550, 150, s, s));
            walls.add(new Wall(offset + 600, 150, s, s));
            walls.add(new Wall(offset + 750, 100, s, s));
            walls.add(new Wall(offset + 900, 300, s, s));
            walls.add(new Wall(offset + 1000, 300, s, s));
            walls.add(new Wall(offset + 1050, 350, s, s));
            walls.add(new Wall(offset + 1200, 400, s, s));
        } else if (index == 4) {

            walls.add(new Wall(offset + 0, 550, s, s));
            walls.add(new Wall(offset + 50, 550, s, s));
            walls.add(new Wall(offset + 100, 450, s, s));
            walls.add(new Wall(offset + 150, 450, s, s));
            walls.add(new Wall(offset + 200, 450, s, s));
            walls.add(new Wall(offset + 250, 350, s, s));
            walls.add(new Wall(offset + 300, 350, s, s));
            walls.add(new Wall(offset + 350, 250, s, s));
            walls.add(new Wall(offset + 400, 200, s, s));
            walls.add(new Wall(offset + 450, 200, s, s));
            walls.add(new Wall(offset + 500, 200, s, s));
            walls.add(new Wall(offset + 550, 150, s, s));
            walls.add(new Wall(offset + 600, 150, s, s));
            walls.add(new Wall(offset + 650, 150, s, s));
            walls.add(new Wall(offset + 700, 100, s, s));
            walls.add(new Wall(offset + 750, 100, s, s));
            walls.add(new Wall(offset + 800, 100, s, s));
            walls.add(new Wall(offset + 850, 100, s, s));
            walls.add(new Wall(offset + 900, 300, s, s));
            walls.add(new Wall(offset + 950, 300, s, s));
            walls.add(new Wall(offset + 1000, 300, s, s));
            walls.add(new Wall(offset + 1050, 350, s, s));
            walls.add(new Wall(offset + 1100, 350, s, s));
            walls.add(new Wall(offset + 1150, 350, s, s));
            walls.add(new Wall(offset + 1200, 400, s, s));
        }
    }
}
//                
//        for (int i = 50; i < 650; i += 50) {
//            walls.add(new Wall(i, 600, 50, 50));
//        }
//        walls.add(new Wall(50, 550, 50, 50));
//        walls.add(new Wall(50, 500, 50, 50));
//        walls.add(new Wall(50, 450, 50, 50));
//        walls.add(new Wall(600, 550, 50, 50));
//        walls.add(new Wall(600, 500, 50, 50));
//        walls.add(new Wall(600, 450, 50, 50));
//        walls.add(new Wall(450, 550, 50, 50));

