package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Cargo {

  Caliber50 caliber50model = new Caliber50();

  int caliber25, caliber30, caliber50;
  String shipstatus;
  Boolean ready;

  public Cargo() {
    this.caliber25 = 0;
    this.caliber30 = 0;
    this.caliber50 = caliber50model.getAmount();
    this.shipstatus = whatIsShipstatus();
    this.ready = isShipReady();
  }

  public String whatIsShipstatus() {
    int maxCargo = 12500;
    int acutalCargo = caliber50;
    double percentage = maxCargo/acutalCargo;
    if (acutalCargo == 0) {
      return "empty";
    }
    return percentage + "%";
  }

  public Boolean isShipReady() {
    if (getShipstatus().equals("100%")) {
      return true;
    }
    return false;
  }

  public int getCaliber25() {
    return caliber25;
  }

  public void setCaliber25(int caliber25) {
    this.caliber25 = caliber25;
  }

  public int getCaliber30() {
    return caliber30;
  }

  public void setCaliber30(int caliber30) {
    this.caliber30 = caliber30;
  }

  public int getCaliber50() {
    return caliber50;
  }

  public void setCaliber50(int caliber50) {
    this.caliber50 = caliber50;
  }

  public String getShipstatus() {
    return shipstatus;
  }

  public void setShipstatus(String shipstatus) {
    this.shipstatus = shipstatus;
  }

  public Boolean getReady() {
    return ready;
  }

  public void setReady(Boolean ready) {
    this.ready = ready;
  }
}
