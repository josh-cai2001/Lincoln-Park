/**
* This template can be used as reference or a starting point
* for your final summative project
* @author Mangat
**/

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
  
//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Mouse imports
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class GameFrame extends JFrame { 
  
  public static BufferedImage tingImage;
  
  public static boolean pressW = false;
  public static boolean pressA = false;
  public static boolean pressS = false;
  public static boolean pressD = false;
  
    public static void main(String[] args) {
      
    try {
      tingImage = ImageIO.read(new File("./images/dab.jpg"));
    } catch (IOException e) {}
    
    tingImage = resizeImage(tingImage, (int)(ting.getWidth()), (int)(ting.getHeight()));
      
    GameFrame game= new GameFrame(); 
  }
    
    public static BufferedImage resizeImage(BufferedImage img, int newW, int newH) {  
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
    }  

   Box box = new Box();
   static Ting ting = new Ting(300,200);
   Clock clock = new Clock();
   
   static GameAreaPanel gamePanel;
  
  
  //Constructor - this runs first
  GameFrame() {
    
    super("My Game");  
    // Set the frame to full screen 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
   // this.setUndecorated(true);  //Set to true to remove title bar
   //frame.setResizable(false);

    //Set up the game panel (where we put our graphics)
    gamePanel = new GameAreaPanel();
    this.add(new GameAreaPanel());
    
    MyKeyListener keyListener = new MyKeyListener();
    this.addKeyListener(keyListener);

    MyMouseListener mouseListener = new MyMouseListener();
    this.addMouseListener(mouseListener);

    this.requestFocusInWindow(); //make sure the frame has focus   
    
    this.setVisible(true);
  
    //Start the game loop in a separate thread
    Thread t = new Thread(new Runnable() { public void run() { animate(); }}); //start the gameLoop 
    t.start();
   
  } //End of Constructor

  //the main gameloop - this is where the game state is updated
  public void animate() { 
    
    while(true){
      clock.update();
      box.update(clock.getElapsedTime());
      ting.move(clock.getElapsedTime());
       if (pressW)
       {
         System.out.println(ting.getSpeed());
         ting.accelerate(clock.getElapsedTime());
       }
       else if (ting.getSpeed() != 0)
       {
         ting.slowDown(clock.getElapsedTime());
       }
       
       ting.move(clock.getElapsedTime());
      
      this.repaint();
    }    
  }
  
  /** --------- INNER CLASSES ------------- **/
  
  // Inner class for the the game area - This is where all the drawing of the screen occurs
  private class GameAreaPanel extends JPanel {
    public void paintComponent(Graphics g) {   
       super.paintComponent(g); //required
       setDoubleBuffered(true); 
       box.paint(g);
       
       ting.draw(g, tingImage); 
    }
  }
  
  // -----------  Inner class for the keyboard listener - this detects key presses and runs the corresponding code
    private class MyKeyListener implements KeyListener {
      
      public void keyTyped(KeyEvent e) {  
      }

      public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
       
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  //If 'W' is pressed
          pressW = true;
        } 
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) { 
          pressA = true;
        }
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) { 
          pressS = true;
        }
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) { 
          pressD = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
          System.out.println("YIKES ESCAPE KEY!"); //close frame & quit
        } 
      }   
      
      public void keyReleased(KeyEvent e) {
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  //If 'W' is released
          pressW = false;
        }
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) { 
          pressA = false;
        }
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) { 
          pressS = false;
        }
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) { 
          pressD = false;
        }
      }
    } //end of keyboard listener
  
  // -----------  Inner class for the keyboard listener - This detects mouse movement & clicks and runs the corresponding methods 
    private class MyMouseListener implements MouseListener {
   
      public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
        System.out.println("X:"+e.getX() + " y:"+e.getY());
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }
    } //end of mouselistener
    
}