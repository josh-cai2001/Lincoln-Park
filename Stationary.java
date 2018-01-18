import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
abstract class Stationary extends MapItem{
  
  Stationary(double x, double y, double w, double h){
    super(x, y, w, h);
  }
  public void draw(Graphics g, BufferedImage image){
    g.drawImage(image, (int)returnX(), (int)returnY(), null);
  }
}