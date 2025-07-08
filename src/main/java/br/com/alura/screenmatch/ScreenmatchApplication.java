package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.EpisodiesModel;
import br.com.alura.screenmatch.model.SeasonModel;
import br.com.alura.screenmatch.model.SeriesModel;
import br.com.alura.screenmatch.service.ApiConsumerService;
import br.com.alura.screenmatch.service.DataConverterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.screenmatch.configuration.Keys.OMDB_KEY;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConsumerService apiConsumerService = new ApiConsumerService();
		String json = apiConsumerService.getData("https://www.omdbapi.com/?t=virgin+river" + OMDB_KEY);
		DataConverterService dataConverterService = new DataConverterService();
		try {
			SeriesModel series = dataConverterService.convertData(json, SeriesModel.class);
			json = apiConsumerService.getData("https://www.omdbapi.com/?t=virgin+river&Season=1&Episode=1"
					+ OMDB_KEY);
			EpisodiesModel episodes = dataConverterService.convertData(json, EpisodiesModel.class);
			List<SeasonModel> seasons = new ArrayList<>();

			for (int season = 1; season <= series.totalSeasons(); season++) {
				json = apiConsumerService.getData("https://www.omdbapi.com/?t=virgin+river&Season=" + season + OMDB_KEY);
				SeasonModel seasonData = dataConverterService.convertData(json, SeasonModel.class);
				seasons.add(seasonData);
			}

			System.out.println("Serie: " + series);
			seasons.forEach(System.out::println);
			System.out.println("Episode: " + episodes);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
