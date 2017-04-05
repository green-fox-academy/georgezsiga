import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by georgezsiga on 4/5/17.
 */
class AnimalTest {
  Animal animalTest = new Animal("lion");

  @Test
  void eat() {
    animalTest.hunger = 10;
    int hunger = 9;
    assertEquals(hunger, animalTest.eat());
  }

  @Test
  void drink() {
  }

  @Test
  void play() {
  }

}