//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Warrior extends Character {
    //Initizialize all attributes
    private String name;

    //CONSTUCTORS
    public Warrior(){
	super();
    }
    public Warrior(String nombre){ //overloaded constructor
	this();
	name = nombre;
    }    
    public Warrior(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
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
	String retStr = "\tA warrior is of strong spirit, and stronger blade.\n";
	retStr += "\tThey adhere to infallible codes of chivalry, passed along generations.\n";
	retStr += "\tA warrior is often the first to jump into a dangerous situation.\n";
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
