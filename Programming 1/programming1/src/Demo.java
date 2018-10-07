/*
Write a demo application utilizing this abstract data structure. Your application should include the following components:
● Two static methods: ​int prefixCountArrayList(PBArrayList list, String prefix) a​ nd int prefixCountLinkedList(PBLinkedList list, String prefix) ​which return the total number of entries in the phonebook with the phone number matching the prefix.
Note​: The running time of this method should be linear in the size of the phone book.
● The main method where you will:
○ Create an instance of ​PBArrayList,​ insert several elements into it, test the
PBArrayList methods and then use the ​prefixCountArrayList ​method to print the
number of elements in the sequence with a given phone prefix.
○ Repeat the above with a ​PBLinkedList.​
 */


import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        PBArrayList test = new PBArrayList();
        test.addPerson(3, new Person("Jake", "9736157155"));
        System.out.println(test.search(3));
        test.delete(3);
        System.out.println(test.search(3));
        System.out.println(prefixCountArrayList(test,"973"));

        PBLinkedList test2 = new PBLinkedList(new PBNode(new Person("Jake", "9736157155")));
        System.out.println(test2.getRoot().getPerson().getId());
        test2.addPerson(2, new Person("John", "1234567890"));
        System.out.println(test2.getRoot().getNext().getPerson().getId());
        System.out.println(prefixCountLinkedList(test2,"973"));
    }

    public static int prefixCountArrayList(PBArrayList list, String prefix) {
        int count = 0;
        for (int i =0; i<list.size(); i++) {
            if (list.search(i).getPhoneNums().contains(prefix))
                count++;

        }
        return count;
    }

    public static int prefixCountLinkedList(PBLinkedList list, String prefix) {
        int count = 0;
        for (int i =0; i<list.size(); i++) {
            if (list.search(i).getPhoneNums().contains(prefix))
            count++;

        }
        return count;
    }

}
