

public class Armchair implements Element, Steppable{
    
    private int countToDrop;
    private Tile tile;
    private SleepyPanda panda;
    
    
    

    /**
     * 
     * 
     * Ez a metódus kidobja a pandát az Armchairből.
     * 
     */
    public void drop() {
            panda.setStatus(true);
            tile.placeMoveableOnNeighbor(panda);
    }

    /**
     * Ez a metódus beleteszi a SleepyPandát az Armchairbe, amelyik bele szeretne menni.
     * 
     * @param sp Az a panda amelyik aludni szeretne.
     */
    public void gyereRam(SleepyPanda sp) {
            Tile tmp = new Tile();
            sp.setTile(tmp);
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
