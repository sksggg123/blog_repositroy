import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Lamda 식
        int[] arr = new int[5];
        Arrays.setAll(arr, i -> (int) (Math.random() * 5) + 1);

        for (int i : arr) {
            System.out.println(i);
        }

    }
    // Method 표현
    static int method(int i) {
        return (int) (Math.random()*5) +1 ;
    }
}