package happyFamilyProject.services;

import happyFamilyProject.base.*;
import happyFamilyProject.dao.FamilyDao;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        if (families != null){
            for (int i = 0; i < families.size(); i++) {
            System.out.println("Family " + (i + 1) + ": " + families.get(i));
        }}else{
            System.out.println("Family is null!");
        }
    }

    public List<Family> getFamiliesBiggerThan(int peopleCount) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > peopleCount)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int peopleCount) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < peopleCount)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == number)
                .count();
    }

    public Family createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
        return newFamily;
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        Random random = new Random();
        boolean isBoy = random.nextBoolean();
        String childName = isBoy ? maleName : femaleName;
        Human child = new Human(childName, family.getFather().getSurname(), family);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : familyDao.getAllFamilies()) {
            family.getChildren().removeIf(child -> child.getYear() > age);
            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        Family family = getFamilyById(index);
        return family != null ? family.getPets() : Collections.emptySet();
    }

    public void addPet(int index, Pet pet) {
        Family family = getFamilyById(index);
        if (family != null) {
            family.getPets().add(pet);
            familyDao.saveFamily(family);
        }
    }
}
