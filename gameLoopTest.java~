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
  
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  double width = screenSize.getWidth();
  double height = screenSize.getHeight() - 100;
  
  //Window constructor
  public GameWindow() { 
    setTitle("Simple Game Loop Example");
    setSize((int)width,(int)height);  // set the size of my window to 400 by 400 pixels
    setResizable(true);  // set my window to allow the user to resize it
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // set the window up to end the program when closed
    GamePanel gp = new GamePanel();
    getContentPane().add(gp);
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
    Zombie zom;
    int wait = 0;
    
    //constructor
    public GamePanel() { 
      setPreferredSize(new Dimension((int)width,(int)height));
      box = new Character(50, 50, 25, 25, 50, 0, 50, 50);
      clock=new Clock();
      kL = new CharacterKeyListener();
      zom = new Zombie(500, 500, 25, 25, 50);
      this.addKeyListener(kL);
      this.requestFocusInWindow();
    }
    
    
    
    public void paintComponent(Graphics g) { 
      super.paintComponent(g); //required to ensure the panel si correctly redrawn
      
      
      
      //update the content
      clock.update();
      if (box != null){
        zom.move(box.returnX(), box.returnY(), box);
      }
//      box.update(clock.getElapsedTime());  //you can 'pause' the game by forcing elapsed time to zero
      
      if ((box != null) &&(zom.checkCollision(box)) && wait <= 0){
        box.loseHealth(5);
        System.out.println("collide" + box.returnHealth());
        wait = 500;
      }
      else if (box != null){
        wait--;
      }
      
      if (box != null && (box.returnHealth() <= 0)){
        box = null;
      }
      
      //draw the screen
      if (box != null){
        box.draw(g);
      }
      zom.draw(g);
      
      //request a repaint
      repaint();
    }
    
    class CharacterKeyListener implements KeyListener{
      
      public void keyTyped(KeyEvent e) {  
      }
      
      public void keyPressed(KeyEvent e) {
        
        if ((box != null) && (!box.checkUpCollision(zom)) && (box.returnY() >= 0) && (KeyEvent.getKeyText(e.getKeyCode()).equals("W"))) {  
          box.moveUp();
        } 
        if ((box != null) && (!box.checkLeftCollision(zom)) && (box.returnX() >= 0) && (KeyEvent.getKeyText(e.getKeyCode()).equals("A"))) {  
          box.moveLeft();
        }  
        if ((box != null) && (!box.checkDownCollision(zom)) && (box.returnY() <= (height - box.returnH())) && (KeyEvent.getKeyText(e.getKeyCode()).equals("S"))) {  
          box.moveDown();
        } 
        if ((box != null) && (!box.checkRightCollision(zom)) && (box.returnX() <= (width - box.returnW())) && (KeyEvent.getKeyText(e.getKeyCode()).equals("D"))) {  
          box.moveRight();
        } 
      }  
      
      
      public void keyReleased(KeyEvent e) {
      }
    }
    
  }
  
}



//A class to represent the object moving around on the screen






