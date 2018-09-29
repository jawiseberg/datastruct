import java.util.LinkedList;

public class Person {
    private String id;
    private LinkedList<String> phoneNums = new LinkedList<String>();

    public Person(String i, String pn) {
        id = i;
        phoneNums.add(pn);
    }

    public String getId() { return id; }
    public void addNumber(String number) { phoneNums.add(number); }
    public LinkedList getPhoneNums() { return phoneNums; }
}
