import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MovingCar extends Moving{
  
  private double fatigue, hunger, thirst, fuel;
  
  MovingCar(double x, double y, double w, double h, double health, double fatigue, double hunger, double thirst, double fuel){
    super(x, y, w, h, health);
    this.fatigue = fatigue;
    this.hunger = hunger;
    this.thirst = thirst;
    this.fuel = fuel;
  }
  
  public void moveLeft(){
    changeSpeed((100-(this.fatigue))/100 * 4);
    changeX(returnX() - returnSpeed() );
  }
  public void moveRight(){
    changeSpeed((100-(this.fatigue))/100 * 4);
    changeX(returnX() + returnSpeed());
  }
  public void moveDown(){
    changeSpeed((100-(this.fatigue))/100 * 4);
    changeY(returnY() + returnSpeed() );
  }
  public void moveUp(){
    changeSpeed((100-(this.fatigue))/100 * 4);
    changeY(returnY() - returnSpeed() );
  }
  public boolean checkLeftCollision(MapItem m){
    if ((returnX() >= (m.returnX() + (m.returnW() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean checkRightCollision(MapItem m){
    if ((m.returnX() >= (returnX() + (m.returnW() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean checkUpCollision(MapItem m){
    if ((returnY() >= (m.returnY() + (m.returnH() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean checkDownCollision(MapItem m){
    if ((m.returnY() >= (returnY() + (m.returnH() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
      return true;
    }
    else{
      return false;
    }
  }
  public void draw(Graphics g) { 
    g.setColor(Color.BLACK); 
    g.fillRect((int)(returnX()), (int)(returnY()), 25, 25);        
  }
  
}