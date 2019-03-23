

public class Orangutan extends Moveable{
 
    private int points = 0;

	/**
	 * 
	 * @param p A pontszám amit hozzá szeretnénk adni.
         * Ez a metódus a paraméterben megadott pontszámot hozzáadja a játékos pontszámához.
	 */
	public void addPoints(int p) {
		points += p;
	}

        /**
         * Ez a metódus kivezeti azokat a pandákat akiket az orangután 
        */
	public void leadOut() {
            
		if(holdsPanda != null){
                    addPoints(holdsPanda.count(0));
                    holdsPanda.ledOut();
                }
	}
        
        @Override
	public void fall() {
            Controller.getInstance().endGame();
	}

	/**
	 * 
	 * @param pnd
	 */
	public void add(Panda pnd) {
		if(holdsPanda != null){
                    holdsPanda.setHeldByMoveable(pnd);
                    pnd.setHoldsPanda(holdsPanda);
                }
                holdsPanda = pnd;
                holdsPanda.setHeldByMoveable(this);
	}

    @Override
    public void hitBy(Orangutan o) {}

    @Override
    public void hitBy(Panda p) {}
}
