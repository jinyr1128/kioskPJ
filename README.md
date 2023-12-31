# `(YULL's CAFE)` Kiosk Project
## Introduction
<span style="font-size: 16px;">이 프로젝트는 카페 키오스크를 가상으로 구현한 자바 기반의 프로그램입니다.<br> 
사용자는 키오스크에서 메뉴를 확인하고, 원하는 상품을 장바구니에 선택해서 담아 결제할 수 있습니다.</span>

## Project Details 
 ### 개발 언어: Java!!!!!![Java.jpeg](src%2Fimg%2FJava.jpeg)

 ### 개발 환경:IntelliJ!!!!!!!!!! ![인텔리제이.png](src%2Fimg%2F%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4.png)
### 주요 클래스
#### Kiosk: 키오스크의 메인 기능을 관리하는데 사용자 인터페이스 및 메뉴 선택 로직을 담당하여서 보여지기용!
#### KioskManager: 키오스크의 주문 및 상품 관리를 담당 메뉴들도 좀 이쪽으로 빼서 추가 삭제가 가능하게 만듬
#### Option: 사용자가 선택할 수 있는 추가 옵션(예: 사이즈, 설탕량 등)을 관리...이자식이 젤 속을 썩였지...
#### Cart: 사용자가 선택한 상품들을 임시로 보관하며, 결제 전까지의 상태를 관리하는 용이다 주문목록
#### Menu: 사용자에게 제공되는 다양한 카페 메뉴를 보여주려고 만들어둔 클래스이다!!!
#### Order: 사용자가 선택한 상품들의 주문 정보를 관리하며 가격합계도 여기서 뚱땅뚱땅 나온다.
#### Product: 카페의 각 상품에 대한 정보를 가지고 있는 클래스이다...
## Project Motivation
<span style="font-size: 16px;">이 프로젝트는 '내일 배움 캠프'의 자바 언어 주간 개인 과제로 시작하게 되었습니다. 
<br>실생활에서 자주 볼 수 있는 카페 키오스크의 기능을 가상으로 구현하여,
<br>실제 비즈니스 환경에서의 프로그래밍 경험을 얻자라는 당찬 포부와 함께 시작하여!!
<br>하얗게 산화되며 마무리를 헀습니다.</span>
## Additional Features (추가 구현 사항)
<span style="font-size: 16px;">키오스크 관리 프로그램을 통해 다음의 기능들이 추가로 구현되었습니다

<span style="font-size: 16px;">대기주문 목록: 주문이 완료되어 처리 대기 중인 주문을 조회하고 완료처리 할 수 있습니다.<br>
완료 주문목록: 완료처리한 주문들을 모두 조회할 수 있습니다.<br>
상품 생성: 새로운 상품정보를 입력하여 생성할 수 있습니다. 기존에 없는 메뉴라면 신규로 생성해줍니다.<br>
상품 삭제: 상품ID를 가지고 기존 상품정보를 삭제할 수 있습니다.<br>

## How to Run
<span style="font-size: 16px;">1.IntelliJ 를 실행합니다.<br>
2.위의 코드들을 복사하여 IntelliJ 프로젝트에 붙여넣기 합니다.<br>
3.Kiosk 클래스에서 main 메서드를 실행하여 프로그램을 시작합니다.<br>

![스크린샷 2023-10-19 오후 3.12.38.png](src%2Fimg%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-19%20%EC%98%A4%ED%9B%84%203.12.38.png)<br>
<span style="font-size: 20px;"><br>그러면 위 이미지처럼 나올것입니다!!!<br><br>
4.콘솔 창에서 메뉴를 선택하여 입력!!!그 뒤 원하는 상품을 장바구니에 담고 결제합니다.<br></span>
## Conclusion
<span style="font-size: 16px;">이 프로젝트를 통해 실제 카페 키오스크의 주문 및 결제 시스템의 기본적인 동작들을 이해하고 구현하며 작동 원리를 이해했습니다.
<br> 더 많은 기능과 UI/UX 개선과 많은 피드백을 통해 사용자가 원하는 기능을 잘 구성하며 <br>
사용자에게 친화적인 키오스크를 만들 수 있을 것입니다.</span>

