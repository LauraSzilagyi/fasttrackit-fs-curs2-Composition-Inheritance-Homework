package ro.fasttrackit.curs2.ex2.composition;

import ro.fasttrackit.curs2.ex2.composition.impl.ReadFromFile;
import ro.fasttrackit.curs2.ex2.composition.impl.ReadFromMemory;

import java.io.IOException;

public class PersonMain {
    public static void main(String[] args) throws IOException {
        new PersonReportGenerator(getPersonProvider())
                .generateReport("output-composition.txt");
    }

    private static PersonProvider getPersonProvider() {
        return System.currentTimeMillis() % 2 == 0
                ? new ReadFromMemory()
                : new ReadFromFile("src/main/resources/people.txt");
    }
}
