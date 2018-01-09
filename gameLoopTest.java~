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
    Clock clock;
    CharacterKeyListener kL;
    
    //constructor
    public GamePanel() { 
      setPreferredSize(new Dimension(1024,768));
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
//      box.update(clock.getElapsedTime());  //you can 'pause' the game by forcing elapsed time to zero
      
      //draw the screen
      box.draw(g);
      
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






