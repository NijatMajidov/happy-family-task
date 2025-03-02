package happyFamilyProject.base;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hey buddy!");
    }

    public void repairCar() {
        System.out.println("I am repairing my car.");
    }
}
