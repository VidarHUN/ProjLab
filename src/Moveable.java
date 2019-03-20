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
	 * @param idx
	 */
	public void move(int idx) {
                Tile oldTile = tile;
		tile.getNeighbor(idx).accept(this);
                if(holdsPanda != null) holdsPanda.follow(oldTile);
	}

	/**
	 * 
	 * @param o
	 */
        @Override
	public abstract void hitBy(Orangutan o);

	/**
	 * 
	 * @param p
	 */
        @Override
	public abstract void hitBy(Panda p);

	/**
	 * 
	 * @param e
	 */
        @Override
	public void collideWith(Element e) {}

	/**
	 * 
	 * @param pnd
	 */
	public void setHoldsPanda(Panda pnd) {
		holdsPanda = pnd;
	}

	/**
	 * 
	 * @param c
     * @return int
	 */
	public int count(int c) {
		if(holdsPanda == null) return c;
                else return holdsPanda.count(c + 1);
	}

	public Tile getTile() {
		return tile;
	}
        
        public void setTile(Tile tl){
            tile = tl;
        }

	public abstract void fall();

	public void leave() {
		tile.remove();
	}
}
