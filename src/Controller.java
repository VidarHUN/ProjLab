
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
    
    public void setOrangutan(Orangutan ogtn){
        orangutan = ogtn;
    }
    
    public Orangutan getOrangutan(){return orangutan;}
    
    
    public void startGame() { 
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

    public void endGame() { 
        endGame = true;
    }
    
    public void setClock(Clock clk){
        clock = clk;
    }
    
    public Clock getClock(){
        return clock;
    }
    
    public void addTile(Tile tl){
        tiles.add(tl);
    }
    
    public ArrayList<Tile>getTiles(){
        return tiles;
    }
    
    public void addPanda(Panda pnd){
        pandas.add(pnd);
    }

    public void removePanda(Panda pnd) {
        pandas.remove(pnd);
    }
}
