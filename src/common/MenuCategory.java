package common;

public enum MenuCategory {
    HAMBURGER("HB",1),
    DRINK("DR",2),
    DESSERT("DS",3),
    BACK("BK",4);

    // 각 카테고리마다 접두사나 식별코드를 부여할 수 있음
    private final String prefix;
    private final int code;

    MenuCategory(String prefix, int code) {
        this.prefix = prefix;
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }
    public int getCode() {
        return code;
    }

    public static MenuCategory valueOfCode(int code) {
        for (MenuCategory restaurantMenu : MenuCategory.values()) {
            if (restaurantMenu.getCode() == code) {
                return restaurantMenu;
            }
        }
        throw new IllegalArgumentException("잘못된 코드입니다! → " + code);
    }
}
