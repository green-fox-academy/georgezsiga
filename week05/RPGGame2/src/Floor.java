/**
 * Created by georgezsiga on 4/10/17.
 */
public class Floor extends Tile {

  public Floor(int posX, int posY) {
    super("assets/floor.png", posX, posY);
    this.isWall = false;
  }
}
