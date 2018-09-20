public class Question4 {

    public static void main(String[] args) {
        int[] arr = {4,5,3,1,7,2,8,5,9};
        System.out.println(min(arr,9));
    }

    public static int min( int [] a){
        int a_min = a[0];
        for( int i = 1; i < a.length; i++)
            if(a[i]<a_min)
                a_min=a[i];
        return a_min;
    }


    public static int min(int[] a, int index) {
        if (index == a.length - 1)
            return a[index];
        int min = min(a, index + 1);
        if (a[index] < min)
            return a[index];
        else
            return min;
    }

}
