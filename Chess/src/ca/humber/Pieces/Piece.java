package ca.humber.Pieces;

import ca.humber.Chess.Square;

public abstract class Piece extends Square{
	
    //Differs from square in that it will 
    //assign a color respective of the player
    //the initialized piece belongs to.
	public Piece(String colorIn, String typeIn) {
		super(typeIn);
		color = colorIn;
	} 
           
        @Override
        public abstract boolean checkTileDetails(int[] moveFrom, int[] moveTo, String color);
        @Override
        public abstract boolean canMoveTo(int x, int y);
        @Override
        public abstract boolean moveTo(int x, int y);

}
