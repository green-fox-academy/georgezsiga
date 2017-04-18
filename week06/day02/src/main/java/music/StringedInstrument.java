package main.java.music;

/**
 * Created by georgezsiga on 4/18/17.
 */
public abstract class StringedInstrument extends Instrument {

  final String formatForPlay ="%s, a %d-stringed instrument that %s\n";
  int numberOfStrings;
  String sound;


  public StringedInstrument(String name, int numberOfStrings, String sound) {
    super(name);
    this.numberOfStrings = numberOfStrings;
    this.sound = sound;
  }

  @Override
  public void play() {
    System.out.printf(formatForPlay, this.name, numberOfStrings, sound);
  }
}
