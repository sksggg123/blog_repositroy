package bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-10 17:11
 */
public class GameBoardTest {

    private List<Integer> playScore;

    @BeforeEach
    void setUp() {
        playScore = new ArrayList<>(Arrays.asList(10,10,10,1,1,1,1,10,10,1,1,10));
    }

    @DisplayName("1~9 프레임 NomalFrame 종료")
    @Test
    void isNormalGameOver() {
        GameBoard board = new GameBoard();
        for (int score : playScore) {
            board.play(score);
        }
        assertThat(board.isNormalGameOver()).isTrue();
    }
}
