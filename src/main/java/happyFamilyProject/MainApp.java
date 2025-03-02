package happyFamilyProject;

import happyFamilyProject.base.*;
import happyFamilyProject.controllers.FamilyController;
import happyFamilyProject.dao.CollectionFamilyDao;
import happyFamilyProject.dao.FamilyDao;
import happyFamilyProject.services.FamilyService;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Go to school");

        Man father = new Man("John", "Smith", 1978, 110, schedule);
        Woman mother = new Woman("Jane", "Smith", 1980, 100, schedule);
        familyController.createNewFamily(mother, father);
        System.out.println("Yeni ailə yaradıldı.");

        familyController.displayAllFamilies();
        System.out.println("Ailələrin ümumi sayı: " + familyController.count());

        Family firstFamily = familyController.getFamilyById(0);
        familyController.bornChild(firstFamily, "David", "Emma");
        System.out.println("Uşaq dünyaya gəldi.");

        familyController.displayAllFamilies();

        Human adoptedChild = new Human("Alice", "Johnson", 5);
        familyController.adoptChild(firstFamily, adoptedChild);
        System.out.println("Uşaq övladlığa götürüldü.");

        familyController.displayAllFamilies();

        familyController.deleteAllChildrenOlderThan(10);
        System.out.println("10 yaşdan yuxarı uşaqlar silindi.");

        familyController.displayAllFamilies();
        Pet pet = new Dog("Rocky", 5, 50, new HashSet<>(Arrays.asList("eat", "sleep")));
        familyController.addPet(0, pet);
        System.out.println("Ev heyvanı əlavə edildi.");

        System.out.println("Ailə 0-ın ev heyvanları: " + familyController.getPets(0));

        int familyCount = familyController.countFamiliesWithMemberNumber(3);
        System.out.println("3 nəfərlik ailələrin sayı: " + familyCount);

        System.out.println("2 nəfərdən böyük ailələr:");
        familyController.getFamiliesBiggerThan(2).forEach(System.out::println);

        familyController.deleteFamilyByIndex(0);
        System.out.println("Ailə silindi.");

        familyController.displayAllFamilies();
        pet.foul();
        pet.eat();
        pet.respond();

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