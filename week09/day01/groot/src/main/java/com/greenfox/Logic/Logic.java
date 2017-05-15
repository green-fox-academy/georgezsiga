package com.greenfox.Logic;

import com.greenfox.Model.Caliber50;
import com.greenfox.Model.CalorieTable;
import com.greenfox.Model.Cargo;
import com.greenfox.Model.Food;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Logic {

  Cargo cargo = new Cargo();
  Caliber50 caliber50 = new Caliber50();
  CalorieTable calorieTable = new CalorieTable();
  Food food;

  public void whatIsShipstatus() {
    double maxCargo = 12500;
    double actualCargo = cargo.getCaliber25()
        + cargo.getCaliber30()
        + cargo.getCaliber50();
    double percentage = (actualCargo/maxCargo)*100;
    if (percentage == 0) {
      cargo.setShipstatus("empty");
    } else if (percentage == 100.0) {
      cargo.setShipstatus("full");
    } else if (percentage > 100.0) {
      cargo.setShipstatus("overloaded");
    } else {
      cargo.setShipstatus(percentage + "%");
    }
  }

  public void addCaliber(String caliber, int amount) {
      caliber50.setReceived(caliber);
      caliber50.setAmount(amount);
      if (caliber.equals(".50")) {
        cargo.setCaliber50(cargo.getCaliber50() + amount);
      } else if (caliber.equals(".30")) {
        cargo.setCaliber30(cargo.getCaliber30() + amount);
      } else {
      cargo.setCaliber25(cargo.getCaliber25() + amount);
    }
      whatIsShipstatus();
      isShipReady();
      caliber50.setShipstatus(cargo.getShipstatus());
      caliber50.setReady(cargo.getReady());
  }

  private void isShipReady() {
    if (cargo.getShipstatus().equals("full")) {
      cargo.setReady(true);
    }
    cargo.setReady(false);
  }

  public Cargo getCargo() {
    return cargo;
  }

  public Caliber50 getCaliber50() {
    return caliber50;
  }

  public CalorieTable getCalorieTable() {
    return calorieTable;
  }


  public void addFood(String name, int amount, int calorie) {
    food = new Food(name, amount, calorie);
    getCalorieTable().addFood(food);
  }

  public void deleteFood(String name) {
  getCalorieTable().removeFood(name);
  }

  public void changeAmount(String name, int amount) {
    getCalorieTable().changeAmount(name, amount);
  }
}
