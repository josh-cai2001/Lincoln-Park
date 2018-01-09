import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Zombie extends Moving{

  Zombie(double x, double y, double health){
    super(x, y, health);
  }
  
  public void moveLeft(){
    changeX(returnX() - returnSpeed() );
  }
  public void moveRight(){
    changeX(returnX() + returnSpeed());
  }
  public void moveDown(){
    changeY(returnY() + returnSpeed() );
  }
  public void moveUp(){
    changeY(returnY() - returnSpeed() );
  }
  public void draw(Graphics g) { 
    g.setColor(Color.GREEN); 
    g.fillRect((int)(returnX()), (int)(returnY()), 25, 25);        
  }
  public void move(double x, double y){
    if(x > returnX()){
      moveRight();
    }
    else{
      moveLeft();
    }
    if(y > returnY()){
      moveDown();
    }
    else{
      moveUp();
    }
  }
}