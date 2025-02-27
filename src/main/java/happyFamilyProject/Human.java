package happyFamilyProject;

import java.util.*;

public class Human extends Family {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;
    private Pet pet;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        this(name,surname,year);
        this.iq = iq;
        this.schedule = schedule;
    }
    public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
        this(name,surname,year,iq,schedule);
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surnam) {
        this.surname = surnam;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public Pet getPet() {
        return pet;
    }
    public void adoptPet(Pet pet) {
        this.pet = pet;
        if (family != null) {
            family.setPets();
        }
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() { return family; }
    public void setFamily(Family family) { this.family = family; }

    public void greetPet() {
        if (family != null && family.getPets() != null) {
            for (Pet pet : family.getPets()) {
                System.out.println("Hello, " + pet.getNickname());
            }
        } else {
            System.out.println("No pet to greet");
        }
    }

    public void describePet() {
        if (family.getPets() != null) {
            for(Pet pet : family.getPets()) {
                String slyLevel = (pet.getTrickLevel() > 50) ? "very sly" : "almost not sly";
                System.out.println("I have a " + pet.getSpecies() + ", it is " + pet.getAge() + " years old, it is " + slyLevel + ".");
            }
        } else {
            System.out.println("No pet to describe");
        }
    }
    public boolean feedPet(boolean isItTimeForFeeding) {
        if (family == null || family.getPets() == null) {
            System.out.println("No pet to feed");
            return false;
        }
        for (Pet pet : family.getPets()) {
            if (isItTimeForFeeding && pet.getTrickLevel() > new Random().nextInt(101)) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.getNickname());
                return true;
            } else {
                System.out.println("I think " + pet.getNickname() + " is not hungry.");
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq,schedule);

    }

    @Override
    public String toString() {
        return """
                Human{
                    name: '%s',
                    surname: '%s',
                    year: %d,
                    iq: %d,
                    mother: %s,
                    father: %s,
                    pet: %s
                }
                """.formatted(
                name, surname, year, iq,
                (getMother() != null ? getMother().name + " " + getMother().surname : "unknown"),
                (getFather() != null ? getFather().name + " " + getFather().surname : "unknown"),
                (pet != null ? pet : "Don't have a pet")
        );
    }
}