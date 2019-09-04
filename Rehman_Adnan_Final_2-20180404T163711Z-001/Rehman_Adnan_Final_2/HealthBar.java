import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 // importing colour to draw health bar
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    //declaring variables
    public static int health = 100;
    int healthBarWidth = 100;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthBar()
    {
        update();
    }

    public void act() 
    {
        update();
    }    
    //drawing the healthbar
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight +2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.GREEN);
        //divides the health into equal spaces of health width
        myImage.fillRect(1, 1, health*pixelsPerHealthPoint, healthBarHeight);
    }
    //called in the hero class 
    public void loseHealth()
    {
        health--;
    }
    //modified version of a healt bar created by Jim Stewart
}
