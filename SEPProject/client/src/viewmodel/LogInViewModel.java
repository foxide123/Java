package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LogInViewModel
{
  private Model model;
  private StringProperty email;
  private StringProperty password;

  public LogInViewModel(Model model){
    this.model = model;
    this.email = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
  }

  public boolean logInUser(String email, String password){
    return model.logInUser(email, password);
  }


}
