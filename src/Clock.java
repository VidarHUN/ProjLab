
import java.util.List;

public class Clock {
    
    private List<Steppable> steppable;
    
    public void tick() {
        steppable.forEach((st) -> {
            st.step();
    });
    }
}
