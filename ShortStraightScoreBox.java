package hw4;

import java.util.ArrayList;

/**
 * Score box for a short straight. A Combination with N dice satisfies this
 * category only if it includes N - 1 distinct consecutive values. For a dice
 * group that satisfies this category, the score is a fixed value specified in
 * the constructor; otherwise, the score is zero.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class ShortStraightScoreBox extends FixedScore
{
	/**
	 * Constructs a SmallStraightScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a dice group that satisfies this score
	 *                    box
	 */
	public ShortStraightScoreBox(String displayName, int points)
	{
		super(displayName, points);
	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		copy(arr);

		if (NDice(3).size() == 0)
		{
			ArrayList<Integer> val = new ArrayList<Integer>();

			val = NDice(2);
			// defined helper method
			remove(val);
			// condition to ensure the list has only one 2 identical dice (value) group.
			if (val.size() == 1 && NDice(2).size() == 0)
			{
				// identical die value
				int iVal = val.get(0);
				val = getList();
				val.add(iVal);

			} else
			{
				val = getList();
				// remove method defined in the array list to remove element at the index 0.
				val.remove(0);
				if (!isConsecutive(val))
				{
					val = getList();
					val.remove(val.size() - 1);
				}
			}

			if (isConsecutive(val))
			{
				return true;
			}
		}

		return false;
	}
}
