package hw4;

/**
 * Score box that is satisfied by a Combination including at least three dice of
 * one value and two of a different value. The score is the sum of all die
 * values.
 * 
 * @author REJINTHALA MANI RAJ
 */

public class FullHouseScoreBox extends TwoDiceSet
{
	/**
	 * Constructs a FullHouseScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public FullHouseScoreBox(String displayName)
	{
		super(displayName, 3, 2);
	}

}
