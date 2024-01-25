public class Square {
    private Integer[] position;
    private Piece piece;
    public Square(Integer i, Integer j){
        position = new Integer[2]; position[0] = i; position[1] = j;
        piece = null;
    }

    public boolean isEmpty(){
        return piece==null;
    }
    public Piece getPiece(){
        return piece;
    }
    public void setPiece(Piece piece){
        this.piece = piece;
    }


}
