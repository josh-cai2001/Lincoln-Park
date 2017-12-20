abstract class Moving extends MapItem implements Movable{
  
  private int health;
  
  Moving(int x, int y, int health){
    super(x, y);
    this.health = health;
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
  
  
}