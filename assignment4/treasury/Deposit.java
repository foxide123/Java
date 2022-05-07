package treasury;

import java.util.LinkedList;
import java.util.Queue;

public class Deposit implements ValuableQueue
{
  private final Queue<Valuable> treasuryQueue;

  public Deposit(){
    treasuryQueue = new LinkedList<>();
  }

  @Override public synchronized void putValuableItemInQueue(Valuable treasury)
  {
    treasuryQueue.add(treasury);
    notifyAll();
  }

  @Override public synchronized Valuable getNextValuableItem() throws InterruptedException
  {
    while(treasuryQueue.isEmpty()){
      wait();
    }
    return treasuryQueue.remove();
  }
}
