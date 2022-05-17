package ro.fasttrackit.curs2.ex2.composition;

import ro.fasttrackit.curs2.ex2.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPerson();
}
