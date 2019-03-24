/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public class JingleFearPanda extends Panda {
    
        //a panda megijed és felbontja a láncot, amiben volt
        public void fear() {
            if(getTile().getJingled()==true) {   //megnézzük, hogy csilingelt-e az adott csempe bármelyik szomszédja
                if(getFree()==false) {   //ha igen, megnézzük, hogy szabad-e a panda
                    breakOut();   //ha nem, akkor felbontjuk a láncot
                }
            }
	}

    @Override
        public void step() {
            if(!getFree()) {   //megnézzük, hogy szabad-e a panda, ha igen akkor léptetjük
                move(pickRandomNeighbor());
            }
            fear();
	}
        
    @Override
        public void follow(Tile t) {
            t.accept(this);
            if(getHoldsPanda()!=null) {   //ha az adott pandát követi egy másik, akkor neki is meghívjuk a követési metódusát
                getHoldsPanda().follow(t);
            }
            fear();
	}

    @Override
    public void hitBy(Panda p) {
        //még mindig semmi
    }
}
