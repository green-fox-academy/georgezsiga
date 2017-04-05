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
  void eatEmpty() {
    animalTest.hunger = 0;
    int hunger = 0;
    assertEquals(hunger, animalTest.eat());
  }

  @Test
  void drink() {
    animalTest.thirst = 10;
    int thirst = 9;
    assertEquals(thirst, animalTest.drink());
  }

  @Test
  void drinkEmpty() {
    animalTest.thirst = 0;
    int thirst = 0;
    assertEquals(thirst, animalTest.drink());
  }

  @Test
  void play() {
    animalTest.hunger = 10;
    animalTest.thirst = 10;
    int hunger = 11;
    int thirst = 9;
    int[]play = {thirst, hunger};
    assertArrayEquals(play, animalTest.play());
  }

  @Test
  void playEmpty() {
    animalTest.hunger = 10;
    animalTest.thirst = 0;
    int thirst = 0;
    int hunger = 10;
    int[]play = {thirst, hunger};
    assertArrayEquals(play, animalTest.play());
  }

}