package br.com.alura.screenmatch.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodesDto(@JsonAlias("Title") String title,
                          @JsonAlias("Episode") int number,
                          @JsonAlias("imdbRating") String rating,
                          @JsonAlias("Released") String releaseDate) {
}
