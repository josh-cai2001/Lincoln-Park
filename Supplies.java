import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
abstract public class Supplies extends MapItem{
  
  private double value;
  
  Supplies(double x, double y, double w, double h){
    super(x, y, w, h);
  }
  
  public void changeValue(double change){
    this.value = change;
  }
  
  
  public double returnValue(){
    return this.value;
  }
  public void draw(Graphics g, BufferedImage image){
    g.drawImage(image, (int)returnX(), (int)returnY(), null);
  }
}