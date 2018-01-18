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
    this.ammo -= 1;
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
  
}