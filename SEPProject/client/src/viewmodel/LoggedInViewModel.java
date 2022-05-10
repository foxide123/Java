package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty welcome;
  private StringProperty showHideContact;
  private PropertyChangeSupport support;

  public LoggedInViewModel(Model model){
    this.model = model;
    this.support = new PropertyChangeSupport(this);
    this.welcome = new SimpleStringProperty();
    this.showHideContact = new SimpleStringProperty();
    model.addPropertyChangeListener(this);
  }

  public StringProperty welcomeLabelProperty(){return welcome;}
  public StringProperty showHideLabelProperty(){return showHideContact;}


  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("LoggedIn")){
      System.out.println("evt name (LoggedInViewModel):" + evt.getPropertyName());
      support.firePropertyChange(evt);
      User user = (User) evt.getNewValue();
      System.out.println(user.getEmail());
      welcome.set("Welcome " + user.getEmail() + "!");
      showHideContact.set("You have chosen " + user.getShowHideContact() + "!");
    }
  }

}
