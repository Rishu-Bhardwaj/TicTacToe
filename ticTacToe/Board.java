package ticTacToe;

public class Board {

    public Cell[][] boxes;
    private final int noOfCell;

    public Board(int noOfCell) {
        this.noOfCell = noOfCell;
        boxes = new Cell[noOfCell][noOfCell];
        initializeBoard();
    }

    public Cell[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(Cell[][] boxes) {
        this.boxes = boxes;
    }

    public void printBoardStatus() {
        for (int i = 0; i < noOfCell; i++) {
            for (int j = 0; j < noOfCell; j++) {
                if(boxes[i][j].getPiece() == null){
                    System.out.print(" ");
                }else {
                    System.out.print(boxes[i][j].getPiece());
                }
                if(j!=noOfCell-1)
                    System.out.print("|");
            }
            System.out.println();
            if(i!=noOfCell-1)
                System.out.println("-+-+-");
        }
        System.out.println();
        System.out.println("***  ***");
        System.out.println();
    }

    public void initializeBoard() {
        for (int i = 0; i < noOfCell; i++) {
            for (int j = 0; j < noOfCell; j++) {
                boxes[i][j] = new Cell(i, j, null);
            }
        }
        System.out.println("*** GAME STARTED ***");
        printBoardStatus();
    }

}
