//DrawDriver
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DrawDriver
{
  public static void main (String args[])
  {
    JFrame frame = new JFrame();
    frame.setSize(600,600);
    frame.add(new Draw());
    frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);//Allows user to close JFrame 
    frame.setVisible(true);
  }
}