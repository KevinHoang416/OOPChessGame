package ca.humber.Chess;

public abstract class Square {
	
	
    //Literally the basis for 99% of the objects contained within the game
    //Other than the player almost everything derives from this square
    //as such as necessary to ensure differences between empty tiles
    //and actual chess pieces. This was done using the property "type".
    //that upon construction will flag as either a tile or a chess piece.
	protected String symbol = " ";
	protected String color;
	protected String type = "";
	
	public Square(String type){
		this.type = type;
	}
	
	String getSymbol(){
		return symbol;
	}
        
	public String getType(){
		return type;
	}
        
        public String getColor(){
            return color;
        }
	
        //abstract methods
        //method for returning a postitions properties
	public abstract boolean checkTileDetails(int[] moveFrom, int[] moveTo, String color);
        //method for checking a moves validity.
        public abstract boolean canMoveTo(int x, int y);
        //method for checking piece logic and reflect a desired movement
        //on the board.
        public abstract boolean moveTo(int x, int y);
}
