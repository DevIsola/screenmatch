package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.EpisodiesModel;
import br.com.alura.screenmatch.model.SeasonModel;
import br.com.alura.screenmatch.model.SeriesModel;
import br.com.alura.screenmatch.service.ApiConsumerService;
import br.com.alura.screenmatch.service.DataConverterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.alura.screenmatch.configuration.Keys.*;

public class Principal {

    Scanner scanner = new Scanner(System.in);
    private final ApiConsumerService apiConsumerService = new ApiConsumerService();

    public void showMenu(){
        System.out.println("> Welcome to ScreenMatch!");
        System.out.println("> Type the title of the movie or series you want to search for: ");
        String title = scanner.nextLine();
        DataConverterService dataConverterService = new DataConverterService();

        try {
            String jsonData = apiConsumerService.getDataByTitle(title);
            SeriesModel series = dataConverterService.convertData(jsonData, SeriesModel.class);
            List<SeasonModel> seasons = new ArrayList<>();
            for (int season = 1; season <= series.totalSeasons(); season++) {
                jsonData = apiConsumerService.getSeasonDataByTitle(title, season);
                SeasonModel seasonData = dataConverterService.convertData(jsonData, SeasonModel.class);
                seasons.add(seasonData);
            }

            seasons.forEach(season -> season.episodes()
                    .forEach(episode -> System.out.println("> " + episode.title())));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
