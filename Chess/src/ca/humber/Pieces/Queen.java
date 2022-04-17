package ca.humber.Pieces;

import ca.humber.Chess.ChessMain;
import ca.humber.Chess.Square;



//Moves but not as it should
public class Queen extends Piece{
    
        int moveFromX;
        int moveFromY;
        int moveToX;
        int moveToY;
        String type = "piece";
	public Queen(String colorIn) {
		super(colorIn, "piece");
		
		if(this.color == "white"){
			symbol = "Q";
		}
		else{
			symbol = "q";
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
		
		String direction;
		String type;
		
		
		
		if(moveToY == moveFromY){ 
			if(moveToX > moveFromX){
				direction = "right";
				type = "straight";
			}
			else{
				direction = "left";
				type = "straight";
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = "bot";
				type = "straight";
			}
			else{
				direction = "top";
				type = "straight";
			}
		}
		else if(moveToX > moveFromX){
			if(moveToY < moveFromY){
				direction = "topRite";
				type = "diagonal";
			}
			else{
				direction = "botRite";
				type = "diagonal";
			}
		}
		else if(moveToX < moveFromX){
			if(moveToY < moveFromY){
				direction = "topLeft";
				type = "diagonal";
			}
			else{
				direction = "botLeft";
				type = "diagonal";
			}
		}
		else{
			return false;
		}
		
		Square testSquare;
		
		if(type == "diagonal"){
			int moveDistance = Math.abs(moveToX - moveFromX);
		
			for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){
			
				if(direction == "topRite"){
					testSquare = ChessMain.board[moveFromY - diagMoveAway][moveFromX + diagMoveAway];
				}
				else if(direction == "botRite"){
					testSquare = ChessMain.board[moveFromY + diagMoveAway][moveFromX + diagMoveAway];
				}
				else if(direction == "topLeft"){
					testSquare = ChessMain.board[moveFromY - diagMoveAway][moveFromX - diagMoveAway];
				}
				else{ //botLeft
					testSquare = ChessMain.board[moveFromY + diagMoveAway][moveFromX - diagMoveAway];
				}
			
				if((testSquare.getType() != "blank") && (diagMoveAway != moveDistance)){
					return false;
				}
				else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != color) || (testSquare.getType() == "blank"))){
					return true;
				}
			}
		}
		else{
			if((direction =="right") || (direction == "left")){
				int positionDifferenceMax = Math.abs(moveToX - moveFromX); //positionDifferencement max depending on what the move to values are
		
				for(int positionDifference = 1; positionDifference <= positionDifferenceMax; positionDifference++){ //looping through squares on the rooks path
					if(direction == "right"){
						testSquare = ChessMain.board[moveFromY][moveFromX + positionDifference];
					
						if((testSquare.getType() != "blank") && (positionDifference != positionDifferenceMax)){
						return false;
						}
						else if((positionDifference == positionDifferenceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
							return true;
						}
					}
					else{
						testSquare = ChessMain.board[moveFromY][moveFromX - positionDifference];
					
						if((testSquare.getType() != "blank") && (positionDifference != positionDifferenceMax)){
							return false;
						}
						else if((positionDifference == positionDifferenceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
							return true;
						}
					}
				}
			}
			else{ 
				int positionDifferenceMax = Math.abs(moveToY - moveFromY);
				
				for(int positionDifference = 1; positionDifference <= positionDifferenceMax; positionDifference++){ 
				
					if(direction == "top"){
						testSquare = ChessMain.board[moveFromY - positionDifference][moveFromX];
					
						if((testSquare.getType() != "blank") && (positionDifference != positionDifferenceMax)){
							return false;
						}
						else if((positionDifference == positionDifferenceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
							return true;
						}
					}
					else{
						testSquare = ChessMain.board[moveFromY + positionDifference][moveFromX];
					
						if((testSquare.getType() != "blank") && (positionDifference != positionDifferenceMax)){
							return false;
						}
						else if((positionDifference == positionDifferenceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
