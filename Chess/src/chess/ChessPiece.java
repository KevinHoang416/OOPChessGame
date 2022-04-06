package chess;

abstract public class ChessPiece {
    
    public int xcoordinate;
    public int ycoordinate;
    public Boolean white;
    
    public ChessPiece(int xcoordinate, int ycoordinate, Boolean white){
        this.xcoordinate= xcoordinate;
        this.ycoordinate=ycoordinate; 
        this.white=white;
        
}

    //every chess piece class will inherit move() but overloaded with different funtionality 
    abstract public boolean canMoveTo(int destinationX, int destinationY);

    abstract public void moveTo(int destinationX, int destinationY);

}
