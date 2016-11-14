package fr.lavahc.oss.java.serietv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import fr.lavahc.oss.java.serietv.entities.TVShow;
import fr.lavahc.oss.java.serietv.entities.TVShowsDoc;

/**
 * Hello world!
 *
 */
public class App 
{	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
			reader = new JsonReader(new FileReader("/home/chavalc/Téléchargements/series.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        TVShowsDoc showsDoc = gson.fromJson(reader, TVShowsDoc.class);
        System.out.println(showsDoc.getTvShows().get(0).getId());
    }
}
