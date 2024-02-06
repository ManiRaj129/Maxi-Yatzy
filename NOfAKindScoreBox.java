package hw4;

import java.util.ArrayList;

/**
 * Score box for a given number N of matching dice, where N is specified in the
 * constructor. A Combination satisfies this category only if it has (at least)
 * N dice that are the same. For a Combination that satisfies this category, the
 * score is the sum of the N dice that have the same value. If there are
 * multiple groups of N with the same value, the group with highest value is
 * used for the score. For example, if N is 3 and the combination is (2, 2, 2,
 * 5, 5, 5, 5, 6), the score is 15.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class NOfAKindScoreBox extends NDiceCommon
{
	/**
	 * number of identical dice
	 */
	private int DSize;

	/**
	 * Constructs a NOfAKindScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param howMany     how many dice must match to satisfy this score box
	 */
	public NOfAKindScoreBox(String displayName, int howMany)
	{
		super(displayName);
		DSize = howMany;
	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		copy(arr);

		if (NDice(DSize).size() == 1)
		{
			return true;
		}

		return false;
	}

	@Override
	public int getPotentialScore(int[] arr)
	{
		
		if (isSatisfiedBy(arr))
		{			
			// highest value among N identical dice groups
			ArrayList<Integer> highVal = NDice(DSize);
            
			remove(highVal); 
			ArrayList<Integer> tempVal = NDice(DSize);
			
			while (tempVal.size() == 1)
			{
				if(highVal.get(0)<tempVal.get(0))
				{
					highVal = tempVal;
				}
				
				remove(tempVal);
				tempVal = NDice(DSize);
			}

			return DSize * highVal.get(0);
		}
		
		return 0;
	}

}
