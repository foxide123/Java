package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewmodel.SignUpViewModel;

import java.io.IOException;

public class SignUpView
{
  @FXML private RadioButton radioButtonShow;
  @FXML private RadioButton radioButtonHide;
  @FXML private TextField tf_email;
  @FXML private TextField tf_password;
  @FXML private ChoiceBox choiceBox;

  private ViewHandler viewHandler;
  private SignUpViewModel viewModel;
  private String toggleName;
  ToggleGroup toggleGroup = new ToggleGroup();

  public void init(ViewHandler viewHandler, SignUpViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    radioButtonShow.setToggleGroup(toggleGroup);
    radioButtonHide.setToggleGroup(toggleGroup);

    radioButtonShow.setSelected(true);

    choiceBox.getItems().addAll("Horsens", "Copenhagen", "Aarhus", "Odense");

    //set default value
    choiceBox.setValue("Horsens");

    //choiceBox.getValue();
  }

  @FXML private void onSignUp(ActionEvent event){
    toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
    viewModel.signUpUser(tf_email.getText(), tf_password.getText(),toggleName);
  }

  @FXML private void onLogIn(ActionEvent event){
    try{
      viewHandler.openView("LogIn");
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
