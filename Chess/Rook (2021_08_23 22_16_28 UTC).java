//Rook
public class Rook extends Piece
{
  public boolean hasMove;
  public Rook(boolean w, Board n)
  {
    super.Piece(w, n);//getting the boolean and board from parent class 
    hasMove = false;
  }
  public Rook(boolean f, Board n, Location p)
  {
    super.Piece(f, n,p);//getting the boolean and board from parent class 
    hasMove = false;
  }
  public boolean move(Location f)
  {
    int moveR = f.getRow();
    int moveC = f.getCol();
    Location original = this.myLocation();
    int r = original.getRow();
    int c = original.getCol();
   boolean occupied = false;

    if(moveR == r)//rook can only move horiontally or vertically meaning that the row or column must be the same 
    {
      if((moveC - c) > 0)//if the rook is moving left
      {
      for (int a = 1; a <Math.abs(moveC - c); a++)//testing the spaces in between to see if they are empty 
      {
        if (myBoard.isEmpty(new Location(r,(c+a)))==false)
        {
          occupied = true;
        }
      }
      }
      else
      {
         for (int a = 1; a <Math.abs(moveC - c); a++)//testing moving right 
      {
        if (myBoard.isEmpty(new Location(r,(c-a)))==false)
        {
          occupied = true;
        }
      }
    }
    }
    if(moveC == c)
    {
      if((moveR - r) > 0)
      {
      for (int a = 1; a <Math.abs(moveR - r); a++)//moving down 
      {
        if (myBoard.isEmpty(new Location((r+a),c))==false)
        {
          occupied = true;
        }
      }
    }
      else
      {
         for (int a = 1; a <Math.abs(moveR - r); a++)//moving up 
      {
     
        if (myBoard.isEmpty(new Location((r-a),c))==false)
        {
          occupied = true;
        }
      }
    }
    }
    if(occupied == true)
    {
      return false;
    }
    if(myBoard.getPiece(f)!= null)//if there is a piece at the destination location 
    {
    if(myBoard.getPiece(f).isWhite() == this.isWhite())//if they are the same color 
    { 
      return false;
    }
    }
    if(hasMove == true)//to see if castling is eligible 
    {
       hasMove = true;
      return true;
    }
       hasMove = true;
    return true;
  }
  public String toString()
  {
    String results = "r";
    if(this.isWhite() == false)
      results = results.toUpperCase();

    return results;
  }
}
