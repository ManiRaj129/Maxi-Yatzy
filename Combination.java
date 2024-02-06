package hw4;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Group of dice for a dice game such as MaxiYatzy in which multiple rolls per
 * turn are allowed. The dice are partitioned into "available" dice and
 * "complete" dice. The available dice can be re-rolled (that is, they can get
 * new values via the <code>update</code> method). The client can select which
 * dice to move from available to complete. Once all dice are complete, as
 * determined by the <code>isComplete()</code> method, the
 * <code>getAvailable()</code> method always returns an empty array, and the
 * state of the combination can no longer be modified.
 * 
 * @author REJINTHALA MANI RAJ
 */
public class Combination
{
	/**
	 * the list of die values that are in available set.
	 */
	private ArrayList<Integer> avaDice;
	/**
	 * the list of die values that are in completed set.
	 */
	private ArrayList<Integer> comDice;
	/**
	 * Number of dices
	 */
	private int nDice;

	/**
	 * Constructs a new Combination in which each die initially has the (invalid)
	 * value zero and all dice are available. In normal usage, a client would
	 * replace the available die values with randomly generated numbers in an
	 * appropriate range, to simulate rolling the dice.
	 * 
	 * @param numDice number of dice in this group
	 */
	public Combination(int numDice)
	{
		nDice = numDice;
		avaDice = new ArrayList<Integer>();
		for(int i=0;i<numDice;i++)
		{
			avaDice.add(0);
		}
		comDice = new ArrayList<Integer>();
	}

	/**
	 * Constructs a new Combination in which each die initially has the value given
	 * by the <code>initialValues</code> array. All dice are initially available.
	 * The number of dice is determined by the size of the given array.
	 * <p>
	 * This version of the constructor is primarily intended for testing.
	 * 
	 * @param initialValues initial values for the dice
	 */
	public Combination(int[] initialValues)
	{
		nDice = initialValues.length;
		avaDice = new ArrayList<Integer>();
		for (int i = 0; i < nDice; i++)
		{
			avaDice.add(initialValues[i]);
		}
		comDice = new ArrayList<Integer>();

	}

	/**
	 * Returns the number of dice in this group.
	 * 
	 * @return number of dice in this group
	 */
	public int getNumDice()
	{
		return nDice;
	}

	/**
	 * Selects a die value to be moved from the available dice to the completed
	 * dice. Has no effect if the given value is not among the values in the
	 * available dice.
	 * 
	 * @param value die value to be moved
	 */
	public void choose(int value)
	{
		if (avaDice.contains(value))
		{
			avaDice.remove(Integer.valueOf(value));
			comDice.add(value);
		}

	}

	/**
	 * Causes all die values be moved from the available dice to the completed dice.
	 * After this method is called, <code>getAvailable</code> always returns an
	 * empty array, and <code>isComplete</code> returns true.
	 */
	public void chooseAll()
	{
		comDice.addAll(avaDice);
		avaDice.clear();
	}

	/**
	 * Determines whether there are any dice available to be rolled in this
	 * combination.
	 * 
	 * @return true if there are no available dice, false otherwise
	 */
	public boolean isComplete()
	{
		if (avaDice.size() == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Returns the values of the dice that are not available to be re-rolled, in
	 * ascending order.
	 * 
	 * @return values of the dice that are not available to be re-rolled
	 */
	public int[] getCompletedDice()
	{
		// length of completed dice set
		int lOC = comDice.size();
		// array type of completed set
		int[] cDice = new int[lOC];
		Collections.sort(comDice);

		for (int k = 0; k < lOC; k++)
		{
			cDice[k] = comDice.get(k);
		}
		return cDice;
	}

	/**
	 * Returns the values of the dice that are available to be re-rolled, in
	 * ascending order.
	 * 
	 * @return dice that are available to be re-rolled
	 */
	public int[] getAvailableDice()
	{
		// length of Available dice set
		int lOA = avaDice.size();
		// array type of Available set
		int[] aDice = new int[lOA];
		Collections.sort(avaDice);

		for (int k = 0; k < lOA; k++)
		{
			aDice[k] = avaDice.get(k);
		}
		return aDice;
	}

	/**
	 * Returns all die values in this combination, in ascending order.
	 * 
	 * @return all die values in this group
	 */
	public int[] getAll()
	{
		// total die values list
		ArrayList<Integer> tDice = new ArrayList<Integer>();
		tDice.addAll(avaDice);
		tDice.addAll(comDice);
		Collections.sort(tDice);

		// array type of total set
		int[] totDice = new int[nDice];

		for (int k = 0; k < nDice; k++)
		{
			totDice[k] = tDice.get(k);
		}

		return totDice;
	}

	/**
	 * Replaces the available dice with the given values. Throws an
	 * IllegalStateException if the length of the given array does not match the
	 * number of available dice in this combination.
	 * 
	 * @throws IllegalStateException if the given array has the wrong length
	 * 
	 * @param newValues array of new die values for available dice.
	 */
	public void updateAvailableDice(int[] newValues)
	{
		if (newValues.length != avaDice.size())
		{
			throw new IllegalStateException("Number of new die values are not equal to the available dice");

		} else
		{
			avaDice.clear();
			for (int k : newValues)
			{
				avaDice.add(k);
			}
		}
	}

	/**
	 * Returns a string representation of the die values in this combination, in the
	 * form <em>available</em>(<em>complete</em>). (For example, if there are two
	 * completed dice with values 2 and 4, and there are 3 available dice with
	 * values 1, 1, and 6, then the method returns the string
	 * 
	 * <pre>
	 * 1 1 6 (2 4)
	 * </pre>
	 * 
	 * @return string representation of the available and completed dice, with the
	 *         completed values in parentheses
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		int[] avail = getAvailableDice();
		int[] completed = getCompletedDice();
		if (avail.length > 0)
		{
			for (int value : avail)
			{
				sb.append(value + " ");
			}
		}
		sb.append("(");
		if (completed.length > 0)
		{
			// use an index so we can add the first one without a leading space
			sb.append(completed[0]);
			for (int i = 1; i < completed.length; ++i)
			{
				sb.append(" " + completed[i]);
			}
		}
		sb.append(")");
		return sb.toString();
	}

}
