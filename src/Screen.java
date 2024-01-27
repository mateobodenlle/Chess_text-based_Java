import java.util.ArrayList;

public class Screen {
    private static String[] formato = {"\u001B[47m","\u001B[100m"};
    public static void msg(String mesage){
        System.out.println(mesage);
    }

    public static void printBoard(Board board) {
        ArrayList<ArrayList<Square>> squares = board.getSquares();
        System.out.println("   A  B  C  D  E  F  G  H |");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (i + 1));
            for (int j = 0; j < 8; j++)
                if(squares.get(i).get(j).isEmpty()) System.out.print(formato[(i*8+j+i%2)%2]+"     \u001B[0m");
                else System.out.print(formato[(i*8+j+i%2)%2] + squares.get(i).get(j).getPiece().getChar()+"\u001B[0m");
            System.out.print("| \n");
        }
        System.out.println("TABLERO");
    }
}
