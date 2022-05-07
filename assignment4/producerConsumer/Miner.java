package producerConsumer;

import treasury.Deposit;
import treasury.Mine;
import treasury.ValuableQueue;
import treasury.Valuable;

public class Miner implements Runnable
{

  /*PRODUCER*/
  private final ValuableQueue valuableQueue;
  private Mine mine;

  public Miner( ValuableQueue valuableQueue){
    this.valuableQueue = valuableQueue;
    this.mine = new Mine();
  }

  @Override public void run()
  {
    while(true){
      try{
        Valuable valuableItem = mine.getGoldNugget();
        valuableQueue.putValuableItemInQueue(valuableItem);
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
