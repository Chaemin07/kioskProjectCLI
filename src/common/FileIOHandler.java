package common;

import java.util.StringTokenizer;

public class FileIOHandler extends IOHandler {



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
        
        // 카테고리 추가
        return new MenuItem(menuName,price,menuInfo);
    }
}
