import java.io.*;
import java.util.*;

public class Reporting1 {
  public static void main(String[] args) {
    Sorting s = new Sorting(); //s is what will be used to call the sorting algorithms

    //file i/o stuff
    FileWriter conclusion = null;

    //try catch is used for file i/o to dodge unwanted exceptions
    try {
      conclusion = new FileWriter(new File("CONCLUSION.txt")); //heap sort output file
      RandomArrays h = new RandomArrays(1000);
      RandomArrays q = new RandomArrays(1000);
      RandomArrays m = new RandomArrays(1000);
      
      long initialTime;
      long finalTime;
      long sum = 0;
      long average;
      
      //runs the heap sort 100 times on 100 different randomly generated arrays then adds the runtime to a growing sum to take the average of later
      for (int i=0; i<h.arr.length; i++) {
        initialTime = System.nanoTime();
        s.heap(h.arr[i]);
        finalTime = System.nanoTime();
        sum += finalTime - initialTime;
      }
      
      average = sum/h.arr.length;
      sum = 0;
      
      conclusion.append("Heap sort average runtime in nanoseconds: " + average + "\n");
      
      
      
      //runs the quick sort 100 times on 100 different randomly generated arrays then adds the runtime to a growing sum to take the average of later
      for (int i=0; i<q.arr.length; i++) {
        initialTime = System.nanoTime();
        s.quick(q.arr[i]);
        finalTime = System.nanoTime();
        sum += finalTime - initialTime;
      }
      
      average = sum/q.arr.length;
      sum = 0;
      
      conclusion.append("Quick sort average runtime in nanoseconds: " + average + "\n");
      
      //runs the quick sort 100 times on 100 different randomly generated arrays then adds the runtime to a growing sum to take the average of later
      for (int i=0; i<m.arr.length; i++) {
        initialTime = System.nanoTime();
        s.quick(m.arr[i]);
        finalTime = System.nanoTime();
        sum += finalTime - initialTime;
      }
      
      average = sum/m.arr.length;
      sum = 0;
      
      conclusion.append("Merge sort average runtime in nanoseconds: " + average + "\n");
      
      
      
      
      
      conclusion.close();
    } catch (IOException e) { System.out.println(e.toString()); }
  }
}