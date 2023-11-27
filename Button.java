import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Button extends Actor
{
    private boolean state = false;
    private GreenfootImage normalImg;
    private GreenfootImage selectedImg;
    public Button(String normal, String selected){
        normalImg = new GreenfootImage(normal);
        normalImg.scale(70,70);
        selectedImg = new GreenfootImage(selected);
        selectedImg.scale(70,70);
        setImage(normalImg);
    }
    public void act(){
        if(state == true){            
            setImage(selectedImg);
        }
        else{
            setImage(normalImg);
        }
        if (Greenfoot.mouseClicked(this)){
            this.state = !this.state;
        }
    }
    protected boolean getState(){
        return this.state;
    }
    protected void setState(boolean state){
        this.state = state;
    }
}
