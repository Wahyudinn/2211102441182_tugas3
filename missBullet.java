import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pelurumeleset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class missBullet extends Actor
{
    /**
     * Act - do whatever the pelurumeleset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int missBullet;
    
    public missBullet(){
        missBullet = 0;
        updateCount();
    }
    public void increaseMissBulletCount(){
        missBullet++;
        updateCount();
    }
    public int getMissbullet(){
        return missBullet;
    }
    private void updateCount() {
        GreenfootImage image = new GreenfootImage("Miss Bullet: " + missBullet, 24, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    public void act() {

    }
}
