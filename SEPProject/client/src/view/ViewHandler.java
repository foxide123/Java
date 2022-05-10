package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import viewmodel.ViewModelProvider;

import java.io.IOException;

public class ViewHandler
{
  private Stage localStage;
  private ViewModelProvider mvViewModel;

  public ViewHandler(ViewModelProvider mvViewModel){
    this.mvViewModel = mvViewModel;
  }

  public void start(Stage stage) throws Exception{
    this.localStage = stage;
    openView("LogIn");
  }

  public void openView(String viewToOpen) throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    if("LogIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("LogIn.fxml"));
      root = loader.load();
      LogInView view = loader.getController();
      view.init(this, mvViewModel.getLogInViewModel());
      localStage.setTitle("LogIn");
    }
    else if("LoggedIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("LoggedIn.fxml"));
      root = loader.load();
      LoggedInView view = loader.getController();
      view.init(this, mvViewModel.getLoggedInViewModel());
      localStage.setTitle("Log");
    }
    else if("SignUp".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("SignUp.fxml"));
      root = loader.load();
      SignUpView view = loader.getController();
      view.init(this, mvViewModel.getSignUpViewModel());
      localStage.setTitle("Log");
    }
    //you can only show one view per stage
    scene = new Scene(root);
    localStage.setScene(scene);
    localStage.show();
  }
}
