public class PBLinkedList extends PBList {
    private PBNode root;
    private int size;

    public PBLinkedList(PBNode r) {
        root = r;
        size = 1;
    }

    //returns size of phone book
    public int size() { return size; }

    public void addPerson(int i, Person person) {
        PBNode curr = root.getNext();
        PBNode temp = null;
        for (int j=0; j<size+1; j++) {
            if (j !=0)
                curr = curr.getNext();
            //best case
            if (i == j && curr.getNext() == null)
                curr.setNext(new PBNode(person));
            else if (i==j && curr.getNext() != null)
                temp = curr.getNext();
                curr.setNext(new PBNode(person));
                curr.getNext().setNext(temp);
        }
    }

    //adds number to an existing person with a certain id, returns false if person doesn't exist
    public boolean addNumber(String id, String phoneNum) {
        int toAdd = searchForID(id);
        PBNode curr = root;
        for (int i=0; i<size; i++) {
            if (i == toAdd) {
                curr.getPerson().addNumber(phoneNum);
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public boolean delete(int i) {
        
    }

    public Person search(int i) {
        PBNode curr = root;
        for (int j=0; j<size; j++) {
            if (i==j)
                return curr.getPerson();
            curr = curr.getNext();
        }
        return null;
    }

    public void merge() {

    }

    //helper method for finding the index of people with a specific id
    public int searchForID(String id) {
        PBNode curr = root;
        for (int i=0; i<size; i++) {
            if (curr.getPerson().getId().equalsIgnoreCase(id))
                return i;
            curr = curr.getNext();
        }
        return -1;
    }
}
