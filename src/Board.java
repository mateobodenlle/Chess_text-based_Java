import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Square>> squares;


    public Board(){
        squares = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            squares.add(new ArrayList<Square>(8));

            for (int j = 0; j<8; j++) {
                squares.get(i).add(new Square(i, j));
                if (i<2)
                    squares.get(i).get(j).setPiece(new Pawn(0,squares.get(i).get(j)));//todo cambiar para considerar tipos de pieza
                if (i>5)
                    squares.get(i).get(j).setPiece(new Pawn(0,squares.get(i).get(j)));
            }
        }

    }

    public ArrayList<ArrayList<Square>> getSquares() {
        return squares;
    }
    public Square getSquare(int i, int j){
        return squares.get(i).get(j);
    }
}
