package lv1.kiosk;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        boolean mainFlag = false;
        File menuFile = new File("./");
        String menu = "";
        printAsciiArt();
        printMenu();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        URL resource = FileTest.class.getClassLoader().getResource("test.txt");
//        // 파일 없다면 에러
//        if (resource == null) {
//            throw new IllegalArgumentException("Resource not found: test.txt");
//        }
//        File file = new File(resource.toURI().getPath());
        // Scanner로 파일 입출력
//        Scanner sc = new Scanner(file);

//        while (sc.hasNext()) {
//            String string = sc.nextLine();
//            System.out.println(string);
//        }
//        sc = new Scanner(System.in);
//        System.out.println("메뉴를 선택해주세요");
//        String string = sc.nextLine();
//        System.out.println("선택한 메뉴는 = " + string);

        // BufferedReader로 파일 입출력
        // 클래스 패스 내부의 리소스만 읽을 경우
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("test.txt");
        System.out.println("메뉴 출력");
        List<String> menuList = printMenu(inputStream);
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i+1)+"번째 메뉴는 "+menuList.get(i));
        }
        System.out.println("메뉴를 선택해주세요");
        String s = br.readLine();
        // 1번부터 입력 -1처리
        int idx = Integer.parseInt(s)-1;
//        System.out.println("선택한 메뉴는 = " + menuList.get(idx));
        while (mainFlag) {
//            menu = sc.next().charAt(0);
            switch (menu){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("다시 입력해 주세요!");
                    break;

            }
            printMenu();

        }



    }
    static void printAsciiArt() {

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
                "                                                \n" +
                "                                                \n" +
                "                                                \n"
        };
        for (String data : acsiiArt) {
//            System.out.println();
            System.out.println(data);
        }

    }
    static void printMenu(){
        System.out.println("🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰");
        System.out.println("1\uFE0F⃣. 메뉴 보기");
        System.out.println("2\uFE0F⃣. 장바구니");
        System.out.println("3\uFE0F⃣. 결제하기");
        System.out.println("4\uFE0F⃣. 종료: \"exit\", \"q\",\"Q\" 입력하기");
    }
    static List<String> printMenu(InputStream inputStream) throws Exception {
        // Index 0 out of bounds for length 0 인덱스 오류 처리해야함
        List<String> menuList = new ArrayList<>();
        if (inputStream != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            // 파일에 저장된 메뉴들 한 줄씩 출력
            while ((line = br.readLine()) != null) {
                menuList.add(line);
            }
            br.close();
        } else {
            System.out.println("파일 없음");
        }
        return menuList;
    }

}
