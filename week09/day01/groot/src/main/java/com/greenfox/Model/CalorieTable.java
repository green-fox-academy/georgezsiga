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

  public void addFood(Food food) {
    calorieTable.add(food);
  }

  public void removeFood(String name) {
    for (Food f : calorieTable) {
      if (f.getName().equals(name)) {
        calorieTable.remove(f);
      }
    }
  }

  public ArrayList<Food> getCalorieTable() {
    return calorieTable;
  }

  public void setCalorieTable(ArrayList<Food> calorieTable) {
    this.calorieTable = calorieTable;
  }

  public void changeAmount(String name, int amount) {
    for (Food f : calorieTable) {
      if (f.getName().equals(name)) {
        f.setAmount(amount);
      }
    }
  }
}
