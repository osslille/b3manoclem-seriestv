package fr.lavahc.oss.java.serietv.finders;

import java.util.ArrayList;
import java.util.List;

import fr.lavahc.oss.java.serietv.entities.Actor;
import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;

public class ActorFinder implements Finder {

	@Override
	public List<TVShow> find(String pattern, TVShowsDoc showsDoc) {
		pattern = pattern.toLowerCase();
		List<Actor> matchingActors = new ArrayList<>();
		List<TVShow> matchingShows = new ArrayList<>();
		for(Actor actor : showsDoc.getActors())
			if(actor.getName().toLowerCase().contains(pattern))
				matchingActors.add(actor);
		for(TVShow show : showsDoc.getTvShows())
			for(Actor actor : matchingActors)
				if(actor.getTvShowId() == show.getId() && !matchingShows.contains(show))
					matchingShows.add(show);
		return matchingShows;
	}

}
