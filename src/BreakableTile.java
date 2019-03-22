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
 * Speciális csempe, aminek van élettartama. Ha az nullára csökken, akkor a 
 * csempe eltörik, és a rajta álló állat meghal.
 */
public class BreakableTile extends Tile{
    
    //Ha a csempe eléri a nullát, akkor eltörik a csempe. 
    private int lifePoints = 20; 

	/**
	 * Ütközteti az elemeket
	 * @param mvbl
	 */
        @Override
	public void accept(Moveable mvbl) {
            if (this.getMoveable() == null){
                loseLifePoint();
                setMoveable(mvbl);
                mvbl.leave();
                if(lifePoints < 1){
                    mvbl.fall();
                }
            } else {
                mvbl.collideWith(element);
            }
	}
        
        /**
         * Csökkenti a tile élettartamát. Ha eléri a nullát, akkor minden 
         * állat, ami rálép meghal. 
         */
	public void loseLifePoint() {
            if (lifePoints > 0)
                lifePoints--; 
	}
}
