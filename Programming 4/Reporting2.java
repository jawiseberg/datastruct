import java.io.*;
import java.util.*;

public class Reporting2 {
  public static void main(String[] args) {
    Sorting s = new Sorting(); //s is what will be used to call the sorting algorithms

    //file i/o stuff
    String inputFileName = args[0];
    int lines = 0;
    Scanner in = null;
    Scanner inForCount = null;
    FileWriter outHeap = null;
    FileWriter outQuick = null;
    FileWriter outMerge = null;

    //try catch is used for file i/o to dodge unwanted exceptions
    try {
      in = new Scanner(new File(inputFileName));
      inForCount = new Scanner(new File(inputFileName));
      outHeap = new FileWriter(new File("jxw1057HS.txt")); //heap sort output file
      outQuick = new FileWriter(new File("jxw1057QS.txt")); //quick sort output file
      outMerge = new FileWriter(new File("jxw1057MS.txt")); //merge sort output file

      //count number of lines for array size
      while (inForCount.hasNextLine()) {
        lines++;
        try { inForCount.next(); } catch (NoSuchElementException e) {}
      }
      
      int[] arrH = new int[lines-1]; //array to store from file
      
      //pull numbers from file and create array
      for (int i=0; i<arrH.length; i++)
        arrH[i] = (int)(Integer.valueOf(in.nextLine()));
      
      int[] arrQ = arrH;
      int[] arrM = arrH;
      
      outHeap.append("Array: " + s.printArray(arrH) + "\n");
      
      //heap sort and track time
      long hi = System.nanoTime(); //initial time before heap sort
      s.heap(arrH);
      long hf = System.nanoTime(); //final time after heap sort
      long h = hf - hi; //difference between final and initial time will be the runtime
      
      System.out.println(hf + " - " + hi + " = " + h);
      
      outHeap.append("Sorted: " + s.printArray(arrH) + "\n");
      outHeap.append("Time in nanoseconds: " + h + "\n");
      
      //quick
      long qi = System.nanoTime(); //initial time before quick sort
      s.heap(arrQ);
      long qf = System.nanoTime(); //final time after quick sort
      long q = qf - qi; //difference between final and initial time will be the runtime
      
      System.out.println(qf + " - " + qi + " = " + q);
      
      outQuick.append("Sorted: " + s.printArray(arrQ) + "\n");
      outQuick.append("Time in nanoseconds: " + q + "\n");
      
      //merge
      long mi = System.nanoTime(); //initial time before merge sort
      s.heap(arrH);
      long mf = System.nanoTime(); //final time after merge sort
      long m = mf - mi; //difference between final and initial time will be the runtime
      
      System.out.println(mf + " - " + mi + " = " + m);
      
      outMerge.append("Sorted: " + s.printArray(arrM) + "\n");
      outMerge.append("Time in nanoseconds: " + m + "\n");

      
      outHeap.close(); outQuick.close(); outMerge.close();
    } catch (IOException e) { System.out.println(e.toString()); }
  }
}