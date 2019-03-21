/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dani
 */
public class Exit implements Element {
    
    //Tárolja, hogy melyik csempe jelképezi a játékmezőn a bejáratot.
    private Tile entrance;
    
    //Lekezeli azt a szituációt, amikor orangután ütközik a kijáratba.
    @Override
    public void hitBy(Orangutan o) {
        o.leadOut(); //Amennyi pandát vitt ki az orangután, annyi pontot fog kapni érte. Ez a függvény meghívja a pandákra a ledOut() függvényt is.
        entrance.accept(o); //Áthelyezi az orangutánt a bejárathoz.
    }
    
    //Nem történik semmi, ha kijáratba ütközik panda.
    @Override
    public void hitBy(Panda p) { }
    
    //Kijárat nem ütközhet semmibe.
    @Override
    public void collideWith(Element e) { }
}
