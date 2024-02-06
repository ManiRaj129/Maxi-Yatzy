package hw4;

/**
 * Score box that is satisfied by a Combination including at least two dice of
 * one value and two of a different value. The score is the sum of all die
 * values.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class TwoPairsScoreBox extends TwoDiceSet
{
	/**
	 * Constructs a TwoPairsScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public TwoPairsScoreBox(String displayName)
	{
		super(displayName,2,2);
	}

}
