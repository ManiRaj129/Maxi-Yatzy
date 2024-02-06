package hw4;

import java.util.ArrayList;

/**
 * this class implements methods to return fixed scores and to find whether the
 * given list of distinct dice values are consecutive.
 * 
 * @author REJINTHALA MANI RAJ
 */
public abstract class FixedScore extends NDiceCommon
{
	/**
	 * score possible if satisfied
	 */
	private int pScore;

	protected FixedScore(String displayName, int points)
	{
		super(displayName);
		pScore = points;
	}

	@Override
	public int getPotentialScore(int[] arr)
	{
		if (isSatisfiedBy(arr))
		{
			return pScore;
		}
		return 0;
	}

	/**
	 * finds whether the given distinct list of dice values are consecutive or
	 * not.
	 * 
	 * @param arr array list of dice values
	 * @return true if consecutive, if not false
	 */
	protected boolean isConsecutive(ArrayList<Integer> arr)
	{
		for (int i = 0; i < arr.size() - 1; i++)
		{
			if (arr.get(i) + 1 != arr.get(i+1))
			{
				return false;
			}
		}

		return true;
	}
}
