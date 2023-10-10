import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor {
    private Player player;
    public Enemy(Player player) {
        this.player = player;
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);
        setRotation(90);
    }

    public void act() {
        move(6);
        if (player != null) {
        int playerX = player.getX();
        int playerY = player.getY();
        turnTowards(playerX, playerY);
    }
        World world = getWorld();
        if (isTouching(Bullet.class)) {
        world.removeObject(this);
    } 
        else if (getY() == world.getHeight() - 1) {
        world.removeObject(this);
    }
    }
}
