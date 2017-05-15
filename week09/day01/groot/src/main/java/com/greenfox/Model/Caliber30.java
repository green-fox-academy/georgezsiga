package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Caliber30 {
  String received;
  int amount;
  String shipstatus;
  Boolean ready;

  public Caliber30() {
    this.received = "0";
    this.amount = 0;
    this.shipstatus = "empty";
    this.ready = false;
  }

  public String getReceived() {
    return received;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
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