//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Character{
    // ------------- INSTANCE VARIABLES -------------
    protected int hp; 
    protected int strength;
    protected int defense;
    protected double attack;
    protected int origStr;
    protected int origDef;
    //protected Character breed;
    //----------------------------------------------

    //CONSTRUCTORS
    public Character(){ //default constructor, initialiazes all instance vars
	hp = 100;
	strength = 25;
	defense = 25;
	attack = 5.0;
	origStr = strength;
	origDef = defense;
    }
    
    public Character(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
	hp = vida;
	strength = fuerte;
	defense = def;
	attack = ATTACK;
    }

    //METHODS
    public boolean isAlive(){ //tells whether Character alive
	return hp > 0; //returns boolean indicating dead or alive
    }
    
    public int getDefense(){
	return defense; //access defense attribute
    }
    

    public String getName(){
	return "I don't rightly know";
    }
    
    public void lowerHP( int damage ){
	hp -= damage; //lowers hp by damage
    }
    
    public int attack( Character attackee ){ //Monster parameter
	int damage = (int)(this.strength * this.attack - attackee.getDefense()); //calculates damage
	attackee.lowerHP(damage); //lowers hp by damage
	return damage;
    }
    
    public String about(){
	return "Standard character. Move along now";
    }
    
    public void specialize(){ //prepares warrior to perform a special attack
	double powerUp = defense * .5;
	strength = (int) (strength + powerUp); //increases strength
	defense = (int) (defense - powerUp); //decreases defense
	    }
    
    public void normalize(){ //prepares warrior to perform a normal attack
	strength = origStr; //resets strength attribute
	defense = origDef; //resets defense attribute
    }

}
