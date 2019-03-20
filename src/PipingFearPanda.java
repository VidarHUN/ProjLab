/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public class PipingFearPanda extends Panda{
    
        //a panda ha megijed ugrik egyet
        public void jump() {
            if(getTile().getPiped()==true) {   //megnézzük, hogy az adott csempe bármelyik szomszédja sípolt-e
                getTile().loseLifePoint();   //ha igen és törékeny csempén állunk, akkor csökkentjük a csempre életpontjait
            }
	}

    @Override
	public void step() {
            if(getFree()==true) {   //megnézzük, hogy szabad-e a panda, ha igen akkor léptetjük
                move(pickRandomNeighbor());
            }
            jump();
	}

    
    @Override
        public void hitBy(Panda p) {
        //még mindig semmi
        }

    @Override
        public void follow(Tile t) {
            t.accept(this);
            if(getHoldsPanda()!=null) {   //ha az adott pandát követi egy másik, akkor neki is meghívjuk a követési metódusát
                getHoldsPanda().follow(t);
            }
            jump();
        }
}
