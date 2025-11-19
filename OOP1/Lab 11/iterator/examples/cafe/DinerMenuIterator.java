package iterator.examples.cafe;

public class DinerMenuIterator implements Iterator {
    private String[] items;
    private int position = 0;

    public DinerMenuIterator(String[] items) {
        this.items = items;
    }

    public String next() {
        String menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }
}

