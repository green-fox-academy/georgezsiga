/**
 * Created by georgezsiga on 4/4/17.
 */
public class Pirate {
  int rumsDrank;
  boolean isPassedOut, isDead;

  public Pirate() {
    rumsDrank = 0;
    isPassedOut = false;
    isDead = false;
  }

  public void drinkSomeRum() {
    if (isDead) {
      System.out.println("he is dead");
    }
  }

  public void howsItGoingMate() {
    if (isDead) {
      System.out.println("he is dead");
    } else if (rumsDrank < 5) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      passOut();
    }
  }

  private void passOut() {
    isPassedOut = true;
  }

  public void die() {
    isDead = true;
  }

  public void brawl(Pirate otherPirate) {
    int brawlResult = (int) Math.random() *3;
    if (brawlResult == 0) {
      die();
    } else if (brawlResult == 1) {
      otherPirate.die();
    } else {
      passOut();
      otherPirate.passOut();
    }
  }


}
