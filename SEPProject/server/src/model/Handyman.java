package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Handyman extends Account {
  private String CPR;
  private String firstName;
  private String lastName;
  private String description;
  private ArrayList<String> skills;
  private static final long serialVersionUID = 3;

  public Handyman(String email, String phone, Address address, String CPR, String firstName, String lastName,  String description,  ArrayList<String> skills, Double hourlyRate, boolean hideShowContact) {
    super(email, phone, address);
    this.CPR = CPR;
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
    this.skills = skills;
    this.hourlyRate = hourlyRate;
    this.hideShowContact = hideShowContact;
  }

  public String getCPR() {
    return CPR;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTaxCard() {
    return taxCard;
  }

  public void setTaxCard(String taxCard) {
    this.taxCard = taxCard;
  }

  public String getLanguages() {
    return languages;
  }

  public void setLanguages(String languages) {
    this.languages = languages;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setCPR(String CPR) {
    this.CPR = CPR;
  }

  public boolean equals(Object obj) {
    if(!(obj instanceof Handyman))
      return false;
    Handyman other = (Handyman) obj;
    return CPR.equals(other.CPR);
  }
}
