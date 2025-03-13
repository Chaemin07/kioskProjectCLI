package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOHandler {
    private BufferedReader br;

    private final String[] acsiiArtKIOSK = {"\n" +
            " __    __  ______   ______    ______   __    __ \n" +
            "/  |  /  |/      | /      \\  /      \\ /  |  /  |\n" +
            "$$ | /$$/ $$$$$$/ /$$$$$$  |/$$$$$$  |$$ | /$$/ \n" +
            "$$ |/$$/    $$ |  $$ |  $$ |$$ \\__$$/ $$ |/$$/  \n" +
            "$$  $$<     $$ |  $$ |  $$ |$$      \\ $$  $$<   \n" +
            "$$$$$  \\    $$ |  $$ |  $$ | $$$$$$  |$$$$$  \\  \n" +
            "$$ |$$  \\  _$$ |_ $$ \\__$$ |/  \\__$$ |$$ |$$  \\ \n" +
            "$$ | $$  |/ $$   |$$    $$/ $$    $$/ $$ | $$  |\n" +
            "$$/   $$/ $$$$$$/  $$$$$$/   $$$$$$/  $$/   $$/ "};
    private final String[] asciiArtHAMBURGER = {"\n" +
            " __    __   ______   __       __  _______   __    __  _______    ______   ________  _______  \n" +
            "/  |  /  | /      \\ /  \\     /  |/       \\ /  |  /  |/       \\  /      \\ /        |/       \\ \n" +
            "$$ |  $$ |/$$$$$$  |$$  \\   /$$ |$$$$$$$  |$$ |  $$ |$$$$$$$  |/$$$$$$  |$$$$$$$$/ $$$$$$$  |\n" +
            "$$ |__$$ |$$ |__$$ |$$$  \\ /$$$ |$$ |__$$ |$$ |  $$ |$$ |__$$ |$$ | _$$/ $$ |__    $$ |__$$ |\n" +
            "$$    $$ |$$    $$ |$$$$  /$$$$ |$$    $$< $$ |  $$ |$$    $$< $$ |/    |$$    |   $$    $$< \n" +
            "$$$$$$$$ |$$$$$$$$ |$$ $$ $$/$$ |$$$$$$$  |$$ |  $$ |$$$$$$$  |$$ |$$$$ |$$$$$/    $$$$$$$  |\n" +
            "$$ |  $$ |$$ |  $$ |$$ |$$$/ $$ |$$ |__$$ |$$ \\__$$ |$$ |  $$ |$$ \\__$$ |$$ |_____ $$ |  $$ |\n" +
            "$$ |  $$ |$$ |  $$ |$$ | $/  $$ |$$    $$/ $$    $$/ $$ |  $$ |$$    $$/ $$       |$$ |  $$ |\n" +
            "$$/   $$/ $$/   $$/ $$/      $$/ $$$$$$$/   $$$$$$/  $$/   $$/  $$$$$$/  $$$$$$$$/ $$/   $$/ "};
    private final String[] asciiArtDRINK={"\n" +
            " _______   _______   ______  __    __  __    __ \n" +
            "/       \\ /       \\ /      |/  \\  /  |/  |  /  |\n" +
            "$$$$$$$  |$$$$$$$  |$$$$$$/ $$  \\ $$ |$$ | /$$/ \n" +
            "$$ |  $$ |$$ |__$$ |  $$ |  $$$  \\$$ |$$ |/$$/  \n" +
            "$$ |  $$ |$$    $$<   $$ |  $$$$  $$ |$$  $$<   \n" +
            "$$ |  $$ |$$$$$$$  |  $$ |  $$ $$ $$ |$$$$$  \\  \n" +
            "$$ |__$$ |$$ |  $$ | _$$ |_ $$ |$$$$ |$$ |$$  \\ \n" +
            "$$    $$/ $$ |  $$ |/ $$   |$$ | $$$ |$$ | $$  |\n" +
            "$$$$$$$/  $$/   $$/ $$$$$$/ $$/   $$/ $$/   $$/ "};
    private final String[] asciiArtDESSERT={"\n" +
            " _______   ________   ______    ______   ________  _______   ________ \n" +
            "/       \\ /        | /      \\  /      \\ /        |/       \\ /        |\n" +
            "$$$$$$$  |$$$$$$$$/ /$$$$$$  |/$$$$$$  |$$$$$$$$/ $$$$$$$  |$$$$$$$$/ \n" +
            "$$ |  $$ |$$ |__    $$ \\__$$/ $$ \\__$$/ $$ |__    $$ |__$$ |   $$ |   \n" +
            "$$ |  $$ |$$    |   $$      \\ $$      \\ $$    |   $$    $$<    $$ |   \n" +
            "$$ |  $$ |$$$$$/     $$$$$$  | $$$$$$  |$$$$$/    $$$$$$$  |   $$ |   \n" +
            "$$ |__$$ |$$ |_____ /  \\__$$ |/  \\__$$ |$$ |_____ $$ |  $$ |   $$ |   \n" +
            "$$    $$/ $$       |$$    $$/ $$    $$/ $$       |$$ |  $$ |   $$ |   \n" +
            "$$$$$$$/  $$$$$$$$/  $$$$$$/   $$$$$$/  $$$$$$$$/ $$/   $$/    $$/    "};
    private final String[] asciiArtBACK = {"\n" +
            " _______    ______    ______   __    __ \n" +
            "/       \\  /      \\  /      \\ /  |  /  |\n" +
            "$$$$$$$  |/$$$$$$  |/$$$$$$  |$$ | /$$/ \n" +
            "$$ |__$$ |$$ |__$$ |$$ |  $$/ $$ |/$$/  \n" +
            "$$    $$< $$    $$ |$$ |      $$  $$<   \n" +
            "$$$$$$$  |$$$$$$$$ |$$ |   __ $$$$$  \\  \n" +
            "$$ |__$$ |$$ |  $$ |$$ \\__/  |$$ |$$  \\ \n" +
            "$$    $$/ $$ |  $$ |$$    $$/ $$ | $$  |\n" +
            "$$$$$$$/  $$/   $$/  $$$$$$/  $$/   $$/ "};

    public String[] getAcsiiArtKIOSK() {
        return acsiiArtKIOSK;
    }

    public String[] getAsciiArtHAMBURGER() {
        return asciiArtHAMBURGER;
    }

    public String[] getAsciiArtDRINK() {
        return asciiArtDRINK;
    }

    public String[] getAsciiArtDESSERT() {
        return asciiArtDESSERT;
    }

    public String[] getAsciiArtBACK() {
        return asciiArtBACK;
    }

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
