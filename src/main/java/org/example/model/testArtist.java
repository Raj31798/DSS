package org.example.model;



public class testArtist {

	org.eclipse.jetty.client.HttpClient client;
	String type;
	public testArtist(org.eclipse.jetty.client.HttpClient httpClient, String type) {
		super();
		this.client = httpClient;
		this.type = type;
	}
	public org.eclipse.jetty.client.HttpClient getClient() {
		return client;
	}
	public void setClient(org.eclipse.jetty.client.HttpClient client) {
		this.client = client;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
