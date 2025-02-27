package happyFamilyProject;

import java.util.Map;

final class Woman extends Human {
    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void makeup() {
        System.out.println("I am doing my makeup.");
    }
}