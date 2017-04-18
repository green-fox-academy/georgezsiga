package main.java.music;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class AppMusic {

  public static void main(String[] args) {

    System.out.println("Test 1, create Electric Guitar, Bass Guitar and Violin with default strings.");
    ElectricGuitar guitar = new ElectricGuitar("Electric Guitar", 6);
    BassGuitar bassGuitar = new BassGuitar("Bass Guitar", 4);
    Violin violin = new Violin("Violin", 4);

    System.out.println("Test 1 Play");
    guitar.play();
    bassGuitar.play();
    violin.play();

    System.out.println("Test 2, create Electric Guitar, Bass Guitar with 7 and 5 strings .");
    ElectricGuitar guitar2 = new ElectricGuitar("Electric Guitar",7);
    BassGuitar bassGuitar2 = new BassGuitar("Bass Guitar",5);

    System.out.println("Test 2 Play");
    guitar.play();
    bassGuitar.play();
  }

}
