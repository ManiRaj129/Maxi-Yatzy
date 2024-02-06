package hw4;

/**
 * Score box that is based on counting dice that match a particular target value
 * (as specified in the constructor). This category is satisfied by any
 * Combination. The score is the sum of the dice that match the target.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class MatchTargetScoreBox extends ScoreBoxCommon
{

	/**
	 * target value
	 */
	private int tVal;

	/**
	 * Constructs a MatchTargetScoreBox with the given display name and target
	 * value.
	 * 
	 * @param displayName name for this score box
	 * @param whichValue  target value that must be matched for the dice to count
	 *                    toward the score
	 */
	public MatchTargetScoreBox(String displayName, int whichValue)
	{
		super(displayName);
		tVal = whichValue;
	}

	@Override
	public int getPotentialScore(int[] arr)
	{
		// sum of the values that match to the target
		int sum = 0;
		if (isSatisfiedBy(arr))
		{
			for (int k : arr)
			{
				if (k == tVal)
				{
					sum += k;
				}
			}
		}
		return sum;
	}

}
