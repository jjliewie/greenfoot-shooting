import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Shooter shooter;
    EnemyGun enemygun;
    Gun gun;
    EnemyBullet enemybullet;
    Enemy enemy;
    Bullet bullet;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1, false);
        shooter = new Shooter();
        enemy = new Enemy();
        gun = new Gun();
        enemygun = new EnemyGun();
        /**
        bullet = new Bullet();
        enemybullet = new EnemyBullet();
         */

        addObject(shooter,100,400);
        addObject(gun,120,395);
        addObject(enemy, 900, 400);
        addObject(enemygun, 880, 395);
    }

    
    void win(){
        removeObject(shooter);
        removeObject(gun);
        removeObject(enemy);
        showText("you won, not bad",500,200);
    }
    
    void lost(){
        removeObject(shooter);
        removeObject(gun);
        removeObject(enemy);
        removeObject(enemygun);
        showText("you lost to a robot that shoots randomly (wow)",500,200);
    }
}
