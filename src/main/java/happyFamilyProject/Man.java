package happyFamilyProject;

import java.util.Map;

final class Man extends Human {
    public Man(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void repairCar() {
        System.out.println("I am repairing my car.");
    }
}
