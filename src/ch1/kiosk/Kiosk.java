package ch1.kiosk;

import common.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static common.MenuCategory.*;

public class Kiosk {
    // 속성
    private List<Menu> menuList;
    private final IOHandler ioHandler;
    private OrderBasket orderBasket;
    private Payment payment;

    boolean mainFlag = true;
    private boolean restaurantMenuFlag = true;
    private boolean cartFlag =true;
    private String line = "🟰".repeat(57);
    private String prompt = "";

    public String[] getAcsiiArtKIOSK() {
        return ioHandler.getAcsiiArtKIOSK();
    }

    public Kiosk(String[] files) {
        ioHandler = new IOHandler();
        FileIOHandler fileIOHandler = new FileIOHandler();
        menuList = new ArrayList<>();
        orderBasket = new OrderBasket();
        payment = new Payment(ioHandler);
        // null 초기화
        MenuCategory category = null;
        for (String file : files) {
            if (file.contains("hamburger")) {
                category = HAMBURGER;
            } else if (file.contains("drink")) {
                category = DRINK;
            } else if (file.contains("dessert")) {
                category = MenuCategory.DESSERT;
            }
            List<MenuItem> loadedMenuList = fileIOHandler.loadMenuList(file);
            menuList.add(new Menu(category, loadedMenuList));
        }
    }


    // 메서드
    public List<Menu> getMenuList() {
        return menuList;
    }

    boolean getmainFlag() {
        return mainFlag;
    }

    void printAsciiArt(String[] asciiArt) {
        for (String data : asciiArt) {
            System.out.println(data);
        }
    }

    void printKioskMenu() {
        System.out.println(line);
        System.out.println("1\uFE0F⃣. \uD83C\uDF7D\uFE0F 메뉴 보기");
        System.out.println("2\uFE0F⃣. 🧺 장바구니");
        System.out.println("3\uFE0F⃣. \uD83D\uDCB3 결제하기");
        System.out.println("4\uFE0F⃣. \uD83D\uDD1A 종료하기");
    }


    // Main에서 호출 default
    void start(int selectMenuNum) throws Exception {
        // enum으로 맵핑된 값
        KioskMenu selectedKioskMenuNum = KioskMenu.valueOfCode(selectMenuNum);
        prompt = "원하는 메뉴 번호를 입력하세요:\n입력 >> ";

        switch (selectedKioskMenuNum) {
            case VIEW_MENU:     // 음식 메뉴 보기:
                // 음식 카테고리 출력
                viewRestaurantMenuList();
                System.out.println(line);
                // 사용자 입력 - 카테고리 선택
                selectMenuNum = ioHandler.inputInt(prompt, 4);
                // enum으로 맵핑된 값
                MenuCategory restCategory = MenuCategory.valueOfCode(selectMenuNum);
                restaurantMenuFlag = true;
                while (restaurantMenuFlag) {
                    int idx = 0;
                    switch (restCategory) {
                        case HAMBURGER:     // 햄버거 메뉴 보기
                            printAsciiArt(ioHandler.getAsciiArtHAMBURGER());
                            System.out.println(line);
                            Menu Hamburger = menuList.get(HAMBURGER.getCode() - 1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Hamburger, prompt);

                            restaurantMenuFlag = false;
                            break;

                        case DRINK:         // 드링크 메뉴 보기:
                            printAsciiArt(ioHandler.getAsciiArtDRINK());
                            System.out.println(line);
                            Menu Drink = menuList.get(DRINK.getCode() - 1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Drink, prompt);
                            restaurantMenuFlag = false;
                            break;

                        case DESSERT:       // 디저트 메뉴 보기:
                            printAsciiArt(ioHandler.getAsciiArtDESSERT());
                            System.out.println(line);
                            Menu Dessert = menuList.get(DESSERT.getCode() - 1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Dessert, prompt);
                            restaurantMenuFlag = false;
                            break;
                        case BACK:          // 뒤로가기
                            printAsciiArt(ioHandler.getAsciiArtBACK());
                            restaurantMenuFlag = false;
                            break;
                        default:
                            System.out.println("입력이 올바르지 않습니다!");
                            break;
                    }
                }
                break;

            case VIEW_CART:          // 장바구니:
                // 장바구니 보기
                cartFlag=true;
                while (cartFlag) {
                    prompt = "장바구니에서 삭제할 항목이 있으십니까? (Y or N)\n>> ";
                    printAsciiArt(ioHandler.getAsciiArtCART());
                    System.out.println(line);
                    // 장바구니 보기
                    orderBasket.viewBasketByCategory();
                    try {
                        if (orderBasket.getTotalSum() == 0) {
                            System.out.println("🛒 장바구니가 비어 있습니다. 뒤로 돌아갑니다.");
                            break;
                        }
                        String answer = ioHandler.isValidAnswer(prompt);
                        // 취소할 메뉴가 있다면?
                        if (answer.equals("Y") || answer.equals("y")) {
                            Map<MenuCategory, MenuItem> removeItemMap = orderBasket.findRemoveItem();
                            for (Map.Entry<MenuCategory, MenuItem> entry : removeItemMap.entrySet()) {
                                prompt = entry.getValue().getName() + "를 삭제하시겠습니까? Y or N)\n>> ";
                                answer = ioHandler.inputString(prompt);
                                if (answer.equalsIgnoreCase("Y")) { // 대소문자 구분 x
                                    orderBasket.removeItem(removeItemMap);
                                }else{
                                    System.out.println("뒤로 돌아갑니다.");
                                    cartFlag =false;
                                }
                            }
                            // 선택한 메뉴 출력
                        } else if (answer.equals("N") || answer.equals("n")) {
                            System.out.println("뒤로 돌아갑니다.");
                            cartFlag =false;
                        }
                    } catch (Exception e) {
                        System.out.println("오류가 발생했습니다!" + e.getMessage());
                    }
                }
                break;

            case CHECKOUT:      // 결제하기, 주문하기
                prompt = "주문 하시겠습니까? (y or n)\n>> ";
                printAsciiArt(ioHandler.getAsciiArtCHECKOUT());
                String answer = ioHandler.isValidAnswer(prompt);
                try{
                    if (answer.equalsIgnoreCase("y")) {
                        payment.startPaymentProcess(orderBasket);
                        printAsciiArt(ioHandler.getAsciiArtMessage());
                    } else if (answer.equalsIgnoreCase("n")) {
                        System.out.println("뒤로 돌아갑니다.");
                    }

                } catch (Exception e) {
                    System.out.println("오류가 발생했습니다!" + e.getMessage());
                }
                break;

            case EXIT:          // 종료
                mainFlag = false;
                System.out.println("키오스크를 종료합니다.");
                break;

            // try-catch로 switch문 이외의 입력을 잡을텐데
            // default가 필요한가?
            default:
                System.out.println("다시 입력해 주세요!");
                break;

        }
    }

    // 음식 메뉴 출력
    private void viewRestaurantMenuList() {
        System.out.println(line);
        System.out.println("1\uFE0F⃣. \uD83C\uDF54 햄버거 메뉴");
        System.out.println("2\uFE0F⃣. 🍹 드링크 메뉴");
        System.out.println("3\uFE0F⃣. 🍮 디저트 메뉴");
        System.out.println("4\uFE0F⃣. 뒤로가기");

    }

    // 메뉴(Menu클래스) 유효성 검사
    private boolean isValidMenuList() {
        if (menuList == null || menuList.isEmpty()) {
            System.out.println("메뉴 목록이 비어 있습니다.");
            return false;
        }
        return true;
    }

    //  카테고리 음식 - 전부 출력
    private void viewRestaurantMenu(Menu menuList) {
        if (isValidMenuList()) {
            MenuItem menu;
            for (int i = 0; i < menuList.getMenuItem().size(); i++) {
                menu = menuList.getMenuItem().get(i);
                System.out.println((i + 1) + "번째 메뉴\n음식명: " + menu.getName() +
                        ", 가격: " + menu.getPrice() + ", 음식 정보: " + menu.getMenuInfo());
            }
        }
    }

    // 음식 메뉴(MenuItem menuElement) 출력
    private void printRestaurantMenu(MenuItem menuElement, int idx) {
        System.out.println(idx + "번 메뉴를 선택하셨습니다.");
        System.out.println("음식명: " + menuElement.getName() +
                ", 가격: " + menuElement.getPrice() + ", 음식 정보: " + menuElement.getMenuInfo());
    }

    // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
    private void selectAndShowFoodMenuItem(Menu menuCategory, String prompt) throws IOException {
        // 메뉴 보기
        viewRestaurantMenu(menuCategory);
        System.out.println(line);
        // 메뉴 고르기
        int idx = ioHandler.inputInt(prompt, menuCategory.getMenuItem().size()) - 1;
        try {
            printRestaurantMenu(menuCategory.getMenuItem().get(idx), idx + 1);
            String basketPrompt = "\uD83D\uDED2 "+menuCategory.getMenuItem().get(idx).getName()+ "를 장바구니에 추가 하시겠습니까? (Y or N)\n>> ";
            String answer = ioHandler.isValidAnswer(basketPrompt);
            if (answer.equals("Y") || answer.equals("y")) {
                orderBasket.addItem(menuCategory.getCategory(), menuCategory.getMenuItem().get(idx));
                // 선택한 메뉴 출력
            } else if (answer.equals("N") || answer.equals("n")) {
                System.out.println("❌ 메뉴 추가가 취소되었습니다. 뒤로 돌아갑니다.");
            }
        }catch(Exception e){
            System.out.println("오류가 발생했습니다." + e.getMessage());
        }
    }
}
