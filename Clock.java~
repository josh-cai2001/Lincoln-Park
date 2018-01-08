public class Clock {
  long elapsedTime;
  long lastTimeCheck;

  public Clock() { 
    lastTimeCheck=System.nanoTime();
    elapsedTime=0;
  }
  
  public void update() {
  long currentTime = System.nanoTime();
  elapsedTime = currentTime - lastTimeCheck;
  lastTimeCheck = currentTime;
  }
  
  public double getElapsedTime() {
    return elapsedTime/1.0E9;
  }
}