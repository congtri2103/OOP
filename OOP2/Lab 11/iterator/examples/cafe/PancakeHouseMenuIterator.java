package iterator.examples.cafe;

import java.util.List;
import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
    private List<String> items;
    private int position = 0;

    public PancakeHouseMenuIterator(ArrayList<String> items) {
        this.items = items;
    }

    public String next() {
        String menuItem = items.get(position);
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        }
        return true;
    }
}

