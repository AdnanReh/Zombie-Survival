import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    //variables declared
    private boolean touching;
    /**
     * Act - do whatever the Coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Collect();
    }    

    public void Collect()
    {
        if (getWorld() != null){
            Actor hero = getOneIntersectingObject(Hero.class);
            if (hero != null)
            {
                if(touching == false)
                {
                    //object collision between hero and coin
                    //adds score when hero collides with coin, removes coin
                    touching = true;
                    World myWorld = getWorld();
                    Map map = (Map)myWorld;
                    Counter counter = map.getCounter();
                    counter.addScore();
                    getWorld().removeObject (this);

                }
                else 
                {
                    touching = false;
                }

            }
        }
    }
}
