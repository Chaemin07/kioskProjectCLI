package common;

public enum KioskMenu {
    VIEW_MENU("메뉴 보기", 1),
    VIEW_CART("장바구니 보기", 2),
    CHECKOUT("결제하기", 3),
    EXIT("종료", 4);

    private final String description;
    private final int code;

    KioskMenu(String description, int code) {
        this.description = description; // enum메뉴 설명
        this.code = code;               // enum메뉴 번호
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static KioskMenu valueOfCode(int code) {
        for (KioskMenu kioskMenu : KioskMenu.values()) {
            if (kioskMenu.getCode() == code) {
                return kioskMenu;
            }
        }
        throw new IllegalArgumentException("잘못된 코드입니다! → " + code);
    }
}
