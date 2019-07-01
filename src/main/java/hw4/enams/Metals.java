package hw4.enams;

public enum Metals {

    BRONZE("Bronze"),
    SELEN("Selen"),
    GOLD("Gold"),
    SILVER("Silver"),
    METALS("Metals");

    final String name;

    Metals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
