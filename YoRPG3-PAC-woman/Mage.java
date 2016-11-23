//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Mage extends Character{
    //initializing attributes
    private String name;

    //CONSTRUCTOR
    public Mage(){
	super();
    }

    public Mage(String nombre){
	this();
	name = nombre;
    }
    public Mage(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
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
	String retStr = "\tThe mage is old, wise, and powerful.\n";
	retStr += "\tThey brew potions and elixirs that can save or kill you.\n";
	retStr += "\tBe careful to trust a mage, they only help for a price!\n";
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
