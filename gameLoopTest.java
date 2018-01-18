

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
  
  public static BufferedImage humanPistolImage;
  public static BufferedImage humanAssaultRifleImage;
  public static BufferedImage humanShotgunImage;
  public static BufferedImage shotgunImage;
  public static BufferedImage pistolImage;
  public static BufferedImage assaultRifleImage;
  public static BufferedImage zomImage;
  public static BufferedImage bulletImage;
  public static BufferedImage foodImage;
  public static BufferedImage waterImage;
  public static BufferedImage medkitImage;
  public static BufferedImage fuelImage;
  public static BufferedImage building1Image;
  public static BufferedImage building2Image;
  public static BufferedImage building3Image;
  public static BufferedImage building4Image;
  
  public static boolean pressW = false;
  public static boolean pressA = false;
  public static boolean pressS = false;
  public static boolean pressD = false;
  public static boolean pressE = false;
  public static boolean pressSpace = false;
  public static boolean bulletShootable = false;
  public static int bulletCoolDown = 0;
  public static double statsCoolDown = 0;
  
  public static MapItem player = new Character(300,300,50,65,100,5,70,70,100, 0, 90, 0);
  public static MapItem bullet = new Bullet (0,0,10,10,100,10,player.getRotation(),player.getAngularSpeed());
  public static MapItem[] weapons = {new Pistol(600,600,20,10, 100), new Shotgun(600,700,70,20, 20), new AssaultRifle(700,600,50,20, 360)};
  public static MapItem tempWeapon = new Pistol(1,1,1,1, 1);
  public static MapItem[] supplies = {new MedKit(1000, 600, 30, 30), new Water(1100, 600, 30, 30), new Fuel(1200, 600, 30, 30), new Food(1300, 600, 30, 30),};
  public static MapItem[] zoms = {new Zombie(100,100,50,50,100,0.25, 0, 0), new Zombie(200,100,50,50,100,0.25, 0, 0), new Zombie(100,200,50,50,100,0.25, 0, 0), new Zombie(400,400,50,50,100,0.25,0,0), new Zombie(500,500,50,50,100,0.25,0,0)};
  public static MapItem[] structures ={new Building1(100, 500, 200, 400)};
  
  public static void main(String[] args) {
    try //Leading and resizing image
    {
      humanPistolImage = ImageIO.read(new File("./Sprites/pistol_human.PNG"));
      humanAssaultRifleImage = ImageIO.read(new File("./Sprites/assault_rifle_human.PNG"));
      humanShotgunImage = ImageIO.read(new File("./Sprites/shotgun_human.PNG"));
      pistolImage = ImageIO.read(new File("./Sprites/pistol.PNG"));
      shotgunImage = ImageIO.read(new File("./Sprites/shotgun.PNG"));
      assaultRifleImage = ImageIO.read(new File("./Sprites/assault_Rifle.PNG"));
      zomImage = ImageIO.read(new File("./Sprites/zombie.PNG"));
      bulletImage = ImageIO.read(new File("./Sprites/bullet.PNG"));
      foodImage = ImageIO.read(new File("./Sprites/food.PNG"));
      waterImage = ImageIO.read(new File("./Sprites/water.PNG"));
      fuelImage = ImageIO.read(new File("./Sprites/fuel.PNG"));
      medkitImage = ImageIO.read(new File("./Sprites/medkit.PNG"));
      building1Image = ImageIO.read(new File("./Sprites/building1.PNG"));
      building2Image = ImageIO.read(new File("./Sprites/building2.PNG"));
      building3Image = ImageIO.read(new File("./Sprites/building3.PNG"));
      building4Image = ImageIO.read(new File("./Sprites/building4.PNG"));
      
    } catch (IOException e) {}
    humanPistolImage = resizeImage(humanPistolImage, (int)(player.returnW()), (int)(player.returnH()));
    humanAssaultRifleImage = resizeImage(humanAssaultRifleImage, (int)(player.returnW()), (int)(player.returnH()));
    humanShotgunImage = resizeImage(humanShotgunImage, (int)(player.returnW()), (int)(player.returnH()));
    shotgunImage = resizeImage(shotgunImage, (int)(weapons[1].returnW()), (int)(weapons[1].returnH()));
    pistolImage = resizeImage(pistolImage, (int)(weapons[0].returnW()), (int)(weapons[0].returnH()));
    assaultRifleImage = resizeImage(assaultRifleImage, (int)(weapons[2].returnW()), (int)(weapons[2].returnH()));
    zomImage = resizeImage(zomImage, (int)(zoms[0].returnW()), (int)(zoms[0].returnH()));
    foodImage = resizeImage(foodImage, 30, 30);
    waterImage = resizeImage(waterImage, 30, 30);
    fuelImage = resizeImage(fuelImage, 30, 30);
    medkitImage = resizeImage(medkitImage, 30, 30);
    bulletImage = resizeImage(bulletImage, (int)(bullet.returnW()), (int)(bullet.returnH()));
    building1Image = resizeImage(building1Image, 200, 400);
    building2Image = resizeImage(building2Image, 50, 50);
    building3Image = resizeImage(building3Image, 50, 50);
    building4Image = resizeImage(building4Image, 50, 50);
    
    
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
      for(int i = 0; i <4; i++){
        if(supplies[i] != null){
          if (player.checkCollision(supplies[i])){
            if (supplies[i] instanceof Water){
              player.drink(supplies[i].returnValue());
              supplies[i] = null;
            }
            else if (supplies[i] instanceof Food){
              player.eat(supplies[i].returnValue());
              supplies[i] = null;
            }
            else if (supplies[i] instanceof Fuel){
              player.addFuel(supplies[i].returnValue());
              supplies[i] = null;
            }
            else if (supplies[i] instanceof MedKit){
              player.addHealth(supplies[i].returnValue());
              supplies[i] = null;
            }
          }
        }
      }
      for(int i = 0; i <3; i++){
        if (weapons[i] != null){
          if(player.checkCollision(weapons[i]) && pressE == true){
            if (weapons[i] instanceof Pistol && player.returnWeapon() instanceof Pistol){
              player.returnWeapon().addAmmo(weapons[i].getAmmo());
              weapons[i] = null;
            }
            else if (weapons[i] instanceof Shotgun && player.returnWeapon() instanceof Shotgun){
              player.returnWeapon().addAmmo(weapons[i].getAmmo());
              weapons[i] = null;
            }
            else if (weapons[i] instanceof AssaultRifle && player.returnWeapon() instanceof AssaultRifle){
              player.returnWeapon().addAmmo(weapons[i].getAmmo());
              weapons[i] = null;
            }
            else{
              if (player.returnWeapon() instanceof Pistol){
                tempWeapon = new Pistol(player.returnX(), player.returnY(), 20, 10, player.returnWeapon().getAmmo());
              }
              else if (player.returnWeapon() instanceof AssaultRifle){
                tempWeapon = new AssaultRifle(player.returnX(), player.returnY(), 50, 20, player.returnWeapon().getAmmo());
              }
              else if (player.returnWeapon() instanceof Shotgun){
                tempWeapon = new Shotgun(player.returnX(), player.returnY(), 50, 20, player.returnWeapon().getAmmo());
              }
              player.changeWeapon((Weapon)weapons[i]);
              weapons[i] = tempWeapon;
            }
          }
        }

      }
      
      if (player.returnHealth()<=0){
        player = null;
        this.repaint();
        break;
      }
      
      if(player.returnX() <= 0 || player.returnX() >= java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width){
        player.changeSpeed(-1*player.getSpeed());
      }
      if(player.returnY() <= 0 || player.returnY() >= java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height){
        player.changeSpeed(-1*player.getSpeed());
      }
      
      if (pressW && (player.getSpeed() < 1.5) && player.returnFatigue() < 100)
      {
        player.accelerate(clock.getElapsedTime());
      }
      else if (pressS && (player.getSpeed() > -1.5) && player.returnFatigue() < 100)
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
            bulletCoolDown = 75000;
          }
          else if (player.returnWeapon() instanceof Pistol){
            bulletCoolDown = 50000;
          }
          else if (player.returnWeapon() instanceof AssaultRifle){
            bulletCoolDown = 25000;
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
      
      if(statsCoolDown >= 5){
        statsCoolDown = 0;
        player.loseHunger();
        player.loseThirst();
        player.addFatigue();
        if(player.returnWater() <= 0){
          player.loseHealth(5);
        }
        if(player.returnFood() <= 0){
          player.loseHealth(5);
        }
      }
      
      statsCoolDown += clock.getElapsedTime();
      
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
      
      if (bullet != null){
        bullet.draw(g, bulletImage);
      }
      for(int i = 0; i <3; i++){
        if(weapons[i] instanceof Pistol){
          weapons[i].draw(g, pistolImage);
        }
        else if(weapons[i] instanceof AssaultRifle){
          weapons[i].draw(g, assaultRifleImage);
        }
        else if(weapons[i] instanceof Shotgun){
          weapons[i].draw(g, shotgunImage);
        }
      }
      for(int i = 0; i <4; i++){
        if(supplies[i] instanceof Food){
          supplies[i].draw(g, foodImage);
        }
        else if(supplies[i] instanceof Water){
          supplies[i].draw(g, waterImage);
        }
        else if(supplies[i] instanceof Fuel){
          supplies[i].draw(g, fuelImage);
        }
        else if(supplies[i] instanceof MedKit){
          supplies[i].draw(g, medkitImage);
        }
      }
      for(int i = 0; i <5; i++){
        if (zoms[i] != null){
          zoms[i].draw(g, zomImage);
        }
      }
      if (player != null){
        if(player.returnWeapon() instanceof Pistol){
          player.draw(g, humanPistolImage); 
        }
        else if(player.returnWeapon() instanceof AssaultRifle){
          player.draw(g, humanAssaultRifleImage);
        }
        else if(player.returnWeapon() instanceof Shotgun){
          player.draw(g, humanShotgunImage);
        }
        
      }
      structures[0].draw(g, building1Image);
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
      if (KeyEvent.getKeyText(e.getKeyCode()).equals("E")) { 
        pressE = true;
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
      if (KeyEvent.getKeyText(e.getKeyCode()).equals("E")) { 
        pressE = false;
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