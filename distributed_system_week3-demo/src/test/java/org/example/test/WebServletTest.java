package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Random;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.example.model.Artist;


class WebServletTest {
	
	
	
	public static void main(String[] args) throws Exception {
   
		
		 final int[] client_total = { 10,50,100 };
		 final int[] client_ratio = { 2,5,10 };
		 
		 for (int i=0; i < client_total[i] ; i++)
		 {
			 for (int j = 0; j< client_total [i] ; j++)
			 {
				 testArtistsPost();
				 for (int k=0; k< client_ratio[k] ; k++) 
				 {
					 testArtistsGet();
					 
				 }
			 }
		 }
	}
		
		
	
		
		
		
		
		
		
//	}

	//@Test
	void testHelloServletGet() throws Exception {
		
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://localhost:9090/coen6317/HelloServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	
	//@Test
	void testBlockingServletGet() throws Exception {
		
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://localhost:9090/coen6317/BlockingServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	//@Test
	void testAsyncServletGet() throws Exception {
		
		String url = "http://localhost:9090/coen6317/longtask";
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse response = client.GET(url);

		assertThat(response.getStatus(), equalTo(200));
		
		String responseContent = IOUtils.toString(response.getContent());
		
		 System.out.println(responseContent);
		//assertThat(responseContent, equalTo( "This is some heavy resource that will be served in an async way"));
		
	}

	
	@Test
	static
	void testArtistsGet() throws Exception {
		
		
		int min = 0;
        int max = 2;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        
        String[] key  = {"eminem", "ushe", "akon"};
        
		String url = "http://localhost:9090/coen6317/artists";
		HttpClient client = new HttpClient();
        client.start();

        Request request = client.newRequest(url);
        
        request.param("id",key[randomNumber]);
        ContentResponse response = request.send();
   

		assertThat(response.getStatus(), equalTo(200));
		
		String responseContent = IOUtils.toString(response.getContent());
		
		 System.out.println(responseContent);
		client.stop();
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	static
	void testArtistsPost() throws Exception {
		
		String url = "http://localhost:9090/coen6317/artists";
		HttpClient client = new HttpClient();
        client.start();
        
        Request request = client.POST(url);
        
        
        request.param("artist_name","jayr");
        request.param("track_title","summers");
        request.param("album_title","smitherins");
        request.param("track_number","24");
        request.param("year","2021");
        request.param("reviews","56");
        request.param("copies","89");
        
  
        
        ContentResponse response = request.send();
		String res = new String(response.getContent());
		System.out.println(res);
		client.stop();
	}
}






