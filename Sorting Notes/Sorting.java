/*
 * TODO
 * - shell sort
 * - quick sort
 * 
 */


public class Sorting {
  
  public static void main(String[] args) {
    int[] random = randomArray();
    printArray(random);
    printArray(bubble(random));
  }
  
  /* SELECTION SORT
   * - worst case O(n^2)
   * - best case O(n) --> completely sorted array
   */
  public static int[] selection(int[] a) {
    for (int i=0; i<a.length; i++) {
      int j = findMin(a,i);
      swap(a,i,j);
      //printArray(a); //uncomment to see each iteration
    }
    return a;
  }
  
  
  /* INSERTION SORT
   * - worst case O(n^2)
   * - best case O(n)
   */
  public static int[] insertion(int[] a) {
    for (int i=1; i<a.length; i++) {
      int toInsert = a[i];
      int j=1;
      for (j=i;j>0 && toInsert<a[j-1];j--)
        a[j] = a[j-1];
      a[j] = toInsert;
      //printArray(a); //uncomment to see each iteration
    }
    return a;
  }
  
  //for an array in the reverse order, selection sort is faster than unoprtimized insertion (implementation above is unoptimized)
  
  
  /* SHELL SORT
   * - improves on insertion sort by lowering the amount of moves to get an element to its final location
   * - shell sort uses larger slides that allows elements to get to their place faster
   * - makes use of subarrays that seperates elements by a given increment (ex. increment of 3 would have 3 subarrays in an array with 9 elements)
   * - larger increments allow for larger "jumps"
   * - end with compleneting the process using subarrays with a increment of 1
   * - complexity is O(n^3/2), depends on increments
   * TODO --> NEED TO FIX IMPLEMENTATION, gets into a while true loop?
   */
  public static int[] shell(int[] a) {
    int incr = 1;
    while (2*incr <= a.length)
      incr = 2*incr;
    incr = incr-1;
    
    while (incr>=1) {
      for (int i=incr; i<a.length; i++) {
        int toInsert = a[i];
        int j=1;
        for (j=i;j>incr-1 && toInsert<a[j-incr];j-=incr)
          a[j] = a[j-incr];
        a[j] = toInsert;
      }
    }
    incr = incr/2;
    
    return a;
  }
  
  
  /* BUBBLE SORT
   * - it's really easy
   * - just compare everything and get the highest number to the end
   * - O(n^2)
   */ 
  public static int[] bubble(int[] a) {
    for (int i=a.length-1; i>0; i--) {
      for (int j=0; j<i; j++) {
        if (a[j]>a[j+1]) {
          swap(a,j,j+1);
        }
      }
    }
    return a;
  }
  
  
  /* QUICK SORT
   * - divides array to "bubble" faster
   * - merges the results at the end
   * - divide and conquer method
   * - easiest done recursively, need 2 methods
   */ 
  public static int[] quick(int[] a) {
    int i=0;
    int j=a.length-1;
    int pivot = (int)(Math.random()*a.length);
    while (/* NEED TO FIGURE OUT THIS CONDITION */) {
      while (a[i] >= pivot) {
        if (a[j] < pivot) {
          swap(a,i,j);
        } else { j--; }
      }
      i++;
    } //this while loop is the partition part of the sort
    
    
  }
  
  
  
  /* MERGE SORT
   * 
   * 
   * 
   */
  public static int[] merge(int[] a) {
    
    
  }
  
  
/*___________________HELPER METHODS_____________________________*/  

  //randomly generates an array of 10 ints between 1 and 100
  public static int[] randomArray() {
    int[] toReturn = new int[10];
    for (int i=0; i<toReturn.length; i++)
      toReturn[i] = (int)(Math.random()*100);
    return toReturn;
  }
  
  //prints an array of ints in a readable form
  public static void printArray(int[] a) {
    System.out.print("[ ");
    for (int i=0; i<a.length; i++)
      System.out.print(a[i]+" ");
    System.out.println("]");
  }
  
  //finds the index of the smallest element in an array
  public static int findMin(int[] a, int lower) {
    int currIndexMin = lower;
    for (int i=lower+1; i<a.length-1; i++) {
      if (a[i]<a[currIndexMin]) {
        currIndexMin=i;
      }
     }
     return currIndexMin;
    }
  
  //swaps 2 elements in an array
  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}