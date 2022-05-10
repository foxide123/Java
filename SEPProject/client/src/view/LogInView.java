package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewmodel.LogInViewModel;

import java.io.IOException;

public class LogInView
{
  @FXML private TextField tf_email;
  @FXML private TextField tf_password;

  private ViewHandler viewHandler;
  private LogInViewModel viewModel;

  public void init(ViewHandler viewHandler, LogInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }


  @FXML private void onLogIn(ActionEvent event) throws IOException
  {
    if(viewModel.logInUser(tf_email.getText(), tf_password.getText())){
      viewHandler.openView("LoggedIn");
    }
  }

  @FXML private void onSignUp(ActionEvent event) throws IOException
  {
    viewHandler.openView("SignUp");
  }

}
