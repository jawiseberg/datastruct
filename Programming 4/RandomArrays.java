public class RandomArrays {
  
  private int size;
  public int[][] arr; //it's public so the averages can be calculated
  
  public RandomArrays(int s) {
    size = s;
    arr = new int[100][size];
    createMatrix();
  }
  
  //adds a bunch of random arrays to an bigger array
  public void createMatrix() {
    for (int i=0; i<arr.length; i++)
      arr[i] = generate();
  }
  
  //random array generator
  public int[] generate() {
    int[] arr = new int[size];
    for (int i=0; i<size; i++)
      arr[i] = (int)(Math.random()*1000);
    return arr;
  }
  
}