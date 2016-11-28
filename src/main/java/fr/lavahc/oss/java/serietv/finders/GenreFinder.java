package fr.lavahc.oss.java.serietv.finders;

import java.util.ArrayList;
import java.util.List;

import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;

public class GenreFinder implements Finder {

	@Override
	public List<TVShow> find(String pattern, TVShowsDoc showsDoc) {
		pattern = pattern.toLowerCase();
		List<TVShow> matchingShows = new ArrayList<>();
		for(TVShow show : showsDoc.getTvShows())
			for(String genre : show.getGenre())
				if(genre.toLowerCase().contains(pattern))
					matchingShows.add(show);
		return matchingShows;
	}

}
