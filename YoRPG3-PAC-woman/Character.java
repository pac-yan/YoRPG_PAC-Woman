//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public abstract class Character{
    // ------------- INSTANCE VARIABLES -------------
    protected int hp; 
    protected int strength;
    protected int defense;
    protected double attack;
    protected int origStr;
    protected int origDef;
    protected int speed;
    //protected Character breed;
    //----------------------------------------------

    //CONSTRUCTORS
    public Character(){ //default constructor, initialiazes all instance vars
	hp = 150;
	strength = 35;
	defense = 25;
	attack = 5.0;
	origStr = strength;
	origDef = defense;
	speed = 1;
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
    
    public abstract String about();

    public abstract void specialize();

    public abstract void normalize();
    


}
