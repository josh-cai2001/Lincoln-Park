/**
 * this template can be used for a start menu for your final project
 **/

// Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

class StartingFrameTwo extends JFrame {

 JFrame thisFrame;

 // Constructor - this runs first
 StartingFrameTwo() {
  super("Start Screen");
  this.thisFrame = this; // lol

  // configure the window
  this.setSize(1000, 698);
  this.setLocationRelativeTo(null); // start the frame in the center of
  // the screen
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setResizable(false);

  // Display the frame without border and invisible
  this.setUndecorated(true);
  setBackground(new Color(0, 0, 0, 0));

  // Create a Panel for stuff
  JPanel decPanel = new JPanel();
  decPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

  // add the main panel to the frame
  getContentPane().add(decPanel);

  JLabel background = new JLabel("");
  background.setBackground(new Color(0, 0, 0, 0));
  background.setIcon(new ImageIcon("display.png"));
  decPanel.add(background);

  JPanel mainPanel = new JPanel();
  mainPanel.setBackground(new Color(0, 0, 0, 0));

  // Create a JButton for the centerPanel
  ImageIcon startB = new ImageIcon("startbutton.png");
  ImageIcon instructionB = new ImageIcon("InstructionButton.png");
  ImageIcon objectiveB = new ImageIcon("objectiveButton.png");
  SpringLayout sl_decPanel = new SpringLayout();
  sl_decPanel.putConstraint(SpringLayout.NORTH, background, 0, SpringLayout.NORTH, decPanel);
  sl_decPanel.putConstraint(SpringLayout.WEST, background, 0, SpringLayout.WEST, decPanel);
  sl_decPanel.putConstraint(SpringLayout.SOUTH, background, 0, SpringLayout.SOUTH, decPanel);
  sl_decPanel.putConstraint(SpringLayout.EAST, background, 0, SpringLayout.EAST, decPanel);

  sl_decPanel.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, decPanel);
  sl_decPanel.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, decPanel);
  sl_decPanel.putConstraint(SpringLayout.SOUTH, mainPanel, 0, SpringLayout.SOUTH, decPanel);
  sl_decPanel.putConstraint(SpringLayout.EAST, mainPanel, 0, SpringLayout.EAST, decPanel);

  decPanel.setLayout(sl_decPanel);

  decPanel.add(mainPanel);
  mainPanel.setLayout(new BorderLayout(0, 0));

  JPanel bottomPanel = new JPanel();
  bottomPanel.setBackground(new Color(0, 0, 0, 0));

  SpringLayout springLayout = new SpringLayout();
  bottomPanel.setLayout(springLayout);
  mainPanel.add(bottomPanel, BorderLayout.CENTER);

  // button number 1
  JButton startButton = new JButton(startB);
  startButton.setBackground(new Color(0, 0, 0, 0));
  startButton.setRolloverIcon(new ImageIcon("startbuttonpressed.png"));
  startButton.setBorder(BorderFactory.createEmptyBorder());
  startButton.setFocusPainted(false);
  startButton.addActionListener(new StartButtonListener());

  springLayout.putConstraint(SpringLayout.NORTH, startButton, 450, SpringLayout.NORTH, bottomPanel);
  springLayout.putConstraint(SpringLayout.WEST, startButton, 35, SpringLayout.WEST, bottomPanel);
  bottomPanel.add(startButton);

  // button number 2
  JButton instructionButton = new JButton(instructionB);
  instructionButton.setBackground(new Color(0, 0, 0, 0));
  instructionButton.setRolloverIcon(new ImageIcon("instructionButtonPressed.png"));
  instructionButton.setBorder(BorderFactory.createEmptyBorder());
  instructionButton.setFocusPainted(false);
  instructionButton.addActionListener(new InstructionButtonListener());

  springLayout.putConstraint(SpringLayout.NORTH, instructionButton, 55, SpringLayout.NORTH, startButton);
  springLayout.putConstraint(SpringLayout.WEST, instructionButton, 00, SpringLayout.WEST, startButton);
  bottomPanel.add(instructionButton);

  // button number 3
  JButton objectiveButton = new JButton(objectiveB);
  objectiveButton.setBackground(new Color(0, 0, 0, 0));
  objectiveButton.setRolloverIcon(new ImageIcon("objectiveButtonPressed.png"));
  objectiveButton.setBorder(BorderFactory.createEmptyBorder());
  objectiveButton.setFocusPainted(false);
  objectiveButton.addActionListener(new ObjectiveButtonListener());

  springLayout.putConstraint(SpringLayout.NORTH, objectiveButton, 55, SpringLayout.NORTH, instructionButton);
  springLayout.putConstraint(SpringLayout.WEST, objectiveButton, -120, SpringLayout.EAST, startButton);
  bottomPanel.add(objectiveButton);
  // Start the app
  this.setVisible(true);
 }

 class StartButtonListener implements ActionListener { // this is the
  // required class
  // definition
  public void actionPerformed(ActionEvent event) {
   System.out.println("Starting new Game");
   thisFrame.dispose();
   new GameFrameTwo(); // create a new FunkyFrame (another file that
   // extends JFrame)

  }

 }

 class InstructionButtonListener implements ActionListener {

  public void actionPerformed(ActionEvent event) {
   System.out.println("Instruction");
   thisFrame.dispose();
   try {
    new InstructionFrameTwo();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }

  }
 }

 class ObjectiveButtonListener implements ActionListener {

  public void actionPerformed(ActionEvent event) {
   System.out.println("Objective");
   thisFrame.dispose();
   try {
    new ObjectiveFrameTwo();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }

  }
 }

 // Main method starts this application
 public static void main(String[] args) {
  new StartingFrameTwo();
 }
}