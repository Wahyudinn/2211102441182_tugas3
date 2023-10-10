import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor {
    private int bulletSpeed = 5;
    private int cooldown = 20;
    private int lastShortTimer = 0;
    private int speed = 5;
    private int lives = 3;
    private int initialLives;
    private int delay = 10; // Menambahkan variabel delay untuk peluru
    private int currentBulletDelay = 0;
    private int flightDirection;
    public Bullet(int direction)
    {
        flightDirection = direction;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2); // Mengurangi ukuran gambar
        setImage(image);
    }

    public void act() {
        if (delay > 0) {
            delay--;
            return; // Menghentikan peluru selama delay masih ada
        }
        move(speed);
        if (isAtEdge()) {
            World world = getWorld();
            world.removeObject(this);
            missBullet missBullet = (missBullet) world.getObjects(missBullet.class).get(0);
            missBullet.increaseMissBulletCount();
        } 
        else {
            checkHitEnemy();
            
        }
        
    }
    private void checkHitEnemy(){
    Actor enemy = getOneIntersectingObject(Enemy.class);
    if (enemy != null){
        World world = getWorld();
        world.removeObject(this);
        ScoreBoard scoreBoard = (ScoreBoard) world.getObjects(ScoreBoard.class).get(0);
        scoreBoard.addScore(1);
        }
    }
}
