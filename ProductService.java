package Supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductService {
    private static final List<ProductData> products = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> responses = new ArrayList<>();
    public static double totalPrice = 0;
    public static double subPrice = 0;

    public static void addProduct() {

        String isContinue;
        do {

            System.out.println("Enter New Product Code: ");
            int newproductCode = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter New Product Name: ");
            String newproductName = scanner.nextLine();

            System.out.println("Enter New Product Price: ");
            double newproductPrice = scanner.nextDouble();

            products.add(new ProductData(newproductCode, newproductName, newproductPrice));

            System.out.println("Product added successfully!!!\n");

            System.out.println("Would you like to add more products? (Yes or No) ");
            isContinue = scanner.next();
            while (!("yes".equalsIgnoreCase(isContinue) || "no".equalsIgnoreCase(isContinue))) {
                System.out.println("*** You have entered INCORRECT response ! ***");
                System.out.println("Please enter a valid response (Yes or No)");
                isContinue = scanner.next();
            }
        } while (isContinue.equalsIgnoreCase("yes"));
        System.out.println("Thank you for your added product(s)");
    }

    public static void buyProduct() {
        String isContinue;
        do {
            System.out.println("Enter Product Code: ");
            int productCode = scanner.nextInt();
            System.out.println("Enter Quantity: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0 || quantity >= 101) {
                System.out.println("*** invalid quantity ***");
            }

            Optional<ProductData> productOpt = products.stream().filter(product -> product.getProductCode() == productCode).findFirst();
            if (productOpt.isPresent()) {
                ProductData product = productOpt.get();
                double priceSubtotal = ProductData.subtotalPrice(quantity, product.getProductPrice());
                subPrice += priceSubtotal;
                double priceTotal = ProductData.totalPrice(quantity, product.getProductPrice(), product.tax);
                totalPrice += priceTotal;
                String response = product.getProductName() + "  " + quantity + " @ " + product.getProductPrice() + "  " + priceSubtotal;
                responses.add(response);
            } else {
                System.out.println("*** item " + productCode + " not in inventory ***");
            }

            System.out.println("Would you like to buy more products? (Yes or No) ");
            isContinue = scanner.next();

            while (!("yes".equalsIgnoreCase(isContinue) || "no".equalsIgnoreCase(isContinue))) {
                System.out.println("*** You have entered INCORRECT response ! ***");
                System.out.println("Please enter a valid response (Yes or No)");
                isContinue = scanner.next();
            }

        } while (isContinue.equalsIgnoreCase("yes"));
        System.out.println("Thank you for choosing us");


    }

    public static void calculateProduct() {
        System.out.print("Enter amount tendered: ");

        double enterAT = scanner.nextDouble();
        double changeDue = enterAT - totalPrice;

        System.out.println("Change due: " + changeDue);

        System.out.println("***** ABC MiniMart *****");

        System.out.println(responses);

        System.out.println("Subtotal: " + subPrice);

        System.out.println("Tax: " + (totalPrice - subPrice));

        System.out.println("Total Amount: " + totalPrice);

        System.out.println("Amount Tendered: " + enterAT);

        System.out.println("Change due: " + changeDue);
    }

    public static void main(String[] args) {

        products.add(new ProductData(11012, "Dutch Lady Milk", 4.50));
        products.add(new ProductData(11014, "Condensed Milk", 2.60));
        products.add(new ProductData(11110, "Milo (1 kg)", 32.50));
        products.add(new ProductData(30005, "Super Jasmine Rice", 23.50));
        products.add(new ProductData(20115, "Top Detergent", 17.30));
        products.add(new ProductData(10007, "Gardenia Bread", 3.20));

        while (true) {
            System.out.println("Enter one of these (1-> add product, 2-> buy product, 0-> exit) : ");
            int selectedMenu = scanner.nextInt();

            if (selectedMenu == 0) {
                System.out.println("Total Price: " + totalPrice);
                break;
            }

            if (selectedMenu == 1) {
                addProduct();
            }

            if (selectedMenu == 2) {
                buyProduct();
            }
        }

        calculateProduct();
        scanner.close();
    }

}
