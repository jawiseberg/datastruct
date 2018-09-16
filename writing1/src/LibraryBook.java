public class LibraryBook<AnyType> {
    private AnyType[] books;
    private String title;
    private int isbn;

    public LibraryBook(String t, int i) {
        title = t;
        isbn = i;
    }

    public boolean onLoan(String t) {
        return true;
    }
    public boolean onLoan(int i) {
        return true;
    }

    public boolean addBook(String t, int i) {
        return true;
    }
    public boolean removeBook(String t, int i) {
        return true;
    }
}
