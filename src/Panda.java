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

	public void breakOut() {
		// TODO - implement Panda.breakOut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public void hitBy(Orangutan o) {
		// TODO - implement Panda.hitBy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void collideWith(Element e) {
		// TODO - implement Panda.collideWith
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 */
	public void follow(Tile t) {
		// TODO - implement Panda.follow
		throw new UnsupportedOperationException();
	}

	public void step() {
		// TODO - implement Panda.step
		throw new UnsupportedOperationException();
	}

	public void ledOut() {
		// TODO - implement Panda.ledOut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param m
	 */
	public void setHeldByMoveable(Moveable m) {
		// TODO - implement Panda.setHeldByMoveable
		throw new UnsupportedOperationException();
	}

	public void fall() {
		// TODO - implement Panda.fall
		throw new UnsupportedOperationException();
	}
}
