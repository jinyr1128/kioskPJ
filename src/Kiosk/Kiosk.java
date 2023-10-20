package Kiosk;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);
    private double totalSales = 0;
    private Map<Product, Integer> productSales = new HashMap<>();
    public Kiosk() {
        initializeProducts();
    }

    private void initializeProducts() {
        // 커피 카테고리
        products.add(new Product("아메리카노", "국민음료? 당신의 하루는 언제나 아메리카노로 시작하는거 다알아요!!!", 3.5, "Coffee"));

        // 차 카테고리
        products.add(new Product("아이스 티", "뜨숩은 차가 심심할 땐 아이스로 즐겨보는건 어떤가요? 아샷추 가능!!", 3.0, "Tea"));

        // 토스트 카테고리
        products.add(new Product("평범한 토스트?", "버터와 잼의 가장 기본의 충실한 맛!!!!!", 2.0, "Toast"));

        // 디저트 카테고리
        products.add(new Product("치즈케이크", "치즈가 웃다! 행복의 원조!", 4.0, "Dessert"));

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
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
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
            cart.addItem(product);
            System.out.println(product.getName() + "을(를) 주문목록에 담았습니다.");
        }
    }

    private static int waitingNumber = 1;


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
                totalSales += total;
                for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                    productSales.put(entry.getKey(), productSales.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }

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
                removeItemCart();
                System.out.println("상품을 삭제하였습니다.");
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                break;
        }
    }
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

