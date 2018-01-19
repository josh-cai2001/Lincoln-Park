//Moving on a Map/Moving a map around a player

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;
import java.util.Random;

/*An Example demonstrating a simple game loop
* 
* This version includes time.
* The old version moves the object across the screen based on frame rate (calls to repaint)
* This version will move the object based on elapsed time to make it consistent regardless of the framRate
* We will make a new 'Clock' class to track time
* 
* @Author Mangat
*/

//This class is used to start the program and manage the windows
class PlayerMapMovement { 

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
   getContentPane().add( new GamePanel());
   pack(); //makes the frame fit the contents
   setVisible(true);
  }
  


// An inner class representing the panel on which the game takes place
static class GamePanel extends JPanel implements KeyListener{
  
  MovingBox box;
  FrameRate frameRate;
  Clock clock;
  Map map;  
  
  //constructor
  public GamePanel() { 
    setPreferredSize(new Dimension(1024,768));
    addKeyListener(this);
    setFocusable(true);
    requestFocusInWindow();
    frameRate = new FrameRate();
    clock=new Clock();
    map = new Map(1024,768);
    //box = new MovingBox(map);
  }
  
  
  public void paintComponent(Graphics g) { 
    super.paintComponent(g); //required to ensure the panel si correctly redrawn
    //update the content
    //draw the screen
    map.draw(g);
    //request a repaint
    repaint();
  }

  public void keyTyped(KeyEvent e) {      
   if(e.getKeyChar() == 'a' ){    //Good time to use a Switch statement
      System.out.println("left");
      map.playerX--;
   } else if(e.getKeyChar() == 's' ){
      System.out.println("down");
      map.playerY++;
   } else if(e.getKeyChar() == 'd' ){
      System.out.println("right");
      map.playerX++;
   } else if(e.getKeyChar() == 'w' ){
      System.out.println("up");
      map.playerY--;
   }
  }
  
  public void keyPressed(KeyEvent e) {
 
  }
  
  public void keyReleased(KeyEvent e) {            
  }  
  
}

}


 class Map { 
  int boxWidth;
  int boxHeight;
  int visibleWidth, visibleHeight;
  int playerX, playerY;
  int map[][]= { 
        {0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,1,1,0},
        {0,1,1,0,0,1,0,0,1,0},
        {0,1,1,1,0,1,0,1,1,0},
        {0,1,0,1,1,1,1,1,1,0},
        {0,1,1,0,0,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0}};  //this can be laoded from a file
  
   public Map(int xResolution,int yResolution) { 
      visibleWidth=5; //The size of the visible portion of the map
      visibleHeight=4;  
      
      boxWidth = 1024/visibleWidth;
      boxHeight = 768/visibleHeight;
      
      playerX = 5;
      playerY = 5;
   }
   
   public void draw(Graphics g) { 
     
     for (int j=0;j<visibleHeight;j++)
       for (int i=0;i<visibleWidth;i++) {
       if (map[playerY-visibleHeight/2+j][playerX-visibleWidth/2+i]==0) 
         g.setColor(Color.BLUE);
       else
         g.setColor(Color.RED);
       //draw the rectange
       g.fillRect(i*boxWidth, j*boxHeight, boxWidth-1, boxHeight-1);  //-1 to see edges

     }
   }
   
   }
