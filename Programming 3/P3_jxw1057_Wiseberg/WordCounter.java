import java.io.*;
import java.util.Scanner;

public class WordCounter {
  
  public static void main(String[] args) {
    wordCount(args[0], args[1]);
  }
  
  public static void wordCount(String inputFileName, String outputFileName) {
    Scanner inForCount = null;
    Scanner in = null;
    FileWriter out = null;
    String curr = null;
    FileWriter info = null;
    
    try {
      inForCount = new Scanner(new File(inputFileName));
      in = new Scanner(new File(inputFileName));
      in.useDelimiter("(\\p{javaWhitespace}|\\.|,)+");
      out = new FileWriter(new File(outputFileName));
      info = new FileWriter(new File("hashTableProperties.txt"));
      int words = 0;
      
      while (inForCount.hasNext()) {
        words++;
        curr = inForCount.next();
      }
      
      curr = null;
      HashTable h = new HashTable(words);

      while (in.hasNext()) {
        curr = in.next();
        h.insert(curr);
      }
      
      out.append(h.printTable());
      
      //hash table properties into file
      info.append("Table Size: " + h.getSize() + "\nNumber of Items: " + h.getNumItems() + "\nLoad Factor: " + h.getLoadFactor());
      
      
      //close all working files
      inForCount.close(); in.close(); out.close(); info.close();
      
    } catch (IOException e) { System.out.println(e.toString()); }
  }
}

class HashTable{
  
  private class Entry {
    private int index;
    private String word;
    private Entry next;
    private int occurances;
    
    private Entry(String w) {
      index = h(w);
      word = w;
      next = null;
      occurances = 1;
    }
    
    public Entry getNext() { return next; }
    public void setNext(Entry n) { next = n; }
    public String getWord() { return word; }
    public int getOccurances() { return occurances; }
    public void addOccurance() { occurances += 1; }
    public String printEntry() { return "(" + word + "," + occurances + ")"; }
  }
  
  private Entry[] table;
  private int tableSize;
  private int numItems;
  
  public HashTable(int size) {
    table = new Entry[size];
    tableSize = size;
    numItems = 0;
  }
  
  //hash function
  public int h(String w) { return Math.abs(w.hashCode()) % tableSize; }
  
  public void insert(String w) {
    int index = h(w);
    if (table[index] != null && search(w) == null)
      traverse(table[index]).setNext(new Entry(w));
    else if (table[index] != null && search(w) != null)
      search(w).addOccurance();
    else
      table[index] = new Entry(w);
    numItems++;
  }
  
  public Entry traverse(Entry r) {
    while (r.getNext() != null)
      r = r.getNext();
    return r;
  }
  
  //returns the node where the string w is located in the hashtable
  public Entry search(String w) {
    int index = h(w);
    Entry toReturn = null;
    if (table[index] == null)
      return toReturn;
    toReturn = table[index];
    while (table[index] != null) {
      if (toReturn.getWord().equalsIgnoreCase(w))
        return toReturn;
      else if(toReturn.getNext() == null)
        return null;
      else
        toReturn = toReturn.getNext();
    }
    return null;
  }
  
  public String printTable() {
    int index = 0;
    Entry toPrint;
    String toReturn = "";
    while (index < tableSize) {
      if (table[index] == null)
        index++;
      else {
        toPrint = table[index];
        toReturn += toPrint.printEntry() + " ";
        if (toPrint.getNext() != null) {
          toPrint = toPrint.getNext();
          while (toPrint.getNext() != null) {
            toReturn += toPrint.printEntry() + " ";
            toPrint = toPrint.getNext();
          }
        }
        index++;
      }
    }
    
    return toReturn;
  }
  
  public int getNumItems() { return numItems; }
  public int getSize() { return tableSize; }
  public double getLoadFactor() {
    int index = 0;
    int[] collisions = new int[numItems+1];
    int indexC = 0;
    Entry curr;
    int tempNum;
    
    while (index < tableSize) {
      if (table[index] != null) {
        tempNum = 1;
        curr = table[index];
        while (curr.getNext() != null) {
          tempNum++;
          curr = curr.getNext();
        }
      collisions[indexC] = tempNum;
      indexC++;
      }
      index++;
    }
    
    int sum = 0;
    for (int i=0; i<collisions.length; i++)
      sum += collisions[i];
    
    return sum/collisions.length;
  }
}