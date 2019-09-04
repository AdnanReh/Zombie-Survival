import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    //variables declared, public static so it can be used from map class
    public static int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //updates score every act
        setImage (new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));
    }    
    //used in coin class to add score
    public void addScore()
    {
       score++; 
    }
}
