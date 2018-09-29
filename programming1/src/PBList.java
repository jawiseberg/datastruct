public abstract class PBList {

    //abstract class instantiating all the methods that will be implemented in PBArrayList and PBLinkedList
    public abstract int size();
    public abstract void addPerson(int i, Person person);
    public abstract boolean addNumber(String id, String phoneNum);
    public abstract boolean delete(int i);
    public abstract Person search(int i);
    public abstract void merge();
    public abstract int searchForID(String id);

}
