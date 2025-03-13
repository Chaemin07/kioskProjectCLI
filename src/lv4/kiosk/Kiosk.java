package lv4.kiosk;
import common.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static common.MenuCategory.*;

public class Kiosk {
    // 속성
    private List<Menu> menuList;
    boolean mainFlag = true;
    boolean kioskMenuFlag = true;
    boolean restaurantMenuFlag = true;
    private IOHandler ioHandler;
    private String line = "🟰".repeat(50);


    public Kiosk(String[] files) {
        this.ioHandler = new IOHandler();
        FileIOHandler fileIOHandler = new FileIOHandler();
        List<Menu> menuList = new ArrayList<>();
        MenuCategory category = null;
        for (String file : files) {
            if (file.contains("hamburger")) {
                category = HAMBURGER;
            } else if (file.contains("drink")) {
                category = DRINK;
            }else if (file.contains("dessert")) {
                category = MenuCategory.DESSERT;
            }
            List<MenuItem> loadedMenuList = fileIOHandler.loadMenuList(file);
            menuList.add(new Menu(category,loadedMenuList));
        }
        this.menuList = menuList;

    }

    // 메서드
    public List<Menu> getMenuList() {
        return menuList;
    }
    boolean getmainFlag(){
        return mainFlag;
    }
    void printAsciiArt() {

        String[] acsiiArt = {"\n" +
                " __    __  ______   ______    ______   __    __ \n" +
                "/  |  /  |/      | /      \\  /      \\ /  |  /  |\n" +
                "$$ | /$$/ $$$$$$/ /$$$$$$  |/$$$$$$  |$$ | /$$/ \n" +
                "$$ |/$$/    $$ |  $$ |  $$ |$$ \\__$$/ $$ |/$$/  \n" +
                "$$  $$<     $$ |  $$ |  $$ |$$      \\ $$  $$<   \n" +
                "$$$$$  \\    $$ |  $$ |  $$ | $$$$$$  |$$$$$  \\  \n" +
                "$$ |$$  \\  _$$ |_ $$ \\__$$ |/  \\__$$ |$$ |$$  \\ \n" +
                "$$ | $$  |/ $$   |$$    $$/ $$    $$/ $$ | $$  |\n" +
                "$$/   $$/ $$$$$$/  $$$$$$/   $$$$$$/  $$/   $$/ \n" +
                "                                                \n"
        };
        for (String data : acsiiArt) {
            System.out.println(data);
        }
    }
    void printKioskMenu() {
        System.out.println(line);
        System.out.println("1\uFE0F⃣. 메뉴 보기");
        System.out.println("2\uFE0F⃣. 장바구니");
        System.out.println("3\uFE0F⃣. 결제하기");
        System.out.println("4\uFE0F⃣. 종료하기");
    }



    // Main에서 호출 default
    void start(int selectMenuNum) throws Exception {
        // enum으로 맵핑된 값
        KioskMenu selectedKioskMenuNum = KioskMenu.valueOfCode(selectMenuNum);
        String prompt = "원하는 메뉴 번호를 입력하세요:\n입력 >> ";

        switch (selectedKioskMenuNum){
            case VIEW_MENU:     // 음식 메뉴 보기:
                // 음식 카테고리 출력
                viewRestaurantMenuList();
                System.out.println(line);
                // 사용자 입력 - 카테고리 선택
                selectMenuNum = ioHandler.inputInt(prompt, 4);
                // enum으로 맵핑된 값
                MenuCategory restCategory= MenuCategory.valueOfCode(selectMenuNum);
                restaurantMenuFlag=true;
                while(restaurantMenuFlag){
                    int idx = 0;
                    switch(restCategory){
                        case HAMBURGER:     // 햄버거 메뉴 보기
                            System.out.println("햄버거 메뉴를 선택하셨습니다.");
                            System.out.println(line);
                            Menu Hamburger = menuList.get(HAMBURGER.getCode()-1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Hamburger, prompt);
                            restaurantMenuFlag=false;
                            break;

                        case DRINK:         // 드링크 메뉴 보기:
                            System.out.println("드링크 메뉴를 선택하셨습니다.");
                            System.out.println(line);
                            Menu Drink = menuList.get(DRINK.getCode()-1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Drink, prompt);
                            restaurantMenuFlag=false;
                            break;

                        case DESSERT:       // 디저트 메뉴 보기:
                            System.out.println("디저트 메뉴를 선택하셨습니다.");
                            System.out.println(line);
                            Menu Dessert = menuList.get(DESSERT.getCode()-1);

                            // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
                            selectAndShowFoodMenuItem(Dessert, prompt);
                            restaurantMenuFlag=false;
                            break;
                        case BACK:          // 뒤로가기
                            System.out.println("뒤로가기를 선택하셨습니다.");
                            restaurantMenuFlag=false;
                            break;
                        default:
                            System.out.println("입력이 올바르지 않습니다!");
                            break;
                    }
                }
                break;

            case CART:          // 장바구니
                System.out.println("테스트 장바구니 입니다.");
                break;

            case CHECKOUT:      // 결제하기
                System.out.println("테스트 결제 화면입니다.");
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
        System.out.println("1\uFE0F⃣. 햄버거 메뉴");
        System.out.println("2\uFE0F⃣. 드링크 메뉴");
        System.out.println("3\uFE0F⃣. 디저트 메뉴");
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
    private void viewRestaurantMenu(Menu menuList){
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
    private void printRestaurantMenu(MenuItem menuElement,int idx) {
        System.out.println(idx+"번 메뉴를 선택하셨습니다.");
        System.out.println("음식명: " + menuElement.getName() +
                ", 가격: " + menuElement.getPrice() + ", 음식 정보: " + menuElement.getMenuInfo());
    }

    // 메뉴 보기, 메뉴 선택하기, 선택한 메뉴 출력
    private void selectAndShowFoodMenuItem(Menu menuCategory,String prompt) throws IOException {
        // 메뉴 보기
        viewRestaurantMenu(menuCategory);
        System.out.println(line);
        // 메뉴 고르기
        int idx = ioHandler.inputInt(prompt, menuCategory.getMenuItem().size())-1;
        // 선택한 메뉴 출력
        printRestaurantMenu(menuCategory.getMenuItem().get(idx), idx+1);
    }
}
