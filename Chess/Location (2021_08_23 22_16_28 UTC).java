//Location

public class Location
{
  private int row, column;
  private String loc;
  public Location(int r,int c)
  {
    row = r;
    column = c;
  }
  public Location(String loc)
  {
    loc = loc.toUpperCase();//changing all characters in the string to upper case
    char first = loc.charAt(0);
    int number = (int)first;//making the first character in the string to ascii 
    if(loc.length() >2||number<65||number>72||loc.charAt(1)>=1&&loc.charAt(1)<=8)//make sure the entered locations are the right format(first char between a-h and the second 1-8)
    {
      throw new IllegalArgumentException("F");//if it isn'r throw an exception 
    }
    else 
    {
      row =  8 - (loc.charAt(1)-'0');//converting the ascii number to how we want to set up the board
      column = loc.charAt(0)-'A';
      Location n = new Location(row,column);
    }
  }
  public void setRow(int r)
  {
    row = r;
  }
  public int getRow()
  {
    return row;
  }
  public void setCol(int c)
  {
    column = c;
  }
  public int getCol()
  {
    return column;
  }
  public String toString()
  {
    String results = "Row: "+ row + "\nColumn: " + column;
    return results;
  }
  public boolean equals(Location n)
  {
    return (row==n.getRow()&&column==n.getCol());//looking to see if the current location and the passed parameter is the same 
  }
}