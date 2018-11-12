public class HeapSort { 
 
 public static void main(String args[]) { 
  int[] arr = {12, 11, 13, 5, 6, 7}; 

  System.out.print("Unsorted: ");
  printArray(arr);
  
  System.out.print("Sorted:   "); 
  printArray(sort(arr)); 
 } 
  
  
  
 public static int[] sort(int[] arr) { 
  
  // Build heap
  for (int i = arr.length / 2 - 1; i >= 0; i--) 
   buildHeap(arr, arr.length, i); 
  
  //Take elements back out of heap 
  for (int i=arr.length-1; i>=0; i--) { 
   int temp = arr[0]; 
   arr[0] = arr[i]; 
   arr[i] = temp; 
   buildHeap(arr, i, 0); 
  } 
  
  return arr;
 } 

 public static void buildHeap(int arr[], int n, int i) { 
  int largest = i;
  int l = 2*i + 1;
  int r = 2*i + 2;

  if (l < n && arr[l] > arr[largest]) 
   largest = l; 
  if (r < n && arr[r] > arr[largest]) 
   largest = r; 


  if (largest != i) { 
   int swap = arr[i]; 
   arr[i] = arr[largest]; 
   arr[largest] = swap; 
   buildHeap(arr, n, largest); 
  } 
 } 

//prints an array of ints in a readable form
 public static void printArray(int[] a) {
  System.out.print("[ ");
  for (int i=0; i<a.length; i++)
   System.out.print(a[i]+" ");
  System.out.println("]");
 }
} 
