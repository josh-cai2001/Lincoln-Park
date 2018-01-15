import java.awt.Rectangle;
public class MapItem {
  
  private double x, y, w, h;
  Rectangle boundingBox;
  
  MapItem(double x, double y, double w, double h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    boundingBox = new Rectangle((int)x, (int)y, (int)w, (int)h);    
  }
  
  public double returnW(){
    return this.w;
  }
  public double returnH(){
    return this.h;
  }
  public double returnX(){
    return this.x;
  }
  public void changeX(double change){
    this.x = change;
    boundingBox.x = (int)change;
  }
  public double returnY(){
    return this.y;
  }
  public void changeY(double change){
    this.y = change;
    boundingBox.y = (int)change;
  }
  
}
