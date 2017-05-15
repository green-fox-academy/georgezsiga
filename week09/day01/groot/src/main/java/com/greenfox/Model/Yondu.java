package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Yondu {

  Float distance;
  Float time;
  Float speed;

  public Yondu(Float distance, Float time) {
    this.distance = distance;
    this.time = time;
    this.speed = distance / time;
  }

  public Float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public Float getTime() {
    return time;
  }

  public void setTime(Float time) {
    this.time = time;
  }

  public Float getSpeed() {
    return speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }
}
