import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ElementView {
    private Text element;
    private Color color;

    public void goTo(TileView tile){

    }
    public void setCoor(double x, double y){
        element.setX(x);
        element.setY(y);
    }
    public void changeText(String text){
        element.setText(text);
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public ElementView(double x, double y, String text){

    }
}
