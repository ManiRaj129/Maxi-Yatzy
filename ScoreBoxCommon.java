package hw4;

import api.ScoreBox;

/**
 * An abstract class which consists general/common implementations of Score
 * boxes.
 * 
 * @author REJINTHALA MANI RAJ
 */
public abstract class ScoreBoxCommon implements ScoreBox
{
	/**
	 * Name of the score box
	 */
	private String nameSB;
	/**
	 * combination used to satisfy
	 */
	private Combination saved;
	/**
	 * score earned
	 */
	private int score;

	/**
	 * Constructs a ScoreBox with the given display name.
	 * 
	 * @param displayName name of a score box
	 */
	protected ScoreBoxCommon(String displayName)
	{
		nameSB = displayName;
		saved = null;
		score = 0;
	}

	@Override
	public void fill(Combination dice)
	{
		if (!dice.isComplete())
		{
			throw new IllegalStateException("the given combination is not complete");
		} else
		{
			saved = dice;
			score = getPotentialScore(dice.getCompletedDice());
		}

	}

	@Override
	public Combination getDice()
	{
		return saved;
	}

	@Override
	public String getDisplayName()
	{
		return nameSB;
	}

	@Override
	public int getScore()
	{
		return score;
	}

	@Override
	public boolean isFilled()
	{
		if (getDice() != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		if (arr.length != 0)
		{
			return true;
		}
		return false;
	}
}
