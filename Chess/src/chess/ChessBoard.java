package chess;

public class ChessBoard {

    private char[][] grid;

    public ChessBoard() {
        //initialize chess board 
        grid = new char[8][8];
        gridInit();
        grid[0][0] = 'R';
        grid[0][1] = 'N';
        grid[0][2] = 'B';
        grid[0][3] = 'Q';
        grid[0][4] = 'K';
        grid[0][5] = 'B';
        grid[0][6] = 'N';
        grid[0][7] = 'R';
        grid[1][0] = 'P';
        grid[1][1] = 'P';
        grid[1][2] = 'P';
        grid[1][3] = 'P';
        grid[1][4] = 'P';
        grid[1][5] = 'P';
        grid[1][6] = 'P';
        grid[1][7] = 'P';
        grid[7][0] = 'R';
        grid[7][1] = 'N';
        grid[7][2] = 'B';
        grid[7][3] = 'Q';
        grid[7][4] = 'K';
        grid[7][5] = 'B';
        grid[7][6] = 'N';
        grid[7][7] = 'R';
        grid[6][0] = 'P';
        grid[6][1] = 'P';
        grid[6][2] = 'P';
        grid[6][3] = 'P';
        grid[6][4] = 'P';
        grid[6][5] = 'P';
        grid[6][6] = 'P';
        grid[6][7] = 'P';

    }

    public void gridInit() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = '-';
            }
        }
    }

    public void createGrid() {
        System.out.println();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void createCell(int row, int col, char RNBQKP) {
        grid[row][col] = RNBQKP;
    }

    public boolean emptyCell(int row, int col) {
        if (grid[row][col] != '0') {
            return true;
        }

        return false;
    }

}
