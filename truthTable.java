import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class truthTable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class truthTable extends Actor
{
    protected int value = 7;
    protected GreenfootImage[] pictures;
    
    public truthTable(){
    pictures = new GreenfootImage[8];
    pictures[0] = new GreenfootImage ("NOR_.png");
    pictures[1] = new GreenfootImage ("NOT_.png");
    pictures[2] = new GreenfootImage ("OR_.png");
    pictures[3] = new GreenfootImage ("XNOR_.png");
    pictures[4] = new GreenfootImage ("XOR_.png");
    pictures[5] = new GreenfootImage ("AND_.png");
    pictures[6] = new GreenfootImage ("NAND_.png");
    pictures[7] = new GreenfootImage ("nothing.png");
    for(int i=0; i<7; i++){
    pictures[i].scale(115,95);
    }
    setImage(pictures[7]);
    }
    public void act()
    {
        setImage(pictures[value]);
    }
    protected void setValue(int value){
        this.value = value;
    }
}
