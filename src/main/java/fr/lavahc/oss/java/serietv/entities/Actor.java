package fr.lavahc.oss.java.serietv.entities;

import com.google.gson.annotations.SerializedName;

public class Actor {
	@SerializedName("id")
	private long id;
	
	@SerializedName("seriesId")
	private long tvShowId;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("role")
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTvShowId() {
		return tvShowId;
	}

	public void setTvShowId(long tvShowId) {
		this.tvShowId = tvShowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
