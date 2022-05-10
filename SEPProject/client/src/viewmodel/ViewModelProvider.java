package viewmodel;

import model.Model;

public class ViewModelProvider
{
  private final LogInViewModel logInViewModel;
  private final LoggedInViewModel loggedInViewModel;
  private final SignUpViewModel signUpViewModel;

  public ViewModelProvider(Model model) {
    this.logInViewModel = new LogInViewModel(model);
    this.loggedInViewModel = new LoggedInViewModel(model);
    this.signUpViewModel = new SignUpViewModel(model);
  }

  public LogInViewModel getLogInViewModel() {
    return logInViewModel;
  }
  public LoggedInViewModel getLoggedInViewModel(){return loggedInViewModel;}
  public SignUpViewModel getSignUpViewModel(){return signUpViewModel;}
}
