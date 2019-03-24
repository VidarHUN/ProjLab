
import java.util.ArrayList;

public class Controller {
    
    private static final Controller INSTANCE = new Controller();
    
    private static boolean endGame;
    
    private static Clock clock = new Clock();
    private static Orangutan orangutan = new Orangutan();
    private static ArrayList<Panda> pandas = new ArrayList<Panda>();
    private static ArrayList<Tile> tiles = new ArrayList<Tile>();
    
    private Controller(){}
    
    public static Controller getInstance(){
        return INSTANCE;
    }
    //beállítja az orangután attribútumot
    public void setOrangutan(Orangutan ogtn){
        orangutan = ogtn;
    }
    
    //visszaadja az orangután attribútumot
    public Orangutan getOrangutan(){return orangutan;}
    
    //Elindítja a játékot.
    public void startGame() {
        /*
        Tile middle = new Tile();
        Tile bottom = new Tile();
        middle.setNeighborAt(2, bottom);
        bottom.setNeighborAt(0, middle);
        Tile right = new Tile();
        middle.setNeighborAt(1, right);
        right.setNeighborAt(3, middle);
        Tile left = new Tile();
        middle.setNeighborAt(3, left);
        left.setNeighborAt(1, middle);
        Armchair ac = new Armchair();
        Tile top = new Tile(ac);
        ac.setTile(top);
        Panda sp = new SleepyPanda();
        Controller.getInstance().addPanda(sp);
        right.setMoveable(sp);
        orangutan = new Orangutan();
        middle.setMoveable(orangutan);*/
        
        endGame = false;
        try{
            while(!endGame){
                clock.tick();
                if(pandas.isEmpty()) endGame();
                Thread.sleep(2000);
            }
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Game Over!");
    }

    //Lezárja a játékot
    public void endGame() {
        endGame = true;
    }
    
    //beállítja a clock attribútumot
    public void setClock(Clock clk){
        clock = clk;
    }
    
    //visszaadja a clock attribútumot
    public Clock getClock(){
        return clock;
    }
    
    //hozzáad egy csempét a játékhoz
    public void addTile(Tile tl){
        tiles.add(tl);
    }
    
    //visszaadja az összes csempét
    public ArrayList<Tile> getTiles(){
        return tiles;
    }
    
    //hozzáad egy új pandát a játékhoz
    public void addPanda(Panda pnd){
        pandas.add(pnd);
    }

    //elvesz egy pandát a játékból
    public void removePanda(Panda pnd) {
        pandas.remove(pnd);
    }
}
