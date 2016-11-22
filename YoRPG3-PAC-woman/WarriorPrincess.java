//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20


public class WarriorPrincess extends Character{

        //initializing attributes
    private String name;

    //CONSTRUCTOR
    public WarriorPrincess(){
	super();
    }

    public WarriorPrincess(String nombre){
	this();
	name = nombre;
    }
    public WarriorPrincess(String nombre, int vida, int fuerte, int def, double ATTACK){ //overloaded constructor
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
	String retStr = "\tThe mighty Warrior Princess hath brilliance.\n";
	retStr += "\tShe is mighty by blade.\n";
	retStr += "\tShe is stronger than a thousand monsters.\n";
	retStr += "\tShe is brave and will take no lies.\n";
	retStr += "\tShe will rule our kingdom one day.\n";
	return retStr;
    }

    
}
