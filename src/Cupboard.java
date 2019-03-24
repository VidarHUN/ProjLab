/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dani
 */
public class Cupboard implements Element {
    
    //A szekrény "párja." Az a hely, ahová a moveable menni fog, ha ütközött a szekrénnyel.
    private Cupboard pair;
    //A csempe, amelyen a szekrény elhelyezkedik.
    private Tile tile;
    
    //Meghívja a teleportTo függvényt az orangutánra, ha az a szekrénnyel ütközött.
    @Override
    public void hitBy(Orangutan o) {
        pair.teleportTo(o);
    }
    
    //Meghívja a teleportTo függvényt a pandára, ha az a szekrénnyel ütközött.
    @Override
    public void hitBy(Panda p) {
        teleportTo(p);
    }
    
    //Áthelyezi a moveablet a szekrény párjával szomszédos csempék egyikére.
    public void teleportTo(Moveable mvbl) {
        tile.placeMoveableOnNeighbor(mvbl);
    }
    
    //Visszaadja a csempét, amelyen a szekrény van.
    public Tile getTile(){
        return tile;
    }
    
    //Szekrény nem ütközhet semmivel.
    @Override
    public void collideWith(Element e) { }
    
}
