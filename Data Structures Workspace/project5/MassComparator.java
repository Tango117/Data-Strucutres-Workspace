package project5;

import java.util.Comparator;

/**
 * This class gives the Comparator for byMass
 *
 * @author Brendan Tang
 * @version 12/6/2020
 */

public class MassComparator implements Comparator<Meteorite>{

	@Override
	public int compare(Meteorite o1, Meteorite o2) {
		if(o1.getMass() == o2.getMass())
			return o1.compareTo(o2);
		else
			return o1.getMass() - o2.getMass();
	}

}
