package br.com.alura.imdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApi {

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/<apiKey>"))
				.build();
		
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
		
	}

}
