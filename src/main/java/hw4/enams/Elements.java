package hw4.enams;

public enum Elements {

    WATER("Water"),
    WIND("Wind"),
    FIRE("Fire"),
    EARTH("Earth");

    final String name;

    Elements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
