public class SquareNotReachable extends Exception{
    Piece piece;
    Square previous, attempted;

    public SquareNotReachable(String msg,Piece piece, Square attempted){
        super();
        previous = piece.getSquare();
        this.piece = piece;
        this.attempted = attempted;
        System.out.println(msg);
    }

    public Square getAttempted() {
        return attempted;
    }
}
