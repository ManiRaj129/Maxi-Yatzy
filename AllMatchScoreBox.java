package hw4;

import java.util.ArrayList;

/**
 * Score box for all dice the same. A Combination with N dice satisfies this
 * category only if all N values are the same. For a Combination that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class AllMatchScoreBox extends FixedScore
{

	/**
	 * Constructs a AllMatchScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a combination that satisfies this score
	 *                    box
	 */
	public AllMatchScoreBox(String displayName, int points)
	{
		super(displayName, points);

	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		copy(arr);

		// element at index 0 (first Element)
		ArrayList<Integer> FElement = new ArrayList<Integer>();
		FElement.add(arr[0]);
		
		// defined helper method in NDiceCommon, removes all dices which has similar
		// values as the first dice.
		remove(FElement);
		
		if (getList().size() == 0)
		{
			return true;
		}

		return false;
	}

}
