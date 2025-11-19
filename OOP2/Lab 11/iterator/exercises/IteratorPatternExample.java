package iterator.exercises;

import java.util.List;

public class IteratorPatternExample {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();

        // Add some products to the catalog
        productCatalog.addProduct("Product A");
        productCatalog.addProduct("Product B");
        productCatalog.addProduct("Product C");

        // Iterate over the products using the iterator
        Iterator iterator = productCatalog.getIterator();
        while (iterator.hasNext()) {
            String product = iterator.next();
            System.out.println("Product: " + product);
        }
    }
}
