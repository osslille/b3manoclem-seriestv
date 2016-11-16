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
        showsDoc.getTvShows().sort(new AlphabeticComparator());
        for(int i = 0; i < showsDoc.getTvShows().size(); i++) {
        	System.out.println((i+1)+". "+showsDoc.getTvShows().get(i));
        }
        String test = "aa";
        String test2 = "bb";
        System.out.println(test.charAt(0));
    }
}
