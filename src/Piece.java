import java.sql.SQLInvalidAuthorizationSpecException;

public class Piece {
    private Square square;
    private final int color;

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
}
