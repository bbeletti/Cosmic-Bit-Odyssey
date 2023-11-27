import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class alert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class alert extends Actor
{
    private boolean state = false;
    private GreenfootImage nothing_;
    private GreenfootImage alert_;
    public alert(){
        nothing_ = new GreenfootImage("nothing.png");
        alert_ = new GreenfootImage("alert_.png");
        alert_.scale(300,125);
    }
    public void act()
    {
        if(state == false){setImage(nothing_);}
        else{setImage(alert_);}
    }
    protected void setState(boolean state){this.state = state;}
}
