package ro.fasttrackit.curs2.ex2.composition.impl;

import ro.fasttrackit.curs2.ex2.Person;
import ro.fasttrackit.curs2.ex2.composition.PersonProvider;

import java.util.List;

public class ReadFromMemory implements PersonProvider {
    @Override
    public List<Person> readPerson() {
        return List.of(
                new Person("Delena", "Spitler", 23),
                new Person("Leo", "Paschal", 33),
                new Person("Reena", "Stach", 12)
        );
    }
}