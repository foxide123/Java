package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoggedInView
{
  @FXML private Label label_welcome;
  @FXML private Label label_showHideContact;

  private LoggedInViewModel viewModel;
  private ViewHandler viewHandler;


  public void init(ViewHandler viewHandler, LoggedInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    label_welcome.textProperty().bindBidirectional(viewModel.welcomeLabelProperty());
    label_showHideContact.textProperty().bindBidirectional(viewModel.showHideLabelProperty());
  }


  @FXML private void onLogOut(ActionEvent event)
  {
    try{
      viewHandler.openView("LogIn");
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
