import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Adnan Rehman 
 *
 *Bugs: Zombies might stand still if too many of them are colliding at once, fixes if you move
 *so its not really a problem
 *Image of a bullet may get frozen/stuck in the world if you shoot too fast, no effect on the functionality of the game
 *
 */
public class Map extends World
{
    //variables defined
    private Target target;
    private Zombie zombie;
    private Hero hero;
    private MouseInfo m;
    private HealthBar healthbar;
    private Bullet bullet;
    private Coin coin; 
    private GameOver gameover;
    private int difficulty = 35;
    Counter counter = new Counter();

    /** 
     * Constructor for objects of class Map.
     * 
     */
    //sets screen size and adds character to map, initializes hero
    public Map()
    {    
        //initialized 
        super(800, 600, 1); 
        hero = new Hero();
        addObject (hero, 400, 300);
        target = new Target();
        zombie = new Zombie(hero);
        healthbar = new HealthBar();
        addObject (healthbar, 475, 30);
        bullet = new Bullet(hero.getX(), hero.getY());
        addObject (counter, 100, 40);
        coin = new Coin();
        Counter.score = 0;
        gameover = new GameOver();
    }

    public void act ()
    {
        //constantly cheking for movement, spawning, difficulty, wins/losses
        checkKeys();
        zombieSpawn();
        checkMouse();
        increaseDifficulty();
        Dead();
        Win();
    }

    //movement for character
    private void checkKeys ()
    {
        int changeX = 0, changeY = 0;
        if (Greenfoot.isKeyDown("w")) {
            changeY = changeY - 3;}
        if (Greenfoot.isKeyDown("s")) {
            changeY = changeY + 3;}
        if (Greenfoot.isKeyDown("a")) {
            changeX = changeX - 3;}
        if (Greenfoot.isKeyDown("d")) {
            changeX = changeX + 3;}
        hero.moveMe (changeX, changeY);
    }
    //spawns zombies randomly on the map
    private void zombieSpawn()
    {
        if (Greenfoot.getRandomNumber (difficulty) == 5)
        {
            zombie = new Zombie(hero);
            //spawns the zombies outside the world to come from four corners of the map
            int spawn = Greenfoot.getRandomNumber (5);
            if (spawn == 1){
                addObject (new Zombie(hero), - 20, -20);
            }
            else if (spawn == 2){
                addObject (new Zombie(hero), - 20, 620);
            }
            else if (spawn == 3){
                addObject (new Zombie(hero),820, -20);
            }
            else if (spawn == 4){
                addObject (new Zombie(hero), 820, 620);
            }
        }
    }

    //for mouse looking around
    private void checkMouse()
    {
        
        m = Greenfoot.getMouseInfo ();
        if (m != null)
        {
            addObject (target, m.getX(), m.getY());
            target.setLocation (m.getX(), m.getY());
            hero.turnTowards(m.getX(), m.getY());               
        }
        //when the user clicks the mouse, hero shoots 
        if (Greenfoot.mouseClicked(null))
        {
            hero.shoot(m.getX(), m.getY());
        }

    }

    //reference for healthbar in hero class, and in here
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
    //reference for counter in coin class, and in here
    public Counter getCounter()
    {
        return counter;
    }

    //increases the difficulty by increasing chances of spawn as score increases
    public void increaseDifficulty()
    { 
        //difficulty value decreases because it increases rate of zombies spawning
        if (Counter.score == 20)
        {
            difficulty = 20;
        }
        else if (Counter.score == 40)
        {
            difficulty = 14;
        }
        else if (Counter.score == 60)
        {
            difficulty = 10;
        }
        else if (Counter.score == 80)
        {
            difficulty = 8;
        }
    }
    //when the hero dies, game ends
    public void Dead()
    {
        if (HealthBar.health <= 0)
        {
            addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
            HealthBar.health = 100;
            

        }
    }
    //if the user reaches 100 points, game stops
    public void Win()
    {
        if (HealthBar.health > 0 && Counter.score >= 100)
        {
            addObject (new Win(), getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
            HealthBar.health = 100;
        }
    }
}

