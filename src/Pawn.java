import static java.lang.Math.abs;

public class Pawn extends  Piece {
    int hasMoved;//Declared as an int to simplify posterior operations, but ultimately serves as a Boolean variable
    public Pawn(int color, Square square) {
        super(color, square);
        value = 1;
        hasMoved = 0;
    }

    @Override
    public void move(Square square) throws SquareNotReachable, PieceColision {
        if (abs(this.getSquare().getPosition()[1]-square.getPosition()[1])>1)
            throw new SquareNotReachable("1",this,square);


        //Black-specific movement checks
        if (this.getColor()==1 && ((this.getSquare().getPosition()[0]-square.getPosition()[1]>2-hasMoved) || this.getSquare().getPosition()[1]-square.getPosition()[0] < 0))
            throw new SquareNotReachable("2",this,square);

        //White-specific movement checks
        if (this.getColor()==0 && ((square.getPosition()[0]-this.getSquare().getPosition()[0]>2-hasMoved) || square.getPosition()[1]-this.getSquare().getPosition()[0] < 0))
            throw new SquareNotReachable("3",this,square);

        //Capturing checks
        if (abs(this.getSquare().getPosition()[1]-square.getPosition()[1])==1) {
            if (!square.isEmpty() && square.getPiece().getColor() != this.getColor())
                square.getPiece().capture();
            else
                throw new SquareNotReachable("4",this, square);
        }

        //Colision checks
        if (!square.isEmpty()){
            System.out.println(square.getPiece().toString());

            throw new PieceColision(this, square.getPiece(),this.getSquare(),square);
        }

        //Movement
        this.getSquare().empty();
        this.setSquare(square);
        square.setPiece(this);
    }
}
