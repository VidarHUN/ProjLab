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
    
    private Panda holdsPanda;
    private Tile tile;
    /**
	 * 
	 * @param idx
	 */
	public void move(int idx) {
		// TODO - implement Moveable.move
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public abstract void hitBy(Orangutan o);

	/**
	 * 
	 * @param p
	 */
	public abstract void hitBy(Panda p);

	/**
	 * 
	 * @param e
	 */
	public void collideWith(Element e) {
		// TODO - implement Moveable.collideWith
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public void setHoldsPanda(Panda p) {
		// TODO - implement Moveable.setHoldsPanda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public int count(int c) {
		// TODO - implement Moveable.count
		throw new UnsupportedOperationException();
	}

	public Tile getTile() {
		// TODO - implement Moveable.getTile
		throw new UnsupportedOperationException();
	}

	public void fall() {
		// TODO - implement Moveable.fall
		throw new UnsupportedOperationException();
	}

	public void leave() {
		// TODO - implement Moveable.leave
		throw new UnsupportedOperationException();
	}
}
