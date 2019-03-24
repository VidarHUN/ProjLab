
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */

/**
 * 
 * A csempéket reprezentáló osztály. Ezeken tárólódnak el a különböző elemek, 
 * de egyszerre egy csempén mindig csak egy elem lehet, ez igaz még a fotelre 
 * is, mivel a megvalósítás szempontjából a fotelben ülő panda nem azon a 
 * csempén van, amin maga a fotel is, hanem a fotelben.
 */
public class Tile {
    
    //Csempe szomszédai, melyek szintén csempék 
    private List<Tile> neighbors = new ArrayList<Tile>();
    
    //Szomszédos fotelek tárolása
    private List<Armchair> neighborChairs;
    
    //True, ha az előző körben egy szomszédos csokiautomata sípolt
    private boolean piped;
    
    //True, ha az előző körben egy szomszédos játékgép csilingelt
    private boolean jingled;
    
    //Az adott csempén lévő elem 
    Element element;
        
        /**
         * Konstruktor
         * @param e 
         */
        Tile(Element e){
            this.element = e; 
        }
        
        /**
         * Konstruktor
         */
        Tile() {}
        
        //Visszatér a csempén lévő elemmel. 
	public Moveable getMoveable() {
            return (Moveable) element; 
	}

	/**
	 * 
	 * @param mvbl
         * Beállítja a csempén lévő moveable-t
	 */
	public void setMoveable(Moveable mvbl) {
            this.element = (Element) mvbl; 
	}
        
        //element setter
        public void setElement(Element lmnt){
            element = lmnt;
        }

	/**
	 * 
	 * @param mvbl
         * Megvizsgálja, hogy a csempére rá tud-e lépni a paraméterben megadott 
         * moveable, vagy nem.
	 */
	public void accept(Moveable mvbl) {
            if (element == null){
                setMoveable(mvbl);
                mvbl.leave();
            }else {
                 mvbl.collideWith(element);
            }
	}

	/**
	 * 
	 * @param idx
         * Visszatér a paraméterben megadott indexű szomszéd csempével.
         * @return 
	 */
	public Tile getNeighbor(int idx) {
            return neighbors.get(idx);
	}
        
        /**
         * @param idx Ez az új csempe indexe
         * @param tl Ez a szmszéd amit hozzá akarunk adni
         * 
         * Ez a metódus fix indexhez ad hozzá újcsempét a szomszédok közé.
         */
        public void setNeighborAt(int idx, Tile tl){
            neighbors.add(idx, tl);
        }
        
        /**
         * Leszedi a csempén lévő elemet a csempéről.
         */
	public void remove() {
            this.element = null; 
	}
        
        /**
         * Visszatér egy szabad/üres szomszédos fotellel.
         * @return 
         */
	public Armchair getFreeNeighborChair() {
            int count = 0; 
            for (Armchair a : neighborChairs){
                if(a.isFree() == true){
                    count++;
                    break;
                }
                count++;
            }
            return neighborChairs.get(count);
	}
        
        /**
         * Ez a metódus, polimorfizmus miatt van itt, ebben az osztályban nem csinál semmit.
         * Ezt a metódust hívja meg az a panda, amelyik ugrik, és akkor csinál valamit,
         * ha az adott csempe törhető.
         * */
	public void loseLifePoint() {}


	/**
	 * 
	 * @param mvbl
         * Elhelyezi az adott moveablet egy szabad szomszédos csempére.
	 */
	public void placeMoveableOnNeighbor(Moveable mvbl) {
            Tile tmp = new Tile(); 
            tmp.setMoveable(mvbl); 
                if (element != null){
                    for (Tile t : neighbors){
                        t.accept(mvbl);
                        this.element = tmp.getMoveable();
                }
            }
	}  

	/**
	 * 
	 * @param j
         * Beállítja a jingled attribútumot a paraméterben megadottra
	 */
	public void setJingled(boolean j) {
		this.jingled = j;
	}

	/**
	 * 
	 * @param p
         * Beállítja a piped attribútumot a paraméterben megadottra.
	 */
	public void setPiped(boolean p) {
		this.piped = p;
	}
        
        /**
         * 
         * @return 
         * Visszatért a jingled attribútum értékével.
         */
	public boolean getJingled() {
		return this.jingled;
	}
        
        /**
         * 
         * @return 
         * Visszatért a piped attribútum értékével.
         */
	public boolean getPiped() {
		return this.piped;
	}
        
        /**
         * Visszatér a szomszédok számával 
         * @return 
         */
        public int getNeighborCount(){
            return neighbors.size();
        }
        
        /**
         * Beállítja a szomszédos csempék piped boolean attribútumát az 
         * ellenkezőjére
         */
	public void invertNeighborsPiped() {
            boolean tmp;
            for (Tile t : neighbors){
                tmp = t.getPiped();
                t.setPiped(!tmp);
            }
	}
        
        /**
         * Beállítja a szomszédos csempék jingled boolean attribútumát az 
         * ellenkezőjére.
         */
	public void invertNeighborsJingled() {
            boolean tmp;
            for (Tile t : neighbors){
                tmp = t.getJingled();
                t.setJingled(!tmp);
            }
	}
}
