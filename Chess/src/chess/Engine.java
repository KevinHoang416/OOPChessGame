package chess;

import java.util.Scanner;

public class Engine {

    private ChessBoard chessBoard;
    private Scanner scanner;

    public Engine() {
        chessBoard = new ChessBoard();
        chessBoard.createGrid();
        scanner = new Scanner(System.in);
    }

    public void initGame() {
        char turn = 'X';
        while (!enterMove(turn)) {
            if (turn == 'X') {
                turn = 'Y';
            } else {
                turn = 'X';
            }

        }
    }

    public boolean enterMove(char RNBQKP) {
        while (true) {
            System.out.println("Player " + RNBQKP + " enter origin coordinates");
            int destinationX = scanner.nextInt();
            int destinationY = scanner.nextInt();
//            System.out.println("Player " + RNBQKP + " enter destination coordinates");
//            int originX = scanner.nextInt();
//            int originY = scanner.nextInt();
            if (chessBoard.emptyCell(destinationX, destinationY)) {
                chessBoard.createCell(destinationX, destinationY, RNBQKP);
                chessBoard.createGrid();
                return false;
            }
        }
    }
}
