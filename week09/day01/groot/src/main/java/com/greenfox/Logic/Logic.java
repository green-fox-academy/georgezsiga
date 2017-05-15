package com.greenfox.Logic;

import com.greenfox.Model.Caliber50;
import com.greenfox.Model.Cargo;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Logic {

  Cargo cargo = new Cargo();
  Caliber50 caliber50 = new Caliber50();

  public void whatIsShipstatus() {
    double maxCargo = 12500;
    double actualCargo = caliber50.getAmount();
//    double percentage = 40;
    double percentage = (actualCargo/maxCargo)*100;
    if (actualCargo == 0) {
      cargo.setShipstatus("empty");
    } else {
      cargo.setShipstatus(percentage + "%");
    }
  }

  public void addCaliber50(String caliber, int amount) {
    caliber50.setReceived(caliber);
    caliber50.setAmount(amount);
    whatIsShipstatus();
    isShipReady();
    caliber50.setShipstatus(cargo.getShipstatus());
    caliber50.setReady(cargo.getReady());

  }

  private void isShipReady() {
    if (cargo.getShipstatus().equals("100%")) {
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
}
