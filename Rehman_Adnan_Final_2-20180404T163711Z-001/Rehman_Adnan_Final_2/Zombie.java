import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    //reference to hero, so that zombie can get coordinates of hero to chase it
    private Hero theHero;

    public Zombie (Hero h)
    {
        theHero = h;
    }

    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        chaseHero();
    }    
    //makes zombie follow player
    private void chaseHero()
    {
        turnTowards (theHero.getX(), theHero.getY());
        move(2);

        /**slightly prevents zombies from overlapping and becoming one zombie (if necessary
        if (!getIntersectingObjects(Zombie.class).isEmpty())
        {
        move (-1); 

        }
         */
    }
}
