package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOHandler {
    private BufferedReader br;

    public IOHandler() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    // 문자열 입력 받기
    public String inputString(String prompt) throws IOException {
        System.out.print(prompt);
        return br.readLine();
    }
    // 정수 입력 받기
    public int inputInt(String prompt,int Max)throws IOException{
        while(true){
            try{
                String inputValue = inputString(prompt);
                if (isValidInteger(inputValue, Max)) {
                    return Integer.parseInt(inputValue);
                }
            }
            catch(Exception e){
                System.out.println("입력이 올바르지 않습니다! 다시 입력해주세요!"+e.getMessage());
            }
        }
    }

    boolean isValidInteger(String selectedMenuNum,int Max) {
        try {
            // 정수 + 메뉴번호 (1 ~ listSize)
            if((Integer.parseInt(selectedMenuNum)<=Max) && Integer.parseInt(selectedMenuNum)>=1){
                return true;
            }else{
                System.out.println("입력이 올바르지 않습니다! 다시 입력해주세요!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("입력이 올바르지 않습니다! 다시 입력해주세요!");
            return false;
        }
    }

    public void close() throws IOException{
        br.close();
    }

}
