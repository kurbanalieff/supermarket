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