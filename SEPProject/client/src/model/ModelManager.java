package model;


import server.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.server.RemoteServer;

public class ModelManager implements Model
{
  private PropertyChangeSupport support;
  private RemoteServer server = new Server(host, port);

  public ModelManager(){
    this.database = new Database();
    this.support = new PropertyChangeSupport(this);
    database.addPropertyChangeListener(evt -> {
      System.out.println("evt name (ModelM):" + evt.getPropertyName());
      support.firePropertyChange(evt);
    });
  }

  public Employer logIn(String CVR, String password){
    return database.logInEmployer(CVR, password);
  }

  public Worker logIn(String CVR, String password){
    return database.logInEmployer(CVR, password);
  }

  public boolean signUpUser(String email, String password, String showHideContact){
    return database.signUpUser(email, password, showHideContact);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }
}
