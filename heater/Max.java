package Heater;

public class Max implements HeaterState
{
  private int POWER = 3;
  Thread thread;

  public Max(Heater heater){

    thread = new Thread(()->{
      try
      {
        Thread.sleep(10000);
        heater.setPowerState(heater.getMedium());
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

    });
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void turnUp(Heater heater)
  {
  }

  @Override public void turnDown(Heater heater)
  {
      thread.interrupt();
      heater.setPowerState(heater.getMedium());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
