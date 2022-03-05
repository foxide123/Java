package Heater;

public interface HeaterState
{
  public void turnUp(Heater radiator);
  public void turnDown(Heater radiator);
  public int getPower();
}
