package Supermarket;

public class ProductData {
    private int productCode;
    private String productName;
    private double productPrice;
    public final double tax = 0.06;

    public ProductData(int productCode, String productName, double productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public static double subtotalPrice(int quantity, double price) {
        return quantity * price;
    }

    public static double totalPrice(int quantity, double price, double tax) {
        return (quantity * price) + (quantity * price * tax);
    }

}
// String isContinue = "no";
// do{

// }while (isContinue.equalsIgnoreCase("yes"));


// while (true) {
//     System.out.println("Product added successfully!!!");
//     System.out.println();
//     System.out.println("Would you like to add more products? (Yes || No) ");
//     String addProduct = scanner.next();
//     if (addProduct.equalsIgnoreCase("No")) {
//         System.out.println("Thank you for your added product");
//         break;
//     } else if (addProduct.equalsIgnoreCase("Yes")) {
//         break;
//     } else {
//         System.out.println("*** You have entered INCORRECT information ! ***");
//         break;
//     }
// }