import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Character extends Moving{
  
  private Weapon weapon;
  private double fatigue, hunger, thirst, fuel;
  
  Character(double x, double y, double w, double h, double health, double fatigue, double hunger, double thirst, double fuel, double speed, double rotation, double angularSpeed){
    super(x, y, w, h, health, 1, speed, rotation, angularSpeed);
    weapon = new Pistol(1, 1, 1, 1, 50);
    this.fatigue = fatigue;
    this.hunger = hunger;
    this.thirst = thirst;
    this.fuel = fuel;
  }
  public Weapon returnWeapon(){
    return this.weapon;
  }
  public void changeWeapon(Weapon p){
    this.weapon = p;
  }
  public void attack(){
    if (weapon.getAmmo() > 0){
      weapon.shoot();
    }
  } 
                      
//  public void moveLeft(){
//    changeSpeed((100-(this.fatigue))/100 * 2);
//    changeX(returnX() - returnSpeed() );
//  }
//  public void moveRight(){
//    changeSpeed((100-(this.fatigue))/100 * 2);
//    changeX(returnX() + returnSpeed());
//  }
//  public void moveDown(){
//    changeSpeed((100-(this.fatigue))/100 * 2);
//    changeY(returnY() + returnSpeed() );
//  }
//  public void moveUp(){
//    changeSpeed((100-(this.fatigue))/100 * 2);
//    changeY(returnY() - returnSpeed() );
//  }
  public boolean checkCollision(MapItem m){
    if (boundingBox.intersects(m.boundingBox)){
      return true;
    }
    else{
      return false;
    }
  }
//  public boolean checkRightCollision(MapItem m){
//    if ((m.returnX() >= (returnX() + (m.returnW() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
//      return true;
//    }
//    else{
//      return false;
//    }
//  }
//  public boolean checkUpCollision(MapItem m){
//    if ((returnY() >= (m.returnY() + (m.returnH() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
//      return true;
//    }
//    else{
//      return false;
//    }
//  }
//  public boolean checkDownCollision(MapItem m){
//    if ((m.returnY() >= (returnY() + (m.returnH() * 0.9))) && (boundingBox.intersects(m.boundingBox))){
//      return true;
//    }
//    else{
//      return false;
//    }
//  }
//  public void draw(Graphics g) { 
//    g.setColor(Color.BLUE); 
//    g.fillRect((int)(returnX()), (int)(returnY()), 25, 25);        
//  }
  
  
  public void rest(double recover){
    this.fatigue -= recover;
  }
  public void loseHunger(){
    if(this.hunger - 5 <= 0){
      this.hunger = 0;
    }
    else {
      this.hunger -= 5;
    }
  }
  public void loseThirst(){
    if(this.thirst - 5 <= 0){
      this.thirst = 0;
    }
    else{
      this.thirst -= 5;
    }
  }
  public void addFatigue(){
    if (this.fatigue + 2 >= 100){
      this.fatigue = 100;
    }
    else{
      this.fatigue += 2;
    }
  }

  public void eat(double food){
    if (this.hunger + food >= 100){
      this.hunger = 100;
    }
    else{
      this.hunger += food;
    }
  }
  public void drink(double water){
    if (this.thirst + water >= 100){
      this.thirst = 100;
    }
    else{
      this.thirst += water;
    }
  }
  
  public void addFuel(double fuel){
    if (this.fuel + fuel >= 100){
      this.fuel = 100;
    }
    else{
      this.fuel += fuel;
    }
  }
  
  public double returnFatigue(){
    return this.fatigue;
  }
  public double returnFood(){
    return this.hunger;
  }
  public double returnWater(){
    return this.thirst;
  }
  public double returnFuel(){
    return this.fuel;
  }
  
  
}