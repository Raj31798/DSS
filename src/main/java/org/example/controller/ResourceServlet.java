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
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.example.model.Artist;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
//import com.skii.skiiproject.model.Audio;

//@WebServlet(name = "skiiers", value = "skiiers")
@WebServlet(name = "artists", value = "artists")
public class ResourceServlet extends HttpServlet {
    
	
	
	
	ConcurrentHashMap<String, Artist> artistDB1 = new ConcurrentHashMap<>();
	

	
	
	 {artistDB1.put("eminem", new Artist("eminem","Mockignbird","Slimshady","1","2010","542","2500"));
	 artistDB1.put("usher", new Artist("usher","ushery","gotham","2","2001","121","1200"));
	 artistDB1.put("akon", new Artist("akon","Smackthat","Broken","7","2013","56","1234"));
	 artistDB1.put("taylor", new Artist("taylor","Smackthat","Broken","6","2003","78","1456"));
	 artistDB1.put("billy-ellish", new Artist("billy-ellish","lomnely","jkey","5","1665","90","155"));
	 artistDB1.put("pheobe", new Artist("pheobe","smellycat","friends","3","2023","112","1232"));}
//	
	@SuppressWarnings("unused")
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String id = "kiran";
		id = request.getParameter("id");
		String prop = request.getParameter("Parametre");
//		
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
	    JsonElement element = gson.toJsonTree(artistDB1);
		if(artistDB1.containsKey(id)) {
		String y = prop;
		Artist x = artistDB1.get(id);
		
		
		
		
		Artist art = new Artist();
		art.setArtist_name(x.artist_name);
		art.setTrack_title(x.track_title);
		art.setAlbum_title(x.album_title);
		art.setTrack_number(x.track_number);
		art.setYear(x.year);
		art.setReviews(x.reviews);	
		art.setCopies(x.copies);
	   
	    String k = "default";
	    if (y.equals("track_title"))
	  		{
	  			k = art.track_title;
	  		}
	  		else if  (y.equals("album_title")) {
	  			k = art.album_title;
	  		}
	  		else if (y.equals("track_number")) {
	  			k = art.track_number;
	  		}
	  		else if (y.equals("year")) {
	  			k = art.year;
	  		}
	  		else if (y.equals("reviews")) {
	  			k = art.reviews;
	  		}
	  		else if (y.equals("copies")) {
	  			k = art.copies;
	  			
	  		};
	  		
	  		if (id.equals("all"))
	  		{
	  		out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(art)+id);}
	  		else 
	   
	    
        if (k.equals("default"))
        {
        	out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(art)+id);
        }
        else if (id.equals("allartists"))
        { out.println("GET RESPONSE IN JSON - all elements " + id+ element.toString());}
        
        else if (k != null)
        { out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(art.track_title+"   "+y+":"+k));};}
		
		else 
		{
			if (id.equals("allartists"))
	        { out.println("GET RESPONSE IN JSON - all elements " + id+ element.toString());}
			else 
			out.println("Id not found");
		}
        
  
        	
//        }
        out.flush();
        
		}
//		else { System.out.println("ID doesnt exist");}
		
//        out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(art));
//        
//        out.println("GET RESPONSE IN JSON - all elements " + element.toString());
     
         
	
	

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
