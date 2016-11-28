package fr.lavahc.oss.java.serietv.finders;

import java.util.List;

import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;

public interface Finder {
	public List<TVShow> find(String pattern, TVShowsDoc showsDoc);
}
