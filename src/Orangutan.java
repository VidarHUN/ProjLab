

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
	 * @param pnd Az a panda, amelyik most fog sorba fűződni.
         * Ez a metódus az orangután sorához hozzáadja a paraméterben megkapott pnadát.
	 */
	public void add(Panda pnd) {
		if(holdsPanda != null){
                    holdsPanda.setHeldByMoveable(pnd);
                    pnd.setHoldsPanda(holdsPanda);
                }
                holdsPanda = pnd;
                holdsPanda.setHeldByMoveable(this);
                holdsPanda.setFree(false);
	}
        
        //Azt az eseményt kezeli le, amikor orangután ütközik valami mással
        @Override
        public void collideWith(Element lmnt){
            lmnt.hitBy(this);
        }

    @Override
    public void hitBy(Orangutan o) {}

    @Override
    public void hitBy(Panda p) {}
}
