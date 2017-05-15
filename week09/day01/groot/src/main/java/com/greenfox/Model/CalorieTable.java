package com.greenfox.Model;

import java.util.ArrayList;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class CalorieTable {

  ArrayList<Food> calorieTable;

  public CalorieTable() {
    this.calorieTable = new ArrayList<>();
  }

  public ArrayList<Food> getCalorieTable() {
    return calorieTable;
  }

  public void setCalorieTable(ArrayList<Food> calorieTable) {
    this.calorieTable = calorieTable;
  }
}
