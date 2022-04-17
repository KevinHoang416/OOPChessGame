package ca.humber.Pieces;

import ca.humber.Chess.ChessMain;
import ca.humber.Chess.Square;



//Moves as should
public class Knight extends Piece{
    int moveFromX;
        int moveFromY;
        int moveToX;
        int moveToY;
        String type = "piece";
        
	public Knight(String colorIn) {
		super(colorIn, "piece");
		
		if(color == "white"){
			symbol = "N";
		}
		else{
			symbol = "n";
		}
	}


    @Override
 public boolean checkTileDetails(int[] moveFrom, int[] moveTo, String pieceColor) {
		this.moveFromX = moveFrom[0];
		this.moveFromY = moveFrom[1];
		this.moveToX = moveTo[0];
		this.moveToY = moveTo[1];
		if (this.color.equals(pieceColor)){
                return true;
                }else {
                    return false;
                }
	}    

    @Override
     public boolean canMoveTo(int x, int y) {
        if (moveFromX != -1  && moveFromY != -1){
            return true;
             } else{
            return false;
        }
    }

    @Override
    public boolean moveTo(int x, int y) {
      Square toSquare = ChessMain.board[moveToY][moveToX];
		
		
		
		boolean locationPass = false;
		
		for(int positionDifferenceX = -2; positionDifferenceX <= 2; positionDifferenceX++){
		
			if(positionDifferenceX != 0){
				if(moveToX == moveFromX + positionDifferenceX){
					
					if(Math.abs(positionDifferenceX) == 1){ 
						for(int positionDifferenceY = -2; positionDifferenceY <= 2; positionDifferenceY += 4){
							if(moveToY == moveFromY + positionDifferenceY){
								locationPass = true;
							}
						}
					}
					else{ 
						for(int positionDifferenceY = -1; positionDifferenceY <= 1; positionDifferenceY += 2){
							if(moveToY == moveFromY + positionDifferenceY){
								locationPass = true;
							}
						}
					}
				}
			}
		}
		if(locationPass){ 
			
			if((toSquare.getType() == "blank") || (toSquare.getColor() != color)){
				return true;
			}
		}
		
		return false;
	}
}
