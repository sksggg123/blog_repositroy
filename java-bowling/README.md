package bowl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BowlApplication
{

	public static void main(final String[] args)
	{
		final BowlApplication app = new BowlApplication();
		app.run();
	}

	public void run()
	{
		final List<Integer> inputList = new ArrayList<>(Arrays.asList(3, 5, 10, 0, 4, 7, 3, 5, 4, 0, 0, 10, 10, 3, 5, 3, 7, 10));
		final Board board = new Board();

		inputList.stream().map(score -> board.play(score)).forEach(System.out::println);
		//		inputList.stream().map(score -> board.play(score)).collect(Collectors.toList());
	}
}



========================================================================================================================================

package bowl;

public class NormalFrame
{
	private final NormalFrameScore frame;

	NormalFrame()
	{
		this.frame = new NormalFrameScore();
	}

	NormalFrame(final NormalFrameScore frame)
	{
		this.frame = frame;
	}

	NormalFrame bowl(final int fallCount)
	{
		final boolean bowlable = frame.bowl(fallCount);
		if (bowlable)
		{
			return this;
		}

		return new NormalFrame(frame.nextFrame(fallCount));
	}

	boolean isFrameOver()
	{
		return frame.isOverTime();
	}

	int sum()
	{
		return frame.sum();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "NormalFrame [frame=" + frame + "]";
	}
}




========================================================================================================================================

package bowl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NormalFrameScore
{
	private static final int MAX_FRAME_SCORE = 10;
	private static final int MAX_BOWL_COUNT = 2;
	private static final int STRIKE_BOWL_COUNT = 1;
	private final List<Score> scores;

	NormalFrameScore()
	{
		this.scores = new ArrayList<>();
	}

	NormalFrameScore(final int score)
	{
		this.scores = new ArrayList<>(Arrays.asList(Score.of(score)));
	}

	boolean bowl(final int fallCount)
	{
		// sum이 10 이하
		// 2번 투구 X
		if (isStrike() || !isBowl(fallCount))
		{
			System.out.println("create");
			return false;
		}
		addScore(fallCount);
		return true;
	}

	// stike 확인
	boolean isStrike()
	{
		return sum() == MAX_FRAME_SCORE && bowlCountPerFrame() == STRIKE_BOWL_COUNT;
	}

	// 현재 Frame 두번째 투구 가능한지 (sum() + fallCount > 10)
	boolean isBowl(final int fallCount)
	{
		if ((sum() + fallCount) > MAX_FRAME_SCORE)
		{
			throw new IllegalArgumentException("투구의 점수가 잘 못 되었습니다." + (sum() + fallCount));
		}

		if (isOverTime())
		{
			return false;
		}

		return true;
	}

	// 현재 Frame 종료되었는지 (NormalFrame 기준 - 2회)
	boolean isOverTime()
	{
		return bowlCountPerFrame() >= MAX_BOWL_COUNT || isStrike();
	}

	// 현재 Frame 몇번 투구한지
	int bowlCountPerFrame()
	{
		return this.scores.size();
	}

	// 현재 Frame 종료 후 새로운 Frame 생성
	NormalFrameScore nextFrame(final int fallCount)
	{
		return new NormalFrameScore(fallCount);
	}

	// 현재 Frame sum
	int sum()
	{
		return scores.stream().mapToInt(Score::getScore).sum();
	}

	// 현재 Frame에 Score추가 private으로 내부에서만 사용하게 제한
	private void addScore(final int fallCount)
	{
		scores.add(Score.of(fallCount));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "NormalFrameScore [scores=" + scores + "]";
	}
}



========================================================================================================================================

package bowl;

public class Score
{
	private static final int MAX_SCORE = 10;
	private static final int MIN_SCORE = 0;
	private final int score;

	Score(final int score)
	{
		this.score = score;
	}

	static Score of(final int fallCount)
	{
		if (fallCount < MIN_SCORE || fallCount > MAX_SCORE)
		{
			throw new IllegalArgumentException();
		}
		return new Score(fallCount);
	}

	int getScore()
	{
		return score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Score [score=" + score + "]";
	}
}



========================================================================================================================================

package bowl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FinalFrameScore
{
	private static final int DEFUALT_FRAME_COUNT = 2;
	private static final int MAX_FRAME_SCORE = 30;
	private static final int MAX_BOWL_COUNT = 3;
	private static final int SPARE_COUNT = 2;
	private static final int SPARE_SCORE = 10;
	private static final int EXCLUDE_STRIE_SUM = 0;
	private final List<Score> scores;

	FinalFrameScore()
	{
		this.scores = new ArrayList<>();
	}

	FinalFrameScore(final int score)
	{
		this.scores = new ArrayList<>(Arrays.asList(Score.of(score)));
	}

	boolean bowl(final int fallCount)
	{
		// sum이 30 이하
		// 3번 투구 X
		// spare or strike
		if (!isBowl(fallCount))
		{
			return false;
		}
		addScore(fallCount);
		return true;
	}

	// 현재 Frame 두번째 투구 가능한지 (sum() + fallCount > 10)
	boolean isBowl(final int fallCount)
	{
		if ((sum() + fallCount) > MAX_FRAME_SCORE)
		{
			throw new IllegalArgumentException("투구의 점수가 잘 못 되었습니다.");
		}

		if (isOverTime())
		{
			throw new IllegalArgumentException("종료된 Frame입니다.");
		}

		return true;
	}

	// stike 확인
	boolean isStrike()
	{
		return sum() / MAX_FRAME_SCORE == bowlCountPerFrame() && sum() != EXCLUDE_STRIE_SUM;
	}

	// 투구가 스페어 상태인지 체크
	boolean isSpare()
	{
		return sum() == SPARE_SCORE && bowlCountPerFrame() == SPARE_COUNT;
	}

	// 현재 Frame 종료되었는지
	boolean isOverTime()
	{
		if (isDefaultTime() && !isSpare() && !isStrike())
		{
			return true;
		}

		return bowlCountPerFrame() >= MAX_BOWL_COUNT;
	}

	private boolean isDefaultTime()
	{
		return bowlCountPerFrame() == DEFUALT_FRAME_COUNT;
	}

	// 현재 Frame 몇번 투구한지
	int bowlCountPerFrame()
	{
		return this.scores.size();
	}

	// 현재 Frame sum
	int sum()
	{
		return scores.stream().mapToInt(Score::getScore).sum();
	}

	// 현재 Frame에 Score추가 private으로 내부에서만 사용하게 제한
	private void addScore(final int fallCount)
	{
		scores.add(Score.of(fallCount));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "FinalFrameScore [scores=" + scores + "]";
	}


}



========================================================================================================================================

package bowl;

public class FinalFrame
{
	private final FinalFrameScore frame;

	FinalFrame()
	{
		this.frame = new FinalFrameScore();
	}

	FinalFrame(final FinalFrameScore frame)
	{
		this.frame = frame;
	}

	FinalFrame bowl(final int fallCount)
	{
		final boolean bowlable = frame.bowl(fallCount);
		if (!bowlable)
		{
			throw new IllegalArgumentException();
		}
		return this;
	}

	int frameSum()
	{
		return frame.sum();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "FinalFrame [frame=" + frame + "]";
	}


}


========================================================================================================================================

package bowl;

import java.util.ArrayList;
import java.util.List;


public class Board
{
	private static final int NORMAL_FRAME_COUNT = 9;
	private static final int FINAL_FRAME_COUNT = 1;
	private static final int TOTAL_FRAME_COUNT = NORMAL_FRAME_COUNT + FINAL_FRAME_COUNT;
	private static final int NORMAL_FRAME_BOWL_COUNT = 2;
	private static final int TOTAL_BOWL_MAX_COUNT = NORMAL_FRAME_BOWL_COUNT * NORMAL_FRAME_COUNT + FINAL_FRAME_COUNT;
	private static final int ONE = 1;
	private static final int ZERO = 0;

	private final List<NormalFrame> normalFrame;
	private final FinalFrame finalFrame;

	public Board()
	{
		this.normalFrame = new ArrayList<>();
		this.finalFrame = new FinalFrame();
	}

	public int play(final int fallCount)
	{
		if (isNormalFrameGameOver())
		{
			return finalFrame.bowl(fallCount).frameSum();
		}
		return normalPlay(fallCount);
	}

	public boolean isNormalFrameGameOver()
	{
		return normalFrame.size() >= NORMAL_FRAME_COUNT;
	}

	private int normalPlay(final int fallCount)
	{
		if (isEmpty())
		{
			final NormalFrame normal = new NormalFrame();
			normalFrame.add(normal.bowl(fallCount));
			return normalFrame.get(ZERO).sum();
		}
		if (isNormalFrameOver())
		{
			final NormalFrame normal = new NormalFrame();
			normalFrame.add(normal.bowl(fallCount));
			return normal.sum();
		}
		return normalFrame.get(normalFrameLastIndex()).bowl(fallCount).sum();
	}

	private boolean isNormalFrameOver()
	{
		return normalFrame.get(normalFrameLastIndex()).isFrameOver();
	}

	private int normalFrameLastIndex()
	{
		return normalFrame.size() - ONE;
	}

	private boolean isEmpty()
	{
		return normalFrame.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Board [normalFrame=" + normalFrame + ", finalFrame=" + finalFrame + "]";
	}


}

