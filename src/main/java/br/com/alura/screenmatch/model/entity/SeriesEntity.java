package br.com.alura.screenmatch.model.entity;

import br.com.alura.screenmatch.model.dto.SeriesDto;
import br.com.alura.screenmatch.model.enums.GenresEnum;

import java.util.OptionalDouble;

public class SeriesEntity {

    private String title;
    private Integer totalSeasons;
    private Double rating;
    private GenresEnum genre;
    private String actors;
    private String plot;

    public SeriesEntity(SeriesDto seriesDto) {
        this.title = seriesDto.title();
        this.totalSeasons = seriesDto.totalSeasons();
        this.rating = OptionalDouble.of(seriesDto.rating()).orElse(0.0);
        this.genre = GenresEnum.fromString(seriesDto.genre().split(",")[0].trim().toLowerCase());
        this.actors = seriesDto.actors();
        this.plot = seriesDto.plot();
    }
}



