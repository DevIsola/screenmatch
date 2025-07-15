package br.com.alura.screenmatch.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesDto(@JsonAlias("Title") String title,
                        @JsonAlias("totalSeasons") int totalSeasons,
                        @JsonAlias("imdbRating") double rating) {
}
