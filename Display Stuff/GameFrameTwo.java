/**
* This template can be used as reference or a starting point
* for your final summative project
* @author Mangat
**/

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;  
import javax.swing.border.EmptyBorder;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class GameFrameTwo extends JFrame { 

  //class variable (non-static)
   static double x, y;
   static GameAreaPanel gamePanel;
  
  
  //Constructor - this runs first
  GameFrameTwo() { 
    
    super("My Game");  
    // Set the frame to full screen 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
    this.setUndecorated(true);  //Set to true to remove title bar
    this.setBackground(new Color(0, 65, 200, 150));
    
    //Set up the game panel (where we put our graphics)
    gamePanel = new GameAreaPanel();
    gamePanel.setBackground(new Color(0, 65, 200, 150));
    
    this.add(new GameAreaPanel());
    
    
    
    

    this.requestFocusInWindow(); //make sure the frame has focus   
    
    this.setVisible(true);
  
    //Start the game loop in a separate thread
    Thread t = new Thread(new Runnable() { public void run() { animate(); }}); //start the gameLoop 
    t.start();
   
  } //End of Constructor

  //the main gameloop - this is where the game state is updated
  public void animate() { 
    
    while(true){
      this.x = (Math.random()*1024)+200;  //update coords
      this.y = (Math.random()*768)+200;
      try{ Thread.sleep(500);} catch (Exception exc){}  //delay
      this.repaint();
    }    
  }
  
  /** --------- INNER CLASSES ------------- **/
  
  // Inner class for the the game area - This is where all the drawing of the screen occurs
  private class GameAreaPanel extends JPanel {
    public void paintComponent(Graphics g) {   
       super.paintComponent(g); //removed to keep transparent panel
    //end of mouselistener
    
}
  }
}
