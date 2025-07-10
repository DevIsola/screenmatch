package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static br.com.alura.screenmatch.configuration.Keys.*;

public class ApiConsumerService {

    public String getDataByTitle(String title) {
        String query = DOMAIN_URL + OMDB_TITLE + titleFormater(title) + OMDB_KEY;
        return apiCall(query);
    }

    public String getSeasonDataByTitle(String title, int season) {
        String query = DOMAIN_URL + OMDB_TITLE + titleFormater(title) + OMDB_SEASON + season + OMDB_KEY;
        return apiCall(query);
    }

    private String titleFormater(String title) {
        return title.toLowerCase().replace(" ", "+");
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
