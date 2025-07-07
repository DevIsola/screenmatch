package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SeriesDataModel;
import br.com.alura.screenmatch.service.ApiConsumerService;
import br.com.alura.screenmatch.service.DataConverterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static br.com.alura.screenmatch.configuration.Keys.omdbKey;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConsumerService apiConsumerService = new ApiConsumerService();
		String json = apiConsumerService.getData("https://www.omdbapi.com/?t=virgin+river&apikey=" + omdbKey);
		DataConverterService dataConverterService = new DataConverterService();
		try {
			SeriesDataModel series = dataConverterService.getData(json, SeriesDataModel.class);
			System.out.println(series);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
