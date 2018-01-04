public class Character<T> extends Moving{
  
  private T weapon;
  private int fatigue, hunger, thirst;
  
  Character(int x, int y, int health, int fatigue, int hunger, int thirst){
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
    
  }
  public void moveRight(double elapsedTime){
    
  }
  public void moveDown(double elapsedTime){
    
  }
  public void moveUp(double elapsedTime){
    
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