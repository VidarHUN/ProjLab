
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public abstract class Panda extends Moveable implements Steppable{

    private Moveable heldByMoveable;
    private Controller controller;
    private boolean free = true;

	// a lánc felbontásához használt metódus
        public void breakOut() {
            if(getHoldsPanda()!=null) {   //megkeressük azt a pandát, aki már nem fogja senki kezét
                getHoldsPanda().breakOut();
            }
            heldByMoveable.setHoldsPanda(null);    //az előttünk lévő elengedi a mi kezünket
            setHeldByMoveable(null);    //elengedjük az előttünk lévő kezét
	}

	/**
	 * 
	 * @param o: az orangután, ami ütközik az adott pandával
	 */
	public void hitBy(Orangutan o) {
            o.add(this);
            setFree(false);
            
	}

	/**
	 * 
	 * @param e
	 */
	public void collideWith(Element e) {
            e.hitBy(this);
	}

	/** a panda követi az előtte lévőt, abstract, mivel minden panda típus lépése végén más esemény hívódik meg
	 * 
	 * @param t: az a csempre, amire a pandának lépnie kell majd
	 */
	public abstract void follow(Tile t);

	//lép a panda, abstract, mivel minden panda típus lépése végén más esemény hívódik meg
        public abstract void step();

        /**
         * 
         * @param i: ezt az értéket növeli a panda, számolva hogy hány pontot kell kapnia az orangutánnak
         */
        public void ledOut() {
            if(getHoldsPanda() != null) {   //végigmegyünk az egész láncon, végignövelve az i értékét
                getHoldsPanda().ledOut();
            }
            getTile().remove();   //eltávolítjuk a csempéről a pandát
            controller.removePanda(this);   //majd a játékból is
	}

	/**
	 * 
	 * @param m: az a mozgó egység, amelyik a panda kezét fogja fogni és így vezetni is azt
	 */
	public void setHeldByMoveable(Moveable m) {
            heldByMoveable = m;
	}

	//lezuhan a panda
        public void fall() {
            if(free==false) { breakOut();}   //ha a pandát vezették, akkor felbomlik a mögötte lévő sor
            getTile().remove();   //eltávolítjuk a csempéről
            controller.removePanda(this);   //majd a játékból is
	}
        /**
         * 
         * @param f 
         */
        public void setFree(boolean f) {free = f;}
        
        public boolean getFree() {return free;}
        
        //a lehetséges szomszédok közül választ egyet véletlenszerűen
        public int pickRandomNeighbor() {
            Random r = new Random();
            int n = r.nextInt(getTile().getNeighborCount());   //lekérdezzük, hogy a csempének, amin a panda áll, hány szomszédja van
            return n;
        }
}
