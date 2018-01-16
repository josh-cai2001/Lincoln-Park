import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
abstract class Moving extends MapItem{
  
  private double health,rotation,speed,angularSpeed,energy;
  
  Moving(double x, double y, double w, double h, double health, double energy, double speed){
    super(x, y, w, h);
    this.health = health;
    this.rotation = 117;
    this.speed = speed;
    this.angularSpeed = 0;
    this.energy = energy;
  }
  
  public void move(double elapsedTime) {
    changeX(returnX() + speed*Math.sin(Math.toRadians(this.rotation))*elapsedTime*100);
    changeY(returnY() - speed*Math.cos(Math.toRadians(this.rotation))*elapsedTime*100);
    this.rotation += this.angularSpeed*elapsedTime*100;
  }
  
  public void accelerateRight(double elapsedTime) {
    this.angularSpeed += elapsedTime*this.energy*2;
  }
  
  public void accelerateLeft(double elapsedTime) {
    this.angularSpeed -= elapsedTime*this.energy*2;
  }
  
  public void slowDownAngularSpeed(double elapsedTime) {
    if (angularSpeed >= 0)
    {
      this.angularSpeed -= elapsedTime*this.energy*1.75;
    }
    else
    {
      this.angularSpeed += elapsedTime*this.energy*1.75;
    }
  }
  
  public void accelerate(double elapsedTime) {
    this.speed += elapsedTime*this.energy;
  }
  
  public void decelerate(double elapsedTime) {
    this.speed -= elapsedTime*this.energy;
  }
  
  public void slowDown(double elapsedTime) {
    if (speed >= 0)
    {
      this.speed -= elapsedTime*this.energy*0.75;
    }
    else
    {
      this.speed += elapsedTime*this.energy*0.75;
    }
  }
  
  public void draw (Graphics g, BufferedImage image) {
    
    double locationX = image.getWidth() / 2;
    double locationY = image.getHeight() / 2;
    
    double diff = Math.pow(Math.pow(image.getWidth(), 2) + Math.pow(image.getHeight(), 2), 0.5) /2;
    
//To correct the set of origin point and the overflow
    double rotationRequired = Math.toRadians(this.rotation);
    double unitX = Math.abs(Math.cos(rotationRequired));
    double unitY = Math.abs(Math.sin(rotationRequired));
    
    double correctUx, correctUy;
    
    if (image.getWidth() >= image.getHeight())
    {
      correctUx = unitX;
      correctUy = unitY;
    }
    else //if the height is greater than the width, you have to change the axis to correct the overflow
    {
      correctUx = unitY;
      correctUy = unitX;
    }
    
    int posAffineTransformOpX = (int)returnX()-(int)(locationX)-(int)(correctUx*diff);
    int posAffineTransformOpY = (int)returnY()-(int)(locationY)-(int)(correctUy*diff);
    
//translate the image center to same diff that dislocates the origin, to correct its point set
    AffineTransform objTrans = new AffineTransform();
    objTrans.translate(correctUx*diff, correctUy*diff);
    objTrans.rotate(rotationRequired, locationX, locationY);
    
    AffineTransformOp op = new AffineTransformOp(objTrans, AffineTransformOp.TYPE_BILINEAR);
    
// Drawing the rotated image at the required drawing locations
    g.drawImage(op.filter(image, null), posAffineTransformOpX, posAffineTransformOpY, null);
  }
  
  
  public double getSpeed() {
    return this.speed;
  }
  
  public double getAngularSpeed() {
    return this.angularSpeed;
  }
  
  public double getEnergy() {
    return this.energy;
  }
  
  public void setEnergy(double input) {
    this.energy = input;
  }
  
  public void loseHealth(int damage){
    this.health = this.health - damage;
  }
  public double returnHealth(){
    return this.health;
  }
  public void changeSpeed(double change){
    this.speed = change;
  }
  public double returnSpeed(){
    return this.speed;
  }
  public double getRotation(){
    return this.rotation;
  }
  public void changeRotation(double change){
    this.rotation = change;
  }
  
}