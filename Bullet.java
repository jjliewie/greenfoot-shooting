import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private double positionx,positiony,velocityx=0,velocityy=0,gx=0,gy=3.0,dt=0.098;
    public void addedToWorld(World Latar)
    {
        positionx=getX();
        positiony=getY();
    }

    public void setVeloc(double velocityxo,double velocityyo)
    {
        velocityx=velocityxo;velocityy=velocityyo;
    }

    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){ 
        positionx+=velocityx*dt+0.5*gx*dt*dt;
        positiony+=velocityy*dt+0.5*gy*dt*dt;

        velocityx+=gx*dt;
        velocityy+=gy*dt;
        setLocation((int)positionx,(int)positiony);
        if(positiony>getWorld().getHeight()+100)getWorld().removeObject(this);

    }   
}
