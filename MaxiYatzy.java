package hw4;

import java.util.ArrayList;
import java.util.Random;

import api.GameConfiguration;
import api.ScoreBox;

/**
 * Hierarchy of Score Boxes
 * 
 * ScoreBoxCommon (implements scorebox interface) is a abstract super class
 * Implements all the basic or general public methods of all score boxes. In
 * addition sets isSatisfiedBy method to return true by default until override.
 * 
 * MatchtargetScoreBox extends ScoreBoxCommon
 * 
 * 
 * AllSumScore, an Abstract class, extends ScoreBoxCommon which override and
 * defines getPotentialScore method which calculates sum of all given dice
 * values
 * 
 * ChanceScoreBox extends AllSumScore
 * 
 * 
 * NDiceCommon, an Abstract class, extends AllSumScore which defines protected
 * helper methods to find whether the give dice combination has certain group of
 * size n identical dice.
 * 
 * NOfAKindScoreBox extends NDiceCommon
 * 
 * 
 * FixedScore, an Abstract class, extends NDiceCommon which overrides and
 * implements getPotentialScore method which return a fixed score
 * 
 * ShortStraightScoreBox extends FixedScore
 * 
 * LargeStraightScoreBox extends FixedScore
 * 
 * AllMatchScoreBox extends FixedScore
 * 
 * 
 * TwoDiceSet, an Abstract class, extends NDiceCommon which overrides and
 * implements isSatisfiedBy method to justify whether the given array of dice
 * values has at least 'm' dice of one value and 'n' of a different value. if
 * not returns false. This class uses private variables for first and second
 * dice number of dice, although it used in only one method of this class
 * because it reduces the redundancy by implementing the general "isSatisfiedBy"
 * method which is suitable for 4 subclasses.
 * 
 * TowerScoreBox extends TwoDiceSet
 * 
 * TwoPairScoreBox extends TwoDiceSet
 * 
 * CastleScoreBox extends TwoDiceSet
 * 
 * FullHouseScoreBox extends TwoDiceSet
 * 
 * ------------------------------------------------------------------------------
 * 
 * Game state for dice games such as MaxiYatzy. The game includes a
 * <code>GameConfiguration</code> object along with two lists of
 * <code>ScoreBox</code> objects, one for the upper section and one for the
 * lower section. (Note that the only actual distinction between the two
 * sections is that the upper section scores are added up and checked to see
 * whether they exceed the upper section bonus cutoff; if so, the upper section
 * bonus is added to the score.) This class is also responsible for maintaining
 * a current Combination (group of dice) and counting the number of rolls.
 * <p>
 * Most of the game state is stored in the associated <code>ScoreBox</code>
 * objects, each of which knows its contribution to the overall score, obtained
 * via its <code>getScore</code> method.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class MaxiYatzy
{
	/**
	 * configuration to use for this game
	 */
	private GameConfiguration con;
	/**
	 * random number generator to use for rolling dice
	 */
	private Random ran;
	/**
	 * list of Lower Section Score Boxes
	 */
	private ArrayList<ScoreBox> LowerSection;
	/**
	 * list of Upper Section Score Boxes
	 */
	private ArrayList<ScoreBox> UpperSection;
	/**
	 * combination of dice
	 */
	private Combination comb;
	/**
	 * Available rolls
	 */
	private int rolls;

	/**
	 * total score including upper section and lower section score boxes scores, and
	 * upper section bonus if any.
	 */
	private int TotalScore;

	/**
	 * Constructs a new MaxiYatzy game based on the given configuration. Initially
	 * the upper section and lower section lists are empty.
	 * 
	 * @param config configuration to use for this game
	 * @param rand   random number generator to use for rolling dice
	 */
	public MaxiYatzy(GameConfiguration config, Random rand)
	{
		con = config;
		ran = rand;
		comb = new Combination(con.getNumDice());
		rolls = con.getMaxRolls();
		LowerSection = new ArrayList<ScoreBox>();
		UpperSection = new ArrayList<ScoreBox>();
		TotalScore = 0;
	}

	/**
	 * Adds a score box to the lower section of this game.
	 * 
	 * @param box score box to add
	 */
	public void addLowerSectionScoreBox(ScoreBox box)
	{
		LowerSection.add(box);
	}

	/**
	 * Adds a score box to the upper section of this game.
	 * 
	 * @param box score box to add
	 */
	public void addUpperSectionScoreBox(ScoreBox box)
	{
		UpperSection.add(box);
	}

	/**
	 * Returns the list of score boxes in the upper section for this game.
	 * 
	 * @return list of score boxes in the upper section
	 */
	public ArrayList<ScoreBox> getUpperSection()
	{
		return UpperSection;
	}

	/**
	 * Returns the list of score boxes in the lower section for this game.
	 * 
	 * @return list of score boxes for the lower section
	 */
	public ArrayList<ScoreBox> getLowerSection()
	{
		return LowerSection;
	}

	/**
	 * Starts a new turn by creating a new Combination and updating the available
	 * rolls according to this game's configuration. If there is already a current
	 * Combination that is not complete, this method does nothing.
	 */
	public void startTurn()
	{
		if (comb.isComplete())
		{
			comb = new Combination(con.getNumDice());

			if (con.allowSavedRolls())
			{
				rolls += con.getMaxRolls();
			} else
			{
				rolls = con.getMaxRolls();
			}
		}

	}

	/**
	 * Returns the remaining number of rolls for this turn. The value returned is
	 * always zero if the current Combination is complete, even if the configuration
	 * allows unused rolls to be saved for future turns.
	 * 
	 * @return number of rolls
	 */
	public int getRemainingRolls()
	{
		if (!comb.isComplete())
		{
			return rolls;
		}
		return 0;
	}

	/**
	 * Rolls the available dice in the current Combination. That is, the available
	 * die values are replaced by randomly generated values in the range 1 through
	 * the given maximum (according to this game's configuration). If there are no
	 * more remaining rolls, all available dice in the current Combination are moved
	 * to the completed state.
	 */
	public void rollAvailableDice()
	{
		if (rolls > 0)
		{
			int[] newVals = new int[comb.getAvailableDice().length];
			for (int i = 0; i < newVals.length; i++)
			{
				newVals[i] = 1 + ran.nextInt(con.getMaxValue() + 1);
			}
			comb.updateAvailableDice(newVals);
			rolls--;
		} else
		{
			comb.chooseAll();
		}
	}

	/**
	 * Returns the current Combination (group of dice).
	 * 
	 * @return current group of dice
	 */
	public Combination getCurrentDice()
	{
		return comb;
	}

	/**
	 * Returns true if the game is over. The game is considered over when all score
	 * boxes are filled.
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean isOver()
	{
		if (sectionFilled(LowerSection) && sectionFilled(UpperSection))
		{
			return true;
		}

		return false;
	}

	/**
	 * @see Helper Method
	 * 
	 *      Returns true if all the score boxes in the given section is filled,
	 *      false otherwise
	 * 
	 * @return true if all the score boxes in the given list is filled, false
	 *         otherwise
	 */
	private boolean sectionFilled(ArrayList<ScoreBox> section)
	{
		for (int i = 0; i < section.size(); i++)
		{
			if (!(section.get(i).isFilled()))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the total score for the filled upper section score boxes (not
	 * including the upper section bonus, if any).
	 * 
	 * @return upper section total score
	 */
	public int getUpperSectionTotal()
	{
		int score = sectionScore(UpperSection);
		TotalScore += score;
		return score;
	}

	/**
	 * Returns the total score for the filled lower section score boxes.
	 * 
	 * @return lower section total score
	 */
	public int getLowerSectionTotal()
	{
		int score = sectionScore(LowerSection);
		TotalScore += score;
		return score;
	}

	/**
	 * @see Helper Method
	 * 
	 *      Returns the total score for the filled section score boxes.
	 * 
	 * @return given section total score
	 */
	private int sectionScore(ArrayList<ScoreBox> section)
	{
		int score = 0;
		for (int i = 0; i < section.size(); i++)
		{
			score += section.get(i).getScore();
		}
		return score;
	}

	/**
	 * Returns the total score for all categories including the upper section bonus,
	 * if any.
	 * 
	 * @return total score for all categories
	 */
	public int getTotalScore()
	{
		return TotalScore;
	}

	/**
	 * Returns the upper section bonus if one is currently being applied, otherwise
	 * returns zero.
	 * 
	 * @return upper section bonus if applicable, otherwise zero
	 */
	public int getUpperSectionBonus()
	{
		if (getUpperSectionTotal() >= con.getUpperSectionBonusCutoff())
		{
			int bonus = con.getUpperSectionBonus();
			TotalScore += bonus;

			return bonus;
		}
		return 0;
	}

}
