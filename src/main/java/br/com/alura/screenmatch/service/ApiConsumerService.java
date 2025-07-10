package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static br.com.alura.screenmatch.configuration.Keys.*;

public class ApiConsumerService {

    public String getData(String title) {
        title = title.toLowerCase().replace(" ", "+");
        String query = DOMAIN_URL + title + OMDB_KEY;
        return apiCall(query);
    }

    private String apiCall(String query) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}
