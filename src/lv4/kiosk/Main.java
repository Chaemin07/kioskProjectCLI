package lv4.kiosk;

import common.IOHandler;

public class Main {
    public static void main(String[] args) throws Exception{
        IOHandler ioHandler = new IOHandler();
        String[] files = {"common/hamburgerMenu.txt",
                "common/drinkMenu.txt","common/dessertMenu.txt"};
        String prompt = "원하는 메뉴 번호를 입력하세요:\n입력 >> ";

        int selectMenuNum = 0;
        boolean mainFlag = true;

        Kiosk kiosk = new Kiosk(files);

        // 키오스크 아스키 아트 출력
        kiosk.printAsciiArt();


        while (mainFlag) {
            // 메뉴 보기
            kiosk.printKioskMenu();
            //  입력 →  정수인지 체크 - 예외처리
            selectMenuNum = ioHandler.inputInt(prompt, 4);
            System.out.println(selectMenuNum+"번을 선택하셨습니다.");
            try {
                kiosk.start(selectMenuNum);
            } catch (IllegalArgumentException e) {
                // 오류 코드
                System.out.println("잘못된 입력입니다! → "+e.getMessage());
            }
            mainFlag = kiosk.getmainFlag();
        }
        ioHandler.close();
    }
}
