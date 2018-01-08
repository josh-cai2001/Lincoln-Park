import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//This class is used to start the program and manage the windows
class gameLoopTest { 
  
  public static void main(String[] args) { 
    GameWindow game= new GameWindow();  
  }
  
}

//This class represents the game window
class GameWindow extends JFrame { 
  
  //Window constructor
  public GameWindow() { 
    setTitle("Simple Game Loop Example");
    //setSize(1280,1024);  // set the size of my window to 400 by 400 pixels
    setResizable(true);  // set my window to allow the user to resize it
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // set the window up to end the program when closed
    GamePanel gp = new GamePanel();
    getContentPane().add(gp);
//    CharacterKeyListener keyListener = new CharacterKeyListener();
//    this.addKeyListener(keyListener);
     //make sure the frame has focus   
    pack(); //makes the frame fit the contents
    gp.requestFocusInWindow();
    setVisible(true);
    
  }
  
  
  
// An inner class representing the panel on which the game takes place
  class GamePanel extends JPanel{
    
    Character box;
    FrameRate frameRate;
    Clock clock;
    CharacterKeyListener kL;
    
    //constructor
    public GamePanel() { 
      setPreferredSize(new Dimension(1024,768));
      frameRate = new FrameRate();
      box = new Character(50, 50, 50, 10, 50, 50);
      clock=new Clock();
      kL = new CharacterKeyListener();
      this.addKeyListener(kL);
      this.requestFocusInWindow();
    }
    
    
    public void paintComponent(Graphics g) { 
      super.paintComponent(g); //required to ensure the panel si correctly redrawn
      
      
      
      //update the content
      clock.update();
      frameRate.update();
//      box.update(clock.getElapsedTime());  //you can 'pause' the game by forcing elapsed time to zero
      
      //draw the screen
      box.draw(g);
      frameRate.draw(g,10,10);
      
      //request a repaint
      repaint();
    }
    
    class CharacterKeyListener implements KeyListener{
      public void keyTyped(KeyEvent e) {  
      }
      
      public void keyPressed(KeyEvent e) {
        
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  
          box.moveUp(box.returnFatigue());
        } 
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {  
          box.moveLeft(box.returnFatigue());
        }  
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {  
          box.moveDown(box.returnFatigue());
        } 
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {  
          box.moveRight(box.returnFatigue());
        } 
      }  
      
      
      public void keyReleased(KeyEvent e) {
      }
    }
    
  }
  
}



//A class to represent the object moving around on the screen


//Better to abstract the FrameRate stuff
class FrameRate { 
  
  String frameRate; //to display the frame rate to the screen
  long lastTimeCheck; //store the time of the last time the time was recorded
  long deltaTime; //to keep the elapsed time between current time and last time
  int frameCount; //used to cound how many frame occurred in the elasped time (fps)
  
  public FrameRate() { 
    lastTimeCheck = System.currentTimeMillis();
    frameCount=0;
    frameRate="0 fps";
  }
  
  public void update() { 
    long currentTime = System.currentTimeMillis();  //get the current time
    deltaTime += currentTime - lastTimeCheck; //add to the elapsed time
    lastTimeCheck = currentTime; //update the last time var
    frameCount++; // everytime this method is called it is a new frame
    if (deltaTime>=1000) { //when a second has passed, update the string message
      frameRate = frameCount + " fps" ;
      frameCount=0; //reset the number of frames since last update
      deltaTime=0;  //reset the elapsed time     
    }
  }
  
  public void draw(Graphics g, int x, int y) {
    g.drawString(frameRate,x,y); //display the frameRate
  }
  
  
}



