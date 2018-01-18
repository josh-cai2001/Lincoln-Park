import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
abstract public class Weapon extends MapItem{
  
  private double ammo, coolDown, damage, coolDownStore;
  
  Weapon(double x, double y, double w, double h, double ammo, double coolDown, double damage){
    super(x, y, w, h);
    this.ammo = ammo;
    this.coolDown = coolDown;
    this.coolDownStore = coolDown;
    this.damage = damage;
  }
  
  public double getAmmo(){
    return this.ammo;
  }
  public void shoot(){
    this.ammo -= 1d;
  }
  public void addAmmo(double change){
    this.ammo += change;
  }
  public double getCoolDown(){
    return this.coolDown;
  }
  public void reduceCoolDown(){
    this.coolDown -= 1;
  }
  public void resetCoolDown(){
    this.coolDown = this.coolDownStore;
  }
  public double returnDamage(){
    return this.damage;
  }
  public void draw(Graphics g, BufferedImage image){
    g.drawImage(image, (int)returnX(), (int)returnY(), null);
  }
}