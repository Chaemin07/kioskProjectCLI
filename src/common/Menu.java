package common;

public enum Menu {
    VIEW_MENU("메뉴 보기", 1),
    CART("장바구니", 2),
    CHECKOUT("결제하기", 3),
    EXIT("종료", 4);

    private final String description;
    private final int code;

    Menu(String description, int code) {
        this.description = description; // enum메뉴 설명
        this.code = code;               // enum메뉴 번호
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static Menu valueOfCode(int code) {
        for (Menu menu : Menu.values()) {
            if (menu.getCode() == code) {
                return menu;
            }
        }
        throw new IllegalArgumentException("잘못된 코드입니다! → " + code);
    }
}
