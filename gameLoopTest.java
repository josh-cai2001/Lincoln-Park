

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
  public static BufferedImage zomImage;
  public static BufferedImage bulletImage;
  
  public static boolean pressW = false;
  public static boolean pressA = false;
  public static boolean pressS = false;
  public static boolean pressD = false;
  public static boolean pressSpace = false;
  public static boolean bulletShootable = false;
  public static int bulletCoolDown = 0;
  
  public static void main(String[] args) {
    addZombies();
    try //Leading and resizing image
    {
      tingImage = ImageIO.read(new File("./Sprites/main_human.PNG"));
      zomImage = ImageIO.read(new File("./Sprites/zombie.PNG"));
      bulletImage = ImageIO.read(new File("./Sprites/bullet.PNG"));
      
    } catch (IOException e) {}
    tingImage = resizeImage(tingImage, (int)(player.returnW()), (int)(player.returnH()));
    
    zomImage = resizeImage(zomImage, (int)(zoms[0].returnW()), (int)(zoms[0].returnH()));
    
    bulletImage = resizeImage(bulletImage, (int)(bullet.returnW()), (int)(bullet.returnH()));
    
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
  
  static MapItem player = new Character(300,300,50,50,100,5,70,70,100, 0, 90, 0);
  static MapItem bullet = new Bullet (0,0,10,10,100,10,player.getRotation(),player.getAngularSpeed());
  static MapItem[] zoms = new Zombie[5];
  
  public static void addZombies(){
    for (int i = 0; i < 5; i++){
      if (i == 0){
        zoms[i] = new Zombie(100,100,50,50,100,0.25, 0, 0);
      }
      else if (i == 1){
        zoms[i] = new Zombie(200,100,50,50,100,0.25, 0, 0);
      }
      else if (i == 2){
        zoms[i] = new Zombie(100,200,50,50,100,0.25, 0, 0);
      }
      else if (i == 3){
        zoms[i] = new Zombie(400,400,50,50,100,0.25,0,0);
      }
      else if (i == 4){
        zoms[i] = new Zombie(500,500,50,50,100,0.25,0,0);
      }
    }
  }
  
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
      
      for(int i = 0; i <5; i++){
        if (zoms[i] != null){
          zoms[i].update(clock.getElapsedTime(), player);
          if (player.checkCollision(zoms[i])){
            player.changeSpeed(-1*player.getSpeed());
            zoms[i].changeSpeed(-1.5*zoms[i].getSpeed());
            player.loseHealth(20.0);
            System.out.println(player.returnHealth());
            
          }
          if (bullet != null && zoms[i].checkCollision(bullet)){
            zoms[i].loseHealth(player.returnWeapon().returnDamage());
            bulletShootable = true;
            bullet = null;
            
            if(zoms[i].returnHealth() <= 0){
              zoms[i] = null;
            }
          }
        }
      }
      if (player.returnHealth()<=0){
        player = null;
        this.repaint();
        break;
      }
      if (pressW && (player.getSpeed() < 1.5))
      {
        player.accelerate(clock.getElapsedTime());
      }
      else if (pressS && (player.getSpeed() > -1.5))
      {
        player.decelerate(clock.getElapsedTime());
      }
      else if (player.getSpeed() != 0)
      {
        player.slowDown(clock.getElapsedTime());
      }
      
      if (pressD && (player.getAngularSpeed() < 1.5))
      {
        player.accelerateRight(clock.getElapsedTime());
      }
      else if (pressA && (player.getAngularSpeed() > -1.5))
      {
        player.accelerateLeft(clock.getElapsedTime());
      }
      else if (player.getAngularSpeed() != 0)
      {
        player.slowDownAngularSpeed(clock.getElapsedTime());
      }
      
      
      if(pressSpace){
        if ((player.returnWeapon()).getAmmo() > 0 && bulletShootable == true && bulletCoolDown <= 0){
          
          player.attack();
          
          bullet = new Bullet (player.returnX(),player.returnY(),10,10,100,10,player.getRotation(),player.getAngularSpeed());
          
          bulletShootable = false;
          
          if(player.returnWeapon() instanceof Shotgun){
            bulletCoolDown = 500000;
          }
          else if (player.returnWeapon() instanceof Pistol){
            bulletCoolDown = 350000;
          }
          else if (player.returnWeapon() instanceof AssaultRifle){
            bulletCoolDown = 50000;
          }
        }
        
      }
      
      if (bulletShootable == false && bullet != null){
        bullet.update(clock.getElapsedTime());
        
        
        if (bullet != null && (bullet.returnX() <= 0 || bullet.returnX() >= java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width)){
          bulletShootable = true;
          bullet = null;
        }
        if (bullet != null && (bullet.returnY() <= 0 || bullet.returnY() >= java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height)){
          bulletShootable = true;
          bullet = null;
        }
      }
      
      
      bulletCoolDown-=clock.getElapsedTime()/100;
      
      
      player.move(clock.getElapsedTime());
      
      this.repaint();
    }    
    
  }
  
  /** --------- INNER CLASSES ------------- **/
  
  // Inner class for the the game area - This is where all the drawing of the screen occurs
  private class GameAreaPanel extends JPanel {
    public void paintComponent(Graphics g) {   
      super.paintComponent(g); //required
      setDoubleBuffered(true); 
      
      
      if (player != null){
        player.draw(g, tingImage); 
      }
      for(int i = 0; i <5; i++){
        if (zoms[i] != null){
          zoms[i].draw(g, zomImage);
        }
      }
      if (bullet != null){
        bullet.draw(g, bulletImage);
      }
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
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {  //If ESC is pressed
        pressSpace = true;
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
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {  //If ESC is pressed
        pressSpace = false;
      } 
    }
  } //end of keyboard listener
  
  // -----------  Inner class for the keyboard listener - This detects mouse movement & clicks and runs the corresponding methods 
  private class MyMouseListener implements MouseListener {
    
    public void mouseClicked(MouseEvent e) {
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