import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    public int compare(Book a, Book b) {
        if (a == null || b == null) throw new NullPointerException("Book cannot be null");

        int authorResult = compareValues(a.getAuthor(), b.getAuthor());
        if (authorResult != 0) return authorResult;

        int titleResult = compareValues(a.getTitle(), b.getTitle());
        if (titleResult != 0) return titleResult;

        return Integer.compare(a.getYear(), b.getYear());
    }

    private int compareValues(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }
}


