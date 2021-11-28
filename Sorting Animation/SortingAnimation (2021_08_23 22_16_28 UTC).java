//SortingAnimation
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SortingAnimation
{  
  public static void main (String args[])
  {
    try 
    { 
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
    JFrame frame = new JFrame();
    frame.setSize(650,400);//creating the size of the frame
    frame.add(new SortingAnimationPanel());
    frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);//Allows user to close JFrame 
    frame.setVisible(true);//allows the user to see it
  }
}