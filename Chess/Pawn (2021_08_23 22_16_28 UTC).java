//Pawn
public class Pawn extends Piece
{
  public Pawn(boolean w, Board n)
  {
    super.Piece(w, n);//getting the boolean and board from parent class 
  }
  public Pawn(boolean f, Board n, Location p)
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
    Boolean occupied = false;
    if(moveC == c)//when moving a pawn, if not capturing a piece, the rows must stay the same 
    {
      if(this.isWhite() == true)
      {
        if(r == 6)//if the pawn hasn't moved yet, it can move up to 2 spaces on it's first turn
        {
          if(Math.abs(moveR - r)==2)
          {
            if(myBoard.isEmpty(new Location(moveR,c))==true)//checking if the spaces between where the pawn wants to move and the current location is empty
            {
              if(myBoard.isEmpty(new Location(moveR+1,c))==true)
              {
                return true;
              }
            }
          }
          if(Math.abs(moveR - r)==1)
          {
            if(myBoard.isEmpty(new Location(moveR,c))==true)
            {
              return true;
            }
          }
        }
        else//if it isn't the white pawns first turn 
        {
          if(myBoard.isEmpty(new Location(moveR,c))==true)
          {
            if(Math.abs(moveR - r)==1)
            {
              return true;
            }
          }
        }
      }
      else//same thing just for the black pawns 
      {
        if(r == 1)
        {
          if(Math.abs(moveR - r)==2)
          {
            if(myBoard.isEmpty(new Location(moveR,c))==true)
            {
              if(myBoard.isEmpty(new Location(moveR-1,c))==true)
              {
                return true;
              }
            }
          }
            if(Math.abs(moveR - r)==1)
          {
            if(myBoard.isEmpty(new Location(moveR,c))==true)
            {
              return true;
            }
          }
        }
        else
        {
          if(myBoard.isEmpty(new Location(moveR,c))==true)
          {
            if(Math.abs(moveR - r)==1)
            {
              return true;
            }
          }
        }
      }
    }
     if(moveC == c - 1|| moveC == c + 1)//to capture a pawn, it an move diagonally, meaning a differnece of 1 in the current column and the column that the pawn is going to mvoe to 
     {
       if(myBoard.getPiece(f) != null)//there needs to be a piece in order to move diagonally
       {
       if(this.isWhite() != myBoard.getPiece(f).isWhite())//piece has to be a differnet color in order to capture it 
       {
         return true;
       }
       }
     }
    return false;
  }
  public String toString()
  {
    String results ="p";
    if(this.isWhite() == false)//white pieces are lower case 
      results = results.toUpperCase();
    return results;
  }
}