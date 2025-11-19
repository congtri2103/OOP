package iterator.exercises;

import java.util.ArrayList;
import java.util.List;

public class ProductIterator implements Iterator {
    private List<String> products = new ArrayList<>();
    private int position;

    public ProductIterator(List<String> products) {
        this.products = products;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return products.get(position++);
        } else {
            // Handle the case when there are no more elements
            return null;
        }
    }
}
