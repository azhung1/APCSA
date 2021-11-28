//CheckingAccount
import java.text.NumberFormat; 
public class CheckingAccount extends Account 
{
  //Additional properties/fields:
  private int nextCheckNumber;
  NumberFormat num = NumberFormat.getCurrencyInstance();
  //Additional methods:
  
  //Constructs a CheckingAccount with given owner, balance, and starting check number.
  public CheckingAccount(String newOwner, double initBalance, int startingCheckNumber) 
  {
//    super(newOwner, initBalance);
    System.out.println("$%3453453425" + newOwner);
    nextCheckNumber = startingCheckNumber;
  }
  
  //Constructs a CheckingAccount with given owner and starting check number, with an
  //initial balance of zero, by calling THIS class' other constructor method.
  public CheckingAccount(String newOwner, int startingCheckNumber) 
  {
    this(newOwner, 0, startingCheckNumber);
  }
  
  //Additional accessor
  public int getNextCheckNumber() 
  {
    return nextCheckNumber;
  }
  
  //Writes a check for the given amount to the given recipient.
  //Always increment nextCheckNumber.
  //If the amount exceeds the balance, leave the balance alone, print a message
  //that the check has bounced, and return false.
  //Otherwise, decrease the balance by the amount of the check, print a "check"
  //to the screen showing the check number, recipient, and amount of the check (this is in
  //lieu of printing an actual check), and return true.
  public boolean writeCheck(double amount, String recipient) 
  {
    int checknumber = 0;
    double x = super.getBalance();
    checknumber++;
    if(amount > x)
    {
      System.out.print("\nYour amount exceeded your balance. Check was bounced. Please call 516 237 2384 for assistance.\n");
      return false;
    }
    x -=amount;
    System.out.print("\n******************\nCheck Number: " + checknumber + "\nRecipient: " + recipient + "\nAmount: "+ num.format(x)+ "\n******************\n");
    return true;
  }
  //Returns a String representation of the Checking Account. This can call the 
  //Account's toString method (by using super.toString()) but must add the
  //next check number to the returned value.
  public String toString() 
  {
    String result = "";
    result += super.toString();
    result += "\nCheck number: " + nextCheckNumber;
    return result;
  }
}

