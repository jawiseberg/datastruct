public class Colors {
  public static void main(String[] args) {
    RedBlue[] arr = new RedBlue[7];
    arr[0] = new RedBlue("Red", 3);
    arr[1] = new RedBlue("Blue", 5);
    arr[2] = new RedBlue("Blue", 7);
    arr[3] = new RedBlue("Red", 1);
    arr[4] = new RedBlue("Red", 4);
    arr[5] = new RedBlue("Blue", 2);
    arr[6] = new RedBlue("Red", 6);
    
    print(arr);
    sort(arr);
  }
  
  public static void sort(RedBlue[] arr) {
    int i=0;
    int j=arr.length-1;
    while (i<j) {
      if (arr[i].color.equals("Red"))
        i++;
      if (arr[j].color.equals("Blue"))
        j--;
      if (arr[i].color.equals("Blue") && arr[j].color.equals("Red")) {
        swap(arr,i,j);
        i++;
        j--;
      }
      print(arr);
    }
  }
  
  public static void print(RedBlue[] arr) {
    System.out.print("[ | ");
    for (RedBlue a : arr)
      System.out.print(a.color + "," + a.value + " | ");
    System.out.println("]");
  }
  
  public static void swap(RedBlue[] arr, int i, int j) {
    RedBlue temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}

class RedBlue {
  String color;
  int value;
  public RedBlue(String c, int v) {
    color = c;
    value = v;
  }
}
