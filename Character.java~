import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Character extends Moving{
  
//  private T weapon;
  private double fatigue, hunger, thirst;
  
  Character(double x, double y, double health, double fatigue, double hunger, double thirst){
    super(x, y, health);
//    weapon = (T)new Object();
    this.fatigue = fatigue;
    this.hunger = hunger;
    this.thirst = thirst;
  }
  
//  public T returnWeapon(){
//    return this.weapon;
//  }
  public void moveLeft(){
    changeSpeed((100-(this.fatigue))/100 * 2);
    changeX(returnX() - returnSpeed() );
  }
  public void moveRight(){
    changeSpeed((100-(this.fatigue))/100 * 2);
    changeX(returnX() + returnSpeed());
  }
  public void moveDown(){
    changeSpeed((100-(this.fatigue))/100 * 2);
    changeY(returnY() + returnSpeed() );
  }
  public void moveUp(){
    changeSpeed((100-(this.fatigue))/100 * 2);
    changeY(returnY() - returnSpeed() );
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
  public void rest(int recover){
    this.fatigue -= recover;
  }
  public void eat(int food){
    this.hunger += food;
  }
  public void drink(int water){
    this.thirst += water;
  }
  
  public double returnFatigue(){
    return this.fatigue;
  }
  
}