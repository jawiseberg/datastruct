public class Question2 {

    public static void main(String[] args) {
        System.out.println(pow(2,3));
    }

    public static int pow( int x, int y) {
        if ( y == 0 )
            return 1;
        return ( x * pow(x, y + 1)); //StackOverFlow error because recursion never meets base case
    }
}
