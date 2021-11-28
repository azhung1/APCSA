//AccountDriver
public class AccountDriver 
{
  public static void main(String[] args) 
  {
    Account[] acctList = new Account[6];
    //WRITE: Populate the array with 2 of each type of account. For each type, call
    //each constructor once.
    acctList [0] = new Account("Account 1", 1);
    acctList[1] = new Account();
    acctList [2] = new CheckingAccount("Account 3", 100,1);
    acctList [3] = new CheckingAccount("Account 4", 2);
    acctList [4] = new SavingsAccount("Account 5", 100, 0.03);
    acctList [5] = new SavingsAccount("Account 6", 1000, 0.05);
    
    printAccounts(acctList);
    System.out.println();
    //WRITE: make a couple of deposits to a couple of accounts. Make a couple of
    //withdrawals: some that work, and some that exceed the balance.
    acctList [0].deposit(800);
    acctList[1].withdraw(6000);
    ((CheckingAccount)acctList[2]).writeCheck(30,"Hlo");
    acctList [2].withdraw(324);
    ((CheckingAccount)acctList[3]).writeCheck(1234,"BOo");
    acctList [3].withdraw(5);
    acctList [4].deposit(43);
    acctList [5].deposit(1000);
    
    
    printAccounts(acctList);
    System.out.println();
    
    //Take a look at the code below. It will compound the interest on the SavingsAccount
    //objects ONLY. It uses a new operator "instanceof". What do you think it does?
    //instanceof checks is accList[i] is an instance of SavingsAccount
    for (int i = 0; i < acctList.length; i++) 
    {
      if (acctList[i] instanceof SavingsAccount)
        ((SavingsAccount) acctList[i]).compoundInterest();
    }
    
    printAccounts(acctList);
    System.out.println();
  }
  
  //Prints out all the Accounts in the array. Just iterate through the
  //array and print out each Account. Don't overthink this one.
  //However, be attentive to the polymorphism here--each call to
  //System.out.println calls each object's toString method. This
  //will result in different code being run depending on the type of
  //the object being printed.
  public static void printAccounts(Account[] acctArray)
  {
    for (int x = 0; x<6; x++)
    {
      System.out.print(acctArray[x]);
    }
  }
}

