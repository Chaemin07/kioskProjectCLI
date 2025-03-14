# 📱 JAVA CLI KIOSK 

이 프로젝트는 **기본적인 키오스크 프로그램**을 구현하여 **객체 지향 설계를 학습하는 목적**으로 개발되었습니다. 
사용자는 메뉴와 주문 기능을 활용하여 음식 주문 및 장바구니 관리를 할 수 있습니다.

### 📦 디렉토리 구조

```  
📦 kiosk-project
┣ 📂 ch1.kiosk
┃  ┣ 📃 Kiosk.java
┃  ┗ 📃 Main.java
┣ 📂 common
┃  ┣ 📃 FileIOHandler.java
┃  ┣ 📃 IOHandler.java
┃  ┣ 📃 KioskMenu.java
┃  ┣ 📃 Menu.java
┃  ┣ 📃 MenuCategory.java
┃  ┣ 📃 MenuItem.java
┃  ┣ 📃 OrderBasket.java
┃  ┗ 📃 Payment.java
┣ 📂 resources
┃  ┣ 📄 dessertMenu.txt
┃  ┣ 📄 drinkMenu.txt
┃  ┗ 📄 hamburgerMenu.txt
┗ 📄 README.md   - 프로젝트 소개 문서
```
---
## 📌 주요 기능

### 🍔 메뉴 및 주문 관리
- 메뉴 및 주문 내역 클래스 기반 관리
- 메뉴 카테고리와 메뉴 아이템 클래스 분리

### 🛒 장바구니 및 주문 기능
- 메뉴 선택 및 장바구니 추가
- 장바구니 항목 관리(추가, 삭제, 조회)
- 주문 처리 및 결제 상태 관리

### ⚠️ 예외 처리
- 사용자 입력 시 `try-catch`를 활용한 예외 처리
- 잘못된 입력 시 적절한 안내 메시지 제공

### 🚀 추가 기능 (🔜 예정)
- 키오스크 관리자를 위한 메뉴 추가 및 수정 기능
- 별도 입력을 통한 동적 메뉴 관리

## 🛠️ 시스템 요구사항
- 프로그래밍 언어: Java
- 프레임워크/라이브러리: 기본 Java 라이브러리 활용
- Java 버전: JDK 17
---
## 실행 예시 화면
![키오스크 실행 예시]()

---

## 📥 설치 및 실행 방법

1. 소스코드 다운로드

```bash
  git clone https://github.com/Chaemin07/kioskProjectCLI.git
```
