
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricsi
 */
public class Application {
    
    /**
	 * 
	 * @param args
     * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
            
            Controller controller = Controller.getInstance();
            Tile mainTile = new Tile();
            controller.addTile(mainTile);
            for (int i = 0; i < 4; i++)
            {
                mainTile.setNeighborAt(i, null);
            }
            
            //controller.startGame();
            
            selectMoveable(controller);
            
            System.out.println();
            
	}
        
        public static String selectMoveable(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, mivel szeretne lépni!");
            System.out.println("O: Orangután");
            System.out.println("SP: SleepyPanda");
            System.out.println("JFP: JingleFearPanda");
            System.out.println("PFP: PipingFearPanda");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            switch (str)
                    {
                        case "O":
                            Orangutan ogtn = new Orangutan();
                            cont.setOrangutan(ogtn);
                            cont.getTiles().get(0).setMoveable(ogtn);
                            System.out.println(selectDirectionForOrangutan(cont));
                            return "O";
                        case "SP":
                            SleepyPanda spnd = new SleepyPanda();
                            cont.addPanda(spnd);
                            cont.getTiles().get(0).setMoveable(spnd);
                            System.out.println(selectDirectionForPanda(cont));
                            return "SP";
                        case "JFP":
                            JingleFearPanda jpnd = new JingleFearPanda();
                            cont.addPanda(jpnd);
                            cont.getTiles().get(0).setMoveable(jpnd);
                            System.out.println(selectDirectionForPanda(cont));
                            return "JFP";
                        case "PFP":
                            PipingFearPanda ppnd = new PipingFearPanda();
                            cont.addPanda(ppnd);
                            cont.getTiles().get(0).setMoveable(ppnd);
                            System.out.println(selectDirectionForPanda(cont));
                            return "PFP";
                    }
            return null;
        }
        
        public static String selectDirectionForOrangutan(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, milyen irányba szeretne lépni!");
            System.out.println("N: North");
            System.out.println("E: East");
            System.out.println("S: South");
            System.out.println("W: West");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            Tile neighbour = new Tile();
            cont.addTile(neighbour);
            for (int i = 0; i < 4; i++)
            {
                neighbour.setNeighborAt(i, null);
            }
            
            switch (str)
                    {
                        case "N":
                            cont.getTiles().get(0).setNeighborAt(0, neighbour);
                            neighbour.setNeighborAt(2, cont.getTiles().get(0));
                            return "N";
                        case "E": 
                            cont.getTiles().get(0).setNeighborAt(1, neighbour);
                            neighbour.setNeighborAt(3, cont.getTiles().get(0));
                            return "E";
                        case "S": 
                            cont.getTiles().get(0).setNeighborAt(2, neighbour);
                            neighbour.setNeighborAt(0, cont.getTiles().get(0));
                            return "S";
                        case "W": 
                            cont.getTiles().get(0).setNeighborAt(3, neighbour);
                            neighbour.setNeighborAt(1, cont.getTiles().get(0));
                            return "W";
                    }
            return null;
        }
        
        public static String selectDirectionForPanda(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, milyen irányba szeretne lépni!");
            System.out.println("N: North");
            System.out.println("E: East");
            System.out.println("S: South");
            System.out.println("W: West");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            Tile neighbour = new Tile();
            for (int i = 0; i < 4; i++)
            {
                neighbour.setNeighborAt(i, null);
            }
            
            switch (str)
                    {
                        case "N": 
                            cont.getTiles().get(0).setNeighborAt(0, neighbour);
                            neighbour.setNeighborAt(2, cont.getTiles().get(0));
                            return "N";
                        case "E": 
                            cont.getTiles().get(0).setNeighborAt(1, neighbour);
                            neighbour.setNeighborAt(3, cont.getTiles().get(0));
                            return "E";
                        case "S": 
                            cont.getTiles().get(0).setNeighborAt(2, neighbour);
                            neighbour.setNeighborAt(0, cont.getTiles().get(0));
                            return "S";
                        case "W": 
                            cont.getTiles().get(0).setNeighborAt(3, neighbour);
                            neighbour.setNeighborAt(1, cont.getTiles().get(0));
                            return "W";
                    }
            return null;
        }
        
        
        public static String selectElementForOrangutan(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, milyen elemmel ütközzön a panda/orangután!");
            System.out.println("NO: No (semmivel sem ütközik)");
            System.out.println("SP: SleepyPanda");
            System.out.println("JFP: JingleFearPanda");
            System.out.println("PFP: PipingFearPanda");
            System.out.println("E: Exit");
            System.out.println("W: Wall (fal, pálya széle)");
            System.out.println("GM: GameMachine");
            System.out.println("CM: ChocoMachine");
            System.out.println("A: Armchair");
            System.out.println("C: Cupboard");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            switch (str)
            {
                case "NO": 
                    selectTileType(cont);
                    return "";
                case "SP": return "";
                case "JFP": return "";
                case "PFP": return "";
                case "E": return "";
                case "W": return "";
                case "GM": return "";
                case "CM": return "";
                case "A": return "";
                case "C": return "";
            }
            
            return null;
        }
        
        public static String selectElementForPanda(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, milyen elemmel ütközzön a panda/orangután!");
            System.out.println("NO: No (semmivel sem ütközik)");
            System.out.println("O: Orangután");
            System.out.println("SP: SleepyPanda");
            System.out.println("JFP: JingleFearPanda");
            System.out.println("PFP: PipingFearPanda");
            System.out.println("E: Exit");
            System.out.println("W: Wall (fal, pálya széle)");
            System.out.println("GM: GameMachine");
            System.out.println("CM: ChocoMachine");
            System.out.println("A: Armchair");
            System.out.println("C: Cupboard");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            switch (str)
            {
                case "NO": 
                    selectTileType(cont);
                    return "";
                case "SP": return "";
                case "JFP": return "";
                case "PFP": return "";
                case "E": return "";
                case "W": return "";
                case "GM": return "";
                case "CM": return "";
                case "A": return "";
                case "C": return "";
            }
            
            return null;
        }
        
        public static String selectTileType(Controller cont) throws IOException
        {
            System.out.println("Válassza ki, milyen típusú csempére lépjen a panda/orangután!");
            System.out.println("NO: No (sima csempe)");
            System.out.println("B: Breakable");
            System.out.println("BT: Broken Tile");
            System.out.println("GMT: GameMachine Tile (játékautomatával szomszédos csempe)");
            System.out.println("CMT: ChocoMachine Tile (csokiautomatával szomszédos csempe)");
            System.out.println("AT: ArmchairTile (fotellel szomszédos csempe)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            
            switch (str)
            {
                case "NO": return "";
                case "B": return "";
                case "BT": return "";
                case "GMT": return "";
                case "CMT": return "";
                case "AT": return "";
            }
            return null;
        }
}
