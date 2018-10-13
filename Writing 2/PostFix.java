import java.util.Stack;

public class PostFix {
  
  public static void main(String[] args) {
    String expr = "6+3*2+3";
    System.out.println(expr);
    System.out.println(postFixExpr(expr));
  }
  
  public static int postFixExpr(String expr) {
    char curr;
    Stack<Integer> eval = new Stack<Integer>();
    for (int i=0; i<expr.length(); i++) {
      curr = expr.charAt(i);
      if (curr == '+')
        eval.push((int)(eval.peek())+(int)(expr.charAt(i+1)));
      else if (curr == '-')
        eval.push((int)(eval.peek())-(int)(expr.charAt(i+1)));
      else if (curr == '*')
        eval.push((int)(eval.peek())*(int)(expr.charAt(i+1)));
      else if (curr == '/')
        eval.push((int)(eval.peek())/(int)(expr.charAt(i+1)));
    }
    return eval.peek();
  }
}