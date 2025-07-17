package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.dto.SeasonsDto;
import br.com.alura.screenmatch.model.dto.SeriesDto;
import br.com.alura.screenmatch.model.entity.SeriesEntity;
import br.com.alura.screenmatch.service.ApiConsumerService;
import br.com.alura.screenmatch.service.DataConverterService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final ApiConsumerService apiConsumerService = new ApiConsumerService();
    Scanner scanner = new Scanner(System.in);
    DataConverterService dataConverterService = new DataConverterService();
    private List<SeriesDto> seriesDtoList = new ArrayList<>();

    public void showMenu() {
        int selection = -1;

        System.out.println("Welcome to the ScreenMatch application!");

        while (selection != 0) {
            System.out.println("""
                    
                    *******************************************
                    
                    > Select one of the options below:
                    
                    > 1 - Search for a series
                    > 2 - Search for an episode
                    > 3 - Show searched series
                    
                    > 0 - Exit
                    """);
            selection = Integer.parseInt(scanner.nextLine());

            switch (selection) {
                case 1 -> searchSeries();
                case 2 -> searchEpisodes();
                case 3 -> showSearchedSeries();
                case 0 -> System.out.println("Exiting the application...");
                default -> System.out.println("Invalid option, please try again.");
            }
        }

    }

    private void searchSeries() {
        SeriesDto seriesDto = getSeriesData();
        seriesDtoList.add(seriesDto);
        System.out.println("> Series found!\n> " + seriesDto);
    }

    private void searchEpisodes() {
        SeriesDto seriesDto = getSeriesData();
        List<SeasonsDto> seasonsDto = new ArrayList<>();

        for(int season = 1; season <= seriesDto.totalSeasons(); season++) {
            String jsonData = apiConsumerService.getSeasonDataByTitle(seriesDto.title(), season);
            SeasonsDto seasonsData = dataConverterService.convertData(jsonData, SeasonsDto.class);
            seasonsDto.add(seasonsData);
        }

        seasonsDto.forEach(season -> season.episodes()
                .forEach(episode -> System.out.println(
                        "> S0" + season.seasonNumber()
                        + "E0" + episode.number()
                        + " | " + episode.title()
                        + " | Release: " + episode.releaseDate())));

    }

    private SeriesDto getSeriesData() {
        System.out.println("> Enter the title of the series:");
        String title = scanner.nextLine();
        String jsonData = apiConsumerService.getDataByTitle(title);
        return dataConverterService.convertData(jsonData, SeriesDto.class);

    }

    private void showSearchedSeries() {
        List<SeriesEntity> seriesEntities = new ArrayList<>();
        seriesEntities = seriesDtoList.stream()
                .map(SeriesEntity::new)
                .toList();

        seriesEntities.stream()
                .sorted(Comparator.comparing(SeriesEntity::getGenre))
                .forEach(System.out::println);
    }
}
