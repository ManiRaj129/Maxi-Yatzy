package hw4;

/**
 * Score box that is satisfied by a Combination including at least four dice of
 * one value and two of a different value The score is the sum of all die
 * values.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class TowerScoreBox extends TwoDiceSet
{
	/**
	 * Constructs a TowerScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public TowerScoreBox(String displayName)
	{
		super(displayName, 4, 2);
	}

}
