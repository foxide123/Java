import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelProvider;

public class RunApplication extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    Model m = new ModelManager();
    ViewModelProvider mvvm = new ViewModelProvider(m);
    ViewHandler view = new ViewHandler(mvvm);
    view.start(stage);
  }
}
