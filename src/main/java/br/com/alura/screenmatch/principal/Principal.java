package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.service.ApiConsumerService;

import java.util.Scanner;

import static br.com.alura.screenmatch.configuration.Keys.*;

public class Principal {

    Scanner scanner = new Scanner(System.in);
    private final ApiConsumerService apiConsumerService = new ApiConsumerService();

    public void showMenu() {
        System.out.println("> Welcome to ScreenMatch!");
        System.out.println("> Type the title of the movie or series you want to search for: ");
        String title = scanner.nextLine();
        title = "?t=" + title.toLowerCase().replace(" ", "+");
        String query = DOMAIN_URL + title + OMDB_KEY;
        String json = apiConsumerService.getData(query);

    }

}
