package view;

import bowling.domain.Bowl;
import bowling.domain.GameBoard;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-10 19:23
 */
public class ConsoleView {

    private static String NAME = "NAME";
    private static String LINE_CONNECTOR = " | ";

    public static void printFrame(List<List<Integer>> frameResult) {
        frameResult.stream()
                .forEach(scores -> printScorePerFrame(scores));
        System.out.println();
    }

    private static void printScorePerFrame(List<Integer> scores) {
        System.out.print(scores.stream()
                .map(score -> Bowl.check(score, isStrike(scores)).getScoreDisplay())
                .collect(Collectors.joining("|")) + " ");
    }

    private static boolean isStrike(List<Integer> scores) {
        return scores.size() == 1 && scores.get(0) == 10;
    }

    public static void showFrameHeader() {
        StringBuilder builder = new StringBuilder("| " + NAME + LINE_CONNECTOR);
        IntStream.rangeClosed(1, GameBoard.TOTAL_GAME_COUNT)
                .peek(number -> builder.append(String.format(" %02d ", number)))
                .forEach(n -> builder.append(LINE_CONNECTOR));
        println(builder.toString());
    }

    public static void showFrameResult(String playerName, String result) {
        StringBuilder builder = new StringBuilder("| " + String.format("%4s", playerName) + LINE_CONNECTOR);
        builder.append(result);
        println(builder.toString());
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void println(Object s) {
        print(s + "\n");
    }

    public static void print(Object s) {
        System.out.print(s);
    }
}
