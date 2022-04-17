package ca.humber.Chess;

import ca.humber.Pieces.*;
import java.util.Scanner;

/**
 * *
 *
 * Program runs, but is missing components: No checks/checkmates No capture
 * implementation, undesirable inputs will crash the game, many pieces move as
 * they should, but some do not *ex. Queen*.
 *
 * I'm sure with more time could make even better and work out many 
 * of the bugs, but this is what was able to be done.
 *
 * - Anthony & Kevin
 *
 **
 */


//board is the main class for the game
public abstract class ChessMain {

    //declare 2D array layout of our 64 tile chessboard
    public static Square board[][] = new Square[8][8];

    private static final Scanner scanner = new Scanner(System.in);

    //method to place pieces in their respective starting positions
    //piece position and board array are inverted
    private static void initializeBoard() {

        //Placing black chess pieces
        board[0][0] = new Rook("black");
        board[0][1] = new Knight("black");
        board[0][2] = new Bishop("black");
        board[0][3] = new Queen("black");
        board[0][4] = new King("black");
        board[0][5] = new Bishop("black");
        board[0][6] = new Knight("black");
        board[0][7] = new Rook("black");

        //loop for placing black pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black");
        }
        //loop for placing empty tiles
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new EmptyTile();
            }
        }

        //loop for placing white pawns
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("white");
        }

        //Placing white chess pieces
        board[7][0] = new Rook("white");
        board[7][1] = new Knight("white");
        board[7][2] = new Bishop("white");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");
        board[7][5] = new Bishop("white");
        board[7][6] = new Knight("white");
        board[7][7] = new Rook("white");

    }

    //a method that updates the board
    //will replace desired board with the piece at the original location
    //replaces the former piece location with an empty tile.
    private static void updateBoard(int[] startTile, int[] newTile) { //setting new location to piece type and setting old location to blank
        board[newTile[1]][newTile[0]] = board[startTile[1]][startTile[0]];
        board[startTile[1]][startTile[0]] = new EmptyTile();
    }

    //A method that will display the initialized board 
    //to the user via the console.
    private static void displayBoard() {
        System.out.print("\n   ");

        //labals the top of the board
        for (int i = 1; i < 9; i++) {
            System.out.print(" " + i + " ");
        }

        //a loop to print the tiles of the board
        System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (8 - i) + " ");

            for (Square j : board[i]) {
                System.out.print("|" + j.getSymbol() + "|");
            }

            //lables the right side of the board
            System.out.print(" " + (8 - i) + " ");

            //a small if check that allows for consistency
            //when labeling the bottom of the board
            //relative to the prompt for user input.
            if (i != 7) {
                System.out.print("\n");
            } else {
                System.out.print("\n   ");
            }

        }
        //labels the bottom of the board
        for (int i = 1; i < 9; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the CPAN131 Chess game\n");
        System.out.println("Player 1 is the white chess pieces indicated by capital letters.");
        System.out.println("Player 2 is the black chess pieces indicated by lower-case letters.\n");
        System.out.println("Good luck and have fun!");

        //Each player is treated as an object within the logic
        //of the program.
        Player player1 = new Player("Player 1", "white");
        Player player2 = new Player("Player 2", "black");

        initializeBoard();

        //A loop containing the primary game logic
        //unfortunately could not figure out a way to implement working captures
        //there is no way to win so the game loops infinitely you can only move pieces around
        while (true) {

            for (int playerDecision = 1; playerDecision <= 2; playerDecision++) {
                displayBoard();

                int move[][] = new int[2][2];

                while (true) {

                    if (playerDecision == 1) {
                        move = player1.getMove();
                    } else {
                        move = player2.getMove();
                    }

                    if (move[0][0] == -1) {
                        System.out.println("Invalid location. Please enter a valid row and column combination.");
                        continue;
                    }

                    //Move is recieved as a 2D array
                    //it is then broken down into 
                    //a "starting from" component
                    //and then broken down into 
                    //its column and row elements
                    //the same logic is applied to 
                    //"moving to" functionality.
                    int[] moveFrom = move[0];
                    int moveFromCol = move[0][0];
                    int moveFromRow = move[0][1];
                    int[] moveTo = move[1];
                    int moveToCol = move[1][0];
                    int moveToRow = move[1][1];
                    Square fromSquare = board[moveFrom[1]][moveFrom[0]];

                    //A series of logic check layers to help ensure a move is valid.
                    //Gets a number of details and properties from a tile
                    //Due to the way the program has been structured 
                    //Pieces are extensions of tiles 
                    //as such each piece has a field property of being a "piece"
                    //to avoid a player trying to move an empty tile.
                    boolean checkValue;
                    if (playerDecision == 1) {
                        fromSquare.checkTileDetails(moveFrom, moveTo, "white");
                        if (fromSquare.getColor().equals("white") && fromSquare.getType().equals("piece")) {
                            if (fromSquare.canMoveTo(moveFromCol, moveFromRow)) {
                                checkValue = fromSquare.moveTo(moveToCol, moveToRow);
                            } else {
                                checkValue = false;
                            }
                        } else {
                            checkValue = false;
                        }
                    } else {
                        fromSquare.checkTileDetails(moveFrom, moveTo, "black");
                        if (fromSquare.getColor().equals("black") && fromSquare.getType().equals("piece")) {
                            if (fromSquare.canMoveTo(moveFromCol, moveFromRow)) {
                                checkValue = fromSquare.moveTo(moveToCol, moveToRow);
                            } else {
                                checkValue = false;
                            }
                        } else {
                            checkValue = false;
                        }
                    }

                    if (checkValue) {
                        updateBoard(moveFrom, moveTo);
                        break;
                    }

                    System.out.println("Invalid move. Please enter a valid row and column combination.");
                }
            }
        }
    }
}
