//Testrun
import java.util.ArrayList;
public class Testrun implements RPSLSStrategy {
  private int oppLast, oppPrev;
  ArrayList <Integer> list = new ArrayList<Integer>();
  ArrayList <Integer> throwList = new ArrayList<Integer>();
  ArrayList <Integer> throwDifference = new ArrayList<Integer>();
  private int i = 0;
  private int h;
  private int difference = 23;
  private int first = 3;
  private int counter = 0;
  private int random;
  private boolean turn = false;
  private boolean repeat = false;
  public String strategyName() 
  {
    return "L";
  }
  public String coderName() 
  {
    return "Albert";
  }
  public int getThrow() 
  {
    if(repeat == true)
    {
      
      return throwList.get(i-1);
    }
    
    
    
    else
    {
      if(turn == false)
      {
        
        
        {
          if(i == 23)
          {
            i = 0;
          }
          while(i<23)
          {
            i++;
            
            return throwList.get(i-1);
          }
          
          if(list.size() <23)
          {
            h = oppLast;
          }
          return 0;
        }
      }
      else
      {
        if(i == difference)
        {
          i = 0;
        }
        while(i<difference)
        {
          i++;
          
          return throwList.get(i-1);
        }
        
        if(list.size() <difference)
        {
          h = oppLast;
        }
        return 0;
      }
    }
  }
  public void opponentsLastThrow(int lastThrow) 
  {
    oppLast = lastThrow;
    if(turn == false)
    {
      if(counter<23)
      {
        
        list.add(oppLast);
        
        counter++;
      }
      if(counter == 23)
      {
        turn = true;
        i=0;
        counter =0;
      }
      
      if (list.size()==23)
      {
        random = (int)((Math.random()*4) +1);
      }
      
      if(random==1)
      { 
        for(int f = 0; f<23;f++)
        {
          if(list.get(f)==0)
          {
            throwList.add(1);
          }
          if(list.get(f)==1)
          {
            throwList.add(2);
          }
          if(list.get(f)==2)
          {
            throwList.add(0);
          }
          if(list.get(f)==3)
          {
            throwList.add(0);
          }
          if(list.get(f)==4)
          {
            throwList.add(1);
          }
        }
      }
      if(random==2)
      {
        for(int f = 0; f<list.size();f++)
        {
          if(list.get(f)==0)
          {
            throwList.add(4);
          }
          if(list.get(f)==1)
          {
            throwList.add(3);
          }
          if(list.get(f)==2)
          {
            throwList.add(0);
          }
          if(list.get(f)==3)
          {
            throwList.add(2);
          }
          if(list.get(f)==4)
          {
            throwList.add(3);
          }
        }
      }
      
      if(random==3)
      {
        for(int f = 0; f<list.size();f++)
        {
          if(list.get(f)==0)
          {
            throwList.add(1);
          }
          if(list.get(f)==1)
          {
            throwList.add(2);
          }
          if(list.get(f)==2)
          {
            throwList.add(4);
          }
          if(list.get(f)==3)
          {
            throwList.add(2);
          }
          if(list.get(f)==4)
          {
            throwList.add(3);
          }
        }
      }
      if(random==4)
      {
        for(int f = 0; f<list.size();f++)
        {
          if(list.get(f)==0)
          {
            throwList.add(4);
          }
          if(list.get(f)==1)
          {
            throwList.add(3);
          }
          if(list.get(f)==2)
          {
            throwList.add(4);
          }
          if(list.get(f)==3)
          {
            throwList.add(0);
          }
          if(list.get(f)==4)
          {
            throwList.add(1);
          }
        }
      }
      
      if(list.size()==23)
      {
        for (int u = 0; u<23;u++)
        {
          if (list.get(u) == 3)
          {
            throwDifference.add((u+1));
          }
        }
      }
      difference = throwDifference.get(2) - throwDifference.get(1);
      int difference2 = throwDifference.get(2) - throwDifference.get(1);
      int difference3 = throwDifference.get(3) - throwDifference.get(2);
      int difference4 = throwDifference.get(4) - throwDifference.get(3);
      
      if(difference == 0)
      {
        if(difference2 == difference && difference3 == difference && difference4 == difference)
        {
          repeat = true;
          System.out.print(repeat);
        }
      }
      if(list.size() == 23)
      {
        list.clear();
        
      }
      
    }
    else 
    {
      if(counter<difference)
      {
        list.add(oppLast);
        counter++;
      }
      if(counter == difference -1)
      {
        counter =0;
      }
      if (list.size()==difference)
      {
        random = (int)((Math.random()*4) +1);
      }
      if(random==1)
      { 
        for(int f = 0; f<difference;f++)
        {
          if(list.get(f)==0)
          {
            throwList.set(f,1);
          }
          if(list.get(f)==1)
          {
            throwList.set(f,2);
          }
          if(list.get(f)==2)
          {
            throwList.set(f,0);
          }
          if(list.get(f)==3)
          {
            throwList.set(f,0);
          }
          if(list.get(f)==4)
          {
            throwList.set(f,1);
          }
        }
      }
    }
    if(random==2)
    {
      for(int f = 0; f<list.size();f++)
      {
        if(list.get(f)==0)
        {
          throwList.set(f,4);
        }
        if(list.get(f)==1)
        {
          throwList.set(f,3);
        }
        if(list.get(f)==2)
        {
          throwList.set(f,0);
        }
        if(list.get(f)==3)
        {
          throwList.set(f,2);
        }
        if(list.get(f)==4)
        {
          throwList.set(f,3);
        }
      }
    }
    if(random==3)
    {
      for(int f = 0; f<list.size();f++)
      {
        
        if(list.get(f)==0)
        {
          throwList.set(f,1);
        }
        if(list.get(f)==1)
        {
          throwList.set(f,2);
        }
        if(list.get(f)==2)
        {
          throwList.set(f,4);
        }
        if(list.get(f)==3)
        {
          throwList.set(f,2);
        }
        if(list.get(f)==4)
        {
          throwList.set(f,3);
        }
      }
    }
    if(random==4)
    {
      for(int f = 0; f<list.size();f++)
      {
        if(list.get(f)==0)
        {
          throwList.set(f,4);
        }
        if(list.get(f)==1)
        {
          throwList.set(f,3);
        }
        if(list.get(f)==2)
        {
          throwList.set(f,4);
        }
        if(list.get(f)==3)
        {
          throwList.set(f,0);
        }
        if(list.get(f)==4)
        {
          throwList.set(f,1);
        }
      }
    }
    
    if(list.size()<23)
    {
      for (int u = 0; u<23;u++)
      {
        if (list.get(u) == first)
        {
          difference = u +1;
        }
      }
    }
    if(list.size() == difference)
    {
      list.clear();
    }
  }
  
  public void reset() 
  {
    
    
  }
}