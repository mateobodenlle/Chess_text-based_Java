public class PieceColision extends Exception {
    Piece attempter, colisioner;
    Square previous, attempted;
    public PieceColision(Piece attempter, Piece colisioner,    Square previous, Square attempted){
        super();
        this.attempter = attempter;
        this.colisioner= colisioner;
    }

    public Square getAttempted() {
        return attempted;
    }
}
