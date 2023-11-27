import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Logica extends Actor
{
    private boolean[] panelBits = new boolean[16];
    private boolean[] panelButtons = new boolean[18];
    private boolean[] result = new boolean[4];
    private int button_instance = 99;
    private int primary_reg = 99;
    private int secondary_reg = 99;
    private boolean primary_selected = false;
    private boolean hasInitted = false;
    private int telecom_value = 4;
    public Logica(){

    }
    //documentado con diagrama de flujo
    public void act(){  
        panelButtons = getButtons();
        for(int e=0;e<14;e++){ //si una compuerta
            if(panelButtons[e] == true){ //es true
                button_instance = e; //guardo el numero de compuerta
                for(int f=0;f<14;f++){ //todos los botones menos el seleccionado son false
                    if(f != button_instance){
                        getWorld().getObjects(Button.class).get(f).setState(false);
                    }
                }
                if (button_instance<=4){ //si la operacion es de un registro
                    for(int er=14;er<=17;er++){ //obtener el registro primario
                        if(panelButtons[er] == true){
                            if(er==14){primary_reg = 1;}
                            if(er==15){primary_reg = 2;}
                            if(er==16){primary_reg = 3;}
                            if(er==17){primary_reg = 4;}
                        }
                    }
                    if(primary_reg != 99){ //if the register 1 are clicked
                        switch(button_instance){
                           case 0:
                           result = operacionRol(getBits(primary_reg));
                           setBits(primary_reg, result);
                           reset_vars();
                           break;
                           
                           case 1:
                           result = operacionRor(getBits(primary_reg));
                           setBits(primary_reg,result);
                           reset_vars();
                           break;
                           
                           case 2:
                           result = operacionNot(getBits(primary_reg));
                           setBits(primary_reg, result);
                           reset_vars();
                           break;
                           
                           case 3:
                           result = operacionDec(getBits(primary_reg));
                           setBits(primary_reg ,result);
                           reset_vars();
                           break;
                           
                           case 4:
                           result = operacionInc(getBits(primary_reg));
                           setBits(primary_reg,result);
                           reset_vars();
                           break;
                           }
                        }
                    }
                if (button_instance>=5 && button_instance<=13){//
                    for(int er=14;er<=17;er++){ //primary
                        if(panelButtons[er] == true && primary_selected == false){
                            if(er == 14){ primary_reg = 1; primary_selected = true;}
                            if(er == 15){ primary_reg = 2; primary_selected = true;}
                            if(er == 16){ primary_reg = 3; primary_selected = true;}
                            if(er == 17){ primary_reg = 4; primary_selected = true;}
                        }
                    }
                    for(int er=14;er<=17;er++){ //secondary
                        if(panelButtons[er] == true && er != primary_reg+13){
                            if(er == 14){ secondary_reg = 1; primary_selected = true;}
                            if(er == 15){ secondary_reg = 2; primary_selected = true;}
                            if(er == 16){ secondary_reg = 3; primary_selected = true;}
                            if(er == 17){ secondary_reg = 4; primary_selected = true;}
                        }
                    }
                    if(primary_reg != 99 && secondary_reg != 99){ //if the registers are clicked
                        boolean[] result2 = new boolean[4];
                        switch(button_instance){
                           case 5: //case mov
                           result2 = getBits(secondary_reg);
                           setBits(primary_reg, result2);
                           reset_vars();
                           break;
                           
                           case 6:
                           result2 = operacionAnd(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                           
                           case 7:
                           result2 = operacionNand(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg, result2);
                           reset_vars();
                           break;
                           
                           case 8:
                           result2 = operacionNor(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg ,result2);
                           reset_vars();
                           break;
                           
                           case 9:
                           result2 = operacionOr(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                           
                           case 10:
                           result2 = operacionSub(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                           
                           case 11:
                           result2 = operacionAdd(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                           
                           case 12:
                           result2 = operacionXnor(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                           
                           case 13:
                           result2 = operacionXor(getBits(primary_reg),getBits(secondary_reg));
                           setBits(primary_reg,result2);
                           reset_vars();
                           break;
                        }
                    }
                }
            }
        }
        if (regToInt(getBits(1))==getWorld().getObjects(rObjetive.class).get(0).getValue()){ //si el registro A es igual a el valor objetive
            int x = Greenfoot.getRandomNumber(14) + 1;
            getWorld().getObjects(rObjetive.class).get(0).setValue(x); //valor aleatorio para objetive
            restart_telecom();
            getWorld().getObjects(rocket.class).get(0).descendRocket();
        }
        if(hasInitted == false){
            getWorld().getObjects(Logica.class).get(0).initReg();
            hasInitted=true;
        }
        switch(button_instance){//truthTable
                        case 2: getWorld().getObjects(truthTable.class).get(0).setValue(1); break; //not
                        case 6: getWorld().getObjects(truthTable.class).get(0).setValue(5); break; //and
                        case 7: getWorld().getObjects(truthTable.class).get(0).setValue(6); break; //nand
                        case 8: getWorld().getObjects(truthTable.class).get(0).setValue(0); break; //nor
                        case 9: getWorld().getObjects(truthTable.class).get(0).setValue(2); break; //or
                        case 12: getWorld().getObjects(truthTable.class).get(0).setValue(3); break; //xnor
                        case 13: getWorld().getObjects(truthTable.class).get(0).setValue(4); break; //xor
        }        
        boolean Unselected = true; //si todas las compuertas estan en off
        for (int i = 0; i < 14; i++) {
            if (panelButtons[i]) {
                Unselected = false;
            }
        }
        if (Unselected) {
            getWorld().getObjects(truthTable.class).get(0).setValue(7);
        }
        if(getWorld().getObjects(rocket.class).get(0).getY() == 425){Greenfoot.setWorld(new winPanel());}//win
    }
    private void decrease_telecom(){
     telecom_value = getWorld().getObjects(levelBar.class).get(0).getValue();
     getWorld().getObjects(levelBar.class).get(0).setValue(telecom_value - 1);
     if(telecom_value == 0){
         Greenfoot.setWorld(new losePanel());
        }
    }
    private void restart_telecom(){getWorld().getObjects(levelBar.class).get(0).setValue(4);}
    private void reset_vars(){ //despues que una compuerta sea utilizada
        setButtonsOff();
        this.primary_reg = 99;
        this.secondary_reg = 99;
        this.button_instance = 99;
        this.primary_selected = false;
        decrease_telecom();
        getWorld().getObjects(alert.class).get(0).setState(false);
        if(Greenfoot.getRandomNumber(32) == 13){
            initReg();
            getWorld().getObjects(alert.class).get(0).setState(true);
        }
    }
    protected void initReg(){
        for(int i=4;i<16;i++){
            if(Greenfoot.getRandomNumber(2) == 1){
                getWorld().getObjects(Bit.class).get(i).setState(true);
            }
            else{
                getWorld().getObjects(Bit.class).get(i).setState(false);
            }
        }
    }
    
    private int regToInt(boolean reg[]){
        int resultado = 0;
        for(int i=0;i<4;i++){
            if(reg[i] == true && i==0){resultado+=8;}
            if(reg[i] == true && i==1){resultado+=4;}
            if(reg[i] == true && i==2){resultado+=2;}
            if(reg[i] == true && i==3){resultado+=1;}
        }
        return resultado;
    }
    //buttons
    private boolean[] getButtons(){
        boolean[] result = new boolean[18];
        for(int i=0;i<18;i++){
            result[i] = getWorld().getObjects(Button.class).get(i).getState();
        }
        //1reg 0Rol, 1Ror, 2Not, 3Dec 4Inc
        //2reg 5Mov, 6And, 7Nand, 8Nor,  9Or,  10Sub, 11Add, 12xnor, 13xor
        //14 regA, 15 regB, 16 regC, 17 regD
        return result;
    }
    private void setButtonsOff(){
        for(int i=0; i<18;i++){ getWorld().getObjects(Button.class).get(i).setState(false);}           
    }
    
    //reg
    private boolean[] getBits(int reg){
        boolean[] result = new boolean[4];
        switch(reg){
        case 1: for(int a=0;a<=3;a++){result[a] = getWorld().getObjects(Bit.class).get(a).getState();} break;
        case 2: for(int b=0;b<=3;b++){result[b] = getWorld().getObjects(Bit.class).get(b+4).getState();} break;
        case 3: for(int c=0;c<=3;c++){result[c] = getWorld().getObjects(Bit.class).get(c+8).getState();} break;
        case 4: for(int d=0;d<=3;d++){result[d] = getWorld().getObjects(Bit.class).get(d+12).getState();} break;
        }
        return result;
    }
    private void setBits(int reg, boolean states[]){
        switch(reg){
        case 1: for(int a=0;a<=3;a++){getWorld().getObjects(Bit.class).get(a).setState(states[a]);} break;
        case 2: for(int b=0;b<=3;b++){getWorld().getObjects(Bit.class).get(b+4).setState(states[b]);} break;
        case 3: for(int c=0;c<=3;c++){getWorld().getObjects(Bit.class).get(c+8).setState(states[c]);} break;
        case 4: for(int d=0;d<=3;d++){getWorld().getObjects(Bit.class).get(d+12).setState(states[d]);} break;
        }
    }
    /*private boolean[] getBits(int from, int until){
        boolean[] result = new boolean[until-from];
        int cont = 0;
        for(int i=from;i<=until;i++){
            result[cont] = getWorld().getObjects(Button.class).get(i).getState();
            cont++;
        }
        return result;
    }
    private void setBits(int from, int until, boolean states[]){
        int cont = 0;
        for(int i=from;i<=until;i++){
            getWorld().getObjects(Button.class).get(i).setState(states[cont]);
            cont++;
        }
    }
    */
    //logics
    private boolean[] operacionAdd(boolean[] registro1, boolean[] registro2) {
        boolean[] resultado = new boolean[4];
        boolean carry = false;
        for (int i = 3; i >= 0; i--) {
            resultado[i] = registro1[i] ^ registro2[i] ^ carry;
            carry = (registro1[i] && registro2[i]) || (registro1[i] && carry) || (registro2[i] && carry);
        }
        return resultado;
        }
    protected boolean[] operacionAnd(boolean[] registro1, boolean[] registro2) {
        boolean[] resultado = new boolean[4];
        for(int i=0;i<4;i++){
            if(registro1[i] == true && registro2[i] == true){
                resultado[i]=true;
            }
            else{
                resultado[i]=false;
            }
        }
        return resultado;
    }
    protected boolean[] operacionDec(boolean[] registro1) {
    boolean[] resultado = new boolean[registro1.length];
    boolean acarreo = true;  // Inicializamos el acarreo en true para la resta
    for (int i = registro1.length - 1; i >= 0; i--) {
        boolean bitActual = registro1[i];
        boolean resta = bitActual ^ acarreo;
        resultado[i] = resta;
        // Actualizamos el acarreo para la siguiente iteración
        acarreo = !bitActual && acarreo;
    }
    return resultado;
} 
    protected boolean[] operacionInc(boolean[] registro1) {
        boolean[] resultado = new boolean[4];
        boolean acarreo = true;
        for (int i = 3; i >= 0; i--) {
            boolean bitActual = registro1[i];
            boolean suma = bitActual ^ acarreo;
            acarreo = bitActual && acarreo;
            resultado[i] = suma;
        }
        return resultado;
    }
    protected boolean[] operacionNand(boolean[] registro1,boolean[] registro2) {
        boolean[] resultado = new boolean[4];
        for (int i = 0; i < 4; i++) {
            resultado[i] = !(registro1[i] && registro2[i]);
        }
        return resultado;
    }
    protected boolean[] operacionNor(boolean[] registro1,boolean[] registro2) {
        boolean[] resultado = new boolean[4];
        for (int i = 0; i < 4; i++) {
        resultado[i] = !(registro1[i] || registro2[i]);
        }
        return resultado;
    }
    protected boolean[] operacionNot(boolean[] registro1) {
        boolean[] resultado = new boolean[4];
        for(int i=0;i<4;i++){
            resultado[i] = !registro1[i];
        }
        return resultado;
    }
    protected boolean[] operacionOr(boolean[] registro1, boolean[] registro2) {
    boolean[] resultado = new boolean[4];
    for (int i = 0; i < 4; i++) {
        resultado[i] = registro1[i] || registro2[i];
    }
    return resultado;
    }
    protected boolean[] operacionRol(boolean[] registro1) {
    boolean[] resultado = new boolean[4];
    for (int i = 0; i < 3; i++) {
        resultado[i] = registro1[i + 1];
    }
    resultado[3] = registro1[0];
    return resultado;
    }
    protected boolean[] operacionRor(boolean[] registro1) {
    boolean[] resultado = new boolean[4];
    resultado[0] = registro1[3];
    for (int i = 1; i < 4; i++) {
        resultado[i] = registro1[i - 1];
    }
    return resultado;
    }
    protected boolean[] operacionXor(boolean[] registro1, boolean[] registro2) {

    boolean[] resultado = new boolean[4];
    for (int i = 0; i < 4; i++) {
        // Realiza la operación XOR entre los bits correspondientes de registro1 y registro2.
        resultado[i] = registro1[i] ^ registro2[i];
    }
    return resultado;
    }
    protected boolean[] operacionXnor(boolean[] registro1, boolean[] registro2) {
    boolean[] resultado = new boolean[4];
    for (int i = 0; i < 4; i++) {
        resultado[i] = registro1[i] == registro2[i];
    }
    return resultado;
    }
    protected boolean[] operacionSub(boolean[] registro1, boolean[] registro2) {
    boolean[] resultado = new boolean[4];
    boolean borrow = false;
    for (int i = 3; i >= 0; i--) {
        resultado[i] = registro1[i] ^ registro2[i] ^ borrow;
        borrow = (!registro1[i] && registro2[i]) || (!registro1[i] && borrow) || (registro2[i] && borrow);
    }
    return resultado;
    }
}

