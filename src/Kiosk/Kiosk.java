package Kiosk;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Product> products = new ArrayList<>();
    private Map<Product, Integer> cart = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Kiosk() {
        initializeProducts();
    }

    private void initializeProducts() {
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


    public void start() {
        while (true) {
            System.out.println(" ");
            System.out.println("\"YULL's CAFE에 오신 것을 환영합니다!\"");
            System.out.println("아래의 메뉴를 보시고 원하는 번호를 입력해 주세요!!!");
            System.out.println(" ");
            System.out.println("[ MENU ]");
            System.out.println(" ");
            System.out.println("1. COFFEE       | 직접 로스팅을 하여 향을 극대화한 커피");
            System.out.println("2. TEA          | 아 오늘은 커피는 별론데...하는 그대를 위한거에요");
            System.out.println("3. TOAST        | 배고프고 출출한 상태에서 카공 중 밥먹으로 가기 밍구스러운 당신!");
            System.out.println("4. DESSERT      | 알고있어 당신은 케잌이 먹고싶다는걸!");
            System.out.println(" ");
            System.out.println("[ ORDER ]");
            System.out.println(" ");
            System.out.println("5. ORDER        | 뭘 담았는지는 알아야지 결제를 하겠죠?");
            System.out.println("6. EXIT         | 아쉽지만...먹고싶은게 없으시군요 더 노력할게요... ");
            System.out.print("옵션을 선택해주세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showProducts("Coffee");
                    break;
                case 2:
                    showProducts("Tea");
                    break;
                case 3:
                    showProducts("Toast");
                    break;
                case 4:
                    showProducts("Dessert");
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    exitMenu();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void showProducts(String category) {
        System.out.println("\n[ " + category + " Menu ]");
        int i = 1;
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                availableProducts.add(product);
                System.out.println(i + ". " + product);
                i++;
            }
        }
        System.out.println(i + ". 뒤로가기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= availableProducts.size()) {
            addProductToCart(availableProducts.get(choice - 1));
        }
    }


    private void addProductToCart(Product product) {
        System.out.println("\n" + product.getName() + " | ₩ " + product.getPrice() + " | " + product.getDescription());
        System.out.println("\"위 메뉴 주문목록에 담으시겠습니까?\"");
        System.out.println("1. 확인");
        System.out.println("2. 취소");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            cart.put(product, cart.getOrDefault(product, 0) + 1);
            System.out.println(product.getName() + "을(를) 주문목록에 담았습니다.");
        }
    }

    private static int waitingNumber = 1;

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\n장바구니가 비어 있습니다.");
            return;
        }

        System.out.println("\n주문목록");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("| " + product.getName()+" | ₩ "+product.getPrice()+ " | " + quantity + " 개 |");
            total += product.getPrice() * quantity;
        }
        System.out.println(" 결제 금액 : ₩ " + total);
        System.out.println("\n결제하시겠습니까?");
        System.out.println("1. 결제하기");
        System.out.println("2. 메뉴보기");
        System.out.println("3. 다시담기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다!");
                System.out.println("당신의 대기 번호는 " + waitingNumber + "번입니다.");
                waitingNumber++;
                cart.clear();

                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "초 후 메인 메뉴로 돌아갑니다");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                break;
            case 3:
                cart.clear();
                System.out.println("주문목록이 비워졌습니다. 원하시는 상품을 다시 담아주세요.");
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
    }


    private void exitMenu() {
        System.out.println("주문을 취소하시겠습니까? 진짜로 그냥 가는거에요???");
        System.out.println("1. 당차게 종료하기");
        System.out.println("2. 미련뚝뚝 돌아가기");
        System.out.print("선택: ");
        int exitChoice = scanner.nextInt();
        scanner.nextLine();

        if (exitChoice == 1) {
            System.out.println("이용해주셔서 감사합니다!다음엔 맛난걸로 준비해둘게요...");
            System.exit(0);
        } else if (exitChoice == 2) {
            return;
        } else {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
    }

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.start();
    }
}

