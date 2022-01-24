import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class watercannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    /**
     * Act - do whatever the watercannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            int rx=mouse.getX()-getX();
            int ry=mouse.getY()-getY();
            int angle=(int)(Math.atan2(ry,rx)*180.0/Math.PI);
            setRotation(angle);
        }

        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            int rx=mouse.getX()-getX();
            int ry=mouse.getY()-getY();
            double r=Math.sqrt(rx*rx+ry*ry);
            double angle=Math.atan2(ry,rx);
            int w=(int)(0.5*getImage().getWidth());
            int positionx=(int)(getX()+w*Math.cos(angle));
            int positiony=(int)(getY()+w*Math.sin(angle));
            Bullet bullet=new Bullet();
            bullet.setVeloc(50*rx/r,50*ry/r);
            getWorld().addObject(bullet,positionx,positiony);
            /**
            Greenfoot.playSound("sounds/gunshot.mp3");
            */
        }

        int x = getX();
        int y = getY();

        move(1);
        if (getWorld().getObjects(Shooter.class).isEmpty()) return; 
        Actor shooter = (Actor)getWorld().getObjects(Shooter.class).get(0);
        setLocation(120, shooter.getY());
    }    
}