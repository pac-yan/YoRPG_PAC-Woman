/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG 
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
	int breed = 0;
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	s = "\nWhat manner of fighter art thou? (Choose a class)\n";

	s += "\t1: Warrior\n";
	s += "\t2: Mage\n";
	s += "\t3: Rogue\n";
	s += "\t4: Archer\n";
	s += "\t5: Warrior Princess\n";
	s += "Selection: ";
	System.out.println(s);

	try{
	    breed = Integer.parseInt(in.readLine());
	}
	catch(IOException e) {}
	
	//instantiate the player's character
	if (breed == 1) { pat = new Warrior (name,150,35,50,5);}
	else if (breed == 2) { pat = new Mage (name,150,35,50,5);}
	else if (breed == 3) { pat = new Rogue (name,150,30,25,6);}
	else if (breed == 4) { pat = new Archer (name,150,30,25,6);}
	else {pat = new WarriorPrincess (name,150,35,50,5);}

	System.out.println(pat.about());

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();
		if (pat.speed > smaug.speed)
		    return attackMethodA(pat, smaug);
		else
		    return attackMethodB(smaug, pat);
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //attack method for when speed of fighter > speed of monster
    public static boolean attackMethodA(Character a, Character b){
	int d1,d2;
	d1 = a.attack( b );
	System.out.println( "\n" + a.getName() + " dealt " + d1 +
			    " points of damage.");
	if (b.isAlive()){
	    d2 = b.attack( a );	    
	    System.out.println( "\n" + "Ye Olde Monster smacked " + a.getName() + " for " + d2 + " points of damage.");
	    if (!a.isAlive()){
		System.out.println( "Ye olde self hath expired. You got dead.") ;		return false;
	    }
	    else
		return true;
	}
	else {
	    System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
	    return true;
	}
    }
    //monster speed > fighter speed
    public static boolean attackMethodB(Character a, Character b){
	int d1,d2;
	d1 = b.attack( a );
	d2 = a.attack( b );

	System.out.println( "\n" + "Ye Olde Monster smacked " + b.getName() +
			    " for " + d2 + " points of damage.");
	System.out.println( "\n" + b.getName() + " dealt " + d1 +
			    " points of damage.");
    
    //option 1: you & the monster perish
	if ( !a.isAlive() && !b.isAlive() ) {
	    System.out.println( "'Twas an epic battle, to be sure... " + 
				"Ye olde monster cut you down, but " +
				"with thy dying breath the brave fighter " +
				"laid a fatal blow upon its skull." );
	    return false;
	}
	//option 2: you slay the beast
	else if ( !a.isAlive() ) {
	    System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
	    return true;
	}
	//option 3: the beast slays you
	else if ( !b.isAlive() ) {
	    System.out.println( "Ye olde self hath expired. You got dead." );
	    return false;
	}
	else
	    return true;
    }
    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*================================================
	  ================================================*/
    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
