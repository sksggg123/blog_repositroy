/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : lamda
 * create date  : 2019-06-09 19:37
 */
public class FunctionMethod {

    @FunctionalInterface
    public interface Sum {

        int sum(int num1, int num2);
    }

    public static void main(String[] args) {
        Sum function = (num1, num2) -> num1 + num2;

        System.out.println(function.sum(10, 20));
    }
}