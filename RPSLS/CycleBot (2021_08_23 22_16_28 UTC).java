public class CycleBot implements RPSLSStrategy {
  private int oppLast;
  private int bot = 0;
  
  public String strategyName() {
    return "CycleBot";
  }
  
  public String coderName() {
    return "Zinnderella";
  }
  
  public int getThrow() {
    bot ++;
//System.out.print("\nthrow: " + (bot %5));
    return bot % 5;
  }
  
  public void opponentsLastThrow(int lastThrow) {
    oppLast = lastThrow;
  }
  
  public void reset() {
    
  }
}