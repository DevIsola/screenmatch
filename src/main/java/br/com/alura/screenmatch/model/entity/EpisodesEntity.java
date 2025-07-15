package br.com.alura.screenmatch.model.entity;

import br.com.alura.screenmatch.model.dto.EpisodesDto;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class EpisodesEntity {

    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double rating;
    private LocalDate releaseDate;

    public EpisodesEntity(int season, EpisodesDto episodiesData) {
        this.season = season;
        this.title = episodiesData.title();
        this.episodeNumber = episodiesData.number();

        try {
            this.rating = Double.valueOf(episodiesData.rating());
        } catch (NumberFormatException e) {
            this.rating = 0.0;
        }

        try {
            this.releaseDate = LocalDate.parse(episodiesData.releaseDate());
        } catch (DateTimeParseException e) {
            this.releaseDate = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "> season: " + season +
                " | title: '" + title + '\'' +
                " | number: " + episodeNumber +
                " | rating: " + rating +
                " | releaseDate: " + releaseDate;
    }
}
