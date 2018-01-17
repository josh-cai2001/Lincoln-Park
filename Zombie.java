import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.*;

public class Zombie extends Moving{

  Zombie(double x, double y, double w, double h, double health, double speed){
    super(x, y, w, h, health, 0.75, speed);
  }
  
  public void faceCharacter(MapItem m){
    if ((m.returnX() > returnX()) && (m.returnY() > returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnX() -  returnX())/Math.abs(m.returnY() - returnY()))); 
      changeRotation(180-tempAngle);
    }
    else if ((m.returnX() > returnX()) && (m.returnY() < returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(90-tempAngle);
    }
    else if ((m.returnX() < returnX()) && (m.returnY() < returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(270+tempAngle);
    }
    else if ((m.returnX() < returnX()) && (m.returnY() > returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(270-tempAngle);
    }
  }
  
  public void move(double elapsedTime){
    if(getSpeed() <= 0.25){
      accelerate(elapsedTime);
    }
    changeX(returnX() + getSpeed()*Math.sin(Math.toRadians(getRotation()))*elapsedTime*100);
    changeY(returnY() - getSpeed()*Math.cos(Math.toRadians(getRotation()))*elapsedTime*100);
  }
  
  public void update(double elapsedTime, MapItem m){
    faceCharacter(m);
    move(elapsedTime);
  }
  
  public void draw (Graphics g, BufferedImage image) {
    
    double locationX = image.getWidth() / 2;
    double locationY = image.getHeight() / 2;
    
    double diff = Math.pow(Math.pow(image.getWidth(), 2) + Math.pow(image.getHeight(), 2), 0.5) /2;
    
//To correct the set of origin point and the overflow
    double rotationRequired = Math.toRadians(getRotation());
    double unitX = Math.abs(Math.cos(rotationRequired));
    double unitY = Math.abs(Math.sin(rotationRequired));
    
    double correctUx, correctUy;
    
    if (image.getWidth() >= image.getHeight())
    {
      correctUx = unitX;
      correctUy = unitY;
    }
    else //if the height is greater than the width, you have to change the axis to correct the overflow
    {
      correctUx = unitY;
      correctUy = unitX;
    }
    
    int posAffineTransformOpX = (int)returnX()-(int)(locationX)-(int)(correctUx*diff);
    int posAffineTransformOpY = (int)returnY()-(int)(locationY)-(int)(correctUy*diff);
    
//translate the image center to same diff that dislocates the origin, to correct its point set
    AffineTransform objTrans = new AffineTransform();
    objTrans.translate(correctUx*diff, correctUy*diff);
    objTrans.rotate(rotationRequired, locationX, locationY);
    
    AffineTransformOp op = new AffineTransformOp(objTrans, AffineTransformOp.TYPE_BILINEAR);
    
// Drawing the rotated image at the required drawing locations
    g.drawImage(op.filter(image, null), posAffineTransformOpX, posAffineTransformOpY, null);
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
  public boolean checkCollision(MapItem m){
    if (boundingBox.intersects(m.boundingBox)){
      return true;
    }
    else{
      return false;
    }
  }
}