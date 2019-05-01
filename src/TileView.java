import javafx.scene.paint.Color;

public class TileView {
    private ElementView element;
    private Color color;
    private double x;
    private double y;
    private double radius;

    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }
    public double getRadius(){
        return radius;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setElement(ElementView element){
        this.element = element;
    }
    public ElementView getElement(){
        return element;
    }
    public void setColor(Color color){
        this.color = color; 
    }
    public Color getColor(){
        return color;
    }
    public TileView(double x, double y, double r, Color c){

    }
}
