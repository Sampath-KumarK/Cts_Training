import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Phone", "Electronics")
        };

        System.out.println("Linear Search");
        System.out.println(SearchAlgorithms.linearSearch(products, "Keyboard"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("Binary Search");
        System.out.println(SearchAlgorithms.binarySearch(products, "Keyboard"));
    }
}