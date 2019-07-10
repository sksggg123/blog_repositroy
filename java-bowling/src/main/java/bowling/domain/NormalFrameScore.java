package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-10 16:12
 */
class NormalFrameScore {
    private static final int LIMIT_SCORE_COUNT = 2;
    private static final int MAX_SUM_SCORE = 10;
    private static final int STRIKE_BOWL_COUNT = 1;

    private List<Score> scores;

    NormalFrameScore(int score) {
        List<Score> scores = new ArrayList<>();
        scores.add(Score.of(score));
        this.scores = scores;
    }

    boolean addScore(int fallCount) {
        if (bowlable()) {
            scores.add(Score.of(fallCount));
            return true;
        }
        return false;
    }

    boolean bowlable() {
        if (bowlCount() >= LIMIT_SCORE_COUNT
                || sum() >= MAX_SUM_SCORE
                || strikeCount() >= STRIKE_BOWL_COUNT) {
            return false;
        }
        return true;
    }

    int bowlCount() {
        return scores.size();
    }

    int sum() {
        return scores.stream()
                .mapToInt(Score::getScore)
                .sum();
    }

    int strikeCount() {
        return (int) scores.stream()
                .filter(Score::isStrike)
                .count();
    }
}
