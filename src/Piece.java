import java.sql.SQLInvalidAuthorizationSpecException;

public abstract class Piece {
    private Square square;
    private final int color;
    private Character character;
    int value;

    public Piece(int color, Square square){
        this.square = square;
        this.color = color;
        value = 3;
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

    /**
     * Method to move pieces, implemented in each piece type. Does all pertinent comprobations, moves and captures if necessary.
     * @param square Place where we try to move
     * @throws SquareNotReachable Self exp.
     * @throws PieceColision Self exp.
     * Both exceptions must be shown to the user, and contain useful info as atributes
     */
    public abstract void move(Square square) throws SquareNotReachable, PieceColision;

    /**
     * Method applied to pieces BEING captured, that only updates score and frees the square
     */
    protected void capture() {
        if (color==0) Chess.addScoreW(value);
        else Chess.addScoreB(value);
        this.square.empty();
    }

    @Override
    public String toString() {
        String[] colors = {"white","black"};
        return colors[color]+ " " + getClass()+ " in "+ square.getPosition()[0] + " - " + square.getPosition()[1];
    }
}
