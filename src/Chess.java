import java.util.InputMismatchException;

public class Chess {
    private Board board;
    private Player playerW, playerB;
    private Player currentPlayer;
    private static Integer scoreW=0, scoreB=0;
    private int turnN;


    private int[] positionSelector(){
        int[] in;
        while(true)
            try{
                in = Screen.twoIntInput();
                break;
            }
            catch (InputMismatchException i){
                System.out.println("Input in wrong format, use \"a,b\" or \"a b\" notation, please.");
            }
        return in;
    }
    /**
     * Method to ask player for detail on the next movement, and call the move() method of piece, dispatching exceptions
     */
    private void movement(){
        Square origin, destination;
        int i,j;
        //Select original square
        Screen.msg("Select a square of origin: ");
        int[] position = positionSelector();
        origin = board.getSquare(position[0],position[1]);
        if(!origin.isEmpty()) Screen.msg(origin.getPiece()+" selected");

        //Select destination square
        Screen.msg("Select a square of destination: ");
        position = positionSelector();
        destination = board.getSquare(position[0],position[1]);

        try {
            origin.getPiece().move(destination);
            Screen.printBoard(board);
        }
        catch (SquareNotReachable | PieceColision e){
            Screen.msg("Square "+ position[0]+","+position[1] +" not reachable");
        }
    }
    public Chess(){
        board = new Board();

        //Black/White randomizer
        //Names
        String name1 = "Juan1Blanco";
        String name2 = "Pedro2Negro";
        playerW = new Player(name1,0);
        playerB = new Player(name2,1);

        currentPlayer = playerW;

        turnN = 0;
    }

    public void game(){
        Player winner = null;
        boolean checkMate = false, tables = false;
        Screen.printBoard(board);
        movement();
        /*while(!checkMate || !tables){

        }*/
        if (tables) Screen.msg("The game ends in tables! Good luck next time");
        else if (checkMate && winner.equals(playerW)) Screen.msg("Checkmate! Player 1, with whites -"+ playerW.getName()+"- Wins the game. Congratulations!");
        else if (checkMate && winner.equals(playerB)) Screen.msg("Checkmate! Player 2, with blacks -"+ playerB.getName()+"- Wins the game. Congratulations!");
    }

    public static Integer getScoreB() {
        return scoreB;
    }
    public static Integer getScoreW() {
        return scoreW;
    }

    public static void addScoreB(Integer scoreB) {
        Chess.scoreB+= scoreB;
    }
    public static void addScoreW(Integer scoreW) {
        Chess.scoreW+= scoreW;
    }
}
