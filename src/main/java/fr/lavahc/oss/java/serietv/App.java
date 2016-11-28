package fr.lavahc.oss.java.serietv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import fr.lavahc.oss.java.serietv.comparators.AlphabeticComparator;
import fr.lavahc.oss.java.serietv.comparators.RateComparator;
import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;
import fr.lavahc.oss.java.serietv.finders.ActorFinder;
import fr.lavahc.oss.java.serietv.finders.Finder;
import fr.lavahc.oss.java.serietv.finders.GenreFinder;
import fr.lavahc.oss.java.serietv.finders.NameFinder;

public class App 
{
	
	public static void main( String[] args ) throws IllegalAccessException
    {
		App app = new App();
		TVShowsDoc showsDoc = app.loadFile("series.json");
		if(args.length < 1)
			throw new IllegalAccessException("Function not recognized. Please, use this syntax : [find-by|sort-by] [SUBFUNCTION] 'SUBFUNCTION ARG'...");
		switch (args[0]) {
		case "sort-by":
			Comparator<TVShow> comparator = null;
			switch (args[1]) {
			// sort-by rating
			case "rating":
				comparator = new RateComparator();
				break;
			//sort-by alphabet
			case "alphabet":
				comparator = new AlphabeticComparator();
				break;
			default:
				throw new IllegalArgumentException("Sort type not recognized. Please, use this syntax : sort-by [rating|alphabet]");
			}
			app.sort(showsDoc, comparator);
			break;
		case "find-by":
			if(args.length < 3)
				throw new IllegalArgumentException("Please, use this syntax : find-by [name|genre|actor] 'PATTERN'");
			Finder finder = null;
			switch (args[1]) {
			// find-by name
			case "name":
				finder = new NameFinder();
				break;
			// find-by genre
			case "genre":
				finder = new GenreFinder();
				break;
			// find-by genre
			case "actor":
				finder = new ActorFinder(); 
				break;
			default:
				throw new IllegalArgumentException("Find type not recognized. Please, use this syntax : find-by [name|genre|actor] 'PATTERN'");
			}
			app.find(showsDoc, args[2], finder);
			break;
		default:
			throw new IllegalAccessException("Function not recognized. Please, use this syntax : [find-by|sort-by] [SUBFUNCTION] 'SUBFUNCTION ARG'");
		}
    }
	
	private void sort(TVShowsDoc showsDoc, Comparator<TVShow> comparator) {
		Collections.sort(showsDoc.getTvShows(), comparator);
        System.out.println(showsDoc.getTvShows().size() + " shows.\n");
        for(int i = 0; i < showsDoc.getTvShows().size(); i++)
        	System.out.println((i+1)+". "+showsDoc.getTvShows().get(i));
	}
	
	private void find(TVShowsDoc showsDoc, String pattern, Finder finder) {
		List<TVShow> findedShows = finder.find(pattern, showsDoc);
		System.out.println(findedShows.size() + " shows finded.\n");
        for(int i = 0; i < findedShows.size(); i++)
        	System.out.println((i+1)+". "+findedShows.get(i));
	}
	
	private TVShowsDoc loadFile(String filename) {
        Gson gson = new Gson();
        JsonReader reader = null;
		try {
			reader = new JsonReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return gson.fromJson(reader, TVShowsDoc.class);
	}
}
