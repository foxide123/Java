package treasury;

import java.util.Random;

public class Mine
{
  Random rand ;
  int randomNumber;

  public Mine(){
    rand = new Random();
    randomNumber = 0;
  }

  public Valuable getRandomValuable(){
    randomNumber = rand.nextInt(100)+1;
    if(randomNumber<=10){ //10% chance that it will be diamond
      return getDiamond();
    }else if(randomNumber>10 && randomNumber<=40){ //30% for gold
      return getGoldNugget();
    }else if(randomNumber<=100 && randomNumber>40){ // 60% for silver
      return getSilver();
    }
    return null;
  }

  public Valuable getGoldNugget(){
    return GoldNugget.getInstance("GoldNugget");
  }

  public Valuable getSilver(){
    return Silver.getInstance("Silver");
  }

  public Valuable getDiamond(){
    return Diamond.getInstance("Diamond");
  }
}
