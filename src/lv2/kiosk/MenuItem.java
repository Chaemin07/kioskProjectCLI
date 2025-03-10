package lv2.kiosk;

public class MenuItem {
    // 메뉴는 불변으로
    private final String name;
    private double price;
    private String menuInfo;

    public MenuItem(String name, String price, String menuInfo) {
        double menuPrice=0;
        try {
            menuPrice = Double.parseDouble(price.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다! \n 에러 내용 → "+e.getMessage());
        }
        // 생성자 내부에서 유효성 검사 - 음식 이름
        if (name == null || name.isBlank()) {
            // name 문자열이 비어 있거나, 빈 공백으로만 이루어져 있으면 true 리턴
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다!");
        }
        // 생성자 내부에서 유효성 검사 - 음식 가격
        if (menuPrice < 0) {
            throw new IllegalArgumentException("가격은 0원 이상이어야 합니다!");
        }
        this.name = name;
        this.price = menuPrice;
        this.menuInfo = menuInfo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMenuInfo() {
        return menuInfo;
    }
}
