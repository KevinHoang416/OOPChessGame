/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
public class Rook extends ChessPiece{
        public Rook(int xcoordinate, int ycoordinate, Boolean white) {
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
