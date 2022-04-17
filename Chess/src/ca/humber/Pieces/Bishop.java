package ca.humber.Pieces;

import ca.humber.Chess.ChessMain;
import ca.humber.Chess.Square;



//Moves but not as it should
public class Bishop extends Piece{
    int moveFromX;
        int moveFromY;
        int moveToX;
        int moveToY;
        String type = "piece";
        
	public Bishop(String colorIn) {
		super(colorIn, "piece");
		
		if(color.equals("white")){
			symbol = "B";
		}
		else{
			symbol = "b";
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
		
		int moveDistance = Math.abs(moveToX - moveFromX);
		
		
		
		String direction;
		
		if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = "topRight";
			}
			else{
				direction = "botRight";
			}
		}
		else{
			if(moveToY < moveFromY){
				direction = "topLeft";
			}
			else{
				direction = "botLeft";
			}
		}
		
		
		Square testSquare;
		
		
		for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
			if(direction == "topRight"){
				testSquare = ChessMain.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
			}
			else if(direction == "botRight"){
				testSquare = ChessMain.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
			}
			else if(direction == "topLeft"){
				testSquare = ChessMain.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
			}
			else{ 
				testSquare = ChessMain.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
			}
			
			if((testSquare.getType() != "blank") && (diagMoveAway != moveDistance)){
				return false;
			}
			else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != color) || (testSquare.getType() == "blank"))){
				return true;
			}
		}
		return false; 
    }
}
