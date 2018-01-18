/**
* This template can be used as reference or a starting point
* for your final summative project
* @author Mangat
**/

//Graphics &GUI imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class InstructionFrameTwo extends JFrame {

 // class variable (non-static)
 static double x, y;
 static InstructionAreaPanel InstructionPanel;
 private final BufferedImage instructionImage;

 // Constructor - this runs first
 InstructionFrameTwo() throws IOException {
  super("Instruction");
  instructionImage = ImageIO.read(new File("display.png"));// <-
                   // IMOPORTANT
                   // TO
                   // CHANGE
  // Set the frame to full screen
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //his.setLocationRelativeTo(null); // start the frame in the center of
           // the screen
  this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
  this.setUndecorated(true); // Set to true to remove title bar
  this.setBackground(new Color(0, 65, 200, 150));

  // Set up the game panel (where we put our graphics)
  InstructionPanel = new InstructionAreaPanel();
  InstructionPanel.setBackground(new Color(0, 65, 200, 150));

  this.add(new InstructionAreaPanel());

  this.requestFocusInWindow(); // make sure the frame has focus

  this.setVisible(true);

  // Start the game loop in a separate thread
  Thread t = new Thread(new Runnable() {
   public void run() {
    animate();
   }
  }); // start the gameLoop
  t.start();

 } // End of Constructor

 // the main gameloop - this is where the game state is updated
 public void animate() {

  while (true) {
   try {
    Thread.sleep(500);
   } catch (Exception exc) {
   } // delay
   this.repaint();
  }
 }

 /** --------- INNER CLASSES ------------- **/

 // Inner class for the the game area - This is where all the drawing of the
 // screen occurs
 private class InstructionAreaPanel extends JPanel {
  public void paintComponent(Graphics g) {
   super.paintComponent(g); // removed to keep transparent panel
   g.drawImage(instructionImage, 0, 0, this);
   // end of mouselistener

  }
 }
}
