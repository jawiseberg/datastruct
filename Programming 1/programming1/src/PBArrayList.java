public class PBArrayList extends PBList {

    //phone book list, that can be used to represent sequences of objects of class Person
    private Person[] pbl;
    private int size;

    public PBArrayList() {
        pbl = new Person[10];
        size = 0;
    }

    //returns current size of phone book
    public int size(){ return size; }

    //adds a person as the ith element in the array
    /*
    if i is greater than size
    if array is full
    if
     */
    public void addPerson(int i, Person person){
        size++;

        //check if array is full
        boolean full = true;
        for (int j=0; j<size; j++) {
            if (pbl[j] == null)
                full = false;
        }

        //create temp array if needed
        Person[] temp = new Person[pbl.length+1];

        //best case
        if (i<pbl.length && pbl[i] == null)
            pbl[i] = person;

        //if i is greater than size of array
        else if (i>=pbl.length) {
            i = pbl.length-1;
            if (pbl[i] == null)
                pbl[i] = person;
            else {
                for (int j=0; j<pbl.length-1; j++)
                    temp[j] = pbl[j];
                temp[pbl.length-1] = person;
                temp[pbl.length] = pbl[pbl.length-1];
                pbl = temp;
            }
        }

        //if array is full
        else if (full) {
            for (int j = 0; j < i; j++)
                temp[j] = pbl[j];
            temp[i] = person;
            for (int j = i + 1; i < size; i++)
                temp[j] = pbl[j];
            pbl = temp;
        }
    }

    //adds a number to an existing person within the phone book
    public boolean addNumber(String id, String phoneNum){
        if (searchForID(id) == -1)
            return false;
        pbl[searchForID(id)].addNumber(phoneNum);
        return true;
    }

    //deletes a person in the phone book
    public boolean delete(int i){
        size--;
        if (i>=pbl.length)
            return false;
        pbl[i] = null;
        return true;
    }

    //returns the person at the ith element
    public Person search(int i){
        if (i<pbl.length-1)
            return pbl[i];
        return null;
    }

    //merge all the instances of a single person in the book with different numbers
    public void merge(){
        //find duplicate ids and add them to a string array
        String[] duplicate = new String[pbl.length];
        int duplicates = 0;
        for (int i=0; i<pbl.length; i++) {
            for (int j=i+1; j<pbl.length; j++) {
                if (pbl[j].getId().equalsIgnoreCase(pbl[i].getId()))
                    duplicate[duplicates] = pbl[i].getId();
                duplicates++;
            }
        }
        for (int i=0; i<=duplicates; i++) {
            int index = searchForID(duplicate[i]);
            //pbl[index].addNumber(pbl[searchForID(duplicate[i], index+1)].getPhoneNums());

        }
    }

    //helper method that returns element with the ID id in the array, returns -1 if nothing is found
    public int searchForID(String id){
        for (int i=0; i<pbl.length; i++) {
            if (pbl[i] != null && pbl[i].getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }

    //helper method that returns element with the ID id in the array and takes a starting index, returns -1 if nothing is found
    public int searchForID(String id, int index){
        for (int i=index; i<pbl.length; i++) {
            if (pbl[i] != null && pbl[i].getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }


}
