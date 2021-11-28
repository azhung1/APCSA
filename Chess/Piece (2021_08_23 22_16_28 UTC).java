//Piece

public abstract class Piece
{
  public boolean white;
  public Board myBoard;
    public void Piece(boolean w, Board n)
  {
    myBoard = n;
    white = w;
  }
  public void Piece(boolean w, Board n, Location p)
  {
    myBoard = n;
    white = w;
    myBoard.placePiece(this,p);//placing the pieces on the board 
  }
  public boolean isWhite()
  {
    return white;  
  }
  public Board getMyBoard()
  {
    return myBoard; 
  }
  public Location myLocation()
  {
   return myBoard.locationOf(this);
  }
   public abstract boolean move(Location l);//further defined in each subclass 
  }

