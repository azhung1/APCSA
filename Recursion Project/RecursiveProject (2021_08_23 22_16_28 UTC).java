//RecursiveProject
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RecursiveProject
{  
  public static void main (String args[])
  {
    JFrame frame = new JFrame();
    frame.setSize(600,600);//creating the size of the frame
    frame.add(new RecursiveProjectPanel());
    frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);//Allows user to close JFrame 
    frame.setVisible(true);//allows the user to see it
  }
}
