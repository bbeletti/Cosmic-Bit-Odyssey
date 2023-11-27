import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class levelBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelBar extends Actor
{
    private int value = 4;
    GreenfootImage[] imagesLocal;
    public levelBar(GreenfootImage[] images){
        imagesLocal = new GreenfootImage[images.length];
        for(int i=0;i<images.length; i++){
            images[i].scale(400,400);
            imagesLocal[i] = images[i];
        }
        setImage(images[4]);
    }
    public void act(){setImage(imagesLocal[value]);}
    protected void setValue(int value){
        this.value = value;
    }
    protected int getValue(){return this.value;}
}
