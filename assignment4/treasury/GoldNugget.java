package treasury;

import java.util.HashMap;

public class GoldNugget implements Valuable
{
  private String name;
  private int value;
  private String key;

  private static final HashMap<String, GoldNugget> goldMap = new HashMap<>();

  private GoldNugget(String key){
    this.name = "Gold";
    this.value = 6;
    this.key = key;
  }

  public synchronized static GoldNugget getInstance(String key) {
    if (!goldMap.containsKey(key)) {
      goldMap.put(key, new GoldNugget(key));
    }
    return goldMap.get(key);
  }

  @Override public String getName()
  {
    return name;
  }

  @Override public int getValue()
  {
    return value;
  }
}
