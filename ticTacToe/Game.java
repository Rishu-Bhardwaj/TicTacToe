package ticTacToe;


public class Game {

    private final Board board;
    private final Player[] players;
    private Player currentPlayer;
    private final int cellCount = 3;
    private final int noOfPlayers = 2;
    private final int[] arrRow = new int[cellCount];
    private final int[] arrCol = new int[cellCount];
    private int drl = 0;
    private int dlr = 0;
    private int numMoves=0;
    private GameStatus gameStatus;

    public Game(Player p1, Player p2) {
        players = new Player[noOfPlayers];
        players[0] = p1;
        players[1] = p2;
        board = new Board(cellCount);
        currentPlayer = players[0];
        gameStatus = GameStatus.PLAYING;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean play(int row, int col) {
        if (GameStatus.PLAYING == gameStatus) {
            if (isValidMove(row, col)) {
                numMoves++;
                board.boxes[row][col].setPiece(currentPlayer.getPiece());
                if (checkIfWon(row, col)) {
                    board.printBoardStatus();
                    return false;
                } else if (checkIfDraw(row, col)) {
                    board.printBoardStatus();
                    return false;
                }
                gameStatus = GameStatus.PLAYING;
                changeTurn();
                System.out.println();
                board.printBoardStatus();
                System.out.println("----- "+currentPlayer.getUserName()+"\'s Turn -----");
                System.out.println();
                return true;
            }
            System.out.println(currentPlayer.getUserName() + " Please put valid move!");
            // board.printBoardStatus();
            return false;
        } else {
            System.out.println();
            System.out.println("*** "+currentPlayer.getUserName().toUpperCase() + " has already won the game! ***");
            System.out.println("*** GAME IS OVER ***");
            System.out.println();
            
            return false;
        }
    }

    private boolean checkIfDraw(int row, int col) {
        if(numMoves==9){
            gameStatus = GameStatus.DRAW;
            System.out.println();
            System.out.println("*** Game has been finished with status DRAW!! ***");
            System.out.println();
            return true;
        }
        return false;
    }

    private void changeTurn() {
        if (currentPlayer.getUserId().equals(players[0].getUserId())) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }


    private boolean checkIfWon(int row, int col) {

        if (currentPlayer.getUserId().equals(players[0].getUserId())) {
            if (row == col) {
                dlr++;
            } else if (row + col == cellCount - 1) {
                drl++;
            }
            arrRow[row] = arrRow[row] + 1;
            arrCol[col] = arrCol[col] + 1;
            if (arrRow[row] == cellCount || arrCol[col] == cellCount || drl == cellCount || dlr == cellCount) {
                gameStatus = GameStatus.WON;
                System.out.println();
                System.out.println("*** "+currentPlayer.getUserName().toUpperCase() + " has won the Game!! ***");
                System.out.println();
                return true;
            }
        } else {
            if (row == col) {
                dlr--;
            } else if (row + col == -(cellCount - 1)) {
                drl--;
            }
            arrRow[row] = arrRow[row] - 1;
            arrCol[col] = arrCol[col] - 1;
            if (arrRow[row] == -cellCount || arrCol[col] == -cellCount || drl == -cellCount || dlr == -cellCount) {
                gameStatus = GameStatus.WON;
                System.out.println();
                System.out.println("*** "+currentPlayer.getUserName().toUpperCase() + " has won the Game!! ***");
                System.out.println();
                return true;
            }

        }

        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row < cellCount && col < cellCount && board.boxes[row][col].getPiece() == null;
    }


}
