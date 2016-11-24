//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Rogue extends Character {
    //Initizialize all attributes
    private String name;

    //CONSTUCTORS
    public Rogue(){
	super();
    }
    public Rogue(String nombre){ //overloaded constructor
	this();
	name = nombre;
    }    
    public Rogue(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
	name = nombre;
	hp = vida;
	strength = fuerte;
	origStr = fuerte;
	defense = def;
	origDef = def;
	attack = ATTACK;
    }
   
    public String getName(){ 
	return name;
    }

    public String about(){
	String retStr = "\tThe Rogue is a shadow of the night.\n";
	retStr += "\tThey devote their lives to stealth, and strike without warning.\n";
	retStr += "\tAll who meet one: check your pockets.\n";
	return retStr;
    }
    public void specialize(){
	double powerUp = defense * .5;
	strength = (int) (strength + powerUp);
	defense = (int) (defense - powerUp);
    }
    public void normalize(){
	strength = origStr;
	defense = origDef;
    } 
}
