import model.Client;
import model.Handyman;

public interface RemoteServer
{
  Handyman logInHandyman(String CVR, String password);
  Client loginClient(String CPR, String password);

}
