public class Pistol extends Weapon{
  
  Pistol(double x, double y, double w, double h, double ammo){
    super(x, y, w, h, ammo, 400, 15);
  }
  public double returnDamage(){
    return super.returnDamage();
  }
  
}