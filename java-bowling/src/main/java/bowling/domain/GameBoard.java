package bowling.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-10 17:15
 */
public class GameBoard {
    public static final int TOTAL_GAME_COUNT = 10;
    private static final int LIMIT_NORMAL_GAME_COUNT = 9;
    private static final int LAST_INDEX = 1;

    private List<NormalFrame> normalFrames;
    private FinalFrame finalFrame;

    GameBoard() {
        this.normalFrames = new ArrayList<>();
        this.finalFrame = new FinalFrame();
    }

    int play(int fallCount) {
        if (isNormalGameOver() && isFinalGameOver()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }

        boolean normalBowlable = false;
        boolean finallBowlable = false;

        if (isNormalGameOver()) {
            finallBowlable = finalFrame.bowl(fallCount);
        }

        if (isNormalFrameEmpty()) {
            normalBowlable = normalFrames.add(NormalFrame.of(fallCount));
        } else {
            normalBowlable = normalFrames.get(lastNormalIndex()).bowl(fallCount);
        }

        if (normalBowlable) {
            return normalFrames.get(lastNormalIndex()).sum();
        }

        return finalFrame.sum();
    }

    private void bowlFinalFrame(int fallCount) {
        finalFrame.bowl(fallCount);
    }

    boolean isFinalGameOver() {
        return finalFrame.isDone();

    }

    boolean isNormalGameOver() {
        System.out.println(normalFrames.size());
        return normalFrames.size() >= LIMIT_NORMAL_GAME_COUNT;
    }

    private boolean isNormalFrameEmpty() {
        return normalFrames.isEmpty();
    }

    private int lastNormalIndex() {
        return normalFrames.size() - LAST_INDEX;
    }

}
