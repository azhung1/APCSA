//Quadrilateral
//
public class Quadrilateral
{
  private Point []arr;
  public Quadrilateral(Point p, Point g, Point h, Point j)
  {
    arr = new Point[] {p, g, h, j};//creates a new array with 4 points
  }
  public boolean isTrapezoid()
  {
    if((arr[0].slope(arr[1])==arr[2].slope(arr[3])||(arr[0].slope(arr[3])==arr[2].slope(arr[1]))))//A trapzoid is a quadrilateral that has at least one pair of parallel lines.  This is testing the
      //the values of the slope to see if they are equal
    {
      return true;
    }
    return false;
  }
  public boolean isParallelogram()
  {
    if(arr[0].distance(arr[1])==arr[2].distance(arr[3])&&(arr[0].slope(arr[1])==arr[2].slope(arr[3])))//A parallelogram is a quadrilateral with one pair of equal and parallel lines.  I only need to 
      //test one pair of opposite sides because they would have to be the same length and have the same slope if the quadrilateral is a parallelogram
    {
      return true;
    }
    return false;
  }
  public boolean isRectangle()
  {
    if(isParallelogram())//A rectangle is a parallelogram.  If it is a parallelogram, it enters the if statement
    {
      if(arr[0].distance(arr[2]) == arr[1].distance(arr[3]))//A rectangle is a parallelogram with congruent diagonals.  This is getting the length of the diagonals and comparing them 
      {
        return true;
      }
    }
    return false;
  }
  public boolean isRhombus()
  {
    if(isParallelogram())//A rhombus is a parallelogram.  If it is a parallelogram, it enters the if statement
    {
      if((arr[0].distance(arr[1])==arr[2].distance(arr[1])))//A rhobus will have adjacent congruent sides
      {
        return true;
      }
    }
    return false;
  }
  public boolean isSquare()
  {
    if(isRhombus()&&isRectangle())//a square has to be a rhobus and a parallelogram 
    {
      return true;
    }
    return false;
  }
  public static boolean approx(double a , double b)
  {
    return Math.abs(a-b)<0.000001;
  }
  public void setArr(Point p, Point g, Point h, Point j)//accessor mutator method
  {
    Point []arr = new Point[] {p, g, h, j};
  }
  public Point[] getArr()
  {
    return arr;
  }
  public String toString()//returns the results of each method
  {
    boolean temp = false;
    String result = "";
    for (int i =0; i<4;i++)//To see if any 2 points are equal
    {
      for (int j = i+1;j <4;j++)
      {
        if(arr[i].equals(arr[j]))
        {
          temp = true;
        }
      }
    }
    if(temp == true)//if any points are equal, return false for every method
    {
      result += "Is it a Trapezoid?\n" + false;//calls method is trapezoid and returns the result 
      result += "\nIs it a Parallelogram?\n" + false;
      result += "\nIs it a Rectangle?\n" + false;
      result += "\nIs it a Rhombus?\n" + false;
      result += "\nIs it a Square?\n" + false;
    }
    else
    {
      result += "Is it a Trapezoid?\n" + isTrapezoid();//calls method is trapezoid and returns the result 
      result += "\nIs it a Parallelogram?\n" + isParallelogram();
      result += "\nIs it a Rectangle?\n" + isRectangle();
      result += "\nIs it a Rhombus?\n" + isRhombus();
      result += "\nIs it a Square?\n" + isSquare();
    }
    return result;
  }
}