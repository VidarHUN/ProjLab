
import java.util.ArrayList;
import java.util.List;

public class Clock {
    
    private static final Clock INSTANCE = new Clock();
    
    private List<Steppable> steppable = new ArrayList<Steppable>();
    
    Clock() {}
    
    public static Clock getInstance(){
        return INSTANCE;
    }
    
    public void tick() {
        steppable.forEach((st) -> {
            st.step();
    });
    }
}
