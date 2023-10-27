package Kiosk;

import java.util.*;
// 키오스크의 관리 기능을 담당하는 클래스
public class KioskManager {

    private List<Order> pendingOrders = new ArrayList<>();  // 대기 중인 주문 목록
    private List<Order> completedOrders = new ArrayList<>(); // 완료된 주문 목록
    private List<Product> products = new ArrayList<>();// 판매 가능한 상품 목록

    public KioskManager() {
        initializeProducts();
    }// 기본 생성자에서 상품을 초기화

    private void initializeProducts() {// 초기 상품 목록을 설정하는 메서드
        // 커피 카테고리
        products.add(new Product("아메리카노", "국민음료? 당신의 하루는 언제나 아메리카노로 시작하는거 다알아요!!!", 3.5, "Coffee"));
        products.add(new Product("라떼", "우유와 함께한 에스프레소의 궁합!! 고소한 커피를 경험해보세요.", 4.0, "Coffee"));
        products.add(new Product("카푸치노", "에스프레소와 밀크의 댄스파티! 너무 신나서 거품이 마구...길라임씨가 되어보세요.", 4.5, "Coffee"));
        products.add(new Product("모카", "초코의 달콤함과 에스프레소의 깊은 만남! 쫀독쫀독 달달에 빠져보세요.", 4.8, "Coffee"));
        products.add(new Product("바닐라 라떼", "바닐라의 달달한 속삭임에 에스프레소가 넘어가 부렸으~.", 5.0, "Coffee"));
        products.add(new Product("플랫 화이트", "카푸치노? 아님 플랫 화이트? 거기서 거기니까 고민하지말기로해요 ", 4.3, "Coffee"));
        products.add(new Product("콜드 브루", "시간을 내어 차가운 물에 담긴 커피의 완숙한 향기! 얼음과의 혀에 닿는 깔끔함!", 4.7, "Coffee"));
        products.add(new Product("더치 커피", "더치로 나를 주세요! 드리프로 6시간 동안 나오기만 고대하던 커피의 기다림.", 5.2, "Coffee"));
        products.add(new Product("아포가토", "이도저도 아니야 난 아이스크림이 좋아!하는 당신의 선택", 5.5, "Coffee"));
        // 차 카테고리
        products.add(new Product("아이스 티", "뜨숩은 차가 심심할 땐 아이스로 즐겨보는건 어떤가요? 아샷추 가능!!", 3.0, "Tea"));
        products.add(new Product("페퍼민트 티", "초코민트는 안좋아할수있지!!하지만 이건 좀 다를껄??", 4.2, "Tea"));
        products.add(new Product("레몬에이드", "레몬의 활력! 그냥 에이드가 아니라 T.O.P 에이드 . 탄산의 춤을 느껴보세요!", 3.8, "Tea"));
        products.add(new Product("프룻 스무디", "생과일로만 만들어서 당신의 활기도 살아나게 해줄!!!!", 5.5, "Tea"));
        products.add(new Product("아이스 초코", "초콜릿이 더위에 지쳐 쉬고 싶다며 아이스로 변신! 시원한 휴가를 즐기는 중!", 4.2, "Tea"));
        products.add(new Product("허브의 숲", "마시면 마법의 숲에 빠지는 기분? 신비로운 허브 차", 3.5, "차"));
        products.add(new Product("로즈위스퍼", "장미의 꽃말처럼 사랑의 속삭임 그게 질투일지 순수한 사랑일지는 당신의 옆에 누가있는지에 달렸죠! 러블리한 장미차", 4.0, "Tea"));
        products.add(new Product("홍차 대모험", "가게만의 특볋한 블랜딩으로 만들어진 홍차의 탐험같은 차!", 3.8, "Tea"));
        products.add(new Product("차올려라!", "우린 명차를 마신다! 우전 녹차로 명차중 명차인 녹차!!", 4.2, "Tea"));
        products.add(new Product("춘식이용", "춘식이가 좋아하는 고구마가 라떼가 되어 돌아온 것! 달콤하게 깜짝 놀라는 맛", 4.5, "Tea"));
        // 토스트 카테고리
        products.add(new Product("평범한 토스트?", "버터와 잼의 가장 기본의 충실한 맛!!!!!", 2.0, "Toast"));
        products.add(new Product("치즈 토스트", "치즈가 숨어있어! 누가 나를 찾나?(치즈양이 적다는건 아녀유...)", 2.5, "Toast"));
        products.add(new Product("아보카도의 대모험", "아보카도와 계란의 토스트 위 콜라보!!", 3.5, "Toast"));
        products.add(new Product("아보카도 VIP", "아보카도가 주인공, 계란은 특별출연!(계란반개)", 4.0, "Toast"));
        products.add(new Product("햄치즈 토스트 파티", "햄과 치즈의 뜨거운 빵위에서 놀이!", 3.5, "Toast"));
        products.add(new Product("계란 토스트", "계란만의 무대! 이걸 고른 당신 아마 편식쟁이...?", 3.0, "Toast"));
        products.add(new Product("크림치즈의 꿈", "녹아내리는 크림치드 ft.후라이의 꿈", 3.8, "Toast"));
        products.add(new Product("땅콩버터 토스트", "땅콩버터의 맛으로 미쿡의 등교길이 생각날 맛!", 3.2, "Toast"));
        products.add(new Product("시나몬 토스트", "시나몬의 무대! 시나몬이 왕밤빵 많이 뿌려져있다구!", 3.6, "Toast"));
        // 디저트 카테고리
        products.add(new Product("치즈케이크", "치즈가 웃다! 행복의 원조!", 4.0, "Dessert"));
        products.add(new Product("티라미수 ", "커피와 치즈의 이탈리아 방식 폭신폭신이!!", 4.5, "Dessert"));
        products.add(new Product("브라우니", "꾸덕함을 원하는 당신은 이걸 고르게 된다!!", 3.8, "Dessert"));
        products.add(new Product("마카롱", "설탕덩어리고 살찌곘지만 어쩌겠어 맛있는걸?", 2.5, "Dessert"));
        products.add(new Product("파운드 케이크", "세계를 돌며 찾은 최고의 커피 파트너!", 3.5, "Dessert"));
        products.add(new Product("푸딩", "몰랑몰랑 탱글탱글 커피랑 안어울려도 너만 있다면야!", 3.0, "Dessert"));
        products.add(new Product("젤라또", "이탈리아의 쫀득함이 한입과 한 수저에 가득!", 4.0, "Dessert"));
        products.add(new Product("무스", "에어리한 질감으로 입천장을 쩝쩝하게 될 맛!!", 4.2, "Dessert"));
        products.add(new Product("크렘 브륄레", "크림의 꽃, 설탕의 불꽃!딱딱함 속에 감춰진 부드러움 like you!", 4.8, "Dessert"));
    }
    public void addPendingOrder(Order order) {
        this.pendingOrders.add(order);
    }    // 대기 주문을 추가하는 메서드
    public boolean completeOrder(int orderId) {    // 주문을 완료 상태로 변경하는 메서드

        for (Order order : pendingOrders) {
            if (order.getOrderId() == orderId) {
                order.setCompletionTime(new Date());
                completedOrders.add(order);
                pendingOrders.remove(order);
                return true;
            }
        }
        return false;// 주문 완료에 실패했음을 반환
    }
    // 새 상품을 추가하는 메서드
    public void addProduct(String name, String description, double price, String category) {
        products.add(new Product(name, description, price, category));
    }
    // 상품을 삭제하는 메서드
    public boolean removeProduct(String productName) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Order> getPendingOrders() {
        return this.pendingOrders;
    }    // 대기 주문 목록을 반환하는 메서드


    public List<Order> getCompletedOrders() {
        return this.completedOrders;
    }    // 완료된 주문 목록을 반환하는 메서드


    public List<Product> getProducts() {
        return this.products;
    }    // 상품 목록을 반환하는 메서드


    public void viewPendingOrders() {    // 대기 주문 목록을 화면에 출력하는 메서드

        System.out.println("\n[ 대기 주문 목록 ]");
        for (Order order : pendingOrders) {
            System.out.println(order.getOrderDetails());
        }
    }
    public boolean approvePendingOrder(int orderId) {    // 대기 주문을 승인하고 완료 목록으로 이동하는 메서드

        Iterator<Order> iterator = pendingOrders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId() == orderId) {
                order.setCompletionTime(new Date());
                completedOrders.add(order);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    // 최근에 완료된 주문을 화면에 출력하는 메서드
    public void viewRecentCompletedOrders(int count) {
        System.out.println("\n[ 최근 완료된 주문 ]");
        int displayedCount = 0;
        ListIterator<Order> iterator = completedOrders.listIterator(completedOrders.size());
        while (iterator.hasPrevious() && displayedCount < count) {
            Order order = iterator.previous();
            System.out.println("대기번호: " + order.getOrderId());
            System.out.print("상품목록: ");
            for (Product product : order.getProducts()) {
                System.out.print(product.getName() + ", ");
            }
            System.out.println("\n---------------------");
            displayedCount++;
        }
    }
}