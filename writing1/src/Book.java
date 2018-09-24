public class Book<T> {
    private T id;
    private boolean available;

    public Book(T id) {
        this.id = id;
        available = true;
    }

    public T getId() { return id; }
    public boolean isAvailable() { return available; }

    public boolean setAvailable(boolean a) {
        available = a;
        return available;
    }
}
