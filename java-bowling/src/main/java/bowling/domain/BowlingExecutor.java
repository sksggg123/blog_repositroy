package bowling.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-10 18:52
 */
public class BowlingExecutor {
    private GameBoard board;

    public BowlingExecutor() {
        this.board = new GameBoard();
    }

    public void execute(int fallCount) {
        if (board.isNormalGameOver()) {
            throw new IllegalStateException("게임 횟수가 넘었습니다.");
        }
//        return new GameSnapShot(board.play(fallCount));
    }

//    private List<List<Integer>> convertToList(Map<Integer, NormalFrameScore> soucre) {
//        return soucre.keySet().stream()
//                .map(key -> soucre.get(key))
//                .map(frameScore -> frameScore.getScoreNumber())
//                .collect(Collectors.toList());
//    }
}
