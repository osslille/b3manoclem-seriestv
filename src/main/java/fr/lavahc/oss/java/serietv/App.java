package fr.lavahc.oss.java.serietv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import fr.lavahc.oss.java.serietv.comparators.AlphabeticComparator;
import fr.lavahc.oss.java.serietv.comparators.RateComparator;
import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;

public class App 
{	
	public static void main( String[] args )
    {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
			reader = new JsonReader(new FileReader("/home/chavalc/Téléchargements/series.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        TVShowsDoc showsDoc = gson.fromJson(reader, TVShowsDoc.class);
        List<TVShow> mShows = Utils.researchShowByActor("brown", showsDoc.getActors(), showsDoc.getTvShows());
        System.out.println(mShows.size() + " result(s) found.");
        for(int i = 0; i < mShows.size(); i++)
        	System.out.println((i+1)+". "+mShows.get(i));
    }
}
