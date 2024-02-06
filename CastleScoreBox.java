package hw4;

/**
 * Score box that is satisfied by a Combination including at least three dice of
 * one value and three of a different value. The score is the sum of all die
 * values.
 * 
 * @author REJINTHALA MANI RAJ
 */

public class CastleScoreBox extends TwoDiceSet
{
	/**
	 * Constructs a CastleScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public CastleScoreBox(String displayName)
	{
		super(displayName, 3, 3);
	}

}
