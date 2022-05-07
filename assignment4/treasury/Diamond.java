package treasury;

import java.util.HashMap;

public class Diamond implements Valuable
{
  private String name;
  private int value;
  private String key;

  private static final HashMap<String, Diamond> diamondMap = new HashMap<>();

  public Diamond(String key){
    this.name = "Diamond";
    this.value = 10;
    this.key = key;
  }


  public synchronized static Diamond getInstance(String key) {
    if (!diamondMap.containsKey(key)) {
      diamondMap.put(key, new Diamond(key));
    }
    return diamondMap.get(key);
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
