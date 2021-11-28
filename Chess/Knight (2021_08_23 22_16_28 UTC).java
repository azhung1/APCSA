//Knight

public class Knight extends Piece
{
  public Knight(boolean w, Board n)
  {
    super.Piece(w, n);//getting the boolean and board from parent class 
  }
  public Knight(boolean f, Board n, Location p)
  {
    super.Piece(f, n, p);//getting the boolean and board from parent class 
  }
  public boolean move(Location f)
  {
    int moveR = f.getRow();
    int moveC = f.getCol();
    Location original = this.myLocation();
    int r = original.getRow();
    int c = original.getCol();
    //testing the 8 possible moves of the knight(in rows and columns)
    int move1r = r +2;
    int move1c = c +1;
    
    int move2r = r +2;
    int move2c = c -1;
    
    int move3r = r -2;
    int move3c = c +1;
    
    int move4r = r -2;
    int move4c = c -1;
    
    int move5r = r +1;
    int move5c = c +2;
    
    int move6r = r +1;
    int move6c = c -2;
    
    int move7r = r +1;
    int move7c = c +2;
    
    int move8r = r -1;
    int move8c = c -2;

    if(moveR == move1r || moveR == move2r || moveR == move3r || moveR == move4r || moveR == move5r ||moveR == move6r || moveR == move7r || moveR == move8r)//if the destination row matches 
      //the calculated row 
    {
      if(moveC == move1c || moveC == move2c || moveC == move3c || moveC == move4c || moveC == move5c || moveC == move6c || moveC == move7c || moveC == move8c)//if the destination column matches 
      //the calculated column 
      {
      if(myBoard.getPiece(f) == null)//if there is no piece in the location 
      {
         return true;
      }
       else if(myBoard.getPiece(f).isWhite() != this.isWhite())//seeing if the color of the piece matches the color of the piece at the location 
        {
          return true;
        }
      }
    }
    return false;
  }
  public String toString()
  {
    String results ="n";
    if(this.isWhite() == false)//if the piece is white, then it is lower case
      results = results.toUpperCase();
    return results;
  }
}