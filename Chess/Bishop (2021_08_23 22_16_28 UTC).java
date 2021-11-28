//Bishop
public class Bishop extends Piece
{
  public Bishop(boolean w, Board n)
  {
    super.Piece(w,n);//getting the boolean and board from parent class 
  }
  public Bishop(boolean f, Board n, Location p)
  {
    super.Piece(f,n,p);//getting the boolean and board from parent class 
  }
  public boolean move(Location f)
  {
    int moveR = f.getRow();
    int moveC = f.getCol();
    Boolean occupied = false;
    Location original = this.myLocation();
    int r = original.getRow();
    int c = original.getCol();
    int difference = Math.abs(r-moveR);
    
    if(c - difference == moveC || c + difference == moveC && r - difference == moveR || r + difference == moveR)//checking to see if the piece moves diagonally
      //change in rows equal change in columns
    {//checking each of the 4 possible directions that a bishop can move in 
      if(moveC - c <0)
      {
        if(moveR - r >0)
        {
          for (int i = 1; i <difference;i++)
          {
            if(myBoard.isEmpty(new Location(r+i,c - i))==false)//moving the bishop to the bottom left
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
            if(myBoard.isEmpty(new Location(r+i,c +i))==false)//moving the bishop to the bottom right
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
            if(myBoard.isEmpty(new Location(r-i,c - i))==false)//moving the bishop to the top left
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
            if(myBoard.isEmpty(new Location(r-i,c +i))==false)//moving the bishop to the top right
            {
              occupied = true;
            }   

          }
        }
      }
    }
    if(occupied == true)
      return false;
    if(myBoard.getPiece(f)!= null)//if there is a piece at the location 
    {
      if(myBoard.getPiece(f).isWhite() == this.isWhite())
      { 
        return false;
      }
    }
    if(difference != Math.abs(moveC-c))//looking if the difference in the rows are equal to the difference in the columns 
    {
      return false;
    }
    return true;
  }
  public String toString()
  {
    String results ="b";
    if(this.isWhite()==false)
      results = results.toUpperCase();
    return results;
  }
}