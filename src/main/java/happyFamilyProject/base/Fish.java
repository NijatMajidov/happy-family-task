package happyFamilyProject.base;

import java.util.Set;

class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(Species.FISH, nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Blub blub! I am a fish.");
    }
}