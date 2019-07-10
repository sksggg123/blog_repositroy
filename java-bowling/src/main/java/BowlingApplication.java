import bowling.domain.BowlingExecutor;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-07 23:07
 */
public class BowlingApplication {

    private BowlingExecutor bowlingExecutor;

    public BowlingApplication() {
        this.bowlingExecutor = new BowlingExecutor();
    }

    public static void main(String[] args) {
        BowlingApplication app = new BowlingApplication();
        app.run();
    }

    public void run() {

        List<Integer> inputList = new ArrayList<>(
                Arrays.asList(10, 3,7,3,6,0,0,3,0,4,6,10,0,0,1,0,10));

        bowlingExecutor.execute(1);
    }
}
