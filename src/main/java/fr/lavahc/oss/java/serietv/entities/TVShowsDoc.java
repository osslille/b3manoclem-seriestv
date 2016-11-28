package fr.lavahc.oss.java.serietv.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TVShowsDoc {
	@SerializedName("series")
	private List<TVShow> tvShows;
	
	@SerializedName("actors")
	private List<Actor> actors;

	public List<TVShow> getTvShows() {
		return tvShows;
	}

	public void setTvShows(List<TVShow> tvShows) {
		this.tvShows = tvShows;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
}
