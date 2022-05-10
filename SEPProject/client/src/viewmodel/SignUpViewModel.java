package viewmodel;

import javafx.scene.control.Alert;
import model.Model;

public class SignUpViewModel
{
  private Model model;

  public SignUpViewModel(Model model){
    this.model = model;
  }

  public void signUpUser(String email, String password, String toggleName){
    if(email!=null && password!=null){
      model.signUpUser(email, password, toggleName);
    }else{
      System.out.println("Please fill in all information");
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText("Please fill in all information to sign up!");
      alert.show();
    }
  }
}
