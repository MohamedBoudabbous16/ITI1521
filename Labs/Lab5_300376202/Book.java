public class Book {
    public String author;
    public String title;
    public int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book book = (Book) other;
        if (year != book.year) {
            return false;
        }
        if (author != null) {
            if (!author.equals(book.author)) {
                return false;
            }
        } else if (book.author != null) {
            return false;
        }
        if (title != null) {
            if (!title.equals(book.title)) {
                return false;
            }
        } else if (book.title != null) {
            return false;
        }
        return true;
    }
    public String toString() {
        return author + ":" + title + "(" + year + ");";
    }
}


