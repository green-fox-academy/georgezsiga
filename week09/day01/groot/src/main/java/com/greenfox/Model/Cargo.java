package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Cargo {

  int caliber25, caliber30, caliber50;
  String shipstatus;
  Boolean ready;

  public Cargo() {
    this.caliber25 = 0;
    this.caliber30 = 0;
    this.caliber50 = 0;
    this.shipstatus = "empty";
    this.ready = false;
  }
}
