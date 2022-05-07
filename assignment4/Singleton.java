public class Singleton
{
  private static Singleton instance;

  private Singleton(){

  }

  public void singletonPrint(String text){
    System.out.println(text);
  }

  public static Singleton getInstance(){
    if(instance == null){
      instance = new Singleton();
    }
    return instance;
  }
}
