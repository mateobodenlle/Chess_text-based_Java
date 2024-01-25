import java.awt.datatransfer.Clipboard;

public class Chess {
    private Board board;
    private Player player1, player2;
    private Player currentPlayer;
    private Integer score1, score2;
    private int turnN;
    public Chess(){
        board = new Board();

        //Black/White randomizer
        //Names
        String name1 = "Juan1Blanco";
        String name2 = "Pedro2Negro";
        player1 = new Player(name1,0);
        player2 = new Player(name2,1);

        currentPlayer = player1;

        turnN = 0;
    }

    public void game(){
        Player winner = null;
        boolean checkMate = false, tables = false;
        while(!checkMate || !tables){

        }
        if (tables) screen.msg("The game ends in tables! Good luck next time");
        else if (checkMate && winner.equals(player1)) screen.msg("Checkmate! Player 1, with whites -"+player1.getName()+"- Wins the game. Congratulations!");
        else if (checkMate && winner.equals(player2)) screen.msg("Checkmate! Player 2, with blacks -"+player2.getName()+"- Wins the game. Congratulations!");
    }
}
