//ChessDriver
import java.util.Scanner;
public class ChessDriver
{
  public static void main(String[] args) 
  {
    int turn = 0;
    Board b = new Board(true);//instantiate a new board
    System.out.print(b);//print outs the biard
    while(true)
    {
      Scanner scan = new Scanner(System.in);
      String l = "";
      try//trying everything in the loop.  If there is an error, it well be caught 
      {
        String a = scan.next();
        Location p = new Location(a);//making a new location at the entered location
        Piece oldPiece = b.getPiece(p);
        String move = scan.next();
        Location g = new Location(move);
        if(turn%2 ==1)
        {
          if(oldPiece.isWhite() != false)//odd number turns are black turns
          {
            l="Cannot move piece that is not your own color.\n";
            System.out.print(l);
            turn = turn;
          }
        }
        if(turn%2 ==0)
        {
          if(oldPiece.isWhite() != true)//even number turns are white
          {
            l="Cannot move piece that is not your own color.\n";
            System.out.print(l);
            turn =turn;
          }
        }
        if(l.equals(""))
        {
          b.movePiece(p,g);//tries to move the piece at the source to destination location 
          turn ++;
        }
      }
      catch (Exception  e)//catching exception if thrown in the try
      {
        if( e instanceof NullPointerException)//if there is a null pointer exception 
        {
          System.out.print("No Piece at Source\n");
          turn = turn;
        }
        else
        {
          System.out.print(e.getMessage() + "\n");//get the message thrown
          turn = turn;
        }
      }
      System.out.print(b.toString());
    }
  }
}
