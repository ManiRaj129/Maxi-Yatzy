package hw4;

import java.util.ArrayList;

/**
 * This class justifies whether the given array of dice values has at least 'F'
 * dice of one value and 'S' of a different value. if not returns false.
 * 
 * this class uses private variables for first and second dice number of dice,
 * although it used in only one method of this class because it reduces the
 * redundancy by implementing the general "isSatisfiedBy" method which is
 * suitable for 4 subclasses.
 * 
 * @author REJINTHALA MANI RAJ
 *
 */
public abstract class TwoDiceSet extends NDiceCommon
{
	private int FirstDice;
	private int SecondDice;

	/**
	 * 
	 * @param displayName name of a score box
	 * @param F           size of identical dice subset
	 * @param S           size of identical dice subset
	 */
	protected TwoDiceSet(String displayName, int F, int S)
	{
		super(displayName);
		FirstDice = F;
		SecondDice = S;
	}

	@Override
	public boolean isSatisfiedBy(int[] arr)
	{
		if ((FirstDice + SecondDice) <= arr.length)
		{
			copy(arr);
			ArrayList<Integer> val = NDice(FirstDice);

			if (val.size() == 1)
			{
				remove(val);
				val = NDice(SecondDice);
				if (val.size() == 1)
				{
					return true;
				}

			}
		}
		return false;
	}
}
