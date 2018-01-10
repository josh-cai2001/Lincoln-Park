import java.awt.Graphics;
import java.awt.Color;

class Box {
  
  private double x;
  private double y;
  private double speed;
  
  Box() {
    this.x = 0;
    this.y = 50;
    this.speed = 1;
  }
  
  public void randomize() {
    this.x = Math.random()*1024;
    this.y = Math.random()*768;
  }
  
   public void update(double elapsedTime){
   this.x= this.x + this.speed*elapsedTime*100;
}
  
  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
       g.fillRect((int)this.x, (int)this.y, 50, 50); 
  }
  
  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }
  
  public void setX(double input) {
    this.x = input;
  }
  
  public void setY(double input) {
    this.y = input;
  }
  
}