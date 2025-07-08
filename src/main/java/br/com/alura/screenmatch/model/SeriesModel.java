package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesModel(@JsonAlias("Title") String title,
                          @JsonAlias("Year") String releaseYear,
                          @JsonAlias("Genre") String genre,
                          @JsonAlias("totalSeasons") int totalSeasons,
                          @JsonAlias("imdbRating") double rating) {
}
