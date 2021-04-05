package internalassessment;

import GameCode.Globals;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Player.java - the character that the user controls on the stage, it
 * can perform actions based on the users inputs. The play has a hitbox
 * that can collide with the walls. a player is able to jump and has a gravity
 * effect.
 *
 * @author Ethan Alexander
 * @since Mar. 30, 2021, 3:07:12 p.m.
 */
public class Player {

    Globals globals;
    GamePanel panel;

    public int x;
    public int y;
    public int width;
    public int height;

    public double xspeed;
    public double yspeed;

    public Rectangle hitbox;

    public boolean keyLeft;
    public boolean keyRight;
    public boolean keyDown;
    public boolean keyUp;

    /**
     * Default constructor, set class properties
     *
     * @param x the x position of the player
     * @param y the y position of the player
     * @param panel the game panel
     */
    public Player(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 100;
        hitbox = new Rectangle(x, y, width, height);
    }
    
    /**
     * sets various properties of the player class
     */
    public void set() {

        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xspeed *= .7;
        } else if (keyLeft && !keyRight) {
            xspeed--;
        } else if (keyRight && !keyLeft) {
            xspeed++;
        }

        if (xspeed > 0 && xspeed < 0.75) {
            xspeed = 0;
        }
        if (xspeed < 0 && xspeed > -0.75) {
            xspeed = 0;
        }

        if (xspeed > 10) {
            xspeed = 10;
        }
        if (xspeed < -10) {
            xspeed = -10;
        }

        if (keyUp) {
            hitbox.y++;
            for (Wall wall : panel.walls) {
                if (wall.hitbox.intersects(hitbox)) {
                    yspeed = -10;
                }
            }
            hitbox.y--;
        }
        yspeed += 0.5;

//        Horizontal Collisions
        hitbox.x += xspeed;
        for (Wall wall : panel.walls) {
            if (hitbox.intersects(wall.hitbox)) {
                hitbox.x -= xspeed;
                while (!wall.hitbox.intersects(hitbox)) {
                    hitbox.x += Math.signum(xspeed);
                }
                hitbox.x -= Math.signum(xspeed);
                panel.cameraX += x - hitbox.x;
                xspeed = 0;
                hitbox.x = x;
            }
        }

//        Vertical Collisions
        hitbox.y += yspeed;
        for (Wall wall : panel.walls) {
            if (hitbox.intersects(wall.hitbox)) {
                hitbox.y -= yspeed;
                while (!wall.hitbox.intersects(hitbox)) {
                    hitbox.y += Math.signum(yspeed);
                }
                hitbox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitbox.y;
            }
        }

        panel.cameraX -= xspeed;
        y += yspeed;

        hitbox.x = x;
        hitbox.y = y;

        if (y > 800) {
            panel.reset();
        }
    }

    /**
     * draws the player on the game panel
     * 
     * @param gtd the graphic 
     */
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.red);
        gtd.fillRect(x, y, width, height);
    }
}
