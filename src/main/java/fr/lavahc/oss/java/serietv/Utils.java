package fr.lavahc.oss.java.serietv;

import java.util.ArrayList;
import java.util.List;

import fr.lavahc.oss.java.serietv.entities.Actor;
import fr.lavahc.oss.java.serietv.entities.TVShow;

public class Utils {
	
	public static List<TVShow> researchShowByName(String str, List<TVShow> shows) {
		String pattern = str.toLowerCase();
		List<TVShow> matchingShows = new ArrayList<>();
		for(TVShow show : shows)
			if(show.getName().toLowerCase().contains(pattern))
				matchingShows.add(show);
		return matchingShows;
	}
	
	public static List<TVShow> researchShowByGenre(String str, List<TVShow> shows) {
		String pattern = str.toLowerCase();
		List<TVShow> matchingShows = new ArrayList<>();
		for(TVShow show : shows)
			for(String genre : show.getGenre())
				if(genre.toLowerCase().contains(pattern))
					matchingShows.add(show);
		return matchingShows;
	}
	
	public static List<TVShow> researchShowByActor(String str, List<Actor> actors, List<TVShow> shows) {
		String pattern = str.toLowerCase();
		List<Actor> matchingActors = new ArrayList<>();
		List<TVShow> matchingShows = new ArrayList<>();
		for(Actor actor : actors)
			if(actor.getName().toLowerCase().contains(pattern))
				matchingActors.add(actor);
		for(TVShow show : shows)
			for(Actor actor : matchingActors)
				if(actor.getTvShowId() == show.getId())
					matchingShows.add(show);
		return matchingShows;
	}
}
