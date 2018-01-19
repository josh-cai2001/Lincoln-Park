/**
* This template can be used as reference or a starting point
* for your final summative project
* @author Mangat
**/

//Graphics &GUI imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ObjectiveFrameTwo extends JFrame {

 // class variable (non-static)
 static double x, y;
 static ObjectiveAreaPanel objectivePanel;
 private final BufferedImage objectiveFrame;

 // Constructor - this runs first
 ObjectiveFrameTwo() throws IOException {
  super("Objective");
  objectiveFrame = ImageIO.read(new File("Objective.png"));
  // Set the frame to full screen
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // his.setLocationRelativeTo(null); // start the frame in the center of
  // the screen
  this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
  this.setUndecorated(true); // Set to true to remove title bar
  this.setBackground(new Color(0, 65, 200, 150));

  // Set up the game panel (where we put our graphics)
  objectivePanel = new ObjectiveAreaPanel();
  objectivePanel.setBackground(new Color(0, 65, 200, 150));

  this.add(new ObjectiveAreaPanel());

  this.requestFocusInWindow(); // make sure the frame has focus

  this.setVisible(true);

  // Start the game loop in a separate thread

 } // End of Constructor

 // the main gameloop - this is where the game state is updated
 /** --------- INNER CLASSES ------------- **/

 // Inner class for the the game area - This is where all the drawing of the
 // screen occurs
 private class ObjectiveAreaPanel extends JPanel {
  public void paintComponent(Graphics g) {
   super.paintComponent(g); // removed to keep transparent panel
   g.drawImage(objectiveFrame, 0, 0, this);

  }
 }
}