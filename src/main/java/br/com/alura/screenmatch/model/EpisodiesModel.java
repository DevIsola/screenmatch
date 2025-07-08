package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodiesModel(@JsonAlias("Title") String title,
                             @JsonAlias("Episode") int number,
                             @JsonAlias("imdbRating") String rating,
                             @JsonAlias("Released") String releaseDate) {
}
