package ca.humber.Pieces;

import ca.humber.Chess.ChessMain;
import ca.humber.Chess.Square;



//Moves but not as it should
public class Rook extends Piece{
        
        int moveFromX;
        int moveFromY;
        int moveToX;
        int moveToY;
        String type = "piece";
        
	public Rook(String colorIn) {
		super(colorIn, "piece");
		
		if(color == "white"){
			symbol = "R";
		}
		else{
			symbol = "r";
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

		
		if(moveToY == moveFromY){
			if(moveToX > moveFromX){
				direction = "right";
			}
			else{
				direction = "left";
			}
		}
		
		else if(moveToX == moveFromX){
			if(moveToY > moveFromY){
				direction = "bot";
			}
			else{
				direction = "top";
			}
		}
		else{
			return false;
		}
		
		Square testSquare;
		
		if((direction == "right") || (direction == "left")){
			int displaceMax = Math.abs(moveToX - moveFromX); //displacement max depending on what the move to values are
		
			for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path
				if(direction == "right"){
					testSquare = ChessMain.board[moveFromY][moveFromX + displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
						return true;
					}
				}
				else{
					testSquare = ChessMain.board[moveFromY][moveFromX - displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
						return true;
					}
				}
			}
		}
		else{ 
			int displaceMax = Math.abs(moveToY - moveFromY); //displacement max depending on what the move to values are
				
			for(int displace = 1; displace <= displaceMax; displace++){ //looping through squares on the rooks path	
				
				if(direction == "top"){
					testSquare = ChessMain.board[moveFromY - displace][moveFromX];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
						return true;
					}
				}
				else{
					testSquare = ChessMain.board[moveFromY + displace][moveFromX];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax)){
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != color))){
						return true;
					}
				}
			}
		}
                return false;
    }

}
