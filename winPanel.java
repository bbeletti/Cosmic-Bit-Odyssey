import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class winPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class winPanel extends World
{
    private GreenfootImage documentImg;
    public winPanel()
    {    
        super(1200, 700, 1);
        documentImg = new GreenfootImage("neil_phrase.png");
        documentImg.scale(1200,700);
        setBackground(documentImg);
        Greenfoot.playSound("tranquility_base.mp3");
    }
}
