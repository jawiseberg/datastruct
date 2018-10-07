public class PBNode {
    private PBNode next;
    private Person person;

    public PBNode(Person p) {
        person = p;
        next = null;
    }

    public Person getPerson() {return person; }

    public PBNode getNext() { return next; }

    public void setNext(PBNode node) { next = node; }
}
