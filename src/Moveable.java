/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public abstract class Moveable implements Element {
 
    protected Panda holdsPanda;
    private Tile tile;
    /**
	 * 
	 * @param idx Az index amire mozgatni szeretnénk a moveable-t
         * Ez a metódus mothatja az aktuális moveable objektumot.
	 */
	public void move(int idx) {
                Tile oldTile = tile;
		tile.getNeighbor(idx).accept(this);
                if(holdsPanda != null) holdsPanda.follow(oldTile);
	}

	/**
	 * 
	 * @param o ütköző orangután
         * Ennek a metódusnak a polimorfizmus miatt van jelentősége.
	 */
        @Override
	public void hitBy(Orangutan o){}

	/**
	 * 
	 * @param p ütköző panda
         * Ennek a metódusnak a polimorfizmus miatt van jelentősége.
	 */
        @Override
	public void hitBy(Panda p){}

	/**
	 * 
	 * @param e ütköző Element
         * Ennek a metódusnak a polimorfizmus miatt van jelentősége.
	 */
        @Override
	public void collideWith(Element e) {}

	/**
	 * 
	 * @param pnd Új panda
         * Beállítja az aktuális objektum holdsPanda attribútumát a paraméterben kapottra.
	 */
	public void setHoldsPanda(Panda pnd) {
		holdsPanda = pnd;
	}

	/**
	 * 
	 * @param c számláló
         * Er a rekurzív metódus arra jó, hogy megszámolja hány darab panda van egy sorban.
     * @return int
	 */
	public int count(int c) {
		if(holdsPanda == null) return c + 1;
                else return holdsPanda.count(c + 1);
	}

	// Visszaadja a tile attribútumot.
	public Tile getTile() {
		return tile;
	}
        
	//Beállítja a tile attribútumot az argumentumként kapott tl-re.
	public void setTile(Tile tl){
		tile = tl;
	}

	//Ez a metódus a leesést kezeli.
	public abstract void fall();

	//Ez a metódus leveszi a pandát
	public void leave() {
		tile.remove();
	}
        
	//Visszaadja a holdaPanda attribútum értékét.
	public Panda getHoldsPanda() {
            return holdsPanda;
        }
}