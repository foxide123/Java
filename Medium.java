package Heater;

public class Medium implements HeaterState
{
  private int POWER = 2;

  @Override public void turnUp(Heater heater)
  {
    heater.setPowerState(heater.getMax());
  }

  @Override public void turnDown(Heater heater)
  {
    heater.setPowerState(heater.getLow());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
