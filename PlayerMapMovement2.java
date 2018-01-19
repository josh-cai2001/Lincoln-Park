//Moving on a Map/Moving a map around a player
//using file I/O to load a large map

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import java.util.Scanner;


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
class PlayerMapMovement2 { 

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
      //if  (map.playerX>map.visibleWidth)
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
   }  //note - would be better to make player class and pass in map, test movement in there
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
  int map[][]; //this is loaded from a file*/
  
   public Map(int xResolution,int yResolution) { 
      visibleWidth=20; //The size of the visible portion of the map
      visibleHeight=16;  
      
      boxWidth = 1024/visibleWidth;
      boxHeight = 768/visibleHeight;
      
      playerX = 25;
      playerY = 25;
      
      map = loadMapData("map.txt");     
   }
   
   public int[][] loadMapData(String filename) { 
     int data[][]=null;
     try {                                 
       
       File f = new File(filename);
       Scanner input = new Scanner(f);   
       data = new int[input.nextInt()][input.nextInt()]; // first two line are map size

       for (int j=0;j<data.length;j++){
         for (int i=0;i<data[0].length;i++)   {    
           data[j][i]=input.nextInt();
          // System.out.print(data[j][i]+" ");
         }
        // System.out.println("");
       }
       input.close();    
     } catch(Exception E){};
     return data;
   }
 
   
   public void draw(Graphics g) { 
     
     for (int j=0;j<visibleHeight;j++)
       for (int i=0;i<visibleWidth;i++) {
       if (map[playerY-visibleHeight/2+j][playerX-visibleWidth/2+i]==0) 
         g.setColor(Color.LIGHT_GRAY);
       else
         g.setColor(Color.DARK_GRAY);
       //draw the rectange
       g.fillRect(i*boxWidth, j*boxHeight, boxWidth-1, boxHeight-1);  //-1 to see edges

     }
   }
   
   }
