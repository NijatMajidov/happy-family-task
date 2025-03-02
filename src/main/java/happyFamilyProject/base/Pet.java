package happyFamilyProject.base;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    private String nickname;
    private int age;
    private Species species;
    private int trickLevel;
    private Set<String> habits;

    public Pet() {}

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel,Set<String> habits) {
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat(){
        System.out.println("I am eating");
    }

    public abstract void respond();

    public void foul(){
        System.out.println("I need to cover it up");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel &&
                Objects.equals(nickname, pet.nickname) &&
                Objects.equals(species, pet.species) &&
                Objects.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, age, species, trickLevel,habits);
    }

    @Override
    public String toString() {
        return """
            species: %s nickname: '%s'
                     age: %d trickLevel: %d
                     habits: %s """.formatted(species, nickname, age, trickLevel, habits);
    }

}