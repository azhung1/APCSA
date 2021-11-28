//Draw
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Draw extends JPanel
{
  private int currX, currY, oriX, oriY;
  public Draw()
  {
    oriX = 0;
    oriY = 0;
    currX = 0;
    currY = 0;
    addMouseListener(new Mouse());
  }
  public void paintComponent(Graphics g)
  {
    g.drawLine(oriX, oriY, currX, currY);
  }
  private class Mouse implements MouseListener
  {
    public void mousePressed(MouseEvent e)
    {
      oriX = getX();
      oriY = getY();
      repaint();
    }
    public void mouseReleased(MouseEvent e)
    {
      currX = getX();
      currY = getY();
      repaint();
    }
    public void mouseEntered(MouseEvent e) 
    {
    }
    public void mouseExited(MouseEvent e) 
    {
    }
    public void mouseClicked(MouseEvent e) 
    {
    }
  }
}