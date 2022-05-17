package ro.fasttrackit.curs2.ex2.composition;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.curs2.ex2.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PersonReportGenerator {
    private final PersonProvider personProvider;

    public void generateReport(String outputFile) throws IOException {
        List<Person> persons = personProvider.readPerson();
        generateOutputReport(persons, outputFile);
    }

    private void generateOutputReport(List<Person> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writePersonsWithAgeLessThan30(writer, persons);
            writePersonsWithAgeBetween30And50(writer, persons);
            writePersonsWithAgeHigherThan50(writer, persons);
        }
    }

    private void writePersonsWithAgeLessThan30(BufferedWriter writer, List<Person> persons) {
        Predicate<Person> predicate = person -> person.age() <= 30;
        String personsName = getPersonsNameByPredicate(persons, predicate);
        writeResult(writer, "1-30: ", personsName);
    }

    private void writePersonsWithAgeBetween30And50(BufferedWriter writer, List<Person> persons) {
        Predicate<Person> predicate = person -> person.age() > 30 && person.age() <= 50;
        String personsName = getPersonsNameByPredicate(persons, predicate);
        writeResult(writer, "30-50: ", personsName);
    }

    private void writePersonsWithAgeHigherThan50(BufferedWriter writer, List<Person> persons) {
        Predicate<Person> predicate = person -> person.age() > 50;
        String personsName = getPersonsNameByPredicate(persons, predicate);
        writeResult(writer, "50+: ", personsName);
    }

    private String getPersonsNameByPredicate(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream()
                .filter(predicate)
                .map(person -> person.name() + " " + person.firstname())
                .collect(Collectors.joining(", "));
    }

    private void writeResult(BufferedWriter writer, String prefix, String line) {
        try {
            writer.write(prefix);
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
