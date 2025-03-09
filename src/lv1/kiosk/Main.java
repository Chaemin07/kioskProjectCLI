package lv1.kiosk;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean mainFlag = false;
        File menuFile = new File("./");
        String menu = "";
        printAsciiArt();
        printMenu();
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


}
