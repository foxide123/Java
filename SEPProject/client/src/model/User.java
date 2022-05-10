package model;

public class User
{
  private String email;
  private String password;
  private String showHideContact;

  public User(String email, String password, String showHideContact){
    this.email = email;
    this.password = password;
    this.showHideContact = showHideContact;
  }

  public String getEmail(){return email;}
  public String getPassword(){return password;}
  public String getShowHideContact(){return showHideContact;}
}
