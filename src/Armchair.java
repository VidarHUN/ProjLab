

public class Armchair implements Element, Steppable{
    
    private int countToDrop;
    private Tile tile;
    private SleepyPanda panda;
    
    public Armchair(Tile tl){
        tile = tl;
    }
    
    /**
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
            countToDrop = 10;
            Tile tmp = new Tile();
            sp.setTile(tmp);
    }
    
    @Override
    public void step() {
            if(countToDrop > 0  && panda != null) countToDrop--;
            else if(countToDrop < 1 && panda == null);
            else if(countToDrop < 1 && panda != null) drop();
            else;
    }

    @Override
    public void hitBy(Orangutan o) {  }

    @Override
    public void hitBy(Panda p) {  }

    @Override
    public void collideWith(Element e) { }
}
