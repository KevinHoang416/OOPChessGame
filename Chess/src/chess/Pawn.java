
package chess;

public class Pawn extends ChessPiece{
        public Pawn(int xcoordinate, int ycoordinate, Boolean white) {
        super(xcoordinate, ycoordinate, white);
    }

      @Override
    public boolean canMoveTo(int destinationX, int destinationY){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public void moveTo(int destinationX, int destinationY){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
