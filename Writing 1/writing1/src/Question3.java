public class Question3 {

    public static void main(String[] args) {
        String test = "test";
        //System.out.println(reverse(test));
        System.out.println(reversei(test));
    }

    //Using recursion
    public static String reverse(String str) {
        if (str.length() < 0)
            return str ;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    //Using iteration
    public static String reversei(String str) {
        char[] temp = str.toCharArray();
        String str2 = "";
        for (int i=temp.length-1; i>=0; i--) {
            str2 += temp[i];
        }
        return str2;
    }
}
