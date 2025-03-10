package lv3.kiosk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// 공통 패키지 import
import common.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";
        int selectMenuNum = 0;
        boolean mainFlag = true;

        // NULL 초기화 주의
        Kiosk kiosk = new Kiosk();
        List<MenuItem> menuList = new ArrayList<>();

        // 키오스크 아스키 아트 출력
        kiosk.printAsciiArt();

        // try-resource
        try(InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("common/test.txt")){
            if (inputStream == null) {
                System.out.println("파일을 찾을 수 없습니다!");
            } else {
                System.out.println("공통 파일이 정상적으로 로드되었습니다.");
                // txtFile → kiost.menuList 초기화
                kiosk.getMenuListFromFile(inputStream);
            }

        }catch(Exception e){
            System.out.println("파일을 찾을 수 없습니다!");
        }
        while (mainFlag) {
            // 메뉴 보기
            kiosk.printMenu();
            // 설명 출력
            System.out.println("원하는 메뉴 번호를 입력하세요 (1~3, 종료는 4):");
            System.out.print("입력 >> "); // 입력 유도 메시지
            //  입력 →  정수인지 체크 - 예외처리
            if (isMenuNumInteger(menu = br.readLine())) {
                selectMenuNum = Integer.parseInt(menu);
            }else{
                continue;
            }
            System.out.println(selectMenuNum+"번 메뉴를 선택하셨습니다.");
            try {
                kiosk.start(selectMenuNum);
            } catch (IllegalArgumentException e) {
                // 오류 코드
                System.out.println("잘못된 입력입니다! → "+e.getMessage());
            }
            mainFlag = kiosk.getmainFlag();
        }
        br.close();
    }


    static boolean isMenuNumInteger(String selectMenuNum) {
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

}
