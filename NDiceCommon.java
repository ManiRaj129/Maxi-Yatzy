package hw4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class has implementations to check whether a given array has certain
 * given number or more of identical value dice.
 * 
 * @author REJINTHALA MANI RAJ
 */
public abstract class NDiceCommon extends AllSumScore
{
	// list of all dice values
	private ArrayList<Integer> values;

	/**
	 * Constructs a ScoreBox with the given display name.
	 * 
	 * @param displayName name of a score box
	 */
	protected NDiceCommon(String displayName)
	{
		super(displayName);
		values = new ArrayList<Integer>();
	}

	/**
	 * copies the array values in to array list. In addition sorts the list.
	 * 
	 * @param arr array of the dice values
	 */
	protected void copy(int[] arr)
	{
		values.clear();

		for (int k : arr)
		{
			values.add(k);
		}
	}

	/**
	 * Return the array list type of dice values.
	 * 
	 * @return Array List of dice values
	 */
	protected ArrayList<Integer> getList()
	{
		return values;
	}

	/**
	 * returns a list with a single die value(i.e.,common value of N dice) if there
	 * are any N dice or more that share common value, if not returns the empty set.
	 * 
	 * @param n size of the identical set of dice values
	 * 
	 * @return returns a list with a single die value or empty list
	 */
	protected ArrayList<Integer> NDice(int n)
	{

		// val list holds a single die value of the given array
		ArrayList<Integer> val = new ArrayList<Integer>();

		int i = 0;

		// temporary list holds a subset with similar die values in given array
		ArrayList<Integer> temp = new ArrayList<Integer>();

		while (i < values.size())
		{
			val.add(values.get(i));
			temp.addAll(values);
			temp.retainAll(val);
			if (temp.size() >= n)
			{
				return val;

			}
			i = i + temp.size();
			temp.clear();
			val.clear();

		}

		return val;
	}

	/**
	 * Removes the dice with value listed in the 'val' list. Where val has only one
	 * die value.
	 * 
	 * @param val die value
	 */
	protected void remove(ArrayList<Integer> val)
	{
		values.removeAll(val);
	}

}
