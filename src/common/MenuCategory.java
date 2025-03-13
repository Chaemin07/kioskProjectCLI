package common;

public enum MenuCategory {
    HAMBURGER("HB"),
    DRINK("DR"),
    DESSERT("DS");

    // 각 카테고리마다 접두사나 식별코드를 부여할 수 있음
    private final String prefix;

    MenuCategory(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
