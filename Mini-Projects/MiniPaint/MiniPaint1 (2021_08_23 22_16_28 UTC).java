//MiniPaint1            Author:Albert Hung

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MiniPaint1
{
  public static void main (String args[])
  {
    try //Ms.Zinn told us to put this in
    { 
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
    JFrame frame = new JFrame();//create a new frame
    frame.setSize(600,600);//setting the size of the jframe
    frame.add(new MiniPaintPanel1());
    frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);//Allows user to close JFrame 
    frame.setVisible(true);//allows user to see the window
  }
}

    
