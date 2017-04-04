package Pirates;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class Pirate {

  private int rumsDrank;
  public boolean isPassedOut, isDead;

  public Pirate() {
    rumsDrank = 0;
    isPassedOut = false;
    isDead = false;
  }

  public void drinkSomeRum() {
    if (isDead) {
      System.out.println("he is dead");
    } else {
      rumsDrank++;
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

  public boolean isPassedOut() {
    return isPassedOut;
  }

  public boolean isDead() {
    return isDead;
  }

  private void passOut() {
    isPassedOut = true;
  }

  public void die() {
    isDead = true;
  }

  public int getRumsDrank() {
    return rumsDrank;
  }

  public String getState() {
    return (isDead) ? "dead" : (isPassedOut) ? "passed out" : "alive";
  }

  public void brawl(Pirate otherPirate) {
    int brawlResult = (int) Math.random() * 3;
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
