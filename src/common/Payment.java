package common;

import java.io.IOException;

public class Payment {
    private final IOHandler ioHandler;
    private String prompt;
    public Payment(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public boolean startPaymentProcess(OrderBasket orderBasket) throws IOException {
        double totalAmount = orderBasket.getTotalSum();

        if (totalAmount == 0) {
            System.out.println("🛒 장바구니가 비어 있습니다.");
            return false;
        }
        System.out.println("💰 총 결제 금액: " + totalAmount + "💲입니다.");
        try {
            prompt = "결제할 수단을 선택해 주세요: (1. 현금 or 2.카드)\n>> ";
            int choice = selectPaymentMethod(prompt);
            String paymentMethod = (choice == 1) ? "현금" : "카드";
            if (handlePaymentTransaction(paymentMethod,totalAmount)) {
                // 결제 성공
                orderBasket.clearBasket();
                return true;
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다!" + e.getMessage());
        }
        return false;
    }

    public int selectPaymentMethod(String prompt) throws IOException {
        int choice = ioHandler.inputInt(prompt, 2);
        return choice;
    }

    private boolean handlePaymentTransaction(String paymentMethod,double totalPrice) {
        double inputCash=0;
        System.out.println(paymentMethod + "(으)로 결제를 진행합니다.");
        if (paymentMethod.equals("카드")) {
            System.out.println("\n💳 " + paymentMethod + "로 결제 진행 중...");
            // 여기서는 단순히 1초 지연 후 성공 처리
            try {
                Thread.sleep(1000); // 1초 딜레이
            } catch (InterruptedException e) {
                return false;
            }
            return true; // 결제 성공 처리
        } else if (paymentMethod.equals("현금")) {
            while(true){
                prompt = "\uD83D\uDCB0 지불할 금액을 입력하세요: \n>> ";
                try{
                    inputCash = ioHandler.isValidCash(prompt);
                    if (inputCash < totalPrice) {
                        String shortfall = String.format("%.2f", totalPrice - inputCash);
                        System.out.println("shortfall = " + shortfall);
                        System.out.println("\"❌ 금액이 부족합니다!\" \n부족한 금액:  + \""+shortfall + "💲\"");
                    }else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("오류가 발생했습니다!" + e.getMessage());
                }
            }
            // 거스름돈 계산 및 출력
            double change = inputCash - totalPrice;
            String stringChange = String.format("%.2f", change);
            if (change > 0) {
                System.out.println("💵 거스름돈: " + stringChange + "💲 입니다.");
            }
            return true;
        }
        return false;
    }

}
