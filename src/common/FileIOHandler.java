package common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileIOHandler extends IOHandler {

    private final ClassLoader classLoader;

    public FileIOHandler() {
        this.classLoader = ClassLoader.getSystemClassLoader();
    }

    // 파일을 InputStream으로 가져오는 메서드
    private InputStream getResourceAsStream(String resourcePath) {
        return classLoader.getResourceAsStream(resourcePath);
    }
    // 파일 존재 여부를 확인하는 메서드
    public boolean isFileExists(String resourcePath) {
        try (InputStream inputStream = getResourceAsStream(resourcePath)) {
            return inputStream != null;
        } catch (Exception e) {
            return false;
        }
    }
    // 파일을 읽고 메뉴 리스트로 변환하는 메서드
    public List<MenuItem> loadMenuList(String resourcePath) {
        List<MenuItem> menuList = new ArrayList<>();
        // 파일 체크
        if (!isFileExists(resourcePath)) {
            return menuList; // 빈 리스트 반환
        }
        try (InputStream inputStream = getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                System.out.println(resourcePath + " 파일을 찾을 수 없습니다.");
                return menuList; // 빈 리스트 반환
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = br.readLine()) != null) {
                menuList.add(parseMenuItem(line));
            }
            br.close();
            System.out.println(resourcePath + " 파일이 정상적으로 로드되었습니다.");
            return menuList;
        } catch (Exception e) {
            System.out.println(resourcePath + " 파일 로드 중 오류 발생: " + e.getMessage());
        }

        return menuList;
    }

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
        
        // MenuItem 추가
        return new MenuItem(menuName,price,menuInfo);
    }
}
