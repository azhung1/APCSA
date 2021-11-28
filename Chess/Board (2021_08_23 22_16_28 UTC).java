//Board

public class Board
{
  private Piece [][]array;
  public Board(boolean reset)
  {
    if (reset ==true)
    {
      reset();//resets the board, calling the reset method, if the boolean is true
    }
    else
    {
      array = new Piece[][]{//creating an empty board
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null,null},
      };
    }
  }
  public Piece getPiece(Location n)
  {
    int pieceRow = n.getRow();//getting the row and column of the location 
    int pieceCol = n.getCol();
    Piece p = array[pieceRow][pieceCol];//finding the piece at the array location 
    return p;
  }
  public Piece placePiece(Piece p, Location f)
  {
    Piece oldPiece = getPiece(f);//making a new piece equal to the piece at location f
    int newRow = f.getRow();
    int newCol = f.getCol();
    array[newRow][newCol] = p;//setting the location of piece p to a new location in the piece array
    return oldPiece;
  }
  public Location locationOf(Piece p)
  {
    for (int row = 0; row<8;row++)//looping through the piece array to find the location of the piece
    {
      for(int col = 0; col <8;col++)
      {
        if(array[row][col] == p)
        {
          return new Location(row,col);
        }
      }
    }
    return null;//if the piece isn't on the board
  }
  public void reset()
  {
    array = new Piece[][]{
      {new Rook(false,this), new Knight(false, this), new Bishop(false, this), new Queen(false, this),//creating a new array of pieces on the board
        new King(false,this), new Bishop(false, this), new Knight (false, this), new Rook(false, this)},
        {new Pawn(false,this),new Pawn(false,this),new Pawn(false,this),new Pawn(false,this),
          new Pawn(false,this),new Pawn(false,this),new Pawn(false,this),new Pawn(false,this)},
          {null,null,null,null,null,null,null,null},
          {null,null,null,null,null,null,null,null},
          {null,null,null,null,null,null,null,null},
          {null,null,null,null,null,null,null,null},
          {new Pawn(true,this),new Pawn(true,this),new Pawn(true,this),new Pawn(true,this),
            new Pawn(true,this),new Pawn(true,this),new Pawn(true,this),new Pawn(true,this)},
            {new Rook(true,this), new Knight(true, this), new Bishop(true, this), new Queen(true, this),
              new King(true,this), new Bishop(true, this), new Knight (true, this), new Rook(true, this)}
    };
  }
  public boolean isEmpty(Location n)
  {
    if(getPiece(n) == null)//if there is no piece in that location 
      return true;
    return false;
  }
  public Piece movePiece(Location source, Location destination)
  {
    if(getPiece(source) == null)//if there is no piece at the source location 
    {
      throw new IllegalArgumentException("No Piece at Source");
    }
    if(getPiece(source).move(destination) == true)//if the move is a legal move
    {
      placePiece(getPiece(source), destination);//place the piece from the source location to the destination location
      return removePiece(source);//remove the piece from the source location 
    }
    if(getPiece(source).move(destination) == false)
    {
      throw new IllegalArgumentException("Invalid Move");//if the move isn't legal
    }
    if(getPiece(source).isWhite() == getPiece(destination).isWhite())//if the color of the source piece is the same as the color of the destination piece, then the move is invalid
    {
      throw new IllegalArgumentException("Invalid Move.  Cannot attempt to capture your own piece.");
    }
    return null;
  }
  public Piece removePiece(Location f)
  {
    Piece p;
    if (isEmpty(f) == true)
      return null;
    p = getPiece(f);
    array[f.getRow()][f.getCol()]=null;//setting the location f in the piece array to null, essentially removing the piece
    return p;
  }
  public boolean isValid(Location g)
  {
    if(g.getRow()>8&&g.getCol()<8)//if the row and column is bigger than the dimensions of the array 
    {
      return false;
    }
    return true;
  }
  public String toString()
  {
    String result = "";
    for(Piece[] arr: array)//for each arr in the piece array 
    {
      for(Piece p : arr)//for each piece in arr
      {
        if(p == null)//if the space is empty
        {
          result +=".";
        }
        else
        {
          result += p;
        }
        result += " ";
      }
      result += "\n";
    }
    return result;
  }
}




