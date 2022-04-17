package ca.humber.Chess;

public class EmptyTile extends Square {
    
    public EmptyTile() {
        
        //this "empty" constructor is crucial for differentiating
        //a "tile" from a "piece".
        super("empty");
        symbol = " ";
        color = null;

    }

    
    //Blank spaces are treated in a manner similar to "pieces" so any 
    //methods related to movement have just been set to return false.
    //to avoid the player being able to interact with an empty tile
    //as if it were a valid chess piece.
    @Override
    public boolean checkTileDetails(int[] moveFrom, int[] moveTo, String pieceColor) {
	         return false;
	}    

    @Override
    public boolean canMoveTo(int x, int y) {
        return false;
    }

    @Override
    public boolean moveTo(int x, int y) {
       return false;
    }

}
