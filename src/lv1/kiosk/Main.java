//package lv1.kiosk;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//// 메뉴 enum import
//import common.Menu;
//
//
//public class Main {
//    public static void main(String[] args) throws Exception{
//        boolean mainFlag = true;
//        String menu = "";
//        int selectMenuNum = 0;
//        printAsciiArt();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
////        URL resource = FileTest.class.getClassLoader().getResource("test.txt");
////        // 파일 없다면 에러
////        if (resource == null) {
////            throw new IllegalArgumentException("Resource not found: test.txt");
////        }
////        File file = new File(resource.toURI().getPath());
//        // Scanner로 파일 입출력
////        Scanner sc = new Scanner(file);
//
////        while (sc.hasNext()) {
////            String string = sc.nextLine();
////            System.out.println(string);
////        }
////        sc = new Scanner(System.in);
////        System.out.println("메뉴를 선택해주세요");
////        String string = sc.nextLine();
////        System.out.println("선택한 메뉴는 = " + string);
//
//        // BufferedReader로 파일 입출력
//        // 클래스 패스 내부의 리소스만 읽을 경우
//
////        String s = br.readLine();
//        // 1번부터 입력 -1처리

import java.io.InputStream;

/// /        int idx = Integer.parseInt(s)-1;
/// /        System.out.println("선택한 메뉴는 = " + menuList.get(idx));
//        while (mainFlag) {
//            // 메뉴 보기
//            printMenu();
//            // 설명 출력
//            System.out.println("원하는 메뉴 번호를 입력하세요 (1~3, 종료는 4):");
//            System.out.print("입력 >> "); // 입력 유도 메시지
//
//            //  입력 정수인지 체크 - 예외처리
//            if (isInteger(menu = br.readLine())) {
//                selectMenuNum = Integer.parseInt(menu);
//            }else{
//                continue;
//            }
//            try {
//                // 입력받아
//                Menu selectedMenu = Menu.valueOfCode(selectMenuNum);
//                switch (selectedMenu){
//                    case VIEW_MENU:     // 음식 메뉴 보기
//                        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources.common/test.txt");
//                        System.out.println("메뉴 출력");
//                        // TODO string -> menuItem클래스로 변경 필요
//                        List<String> menuList = getMenuListFromFile(inputStream);
//                        // menuList
//                        for (int i = 0; i < menuList.size(); i++) {
//                            System.out.println((i+1)+"번째 메뉴는 "+menuList.get(i));
//                        }
//                        System.out.println("테스트 메뉴를 선택해주세요");
//                        break;
//
//                    case CART:          // 장바구니
//                        System.out.println("테스트 장바구니 입니다.");
//                        break;
//
//                    case CHECKOUT:      // 결제하기
//                        System.out.println("테스트 결제 화면입니다.");
//                        break;
//
//                    case EXIT:          // 종료
//                        mainFlag = false;
//                        break;
//
//                        // try-catch로 switch문 이외의 입력을 잡을텐데
//                        // default가 필요한가?
//                    default:
//                        System.out.println("다시 입력해 주세요!");
//                        break;
//
//                }
//
//            } catch (IllegalArgumentException e) {
//                // 오류 코드
//                System.out.println("잘못된 입력입니다! → "+e.getMessage());
//            }
//        }
//
//
//
//    }
//    static void printAsciiArt() {
//
//        String[] acsiiArt = {"\n" +
//                " __    __  ______   ______    ______   __    __ \n" +
//                "/  |  /  |/      | /      \\  /      \\ /  |  /  |\n" +
//                "$$ | /$$/ $$$$$$/ /$$$$$$  |/$$$$$$  |$$ | /$$/ \n" +
//                "$$ |/$$/    $$ |  $$ |  $$ |$$ \\__$$/ $$ |/$$/  \n" +
//                "$$  $$<     $$ |  $$ |  $$ |$$      \\ $$  $$<   \n" +
//                "$$$$$  \\    $$ |  $$ |  $$ | $$$$$$  |$$$$$  \\  \n" +
//                "$$ |$$  \\  _$$ |_ $$ \\__$$ |/  \\__$$ |$$ |$$  \\ \n" +
//                "$$ | $$  |/ $$   |$$    $$/ $$    $$/ $$ | $$  |\n" +
//                "$$/   $$/ $$$$$$/  $$$$$$/   $$$$$$/  $$/   $$/ \n" +
//                "                                                \n"
//        };
//        for (String data : acsiiArt) {
////            System.out.println();
//            System.out.println(data);
//        }
//
//    }
//    static void printMenu(){
//        System.out.println("🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰");
//        System.out.println("1\uFE0F⃣. 메뉴 보기");
//        System.out.println("2\uFE0F⃣. 장바구니");
//        System.out.println("3\uFE0F⃣. 결제하기");
//        System.out.println("4\uFE0F⃣. 종료: \"exit\", \"q\",\"Q\" 입력하기");
//    }
//    //
//    static List<String> getMenuListFromFile(InputStream inputStream) throws Exception {
//        // Index 0 out of bounds for length 0 인덱스 오류 처리해야함
//        List<String> menuList = new ArrayList<>();
//        if (inputStream != null) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            // 파일에 저장된 메뉴들 한 줄씩 출력
//            while ((line = br.readLine()) != null) {
//                menuList.add(line);
//            }
//            br.close();
//        } else {
//            System.out.println("파일 없음");
//        }
//        return menuList;
//    }
//
//    static boolean isInteger(String selectMenuNum) {
//        try {
//            // 정수 + 메뉴번호 ( 1 ~ 4 )
//            if((Integer.parseInt(selectMenuNum)<=4) && Integer.parseInt(selectMenuNum)>=1){
//                return true;
//            }else{
//                System.out.println("입력이 올바르지 않습니다!");
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("입력이 올바르지 않습니다!");
//            return false;
//        }
//    }
//
//}
