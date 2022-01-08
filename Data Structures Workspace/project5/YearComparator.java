package project5;

import java.util.Comparator;

/**
 * This class gives the Comparator for byYear
 *
 * @author Brendan Tang
 * @version 12/6/2020
 */

public class YearComparator implements Comparator<Meteorite>{

	@Override
	public int compare(Meteorite o1, Meteorite o2) {
		if(o1.getYear() == o2.getYear())
			return o1.compareTo(o2);
		else
			return o1.getYear() - o2.getYear();
	}

}
