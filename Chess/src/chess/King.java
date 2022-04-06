package chess;

public class King extends ChessPiece{
        public King(int xcoordinate, int ycoordinate, Boolean white) {
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
