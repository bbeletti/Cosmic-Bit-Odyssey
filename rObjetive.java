import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rObjetive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rObjetive extends Actor
{
    /**
     * Act - do whatever the rObjetive wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int value;
    protected GreenfootImage[] pictures;
    
    public rObjetive(){
        pictures = new GreenfootImage[16];
        pictures[0] = new GreenfootImage ("0000.png");
        pictures[1] = new GreenfootImage ("0001.png");
        pictures[2] = new GreenfootImage ("0010.png");
        pictures[3] = new GreenfootImage ("0011.png");
        pictures[4] = new GreenfootImage ("0100.png");
        pictures[5] = new GreenfootImage ("0101.png");
        pictures[6] = new GreenfootImage ("0110.png");
        pictures[7] = new GreenfootImage ("0111.png");
        pictures[8] = new GreenfootImage ("1000.png");
        pictures[9] = new GreenfootImage ("1001.png");
        pictures[10] = new GreenfootImage ("1010.png");
        pictures[11] = new GreenfootImage ("1011.png");
        pictures[12] = new GreenfootImage ("1100.png");
        pictures[13] = new GreenfootImage ("1101.png");
        pictures[14] = new GreenfootImage ("1110.png");
        pictures[15] = new GreenfootImage ("1111.png");
        for (int i=0; i<16; i++){
            pictures[i].scale(100,100);
        }
        setImage(pictures[0]);
    }
    public void act()
    {
        updateImage(this.value);
    }
    private void updateImage(int value){
            setImage(pictures[value]);
    }
    protected int getValue(){
        return this.value;
    }
    protected void setValue(int value){
        this.value = value;
    }
}