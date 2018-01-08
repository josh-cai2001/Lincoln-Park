import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Character extends Moving{
  
//  private T weapon;
  private int fatigue, hunger, thirst;
  
  Character(double x, double y, int health, int fatigue, int hunger, int thirst){
    super(x, y, health);
//    weapon = (T)new Object();
    this.fatigue = fatigue;
    this.hunger = hunger;
    this.thirst = thirst;
  }
  
//  public T returnWeapon(){
//    return this.weapon;
//  }
  public void moveLeft(double elapsedTime){
//    changeSpeed(-20);
//    changeX(returnX() + returnSpeed()*elapsedTime*100);
    changeX(returnX() - ((100-elapsedTime)/100 * 2) );
  }
  public void moveRight(double elapsedTime){
//    changeSpeed(20);
  //  changeX(returnX() + returnSpeed()*elapsedTime*100);
    changeX(returnX() + ((100-elapsedTime)/100 * 2) );
  }
  public void moveDown(double elapsedTime){
    //changeSpeed(20);
  //  changeY(returnY() + returnSpeed()*elapsedTime*100);
    changeY(returnY() + ((100-elapsedTime)/100 * 2) );
  }
  public void moveUp(double elapsedTime){
    //changeSpeed(-20);
  //  changeY(returnY() + returnSpeed()*elapsedTime*100);
    changeY(returnY() - ((100-elapsedTime)/100 * 2) );
  }
//  public boolean checkCollision(MapItem m){
//    if (boundingBox.intersects(m.boundingBox)){
//      return true;
//    }
//    else{
//      return false;
//    }
//  }
  public void draw(Graphics g) { 
    g.setColor(Color.BLUE); 
    g.fillRect((int)(returnX()), (int)(returnY()), 25, 25);        
  }
  public void update(double elapsedTime){
    
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
  
  public int returnFatigue(){
    return this.fatigue;
  }
  
}