import java.util.ArrayList;
import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProduct() {
        return products;
    }

}

class CalculateTotal {
    ShoppingCart cart;

    public CalculateTotal(ShoppingCart cart) {
        this.cart = cart;

    }

    public double calculateSum() {
        double sum = 0;

        for (Product p : cart.getProduct()) {
            sum += p.price;
        }
        return sum;
    }
}

class InvoicePrinter {

    ShoppingCart cart;

    public InvoicePrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printVoice() {
        for (Product p : cart.getProduct()) {
            System.out.println("product " + p.name + ": Price :" + p.price);
        }
    }
}

public class SRP_Principle {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("apple", 30));
        cart.addProduct(new Product("Banana", 60));

        InvoicePrinter printer = new InvoicePrinter(cart);
        printer.printVoice();

        CalculateTotal total = new CalculateTotal(cart);
        System.out.println(total.calculateSum());
    }
}
