import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor {
    private int score = 0;
    private GreenfootImage scoreImage;

    public ScoreBoard() {
        updateScoreImage();
    }

    private void updateScoreImage() {
        scoreImage = new GreenfootImage("Score: " + score, 36, Color.WHITE, Color.BLACK);
        setImage(scoreImage);
    }

    public void addScore(int points) {
        score += points;
        updateScoreImage();
    }

    public void setScore(int score) {
        this.score = score;
        updateScoreImage();
    }

    public int getScore() {
        return score;
    }

    public void act() {
        
    }
}
