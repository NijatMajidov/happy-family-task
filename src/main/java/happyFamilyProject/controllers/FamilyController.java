package happyFamilyProject.controllers;

import happyFamilyProject.base.*;
import happyFamilyProject.services.FamilyService;
import java.util.Set;
import java.util.List;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int people) {
        return familyService.getFamiliesBiggerThan(people);
    }

    public List<Family> getFamiliesLessThan(int people) {
        return familyService.getFamiliesLessThan(people);
    }

    public int countFamiliesWithMemberNumber(int people) {
        return (int) familyService.countFamiliesWithMemberNumber(people);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String masculine, String feminine) {
        return familyService.bornChild(family, masculine, feminine);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}

