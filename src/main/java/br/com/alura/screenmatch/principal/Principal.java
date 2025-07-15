package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.entity.EpisodesEntity;
import br.com.alura.screenmatch.model.dto.SeasonsDto;
import br.com.alura.screenmatch.model.dto.SeriesDto;
import br.com.alura.screenmatch.service.ApiConsumerService;
import br.com.alura.screenmatch.service.DataConverterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private final ApiConsumerService apiConsumerService = new ApiConsumerService();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("> Welcome to ScreenMatch!");
        System.out.println("> Type the title of the movie or series you want to search for: ");
        String title = scanner.nextLine();
        DataConverterService dataConverterService = new DataConverterService();

        try {
            String jsonData = apiConsumerService.getDataByTitle(title);
            SeriesDto series = dataConverterService.convertData(jsonData, SeriesDto.class);
            List<SeasonsDto> seasons = new ArrayList<>();
            for (int season = 1; season <= series.totalSeasons(); season++) {
                jsonData = apiConsumerService.getSeasonDataByTitle(title, season);
                SeasonsDto seasonData = dataConverterService.convertData(jsonData, SeasonsDto.class);
                seasons.add(seasonData);
            }

            seasons.forEach(season -> season.episodes()
                    .forEach(episode -> System.out.println("> " + episode.title()
                            + " | " + episode.releaseDate())));

            List<EpisodesEntity> episodesEntity = seasons.stream()
                    .flatMap(s -> s.episodes().stream()
                            .map(e -> new EpisodesEntity(s.seasonNumber(), e)))
                            .collect(Collectors.toList());

            episodesEntity.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
