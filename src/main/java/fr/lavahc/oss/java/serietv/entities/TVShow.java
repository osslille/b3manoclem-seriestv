package fr.lavahc.oss.java.serietv.entities;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class TVShow {
	
	@SerializedName("id")
	private long id;
	
	@SerializedName("seriesName")
	private String name;
	
	@SerializedName("genre")
	private ArrayList<String> genre;
	
	@SerializedName("overview")
	private String overview;
	
	@SerializedName("siteRating")
	private double rate;
	
	@SerializedName("siteRatingCount")
	private int rateCount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getRateCount() {
		return rateCount;
	}
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
	
	public String toString() {
		return "["+this.id+"]\t"+this.name;
	}
	
}