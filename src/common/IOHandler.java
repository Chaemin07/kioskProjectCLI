package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOHandler {
    private BufferedReader br;

    public IOHandler() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    // 문자열 입력 받기
    public String inputString(String prompt) throws Exception{
        System.out.println(prompt);
        return br.readLine();
    }
    // 정수 입력 받기
    public int inputInt(String prompt)throws Exception{
        while(true){
            try{
                System.out.println(prompt);
                // 공백 제거
                return Integer.parseInt(br.readLine().trim());
            }
            catch(Exception e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요."+e.getMessage());
            }
        }
    }

}
