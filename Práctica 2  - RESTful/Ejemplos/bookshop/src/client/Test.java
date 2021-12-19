package client;


import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import practica2Bookshop.model.Model;


public class Test {
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(getBaseURI());
		
		System.out.println("Respuesta: ");
		System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class));
	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/practica2Bookshop").build();
	}
}
