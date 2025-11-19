package iterator.exercises;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog implements Iterable{
    List<String> productCatalog = new ArrayList<>();

    public void addProduct(String product) {
        productCatalog.add(product);
    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator(productCatalog);
    }
}
