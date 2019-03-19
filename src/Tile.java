/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public class Tile {
    private boolean piped;
	private boolean jingled;

	public Moveable getMoveable() {
		// TODO - implement Tile.getMoveable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mvbl
	 */
	public void setMoveable(Moveable mvbl) {
		// TODO - implement Tile.setMoveable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mvbl
	 */
	public void accept(Moveable mvbl) {
		// TODO - implement Tile.accept
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idx
	 */
	public Tile getNeighbor(int idx) {
		// TODO - implement Tile.getNeighbor
		throw new UnsupportedOperationException();
	}

	public void remove() {
		// TODO - implement Tile.remove
		throw new UnsupportedOperationException();
	}

	public Armchair getFreeNeighborChair() {
		// TODO - implement Tile.getFreeNeighborChair
		throw new UnsupportedOperationException();
	}

	public void loseLifePoint() {
		// TODO - implement Tile.loseLifePoint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mvbl
	 */
	public void placeMoveableOnNeighbor(Moveable mvbl) {
		// TODO - implement Tile.placeMoveableOnNeighbor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public void setJingled(boolean j) {
		this.jingled = j;
	}

	/**
	 * 
	 * @param p
	 */
	public void setPiped(boolean p) {
		this.piped = p;
	}

	public boolean getJingled() {
		return this.jingled;
	}

	public boolean getPiped() {
		return this.piped;
	}

	public void invertNeighborsPiped() {
		// TODO - implement Tile.invertNeighborsPiped
		throw new UnsupportedOperationException();
	}

	public void invertNeighborsJingled() {
		// TODO - implement Tile.invertNeighborsJingled
		throw new UnsupportedOperationException();
	}
}
