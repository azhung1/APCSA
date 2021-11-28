//Dino
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
public class Dino extends Sprites
{
  private double h = 157;
  ArrayList<Integer>heightJ = new ArrayList<Integer>();
  public Dino()
  {
    //-.175(x-20)^2 +70
    for(int i = 1; i<=70;i++)
    {
      int f = (int)(-0.0571*Math.pow(i-35,2)+70);
      heightJ.add(f);
    }
    for(int c = 0; c < heightJ.size(); c++)
    {
      heightJ.set(c, 157 - heightJ.get(c));
    }
//     heightJ.add(i);
//       i -=2;
//     while(i>120)
//     {
//       heightJ.add(i);
//       i -=2;
//     }
//     while(i<180)
//     {
//        heightJ.add(i);
//       i +=2;
//     }
  }
   public boolean isDead()
  {
    return false;
  }
   public int jump(int a)
   {
     return heightJ.get(a);
   }
   public ArrayList jumpArray()
   {
     return heightJ;
   }
}