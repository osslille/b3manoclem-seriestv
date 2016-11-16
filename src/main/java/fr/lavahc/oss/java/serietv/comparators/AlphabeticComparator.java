package fr.lavahc.oss.java.serietv.comparators;

import java.util.Comparator;

import fr.lavahc.oss.java.serietv.entities.TVShow;

public class AlphabeticComparator implements Comparator<TVShow> {

	public int compare(TVShow o1, TVShow o2) {
		// TODO Auto-generated method stub
		String s01 = o1.getName().toUpperCase().trim();
		String s02 = o2.getName().toUpperCase().trim();
		
		
		
		for(int i = 0; i < s01.length(); i++){
			if (s01.charAt(i) < s02.charAt(i))
				return -1;	
			else if (s01.charAt(i) > s02.charAt(i))
				return 1;
		}
		return 0;
	}

	
	
}
