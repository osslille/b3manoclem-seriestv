package fr.lavahc.oss.java.serietv.comparators;

import java.util.Comparator;

import fr.lavahc.oss.java.serietv.entities.TVShow;

public class RateComparator implements Comparator<TVShow> {

	public int compare(TVShow o1, TVShow o2) {
		// TODO Auto-generated method stub
		int ret;
		if(o1.getRate() < o2.getRate())
			ret = 1;
		else if(o1.getRate() == o2.getRate())
			ret = 0;
		else
			ret = -1;
		return ret;
	}
}
