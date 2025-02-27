package happyFamilyProject;

import java.util.Set;

class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(Species.DOG.toString(), nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am - " + super.getNickname() + ". I miss you!");
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up");
    }
}