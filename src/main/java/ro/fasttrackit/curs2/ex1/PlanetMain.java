package ro.fasttrackit.curs2.ex1;

public class PlanetMain {
    public static void main(String[] args) {

        double weightOnTerra = 20;

        for (Planet planet : Planet.values()) {
            System.out.printf("Your weight on %s is %s%n", planet.name(), planet.getWeightOnTerra(weightOnTerra));
        }
    }
}
