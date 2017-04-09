package Pirates;

/**
 * Created by georgezsiga on 4/4/17.
 */
public class BattleApp {

  public static void main(String[] args) {
    Armada armada1 = new Armada();
    armada1.fillArmada();
    Armada armada2 = new Armada();
    armada2.fillArmada();
    armada1.armadaWar(armada2);
  }
}
