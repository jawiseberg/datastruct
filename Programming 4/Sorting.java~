public class Sorting {
  
  public static void main(String[] args) {
    int[] testArr = {2,5,4,3,1,7,6,8,9,0};
    printArray(testArr);
    quick(testArr);
    printArray(testArr);
  }
  
  /*___________________________________________ HEAP SORT ___________________________________________*/
  
  public static void heap(int[] arr) {
    
    //build the max-heap and rearrange the array to reflect this
    for (int i = arr.length / 2 + 1; i >= 0; i--)
      buildHeap(arr, arr.length, i);
    
    //take the elements one by one from the heap and sort them within the array
    for (int i=arr.length-1; i >= 0; i--) {
      swap(arr, 0, i); //moves the current root of the heap (the end of the array) to be the first element in the array
      buildHeap(arr, i, 0); //rebuilds the heap without the extracted element (previously the root of the array)
    }
  }
  
  /* builds the max-heap of a subtree given the array
   * n - the size of the array
   * the i - the index of the root of the heap
   */
  public static void buildHeap(int[] arr, int n, int i) {
    int max = i; //initially sets the max as the root of the heap
    int l = 2*i+1; //defines the left child at the index 2*i+1
    int r = 2*i; //defines the right child at the index 2*i+1
    
    //if the left child is larger than the root set the max accordingly
    if (l < n && arr[l] > arr[max])
      max = l;
    
    //if the right child is larger than the root set the max accordingly
    if (r < n && arr[r] > arr[max])
      max = r;
    
    //if the max wasn't the root of the tree, swap the max node to the root index, then recursively continue to do this for the rest of the subtree
    if (max != i) {
      swap(arr, i, max);
      buildHeap(arr, n, max);
    }
  }
  
  
  
  
  
  
  /*___________________________________________ QUICK SORT ___________________________________________*/
  
  public static void quick(int[] arr) {
    qSort(arr, 0, arr.length-1); //call the qSort() method starting with the beginning and end of the array
  }
  
  /* recursively sorts the array based on the partitioning index
   * seperates the sorting algorithm into a lower half and a higher half and recursively sorts through it
   */
  public static void qSort(int[] arr, int first, int last) {
    //the if statement acts as the base case, once the array is sorted the first and last values should be flipped which breaks the recursion
    if (first < last) {
      int partitionIndex = partition(arr, first, last);
      
      qSort(arr, first, partitionIndex-1); //sort elements before partition
      qSort(arr, partitionIndex+1, last);  //sort elements after partition
    }
  }
  
  /* takes pivot element and puts it in the correct place
   * moves all elements less than the pivot before it in the array
   * moves all elements greater than the pivot after it in the array
   * returns the index of the next pivot
   */
  public static int partition(int[] arr, int first, int last) {
    int i=first-1; //index going from left to right
    int j=last+1; //index going from right to left
    int pivot = arr[(first+last)/2]; //pivot as middle element
    while (true) {
      do {
        i++; //iterates through the elements before the pivot to swap higher elements to the right
      } while (arr[i] < pivot);
      do {
        j--; //iterates through the elements before the pivot to swap lower elements to the left
      } while (arr[j] > pivot);
      if (i < j)
        swap(arr,i,j);
      else return j; //breaks the while true loop once all 
    }
  }
  
  
  
  
  
  
  /*___________________________________________ MERGE SORT __________________________________________*/
  
  /*
  public static void merge(int[] arr) {
    
  }
  */
  
  
  
  
  
  
  /*___________________________________________ HELPER METHODS ______________________________________*/
  
  //swaps two elements in an array given their indices
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  //returns a string of the given array in a readable form
  public static void printArray(int[] arr) {
    String s = "[ ";
    for (int a : arr)
      s += a + " ";
    s += "]";
    System.out.println(s);
  }
}
