package producerConsumer;

import treasury.Deposit;
import treasury.Valuable;
import treasury.ValuableQueue;

import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable
{
  private final ValuableQueue valuableQueue;

  public ValuableTransporter(ValuableQueue valuableQueue){
    this.valuableQueue = valuableQueue;
  }

  @Override public void run()
  {
    ArrayList<Valuable> valuableForTransporter = new ArrayList<>();
    Random random = new Random();
    while(true){
      try{
        int randomNumber = random.nextInt(200)+50;
        int i=0;
        while(i<=randomNumber) {
          int value = valuableQueue.getNextValuableItem().getValue();
          valuableForTransporter.add(valuableQueue.getNextValuableItem());
          i+=value;
        }
        System.out.println("Random number: " + randomNumber + ". " + "ValuableTrasnporter has gathered valuables "
                + "of value: " + i);
        Thread.sleep(100);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
}
