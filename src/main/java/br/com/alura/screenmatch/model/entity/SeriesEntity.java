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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public GenresEnum getGenre() {
        return genre;
    }

    public void setGenre(GenresEnum genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
               ", totalSeasons=" + totalSeasons +
               ", rating=" + rating +
               ", genre=" + genre +
               ", actors='" + actors + '\'' +
               ", plot='" + plot + '\'';
    }

}
