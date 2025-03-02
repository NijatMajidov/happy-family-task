package happyFamilyProject.base;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my lovely pet!");
    }

    public void makeup() {
        System.out.println("I am doing my makeup.");
    }
}