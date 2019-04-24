
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Application {
    
	private static BufferedReader br;

	//Oldalak száma.
	private static int sidesNumber;
    private static int idx;
    private static Controller instance = Controller.getInstance();

    //Első szintű kiíratás
    private static String first = "Test successful";

    //Második szintű kiíratás
    private static List<String> second = new ArrayList<String>();

    //Harmadik szintű kiíratás
    private static List<String> third = new ArrayList<String>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
            System.out.println("Kérem adjon meg teszteseteket");
            readingTest();
            /*
            while(true){
                nullAttributes();
                ArrayList<String> params = readParams();
                if(params == null) continue;
                if(params.get(0).equals("q")) break;
                setAttributes(params);
                test();
            }
            */
           System.out.println("Hello World");
		
    }

    /**
     * Egy olyan függvény, aminek egy útvonalat lehet megadni, hogy hol van a tesztelni kívánt fájl.
     *
     * @param path Az elérés útvonala
     * @return Egy olyan listával tér vissza, amiben a kimenetek vannnak tárolva.
     * @throws IOException
     */

    private static void readingTestFiles(String path) throws IOException, ClassNotFoundException {
	    br = new BufferedReader(new FileReader(path));
	    String line;
	    while ((line = br.readLine()) != null){
	        String[] elements = line.split(" ");
	        switch (elements[0].toLowerCase()){
                case "load":
                    readingTestFiles(path);
                    break;
                case "setside":
                    sidesNumber = Integer.parseInt(elements[1]);
                    second.add("SetSide "+elements[1] +" successful");
                    break;
                case "random":
                    second.add("Random "+elements[1] +" successful");
                    break;
                case "create":
                    instance.add(typeDecider(elements[1]), elements[2]);
                    second.add("Create "+elements[1]+" "+elements[2] +" successful");
                    break;
                case "connect":
                    instance.connect(elements[1], Integer.parseInt(elements[2]), elements[3]);
                    second.add("Connect "+elements[1]+" "+elements[2]+" "+elements[3] +" successful");
                    break;
                case "place":
                    instance.place(elements[1], elements[2]);
                    second.add("Place "+elements[1]+" "+elements[2] +" successful");
                    break;
                case "catch":
                    instance.grab(elements[1], elements[2]);
                    second.add("Catch "+elements[1]+" "+elements[2] +" successful");
                    break;
                case "endcreate":
                    second.add("EndCreate successful");
                    break;
                case "move":
                    instance.move(elements[1], Integer.parseInt(elements[2]));
                    second.add("Move "+elements[1]+" "+elements[2] +" successful");
                    break;
                case "jingle":
                    instance.jingle(elements[1]);
                    second.add("Jingle "+elements[1]+" successful");
                    break;
                case "pipe":
                    instance.pipe(elements[1]);
                    second.add("Pipe "+elements[1]+" successful");
                    break;
                case "jump":
                    instance.jump(elements[1]);
                    second.add("Jump "+elements[1]+" successful");
                    break;
                case "letgo":
                    instance.letGo(elements[1]);
                    second.add("LetGo "+elements[1]+" successful");
                    break;
                case "save":
                    save(Integer.parseInt(elements[1]), elements[2]);
                    break;
                default:
                    System.out.println("Valahol hibás volt a kiadott parancs így nem hajtható végre!");
            }
        }
    }

    /**
     * Ez a függvény felel a konzolos bemenetért.
     * A kiíratások azért szerepelnek benne, hogy ellenőrizhető legyen, hogy mi fut le
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */

    private static void readingTest() throws IOException, ClassNotFoundException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            String[] elements = line.split(" ");
            switch (elements[0].toLowerCase()){
                case "load":
                    readingTestFiles(elements[1]);
                    break;
                case "setside":
                    sidesNumber = Integer.parseInt(elements[1]);
                    System.out.println(sidesNumber);
                    second.add("SetSide"+elements[1] +"successful");
                    break;
                case "random":
                    second.add("Random "+elements[1] +" successful");
                    break;
                case "create":
                    instance.add(typeDecider(elements[1]), elements[2]);
                    second.add("Create "+elements[1]+" "+elements[2] +" successful");
                    System.out.println("OK");
                    break;
                case "connect":
                    instance.connect(elements[1], Integer.parseInt(elements[2]), elements[3]);
                    second.add("Connect "+elements[1]+" "+elements[2]+" "+elements[3] +" successful");
                    System.out.println("OK");
                    break;
                case "place":
                    instance.place(elements[1], elements[2]);
                    second.add("Place "+elements[1]+" "+elements[2] +" successful");
                    System.out.println("OK");
                    break;
                case "catch":
                    instance.grab(elements[1], elements[2]);
                    second.add("Catch "+elements[1]+" "+elements[2] +" successful");
                    System.out.println("OK");
                    break;
                case "endcreate":
                    System.out.println("OK");
                    second.add("EndCreate successful");
                    break;
                case "move":
                    instance.move(elements[1], Integer.parseInt(elements[2]));
                    second.add("Move "+elements[1]+" "+elements[2] +" successful");
                    System.out.println("OK");
                    break;
                case "jingle":
                    instance.jingle(elements[1]);
                    second.add("Jingle "+elements[1]+" successful");
                    System.out.println("OK");
                    break;
                case "pipe":
                    instance.pipe(elements[1]);
                    second.add("Pipe "+elements[1]+" successful");
                    System.out.println("OK");
                    break;
                case "jump":
                    instance.jump(elements[1]);
                    second.add("Jump "+elements[1]+" successful");
                    System.out.println("OK");
                    break;
                case "letgo":
                    instance.letGo(elements[1]);
                    second.add("LetGo "+elements[1]+" successful");
                    System.out.println("OK");
                    break;
                case "save":
                    save(Integer.parseInt(elements[1]), elements[2]);
                    System.out.println("OK");
                    break;
                default:
                    System.out.println("Valahol hibás volt a kiadott parancs így nem hajtható végre!");
            }
        }
    }

    /**
     * Ezt terveztem arra, hogy kiírassa fájlba a tesztek lefutását.
     *
     * @param level
     * @param path
     */

    public static void save(int level, String path) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        if(level==1) {
            writer.write(first);
        }
        if(level==2) {
            for(int i = 0; i<second.size(); i++) {
                writer.write(second.get(i));
                writer.newLine();
            }
        }
        if(level==3) {
        }
        second.clear();
        writer.close();
    }

    /**
     * A megadott stringből eldönti, hogy milyen típusú objektumot kell létrehoznia.
     *
     * @param type A konzolról vagy fájlból megkapott osztály neve.
     * @return A visszatérése egy olyan osztályú objektum, ami meglett adva paraméterként.
     */

    public static Object typeDecider(String type){
        switch (type.toLowerCase()){
            case "armchair":
                return new Armchair();
            case "breakabletile":
                return new BreakableTile();
            case "chocomachine":
                return new ChocoMachine();
            case "cupboard":
                return new Cupboard();
            case "exit":
                return new Exit();
            case "gamemachine":
                return new GameMachine();
            case "jinglefearpanda":
                return new JingleFearPanda();
            case "orangutan":
                return new Orangutan();
            case "pipingfearpanda":
                return new PipingFearPanda();
            case "sleepypanda":
                return new SleepyPanda();
            case "tile":
                return new Tile();
            default:
                return null;
        }
    }
    /*
    //MAIN VÉGE
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
                if(tl2.getElement() == sp) {
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

     */
}
