public class Test {
    public static void main(String[] args) {
        int l = 2;
        Library books = new Library(l);
        books.addBook(new Book<String>("Ready PLayer One"));
        books.addBook(new Book<Integer>(121432));
        for (int i=0; i<l; i++) {
            System.out.println(books.getBook(i));
        }
    }
}
