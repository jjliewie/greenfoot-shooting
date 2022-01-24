import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class holding here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends Actor
{

    int health = 50;

    /**
     * Act - do whatever the holding wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {int x = getX();
        int y = getY();
        if(y >= 680){
            y = 680;}

        if(y <= 50){
            y = 50;}

        if(Greenfoot.isKeyDown("up")){
            setLocation(x, y-1);
        }else if(Greenfoot.isKeyDown("down")){
            setLocation(x, y+1);
        }
        if(isTouching(EnemyBullet.class)){
            health--;

        }
        if(health <= 0){
            ((MyWorld)getWorld()).lost();
        }
    }

}
