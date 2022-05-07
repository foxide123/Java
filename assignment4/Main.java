import producerConsumer.Miner;
import producerConsumer.ValuableTransporter;
import treasury.Deposit;
import treasury.ValuableQueue;

import java.util.concurrent.BlockingQueue;

public class Main
{
  public static void main(String[] args)
  {
    ValuableQueue valuableQueue = new Deposit();

    Miner miner1 = new Miner(valuableQueue);
    ValuableTransporter valuableTransporter = new ValuableTransporter(valuableQueue);

    Thread minerThread = new Thread(miner1);
    Thread valuableTransporterThread = new Thread(valuableTransporter);

    minerThread.start();
    valuableTransporterThread.start();
  }
}
