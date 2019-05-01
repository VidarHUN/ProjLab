import javafx.animation.AnimationTimer;

import java.awt.event.ActionEvent;
import java.util.Map;

public class GameController {

    private Map<Tile, TileView> tiles;
    private Map<BreakableTile, TileView> breakableTiles;
    private Map<Tile, TileView> selectedTileO1;
    private Map<Tile, TileView> selectedTileO2;
    private Map<Orangutan, ElementView> orangutans;
    private Map<SleepyPanda, ElementView> sleepyPandas;
    private Map<JingleFearPanda, ElementView> jingleFearPandas;
    private Map<PipingFearPanda, ElementView> pipingFearPandas;
    private Map<Armchair, ElementView> armchairs;
    private Map<ChocoMachine, ElementView> chocoMachines;
    private Map<GameMachine, ElementView> gameMachines;
    private Map<Cupboard, ElementView> cupboards;
    private Map<Exit, ElementView> exit;
    private AnimationTimer timer;;

    public void Move() {

    }
    public void newTileSelectedO1(Tile newTile){

    }
    public void newTileSelectedO2(Tile newTile){

    }
    public void Initialize(){

    }
    public void update(){

    }
    private void handleStartGame(ActionEvent event){

    }

}
