import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class watercannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyGun extends Actor
{

    long lastAdded = System.currentTimeMillis();
    public int getRandomNumber(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }

    public void act()
    {

        /**
         * Act - do whatever the watercannon wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        long curTime  = System.currentTimeMillis();
        int rx=getRandomNumber(150,getX()-10)-getX();
        int ry=getRandomNumber(50,getY())-getY();
        int angle=(int)(Math.atan2(ry,rx)*180.0/Math.PI);

        if(curTime >= lastAdded + 600){
            double r=Math.sqrt(rx*rx+ry*ry);
            setRotation(angle+180);
            int w=(int)(0.5*getImage().getWidth());
            int positionx=(int)(getX()+w*Math.cos(angle));
            int positiony=(int)(getY()+w*Math.sin(angle));
            EnemyBullet enemybullet=new EnemyBullet();
            enemybullet.setVeloc(50*rx/r,50*ry/r);
            getWorld().addObject(enemybullet,positionx,positiony);
            lastAdded  = curTime;
        }

        int x = getX();
        int y = getY();

        move(1);
        if (getWorld().getObjects(Enemy.class).isEmpty()) return; 
        Actor enemy = (Actor)getWorld().getObjects(Enemy.class).get(0);
        setLocation(880, enemy.getY());
    }    
}