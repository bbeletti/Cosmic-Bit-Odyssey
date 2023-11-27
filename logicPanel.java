import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class logicPanel extends World
{
    private GreenfootImage background;
    private Bit bits[];
    private Button regA;
    private Button regB;
    private Button regC;
    private Button regD;
    private Button and1;
    private Button nand1;
    private Button nor1;
    private Button or1;
    private Button xnor1;
    private Button xor1;
    private Button not1;
    private Button add1;
    private Button dec1;
    private Button inc1;
    private Button mov1;
    private Button rol1;
    private Button ror1;
    private Button sub1;
    private rocket rocket1;  
    private moon moon1;
    private rObjetive reg_obj;
    private alert alert1;
    private title title1;
    public logicPanel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        background = new GreenfootImage("background.jpg");
        
        setBackground(background);
        Bit bits[] = new Bit[16];
        this.bits = setupBits(bits);
        setupButtons();

        setupNave();
        setupLevelBar();
        
        alert1 = new alert();
        addObject(alert1, 600, 50);
        
        moon1 = new moon();
        addObject(moon1, 1000, 550);
        
        title1 = new title();
        addObject(title1, 170, 170);
    }
    private Bit[] setupBits(Bit bits[]){
        for(int y=450;y>50;y-=100){
            for(int x=440;x<840;x+=100){
                int cont_bit = 0;
                bits[cont_bit] = new Bit(false);
                addObject(bits[cont_bit], x, y);
                cont_bit+=1;
            }
        }
        return bits;
    }
    private void setupLevelBar(){
        GreenfootImage[] telecomImages = new GreenfootImage[5];
        telecomImages[0] = new GreenfootImage("transmision0.png");
        telecomImages[1] = new GreenfootImage("transmision1.png");
        telecomImages[2] = new GreenfootImage("transmision2.png");
        telecomImages[3] = new GreenfootImage("transmision3.png");
        telecomImages[4] = new GreenfootImage("transmision4.png");
        levelBar telecomBar = new levelBar(telecomImages);
        addObject(telecomBar, 1015, 175);
    }
    private void setupButtons(){
        rol1 = new Button("rol.png", "lumin_rol.png"); //0
        addObject(rol1, 625, 560);
        
        ror1 = new Button("ror.png", "lumin_ror.png"); //1
        addObject(ror1, 700, 560);
        
        not1 = new Button("not.png", "lumin_not.png"); //2
        addObject(not1, 550, 630);
        
        dec1 = new Button("dec.png", "lumin_dec.png"); //3
        addObject(dec1, 625, 630);
        
        inc1 = new Button("inc.png", "lumin_inc.png"); //4
        addObject(inc1, 700, 630);

        mov1 = new Button("mov.png", "lumin_mov.png"); //5
        addObject(mov1, 400, 560);
        
        and1 = new Button("and.png", "lumin_and.png"); //6
        addObject(and1, 325, 560);
        
        nand1 = new Button("nand.png", "lumin_nand.png"); //7
        addObject(nand1, 475, 560);
        
        nor1 = new Button("nor.png", "lumin_nor.png"); //8
        addObject(nor1, 475, 630);
        
        or1 = new Button("or.png", "lumin_or.png"); //9
        addObject(or1, 400, 630);
        
        sub1 = new Button("sub.png", "lumin_sub.png"); //10
        addObject(sub1, 775, 560);
        
        add1 = new Button("add.png", "lumin_add.png"); //11
        addObject(add1, 775, 630);
        
        xnor1 = new Button("xnor.png", "lumin_xnor.png"); //12
        addObject(xnor1, 550, 560);
        
        xor1 = new Button("xor.png", "lumin_xor.png"); //13
        addObject(xor1, 325, 630);
        
        regA = new Button("regA.png", "lumin_regA.png"); //14
        addObject(regA, 340, 450);
        
        regB = new Button("regB.png", "lumin_regB.png"); //15
        addObject(regB, 340, 350);
        
        regC = new Button("regC.png", "lumin_regC.png"); //16
        addObject(regC, 340, 250);
        
        regD = new Button("regD.png", "lumin_regD.png"); //17
        addObject(regD, 340, 150);
        
        reg_obj = new rObjetive ();
        addObject(reg_obj, 170, 350);
        
        addObject(new Logica(),1,1);
        addObject(new truthTable(),170,585);
    }
    private void setupNave(){
        rocket1 = new rocket();
        addObject(rocket1, 1000, 275);
    }
}
