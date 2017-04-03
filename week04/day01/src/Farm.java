import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/3/17.
 */
public class Farm {
  public List<Animal> animals;
  int slots = 10;

  public Farm() {
    this.animals = new ArrayList<>();
  }

  public void add() {
    animals.add(new Animal("lion"));
    animals.add(new Animal("goat"));
    animals.add(new Animal("chicken"));
  }

  public void breed() {
    if (slots > animals.size()) {
      animals.add(new Animal("new animal"));
    }
    slots -=1;
  }

  public void slaughter() {
    Animal tempAnimal = animals.get(0);
    for (Animal animal : animals) {
        if (animal.hunger < tempAnimal.hunger) {
          tempAnimal = animal;
        }
      }
      animals.remove(tempAnimal);
    }

  public static void main(String[] args) {
    Farm farmAnimals = new Farm();
    farmAnimals.add();
    farmAnimals.breed();
    farmAnimals.animals.get(2).hunger = 30;
    farmAnimals.slaughter();
    System.out.println(farmAnimals.animals);
  }
}
