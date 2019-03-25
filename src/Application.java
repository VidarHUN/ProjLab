
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Application {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String line;
        static Orangutan ogtn;
        static Moveable firstMvbl;
        static Moveable secondMvbl;
        static SleepyPanda sp;
        static JingleFearPanda jfp;
        static PipingFearPanda pfp;
        static Tile tl1;
        static Tile tl2;
        static Exit exit;
        static Element lmnt;
        static int idx;
        static Controller instance = Controller.getInstance();
    
	public static void main(String[] args) throws IOException {
            while(true){
                nullAttributes();
                ArrayList<String> params = readParams();
                if(params == null) continue;
                if(params.get(0).equals("q")) break;
                setAttributes(params);
                test();
            }
		
    }   //MAIN VÉGE
        //megvalósítja a teszteket
        static void test(){
            tl1.setNeighborAt(idx, tl2);
            firstMvbl.move(idx);
            if(ogtn != null){
                if(exit != null){
                    if(exit.getEntrance().getMoveable() == ogtn){
                        System.out.println("Az orangután sikeresen kilépett, majd belépett");
                    }
                } else {
                    if(tl2.getElement() == ogtn) System.out.println("Az orangután moveable sikeresen a második csempére lépett.");
                    if(tl1.getElement() == ogtn) System.out.println("Az orangután moveable nem tudott a második csempére lépni.");
                    if(secondMvbl != null && tl1.getElement() == secondMvbl) System.out.println("A követő panda sikeresen követett.");
                    if(secondMvbl != null && tl1.getElement() != secondMvbl) System.out.println("A követő panda nem tudott követni.");
                }
            } else if(sp != null){
                if(tl2.getMoveable() == sp) {
                    sp.checkChair();
                    System.out.println("A SleepyPanda a második csempére lépett.");
                }
                if(tl1.getMoveable() == sp) System.out.println("A SleepyPanda nem tudott a második csempére lépni.");

            } else if(pfp != null){
                if(tl2.getMoveable() == pfp) {
                    pfp.jump();
                    System.out.println("A Panda a második csempére lépett.");
                }
                if(tl1.getMoveable() == pfp) System.out.println("A panda nem tudott a második csempére lépni.");

            } else if(jfp != null){
                if(tl2.getMoveable() == jfp) {
                    jfp.fear();
                    System.out.println("A Panda a második csempére lépett.");
                }
                if(tl1.getMoveable() == jfp) System.out.println("A panda nem tudott a második csempére lépni.");
            }
        }   //TEST VÉGE
        
        //Kinulláz minden attribútumot
        static void nullAttributes(){
             line  = null;
             ogtn  = null;
             jfp = null;
             pfp = null;
             sp = null;
             firstMvbl = null;
             secondMvbl  = null;
             tl1  = null;
             tl2  = null;
             lmnt  = null;
             exit = null;
        }   //NULLATTRIBUTES VÉGE
	
        //beolvassa azt, hogy milyen paramétereket szeretne a felhasználó
	static ArrayList<String> readParams() throws IOException {
		ArrayList<String> ret = new ArrayList<>();
		System.out.println("Mivel szeretnél lépni? (O|SP|JFP|PFP)");
		readLine();
		if(line.equals("0")) return null;
                if(line.equals("q")){
                    ret.add(line);
                    return ret;
                }
		ret.add(line);
                
                System.out.println("Milyen irányba szeretnél lépni? (N|E|S|W)");
                readLine();
                if(line.equals("0")) return null;
                ret.add(line);
                
                System.out.println("Mivel szeretnél ütközni? (NO|O|SP|JFP|PFP|E|GM|CM|A|C)");
                readLine();
                if(line.equals("0")) return null;
                ret.add(line);
                
                System.out.println("Legyen-e ott különleges csempe, ha igen, milyen? (NO|B|BT|GMT|CMT|AT)");
                readLine();
                if(line.equals("0")) return null;
                ret.add(line);
                
                if(!ret.get(0).equals("O")) return ret;
                System.out.println("Kövesse-e panda? (I|N)");
                readLine();
                if(line.equals("0")) return null;
                ret.add(line);
                
                return ret;       
	}   //READPARAMS VÉGE
        
        //Beállítja az attribútumokat egy ArrayList alapján
        static void setAttributes(ArrayList<String> params){
            tl1 = new Tile();
            switch (params.get(0)){     //milyen moveable lép switch
                case "O":
                    firstMvbl = ogtn = new Orangutan();
                    break;
                    
                case "JFP":
                    firstMvbl = jfp = new JingleFearPanda();
                    break;
                    
                case "PFP":
                    firstMvbl = pfp = new PipingFearPanda();
                    break;
                    
                case "SP":
                    firstMvbl = sp = new SleepyPanda();
                    break;
                default:
                    return;
            }                       //milyen moveable lép switch vége
            
            tl1.setMoveable(firstMvbl);
            firstMvbl.setTile(tl1);
            
            switch (params.get(1)){  //irány switch
                case "N":
                    idx = 0;
                    break;
                    
                case "E":
                    idx = 1;
                    break;
                    
                case "S":
                    idx = 2;
                    break;
                    
                case "W":
                    idx = 3;
                    break;
                    
                default:
                    return;
            }                       //irány switch vége
            switch (params.get(2)){ //szomszédos csempén lévő element switch
                case "NO":
                    lmnt = null;
                    break;
                    
                case "O":
                    lmnt = new Orangutan();
                    break;
                    
                case "SP":
                    lmnt = new SleepyPanda();
                    break;
                    
                case "JFP":
                    lmnt = new JingleFearPanda();
                    break;
                    
                case "PFP":
                    lmnt = new PipingFearPanda();
                    break;
                    
                case "E":
                    exit = new Exit(new Tile());
                    lmnt = exit;
                    break;
                    
                case "GM":
                    lmnt = new GameMachine();
                    break;
                    
                case "CM":
                    lmnt = new ChocoMachine();
                    break;
                    
                case "A":
                    lmnt = new Armchair();
                    break;
                    
                case "C":
                    Cupboard cb2 = new Cupboard(new Tile());
                    cb2.getTile().setNeighborAt(0, new Tile());
                    Cupboard cb1 = new Cupboard(cb2);
                    lmnt = cb1;
                    break;
                    
                default:
                    return;
            }                           //szomszédos csempén lévő element switch vége
            switch(params.get(3)){      //szomszédos csempe speciális-e switch
                case "NO":
                tl2 = new Tile();
                break;
                
                case "B":
                tl2 = new BreakableTile();
                break;
                
                case "BT":
                BreakableTile tmp = new BreakableTile();
                tmp.setLifePoints(0);
                tl2 = tmp;
                break;
                
                case "GMT":
                tl2 = new Tile();
                tl2.setJingled(true);
                break;
                
                case "CMT":
                tl2 = new Tile();
                tl2.setPiped(true);
                break;
                
                case "AT":
                tl2 = new Tile();
                Tile tmp2 = new Tile();
                tl2.setNeighborAt(5, tmp2);
                tmp2.setNeighborAt(0, tl2);
                Armchair ac = new Armchair();
                ac.setTile(tmp2);
                tmp2.setElement(ac);
                break;
                
                default:
                    return;
            }                   //szomszédos csempe speciális-e switch vége
            tl2.setElement(lmnt);
            
            if(!params.get(0).equals("O")) return;
            
            switch(params.get(4)){ // követi-e panda switch
                case "I":
                    SleepyPanda tmpSP = new SleepyPanda();
                    firstMvbl.setHoldsPanda(tmpSP);
                    tmpSP.setHeldByMoveable(firstMvbl);
                    secondMvbl = tmpSP;
                    tmpSP.setTile(new Tile());
                    tmpSP.getTile().setElement(tmpSP);
                default:
            }
        }   //SETATTRIBUTES VÉGE
	
        //beolvas egy sort a line string attribútumba
	static void readLine() throws IOException {
		line = br.readLine();
	}   //READLINE VÉGE
}
