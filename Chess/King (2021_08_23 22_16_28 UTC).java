//King
public class King extends Piece
{
  public boolean hasMoved;
  public King(boolean w, Board n)
  {
    super.Piece(w, n);//getting the boolean and board from parent class 
    hasMoved = false;
  }
  public King(boolean f, Board n, Location p)
  {
    super.Piece(f, n, p);//getting the boolean and board from parent class 
    hasMoved = false;
  }
  public boolean move(Location f)
  {
    int moveR = f.getRow();
    int moveC = f.getCol();
    Location original = this.myLocation();
    int r = original.getRow();
    int c = original.getCol();
    int difference = Math.abs(moveR -r);
    //testing all of the possible move combinations 
    int move1r = r +1;
    int move1c = c +1;
    
    int move2r = r +1;
    int move2c = c;
    
    int move3r = r -1;
    int move3c = c;
    
    int move4r = r -1;
    int move4c = c -1;
    
    int move5r = r ;
    int move5c = c +1;
    
    int move6r = r ;
    int move6c = c -1;
    
    int move7r = r +1;
    int move7c = c -1;
    
    int move8r = r -1;
    int move8c = c +1;
    Rook e =(Rook)myBoard.getPiece(new Location(7,0));
    Rook  u=(Rook)myBoard.getPiece(new Location(0,0)); 
    Rook q =(Rook)myBoard.getPiece(new Location(7,7));
    Rook k =(Rook)myBoard.getPiece(new Location(0,7));
    if((moveR == move1r || moveR == move2r || moveR == move3r || moveR == move4r || moveR == move5r ||moveR == move6r || moveR == move7r || moveR == move8r) 
         && (moveC == move1c || moveC == move2c || moveC == move3c || moveC == move4c || moveC == move5c || moveC == move6c || moveC == move7c || moveC == move8c))//if the moves are possible
    {
      if(myBoard.getPiece(f) != null)//if the location isn't empty
      {
        if(myBoard.getPiece(f).isWhite() != this.isWhite())//if the pieces aren't the same color 
        {
          hasMoved = true;
          return true;
        }
      }
      else//if the location is empty and is a possible move 
      {
        hasMoved = true;
        return true;
      }
    }
    if(hasMoved == false)//the king couldn't have moved before castling 
    {
      if(Math.abs(moveC-c)==2)//the king has to move 2 places to castle
      {
        if(myBoard.isEmpty(new Location (7,5)) == true && myBoard.isEmpty(new Location (7,6))== true
             ||myBoard.isEmpty(new Location (0,5)) == true && myBoard.isEmpty(new Location (0,6))== true)//testing to see if the space next to the king are empty
        {
          if(this.isWhite() == true)
          {
            if(q.hasMove == false)//looking for the hasMove variable in the rook class
            {
              myBoard.movePiece(new Location(moveR,7), new Location(moveR, 5));//moving the rook to the other side of the king
              hasMoved = true;
              return true;
            }
          }
          else
          {
            if(k.hasMove == false)
            {
              myBoard.movePiece(new Location(moveR,7), new Location(moveR, 5));
              hasMoved = true;
              return true;
            }
          }
        }
        if(myBoard.isEmpty(new Location (7,1)) == true && myBoard.isEmpty(new Location (7,2))== true&&myBoard.isEmpty(new Location (7,3))== true//queen side castling
             ||myBoard.isEmpty(new Location (0,1)) == true && myBoard.isEmpty(new Location (0,2))== true&&myBoard.isEmpty(new Location (0,3))== true)
        {
          if(hasMoved == false)
          {
            if(this.isWhite() == true)
            {
              if(e.hasMove == false)
              {
                myBoard.movePiece(new Location(moveR,0), new Location(moveR, 3));
                hasMoved = true;
                return true;
              }
            }
            else
            {
              if(u.hasMove == false)
              {
                myBoard.movePiece(new Location(moveR,0), new Location(moveR, 3));
                hasMoved = true;
                return true;
              }
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  public String toString()
  {
    String results ="k";
    if(this.isWhite() == false)
      results = results.toUpperCase();
    return results;
  }
}