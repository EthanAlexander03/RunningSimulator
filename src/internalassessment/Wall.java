package internalassessment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

/**
 * Wall.java - builds the wall in the game 
 *
 * @author Ethan Alexander
 * @since Apr. 3, 2021, 1:55:15 p.m.
 */
public class Wall {

    public int x;
    public int y;
    public int width;
    public int height;
    public int startX;

    Rectangle hitbox;

    /**
     * Default constructor, set class properties
     */
    public Wall(int x, int y, int width, int height) {
        this.x = x;
        startX = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitbox = new Rectangle(x, y, width, height);
    }

    /**
     * Draws the walls on the panel making them white with a black border
     * 
     * @param gtd the graphic of the wall
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.black);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x + 1, y + 1, width - 2, height - 2);
    }

    /**
     * sets the hitbox of the walls
     * 
     * @param cameraX the position of the fixed camera
     * @return the x value of the wall
     */
    public int set(int cameraX) {
        x = startX + cameraX;
        hitbox.x = x;
        
        return x;
      
    }

}
