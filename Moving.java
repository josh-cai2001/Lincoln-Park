abstract class Moving extends MapItem implements Movable{
  
  private int health;
  
  Moving(int x, int y, int health){
    super(x, y);
    this.health = health;
  }
  
  abstract public void moveLeft();
  abstract public void moveRight();
  abstract public void moveDown();
  abstract public void moveUp();
  abstract public boolean checkCollision(MapItem m);
  
  public void loseHealth(int damage){
    this.health = this.health - damage;
  }
  public int returnHealth(){
    return this.health;
  }
  
  
}