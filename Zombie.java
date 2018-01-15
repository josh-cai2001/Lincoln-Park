import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Zombie extends Moving{

  Zombie(double x, double y, double w, double h, double health){
    super(x, y, w, h, health, 0.75);
  }
  
  public void changeRotation(MapItem m){
    
  }
  
//  public void moveLeft(){
//    changeX(returnX() - returnSpeed() );
//  }
//  public void moveRight(){
//    changeX(returnX() + returnSpeed());
//  }
//  public void moveDown(){
//    changeY(returnY() + returnSpeed() );
//  }
//  public void moveUp(){
//    changeY(returnY() - returnSpeed() );
//  }
//  public void draw(Graphics g) { 
//    g.setColor(Color.GREEN); 
//    g.fillRect((int)(returnX()), (int)(returnY()), 25, 25);        
//  }
//  public boolean checkCollision(MapItem m){
//    if (boundingBox.intersects(m.boundingBox)){
//      return true;
//    }
//    else{
//      return false;
//    }
//  }
//  public void move(double x, double y, MapItem m){
//    if((!checkCollision(m))&&(x > returnX())){
//      moveRight();
//    }
//    else if(!checkCollision(m)){
//      moveLeft();
//    }
//    if((!checkCollision(m))&& (y > returnY())){
//      moveDown();
//    }
//    else if(!checkCollision(m)){
//      moveUp();
//    }
//  }
}