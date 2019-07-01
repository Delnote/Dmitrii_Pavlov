package hw4.enams;

public enum Colors {

    YELLOW("Yellow"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    COLORS("Colors");

    final String name;

    Colors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
