//AnimationProjectPanel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
public class AnimationProjectPanel extends JPanel implements KeyListener
{
  private Timer timer = null;
  private Timer timer2 = null;
  private Timer pTimer = null;
  private int x = 600;
  private int theSprite = -1;
  private int numOfSprites = 0;
  private int counter = 0;
  private int counter2 = 0;
  private int timerCounter = 0;
  private boolean sprite = false;
  private boolean isOnGround = true;
  private boolean right = true;
  private boolean left = false;
  private int counter3 = 0;
  private boolean bird, tac, sic;
  private int y = 600;
  private int j =  0;
  private int sc = 0;
  private int tc = 0;
  private boolean secCloud = false;
  private int dinoCounter = 0;
  private int dinoJumpCounter = 0;
  private int rate = 0;
  private int ran, ran2;
  private int sCounter= 0;
  private JButton Start;
  private JLabel score;
  private int pScore = 0;
  private Image cloud, cloud2,dino,dinoO,dinoJumper,FlyingBirdThing, SingleCactus, TripleCactus;
  ArrayList<Integer> currX =new ArrayList<Integer>();
//  int [][] cloudX = new int[2][200];
  ArrayList<Integer> dinoHeight =new ArrayList<Integer>();
  Dino tinyDino = new Dino();
  Sprites s = new Sprites();
  Sprites fbt = new FlyingBirdThing();
  public AnimationProjectPanel()
  {
    bird = tac = sic = false;
    currX.add(600);
    addKeyListener(this);//Adding key listener
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    Start = new JButton("Start");
    Start.addActionListener (new ButtonListener());//Waiting for the button to be pressed.  Creating a new button listener
    add(Start);
    cloud = Toolkit.getDefaultToolkit().getImage("Cloud.png");
    cloud2 = Toolkit.getDefaultToolkit().getImage("Cloud.png");
    dino = Toolkit.getDefaultToolkit().getImage("DinoLeftUp.png");
    dinoO = Toolkit.getDefaultToolkit().getImage("DinoRightUp.png");
    dinoJumper = Toolkit.getDefaultToolkit().getImage("Dino Jump.png");
    FlyingBirdThing = Toolkit.getDefaultToolkit().getImage("FlyingBirdThing.png");
    SingleCactus = Toolkit.getDefaultToolkit().getImage("SingleCactus.png");
    TripleCactus = Toolkit.getDefaultToolkit().getImage("TakenCactus.png");
    setBackground(Color.WHITE);
//    currX.add(630);
    while(x>0)
    {
      currX.add(x);
      x-=2;
    }
    score = new JLabel(String.valueOf(pScore));
    add(score);
  }
  private class ButtonListener implements ActionListener//when the button is pressed
  {
    public void actionPerformed (ActionEvent event)
    {
      ran = (int)(Math.random() * 90);
      ran2 = (int)(Math.random() * 90);
      Start.setVisible(false);
      isOnGround = true;
      s.moveSprite();
      cloud();
      sTimer();
      tinyDinoJump();
    }
  }
  private void sTimer()
  {
    pTimer = new Timer(100, new ActionListener(){//one for loop to prevent the program from not being able to repaint
      public void actionPerformed(ActionEvent e) 
      {
        pScore++;
        score.setText(String.valueOf(pScore));
        repaint();
      }
    });
    pTimer.start();
  }
  public void sGenerator()
  {
     if(counter3 == numOfSprites)
    {
      numOfSprites = numGen();
      theSprite = s.whichSprite();
      if(theSprite == 0)
      {
        bird = true;
      }
      if(theSprite == 1)
      {
        sic = true;
      }
      if(theSprite == 2)
      {
        tac = true;
      }
      counter3 = 0;
    }
    counter3++;
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawLine(0, 200, 600, 200);
    g.drawImage(cloud, currX.get(counter), ran, 30, 20, this);
    if(counter > 150)
    {
      secCloud = true;
    }
    if(secCloud ==true)
    {
      g.drawImage(cloud, currX.get(counter2), ran2, 45, 30, this);
      counter2++;
    }
   sGenerator();
    
    if(bird == true)
    {
      if(j == 300)
      {
//        g.drawImage(FlyingBirdThing, 620, 155, 90, 60, this);
        bird = false;
        j = 0;
      }
      else
      {
        g.drawImage(FlyingBirdThing, moveSprite(s.spriteX,j), 155, 90, 60, this);
        j++;  
      }
    }
    if(sic == true)
    {
      if(sc == 300)
      {
//        g.drawImage(SingleCactus, 620, 161, 90, 60, this);
        sc = 0;
        sic = false;
      }
      g.drawImage(SingleCactus, moveSprite(s.spriteX,sc), 161, 90, 60, this);
      sc++;
    }
    if(tac)
    {
      if(tc == 300)
      {
//        g.drawImage(TripleCactus, 620, 160, 90, 60, this);
        tc = 0;
        tac = false;
      }
      g.drawImage(TripleCactus, moveSprite(s.spriteX,tc), 160, 90, 60, this);
      tc++;
    }
    if(isOnGround == true)
    {
      if(dinoCounter == 15)
      {
        right = true;
        left = false;
      }
      if(dinoCounter == 30)
      {
        right = false;
        left = true;
        dinoCounter = 0;
      }
      dinoCounter ++;
      if(right == true)
      {
        g.drawImage(dino, 130, 180, 60, 30, this);
      }
      if(left == true)
      {
        g.drawImage(dinoO, 130, 180, 60, 30, this);
      }
    }
    if(isOnGround == false)
    {
      if(dinoJumpCounter < tinyDino.jumpArray().size())
      {
        g.drawImage(dinoJumper, 135,dinoHeight.get(dinoJumpCounter), 58,75,this);
        dinoJumpCounter ++;
      }
      if(tinyDino.jumpArray().size() == dinoJumpCounter)
      {
        dinoJumpCounter = 0;
        isOnGround= true;
      }
    }
  }
  public void tinyDinoJump()
  {
    for (int i = 0; i<tinyDino.jumpArray().size();i++)
    {
      dinoHeight.add(tinyDino.jump(i));
    }
  }
  public void keyPressed(KeyEvent e)
  {
    int o = e.getKeyCode();
    if(o == KeyEvent.VK_SPACE)//if the space bar is pressed
    {
      isOnGround = false;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }
  public void keyReleased(KeyEvent e)
  {
  }
  private int moveSprite(ArrayList<Integer> s, int h)
  {
    int p = s.get(h);
    return p;
  }
  private int numGen()
  {
    return (int) (Math.random()*180+30);
  }
  private void cloud()
  {
    timer = new Timer(5, new ActionListener(){//one for loop to prevent the program from not being able to repaint
      public void actionPerformed(ActionEvent e) 
      {
        if(counter %300 == 1)
        {
          ran = (int)(Math.random() * 90);
        }
        if(counter2 %300 == 1)
        {
          ran2 = (int)(Math.random() * 90);
        }
//        timerCounter++;
        if(counter<300)
        {
          counter++;
        }
        
        else if(counter==300)
        {
          counter = 0;
        }
        
        if(counter2>300)
        {
          counter2 = 0;
        }
        repaint();
      }
    });
    timer.start();
  }
//  private void rate()
//  {
//    int rateC = s.speed(sCounter);
//    timerC = new Timer(rateC, new ActionListener(){//one for loop to prevent the program from not being able to repaint
//      public void actionPerformed(ActionEvent e) 
//      {
//        sCounter++;
//        repaint();
//      }
//    });
//    timerC.start();
//  }
  
}

