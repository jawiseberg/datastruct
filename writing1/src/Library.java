public class Library<T> {
    private Book[] lib;
    private int len;

    public Library(int l) {
        lib = new Book[l];
        len = 0;
    }

    public boolean onLoan(T t) {
        for (int i=0; i<lib.length; i++) {
            if (lib[i].getId() == t) {
                lib[i].setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean addBook(T t) {
        if (len < lib.length && lib[len] == null) {
            lib[len] = (Book)t;
            len++;
            return true;
        }
        return false;
    }

    public boolean removeBook(T t) {
        for (int i=0; i<lib.length; i++) {
            if (lib[i].getId() == t) {
                lib[i] = null;
                return true;
            }
        }
        return false;
    }

    public Book getBook(T t) {
        for (int i=0; i<lib.length; i++) {
            if (lib[i].getId() == t)
                return lib[i];
        }
        return null;
    }
}
