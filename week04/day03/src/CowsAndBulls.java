/**
 * Created by georgezsiga on 4/5/17.
 */
public class CowsAndBulls {

  public int randomNumber() {
    int number = (int) (Math.random() * 10);
    return number;
  }

  public int[] guessThisNumber() {
    int[] guessThis = {randomNumber(), randomNumber(),randomNumber(),randomNumber()};
    return guessThis;
  }
}
