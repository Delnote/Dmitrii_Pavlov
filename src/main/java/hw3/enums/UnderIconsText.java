package hw3.enums;

public enum UnderIconsText {

    PRACTISE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM("To be flexible and\ncustomizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    final String name;

    UnderIconsText(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
