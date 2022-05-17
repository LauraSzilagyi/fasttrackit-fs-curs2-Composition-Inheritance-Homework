package ro.fasttrackit.curs2.ex2;

public record Person(String name, String firstname, int age) {

    public Person(String name, String firstname, int age) {
        this.name = name;
        this.firstname = firstname;
        this.age = Math.abs(age);
    }
}
