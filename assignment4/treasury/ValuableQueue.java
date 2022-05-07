package treasury;

public interface ValuableQueue
{
  void putValuableItemInQueue(Valuable treasury);
  Valuable getNextValuableItem() throws InterruptedException;
}
