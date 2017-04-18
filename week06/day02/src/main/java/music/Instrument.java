package main.java.music;

/**
 * Created by georgezsiga on 4/18/17.
 */
public abstract class Instrument {

  protected String name;

  public abstract void play();

  public Instrument(String name) {
    this.name = name;
  }
}
