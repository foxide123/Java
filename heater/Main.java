package Heater;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Heater heater = new Heater();
    heater.turnUp();
    heater.turnUp();
    heater.turnUp();
    System.out.println(heater.getPower());
    Thread.sleep(11000);
    System.out.println(heater.getPower());
  }
}
