package hw3.enums;

public enum DifferentElementsPageData {

    WIND("Wind"),
    WATER("Water"),
    SELEN("Selen"),
    YELLOW("Yellow"),
    METAL("metal"),
    COLORS("Colors");

    final String name;

    DifferentElementsPageData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
