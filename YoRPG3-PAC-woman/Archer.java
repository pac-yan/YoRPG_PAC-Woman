//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Archer extends Character {
    //Initizialize all attributes
    private String name;

    //CONSTUCTORS
    public Archer(){
	super();
    }
    public Archer(String nombre){ //overloaded constructor
	this();
	name = nombre;
    }    
    public Archer(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
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
	String retStr = "\tThe archer is the ultimate long-range combatist.\n";
	retStr += "\tA great ally in any battle for they aim where it hurts.\n";
	retStr += "\tOne can only be grateful nukes have yet to be invented.\n";
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
