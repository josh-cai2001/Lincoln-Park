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
  
}