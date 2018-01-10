abstract class Moving extends MapItem implements Movable{
  
  private double health, speed;
  
  Moving(double x, double y, double w, double h, double health){
    super(x, y, w, h);
    this.health = health;
    this.speed = 0.05;
  }
  
  abstract public void moveLeft();
  abstract public void moveRight();
  abstract public void moveDown();
  abstract public void moveUp();
  
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
  
}