import java.sql.SQLInvalidAuthorizationSpecException;

public class Piece {
    private Square square;
    private final int color;
    private Character character;

    public Piece(int color, Square square){
        this.square = square;
        this.color = color;
    }
    public Square getSquare() {
        return square;
    }
    public int getColor() {
        return color;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
    public Character getChar() {
        if (color == 0) return '\u2659';
        else return '\u265F';
    }
}
