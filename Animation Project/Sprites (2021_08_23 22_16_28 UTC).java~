//Sprites 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
public class Sprites
{
  int counter;
  private Timer timer2 = null;
  int a = 600;
  private int y = 600;
  private int rate = 100;
  ArrayList<Integer> spriteX =new ArrayList<Integer>();
  ArrayList<Integer> spriteCurrX =new ArrayList<Integer>();
 int [][] area = new int [2][4];
  public Sprites()
  {
    spriteCurrX.add(y);
    if(y>150)
    {
      y-=2;
    }
    spriteCurrX.add(y);
    
    while(a>0)
    {
      if(a>0)
      {
        a-=2;
        spriteX.add(a);
      }
    }
  }
  
  public int whichSprite()
  {
    int sprite = (int)(Math.random() * 3);
//    k.moveTheSprite();
    counter++;
    return sprite;
  }
  public ArrayList moveSprite()
  {
    return spriteX;
  }
//  public int speed(int counter)
//  {
//    if(counter <300)
//      return 7;
//    if(counter <600&& counter >= 300)
//      return 5; 
//    if(counter >=600)
//    {
//      return 1;
//    }
//    return 10;
//  }
  
}
