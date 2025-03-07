package lv1.kiosk;

public class Main {
    public static void main(String[] args) {
        printAsciiArt();
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


}
