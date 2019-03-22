

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
        if(panda != null){
            countToDrop = 10;
            Tile tmp = new Tile();
            sp.setTile(tmp);
            panda = sp;
        }
    }
    
    @Override
    public void step() {
            if(countToDrop > 0  && panda != null) countToDrop--;
            else if(countToDrop < 1 && panda == null);
            else if(countToDrop < 1 && panda != null) drop();
            else;
    }
    
    /**
     * Sorry, de senki nem válasszolt és siettem, ezért tettem bele egy ilyet, 
     * mert máshogy nem tudtam volna megvalósítani a getFreeNeighborChair 
     * metódust és ez tűnt a legegyszerűbbnek.
     * @author ricsi
     * @return 
     */
    public boolean isFree(){
        if(panda != null)
            return false;
        return true;
    }

    @Override
    public void hitBy(Orangutan o) {  }

    @Override
    public void hitBy(Panda p) {  }

    @Override
    public void collideWith(Element e) { }
}
