package hw4;

/**
 * This class implements a score calculation. The score is the sum of all dice values in
 * the given array
 * 
 * @author REJINTHALA MANI RAJ
 */
public abstract class AllSumScore extends ScoreBoxCommon
{

	protected AllSumScore(String displayName)
	{
		super(displayName);

	}

	@Override
	public int getPotentialScore(int[] arr)
	{
		// current score for the given array values
		int cScore = 0;
		if (isSatisfiedBy(arr))
		{
			for (int k : arr)
			{
				cScore += k;
			}
		}
		return cScore;
	}
}
