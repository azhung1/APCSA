public class L implements RPSLSStrategy {
  private int oppLast;
  
  public String strategyName() {
    return "L";
  }
  
  public String coderName() {
    return "F";
  }
  
  public int getThrow() {
    return oppLast;
  }
  
  public void opponentsLastThrow(int lastThrow) 
  {
    oppLast = lastThrow;
  }
  public void reset() 
  {
    
  }
}