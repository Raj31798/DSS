package org.example.model;

public class Artist {
	public String artist_name;
	public String track_title;
	public String album_title;
	public String track_number;
	public String year;
	public String reviews;
	public String copies;
	
	
	
	public Artist(String artist_name, String track_title, String album_title, String track_number, String year,
			String reviews, String copies) {
		super();
		this.artist_name = artist_name;
		this.track_title = track_title;
		this.album_title = album_title;
		this.track_number = track_number;
		this.year = year;
		this.reviews = reviews;
		this.copies = copies;
	}
	
	
	public Artist() {
		// TODO Auto-generated constructor stub
	}


	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getTrack_title() {
		return track_title;
	}
	public void setTrack_title(String track_title) {
		this.track_title = track_title;
	}
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
	public String getTrack_number() {
		return track_number;
	}
	public void setTrack_number(String track_number) {
		this.track_number = track_number;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
	
	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	private String name;
	
	
}
