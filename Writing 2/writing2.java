class Test {
  private int num;
  
  public Test(int num) {
    this.num = num;
  }
  
  public int getNum() { return num; }
  
  public void setNum(int num) { this.num = num; }
  
}

public class writing2 {
  
  public static void main(String[] args) {
    Test t = new Test(3);
    System.out.println(t.getNum());
    t.setNum(5);
    System.out.println(t.getNum());
  }
}