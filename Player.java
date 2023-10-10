import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor {
     private int bulletSpeed = 5;
    private int cooldown = 20;
    private int lastShortTimer = 0;
    private int speed = 5;
    private int lives = 3;
    private int initialLives;
    private int bulletDelay = 10; // Menambahkan variabel delay untuk peluru
    private int currentBulletDelay = 0;
    public Player(int startingLives) {
        initialLives = startingLives;
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);
        setRotation(270);
        lives = startingLives;
        reset();
        }
    
    private void tembak() {
        World world = getWorld();
        Bullet bullet = new Bullet(bulletSpeed);
        bullet.setRotation(getRotation());
        world.addObject(bullet, getX(), getY());
    }
    
    public void act() {
        if (lives > 0){
        move(0);
        
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
        
        if (lastShortTimer < cooldown && lastShortTimer > 0) {
            lastShortTimer++;
        }
        
        if (currentBulletDelay > 0) {
            currentBulletDelay--;
            }
        if (Greenfoot.isKeyDown("space") && currentBulletDelay == 0) {
            tembak();
            lastShortTimer = cooldown;
            currentBulletDelay = bulletDelay;
            }
        if (lastShortTimer > 0) {
                lastShortTimer--;
            }
        
        if (Greenfoot.isKeyDown("space") && lastShortTimer == 0) {
            tembak();
            lastShortTimer = cooldown;
        }
        
        if (lastShortTimer == cooldown) {
            lastShortTimer = 0;
        }
        
        if (isTouching(Enemy.class)) {
            loseLife();
            getWorld().removeObject(this);
        }
    }
    
    }
    private void loseLife(){
        if (lives > 0){
            lives--;
            respawn();
        }
    }
    
    public void reset(){
        if (getWorld() != null) {
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() - 30);
        }
        lives = initialLives;
    }
    private void respawn() {
        reset();
    }
}
