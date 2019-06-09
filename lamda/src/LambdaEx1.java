/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : lamda
 * create date  : 2019-06-09 20:45
 */
public class LambdaEx1 {
    static void excute(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {

        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();


        f1.run();
        f2.run();
        f3.run();

        excute(f1);
        excute(() -> System.out.println("f4.run()"));
    }
}

@FunctionalInterface
interface MyFunction {
    void run();
}
