/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public class Armchair implements Element, Steppable{
    private int countToDrop;

	public void drop() {
		// TODO - implement Armchair.drop
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sp
	 */
	public void gyereRam(SleepyPanda sp) {
		// TODO - implement Armchair.gyereRam
		throw new UnsupportedOperationException();
	}

	public void step() {
		// TODO - implement Armchair.step
		throw new UnsupportedOperationException();
	}

    @Override
    public void hitBy(Orangutan o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hitBy(Panda p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collideWith(Element e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
