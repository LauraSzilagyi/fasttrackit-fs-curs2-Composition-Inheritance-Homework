package ro.fasttrackit.curs2.ex2.inheritance;

import ro.fasttrackit.curs2.ex2.Person;

import java.util.List;

public class ReadFromMemory extends PersonReportGenerator {
    @Override
    List<Person> readPersons() {
        return List.of(
                new Person("Delena", "Spitler", 23),
                new Person("Leo", "Paschal", 33),
                new Person("Reena", "Stach", 12)
        );
    }
}
