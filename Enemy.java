import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int health1 = 100;

    private int topBorder = 100, bottomBorder = 650, direction = 1;

    public void act()
    {

        {
            setLocation(getX(), getY()+direction);
            if (getY()==topBorder || getY()==bottomBorder) direction *= -1;
        }

        if(isTouching(Bullet.class)){ 
            health1--;

        }
        if(health1 <= 0){
            ((MyWorld)getWorld()).win();
        }
    }

}