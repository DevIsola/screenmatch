package br.com.alura.screenmatch.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonsDto(@JsonAlias("Season") int seasonNumber,
                         @JsonAlias("Episodes") List<EpisodesDto> episodes) {
}
