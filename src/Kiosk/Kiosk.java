package Kiosk;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키오스크 시스템의 주 클래스
public class Kiosk {
    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();// 장바구니 객체
    private Scanner scanner = new Scanner(System.in);// 사용자 입력을 받기 위한 스캐너
    private double totalSales = 0;// 총 판매 금액
    private Map<Product, Integer> productSales = new HashMap<>();// 상품 판매량 관리 맵

    private KioskManager kioskManager = new KioskManager();// 키오스크 관리자 객체
    // 상품별 선택 가능한 옵션들
    private Option coffeeOption1 = new Option("아이스", 0.5);
    private Option coffeeOption2 = new Option("샷추가", 0.5);
    private Option teaOption1 = new Option("아이스", 0.5);
    private Option teaOption2 = new Option("밀크폼추가", 0.8);
    private Option toastOption1 = new Option("커피SET", 3.0);
    private Option toastOption2 = new Option("치즈추가", 0.8);
    private Option dessertOption1 = new Option("커피SET", 3.0);

// 키오스크를 시작하는 메서드

    public void start() {
        while (true) {
            // 사용자에게 메뉴를 보여주고, 선택을 받는 부분
            System.out.println(" ");
            System.out.println("\"YULL's CAFE에 오신 것을 환영합니다!\"");
            System.out.println("[ 주문 현황 ]");
            System.out.println(" ");
            kioskManager.viewRecentCompletedOrders(3);
            System.out.println(" ");
            kioskManager.viewPendingOrders();
            System.out.println(" ");
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
            System.out.println("7. 관리자 메뉴");
            System.out.print("옵션을 선택해주세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
// 사용자의 선택에 따른 처리를 하는 switch-case 문
            switch (choice) {
                case 0:
                    showTotalSales();
                    break;
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
                case 7:
                    adminMenu();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
    // 관리자 메뉴를 보여주는 메서드
    private void adminMenu() {
        while (true) {
            System.out.println("\n[ 관리자 메뉴 ]");
            System.out.println("1. 대기주문 목록 보기");
            System.out.println("2. 완료주문 목록 보기");
            System.out.println("3. 상품 추가하기");
            System.out.println("4. 상품 삭제하기");
            System.out.println("5. 뒤로가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewPendingOrders();
                    System.out.println("승인할 주문의 대기 번호를 입력하세요: ");
                    int orderId = scanner.nextInt();
                    if (kioskManager.approvePendingOrder(orderId)) {
                        System.out.println("주문이 승인되었습니다.");
                    } else {
                        System.out.println("주문 번호를 찾을 수 없습니다.");
                    }
                    break;
                case 2:
                    viewCompletedOrders();
                    break;
                case 3:
                    addProductAdmin();
                    break;
                case 4:
                    removeProductAdmin();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void viewPendingOrders() {
        List<Order> orders = kioskManager.getPendingOrders();
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
        }
    }

    private void viewCompletedOrders() {
        List<Order> orders = kioskManager.getCompletedOrders();
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
        }
    }

    private void addProductAdmin() {
        System.out.print("상품명: ");
        String name = scanner.nextLine();
        System.out.print("상품 설명: ");
        String description = scanner.nextLine();
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        System.out.print("카테고리 (Coffee, Tea, Toast, Dessert): ");
        String category = scanner.nextLine();

        kioskManager.addProduct(name, description, price, category);
        System.out.println("상품이 추가되었습니다.");
    }

    private void removeProductAdmin() {
        System.out.print("삭제할 상품명: ");
        String name = scanner.nextLine();
        if (kioskManager.removeProduct(name)) {
            System.out.println(name + " 상품이 삭제되었습니다.");
        } else {
            System.out.println(name + " 상품을 찾을 수 없습니다.");
        }
    }


    private void showTotalSales() {
        System.out.println("\n[ 총 판매상품 목록 현황 ]");
        double cumulativeSales = 0;
        for (Map.Entry<Product, Integer> entry : productSales.entrySet()) {
            double productTotalSales = entry.getKey().getPrice() * entry.getValue();
            cumulativeSales += productTotalSales;
            System.out.println("-" + entry.getKey().getName() + " | ₩ " + entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("\n[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ ₩ " + cumulativeSales + " ] 입니다.");
        System.out.println("\n1.돌아가기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice != 1) {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
    }

    private void showProducts(String category) {
        System.out.println("\n[ " + category + " Menu ]");
        int i = 1;
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : kioskManager.getProducts()) {  // 여기를 수정하여 KioskManager의 상품 목록을 참조하도록 합니다.
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
        System.out.println("1. 옵션보기");
        System.out.println("2. 그냥담기");
        System.out.println("3. 돌아가기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            if (product.getCategory().equals("Coffee")) {
                showOptions(product, coffeeOption1, coffeeOption2);
            } else if (product.getCategory().equals("Tea")) {
                showOptions(product, teaOption1, teaOption2);
            }
        } else if (product.getCategory().equals("Toast")) {
            showOptions(product, toastOption1, toastOption2);
        } else if (product.getCategory().equals("Dessert")) {
            showOptions(product, dessertOption1);
        } else if (choice == 2) {
            cart.addItem(product);
            System.out.println(product.getName() + "을(를) 주문목록에 담았습니다.");
        } else if (choice == 3) {
            return;
        } else {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
    }

    private void showOptions(Product product, Option... options) {
        System.out.println("\n[옵션 메뉴]");
        int i = 1;
        for (Option option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
        System.out.println(i + ". 취소하기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= options.length) {
            Product newProduct = product.withOption(options[choice - 1]);
            cart.addItem(newProduct);
            System.out.println(newProduct.getName() + "을(를) 주문목록에 담았습니다.");
        }
    }

    private static int waitingNumber = 1;
    //장바구니의 역할을 하는 메서드

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\n주문목록이 비어 있습니다.");
            return;
        }

        System.out.println("\n주문목록");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("| " + product.getName() + " | ₩ " + product.getPrice() + " | " + quantity + " 개 |");
            total += product.getPrice() * quantity;
        }
        System.out.println(" 결제 금액 : ₩ " + total);
        System.out.println("\n결제하시겠습니까?");
        System.out.println("1. 결제하기");
        System.out.println("2. 메뉴보기");
        System.out.println("3. 삭제하기");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("요청사항을 입력해주세요(없으면 없음을 입력해주세요, 20자 제한): ");
                String requestMessage = scanner.nextLine().substring(0, Math.min(scanner.nextLine().length(), 20));
                totalSales += total;
                for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                    productSales.put(entry.getKey(), productSales.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
                Order newOrder = new Order(requestMessage); // 주문 생성
                for (Product product : cart.getItems().keySet()) {
                    newOrder.addProduct(product);
                }
                kioskManager.addPendingOrder(newOrder);  // 주문을 대기 목록에 추가
                System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다!");
                cart.clear();
                break;
            case 2:
                break;
            case 3:
                removeItemCart();
                System.out.println("상품을 삭제하였습니다.");
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
    }
    //하나만 삭제하는 메서드
    private void removeItemCart() {
        System.out.println("\n주문 목록");
        List<Product> cartProducts = new ArrayList<>(cart.getItems().keySet());
        for (int i = 0; i < cartProducts.size(); i++) {
            Product product = cartProducts.get(i);
            int quantity = cart.getItems().get(product);
            System.out.println((i + 1) + ". " + product.getName() + " | " + quantity + " 개");
        }
        System.out.println("삭제할 항목의 번호를 입력해주세요: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= cartProducts.size()) {
            Product selectedProduct = cartProducts.get(choice - 1);
            cart.removeOneItem(selectedProduct);
        }
    }
    //메뉴 종료
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
    // 메인 메서드
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.start();

    }
}
