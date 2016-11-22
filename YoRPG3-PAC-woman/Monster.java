//Team PAC-woman
//Augie Murphy, Carol Pan, Pacy Yan
//APCS1 pd3
//HW32--Ye Olde Role Playing Game, Expanded
//2016-11-20

public class Monster extends Character{


//default constructor
    public Monster(){ 
	hp = 150;
	strength = (int)(Math.random() * 45 + 20);
	defense = 20;
	attack = 5;
    }
}
