package lv3.kiosk;
import common.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Kiosk {
    // 속성
    private List<MenuItem> menuList;
    boolean mainFlag = true;
    boolean menuFlag = true;



    // 메서드
    public List<MenuItem> getMenuList() {
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
    void printMenu() {
        System.out.println("🟰".repeat(50));
        System.out.println("1\uFE0F⃣. 메뉴 보기");
        System.out.println("2\uFE0F⃣. 장바구니");
        System.out.println("3\uFE0F⃣. 결제하기");
        System.out.println("4\uFE0F⃣. 종료하기");
    }

    // Main에서 호출 default
    void getMenuListFromFile(InputStream inputStream) throws Exception {

        this.menuList = new ArrayList<>();
        if (inputStream != null) {
            // 파일 출력
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            // 파일에 저장된 메뉴들 한 줄씩 출력
            while ((line = br.readLine()) != null) {
                menuList.add(parseMenuItem(line));
            }
            br.close();
        } else {
            System.out.println("파일 없음");
        }
    }

    // Main에서 호출 default
    void start(int selectMenuNum){
        // enum으로 맵핑된 값
        KioskMenu selectedKioskMenu = KioskMenu.valueOfCode(selectMenuNum);
        // 초기화
        MenuItem menuElement = null;
        String menu = "";

        switch (selectedKioskMenu){
            case VIEW_MENU:     // 음식 메뉴 보기
                System.out.println("🟰".repeat(50));
                // menuList 출력
                viewMenuList();
                System.out.println("🟰".repeat(50));
                // menuFlag 초기화
                menuFlag = true;
                while(menuFlag){
                    try {
                        System.out.println("원하는 메뉴 번호를 입력하세요 ( 1 ~ 4 ):");
                        System.out.print("입력 >> "); // 입력 유도 메시지
                        // TODO 메뉴 추가시 유효성 범위 늘려야함 - 현재 4까지
                        if (isMenuNumInteger(menu = inputMenu())) {
                            selectMenuNum = Integer.parseInt(menu);
                            menuFlag = false;
                        }
                    } catch (Exception e) {
                        System.out.println("다시 입력해주세요!");
                    }
                }
                // 1부터 시작이라 -1
                menuElement = menuList.get(selectMenuNum - 1);
                System.out.println(selectMenuNum+"번 메뉴를 선택하셨습니다.");
                System.out.println("음식명: " + menuElement.getName() +
                        ", 가격: " + menuElement.getPrice() + ", 음식 정보: " + menuElement.getMenuInfo());
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
    private void viewMenuList() {
        MenuItem menu;
        // 유효성 검사
        if(isValidMenuList())
        {
            for (int i = 0; i < menuList.size(); i++) {
                menu = menuList.get(i);
                System.out.println((i + 1) + "번째 메뉴\n음식명: " + menu.getName() +
                        ", 가격: " + menu.getPrice() + ", 음식 정보: " + menu.getMenuInfo());
            }
        }
    }

    // 메뉴 번호 유효성 검사
    private boolean isMenuNumInteger(String selectMenuNum) {
        try {
            // 정수 + 메뉴번호 ( 1 ~ 4 )
            if((Integer.parseInt(selectMenuNum)<=4) && Integer.parseInt(selectMenuNum)>=1){
                return true;
            }else{
                System.out.println("입력이 올바르지 않습니다!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("입력이 올바르지 않습니다!");
            return false;
        }
    }

    // 유효성 검사
    private boolean isValidMenuList() {
        if (menuList == null || menuList.isEmpty()) {
            System.out.println("메뉴 목록이 비어 있습니다.");
            return false;
        }
        return true;
    }
    private String inputMenu() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private MenuItem parseMenuItem(String line) {
        String menuName = "";
        String price = "";
        String menuInfo = "";
        StringTokenizer st = new StringTokenizer(line, "|");
        menuName = st.nextToken().trim();
        // 현재 price에는 "W ~.~"가 저장됨 쪼개야함
        price = st.nextToken().trim();
        StringTokenizer priceTokenizer = new StringTokenizer(price);
        priceTokenizer.nextToken();
        price = priceTokenizer.nextToken();
        menuInfo = st.nextToken().trim();

        return new MenuItem(menuName,price,menuInfo);
    }

}
