public class Character<T> extends Moving{
  
  private T weapon;
  private int fatigue, hunger, thirst;
  
  Character(double x, double y, int health, int fatigue, int hunger, int thirst){
    super(x, y, health);
    weapon = (T)new Object();
    this.fatigue = fatigue;
    this.hunger = hunger;
    this.thirst = thirst;
  }
  
  public T returnWeapon(){
    return this.weapon;
  }
  public void moveLeft(double elapsedTime){
    changeSpeed(-2);
    changeX(returnX() + returnSpeed()*elapsedTime*100);
  }
  public void moveRight(double elapsedTime){
    changeSpeed(2);
    changeX(returnX() + returnSpeed()*elapsedTime*100);
  }
  public void moveDown(double elapsedTime){
    changeSpeed(2);
    changeY(returnY() + returnSpeed()*elapsedTime*100);
  }
  public void moveUp(double elapsedTime){
    changeSpeed(-2);
    changeY(returnY() + returnSpeed()*elapsedTime*100);
  }
  public boolean checkCollision(MapItem m){
    if (boundingBox.intersects(m.boundingBox)){
      return true;
    }
    else{
      return false;
    }
  }
  public void rest(int recover){
    this.fatigue -= recover;
  }
  public void eat(int food){
    this.hunger += food;
  }
  public void drink(int water){
    this.thirst += water;
  }
  
}