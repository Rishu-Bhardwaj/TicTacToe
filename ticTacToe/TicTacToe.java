package ticTacToe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of Player1 : ");
        String player1=scanner.nextLine();
        System.out.println("Enter the name of Player2 : ");
        String player2=scanner.nextLine();

        Random r=new Random();
        char randomChar1=(char) (r.nextInt(26)+'a');
        char randomChar2=(char) (r.nextInt(26)+'a');

        String id1=player1.substring(0,2)+randomChar1;
        String id2=player2.substring(0,2)+randomChar2;

        Player p1 = new Player(player1,id1,Piece.X);
        Player p2 = new Player(player2,id2,Piece.O);

        System.out.println("Game 1");
        Game ticTac = new Game(p1,p2);
        System.out.println("----- "+player1+"\'s Turn -----");
        System.out.println();
        while(ticTac.getGameStatus()==GameStatus.PLAYING){
            System.out.println("Enter the position you want to play at : ");
            int position=scanner.nextInt();
            int row=(position-1)/3;
            int col=(position-1)%3;
            ticTac.play(row, col);
        }
    }

}
