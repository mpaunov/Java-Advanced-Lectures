package advanced.iteratorsAndComparators;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {
        return f.compareTo(s);
    }
}
