	package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.example.model.Artist;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
//import com.skii.skiiproject.model.Audio;

//@WebServlet(name = "skiiers", value = "skiiers")
@WebServlet(name = "artists", value = "artists")
public class ResourceServlet extends HttpServlet {
    
	
	/*
	 * ConcurrentHashMap is thread safe; 
	 */
	
	ConcurrentHashMap<String, Artist> artistDB1 = new ConcurrentHashMap<>();
	
	/*
	 * simply emulation of in memory database;  
	 */
	
//	ConcurrentHashMap< String, Artist> artistDB = new ConcurrentHashMap<>();
	
	
	 {artistDB1.put("eminem", new Artist("eminem","Mockignbird","Slimshady","1","2010","542","2500"));
	 artistDB1.put("ushe", new Artist("usher","ushery","gotham","2","2001","121","1200"));
	 artistDB1.put("akon", new Artist("akon","Smackthat","Broken","3","2003","250","2200"));}
//	 public void init() throws ServletException {
//		 artistDB.put("id_1", "raj");
//		 artistDB.put("id_2", "artist_name_2");
//		 artistDB.put("id_3", "artist_name_3");
//		 artistDB.put("id_4", "artist_name_4");
//		 artistDB.put("id_5", "artist_name_5");
//		 artistDB.put("id_6", "artist_name_6");
//		 
//	 }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String id = request.getParameter("id");
		Artist x = artistDB1.get(id);
		
		Artist art = new Artist();
		art.setArtist_name(x.artist_name);
		art.setTrack_title(x.track_title);
		art.setAlbum_title(x.album_title);
		art.setTrack_number(x.track_number);
		art.setYear(x.year);
		art.setReviews(x.reviews);
		art.setCopies(x.copies);
	    Gson gson = new Gson();
	    JsonElement element = gson.toJsonTree(artistDB1);
	    
	    /*
	     * response in normal string message;
	     */
		//response.getOutputStream().println("Artist id is " + id +" name is " + name);
    
		
		/*
		 * response in json with as a data model
		 */
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(art));
        
        out.println("GET RESPONSE IN JSON - all elements " + element.toString());
     
        out.flush();   
	
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
       
    	String artist_name = request.getParameter("artist_name");
    	String track_title = request.getParameter("track_title");
    	String album_title = request.getParameter("album_title");
    	String track_number = request.getParameter("track_number");
    	String year = request.getParameter("year");
    	String reviews = request.getParameter("reviews");
    	String copies = request.getParameter("copies");
    	

    	Artist y = new Artist(artist_name,track_title,album_title,track_number,year,reviews,copies);
    	
        
        
        artistDB1.put(y.artist_name,y);
        response.setStatus(200);
    	
    	response.getOutputStream().println("POST RESPONSE: Artist " + y.artist_name + " is added to the database.");
    }
}
