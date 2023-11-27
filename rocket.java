import greenfoot.*;

public class rocket extends Actor
{
    private GreenfootImage rocketImg;
    public rocket(){
        rocketImg = new GreenfootImage("lunarLander.png");
        rocketImg.scale(75,75);
        setImage (rocketImg);
        setRotation(90);
    }
    protected void descendRocket(){
        move(15);
    }
}