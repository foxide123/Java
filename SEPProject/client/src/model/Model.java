package model;

import java.beans.PropertyChangeListener;

public interface Model
{
  boolean logInUser(String username, String password);
  boolean signUpUser(String username, String password, String favChannel);
  void addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
}
