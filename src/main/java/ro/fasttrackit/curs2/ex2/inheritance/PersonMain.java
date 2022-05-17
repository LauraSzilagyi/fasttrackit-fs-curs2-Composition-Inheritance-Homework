package ro.fasttrackit.curs2.ex2.inheritance;

import java.io.IOException;

public class PersonMain {
    public static void main(String[] args) throws IOException {
//        var generator = new ReadFromMemory();
        var generator = new ReadFromFile("src/main/resources/people.txt");
        generator.generateReport("output.txt");
    }
}
