

public class Orangutan extends Moveable{
 
    private static final Controller CONTROLLER = Controller.getInstance();
    private int points = 0;

	/**
	 * 
	 * @param p
	 */
	public void addPoints(int p) {
		points += p;
	}

	public void leadOut() {
            
		if(holdsPanda != null){
                    addPoints(holdsPanda.count(0));
                    holdsPanda.ledOut();
                }
	}
        
        @Override
	public void fall() {
            CONTROLLER.endGame();
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
