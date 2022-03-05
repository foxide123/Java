package Heater;

public class Off implements HeaterState
{
  private int POWER = 0;

  @Override public void turnUp(Heater heater)
  {
    heater.setPowerState(heater.getLow());
  }

  @Override public void turnDown(Heater heater)
  {

  }

  @Override public int getPower()
  {
    return POWER;
  }
}
