package hw3.enums;

public enum LeftSideMenu {

    HOME("Home"),
    CONTACT_FORM("Contact Form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENT_PACKS("Element Packs");

    final String name;

    LeftSideMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
