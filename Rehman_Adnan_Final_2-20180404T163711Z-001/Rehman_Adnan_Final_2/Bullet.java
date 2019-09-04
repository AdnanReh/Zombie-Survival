import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    //variables declared
    int targX, targY;
    private boolean hitTarget;
    private int speed;
    boolean hitZombie = false;
   
    
    public Bullet (int targX, int targY)
    {
        this.targX = targX;
        this.targY = targY;
        hitTarget = false;
        speed = 20;
        
    }

    public void act() 
    {
        // If I have come within 10 pixels of my destination, I no longer
        // want to update my direction as I am close enough:
        if (Math.abs(getX() - targX) < 10 && Math.abs(getY() - targY) < 10)
            hitTarget = true;
        // If I am not yet close to my destination, update my trajectory
        if (!(hitTarget))
            turnTowards(targX, targY);
        // Move in the direction I am facing
        move(speed);
        // Check if I am at the edge of the World, and if so, remove myself
        if (atWorldEdge())
            getWorld().removeObject(this);
        hitZombie();
    }    

    public boolean atWorldEdge ()
    {
        int maxX = getWorld().getBackground().getWidth();
        int maxY = getWorld().getBackground().getHeight();
        if (getX() <= 0 || getX() >= maxX - 1)
        { return true; }
        if (getY() <= 0 || getY() >= maxY - 1)
        { return true; }
        return false;
    }
    
    //when the bullet collides with a zombie
    public void hitZombie()
    {
        if (getWorld() != null){
            Actor zombie = getOneIntersectingObject(Zombie.class);
            if (zombie != null)
            {
                if(hitZombie == false)
                {
                    //remove zombie and bullet, drop coin
                    hitZombie = true;
                    getWorld().removeObject(zombie);
                    getWorld().addObject (new Coin(), this.getX(), this.getY());
                    getWorld().removeObject(this);
                    

                }
                else 
                {
                    hitZombie = false;
                }

            }
        }
    }
}
