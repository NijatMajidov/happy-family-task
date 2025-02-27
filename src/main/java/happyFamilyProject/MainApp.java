package happyFamilyProject;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        Pet pet = new Dog("Rocky", 5, 50, new HashSet<>(Arrays.asList("eat", "sleep")));
        pet.foul();
        pet.eat();
        pet.respond();

        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Go to school");

        Human father = new Man("John", "Smith", 1978, 110, schedule);
        Human mother = new Woman("Jane", "Smith", 1980, 100, schedule);

        Family family = new Family(mother,father);
        father.setFamily(family);
        mother.setFamily(family);
        father.adoptPet(pet);

        Human child1 = new Human("Emma", "Smith", 10);
        Human child2 = new Human("Liam", "Smith", 8);

        family.addChild(child1);
        family.addChild(child2);

        father.greetPet();
        father.describePet();
        father.feedPet(true);

        System.out.println("Before deletion: " + family.getChildren());

        boolean removed = family.deleteChild(1);
        System.out.println("Test 1. Child removed (index 1): " + removed);
        System.out.println("After deletion: " + family.getChildren());

        boolean invalidRemove1 = family.deleteChild(-1);
        System.out.println("Test 2. Child removed (index -1): " + invalidRemove1);
        System.out.println("After invalid deletion: " + family.getChildren());

        boolean invalidRemove2 = family.deleteChild(10);
        System.out.println("Test 3. Child removed (index 10): " + invalidRemove2);
        System.out.println("After out-of-bounds deletion: " + family.getChildren());

        System.out.println("Family member count: "+family.countFamily());
        System.out.println(family);

        boolean removed2 = family.deleteChild(child1);
        System.out.println("Test 4. Child removed (human): " + removed2);
        System.out.println(family);
    }
}