import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bit extends Actor
{
    public boolean state = false;
    private GreenfootImage bitoff;
    private GreenfootImage biton;
    public Bit(boolean state)
    {
        this.state = state;
        bitoff = new GreenfootImage("bitoff.png");
        biton = new GreenfootImage("biton.png");
        bitoff.scale(100,100);
        biton.scale(100,100);
        updateImage(state);
    }
    public void act(){
        updateImage(this.state);
    }
    private void updateImage(boolean state){
        if(state == true){            
            setImage(biton);
        }
        else{
            setImage(bitoff);
        }
    }
    protected void setState(boolean state){
        this.state = state;
    }
    protected boolean getState(){
        return this.state;
    }
}