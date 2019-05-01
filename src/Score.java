import javafx.scene.control.TextField;

public class Score {
    private String text;
    private String player;
    private int points;
    private TextField field;

    public void updatePointsTo(int score){
        this.points = score;
        this.text = player + ": " + String.valueOf(points) + " points";
    }
    public Score(double x, double y, String str){

    }
    public void setPlayer(String str){
        this.player = str;
        this.text = player + ": " + String.valueOf(points) + " points";
    }
}
