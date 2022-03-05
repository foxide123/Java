package Heater;

public class Heater
{

  HeaterState off;
  HeaterState low;
  HeaterState medium;
  HeaterState max;
  private HeaterState currentState;


  public Heater()
  {
    off = new Off();
    low = new Low();
    medium = new Medium();
    max = new Max(this);

    currentState = new Off();
  }

  public void turnUp(){
    currentState.turnUp(this);
  }

  public void turnDown(){
    currentState.turnDown(this);
  }

  public int getPower(){
    return currentState.getPower();
  }

  void setPowerState(HeaterState state){
    currentState = state;
  }

  HeaterState getOff() {return off;}
  HeaterState getLow(){return low;}
  HeaterState getMedium(){return medium;}
  HeaterState getMax(){return max;}
}
