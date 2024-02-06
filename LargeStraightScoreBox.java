package hw4;

/**
 * Score box for a large straight. A Combination with N dice satisfies this
 * category only if it consists of N distinct consecutive values. For a dice
 * group that satisfies this category, the score is a fixed value specified in
 * the constructor; otherwise, the score is zero.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class LargeStraightScoreBox extends FixedScore
{
	/**
	 * Constructs a LargeStraightScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a dice group that satisfies this score
	 *                    box
	 */
	public LargeStraightScoreBox(String displayName, int points)
	{
		super(displayName, points);
	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		copy(arr);

		// checking whether the given array has distinct elements or not.
		if (NDice(2).size() == 0)
		{
			if (isConsecutive(getList()))
          {
        	  return true;
          }
		}

		return false;
	}

}
