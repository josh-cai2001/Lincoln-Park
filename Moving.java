abstract class Moving extends MapItem implements Movable{
  
  private int health;
  private double speed;
  
  Moving(double x, double y, int health){
    super(x, y);
    this.health = health;
    this.speed = 1;
  }
  
  abstract public void moveLeft(double elapsedTime);
  abstract public void moveRight(double elapsedTime);
  abstract public void moveDown(double elapsedTime);
  abstract public void moveUp(double elapsedTime);
  abstract public boolean checkCollision(MapItem m);
  
  public void loseHealth(int damage){
    this.health = this.health - damage;
  }
  public int returnHealth(){
    return this.health;
  }
  public void changeSpeed(double change){
    this.speed = change;
  }
  public double returnSpeed(){
    return this.speed;
  }
  
}