/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dani
 */
public class GameMachine implements Element, Steppable {
 
    //Tárolja, hogy a játékgép melyik csempén van.
    private Tile tile;
    
    //Meghívja a csempére azt a függvényt, amely invertálja a szomszédos csempék jingled változóját.
    public void invertJingled() {
        tile.invertNeighborsJingled();
    }
    
    //Véletlenszerűen meghívja az invertJingled() függvényt.
    @Override
    public void step() {
        if(Math.random() < 0.4){
                invertJingled();
        }
    }
    
    //Nem történik semmi, ha játékgépbe ütközik orangután.
    @Override
    public void hitBy(Orangutan o) { }

    //Nem történik semmi, ha játékgépbe ütközik panda.
    @Override
    public void hitBy(Panda p) { }

    //Játékgép nem ütközhet semmibe.
    @Override
    public void collideWith(Element e) { }

    //Beállítja a tile attribútumot az argumentumként kapott tl-re.
    public void setTile(Tile tl){
        tile = tl;
    }
}
