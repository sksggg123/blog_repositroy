import java.lang.FunctionalInterface;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : lamda
 * create date  : 2019-06-11 23:18
 */
public class FunctionalInterfaceEx {

    public static void main(String[] args) {
        MyFunction f1 = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        System.out.println("익명 클래스 : " + f1.max(10, 20));

        MyFunction f2 = (int a, int b) -> a > b ? a : b;

        System.out.println("람다식 : " + f2.max(10, 20));
    }

    interface MyFunction {
        public abstract int max(int a, int b);
    }
}

