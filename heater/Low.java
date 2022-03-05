package Heater;

public class Low implements HeaterState
{
  private int POWER = 1;

  @Override public void turnUp(Heater heater)
  {
    heater.setPowerState(heater.getMedium());
  }

  @Override public void turnDown(Heater heater)
  {
    heater.setPowerState(heater.getOff());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
