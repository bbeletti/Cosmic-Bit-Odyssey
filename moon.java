import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class imageObjet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moon extends Actor
{
    /**
     * Act - do whatever the imageObjet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage moonImg;
    public moon(){
        moonImg = new GreenfootImage("moon.png");
        moonImg.scale(200,200);
        setImage(moonImg);
    }
}
