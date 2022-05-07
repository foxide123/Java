package treasury;

import java.util.HashMap;

public class Silver implements Valuable
{
  private String name;
  private int value;
  private String key;

  private static final HashMap<String, Silver> silverMap = new HashMap<>();

  public Silver(String key){
    this.name = "Silver";
    this.value = 4;
    this.key = key;
  }

  public synchronized static Silver getInstance(String key) {
    if (!silverMap.containsKey(key)) {
      silverMap.put(key, new Silver(key));
    }
    return silverMap.get(key);
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
