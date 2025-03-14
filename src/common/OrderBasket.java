package common;

import java.io.IOException;
import java.util.*;

public class OrderBasket {
    private Map<MenuCategory, List<MenuItem>> menuBasket;
    // idx, 장바구니 음식
    private Map<Integer, MenuItem> basketMap;
    // idx, 메뉴 카테고리
    private Map<Integer, MenuCategory> categoryMap;
    private double totalSum=0;

    public OrderBasket() {
        menuBasket = new HashMap<>();
        //  카테고리별 List초기화
        for (MenuCategory category : MenuCategory.values()) {
            menuBasket.put(category, new ArrayList<>()); // 초기화
        }
    }

    private void setMenuBasket() {
        this.menuBasket = new HashMap<>();
        totalSum=0;
        for (MenuCategory category : MenuCategory.values()) {
            menuBasket.put(category, new ArrayList<>()); // 초기화
        }
    }

    //  장바구니에 메뉴 추가
    public void addItem(MenuCategory category, MenuItem item) {
        menuBasket.get(category).add(item);
        System.out.println(item.getName()+"을 추가하였습니다.");
        totalSum += item.getPrice();
    }

    // ✅ 장바구니에서 메뉴 제거
    public void removeItem(Map<MenuCategory,MenuItem> removeItemMap) {
        for (Map.Entry<MenuCategory, MenuItem> entry : removeItemMap.entrySet()) {
            MenuCategory category = entry.getKey();
            MenuItem item = entry.getValue();
            if (menuBasket.get(category).remove(item)) {
                System.out.println("✅ "+item.getName() + "를 장바구니에서 삭제합니다.");
                totalSum -= item.getPrice();
            } else {
                System.out.println("⚠\uFE0F " + item.getName() + "는 장바구니에 없습니다");

            }
        }
    }

    public Map<MenuCategory,MenuItem> findRemoveItem()throws IOException {
        IOHandler ioHandler = new IOHandler();
        Map<MenuCategory, MenuItem> removeItem = new HashMap<>();
        try{
            int removeIdx = ioHandler.inputInt("❌ 삭제할 메뉴 번호를 입력하세요 (0 입력 시 취소): ", basketMap.size())-1;
            if (removeIdx == -1) {
                System.out.println("🚫 메뉴 삭제를 취소하였습니다.");
                return removeItem;
            }
            if (basketMap.containsKey(removeIdx)) {
                MenuItem removeMenuItem = basketMap.get(removeIdx);
                MenuCategory category = categoryMap.get(removeIdx);
                // 삭제 메서드
                removeItem.put(category, removeMenuItem);
                return removeItem;
            }

        } catch (Exception e) {
            System.out.println("오류가 발생했습니다!" + e.getMessage());
        }
        return removeItem;
    }

    // 장바구니 비우기
    public void clearBasket() {
        menuBasket.clear();
        setMenuBasket();
    }
    // 카테고리별 장바구니보기
    public void viewBasketByCategory(){
        int cnt=0;
        basketMap = new HashMap<>();
        categoryMap = new HashMap<>(); // 삭제 시 필요한 카테고리 저장

        System.out.println("\uD83D\uDED2 장바구니 내역");
        for (MenuCategory category : MenuCategory.values()) {
            List<MenuItem> menuItems = menuBasket.get(category);

            //
            if (!menuItems.isEmpty()) {
                System.out.println("[ " + category + " ] 메뉴");
                for (MenuItem menuItem : menuItems) {
                    System.out.println((cnt+1) + "번째 메뉴\t음식명: " + menuItem.getName() +
                            ", 가격: " + menuItem.getPrice() );
                    basketMap.put(cnt, menuItem);
                    categoryMap.put(cnt, category);
                    cnt++;
                }
            }
        }
        System.out.println("총 금액: "+getTotalSum()+"💲입니다.");
    }

    public double getTotalSum() {
        return totalSum;
    }
}
