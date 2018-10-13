class Node {
  private int data;
  private Node next;
  
  public Node(int d) { data = d; }
  
  public int getData() { return data; }
  public Node getNext() { return next; }
  public void setNext(Node n) { next = n; }
}

class LinkedList {
  private Node head;
  
  public LinkedList(Node h) { head = h; }
  
  public Node getHead() { return head; }
  public boolean add(Node n) {
    Node curr = head;
    while (curr.getNext() != null)
      curr = curr.getNext();
    curr.setNext(n);
    return true;
  }
  public void print() {
    Node curr = head;
    while (curr.getNext() != null) {
      System.out.println(curr.getData() + ", ");
      curr = curr.getNext();
    }
  }
      
  
  //reverses linked list using constant memory space
  public void reverse() {
    Node curr = head;
    Node next = head.getNext();
    Node prev = null;
    
    //Base case, if it is the last note, set it to be the head
    if (curr.getNext() == null) { 
      head = curr; 
      curr.setNext(prev); 
    }
    
    Node next1 = curr.getNext(); 
    curr.setNext(prev); 
    reverse(); 
  }
}

public class writing2 {
  
  public static void main(String[] args) {
    LinkedList lst = new LinkedList(new Node(2));
    lst.add(new Node(3));
    lst.add(new Node(5));
    System.out.println(lst.print());
    lst.reverse();
    System.out.println(lst.print());
    
  }
  
}