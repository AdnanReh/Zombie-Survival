import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    //variables declared
    boolean touchingZombie = false;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hitZombie();
    }    
    //allows character to move
    public void moveMe (int xMove, int yMove)
    {
        setLocation (getX()+ xMove, getY()+ yMove);
    }
    //while the zombie is touching the character he loses health
    public void hitZombie()
    {
        Actor zombie = getOneIntersectingObject(Zombie.class);
        if (zombie != null)
        {
            World myWorld = getWorld();
            Map map = (Map)myWorld;
            HealthBar healthbar = map.getHealthBar();
            if(touchingZombie == false)
            {
                healthbar.loseHealth();
                touchingZombie = true;
            }
            else 
            {
                touchingZombie = false;
            }
        }
    }
    //when the hero shoots a bullet
    public void shoot (int targX, int targY)
    {
        Bullet b = new Bullet(targX, targY);
        getWorld().addObject(b, this.getX() , this.getY());
    }
}
