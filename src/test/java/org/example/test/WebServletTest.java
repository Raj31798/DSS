package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Random;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.model.testArtist;


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
class newtest extends WebServletTest implements Runnable{
	public newtest(newtest newtest) {
		// TODO Auto-generated constructor stub
	}

	public newtest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		try {
			System.out.println("hey22");
//			testArtistsPost();
			threadtest();
			
			
//			threadtest();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        	}}


	

class WebServletTest {
	

//@Test

//void testing() throws Exception
//{
//	testArtistsGet();
//	Runnable r = new newtest();
////	Runnable k = new newgettest();
//	Thread task = new Thread(r);
//	task.start();
////	Thread mytask = new Thread(r);
////	mytask.start();
////	System.out.println("hi");
////	testArtistsGet();
//	try {
//        task.join();
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//
//
//	
//	
//}

	
		
//	@Test	
	void starting() throws Exception
	{
		
		final int[] client_total = { 10,50,100 };
		
		ArrayList<newtest> addclient = new ArrayList<newtest>();
		for (int k=0;k<1;k++)
		{
			
			for (int i=0; i <client_total[k]  ; i++)
		{
//			testArtistsGet();
		
			newtest thread1 = new newtest();
			addclient.add(thread1);
	     }
		for (int i=0; i < 2 ; i++)
		{
//			System.out.println("hi");
			Runnable r = new newtest(addclient.get(i));
			Thread task = new Thread(r);
			task.start();
			try {
		        task.join();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}}
	}
//	
 
	

	 static	void threadtest () throws Exception
	
	{
	
	
//		testArtistsPost();
//		testArtistsGet();
//		
	
		 final int[] client_total = { 10,50,100 };
		 final int[] client_ratio = { 2,5,10};
		 
		 
		 for (int x =0;x<1;x++)
		 {
			 for (int j = 0; j< 1 ; j++)
			 {
//				 System.out.println("hii");
				 testArtistsPost();
				  
				 for (int k=0; k< client_ratio[x]; k++) 
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

        ContentResponse res = client.GET("http://localhost:8080/coen6317/HelloServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	
	//@Test
	void testBlockingServletGet() throws Exception {
		
		HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://localhost:8080/coen6317/BlockingServlet");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
		
	}
	
	//@Test
	void testAsyncServletGet() throws Exception {
		
		String url = "http://localhost:8080/coen6317/longtask";
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
	
	synchronized  void testArtistsGet()  throws Exception {
		  long startTime = System.currentTimeMillis();
		
		System.out.println("h202i");
		
		
		int min = 0;
        int max = 2;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        
        String[] key  = {"eminem", "usher", "akon"};
        
		String url = "http://localhost:8080/coen6317/artists";
		HttpClient client = new HttpClient();
        client.start();

        Request request = client.newRequest(url);
        
        request.param("id",key[randomNumber]);
        ContentResponse response = request.send();
   

		assertThat(response.getStatus(), equalTo(200));
		
		String responseContent = IOUtils.toString(response.getContent());
		
		 System.out.println(responseContent);
		 long endTime = System.currentTimeMillis();
		 long requestTimes;
		requestTimes = endTime - startTime;
		System.out.println(requestTimes);
		 client.stop();
		
	}
	
	@SuppressWarnings("deprecation")
//	@Test
	static

	
	
	
	
	synchronized void testArtistsPost() throws Exception {
		
		String url = "http://localhost:8080/coen6317/artists";
		HttpClient client = new HttpClient();
        client.start();
//        System.out.println(url);
        
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






