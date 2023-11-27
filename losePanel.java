import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class losePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class losePanel extends World
{
    private GreenfootImage documentImg;
    
    public losePanel()
    {    
        super(1200, 700, 1);
        documentImg = new GreenfootImage("document.png");
        documentImg.scale(1200,700);
        setBackground(documentImg);
        Greenfoot.playSound("bill_safire.mp3");
    }
}
