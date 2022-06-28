package advanced.iteratorsAndComparators;

import java.util.Comparator;

public class BookComparatorByYear implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {
        return Integer.compare(f.getYear(), s.getYear());
    }

}
