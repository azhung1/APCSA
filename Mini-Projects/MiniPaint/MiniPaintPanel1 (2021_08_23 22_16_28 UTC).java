//MiniPaintPanel1         Author: Albert Hung

import javax.swing.*;
import java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MiniPaintPanel1 extends JPanel
{
  private int currX, currY, oriX, oriY;
  private JButton Blue, Red, Yellow, Orange, Black,Line,Rectangle;
  private boolean line, rectangle;
  private String colors;
  ArrayList<Integer> A =new ArrayList<Integer>();//creating a new array list
  ArrayList<String> Shape =new ArrayList<String>();
  ArrayList<String> pColors =new ArrayList<String>();
  public MiniPaintPanel1()
  {
    colors = "black";//setting the default color to black until the user changes it
    line = true;//sets the default shape to a line
    rectangle = false;
    
    oriX = 0;
    oriY = 0;
    currX = 0;
    currY = 0;
    
    Blue = new JButton ("Blue");
    Black = new JButton ("Black");
    Red = new JButton ("Red");
    Yellow = new JButton ("Yellow");
    Orange = new JButton ("Orange");
    
    add(Blue);
    add(Black);
    add(Red);
    add(Orange);
    add(Yellow);
    
    Rectangle = new JButton ("Rectangle");
    Line = new JButton ("Line");
    
    addMouseListener(new Mouse());//created a new mouse listener for an action to be performed 
    
    Blue.addActionListener (new ButtonListener());//Waiting for the button to be pressed.  Creating a new button listener
    Black.addActionListener (new ButtonListener1());
    Red.addActionListener (new ButtonListener2());
    Orange.addActionListener (new ButtonListener3());
    Yellow.addActionListener (new ButtonListener4());
    Line.addActionListener(new ButtonListener5());
    Rectangle.addActionListener(new ButtonListener6());
    
    add(Blue);
    add(Black);
    add(Red);
    add(Orange);
    add(Yellow);
    add(Line);
    add(Rectangle);
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);//prints the paint component
    int j = 0;
    int i = 0;
    for(int a = 0;a<A.size();a+=4)//incrimenting a by 4 because we are accessing 2 points, or 4 individual values
    {
      int oneX= (int)A.get(a);//accessing the components in the array list.  
      int oneY = (int)A.get(a+1);
      int twoX = (int)A.get(a+2);
      int twoY = (int)A.get(a+3);
      if (pColors.get(j).equals("blue"))//if the component in the clors array matches the word for the color(blue) then the color would be set to blue etc.
      {
        g.setColor(Color.BLUE);
      } 
      if (pColors.get(j).equals("black"))
      {
        g.setColor(Color.BLACK);
      }
      if (pColors.get(j).equals("red"))
      {
        g.setColor(Color.RED);
      }
      if (pColors.get(j).equals("orange"))
      {
        g.setColor(Color.ORANGE);
      }
      if (pColors.get(j).equals("yellow"))
      {
        g.setColor(Color.YELLOW);
      }
      if(Shape.get(i).equals("line"))//if the element in the array for the shape indicates that it is a line
      {
        g.drawLine(oneX,oneY,twoX,twoY );//drawing a line between the inputted points
        i++;
        j++;
      }
      else if(Shape.get(i).equals("rectangle"))//if the element in the array for the shape indicates that it is a rectangle
      {
        g.drawLine(oneX, oneY, twoX, oneY);
        g.drawLine(twoX, oneY, twoX, twoY);
        g.drawLine(oneX, twoY, twoX, twoY);
        g.drawLine(oneX, oneY, oneX, twoY);
        i++;
        j++;
      }
    }
  }
  
  private class ButtonListener implements ActionListener//when the button is pressed
  {
    public void actionPerformed (ActionEvent event)
    {
      colors = "blue";//setting the string colors to equal the color the user wants
    }
  }
  private class ButtonListener1 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      colors = "black";
    }
  }
  private class ButtonListener2 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      colors = "red";
    }
  }
  private class ButtonListener3 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      colors = "orange";
    }
  }
  private class ButtonListener4 implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      colors = "yellow";
    }
  }
  private class ButtonListener5 implements ActionListener//if the button for a line is pressed, then the boolean line is set to true and rectangle is set to false
  {
    public void actionPerformed (ActionEvent event)
    {
      rectangle = false;
      line = true;
    }
  }
  private class ButtonListener6 implements ActionListener//if the button for a line is pressed, then the boolean line is set to false and rectangle is set to true
  {
    public void actionPerformed (ActionEvent event)
    {
      line = false;
      rectangle = true;
    }
  }
  private class Mouse implements MouseListener
  {
    public void mousePressed(MouseEvent e)
    {
      oriX = e.getX();//getting the x coordinate when the mouse is pressed
      oriY = e.getY();//getting the y coordinate when the mouse is pressed
      A.add(oriX);//adding the values to the array list
      A.add(oriY);
    }
    public void mouseClicked(MouseEvent e) 
    {
    }
    public void mouseReleased(MouseEvent e)//when the mouse is let go
    {
      currX = e.getX();//getting the x coordinate when the mouse is released
      currY = e.getY();//getting the y coordinate when the mouse is released
      A.add(currX);//adding the coordinates to the array list
      A.add(currY);
      if(line == true)//checking if the boolean is set to true
      {
        Shape.add("line");//if the user want a line to be drawn, than the word line will be added to the array list for shapes
        pColors.add(colors);//adding the string colors to the array list
      }
      if(rectangle == true)
      {
        Shape.add("rectangle");
        pColors.add(colors);
      }
      repaint();
    }
    public void mouseEntered(MouseEvent e) 
    {
    }
    public void mouseExited(MouseEvent e) 
    {
    }
  }
}
