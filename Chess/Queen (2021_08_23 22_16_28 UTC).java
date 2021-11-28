//Queen
public class Queen extends Piece
{
  public Queen(boolean w, Board n)
  {
    super.Piece(w, n);//getting the boolean and board from parent class 
  }
  public Queen(boolean f, Board n, Location p)
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
    int difference = Math.abs(r-moveR);
    //A queen is a bishop and a rook combined. The move methods are the same and can be found in the respective classes
    if(moveR == r)
    {
      if((moveC - c) > 0)
      {
        for (int a = 1; a <Math.abs(moveC - c); a++)
        {
          if (myBoard.isEmpty(new Location(r,(c+a)))==false)
          {
            occupied = true;
          }
        }
      }
      else
      {
        for (int a = 1; a <Math.abs(moveC - c); a++)
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
        for (int a = 1; a <Math.abs(moveR - r); a++)
        {
          if (myBoard.isEmpty(new Location((r+a),c))==false)
          {
            occupied = true;
          }
        }
      }
      else
      {
        for (int a = 1; a <Math.abs(moveR - r); a++)
        {
          
          if (myBoard.isEmpty(new Location((r-a),c))==false)
          {
            occupied = true;
          }
        }
      }
    }
    if(c - difference == moveC || c + difference == moveC && r - difference == moveR || r + difference == moveR)
    {
      System.out.print("l");
      if(moveC - c <0)
      {
        if(moveR - r >0)
        {
          for (int i = 1; i <difference;i++)
          {
            if(myBoard.isEmpty(new Location(r+i,c - i))==false)
            {
              occupied = true;
            }   
          }
        }
      }
      if(moveC - c >0)
      {
        if(moveR - r >0)
        {
          for (int i = 1; i <difference;i++)
          {
            if(myBoard.isEmpty(new Location(r+i,c +i))==false)
            {
              occupied = true;
            }   
          }
        }
      }
      if(moveC - c <0)
      {
        if(moveR - r <0)
        {
          for (int i = 1; i <difference;i++)
          {
            if(myBoard.isEmpty(new Location(r-i,c - i))==false)
            {
              occupied = true;
            }   
          }
        }
      }
      if(moveC - c >0)
      {
        if(moveR - r < 0)
        {
          for (int i = 1; i <difference;i++)
          {
            if(myBoard.isEmpty(new Location(r-i,c +i))==false)
            {
              occupied = true;
            }   
            
          }
        }
      }
       if(difference != Math.abs(moveC-c))
    {
      return false;
    }
    }
    if(occupied == true)
    {
      return false;
    }
    if(myBoard.getPiece(f)!= null)
    {
      if(myBoard.getPiece(f).isWhite() == this.isWhite())
      { 
        return false;
      }
    }
    return true;
  }
  public String toString()
  {
    String results ="q";
    if(this.isWhite() == false)
      results = results.toUpperCase();
    return results;
  }
}