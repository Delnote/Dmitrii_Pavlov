package hw4.enams;

public enum Vegetables {

    VEGETABLES("Vegetables"),
    ONION("Onion"),
    CUCUMBER("Cucumber"),
    TOMATO("Tomato");

    final String name;

    Vegetables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
