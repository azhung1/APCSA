//Point 

public class Point
{
  private double x, y;
  public Point(double xVal, double yVal)
  {
    x = xVal;
    y = yVal;
  }
  public void setX(double xValue)//access mutator method
  {
    x = xValue;
  }
  public Double getX()
  {
    return x;
  }
  public void setY(double yValue)//access mutator method
  {
    y = yValue;
  }
  public Double getY()
  {
    return y;
  }
  public double distance(Point p)//distance formula between 2 points
  {
    double xDistance = Math.pow(p.getX()-x,2);//the difference of the x values squared
    double yDistance = Math.pow(p.getY()-y,2);//the differences of the y values squared
    double distance = Math.sqrt(xDistance +yDistance);//the square root of the sum is the final distance
    return distance;
  }
  public boolean equals(Point p)
  {
    return approx(p.getX(),x)&& approx(p.getY(),y);//calls the approx method to see if the x values and y value of 2 points are equal
  }
  public Point midpoint (Point p)
  {
    double xMidpoint = (p.getX() + x)/2;//the average of the 2 x values
    double yMidpoint = (p.getY() + y)/2;//the average of the 2 y values
    Point mp = new Point(xMidpoint, yMidpoint); //the midpoint is the average of both the x and y values
    return mp;
  }
  public double slope(Point p)
  {
    double infinity = Double.POSITIVE_INFINITY;
    double deltaX = p.getX() - x;//getting the difference in x values in the point you want to find and the point you are in
    double deltaY = p.getY() - y;//getting the difference in y values in the point you want to find and the point you are in
    if (deltaX == 0)
    {
      return infinity;//when dividing by 0, or the slope is undefined, then return infinity
    }
    return deltaY/deltaX;//returning the change in y over the change in x, which represents the slope
  }
  public static boolean approx(double a, double b)
  {
    return Math.abs(a-b)<0.000001;//Looking to see if their is a small difference between the values.  If there is a miniscule difference, it will return true to them being equal 
  }
  public String toString()//to string which provides a summary 
  {
    String results = "";
    results = "x: " +x +"\ny: " +y;
    return results ;
  }
}
